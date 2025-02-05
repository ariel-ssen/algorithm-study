import java.util.*;

public class 기타_레슨 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] lessons = new int[N];

        int maxLesson = 0;
        int totalLength = 0;

        for (int i = 0; i < N; i++) {
            lessons[i] = sc.nextInt();
            if (lessons[i] > maxLesson) {
                maxLesson = lessons[i];
            }
            totalLength += lessons[i];
        }

        int left = maxLesson;
        int right = totalLength;
        int result = right;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (canDivide(lessons, N, M, mid)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(result);
    }

    private static boolean canDivide(int[] lessons, int N, int M, int size) {
        int count = 1;
        int sum = 0;

        for (int i = 0; i < N; i++) {
            if (sum + lessons[i] > size) {
                count++;
                sum = lessons[i];

                if (count > M) {
                    return false;
                }
            } else {
                sum += lessons[i];
            }
        }

        return true;
    }
}
