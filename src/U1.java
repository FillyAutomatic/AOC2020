import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.math.*;

public class U1 {
	public static void main(String[] args) throws IOException {

		/*/
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		/*/
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("src/u.in"))));
		/**/
		
		HashMap<String, HashSet<String>> alg = new HashMap<>();
		ArrayList<String> af = new ArrayList<>();
		while (sc.hasNextLine()) {
			String[] ings = sc.nextLine().replaceAll("\\(", "").replaceAll("\\)", "").replaceAll(",", "").split(" ");
			int ic = 0;
			for (int i = 0; i < ings.length; ++i) {
				String s = ings[i];
				if (s.equals("contains"))
					break;
				af.add(s);
				ic++;
			}
			for (int i = ic+1; i<ings.length; ++i) {
				HashSet<String> nhs = new HashSet<>();
				for (int j = 0; j < ic; ++j) {
					nhs.add(ings[j]);
				}
				if (!alg.containsKey(ings[i])) {
					alg.put(ings[i], nhs);
				} else {
					alg.get(ings[i]).retainAll(nhs);
				}
			}
		}
		HashSet<String> pa = new HashSet<>();
		for (String al : alg.keySet()) {
			for (String f : alg.get(al))
				pa.add(f);
		}
		int ans = 0;
		for (String f : af) {
			if (!pa.contains(f))
				ans++;
		}
		System.out.println(ans);
	}
}