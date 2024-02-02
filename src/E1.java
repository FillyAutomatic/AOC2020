import java.io.*;
import java.util.*;
import java.math.*;

public class E1 {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("src/e.in"))));

        int ans = 0;
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            int a = 0;
            for (char c : s.toCharArray()) {
                a *= 2;
                if (c == 'B' || c == 'R')
                    a++;
            }
            ans = Math.max(ans, a);
        }
        System.out.println(ans);
    }
}