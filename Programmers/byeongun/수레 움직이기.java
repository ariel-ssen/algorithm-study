package org.example;

import java.awt.*;
import java.util.*;
import java.util.List;

public class WeeklySolution {
    static boolean[][] redVisited;
    static boolean[][] blueVisited;
    static Point redStart = null;
    static Point blueStart = null;
    static Point redHome = null;
    static Point blueHome = null;
    static int answer = Integer.MAX_VALUE;

    static int[] dx = {0, 1, 0, -1, 0}; //사방위 + 가만히 있기
    static int[] dy = {1, 0, -1, 0, 0};


    public static void main(String[] args) {
        int[][] maze = {
                {1,5}, {2, 5}, {4, 5}, {3, 5}
        };
        int solution = solution(maze);
    }

    public static int solution(int[][] maze) {
        int col = maze.length;
        int row = maze[0].length;
        List<Point> block = new ArrayList<>();

        for (int i = 0; i < col * row; i++) {
            int x = i / row;
            int y = i % row;
            switch (maze[x][y]) {
                case 1 -> redStart = new Point(x, y);
                case 2 -> blueStart = new Point(x, y);
                case 3 -> redHome = new Point(x, y);
                case 4 -> blueHome = new Point(x, y);
                case 5 -> block.add(new Point(x, y));
            }
        }

        redVisited = new boolean[col][row];
        blueVisited = new boolean[col][row];
        for (Point p : block) {
            redVisited[p.x][p.y] = true;
            blueVisited[p.x][p.y] = true;
        }
        redVisited[redStart.x][redStart.y] = true;
        blueVisited[blueStart.x][blueStart.y] = true;

        dfs(redStart, blueStart, 0);

        return answer == Integer.MAX_VALUE ? 0 : answer;
    }

    private static void dfs(Point red, Point blue, int count) {
        // 종료 조건: 두 공이 각자의 목적지에 도달했을 때
        if (red.equals(redHome) && blue.equals(blueHome)) {
            answer = Math.min(answer, count);
            return;
        }

        for (int i = 0; i < 5; i++) { // 빨간 공의 방향
            for (int j = 0; j < 5; j++) { // 파란 공의 방향
                if(i==4 && j==4) continue; // 둘 다 가만히 있으면 안됨
                Point newRed = move(red, i, redVisited); // 빨간 공 이동
                Point newBlue = move(blue, j, blueVisited); // 파란 공 이동

                // 두 공이 같은 위치에 있을 수 없음
                if (newRed.equals(newBlue)) continue;
                if(newRed.equals(blue) && newBlue.equals(red)) continue; // 스위칭 방지
                if(newRed.equals(redHome)) redVisited[redHome.x][redHome.y] = false;
                else if(newBlue.equals(blueHome)) blueVisited[blueHome.x][blueHome.y] = false;

                // 두 공이 방문하지 않은 곳으로 이동한 경우 DFS 호출
                if (!redVisited[newRed.x][newRed.y] && !blueVisited[newBlue.x][newBlue.y]) {
                    redVisited[newRed.x][newRed.y] = true;
                    blueVisited[newBlue.x][newBlue.y] = true;
                    dfs(newRed, newBlue, count + 1);

                    // 방문 복원
                    redVisited[newRed.x][newRed.y] = false;
                    blueVisited[newBlue.x][newBlue.y] = false;
                }
            }
        }
    }

    // 특정 공을 이동시키는 함수 (변경 없음)
    private static Point move(Point point, int dir, boolean[][] visited) {
        int nx = point.x + dx[dir];
        int ny = point.y + dy[dir];

        // 목적지에 도달했거나 맵 범위를 벗어나거나 장애물이 있는 경우 현재 위치 유지
        if (nx < 0 || ny < 0 || nx >= visited.length || ny >= visited[0].length || visited[nx][ny]) {
            return point;
        }
        return new Point(nx, ny);
    }
}
