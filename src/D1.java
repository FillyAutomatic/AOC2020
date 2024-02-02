import java.io.*;
import java.util.*;
import java.math.*;

public class D1 {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("src/d.in"))));

        int ans = 0;
        while (sc.hasNextLine()) {
            HashMap<String, String> fds = new HashMap<>();
            while (sc.hasNextLine()) {
                String l = sc.nextLine();
                if (l.isEmpty())
                    break;
                String[] fs = l.split(" ");
                for (String f : fs)
                    fds.put(f.split(":")[0], f.split(":")[1]);
            }
            if (fds.size() == 8 || (fds.size() == 7 && !fds.containsKey("cid")))
                ans++;
        }
        System.out.println(ans);
    }
}