package org.example;

class TodayAlgorithm {
    public static void main(String[] args) {
        // 12903 가운데 글자 가져오기
        System.out.println(solution("abcdef"));
        System.out.println(solution("abcde"));
    }

    public static String solution(String s) {
        int length = s.length();
        int mid = length / 2;

        if (length % 2 == 0) {
            return s.substring(mid - 1, mid + 1);
        } else {
            return s.substring(mid, mid + 1);
        }
    }
}
