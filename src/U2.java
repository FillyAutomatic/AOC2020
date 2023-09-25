import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.math.*;

public class U2 {
	public static void main(String[] args) throws IOException {

		/*/
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		/*/
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("src/u.in"))));
		/**/
		
		TreeMap<String, HashSet<String>> alg = new TreeMap<>();
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
		for (int z = 0; z < 100; ++z) {
			for (String al : alg.keySet()) {
				if (alg.get(al).size()==1) {
					for (String al2 : alg.keySet()) {
						if (al.equals(al2))
							continue;
						alg.get(al2).remove(alg.get(al).stream().findAny().get());
					}
				}
			}
		}
		String ans = "";
		String comma = "";
		for (String al : alg.keySet()) {
			ans+=comma;
			ans+=alg.get(al).stream().findAny().get();
			comma=",";
		}
		System.out.println(ans);
	}
}