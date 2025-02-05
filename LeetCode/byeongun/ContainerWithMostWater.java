package org.example;

class TodayAlgorithm {
    public static void main(String[] args) {
        //LeetCode 11 - Container With Most Water
        // 양쪽에서 작은 수를 옆으로 옮기는 방식?
        int[] height = {1,10,1};
        System.out.println("max = " + maxArea(height));

    }

    static int max = 0;

    public static int maxArea(int[] height) {
        int prev = height[0];
        int last = height[height.length - 1];
        int preCount = 1;
        int lastCount = height.length - 2;

        for (int i = 1; i < height.length; i++) {
            int size = (last > prev) ? prev * (height.length - i) : last * (height.length - i);
            //System.out.println("size = " + size);
            max = Math.max(max, size);
            if (prev > last) {
                last = height[lastCount];
                lastCount--;
            } else if (prev < last) {
                prev = height[preCount];
                preCount++;
            } else { //동일한 수
                //System.out.println("lastCount = " + lastCount);
                if (lastCount == 0) {
                    //System.out.println("동일한 수, 상황 2개");
                    return max;
                } else if (lastCount == 1) {
                    //System.out.println("동일한 수, 상황 3개");
                    size = height[lastCount-1] * 2;
                    System.out.println("size = " + size);
                    size = Math.max(size, height[lastCount]);
                    return Math.max(size, max);
                }
                if (height[preCount + 1] < height[lastCount - 1]) {
                    last = height[lastCount];
                    lastCount--;
                } else {
                    prev = height[preCount];
                    preCount++;
                }
            }
        }
        return max;
    }

}
