import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.math.*;

public class X1 {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("src/x.in"))));

        int[][] flipped = new int[100][100];
        int ans = 0;
        while (sc.hasNextLine()) {
            int x = 50;
            int y = 50;
            String s = sc.nextLine();
            for (int i = 0; i < s.length(); ++i) {
                if (s.charAt(i) == 'w') {
                    x--;
                }
                if (s.charAt(i) == 'e') {
                    x++;
                }
                if (s.charAt(i) == 'n') {
                    ++i;
                    --y;
                    if (s.charAt(i) == 'w') {
                        --x;
                    }
                } else if (s.charAt(i) == 's') {
                    ++i;
                    ++y;
                    if (s.charAt(i) == 'e') {
                        ++x;
                    }
                }
            }
            ans -= flipped[x][y];
            flipped[x][y] ^= 1;
            ans += flipped[x][y];
        }
        System.out.println(ans);
    }
}