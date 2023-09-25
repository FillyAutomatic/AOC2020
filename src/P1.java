import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.math.*;

public class P1 {
	public static void main(String[] args) throws IOException {

		/*/
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		/*/
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("src/p.in"))));
		/**/
		
		int[] x1 = new int[100];
		int[] x2 = new int[100];
		int[] y1 = new int[100];
		int[] y2 = new int[100];
		int ind = 0;
		while (sc.hasNextLine()) {
			String s = sc.nextLine();
			if (s.isEmpty())
				break;
			s = s.substring(s.indexOf(':')+2);
			x1[ind] = Integer.parseInt(s.substring(0,s.indexOf('-')));
			s = s.substring(s.indexOf('-')+1);
			x2[ind] = Integer.parseInt(s.substring(0,s.indexOf(' ')));
			s = s.substring(s.indexOf('r')+2);
			y1[ind] = Integer.parseInt(s.substring(0,s.indexOf('-')));
			s = s.substring(s.indexOf('-')+1);
			y2[ind] = Integer.parseInt(s);
			++ind;
		}
		while (sc.hasNextLine()) {
			String s = sc.nextLine();
			if (s.isEmpty())
				break;
		}
		int inval = 0;
		while (sc.hasNextLine()) {
			String s = sc.nextLine();
			if (s.startsWith("nearby"))
				continue;
			int[] nums = Arrays.stream(s.split(",")).mapToInt(Integer::parseInt).toArray();
			for (int i = 0; i < nums.length; ++i) {
				boolean match = false;
				for (int j = 0; j < 100; ++j) {
					if (x1[j]<=nums[i]&&nums[i]<=x2[j])
						match = true;
					if (y1[j]<=nums[i]&&nums[i]<=y2[j])
						match = true;
				}
				if (!match)
					inval += nums[i];
			}
		}
		System.out.println(inval);
	}
}