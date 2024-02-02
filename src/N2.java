import java.io.*;
import java.util.*;
import java.math.*;

public class N2 {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("src/n.in"))));

        HashMap<String, Long> vals = new HashMap<>();
        String mask = "";
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            String inst = s.split(" ")[0];
            if (inst.equals("mask")) {
                mask = s.split(" ")[2];
            } else {
                int a = s.indexOf('[');
                int b = s.indexOf(']');
                int ind = Integer.parseInt(s.substring(a + 1, b));
                long num = Long.parseLong(s.split(" ")[2]);
                HashSet<String> mss = adds(Long.toBinaryString((1L << 40) + ind).substring(5), mask);
                for (String mv : mss) {
                    vals.put(mv, num);
                }
            }
        }
        System.out.println(vals.values().stream().reduce(0L, Long::sum));
    }

    public static HashSet<String> adds(String val, String mask) {
        HashSet<String> res = new HashSet<>();
        if (mask.isEmpty()) {
            res.add("");
            return res;
        }
        if (mask.charAt(0) == 'X') {
            HashSet<String> a1 = adds(val.substring(1), mask.substring(1));
            for (String s : a1) {
                res.add("0" + s);
                res.add("1" + s);
            }
            return res;
        } else {
            HashSet<String> a1 = adds(val.substring(1), mask.substring(1));
            for (String s : a1)
                res.add((mask.charAt(0) == '0' ? val.charAt(0) : mask.charAt(0)) + s);
        }
        return res;
    }
}