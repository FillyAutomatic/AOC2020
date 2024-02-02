import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.math.*;

public class S2 {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("src/s.in"))));

        HashMap<Integer, ArrayList<String>> rules = new HashMap<Integer, ArrayList<String>>();
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            if (s.isEmpty())
                break;
            int ind = Integer.parseInt(s.split(":")[0]);
            rules.put(ind, new ArrayList<>());
            s = s.substring(s.indexOf(':') + 2);
            if (s.contains("\"")) {
                rules.get(ind).add("" + s.charAt(1));
                continue;
            }
            for (String s2 : s.split("\\|")) {
                if (s2.startsWith(" "))
                    s2 = s2.substring(1);
                if (s2.endsWith(" "))
                    s2 = s2.substring(0, s2.length() - 1);
                rules.get(ind).add(s2);
            }
        }
        rules.get(8).add("42 8");
        rules.get(11).add("42 11 31");
        int ans = 0;
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            boolean[][][] dp = new boolean[s.length()][s.length()][200];
            for (int i = 0; i < s.length(); ++i) {
                for (int y = 0; y < 5; ++y) {
                    for (int key : rules.keySet()) {
                        if (rules.get(key).get(0).charAt(0) > '9') {
                            dp[i][i][key] = s.charAt(i) == rules.get(key).get(0).charAt(0);
                            continue;
                        }
                        for (String rule : rules.get(key)) {
                            String[] rp = rule.split(" ");
                            if (rp.length == 1) {
                                dp[i][i][key] |= dp[i][i][Integer.parseInt(rp[0])];
                            }
                        }
                    }
                }
            }
            for (int z = 1; z < s.length(); ++z) {
                for (int i = 0; i + z < s.length(); ++i) {
                    int j = i + z;
                    for (int y = 0; y < 5; ++y) {
                        for (int key : rules.keySet()) {
                            if (rules.get(key).get(0).charAt(0) > '9') {
                                continue;
                            }
                            for (String rule : rules.get(key)) {
                                String[] rp = rule.split(" ");
                                if (rp.length == 1) {
                                    dp[i][j][key] |= dp[i][j][Integer.parseInt(rp[0])];
                                }
                                if (rp.length == 2) {
                                    for (int k = i; k < j; ++k) {
                                        dp[i][j][key] |= dp[i][k][Integer.parseInt(rp[0])]
                                                && dp[k + 1][j][Integer.parseInt(rp[1])];
                                    }
                                }
                                if (rp.length == 3) {
                                    for (int k = i; k < j; ++k) {
                                        for (int l = k; l < j; ++l) {
                                            dp[i][j][key] |= dp[i][k][Integer.parseInt(rp[0])]
                                                    && dp[k + 1][l][Integer.parseInt(rp[1])]
                                                    && dp[l + 1][j][Integer.parseInt(rp[2])];
                                        }
                                    }
                                }
                                if (rp.length > 3) {
                                    System.out.println(rp.length);
                                }
                            }
                        }
                    }
                }
            }
            if (dp[0][s.length() - 1][0])
                ans++;
            if (dp[0][s.length() - 1][0])
                System.out.println(s + " YES");
            else
                System.out.println(s + " NO");
        }
        System.out.println(ans);
    }
}