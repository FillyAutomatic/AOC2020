import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.math.*;

public class O2 {
	public static void main(String[] args) throws IOException {

		/*/
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		/*/
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("src/o.in"))));
		/**/
		
		List<Integer> nums = Arrays.stream(sc.nextLine().split(",")).map(Integer::parseInt).collect(Collectors.toList());
		HashMap<Integer, Integer> hm = new HashMap<>();
		HashMap<Integer, Integer> hm2 = new HashMap<>();
		for (int i = 0; i < nums.size(); ++i) {
			if (hm.containsKey(nums.get(i)))
				hm2.put(nums.get(i), hm.get(nums.get(i)));
			hm.put(nums.get(i), i);
		}
		while (nums.size() < 30000000) {
			int last = nums.get(nums.size()-1);
			int age = 0;
			if (hm2.containsKey(last)) {
				age = nums.size()-1-hm2.get(last);
			}
			if (hm.containsKey(age))
				hm2.put(age, hm.get(age));
			hm.put(age, nums.size());
			nums.add(age);
		}
		System.out.println(nums.get(29999999));
	}
}