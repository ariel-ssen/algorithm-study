public class Solution {
    public static void main(String[] args) {
        // 인풋을 예시와 같이
        int n1 = 11;
        int n2 = 128;
        int n3 = 2147483645;

        // Outputs
        System.out.println(hammingWeight(n1)); 
        System.out.println(hammingWeight(n2)); 
        System.out.println(hammingWeight(n3)); 
    }

    public static int hammingWeight(int n) {
        int count = 0;
        while (n > 0) {
            count += n & 1; 
            n >>= 1;     
        }
        return count;
    }
}
