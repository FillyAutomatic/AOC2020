import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.math.*;

public class T1 {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("src/t.in"))));

        HashMap<String, HashSet<Integer>> ms = new HashMap<>();
        HashMap<Integer, ArrayList<String>> hm = new HashMap<>();
        while (sc.hasNextLine()) {
            String s = sc.nextLine().substring(5);
            s = s.substring(0, s.length() - 1);
            int tn = Integer.parseInt(s);
            hm.put(tn, new ArrayList<>());
            while (sc.hasNextLine()) {
                String s2 = sc.nextLine();
                if (s2.isEmpty())
                    break;
                hm.get(tn).add(s2);
            }
        }
        for (int tn : hm.keySet()) {
            String up = hm.get(tn).get(0);
            if (up.compareTo(new StringBuilder(up).reverse().toString()) > 0) {
                up = new StringBuilder(up).reverse().toString();
            }
            String down = hm.get(tn).get(hm.get(tn).size() - 1);
            if (down.compareTo(new StringBuilder(down).reverse().toString()) > 0) {
                down = new StringBuilder(down).reverse().toString();
            }
            if (!ms.containsKey(up))
                ms.put(up, new HashSet<>());
            if (!ms.containsKey(down))
                ms.put(down, new HashSet<>());
            ms.get(up).add(tn);
            ms.get(down).add(tn);
            String left = "";
            String right = "";
            for (String s : hm.get(tn)) {
                left += s.charAt(0);
                right += s.charAt(s.length() - 1);
            }
            if (left.compareTo(new StringBuilder(left).reverse().toString()) > 0) {
                left = new StringBuilder(left).reverse().toString();
            }
            if (right.compareTo(new StringBuilder(right).reverse().toString()) > 0) {
                right = new StringBuilder(right).reverse().toString();
            }
            if (!ms.containsKey(left))
                ms.put(left, new HashSet<>());
            if (!ms.containsKey(right))
                ms.put(right, new HashSet<>());
            ms.get(left).add(tn);
            ms.get(right).add(tn);
        }
        long ans = 1;
        for (int tn : hm.keySet()) {
            String up = hm.get(tn).get(0);
            if (up.compareTo(new StringBuilder(up).reverse().toString()) > 0) {
                up = new StringBuilder(up).reverse().toString();
            }
            String down = hm.get(tn).get(hm.get(tn).size() - 1);
            if (down.compareTo(new StringBuilder(down).reverse().toString()) > 0) {
                down = new StringBuilder(down).reverse().toString();
            }
            String left = "";
            String right = "";
            for (String s : hm.get(tn)) {
                left += s.charAt(0);
                right += s.charAt(s.length() - 1);
            }
            if (left.compareTo(new StringBuilder(left).reverse().toString()) > 0) {
                left = new StringBuilder(left).reverse().toString();
            }
            if (right.compareTo(new StringBuilder(right).reverse().toString()) > 0) {
                right = new StringBuilder(right).reverse().toString();
            }
            int mch = 0;
            if (ms.get(up).size() == 1)
                mch++;
            if (ms.get(down).size() == 1)
                mch++;
            if (ms.get(left).size() == 1)
                mch++;
            if (ms.get(right).size() == 1)
                mch++;
            if (mch == 2) {
                ans *= tn;
            }
        }
        System.out.println(ans);
    }
}