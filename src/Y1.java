import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.math.*;

public class Y1 {
	public static void main(String[] args) throws IOException {

		/*/
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		/*/
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("src/y.in"))));
		/**/
		
		int cpk = sc.nextInt();
		int dpk = sc.nextInt();
		int sub = 7;
		int cnum = 1;
		int cls = 0;
		int dnum = 1;
		int dls = 0;
		while (cnum != cpk) {
			cnum*=sub;
			cnum%=20201227;
			++cls;
		}
		while (dnum != dpk) {
			dnum*=sub;
			dnum%=20201227;
			++dls;
		}
		long key = 1;
		for (int i = 0; i < dls; ++i) {
			key *= cnum;
			key %= 20201227;
		}
		System.out.println(key);
	}
}