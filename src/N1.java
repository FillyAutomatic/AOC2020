import java.io.*;
import java.util.*;
import java.math.*;

public class N1 {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("src/n.in"))));

        long[] vals = new long[1000000];
        String mask = "";
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            String inst = s.split(" ")[0];
            if (inst.equals("mask")) {
                mask = s.split(" ")[2];
            } else {
                int a = s.indexOf('[');
                int b = s.indexOf(']');
                int ind = Integer.parseInt(s.substring(a + 1, b));
                long num = Long.parseLong(s.split(" ")[2]);
                for (int i = 0; i < 36; ++i) {
                    if (mask.charAt(35 - i) != 'X')
                        num |= 1L << i;
                    if (mask.charAt(35 - i) == '0')
                        num -= 1L << i;
                    vals[ind] = num;
                }
            }
        }
        System.out.println(Arrays.stream(vals).sum());
    }
}