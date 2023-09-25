import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.math.*;

public class R2 {
	public static void main(String[] args) throws IOException {

		/*/
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		/*/
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("src/r.in"))));
		/**/
		
		long ans = 0;
		while (sc.hasNextLine()) {
			String s = sc.nextLine().replaceAll(" ", "");
			ans += eval(s);
		}
		System.out.println(ans);
	}
	
	public static long eval(String s) {
		if (s.isEmpty())
			return 0;
		if (s.contains("(")) {
			int first = s.indexOf('(');
			int ct = 0;
			int last = -1;
			for (int i = first; i < s.length(); ++i) {
				if (s.charAt(i)=='(')
					ct++;
				if (s.charAt(i)==')')
					ct--;
				if (ct==0) {
					last = i;
					break;
				}
			}
			return eval(s.substring(0,first)+eval(s.substring(first+1,last))+s.substring(last+1));
		}
		if (s.contains("*")) {
			String[] parts = s.split("\\*");
			long ans = 1;
			for (String p : parts)
				ans *= eval(p);
			return ans;
		}
		if (s.contains("+")) {
			String[] parts = s.split("\\+");
			long ans = 0;
			for (String p : parts)
				ans += eval(p);
			return ans;
		}
		return Long.parseLong(s);
	}
}