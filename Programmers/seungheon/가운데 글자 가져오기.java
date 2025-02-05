class Solution {
    public String solution(String s) {
        int n = s.length();
        int mid = n >> 1;
        if ((n & 1) == 1) {
            return s.substring(mid, mid + 1);
        } else {
            return s.substring(mid - 1, mid + 1);
        }
    }
}
