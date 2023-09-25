import java.io.*;
import java.util.*;
import java.math.*;

public class C1 {
	public static void main(String[] args) throws IOException {

		/*/
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		/*/
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("src/c.in"))));
		/**/
		
		int curr = 0;
		int tr = 0;
		while (sc.hasNext()) {
			String s = sc.next();
			if (s.charAt(curr%s.length())=='#')
				tr++;
			curr += 3;
		}
		System.out.println(tr);
	}
}