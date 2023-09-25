import java.io.*;
import java.util.*;
import java.math.*;

public class H2 {
	public static void main(String[] args) throws IOException {

		/*/
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		/*/
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("src/h.in"))));
		/**/
		
		ArrayList<String> al = new ArrayList<>();
		while (sc.hasNextLine()) {
			al.add(sc.nextLine());
		}
		for (int i = 0; i < al.size(); ++i) {
			int acc = 0;
			int ptr = 0;
			int last = 0;
			if (al.get(i).split(" ")[0].equals("acc"))
				continue;
			HashSet<Integer> vis = new HashSet<>();
			while (true) {
				if (vis.contains(ptr)||ptr>=al.size()||ptr<0)
					break;
				vis.add(ptr);
				String inst = al.get(ptr).split(" ")[0];
				int num = Integer.parseInt(al.get(ptr).split(" ")[1]);
				last = ptr;
				if (inst.equals("nop")) {
					if (ptr==i)
						ptr+=num;
					else
						ptr++;
				} else if (inst.equals("jmp")) {
					if (ptr==i)
						ptr++;
					else
						ptr+=num;
				} else if (inst.equals("acc")) {
					ptr++;
					acc+=num;
				}
			}
			if (last==al.size()-1)
				System.out.println(acc);
		}
	}
}