public class LG문제복원2번 {
    // 이동 방향을 왼쪽 → 아래쪽 → 오른쪽 → 한 칸 위 → 왼쪽 → 위쪽 → 오른쪽 → 한 칸 아래로 설정
    // dx는 행(위아래), dy는 열(좌우)을 의미
    private static final int[] dx = {0, 1, 0, -1, 0, -1, 0, 1};  // 이동하는 방향의 행 변화
    private static final int[] dy = {-1, 0, 1, 0, -1, 0, 1, 0};  // 이동하는 방향의 열 변화

    public static int[][] solution(int r, int c) {
        int[][] result = new int[r][c];  // 결과를 저장할 배열
        boolean[][] visited = new boolean[r][c];  // 방문 여부를 기록할 배열

        int x = 0, y = c - 1;  // 시작 위치는 (0, c-1) (오른쪽 상단에서 시작)
        int number = 1;  // 방문 순서 번호

        // 초기 방향을 설정: 0 (왼쪽으로 이동 시작)
        int direction = 0;

        // 배열을 채울 때까지 반복
        while (number <= r * c) {
            // 현재 위치에 번호 기록
            result[x][y] = number++;
            visited[x][y] = true;  // 방문 처리

            // 다음 좌표 계산
            int nextX = x + dx[direction];
            int nextY = y + dy[direction];

            // 다음 좌표가 범위를 벗어나거나 방문한 셀이면 방향을 전환
            if (nextX < 0 || nextX >= r || nextY < 0 || nextY >= c || visited[nextX][nextY]) {
                // 방향을 바꾸는 순서에 맞춰서 전환
                direction = (direction + 1) % 8;
                nextX = x + dx[direction];
                nextY = y + dy[direction];
            }

            // 다음 좌표로 이동
            x = nextX;
            y = nextY;
        }

        return result;
    }

    // 결과를 출력하는 메서드
    public static void printResult(int[][] result) {
        for (int[] row : result) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    // 메인 메서드 테스트 실행
    public static void main(String[] args) {
        int[][] result = solution(5, 4);  // r = 5, c = 4
        printResult(result);
    }
}
