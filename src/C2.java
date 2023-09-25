import java.io.*;
import java.util.*;
import java.math.*;

public class C2 {
	public static void main(String[] args) throws IOException {

		/*/
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		/*/
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("src/c.in"))));
		/**/
		
		int c1 = 0;
		int c3 = 0;
		int c5 = 0;
		int c7 = 0;
		int c12 = 0;
		long t1 = 0;
		long t3 = 0;
		long t5 = 0;
		long t7 = 0;
		long t12 = 0;
		List<String> ls = new ArrayList<>();
		while (sc.hasNext()) {
			ls.add(sc.next());
		}
		for (int i = 0; i < ls.size(); ++i) {
			String s = ls.get(i);
			if (s.charAt(c1%s.length())=='#')
				t1++;
			if (s.charAt(c3%s.length())=='#')
				t3++;
			if (s.charAt(c5%s.length())=='#')
				t5++;
			if (s.charAt(c7%s.length())=='#')
				t7++;
			c1 += 1;
			c3 += 3;
			c5 += 5;
			c7 += 7;
			if (i%2==0) {
				if (s.charAt(c12%s.length())=='#')
					t12++;
				c12++;
			}
		}
		System.out.println(t1*t3*t5*t7*t12);
	}
}