import java.io.*;
import java.util.*;
import java.math.*;

public class F1 {
	public static void main(String[] args) throws IOException {

		/*/
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		/*/
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("src/f.in"))));
		/**/
		
		int ans = 0;
		while (sc.hasNextLine()) {
			HashSet<Character> hs = new HashSet<>();
			while (sc.hasNextLine()) {
				String s = sc.nextLine();
				if (s.isEmpty())
					break;
				for (char c : s.toCharArray())
					hs.add(c);
			}
			ans += hs.size();
		}
		System.out.println(ans);
	}
}