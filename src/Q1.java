import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.math.*;

public class Q1 {
	public static void main(String[] args) throws IOException {

		/*/
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		/*/
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("src/q.in"))));
		/**/
		
		boolean[][][] grid = new boolean[100][100][100];
		int cur = 50;
		while (sc.hasNextLine()) {
			String s = sc.nextLine();
			for (int i = 0; i < s.length(); ++i) {
				if (s.charAt(i)=='#')
					grid[50][cur][50+i] = true;
			}
			++cur;
		}
		for (int z = 0; z < 6; ++z) {
			int ans = 0;
			boolean[][][] grid2 = new boolean[100][100][100];
			for (int i = 1; i < 99; ++i) {
				for (int j = 1; j < 99; ++j) {
					for (int k = 1; k < 99; ++k) {
						int ct = 0;
						for (int a = -1; a <= 1; ++a) {
							for (int b = -1; b <= 1; ++b) {
								for (int c = -1; c <= 1; ++c) {
									if (a==0&&b==0&&c==0)
										continue;
									if (grid[i+a][j+b][k+c])
										ct++;
								}
							}
						}
						grid2[i][j][k] = (grid[i][j][k]&&(ct==2||ct==3))||(!grid[i][j][k]&&ct==3);
						if (grid2[i][j][k])
							ans++;
					}
				}
			}
			grid = grid2;
			System.out.println(ans);
		}
	}
}