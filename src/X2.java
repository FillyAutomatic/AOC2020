import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.math.*;

public class X2 {
	public static void main(String[] args) throws IOException {

		/*/
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		/*/
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("src/x.in"))));
		/**/
		
		int[][] fl = new int[300][300];
		while (sc.hasNextLine()) {
			int x = 150;
			int y = 150;
			String s = sc.nextLine();
			for (int i = 0; i < s.length(); ++i) {
				if (s.charAt(i)=='w') {
					x--;
				}
				if (s.charAt(i)=='e') {
					x++;
				}
				if (s.charAt(i)=='n') {
					++i;
					--y;
					if (s.charAt(i)=='w') {
						--x;
					}
				} else if (s.charAt(i)=='s') {
					++i;
					++y;
					if (s.charAt(i)=='e') {
						++x;
					}
				}
			}
			fl[y][x]^=1;
		}
		for (int z = 0; z < 100; ++z) {
			int[][] nf = new int[300][300];
			for (int i = 1; i < 299; ++i) {
				for (int j = 1; j < 299; ++j) {
					int ct = fl[i][j-1]+fl[i][j+1]+fl[i-1][j-1]+fl[i-1][j]+fl[i+1][j]+fl[i+1][j+1];
					if (fl[i][j]==1&&ct>=1&&ct<=2)
						nf[i][j] = 1;
					if (fl[i][j]==0&&ct==2)
						nf[i][j] = 1;
				}
			}
			fl = nf;
		}
		int ans = 0;
		for (int i = 0; i < 300; ++i) {
			for (int j = 0; j < 300; ++j) {
				ans += fl[i][j];
			}
		}
		System.out.println(ans);
	}
}