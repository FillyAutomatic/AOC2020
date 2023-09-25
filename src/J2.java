import java.io.*;
import java.util.*;
import java.math.*;

public class J2 {
	public static void main(String[] args) throws IOException {

		/*/
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		/*/
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("src/j.in"))));
		/**/
		
		ArrayList<Long> ls = new ArrayList<>();
		ls.add(0L);
		while (sc.hasNextLong()) {
			ls.add(sc.nextLong());
		}
		Collections.sort(ls);
		ls.add(ls.get(ls.size()-1)+3);
		int n = ls.size();
		long[] dp = new long[n];
		dp[0] = 1;
		for (int i = 1; i < n; ++i) {
			for (int j = 0; j < i; ++j) {
				long d = ls.get(i)-ls.get(j);
				if (d<=3&&d>=1) {
					dp[i] += dp[j];
				}
			}
		}
		System.out.println(dp[n-1]);
	}
}