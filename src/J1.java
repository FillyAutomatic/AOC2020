import java.io.*;
import java.util.*;
import java.math.*;

public class J1 {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("src/j.in"))));

        ArrayList<Long> ls = new ArrayList<>();
        ls.add(0L);
        while (sc.hasNextLong()) {
            ls.add(sc.nextLong());
        }
        Collections.sort(ls);
        int d1 = 0;
        int d3 = 1;
        for (int i = 1; i < ls.size(); ++i) {
            if (ls.get(i) - ls.get(i - 1) == 1)
                d1++;
            if (ls.get(i) - ls.get(i - 1) == 3)
                d3++;
        }
        System.out.println(d1 * d3);
    }
}