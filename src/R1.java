import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.math.*;

public class R1 {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("src/r.in"))));

        long ans = 0;
        while (sc.hasNextLine()) {
            String s = sc.nextLine().replaceAll(" ", "");
            ans += eval(s);
        }
        System.out.println(ans);
    }

    public static long eval(String s) {
        if (s.isEmpty())
            return 0;
        if (s.charAt(0) == '(') {
            int ct = 0;
            int lend = 0;
            for (int i = 0; i < s.length(); ++i) {
                if (s.charAt(i) == '(')
                    ct++;
                if (s.charAt(i) == ')')
                    ct--;
                if (ct == 0) {
                    lend = i;
                    break;
                }
            }
            return eval(eval(s.substring(1, lend)) + s.substring(lend + 1));
        }
        long left = 0;
        char op = 'x';
        int opi = -1;
        int mul = 1;
        for (int i = 0; i < s.length(); ++i) {
            if (i == 0 && s.charAt(i) == '-') {
                mul = -1;
                continue;
            }
            if (s.charAt(i) < '0' || s.charAt(i) > '9') {
                op = s.charAt(i);
                opi = i;
                break;
            }
            left *= 10;
            left += s.charAt(i) - '0';
        }
        left *= mul;
        if (opi == -1)
            return left;
        long right = 0;
        int rend = s.length();
        if (s.charAt(opi + 1) == '(') {
            int ct = 0;
            for (int i = opi + 1; i < s.length(); ++i) {
                if (s.charAt(i) == '(')
                    ct++;
                if (s.charAt(i) == ')')
                    ct--;
                if (ct == 0) {
                    rend = i + 1;
                    break;
                }
            }
            right = eval(s.substring(opi + 2, rend - 1));
        } else {
            for (int i = opi + 1; i < s.length(); ++i) {
                if (s.charAt(i) < '0' || s.charAt(i) > '9') {
                    rend = i;
                    break;
                }
                right *= 10;
                right += s.charAt(i) - '0';
            }
        }
        if (op == '+')
            return eval((left + right) + s.substring(rend));
        if (op == '*')
            return eval((left * right) + s.substring(rend));
        return 0;
    }
}