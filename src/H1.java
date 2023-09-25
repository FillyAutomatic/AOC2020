import java.io.*;
import java.util.*;
import java.math.*;

public class H1 {
	public static void main(String[] args) throws IOException {

		/*/
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		/*/
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("src/h.in"))));
		/**/
		
		int acc = 0;
		int ptr = 0;
		ArrayList<String> al = new ArrayList<>();
		while (sc.hasNextLine()) {
			al.add(sc.nextLine());
		}
		HashSet<Integer> vis = new HashSet<>();
		while (true) {
			if (vis.contains(ptr))
				break;
			vis.add(ptr);
			String inst = al.get(ptr).split(" ")[0];
			int num = Integer.parseInt(al.get(ptr).split(" ")[1]);
			if (inst.equals("nop")) {
				ptr++;
			} else if (inst.equals("jmp")) {
				ptr+=num;
			} else if (inst.equals("acc")) {
				ptr++;
				acc+=num;
			}
		}
		System.out.println(acc);
	}
}