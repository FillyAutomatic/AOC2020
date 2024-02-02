import java.io.*;
import java.util.*;
import java.math.*;

public class A1 {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("src/a.in"))));

        int[] nums = new int[2021];
        int ans = 0;
        while (sc.hasNextInt()) {
            int x = sc.nextInt();
            if (x > 2020)
                continue;
            if (nums[2020 - x] > 0)
                ans = x * (2020 - x);
            nums[x]++;
        }
        System.out.println(ans);
    }
}