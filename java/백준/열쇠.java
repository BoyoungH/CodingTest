import java.io.*;
import java.util.*;

public class 열쇠 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static char[][] map;
    static int h, w;
    static Set<Character> keys;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            // 패딩을 위해 (h+2) x (w+2) 크기의 맵 생성
            map = new char[h + 2][w + 2];
            keys = new HashSet<>(); // 열쇠 목록

            // 맵을 '.'으로 초기화 (빈 공간)
            for (int i = 0; i < h + 2; i++) {
                Arrays.fill(map[i], '.');
            }

            // 입력 맵을 (1,1)부터 복사
            for (int i = 1; i <= h; i++) {
                String str = br.readLine();
                for (int j = 1; j <= w; j++) {
                    map[i][j] = str.charAt(j - 1);
                }
            }

            // 초기 열쇠 입력 처리
            String keyInput = br.readLine();
            if (!keyInput.equals("0")) {
                for (char key : keyInput.toCharArray()) {
                    keys.add(key);
                }
            }

            sb.append(bfs()).append('\n');
        }

        System.out.print(sb.toString());
    }

    static int bfs() {
        Queue<Node> q = new LinkedList<>(); // 사방위 탐색 위치, 오로지 count만 세는거기 때문에 .길을 이어갈 필요가 없음
        boolean[][] visited = new boolean[h + 2][w + 2]; // 왔던 길은 가지 않음
        Queue<Node>[] doors = new LinkedList[26]; // 똑같은 대문자 문이 여러개 나올 수 있음
        for (int i = 0; i < 26; i++) {
            doors[i] = new LinkedList<>();
        }

        // 패딩된 가장자리에서 BFS 시작 -> 경로가 중요한게 아니라 $수가 중요하기 때문
        q.add(new Node(0, 0));
        visited[0][0] = true;

        int count = 0;
        while (!q.isEmpty()) {
            Node now = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= h + 2 || ny >= w + 2) continue;
                if (visited[nx][ny] || map[nx][ny] == '*') continue;

                visited[nx][ny] = true;

                if (map[nx][ny] == '.') { // 갈 수 있는 방향
                    q.add(new Node(nx, ny));
                } else if (map[nx][ny] == '$') { // 달러 획득, 카운트 증가
                    count++;
                    q.add(new Node(nx, ny));
                } else if (Character.isLowerCase(map[nx][ny])) { // 소문자 -> 키
                    // 새로운 열쇠를 획득한 경우
                    if (!keys.contains(map[nx][ny])) {
                        keys.add(map[nx][ny]);
                        // 획득한 열쇠로 인해 열 수 있는 문을 다시 BFS 수행
                        while (!doors[map[nx][ny] - 'a'].isEmpty()) {
                            q.add(doors[map[nx][ny] - 'a'].poll());
                        }
                    }
                    q.add(new Node(nx, ny));
                } else if (Character.isUpperCase(map[nx][ny])) { //대문자 -> 문
                    // 문인 경우
                    if (keys.contains(Character.toLowerCase(map[nx][ny]))) {
                        q.add(new Node(nx, ny));
                    } else {
                        // 아직 열쇠가 없는 경우 -> doors[x] index가 키인 문 배열에 저장
                        doors[map[nx][ny] - 'A'].add(new Node(nx, ny));
                    }
                }
            }
        }

        return count;
    }

    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
