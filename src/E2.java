import java.io.*;
import java.util.*;
import java.math.*;

public class E2 {
	public static void main(String[] args) throws IOException {

		/*/
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		/*/
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("src/e.in"))));
		/**/
		
		boolean[] t = new boolean[1024];
		int ans = -1;
		while (sc.hasNextLine()) {
			String s = sc.nextLine();
			int a = 0;
			for (char c : s.toCharArray()) {
				a*=2;
				if (c=='B'||c=='R')
					a++;
			}
			t[a] = true;
		}
		for (int i = 1; i < 1023; ++i) {
			if (!t[i]&&t[i-1]&&t[i+1])
				ans = i;
		}
		System.out.println(ans);
	}
}