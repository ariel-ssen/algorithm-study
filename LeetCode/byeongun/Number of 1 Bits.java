package org.example;

class TodayAlgorithm {
    // LeetCode 191 - Number of 1 Bits
    public static void main(String[] args) {
        int result = hammingWeight(128); // 입력값 예시
        System.out.println("count = " + result);
    }

    public static int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count += (n & 1); // 마지막 비트가 1인지 확인
            n >>>= 1;         // 논리적 오른쪽 시프트 (부호 비트 포함 처리)
        }
        return count;
    }
}
