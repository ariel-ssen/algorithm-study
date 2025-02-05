package org.example;
import java.util.Stack;

class TodayAlgorithm {
    // Programmers 154539 - 뒤에 있는 큰 수 찾기
    public static void main(String[] args) {
        int[] array = {2, 3, 3, 5};
        int[] solution = solution(array);
        for (int i : solution) {
            System.out.println("i = " + i);
        }
    }

    public static int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = numbers.length - 1; i >= 0; i--) {
            // 스택에서 현재 숫자보다 작거나 같은 값 제거
            while (!stack.isEmpty() && stack.peek() <= numbers[i]) {
                stack.pop();
            }

            // 스택이 비어 있으면 뒷 큰수가 없음(-1), 아니면 스택의 top이 뒷 큰수
            answer[i] = stack.isEmpty() ? -1 : stack.peek();

            // 현재 숫자를 스택에 추가
            stack.push(numbers[i]);
        }

        return answer;
    }
}
