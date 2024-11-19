package TestSample;

import java.io.*;
import java.util.*;

class SofteerBootTest {
    static int N;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visited;
    static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        int countArea = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    int count = bfs(i, j);
                    answer.add(count);
                    countArea++;
                }
            }
        }

        // 결과 출력
        System.out.println(countArea);
        Collections.sort(answer);
        for (int areaSize : answer) {
            System.out.println(areaSize);
        }
    }

    static int bfs(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, y, 1));
        visited[x][y] = true;

        int count = 1; // 시작 지점 포함

        while (!q.isEmpty()) {
            Node c = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = c.x + dx[i];
                int ny = c.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;

                if (!visited[nx][ny] && map[nx][ny] == 1) {
                    q.add(new Node(nx, ny, c.count + 1));
                    visited[nx][ny] = true;
                    count++;
                }
            }
        }

        return count;
    }
}

class Node {
    int x;
    int y;
    int count;

    public Node(int x, int y, int count) {
        this.x = x;
        this.y = y;
        this.count = count;
    }
}
