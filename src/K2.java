import java.io.*;
import java.util.*;
import java.math.*;

public class K2 {
	public static void main(String[] args) throws IOException {

		/*/
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		/*/
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("src/k.in"))));
		/**/
		
		ArrayList<String> ls = new ArrayList<>();
		while (sc.hasNextLine()) {
			ls.add(sc.nextLine());
		}
		int n = ls.size();
		int m = ls.get(0).length();
		while (true) {
			ArrayList<String> ns = new ArrayList<>();
			for (int i = 0; i < n; ++i) {
				String xx = "";
				for (int j = 0; j < m; ++j) {
					int nh = 0;
					if (ls.get(i).charAt(j)=='.') {
						xx+='.';
						continue;
					}
					for (int a = -1; a <= 1; ++a) {
						for (int b = -1; b <= 1; ++b) {
							if (a==0&&b==0)
								continue;
							for (int z = 1; z < 1000; ++z) {
								if (i+a*z<0||j+b*z<0||i+a*z>=n||j+b*z>=m)
									continue;
								if (ls.get(i+a*z).charAt(j+b*z)=='#') {
									nh++;
									break;
								}
								if (ls.get(i+a*z).charAt(j+b*z)=='L') {
									break;
								}
							}
						}
					}
					if (ls.get(i).charAt(j)=='L') {
						if (nh==0)
							xx+='#';
						else
							xx+='L';
					} else {
						if (nh>=5)
							xx+='L';
						else
							xx+='#';
					}
				}
				ns.add(xx);
			}
			int ct = 0;
			boolean diff = false;
			for (int i = 0; i < n; ++i) {
				for (int j = 0; j < m; ++j) {
					if (ns.get(i).charAt(j)!=ls.get(i).charAt(j))
						diff = true;
					if (ns.get(i).charAt(j)=='#')
						ct++;
				}
			}
			if (!diff) {
				System.out.println(ct);
				break;
			}
			ls = ns;
		}
	}
}