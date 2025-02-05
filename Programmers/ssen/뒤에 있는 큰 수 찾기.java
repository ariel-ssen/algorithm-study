import java.util.*;

public class Solution {
    public int[] solution(int[] numbers) {
        int n = numbers.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        Arrays.fill(result, -1);

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                int index = stack.pop();
                result[index] = numbers[i];
            }
            stack.push(i);
        }

        return result;
    }

    // 체킹 
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] numbers1 = {2, 3, 3, 5};
        int[] result1 = sol.solution(numbers1);
        System.out.println(Arrays.toString(result1)); 

        int[] numbers2 = {9, 1, 5, 3, 6, 2};
        int[] result2 = sol.solution(numbers2);
        System.out.println(Arrays.toString(result2));
    }
}
