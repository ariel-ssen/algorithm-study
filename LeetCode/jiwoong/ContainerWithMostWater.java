class Solution {
    public int maxArea(int[] height) {
        int start = 0;
        int end = height.length - 1;
        int maxWater = -1;
        while(start < end){
            int curHeight = Math.min(height[start], height[end]);
            int curWidth = end - start;

            maxWater = Math.max(maxWater, calcWater(curWidth, curHeight));

            if(height[start] >= height[end]) end--;
            else start++;
        }

        return maxWater;
    }

    public int calcWater(int width, int height){
        return width * height;
    }
}
