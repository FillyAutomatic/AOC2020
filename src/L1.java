import java.io.*;
import java.util.*;
import java.math.*;

public class L1 {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("src/l.in"))));

        long x = 0;
        long y = 0;
        int mx = 1;
        int my = 0;
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            long num = Long.parseLong(s.substring(1));
            if (s.charAt(0) == 'E')
                x += num;
            if (s.charAt(0) == 'W')
                x -= num;
            if (s.charAt(0) == 'N')
                y += num;
            if (s.charAt(0) == 'S')
                y -= num;
            if (s.charAt(0) == 'F') {
                x += num * mx;
                y += num * my;
            }
            if (s.charAt(0) == 'R') {
                while (num > 0) {
                    int t = my;
                    my = -mx;
                    mx = t;
                    num -= 90;
                }
            }
            if (s.charAt(0) == 'L') {
                while (num > 0) {
                    int t = mx;
                    mx = -my;
                    my = t;
                    num -= 90;
                }
            }
        }
        System.out.println(Math.abs(x) + Math.abs(y));
    }
}