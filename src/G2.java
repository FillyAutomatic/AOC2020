import java.io.*;
import java.util.*;
import java.math.*;

public class G2 {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("src/g.in"))));

        HashMap<String, ArrayList<String>> g = new HashMap<>();
        while (sc.hasNextLine()) {
            String[] words = sc.nextLine().split(" ");
            String outer = words[0] + " " + words[1];
            g.put(outer, new ArrayList<>());
            for (int i = 5; i < words.length; i += 4) {
                if (words[i - 1].equals("no"))
                    continue;
                String inner = words[i - 1] + " " + words[i] + " " + words[i + 1];
                if (!g.containsKey(outer))
                    g.put(outer, new ArrayList<>());
                g.get(outer).add(inner);
            }
        }
        System.out.println(calc(g, "shiny gold").subtract(BigInteger.ONE));
    }

    public static BigInteger calc(HashMap<String, ArrayList<String>> g, String u) {
        BigInteger ans = BigInteger.ONE;
        for (String v : g.get(u)) {
            ans = ans.add(calc(g, v.split(" ")[1] + " " + v.split(" ")[2])
                    .multiply(BigInteger.valueOf(Integer.parseInt(v.split(" ")[0]))));
        }
        return ans;
    }
}