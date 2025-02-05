import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Set<Integer> s = new HashSet<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        while (N-- > 0) {
            s.add(Integer.parseInt(st.nextToken()));
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        while (M-- > 0) {
            if (s.contains(Integer.parseInt(st.nextToken()))) {
                bw.write("1\n");
            } else {
                bw.write("0\n");
            }
        }

        bw.flush();
    }
}
