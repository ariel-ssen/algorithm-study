import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int n = numbers.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        
        Deque<Integer> s = new ArrayDeque(n);
        for (int i = 0; i < n; ++i) {
            while (!s.isEmpty() && numbers[s.peekLast()] < numbers[i]) {
                res[s.peekLast()] = numbers[i];
                s.pollLast();
            }
                
            s.offer(i);
        }
        
        return res;
    }
}
