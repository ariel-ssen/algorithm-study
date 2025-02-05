package org.example;

import javax.swing.text.html.HTMLDocument;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

class TodayAlgorithm {
    //기타 레슨
    //N (1 ≤ N ≤ 100,000)과 M (1 ≤ M ≤ N)
    //연속적인 강의를 M 분할로 나누는데 가장 큰 블루레이 크기가 가장 작을 수
    static int answer = Integer.MAX_VALUE;
    static int N;
    static int M;
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] init = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = init[0];
        M = init[1];
        List<Integer> list = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).boxed().toList().stream().sorted(Comparator.reverseOrder()).toList();
        //근데 이것보다 스택에 넣고 뺴는 게 더 빠른가?

        List<Integer> group = new ArrayList<>();
        String startStr = "";
        for(int i=0; i<M-1; i++){
            group.add(1);
            startStr = startStr.concat(group.get(i).toString());
        }
        group.add(N-(M-1));
        startStr = startStr.concat(group.get(M-1).toString());
        //System.out.println("group = " + group);
        int start = Integer.parseInt(startStr);
        //M->3 큰 수부터 117, 126, 135, 144.. 225, 234..., 333..
        //근데 생각해보니까 백의 자리보다 십의자리 수가 낮을 수 없다.

        //계산 로직
        getPrefixSum = getInts(N, list);
        logic(M, group);
        double end = (double) N / M * Math.pow(10, M);
        for(;;){
            start++;
            List<Integer> list1 = Arrays.stream(String.valueOf(start).split("")).mapToInt(Integer::parseInt).boxed().toList();
            boolean flag = false;
            for(int i=list1.size()-1; i>0; i--){
                //System.out.println("sum = " + sum);
                //System.out.println("N = " + N);
                if( N != list1.stream().mapToInt(Integer::intValue).sum()) flag = true;
                if( list1.size() > M ) flag = true;
                if(list1.get(i) < list1.get(i-1)){
                    flag = true; //걸러야할 수
                    continue;
                }
                if(flag) break;
            }
            if(!flag){
                //System.out.println("start = " + start);
                logic(M, list1);
            }
            if(start == end) break;

        }

        System.out.println(answer);
    }
    static int[] getPrefixSum = new int[N+1];
    private static void logic(int M, List<Integer> group) {
        int[] prefixSum = getPrefixSum;
        int current = 0;
        int big = 0;
        for (int i = 0; i < M; i++) {
            Integer num = group.get(i);
            int split = prefixSum[current + num] - prefixSum[current]; // 누적 합을 사용해 계산
            current += num;
            //System.out.println("split = " + split);
            if(big < split) big = split;
            //System.out.println("big = " + big);
        }
        answer = Math.min(answer, big);
        //System.out.println("answer = " + answer);
    }

    private static int[] getInts(int N, List<Integer> list) {
        int[] prefixSum = new int[N + 1]; // 0부터 N까지 저장 (0-indexed)
        for (int i = 0; i < N; i++) {
            prefixSum[i + 1] = prefixSum[i] + list.get(i);
        }
        getPrefixSum = prefixSum;
        return prefixSum;
    }
}
