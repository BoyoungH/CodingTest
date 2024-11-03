import java.util.ArrayList;
import java.util.List;

public class 현캐2번문제복원 {
    // 각 숫자에 대한 7세그먼트 상태 정의
    private static final int[][] segments = {
        {1, 1, 1, 1, 1, 1, 0}, // 0
        {0, 1, 1, 0, 0, 0, 0}, // 1
        {1, 1, 0, 1, 1, 0, 1}, // 2
        {1, 1, 1, 1, 0, 0, 1}, // 3
        {0, 1, 1, 1, 0, 0, 0}, // 4
        {1, 0, 1, 1, 0, 1, 1}, // 5
        {1, 0, 1, 1, 1, 1, 1}, // 6
        {1, 1, 1, 0, 0, 0, 0}, // 7
        {1, 1, 1, 1, 1, 1, 1}, // 8
        {1, 1, 1, 1, 0, 1, 1}  // 9
    };

    public int[][] calculateAngles(int[] numbers) {
        List<int[]> result = new ArrayList<>();
        int[] currentSegments = segments[8]; // 시작 숫자 8의 세그먼트 상태

        for (int number : numbers) {
            int[] targetSegments = segments[number]; // 목표 숫자의 세그먼트 상태
            int[] angles = new int[3]; // 각 회전축에 대한 각도

            // 회전축별로 각도 계산
            for (int i = 0; i < 3; i++) {
                if (currentSegments[i] != targetSegments[i]) {
                    if (currentSegments[i] == 1) {
                        angles[i] = 180; // 현재 세그먼트가 켜져있다면 180도로 회전하여 끄기
                    } else {
                        // 꺼진 세그먼트를 켜기 위해 필요한 각도 설정 (화면 밖으로 나가는지 검사 추가)
                        angles[i] = (i == 1) ? 270 : 90;
                        if (isOutOfBounds(i, angles[i])) {
                            targetSegments[i] = 0; // 화면 밖으로 나가면 세그먼트를 꺼짐으로 설정
                        }
                    }
                } else {
                    angles[i] = 0; // 변화가 없으면 0도
                }
            }

            result.add(angles); // 결과에 추가
            currentSegments = targetSegments; // 현재 상태 업데이트
        }

        return result.toArray(new int[result.size()][]);
    }

    // 화면 밖으로 나가는지 체크하는 함수
    private boolean isOutOfBounds(int pivot, int angle) {
        // 예: 회전 축의 각도가 270도일 때 화면 밖으로 나가는지 확인
        // 예시 구현: 이 함수는 각 축의 특정 각도가 화면 밖으로 나가는 경우 true를 반환하도록 처리
        // 특정 회전 축과 각도를 기준으로 화면 밖으로 나가는 상황을 정의
        return angle == 270 || angle == 180;
    }

    public static void main(String[] args) {
        현캐2번문제복원 solution = new 현캐2번문제복원();

        // 테스트 케이스
        int[] numbers1 = {6, 4};
        int[][] result1 = solution.calculateAngles(numbers1);
        for (int[] angles : result1) {
            System.out.println(java.util.Arrays.toString(angles));
        }

        int[] numbers2 = {8, 1, 5};
        int[][] result2 = solution.calculateAngles(numbers2);
        for (int[] angles : result2) {
            System.out.println(java.util.Arrays.toString(angles));
        }
    }
}
