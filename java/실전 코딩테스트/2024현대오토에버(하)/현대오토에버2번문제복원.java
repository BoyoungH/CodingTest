// import java.util.LinkedList;
// import java.util.Queue;
// import java.util.Scanner;

// public class 현대오토에버2번문제복원 {

//     static int N, M, L, T;
//     static int[][][] map;
//     static int[][][] maxReward;
//     static boolean[][][][] visited;
//     static int[] dx = {1, 0, 0};
//     static int[] dy = {0, 1, 0};
//     static int[] dz = {0, 0, 1};

//     public static void main(String[] args) {
//         Scanner scanner = new Scanner(System.in);
//         N = scanner.nextInt();
//         M = scanner.nextInt();
//         L = scanner.nextInt();
//         T = scanner.nextInt();

//         map = new int[N][M][L];
//         maxReward = new int[N][M][L];
//         visited = new boolean[N][M][L][T + 1];

//         for (int i = 0; i < N; i++) {
//             for (int j = 0; j < M; j++) {
//                 for (int k = 0; k < L; k++) {
//                     map[i][j][k] = scanner.nextInt();
//                     maxReward[i][j][k] = -1; // 초기화
//                 }
//             }
//         }

//         int result = bfs();
//         System.out.println(result);
//     }

//     public static int bfs() {
//         Queue<State> queue = new LinkedList<>();
//         queue.offer(new State(0, 0, 0, 0, 0));
//         visited[0][0][0][0] = true;
//         maxReward[0][0][0] = 0;

//         int maxCollectedReward = -1;

//         while (!queue.isEmpty()) {
//             State current = queue.poll();

//             // 목표 지점 도달 시 최대 보상 갱신
//             if (current.x == N - 1 && current.y == M - 1 && current.z == L - 1) {
//                 maxCollectedReward = Math.max(maxCollectedReward, current.rewards);
//             }

//             // 3차원 이동 (x, y, z)
//             for (int i = 0; i < 3; i++) {
//                 int nx = current.x + dx[i];
//                 int ny = current.y + dy[i];
//                 int nz = current.z + dz[i];

//                 if (nx < 0 || nx >= N || ny < 0 || ny >= M || nz < 0 || nz >= L) continue;

//                 int nextObstacles = current.obstacles;
//                 int nextRewards = current.rewards;

//                 if (map[nx][ny][nz] == -1) {
//                     nextObstacles++;
//                 } else if (map[nx][ny][nz] > 0) {
//                     nextRewards += map[nx][ny][nz];
//                 }

//                 // 장애물 통과 제한 조건 확인
//                 if (nextObstacles > T) continue;

//                 // 이미 방문했더라도 더 높은 보상을 얻는 경우에만 큐에 추가
//                 if (!visited[nx][ny][nz][nextObstacles] || nextRewards > maxReward[nx][ny][nz]) {
//                     visited[nx][ny][nz][nextObstacles] = true;
//                     maxReward[nx][ny][nz] = nextRewards;
//                     queue.offer(new State(nx, ny, nz, nextObstacles, nextRewards));
//                 }
//             }
//         }

//         return maxCollectedReward;
//     }

//     static class State {
//         int x, y, z, obstacles, rewards;

//         public State(int x, int y, int z, int obstacles, int rewards) {
//             this.x = x;
//             this.y = y;
//             this.z = z;
//             this.obstacles = obstacles;
//             this.rewards = rewards;
//         }
//     }
// }

// 1. visited에 obstacle 고려 안하니까 결과 제대로 안나옴
// 2. maxReward 따로 안쓰니까 결과 제대로 안나옴
// 둘 중 어느 하나라도 없으면 결과 제대로 안나옴 -> 전부 테스트케이스1 결과 10만 나옴
// 10왜 나오는지 한번 살펴보기


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 현대오토에버2번문제복원 {

    static int N, M, L, T;
    static int[][][] map;
    static boolean[][][][] visited;
    static int[] dx = {1, 0, 0};
    static int[] dy = {0, 1, 0};
    static int[] dz = {0, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new int[N][M][L];
        visited = new boolean[N][M][L][T + 1];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < L; k++) {
                    map[i][j][k] = Integer.parseInt(st.nextToken());
                }
            }
        }

        int result = bfs();
        System.out.println("Maximum reward collected: " + result);
    }

    public static int bfs() {
        Queue<State> queue = new LinkedList<>();
        queue.offer(new State(0, 0, 0, 0, 0));
        visited[0][0][0][0] = true;

        int maxCollectedReward = -1;

        while (!queue.isEmpty()) {
            State current = queue.poll();

            // 목표 지점 도달 시 최대 보상 갱신
            if (current.x == N - 1 && current.y == M - 1 && current.z == L - 1) {
                maxCollectedReward = Math.max(maxCollectedReward, current.rewards);
            }

            // 3차원 이동 (x, y, z)
            for (int i = 0; i < 3; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];
                int nz = current.z + dz[i];

                // 지도 범위를 벗어나는 경우 무시
                if (nx < 0 || nx >= N || ny < 0 || ny >= M || nz < 0 || nz >= L) continue;

                int nextObstacles = current.obstacles;
                int nextRewards = current.rewards;

                // 장애물이 있는 경우, 통과 가능한지 확인
                if (map[nx][ny][nz] == -1) {
                    nextObstacles++;
                } else if (map[nx][ny][nz] > 0) { // 보상이 있는 경우 보상 추가
                    nextRewards += map[nx][ny][nz];
                }

                // 장애물 통과 제한 조건 확인
                if (nextObstacles > T) continue;

                // 장애물 수에 따라 방문 여부를 결정
                if (!visited[nx][ny][nz][nextObstacles]) {
                    visited[nx][ny][nz][nextObstacles] = true;
                    queue.offer(new State(nx, ny, nz, nextObstacles, nextRewards));
                }
            }
        }

        return maxCollectedReward;
    }

    static class State {
        int x, y, z, obstacles, rewards;

        public State(int x, int y, int z, int obstacles, int rewards) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.obstacles = obstacles;
            this.rewards = rewards;
        }
    }
}
