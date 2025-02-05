package org.example;



import java.util.*;

class TodaySolution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = Integer.parseInt(sc.nextLine());
        List<Integer> list = new ArrayList<>(Arrays.stream(sc.nextLine().split(" "))
                .map(Integer::parseInt).toList());

        Collections.sort(list);

        int solIter = Integer.parseInt(sc.nextLine());
        List<Integer> findList = new ArrayList<>(Arrays.stream(sc.nextLine().split(" "))
                .map(Integer::parseInt).toList());

        int[] arr = new int[solIter];

        for (int i = 0; i < solIter; i++) {
            int start = 0;
            int end = list.size() - 1;
            int target = findList.get(i);
            boolean found = false;

            while (start <= end) {
                int mid = (start + end) / 2;
                if (list.get(mid) == target) {
                    found = true;
                    break;
                } else if (list.get(mid) < target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }

            arr[i] = found ? 1 : 0;
        }

        for (int i : arr) {
            System.out.println(i);
        }
    }
}
