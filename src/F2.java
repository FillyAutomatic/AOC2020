import java.io.*;
import java.util.*;
import java.math.*;

public class F2 {
	public static void main(String[] args) throws IOException {

		/*/
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		/*/
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("src/f.in"))));
		/**/
		
		int ans = 0;
		while (sc.hasNextLine()) {
			int ct = 0;
			int[] cts = new int[26];
			while (sc.hasNextLine()) {
				String s = sc.nextLine();
				if (s.isEmpty())
					break;
				ct++;
				for (char c : s.toCharArray())
					cts[c-'a']++;
			}
			for (int i : cts)
				if (i==ct)
					ans++;
		}
		System.out.println(ans);
	}
}