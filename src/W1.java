import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.math.*;

public class W1 {
	public static void main(String[] args) throws IOException {

		/*/
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		/*/
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("src/w.in"))));
		/**/
		
		String s = sc.next();
		int curr = 0;
		for (int i = 0; i < 100; ++i) {
			char c = s.charAt(curr);
			String s2 = "";
			String pick = "";
			for (int j = 0; j < s.length(); ++j) {
				if ((j+s.length()-curr)%s.length()>=1&&(j+s.length()-curr)%s.length()<=3)
					continue;
				else
					s2 += s.charAt(j);
			}
			for (int j = 1; j <= 3; ++j) {
				pick += s.charAt((j+curr)%s.length());
			}
			char find = (char)(c-1);
			while (s2.indexOf(find)==-1) {
				if (find<'0') {
					find = '9';
					continue;
				}
				find--;
			}
			s = s2.substring(0,s2.indexOf(find)+1)+pick+s2.substring(s2.indexOf(find)+1);
			curr = s.indexOf(c);
			++curr;
			curr %= s.length();
		}
		System.out.println(s);
	}
}