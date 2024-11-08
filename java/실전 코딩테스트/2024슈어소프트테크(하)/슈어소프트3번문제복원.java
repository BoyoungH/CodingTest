import java.util.*;
/*
 * DP와 이진탐색 -> 난이도 골드3~4 정도
 * 알바 끝날 기준 정렬 (이진탐색 전에 정렬 과정 필요)
 * dp 배열은 인덱스에 상관없이 이제껏 가장 큰 profit으로 계속 갱신 -> dp 마지막 값이 최대수익
 * 현재 profit은 includeProfit에 저장해놓고 이전 알바 dp에 더하면서 최대값 갱신
 */
public class 슈어소프트3번문제복원 {
    public static void main(String[] args) {
        // 예제 입력
        int[][] part_times = {{3, 6, 3}, {2, 4, 2}, {10, 12, 8}, {11, 15, 5}, {1, 8, 10}, {12, 13, 1}};

        // 최대 수익 계산
        int result = solution(part_times);

        // 결과 출력
        System.out.println("최종 최대 수익: " + result);
    }

    public static int solution(int[][] part_times) {
        // part_times 배열을 끝나는 날짜를 기준으로 정렬
        Arrays.sort(part_times, (a, b) -> Integer.compare(a[1], b[1]));

        int n = part_times.length;
        int[] dp = new int[n];
        dp[0] = part_times[0][2];  // 첫 번째 아르바이트의 급여로 초기화
        // System.out.println("초기 상태: ");
        // System.out.println("아르바이트 [" + part_times[0][0] + ", " + part_times[0][1] + "] 급여: " + part_times[0][2]);
        // System.out.println("dp[0] = " + dp[0]);

        for (int i = 1; i < n; i++) {
            // System.out.println("\n아르바이트 [" + part_times[i][0] + ", " + part_times[i][1] + "] 급여: " + part_times[i][2]);
            int includeProfit = part_times[i][2];
            int lastNonConflicting = findLastNonConflicting(part_times, i);

            if (lastNonConflicting != -1) {
                includeProfit += dp[lastNonConflicting];
                // System.out.println("겹치지 않는 마지막 아르바이트 인덱스: " + lastNonConflicting + ", 누적 수익: " + dp[lastNonConflicting]);
            } else {
                // System.out.println("겹치지 않는 아르바이트가 없음");
            }

            dp[i] = Math.max(includeProfit, dp[i - 1]);
            // System.out.println("dp[" + i + "] (현재 최대 수익) = " + dp[i]);
        }

        return dp[n - 1];
    }

    // 이진 탐색을 통해 현재 아르바이트와 겹치지 않는 마지막 아르바이트의 인덱스를 찾음
    private static int findLastNonConflicting(int[][] part_times, int i) {
        int low = 0, high = i - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            // System.out.println("  이진 탐색 중 - low: " + low + ", high: " + high + ", mid: " + mid);
            if (part_times[mid][1] <= part_times[i][0]) { // 이전 것의 끝나는 날짜와 현재의 시작날짜를 비교(이전 끝 날짜가 현재 시작날짜보다 앞서 있거나 같아야함)
                if (mid == i - 1 || part_times[mid + 1][1] > part_times[i][0]) {
                    // System.out.println("  이전 가능한 마지막 아르바이트 찾음: 인덱스 " + mid);
                    return mid;
                }
                low = mid + 1;
            } else {
                high = mid - 1; // 알바 끝날짜 기준으로 정렬되어 있기 때문에 part_times[mid][1](mid의 끝날짜)가 현재 시작날짜보다 크면 high 기준점을 하나 내려서 그 더 작은 끝날짜를 찾아 탐색
            }
        }
        return -1;
    }
}
