import java.io.*;
import java.util.*;
import java.math.*;

public class I2 {
	public static void main(String[] args) throws IOException {

		/*/
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		/*/
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("src/i.in"))));
		/**/
		
		ArrayList<Long> nums = new ArrayList<>();
		while (sc.hasNextLong()) {
			nums.add(sc.nextLong());
		}
		long tg = 25918798;
		int a = 0;
		int b = 0;
		long csum = 0;
		while (true) {
			if (csum==tg) {
				long min = 1000000000;
				long max = 0;
				for (int i = a; i<b; ++i) {
					min = Math.min(min, nums.get(i));
					max = Math.max(max, nums.get(i));
				}
				System.out.println(min+max);
				break;
			} else if (csum<tg) {
				csum += nums.get(b);
				++b;
			} else {
				csum -= nums.get(a);
				++a;
			}
		}
	}
}