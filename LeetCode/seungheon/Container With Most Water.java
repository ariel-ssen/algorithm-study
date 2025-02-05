import java.util.*;

class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int amount = 0;
        for (int s = 0, e = n - 1; s < n && e >= 0;) {
            amount = Math.max(amount, (e - s) * Math.min(height[s], height[e]));

            if (height[s] <= height[e]) s++;
            else e--;
        }

        return amount;
    }
}
