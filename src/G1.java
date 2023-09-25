import java.io.*;
import java.util.*;
import java.math.*;

public class G1 {
	public static void main(String[] args) throws IOException {

		/*/
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		/*/
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("src/g.in"))));
		/**/
		
		HashMap<String, ArrayList<String>> g = new HashMap<>();
		HashSet<String> vis = new HashSet<>();
		while (sc.hasNextLine()) {
			String[] words = sc.nextLine().split(" ");
			String outer = words[0]+" "+words[1];
			for (int i = 5; i < words.length; i+=4) {
				if (words[i-1].equals("no"))
					continue;
				String inner = words[i]+" "+words[i+1];
				if (!g.containsKey(inner))
					g.put(inner, new ArrayList<>());
				g.get(inner).add(outer);
			}
		}
		ArrayDeque<String> q = new ArrayDeque<>();
		q.add("shiny gold");
		vis.add("shiny gold");
		while (!q.isEmpty()) {
			String u = q.removeFirst();
			if (!g.containsKey(u))
				continue;
			for (String v : g.get(u)) {
				if (!vis.contains(v)) {
					vis.add(v);
					q.add(v);
				}
			}
		}
		System.out.println(vis.size()-1);
	}
}