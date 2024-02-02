import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.math.*;

public class Q2 {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("src/q.in"))));

        boolean[][][][] grid = new boolean[80][80][80][80];
        int cur = 40;
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            for (int i = 0; i < s.length(); ++i) {
                if (s.charAt(i) == '#')
                    grid[40][40][cur][40 + i] = true;
            }
            ++cur;
        }
        for (int z = 0; z < 6; ++z) {
            int ans = 0;
            boolean[][][][] grid2 = new boolean[80][80][80][80];
            for (int i = 1; i < 79; ++i) {
                for (int j = 1; j < 79; ++j) {
                    for (int k = 1; k < 79; ++k) {
                        for (int l = 1; l < 79; ++l) {
                            int ct = 0;
                            for (int a = -1; a <= 1; ++a) {
                                for (int b = -1; b <= 1; ++b) {
                                    for (int c = -1; c <= 1; ++c) {
                                        for (int d = -1; d <= 1; ++d) {
                                            if (a == 0 && b == 0 && c == 0 && d == 0)
                                                continue;
                                            if (grid[i + a][j + b][k + c][l + d])
                                                ct++;
                                        }
                                    }
                                }
                            }
                            grid2[i][j][k][l] = (grid[i][j][k][l] && (ct == 2 || ct == 3))
                                    || (!grid[i][j][k][l] && ct == 3);
                            if (grid2[i][j][k][l])
                                ans++;
                        }
                    }
                }
            }
            grid = grid2;
            System.out.println(ans);
        }
    }
}