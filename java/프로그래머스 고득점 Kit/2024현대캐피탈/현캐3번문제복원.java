import java.util.*;

class Solution {
    public int solution(int[][] part_times) {
        int n = part_times.length;

        Arrays.sort(part_times, (a, b) -> Integer.compare(a[1], b[1]));

        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            dp[i] = part_times[i][2];
            for (int j = 0; j < i; j++) { // i가 현재, j는 이전 것 -> 바로 직전 것(연속되는 것) 아님에 유의
                if (part_times[i][0] >= part_times[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + part_times[i][2]);
                }
            }
        }

        // 최대 수익을 찾기 -> 맞는 최대 조합을 찾아내는 것이기 때문에 dp값 중에 최대 값 찾기
        int maxEarnings = 0;
        for (int earnings : dp) {
            maxEarnings = Math.max(maxEarnings, earnings);
        }

        return maxEarnings;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] part_times1 = {
            {3, 6, 3},
            {2, 4, 2},
            {10, 12, 8},
            {11, 15, 5},
            {1, 8, 10},
            {12, 13, 1}
        };
        System.out.println(solution.solution(part_times1)); // 결과: 19

        int[][] part_times2 = {
            {1, 2, 1},
            {1, 2, 2},
            {2, 3, 1},
            {3, 4, 1},
            {1, 4, 2}
        };
        System.out.println(solution.solution(part_times2)); // 결과: 4
    }
}
