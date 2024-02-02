import java.io.*;
import java.util.*;
import java.math.*;

public class A2 {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("src/a.in"))));

        int[] nums = new int[2021];
        int ans = 0;
        while (sc.hasNextInt()) {
            int x = sc.nextInt();
            if (x > 2020)
                continue;
            for (int a = 0; a <= 2020; ++a) {
                int b = 2020 - a - x;
                if (b < 0)
                    continue;
                if (a == b) {
                    if (nums[a] > 1) {
                        ans = a * b * x;
                    }
                } else {
                    if (nums[a] > 0 && nums[b] > 0) {
                        ans = a * b * x;
                    }
                }
            }
            nums[x]++;
        }
        System.out.println(ans);
    }
}