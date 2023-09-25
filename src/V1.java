import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.math.*;

public class V1 {
	public static void main(String[] args) throws IOException {

		/*/
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		/*/
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("src/v.in"))));
		/**/
		
		ArrayDeque<Integer> p1c = new ArrayDeque<>();
		ArrayDeque<Integer> p2c = new ArrayDeque<>();
		while (sc.hasNextLine()) {
			String s = sc.nextLine();
			if (s.startsWith("Player"))
				continue;
			if (s.isEmpty())
				break;
			p1c.add(Integer.parseInt(s));
		}
		while (sc.hasNextLine()) {
			String s = sc.nextLine();
			if (s.startsWith("Player"))
				continue;
			if (s.isEmpty())
				break;
			p2c.add(Integer.parseInt(s));
		}
		while (!p1c.isEmpty()&&!p2c.isEmpty()) {
			int a = p1c.removeFirst();
			int b = p2c.removeFirst();
			if (a>b) {
				p1c.add(a);
				p1c.add(b);
			} else {
				p2c.add(b);
				p2c.add(a);
			}
		}
		if (p1c.isEmpty())
			p1c=p2c;
		int ans = 0;
		int mul = 1;
		while (!p1c.isEmpty()) {
			ans += p1c.removeLast()*mul;
			mul++;
		}
		System.out.println(ans);
	}
}