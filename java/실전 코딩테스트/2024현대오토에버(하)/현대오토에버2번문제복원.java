// 아래 문제는 bfs에서 visited 써서 최단거리를 확보하는 일반적인 문제가 아님
// 특정 위치에 이미 방문을 했더라도 멀리 돌아온 루트를 통해 보상이 최대가 된다면 다시 들려서 maxReward를 갱신시킴
// 아래 문제의 경우 bfs의 최단거리 문제가 아닌 bfs를 통해 최대보상 문제임으로 visited한 부분을 또 들려도 됌

/*
 * 결론!
 * 1. 최단거리문제가 아니고 최대보상문제임으로 특정 위치에 도착하는 여러 경로를 고려하여 최대보상인 경로로 다시
 *    방문할 수 있음, 하지만 최대보상이 갱신되지 않은 루트는 탐색에서 배제 가능
 * 2. maxReward, if (!visited[nx][ny][nz][nextObstacles] || nextRewards > maxReward[nx][ny][nz]) -> 이 부분들이 핵심
 * 3. visited[nx][ny][nz][nextObstacles] : 현재위치에 도달할 때, 해당 경로로 올 
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 현대오토에버2번문제복원 {

    static int N, M, L, T;
    static int[][][] map;
    static int[][][] maxReward;
    static boolean[][][][] visited;
    static int[] dx = {1, 0, 0};
    static int[] dy = {0, 1, 0};
    static int[] dz = {0, 0, 1};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();
        L = scanner.nextInt();
        T = scanner.nextInt();

        map = new int[N][M][L];
        maxReward = new int[N][M][L]; // 여러 경로를 통해서 해당 위치에 도착했을때 가장 큰 보상값으로 갱신(모든 경로 중 최대보상값)
        visited = new boolean[N][M][L][T + 1];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < L; k++) {
                    map[i][j][k] = scanner.nextInt();
                    maxReward[i][j][k] = -1; // 초기화
                }
            }
        }

        int result = bfs();
        System.out.println(result);
    }

    public static int bfs() {
        Queue<State> queue = new LinkedList<>();
        queue.offer(new State(0, 0, 0, 0, 0));
        visited[0][0][0][0] = true;
        maxReward[0][0][0] = 0;

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

                if (nx < 0 || nx >= N || ny < 0 || ny >= M || nz < 0 || nz >= L) continue;

                int nextObstacles = current.obstacles;
                int nextRewards = current.rewards;

                if (map[nx][ny][nz] == -1) {
                    nextObstacles++;
                } else if (map[nx][ny][nz] > 0) {
                    nextRewards += map[nx][ny][nz];
                }

                // 장애물 통과 제한 조건 확인
                if (nextObstacles > T) continue;

                // 이미 방문했더라도 더 높은 보상을 얻는 경우에만 큐에 추가 -> 각 경로마다 얻을 수 있는 보상이 다를 수 있으므로, 같은 위치라도 더 높은 보상을 얻는 경우에 다시 방문하여 경로를 탐색해야 gka
                if (!visited[nx][ny][nz][nextObstacles] || nextRewards > maxReward[nx][ny][nz]) {
                    visited[nx][ny][nz][nextObstacles] = true;
                    maxReward[nx][ny][nz] = nextRewards;
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
            this.rewards = rewards; // 현재 탐색 중인 경로로 왔을 때의 누적 보상 -> 다른 경로로 왔을 때의 최대 보상을 저장하는 변수로는 사용할 수 없음, 따라서 maxRewards 사용
        }
    }
}

// 1. visited에 obstacle 고려 안하니까 결과 제대로 안나옴
// 2. maxReward 따로 안쓰니까 결과 제대로 안나옴
// 둘 중 어느 하나라도 없으면 결과 제대로 안나옴 -> 전부 테스트케이스1 결과 10만 나옴
// 10왜 나오는지 한번 살펴보기


// import java.io.BufferedReader;
// import java.io.IOException;
// import java.io.InputStreamReader;
// import java.util.LinkedList;
// import java.util.Queue;
// import java.util.StringTokenizer;

// public class 현대오토에버2번문제복원 {

//     static int N, M, L, T;
//     static int[][][] map;
//     static boolean[][][][] visited;
//     static int[] dx = {1, 0, 0};
//     static int[] dy = {0, 1, 0};
//     static int[] dz = {0, 0, 1};

//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//         StringTokenizer st = new StringTokenizer(br.readLine());
//         N = Integer.parseInt(st.nextToken());
//         M = Integer.parseInt(st.nextToken());
//         L = Integer.parseInt(st.nextToken());
//         T = Integer.parseInt(st.nextToken());

//         map = new int[N][M][L];
//         visited = new boolean[N][M][L][T + 1];

//         for (int i = 0; i < N; i++) {
//             for (int j = 0; j < M; j++) {
//                 st = new StringTokenizer(br.readLine());
//                 for (int k = 0; k < L; k++) {
//                     map[i][j][k] = Integer.parseInt(st.nextToken());
//                 }
//             }
//         }

//         int result = bfs();
//         System.out.println("Maximum reward collected: " + result);
//     }

//     public static int bfs() {
//         Queue<State> queue = new LinkedList<>();
//         queue.offer(new State(0, 0, 0, 0, 0));
//         visited[0][0][0][0] = true;

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

//                 // 지도 범위를 벗어나는 경우 무시
//                 if (nx < 0 || nx >= N || ny < 0 || ny >= M || nz < 0 || nz >= L) continue;

//                 int nextObstacles = current.obstacles;
//                 int nextRewards = current.rewards;

//                 // 장애물이 있는 경우, 통과 가능한지 확인
//                 if (map[nx][ny][nz] == -1) {
//                     nextObstacles++;
//                 } else if (map[nx][ny][nz] > 0) { // 보상이 있는 경우 보상 추가
//                     nextRewards += map[nx][ny][nz];
//                 }

//                 // 장애물 통과 제한 조건 확인
//                 if (nextObstacles > T) continue;

//                 // 장애물 수에 따라 방문 여부를 결정
//                 if (!visited[nx][ny][nz][nextObstacles]) {
//                     visited[nx][ny][nz][nextObstacles] = true;
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
