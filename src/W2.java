import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.math.*;

public class W2 {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("src/w.in"))));

        int[] nxts = new int[1000000];
        String s = sc.next();
        for (int i = 0; i < 1000000; ++i) {
            if (i < s.length() - 1) {
                nxts[s.charAt(i) - '1'] = s.charAt(i + 1) - '1';
            } else if (i == s.length() - 1) {
                nxts[s.charAt(i) - '1'] = i + 1;
            } else if (i == 999999) {
                nxts[i] = s.charAt(0) - '1';
            } else {
                nxts[i] = i + 1;
            }
        }
        int curr = s.charAt(0) - '1';
        for (int i = 0; i < 10000000; ++i) {
            int p1 = nxts[curr];
            int p2 = nxts[p1];
            int p3 = nxts[p2];
            int p4 = nxts[p3];
            int plop = curr - 1;
            if (plop < 0)
                plop += 1000000;
            while (plop == p1 || plop == p2 || plop == p3) {
                plop--;
                if (plop < 0)
                    plop += 1000000;
            }
            int plop1 = nxts[plop];
            nxts[curr] = p4;
            nxts[plop] = p1;
            nxts[p3] = plop1;
            curr = p4;
        }
        System.out.println((long) (nxts[0] + 1) * (long) (nxts[nxts[0]] + 1));
    }
}