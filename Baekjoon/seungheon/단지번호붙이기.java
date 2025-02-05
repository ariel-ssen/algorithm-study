import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static StringBuilder[] map;
    static int[][] dir = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };
    
    static int dfs(int x, int y) {
        if (map[x].charAt(y) == '0') return 0;
        
        int cnt = 1;
        map[x].setCharAt(y, '0');
        
        for (int d = 0; d < 4; ++d) {
            int nx = x + dir[d][0];
            int ny = y + dir[d][1];
            
            if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                cnt += dfs(nx, ny);
            }
        }
        
        return cnt;
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        N = Integer.parseInt(br.readLine());
        map = new StringBuilder[N];
        for (int i = 0; i < N; ++i) {
            map[i] = new StringBuilder(br.readLine());
        }
        
        List<Integer> cntPerHouse = new ArrayList<>();
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                if (map[i].charAt(j) == '1') {
                    cntPerHouse.add(dfs(i, j));
                }
            }
        }
        Collections.sort(cntPerHouse);
        
        bw.write(cntPerHouse.size() + System.lineSeparator());
        for (int cnt : cntPerHouse) {
            bw.write(cnt + System.lineSeparator());
        }
        
        bw.flush();
        bw.close();
    }
}
