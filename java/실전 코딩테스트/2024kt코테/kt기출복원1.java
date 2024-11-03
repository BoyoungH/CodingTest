// import java.util.*;

// public class kt기출복원1 {

//     static int[] satisfactions;
//     static List<Integer> holidayList;
//     static List<Integer> vacationDays;
//     static int maxScore;

//     public static int maxSatisfactionScore(int k) {
//         maxScore = Integer.MIN_VALUE;
//         vacationDays = new ArrayList<>();

//         // 연차를 쓸 위치를 k개 고르는 조합
//         calculateMaxScore(k, 0);
//         return maxScore;
//     }

//     private static void calculateMaxScore(int k, int start) {
//         if (vacationDays.size() == k) {
//             List<Integer> allDaysOff = new ArrayList<>(holidayList);
//             allDaysOff.addAll(vacationDays);
//             Collections.sort(allDaysOff);
            
//             // 점수 계산
//             int score = 0, sum = 0, count = 0;
//             for (int i = 0; i < allDaysOff.size(); i++) {
//                 if (i > 0 && allDaysOff.get(i) != allDaysOff.get(i - 1) + 1) {
//                     score += sum * count;
//                     sum = 0;
//                     count = 0;
//                 }
//                 sum += satisfactions[allDaysOff.get(i)];
//                 count++;
//             }
//             score += sum * count; // 마지막 구간 점수 추가
//             maxScore = Math.max(maxScore, score);
//             return;
//         }

//         for (int i = start; i < satisfactions.length; i++) {
//             if (!holidayList.contains(i)) { // 이미 고정된 휴일이 아닌 날만 연차로 선택
//                 vacationDays.add(i);
//                 calculateMaxScore(k, i + 1);
//                 vacationDays.remove(vacationDays.size() - 1);
//             }
//         }
//     }

//     public static void main(String[] args) {
//         // 첫 번째 테스트 케이스
//         satisfactions = new int[]{1, 2, 3, 1, -10, -30, -40, 40, -12, -22, -1, -1, 12, 3, 4, 3, -10, 0, 0, 1, -13, 19, 4, -9, 3, -1, -2, -1, 10, 4};
//         int[] holidays1 = {11, 12, 15, 16, 22};
//         holidayList = new ArrayList<>();
//         for (int day : holidays1) {
//             holidayList.add(day - 1); // 0부터 시작하는 인덱스로 변환
//         }
//         System.out.println("Result 1: " + maxSatisfactionScore(3)); // Expected: 179

//         // 두 번째 테스트 케이스
//         satisfactions = new int[]{-10, -4, -2, -10, -1, -42, -10, 9, -1, -2, -1, -1, 15, -32, -12, -11, -10, 0, 0, -10, -10, -14, -1, -5, -2, -1, -2, -4, 0, 0};
//         int[] holidays2 = {4, 7, 16, 17, 22, 26};
//         holidayList = new ArrayList<>();
//         for (int day : holidays2) {
//             holidayList.add(day - 1);
//         }
//         System.out.println("Result 2: " + maxSatisfactionScore(5)); // Expected: -25
//     }
// }


import java.util.*;

// 백트래킹 -> 재귀법, 조합 -> 백트래킹, 뒤에 푼 슬라이드 윈도우보다 비효율적일 수 있음
// n과 k가 크지 않는 경우에만 할 수 있음 (보통 백트래킹은 n이 100만 이하인 경우 활용 가능, 여기서는 k도 고려하기)
// k만큼 뽑을 수 있는 조합을 만들어서 계산하여 최대값 갱신
// 해당 문제에서는 n이 30으로 고정되어 있고 k가 5이하일 때만 사용하는게 좋음
// 이렇게 풀면 시간초과로 틀렸을 것!

class Solution {
    private int[] satisfactions;
    private List<Integer> holidayList;
    private int maxScore;

    public int solution(int[] satisfactions, int[] holidays, int k) {
        this.satisfactions = satisfactions;
        this.holidayList = new ArrayList<>();
        for (int day : holidays) {
            holidayList.add(day - 1); // 0부터 시작하는 인덱스로 변환
        }

        this.maxScore = Integer.MIN_VALUE;
        List<Integer> vacationDays = new ArrayList<>();
        calculateMaxScore(k, 0, vacationDays);
        
        return maxScore;
    }

    private void calculateMaxScore(int k, int start, List<Integer> vacationDays) {
        if (vacationDays.size() == k) {
            List<Integer> allDaysOff = new ArrayList<>(holidayList);
            allDaysOff.addAll(vacationDays);
            Collections.sort(allDaysOff);
            
            // 점수 계산
            int score = 0, sum = 0, count = 0;
            for (int i = 0; i < allDaysOff.size(); i++) {
                if (i > 0 && allDaysOff.get(i) != allDaysOff.get(i - 1) + 1) {
                    score += sum * count;
                    sum = 0;
                    count = 0;
                }
                sum += satisfactions[allDaysOff.get(i)];
                count++;
            }
            score += sum * count; // 마지막 구간 점수 추가
            maxScore = Math.max(maxScore, score);
            return;
        }

        for (int i = start; i < satisfactions.length; i++) {
            if (!holidayList.contains(i)) { // 이미 고정된 휴일이 아닌 날만 연차로 선택
                vacationDays.add(i);
                calculateMaxScore(k, i + 1, vacationDays);
                vacationDays.remove(vacationDays.size() - 1);
            }
        }
    }
}
