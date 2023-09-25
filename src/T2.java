import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.math.*;

public class T2 {
	public static void main(String[] args) throws IOException {

		/*/
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		/*/
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("src/t.in"))));
		/**/
		
		HashMap<String, HashSet<Integer>> ms = new HashMap<>();
		HashMap<Integer, ArrayList<String>> hm = new HashMap<>();
		while (sc.hasNextLine()) {
			String s = sc.nextLine().substring(5);
			s = s.substring(0,s.length()-1);
			int tn = Integer.parseInt(s);
			hm.put(tn, new ArrayList<>());
			while (sc.hasNextLine()) {
				String s2 = sc.nextLine();
				if (s2.isEmpty())
					break;
				hm.get(tn).add(s2);
			}
		}
		for (int tn : hm.keySet()) {
			String up = hm.get(tn).get(0);
			if (up.compareTo(new StringBuilder(up).reverse().toString())>0)
				up = new StringBuilder(up).reverse().toString();
			String down = hm.get(tn).get(hm.get(tn).size()-1);
			if (down.compareTo(new StringBuilder(down).reverse().toString())>0)
				down = new StringBuilder(down).reverse().toString();
			String left = "";
			String right = "";
			for (String s : hm.get(tn)) {
				left += s.charAt(0);
				right += s.charAt(s.length()-1);
			}
			if (left.compareTo(new StringBuilder(left).reverse().toString())>0)
				left = new StringBuilder(left).reverse().toString();
			if (right.compareTo(new StringBuilder(right).reverse().toString())>0)
				right = new StringBuilder(right).reverse().toString();
			if (!ms.containsKey(up))
				ms.put(up, new HashSet<>());
			if (!ms.containsKey(down))
				ms.put(down, new HashSet<>());
			if (!ms.containsKey(left))
				ms.put(left, new HashSet<>());
			if (!ms.containsKey(right))
				ms.put(right, new HashSet<>());
			ms.get(up).add(tn);
			ms.get(down).add(tn);
			ms.get(left).add(tn);
			ms.get(right).add(tn);
		}
		int dim = (int)Math.sqrt(hm.size());
		HashSet<Integer> corners = new HashSet<>();
		HashMap<Integer, HashSet<Integer>> g = new HashMap<>();
		for (int tn : hm.keySet()) {
			String up = hm.get(tn).get(0);
			if (up.compareTo(new StringBuilder(up).reverse().toString())>0)
				up = new StringBuilder(up).reverse().toString();
			String down = hm.get(tn).get(hm.get(tn).size()-1);
			if (down.compareTo(new StringBuilder(down).reverse().toString())>0)
				down = new StringBuilder(down).reverse().toString();
			String left = "";
			String right = "";
			for (String s : hm.get(tn)) {
				left += s.charAt(0);
				right += s.charAt(s.length()-1);
			}
			if (left.compareTo(new StringBuilder(left).reverse().toString())>0)
				left = new StringBuilder(left).reverse().toString();
			if (right.compareTo(new StringBuilder(right).reverse().toString())>0)
				right = new StringBuilder(right).reverse().toString();
			int mch = 0;
			if (ms.get(up).size()==1)
				mch++;
			if (ms.get(down).size()==1)
				mch++;
			if (ms.get(left).size()==1)
				mch++;
			if (ms.get(right).size()==1)
				mch++;
			if (mch==2) {
				corners.add(tn);
			}
			g.put(tn, new HashSet<>());
			for (int v : ms.get(up)) {
				if (v!=tn)
					g.get(tn).add(v);
			}
			for (int v : ms.get(down)) {
				if (v!=tn)
					g.get(tn).add(v);
			}
			for (int v : ms.get(left)) {
				if (v!=tn)
					g.get(tn).add(v);
			}
			for (int v : ms.get(right)) {
				if (v!=tn)
					g.get(tn).add(v);
			}
		}
		int[][] arr = new int[dim][dim];
		arr[0][0] = corners.stream().findAny().get();
		HashSet<Integer> vis = new HashSet<>();
		vis.add(arr[0][0]);
		for (int i = 1; i < dim-1; ++i) {
			for (int v : g.get(arr[0][i-1])) {
				if (!vis.contains(v)&&g.get(v).size()==3) {
					arr[0][i] = v;
					vis.add(v);
					break;
				}
			}
		}
		for (int v : g.get(arr[0][dim-2])) {
			if (!vis.contains(v)&&g.get(v).size()==2) {
				arr[0][dim-1] = v;
				vis.add(v);
				break;
			}
		}
		for (int i = 1; i < dim; ++i) {
			for (int j = 0; j < dim; ++j) {
				for (int v : g.get(arr[i-1][j])) {
					if (!vis.contains(v)) {
						arr[i][j] = v;
						vis.add(v);
						break;
					}
				}
			}
		}
		ArrayList<String> fin = new ArrayList<String>();
		for (int i = 0; i < dim; ++i) {
			for (int j = 0; j < dim; ++j) {
				int tn = arr[i][j];
				String up = hm.get(tn).get(0);
				if (up.compareTo(new StringBuilder(up).reverse().toString())>0)
					up = new StringBuilder(up).reverse().toString();
				String down = hm.get(tn).get(hm.get(tn).size()-1);
				if (down.compareTo(new StringBuilder(down).reverse().toString())>0)
					down = new StringBuilder(down).reverse().toString();
				String left = "";
				String right = "";
				for (String s : hm.get(tn)) {
					left += s.charAt(0);
					right += s.charAt(s.length()-1);
				}
				if (left.compareTo(new StringBuilder(left).reverse().toString())>0)
					left = new StringBuilder(left).reverse().toString();
				if (right.compareTo(new StringBuilder(right).reverse().toString())>0)
					right = new StringBuilder(right).reverse().toString();
				int ud = i==0?arr[i+1][j]:arr[i-1][j];
				int lr = j==0?arr[i][j+1]:arr[i][j-1];
				if (!ms.get(up).contains(ud)&&!ms.get(down).contains(ud)) {
					ArrayList<String> nu = new ArrayList<>();
					for (String s : hm.get(tn))
						nu.add(new String());
					for (String s : hm.get(tn)) {
						for (int k = 0; k < s.length(); ++k)
							nu.set(k, nu.get(k)+s.charAt(k));
					}
					hm.put(tn, nu);
					up = hm.get(tn).get(0);
					if (up.compareTo(new StringBuilder(up).reverse().toString())>0)
						up = new StringBuilder(up).reverse().toString();
					down = hm.get(tn).get(hm.get(tn).size()-1);
					if (down.compareTo(new StringBuilder(down).reverse().toString())>0)
						down = new StringBuilder(down).reverse().toString();
					left = "";
					right = "";
					for (String s : hm.get(tn)) {
						left += s.charAt(0);
						right += s.charAt(s.length()-1);
					}
					if (left.compareTo(new StringBuilder(left).reverse().toString())>0)
						left = new StringBuilder(left).reverse().toString();
					if (right.compareTo(new StringBuilder(right).reverse().toString())>0)
						right = new StringBuilder(right).reverse().toString();
				}
				if ((j>0&&!ms.get(left).contains(lr))||(j==0&&!ms.get(right).contains(lr))) {
					ArrayList<String> nu = new ArrayList<>();
					for (String s : hm.get(tn))
						nu.add(new StringBuilder(s).reverse().toString());
					hm.put(tn, nu);
				}
				if ((i>0&&!ms.get(up).contains(ud))||(i==0&&!ms.get(down).contains(ud))) {
					ArrayList<String> nu = new ArrayList<>();
					for (String s : hm.get(tn))
						nu.add(0, s);
					hm.put(tn, nu);
				}
				for (int k = 1; k < hm.get(tn).size()-1; ++k) {
					int ind = i*(hm.get(tn).size()-2)+k-1;
					if (ind==fin.size())
						fin.add("");
					fin.set(ind, fin.get(ind)+hm.get(tn).get(k).substring(1,hm.get(tn).size()-1));
				}
			}
		}
		int ans = 10000000;
		for (int rot = 0; rot < 2; ++rot) {
			for (int fh = 0; fh < 2; ++fh) {
				for (int fv = 0; fv < 2; ++fv) {
					int ct = 0;
					String sm1 = "                  # ".replaceAll(" ", ".");
					String sm2 = "#    ##    ##    ###".replaceAll(" ", ".");
					String sm3 = " #  #  #  #  #  #   ".replaceAll(" ", ".");
					for (int i = 0; i+3<=fin.size(); ++i) {
						for (int j = 0; j+sm1.length()<=fin.size(); ++j) {
							if (fin.get(i).substring(j,j+sm1.length()).matches(sm1)&&fin.get(i+1).substring(j,j+sm2.length()).matches(sm2)&&fin.get(i+2).substring(j,j+sm3.length()).matches(sm3)) {
								ct -= 15;
							}
						}
					}
					for (int i = 0; i < fin.size(); ++i) {
						for (int j = 0; j < fin.size(); ++j) {
							if (fin.get(i).charAt(j)=='#')
								ct++;
						}
					}
					ans = Math.min(ans, ct);
					ArrayList<String> nu = new ArrayList<>();
					for (String s : fin)
						nu.add(0, s);
					fin = nu;
				}
				ArrayList<String> nu = new ArrayList<>();
				for (String s : fin)
					nu.add(new StringBuilder(s).reverse().toString());
				fin = nu;
			}
			ArrayList<String> nu = new ArrayList<>();
			for (String s : fin)
				nu.add(new String());
			for (String s : fin) {
				for (int k = 0; k < s.length(); ++k)
					nu.set(k, nu.get(k)+s.charAt(k));
			}
			fin = nu;
		}
		System.out.println(ans);
	}
}