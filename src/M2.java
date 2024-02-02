import java.io.*;
import java.util.*;
import java.math.*;

public class M2 {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("src/m.in"))));

        int ts = sc.nextInt();
        sc.nextLine();
        String[] bs = sc.nextLine().split(",");
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < bs.length; ++i) {
            if (bs[i].equals("x"))
                continue;
            int num = Integer.parseInt(bs[i]);
            int val = -i;
            while (val < 0)
                val += num;
            hm.put(num, val);
        }
        long t = 0;
        long mul = 1;
        for (int key : hm.keySet()) {
            while (t % key != hm.get(key))
                t += mul;
            mul *= key;
        }
        System.out.println(t);
    }
}