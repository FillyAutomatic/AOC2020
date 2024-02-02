import java.io.*;
import java.util.*;
import java.math.*;

public class L2 {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("src/l.in"))));

        long x = 0;
        long y = 0;
        long wx = 10;
        long wy = 1;
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            long num = Long.parseLong(s.substring(1));
            if (s.charAt(0) == 'E')
                wx += num;
            if (s.charAt(0) == 'W')
                wx -= num;
            if (s.charAt(0) == 'N')
                wy += num;
            if (s.charAt(0) == 'S')
                wy -= num;
            if (s.charAt(0) == 'F') {
                x += num * wx;
                y += num * wy;
            }
            if (s.charAt(0) == 'R') {
                while (num > 0) {
                    long t = wy;
                    wy = -wx;
                    wx = t;
                    num -= 90;
                }
            }
            if (s.charAt(0) == 'L') {
                while (num > 0) {
                    long t = wx;
                    wx = -wy;
                    wy = t;
                    num -= 90;
                }
            }
        }
        System.out.println(Math.abs(x) + Math.abs(y));
    }
}