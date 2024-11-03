import java.util.*;

//모르겠다..

public class 현캐4번문제복원 {
    static int n, m;
    static int[][] grid;
    static List<int[]> walls;
    static int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // 동, 남, 서, 북 방향

    public static void main(String[] args) {
        n = 6;
        m = 3;
        walls = Arrays.asList(new int[][]{
            {2, 0, 2, 2},
            {3, 1, 3, 3},
            {3, 1, 5, 1}
        });

        System.out.println(getMaxDistanceWithExtraWall(n, m, walls));
    }

    // 추가 벽을 놓았을 때 도달할 수 있는 최대 이동 횟수를 계산
    public static int getMaxDistanceWithExtraWall(int n, int m, List<int[]> walls) {
        // 초기 격자와 벽 설정
        grid = new int[n][m];
        for (int[] wall : walls) {
            if (wall.length == 4) {
                setWall(wall, 1); // 기존 벽을 격자에 배치
            }
        }

        // 초기 최소 거리 계산 (0, 0)에서 (n-1, m-1)까지
        int initialDistance = bfs();

        int maxDistance = initialDistance;

        // 모든 후보 위치에 벽을 하나씩 추가해보고 최대 거리를 계산
        for (int[] candidateWall : getPossibleWalls()) {
            setWall(candidateWall, 1); // 벽 추가
            int newDistance = bfs(); // 새로 계산한 거리

            if (newDistance != -1) { // 목적지로 가는 경로가 존재할 때만 업데이트
                maxDistance = Math.max(maxDistance, newDistance);
            }

            setWall(candidateWall, 0); // 벽을 원래대로 제거
        }

        return maxDistance;
    }

    // BFS를 사용하여 (0, 0)에서 (n-1, m-1)로의 최단 경로 계산
    static int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        queue.offer(new int[]{0, 0, 0}); // x, y, 거리
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0], y = cell[1], dist = cell[2];

            if (x == n - 1 && y == m - 1) {
                return dist; // 목적지에 도착했을 때 거리 반환
            }

            for (int[] dir : directions) {
                int nx = x + dir[0];
                int ny = y + dir[1];

                if (isInBounds(nx, ny) && !visited[nx][ny] && grid[nx][ny] == 0) {
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny, dist + 1});
                }
            }
        }
        return -1; // 목적지에 도달할 수 없을 때
    }

    // 격자 내 범위 체크
    static boolean isInBounds(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    // 벽 설치 및 제거 함수
    static void setWall(int[] wall, int status) {
        if (wall == null || wall.length != 4) return; // 벽의 길이와 null 체크 추가

        if (wall[0] == wall[2]) { // 수직 벽
            for (int i = Math.min(wall[1], wall[3]); i <= Math.max(wall[1], wall[3]); i++) {
                grid[wall[0]][i] = status;
            }
        } else { // 수평 벽
            for (int i = Math.min(wall[0], wall[2]); i <= Math.max(wall[0], wall[2]); i++) {
                grid[i][wall[1]] = status;
            }
        }
    }

    // 벽을 놓을 수 있는 후보 위치 목록 생성 (예시로 빈 목록 반환)
    static List<int[]> getPossibleWalls() {
        List<int[]> possibleWalls = new ArrayList<>();
        // 실제 구현에서는 가능한 벽 위치를 추가
        return possibleWalls;
    }
}
