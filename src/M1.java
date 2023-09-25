import java.io.*;
import java.util.*;
import java.math.*;

public class M1 {
	public static void main(String[] args) throws IOException {

		/*/
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		/*/
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("src/m.in"))));
		/**/
		
		int ts = sc.nextInt();
		sc.nextLine();
		String[] bs = sc.nextLine().split(",");
		long bus = 0;
		int earl = 1000000000;
		for (String b : bs) {
			if (b.equals("x"))
				continue;
			int num = Integer.parseInt(b);
			int t = ts/num*num;
			if (t<ts)
				t+=num;
			if (t<earl) {
				earl = t;
				bus = num;
			}
		}
		System.out.println(bus*(earl-ts));
	}
}