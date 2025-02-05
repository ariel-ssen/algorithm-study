package org.example;

import java.awt.*;
import java.util.*;
import java.util.List;

class WeeklySolution {
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1}; // 상, 하, 좌, 우
    static int[] dy = {1, 0, -1, 0};
    static int[][] arr;
    static List<Integer> complexSizes = new ArrayList<>();

    public static void main(String[] args) {
        // 백준 2667 - 단지번호붙이기 (BFS 방식)
        solution();
    }

    public static void solution() {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine()); // 지도의 크기
        arr = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            arr[i] = Arrays.stream(sc.nextLine().split("")).mapToInt(Integer::parseInt).toArray();
        }

        int complexCount = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 1 && !visited[i][j]) {
                    complexCount++;
                    int size = bfs(n, i, j);
                    complexSizes.add(size);
                }
            }
        }

        // 결과 출력
        Collections.sort(complexSizes);
        System.out.println(complexCount);
        for (int size : complexSizes) {
            System.out.println(size);
        }
    }

    public static int bfs(int n, int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        visited[x][y] = true;

        int count = 1; // 단지 내 집 개수

        while (!queue.isEmpty()) {
            Point p = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < n) { // 범위 체크
                    if (arr[nx][ny] == 1 && !visited[nx][ny]) {
                        queue.add(new Point(nx, ny));
                        visited[nx][ny] = true;
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
