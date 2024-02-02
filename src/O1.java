import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.math.*;

public class O1 {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("src/o.in"))));

        List<Integer> nums = Arrays.stream(sc.nextLine().split(",")).map(Integer::parseInt)
                .collect(Collectors.toList());
        while (nums.size() < 2020) {
            int last = nums.get(nums.size() - 1);
            int age = 0;
            for (int i = nums.size() - 2; i >= 0; --i) {
                if (nums.get(i) == last) {
                    age = nums.size() - 1 - i;
                    break;
                }
            }
            nums.add(age);
        }
        System.out.println(nums.get(2019));
    }
}