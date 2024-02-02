import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.math.*;

public class V2 {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("src/v.in"))));

        ArrayDeque<Integer> p1c = new ArrayDeque<>();
        ArrayDeque<Integer> p2c = new ArrayDeque<>();
        int p1ct = 0;
        int p2ct = 0;
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            if (s.startsWith("Player"))
                continue;
            if (s.isEmpty())
                break;
            p1c.add(Integer.parseInt(s));
            p1ct++;
        }
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            if (s.startsWith("Player"))
                continue;
            if (s.isEmpty())
                break;
            p2c.add(Integer.parseInt(s));
            p2ct++;
        }
        play(p1c, p2c, p1ct, p2ct);
        if (p1c.isEmpty())
            p1c = p2c;
        int ans = 0;
        int mul = 1;
        while (!p1c.isEmpty()) {
            ans += p1c.removeLast() * mul;
            mul++;
        }
        System.out.println(ans);
    }

    public static boolean play(ArrayDeque<Integer> p1c, ArrayDeque<Integer> p2c, int p1ct, int p2ct) {
        HashSet<String> hs = new HashSet<>();
        while (!p1c.isEmpty() && !p2c.isEmpty()) {
            String s = String.join(",", p1c.stream().map(x -> "" + x).collect(Collectors.toList()));
            if (hs.contains(s))
                return true;
            hs.add(s);
            int a = p1c.removeFirst();
            int b = p2c.removeFirst();
            p1ct--;
            p2ct--;
            if (a <= p1ct && b <= p2ct) {
                ArrayDeque<Integer> ad1 = new ArrayDeque<>();
                ArrayDeque<Integer> ad2 = new ArrayDeque<>();
                Iterator<Integer> i1 = p1c.iterator();
                Iterator<Integer> i2 = p2c.iterator();
                for (int i = 0; i < a; ++i)
                    ad1.add(i1.next());
                for (int i = 0; i < b; ++i)
                    ad2.add(i2.next());
                boolean winner = play(ad1, ad2, a, b);
                if (winner) {
                    p1c.add(a);
                    p1c.add(b);
                    p1ct += 2;
                } else {
                    p2c.add(b);
                    p2c.add(a);
                    p2ct += 2;
                }
                continue;
            }
            if (a > b) {
                p1c.add(a);
                p1c.add(b);
                p1ct += 2;
            } else {
                p2c.add(b);
                p2c.add(a);
                p2ct += 2;
            }
        }
        return p2c.isEmpty();
    }
}