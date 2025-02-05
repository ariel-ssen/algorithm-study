package org.example;

import java.awt.*;
import java.util.*;
import java.util.List;

class WeeklySolution {
    public static void main(String[] args) {
        //두 용액 - 2470
        solution();
    }

    public static void solution() {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        List<Integer> list = new ArrayList<>();
        String[] split = sc.nextLine().split(" ");
        for (String s : split) {
            list.add(Integer.parseInt(s));
        }

        Collections.sort(list);

        Point solution = new Point(0, 0);
        int sol = Integer.MAX_VALUE;

        int start = 0;
        int end = list.size() - 1;

        while (start < end) {
            int temp = list.get(start) + list.get(end);

            if (Math.abs(temp) < Math.abs(sol)) {
                sol = temp;
                solution = new Point(list.get(start), list.get(end));
            }

            if (temp == 0) {
                break;
            } else if (temp > 0) {
                end--;
            } else {
                start++;
            }
        }

        System.out.println(Math.min(solution.x, solution.y) + " " + Math.max(solution.x, solution.y));
    }
}
