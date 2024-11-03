import java.util.*;

//슬라이딩 윈도우 -> 최적해 기법(그리디 알고리즘과 함께 자주 쓰이기도 함)
//배열과 리스트 같이 연속된 데이터에서 고정된 크기나 가변 크기 부분 구간 탐색
//O(n) 굉장히 효율적
//1일~30일 모두 탐색 시 윈도우 크기만큼 이동하여 최대값 갱신하기


class Solution {
    public int solution(int[] satisfactions, int[] holidays, int k) {
        int n = satisfactions.length;
        boolean[] isHoliday = new boolean[n];
        
        // 고정된 휴일 표시
        for (int day : holidays) {
            isHoliday[day - 1] = true; // 0-based index로 변환
        }

        int maxScore = Integer.MIN_VALUE;

        // 슬라이딩 윈도우로 연차 구간을 이동하며 최대 만족도 계산
        for (int start = 0; start <= n - k; start++) {
            int score = calculateScoreWithVacation(satisfactions, isHoliday, start, start + k - 1);
            maxScore = Math.max(maxScore, score);
        }

        /* n-k가 27까지 나올 것, start+k-1이 구간 크기에 맞는 마지막 값
        1. 첫 번째 슬라이딩 윈도우: start=0에서 start+2까지 (1일부터 3일까지)
        2. 두 번째 슬라이딩 윈도우: start=1에서 start+3까지 (2일부터 4일까지)
        3. 마지막 슬라이딩 윈도우: start=27에서 start+29까지 (28일부터 30일까지)*/

        return maxScore;
    }

    private int calculateScoreWithVacation(int[] satisfactions, boolean[] isHoliday, int start, int end) {
        int score = 0;
        int currentSum = 0;
        int currentCount = 0;

        for (int i = 0; i < satisfactions.length; i++) {
            if (isHoliday[i] || (i >= start && i <= end)) {
                // 현재 날짜가 연차 구간이거나 고정된 휴일일 때
                if (currentCount > 0 && i > 0 && i != i - 1 + 1) {
                    score += currentSum * currentCount;
                    currentSum = 0;
                    currentCount = 0;
                }
                currentSum += satisfactions[i];
                currentCount++;
            }
        }
        score += currentSum * currentCount;

        return score;
    }
}
