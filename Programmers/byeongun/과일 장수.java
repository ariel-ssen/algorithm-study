package org.example;

import java.util.*;

class TodaySolution {
    public static void main(String[] args) {
        int solution = solution(4, 3, new int[]{4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2});
        System.out.println("solution = " + solution);
    }
    public static int solution(int k, int m, int[] score) {
        //1~k점수, 박스 당 M개의 사과, 최대 점수
        // 사과 개수 < 2M 이면 정렬 문제이고
        // 사과 개수 > 2M 이면 분배 문제? -> 정렬 후 M 개씩 띄워서 배열안에 넣고 -> 마지막 사과 점수 * M
        // 일단 내림차순으로 정렬

        Arrays.sort(score);
        int n = score.length;
        int sum = 0;
        for (int i = n - m; i >= 0; i -= m) {
            sum += score[i] * m;
        }
        return sum;
    }
}
