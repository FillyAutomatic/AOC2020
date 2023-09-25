import java.io.*;
import java.util.*;
import java.math.*;

public class D2 {
	public static void main(String[] args) throws IOException {

		/*/
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		/*/
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("src/d.in"))));
		/**/
		
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
			if (fds.size()!=8&&(fds.size()!=7||fds.containsKey("cid")))
				continue;
			if (Integer.parseInt(fds.get("byr"))<1920||Integer.parseInt(fds.get("byr"))>2002)
				continue;
			if (Integer.parseInt(fds.get("iyr"))<2010||Integer.parseInt(fds.get("iyr"))>2020)
				continue;
			if (Integer.parseInt(fds.get("eyr"))<2020||Integer.parseInt(fds.get("eyr"))>2030)
				continue;
			if (fds.get("hgt").matches("\\d{2}in")) {
				if (Integer.parseInt(fds.get("hgt").substring(0,2))<59||Integer.parseInt(fds.get("hgt").substring(0,2))>76)
					continue;
			} else if (fds.get("hgt").matches("\\d{3}cm")) {
				if (Integer.parseInt(fds.get("hgt").substring(0,3))<150||Integer.parseInt(fds.get("hgt").substring(0,3))>193)
					continue;
			} else {
				continue;
			}
			if (!fds.get("hcl").matches("#[\\da-f]{6}"))
				continue;
			if (!fds.get("ecl").matches("amb|blu|brn|gry|grn|hzl|oth"))
				continue;
			if (!fds.get("pid").matches("\\d{9}"))
				continue;
			ans++;
		}
		System.out.println(ans);
	}
}