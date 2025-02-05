class Solution {
    public String solution(String s) {
        int strlen = s.length();
        
        if (strlen % 2 == 0) {
            return s.substring(strlen / 2 - 1, strlen / 2 +1);
        } else {
            return String.valueOf(s.charAt(strlen / 2));
        }
    }
}
