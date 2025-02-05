//투포인터 O(n)
class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        int left = 0; int right=height.length - 1;
        while(left<right){
            int shorter = 0;
            if(height[left] < height[right]){
                shorter = height[left];
                left++;
            }else{
                shorter = height[right];
                right--;
            }
            max = Math.max(max, shorter * (right- left+1));
        }
        return max;
    }
}

//시간 초과 o(n^2)
// class Solution {
//     public int maxArea(int[] height) {
//         int max = 0;
//         for(int i=0; i<height.length-1; i++){
//             for(int j=i+1; j<height.length; j++){
//                 max = Math.max(max, Math.min(height[i],height[j])*(j-i));
//             }
//         }
//         return max;
//     }
// }
