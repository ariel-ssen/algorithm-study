import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> m1 = new HashMap<>();
        Map<Integer, String> m2 = new HashMap<>();
        
        for (int i = 0; i < players.length; ++i) {
            m1.put(players[i], i + 1);
            m2.put(i + 1, players[i]);
        }
        
        for (String c : callings) {
            int prevG = m1.get(c);
            m1.put(c, prevG - 1);
            m1.put(m2.get(prevG - 1), prevG);
            
            m2.put(prevG, m2.get(prevG - 1));
            m2.put(prevG - 1, c);
        }
        
        String[] res = new String[players.length];
        for (int i = 0; i < players.length; ++i) {
            res[i] = m2.get(i + 1);
        }
        
        return res;
    }
}
