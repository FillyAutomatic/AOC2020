import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.math.*;

public class P2 {
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
		String[] heads = new String[100];
		while (sc.hasNextLine()) {
			String s = sc.nextLine();
			if (s.isEmpty())
				break;
			heads[ind] = s.substring(0,s.indexOf(':'));
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
		int[] yt = new int[0];
		while (sc.hasNextLine()) {
			String s = sc.nextLine();
			if (s.isEmpty())
				break;
			if (s.startsWith("your"))
				continue;
			yt = Arrays.stream(s.split(",")).mapToInt(Integer::parseInt).toArray();
		}
		List<String> valids = new ArrayList<>();
		while (sc.hasNextLine()) {
			String s = sc.nextLine();
			if (s.startsWith("nearby"))
				continue;
			int[] nums = Arrays.stream(s.split(",")).mapToInt(Integer::parseInt).toArray();
			boolean valid = true;
			for (int i = 0; i < nums.length; ++i) {
				boolean match = false;
				for (int j = 0; j < 100; ++j) {
					if (x1[j]<=nums[i]&&nums[i]<=x2[j])
						match = true;
					if (y1[j]<=nums[i]&&nums[i]<=y2[j])
						match = true;
				}
				if (!match)
					valid = false;
			}
			if (valid)
				valids.add(s);
		}
		boolean[][] poss = new boolean[ind][ind];
		for (int i = 0; i < ind; ++i) {
			for (int j = 0; j < ind; ++j) {
				poss[i][j] = true;
			}
		}
		for (String s : valids) {
			int[] nums = Arrays.stream(s.split(",")).mapToInt(Integer::parseInt).toArray();
			for (int i = 0; i < nums.length; ++i) {
				for (int j = 0; j < ind; ++j) {
					boolean match = false;
					if (x1[j]<=nums[i]&&nums[i]<=x2[j])
						match = true;
					if (y1[j]<=nums[i]&&nums[i]<=y2[j])
						match = true;
					if (!match)
						poss[i][j] = false;
				}
			}
		}
		for (int z = 0; z < 100; ++z) {
			for (int i = 0; i < ind; ++i) {
				int ct = 0;
				int last = -1;
				for (int j = 0; j < ind; ++j) {
					ct += poss[i][j]?1:0;
					last = poss[i][j]?j:last;
				}
				if (ct==1) {
					for (int j = 0; j < ind; ++j) {
						poss[j][last] = false;
					}
					poss[i][last] = true;
				}
			}
			for (int j = 0; j < ind; ++j) {
				int ct = 0;
				int last = -1;
				for (int i = 0; i < ind; ++i) {
					ct += poss[i][j]?1:0;
					last = poss[i][j]?i:last;
				}
				if (ct==1) {
					for (int i = 0; i < ind; ++i) {
						poss[last][i] = false;
					}
					poss[last][j] = true;
				}
			}
		}
		long ans = 1;
		for (int i = 0; i < ind; ++i) {
			for (int j = 0; j < ind; ++j) {
				if (poss[i][j]&&heads[j].startsWith("departure"))
					ans *= yt[i];
			}
		}
		System.out.println(ans);
	}
}