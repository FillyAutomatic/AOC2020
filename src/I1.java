import java.io.*;
import java.util.*;
import java.math.*;

public class I1 {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("src/i.in"))));

        ArrayList<Long> nums = new ArrayList<>();
        while (sc.hasNextLong()) {
            nums.add(sc.nextLong());
            if (nums.size() <= 25)
                continue;
            boolean ix = false;
            for (int i = 0; i < 25; ++i) {
                for (int j = i + 1; j < 25; ++j) {
                    if (nums.get(i) + nums.get(j) == nums.get(25))
                        ix = true;
                }
            }
            if (!ix) {
                System.out.println(nums.get(25));
                break;
            }
            nums.remove(0);
        }
    }
}