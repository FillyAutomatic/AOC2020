import java.io.*;
import java.util.*;
import java.math.*;

public class B1 {
	public static void main(String[] args) throws IOException {

		/*/
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		/*/
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("src/b.in"))));
		/**/
		
		int ans = 0;
		while (sc.hasNext()) {
			String pol = sc.next();
			int ind = pol.indexOf('-');
			int min = Integer.parseInt(pol.substring(0,ind));
			int max = Integer.parseInt(pol.substring(ind+1));
			char c = sc.next().charAt(0);
			String pw = sc.next();
			int num = 0;
			for (char cc : pw.toCharArray()) {
				if (cc==c)
					++num;
			}
			if (min<=num&&num<=max)
				ans++;
		}
		System.out.println(ans);
	}
}