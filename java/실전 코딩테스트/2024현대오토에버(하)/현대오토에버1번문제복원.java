import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/* 현재 위치에서 가능한 속도 범위를 모두 탐색하여 위치를 계산하고 (목적지,0)에 가장 먼저 도착하는 time-1을 return하기
* 처음에는 boolean[][] visited = new boolean[N + 1][K * 2 + 1]; 이렇게 했는데 
* boolean[속도][가감속도 경우의 수] 이렇게 되니까 속도 변화의 가능한 모든 범위를 고려하지 않음
* 따라서, 해쉬셋으로 접근
* visited 사용 이유 : 각 위치와 속도 조합에 대해 방문 여부를 기록하여, 동일한 위치와 속도로 다시 방문하지 않게 하기 위함
* cf) (7,2)와(7,1) -> 위치 7에 올 수 있는 속도 조합이 다르면 괜찮지만 같은 경우는 배제해서 최단거리 확보
*/

public class 현대오토에버1번문제복원 {

    public static int minTimeToReachN(int N, int K) { // bfs로 풀이
        Queue<State> queue = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();

        queue.offer(new State(1, 0, 0));
        visited.add("1,0");

        // System.out.println("Start: 1,0,0");

        while (!queue.isEmpty()) {
            State current = queue.poll();
            // System.out.println("Processing: " + current.position + "," + current.speed + "," + current.time);

            if (current.position == N && current.speed == 0) {
                // System.out.println("Reached: " + N + ",0," + current.time);
                return current.time-1;
            }

            for (int deltaSpeed = -K; deltaSpeed <= K; deltaSpeed++) {
                int newSpeed = current.speed + deltaSpeed;
                if (newSpeed < 0) continue;

                int newPosition = current.position + newSpeed;
                if (newPosition <= 0 || newPosition > N) continue;

                String stateKey = newPosition + "," + newSpeed;
                if (!visited.contains(stateKey)) {
                    visited.add(stateKey);
                    queue.offer(new State(newPosition, newSpeed, current.time + 1));
                    // System.out.println("Enqueue: " + newPosition + "," + newSpeed + "," + (current.time + 1));
                }
            }
        }
        // System.out.println("Not reachable");
        return -1;
    }

    public static void main(String[] args) {
        int N1 = 9, K1 = 2;
        int N2 = 23, K2 = 2;
        int N3 = 10, K3 = 1;

        System.out.println("Result for (9, 2): " + minTimeToReachN(N1, K1)); // Expected: 3
        System.out.println("Result for (23, 2): " + minTimeToReachN(N2, K2)); // Expected: 6
        System.out.println("Result for (10, 1): " + minTimeToReachN(N3, K3)); // Expected: 5
    }
}

class State {
    int position;
    int speed;
    int time;

    public State(int position, int speed, int time) {
        this.position = position;
        this.speed = speed;
        this.time = time;
    }
}

// TestCase1
// Start: 1,0,0
// Processing: 1,0,0
// Enqueue: 2,1,1
// Enqueue: 3,2,1
// Processing: 2,1,1
// Enqueue: 2,0,2
// Enqueue: 3,1,2
// Enqueue: 4,2,2
// Enqueue: 5,3,2
// Processing: 3,2,1
// Enqueue: 3,0,2
// Enqueue: 4,1,2
// Enqueue: 5,2,2
// Enqueue: 6,3,2
// Enqueue: 7,4,2
// Processing: 2,0,2
// Processing: 3,1,2
// Processing: 4,2,2
// Enqueue: 4,0,3
// Enqueue: 5,1,3
// Enqueue: 6,2,3
// Enqueue: 7,3,3
// Enqueue: 8,4,3
// Processing: 5,3,2
// Enqueue: 6,1,3
// Enqueue: 7,2,3
// Enqueue: 8,3,3
// Enqueue: 9,4,3
// Processing: 3,0,2
// Processing: 4,1,2
// Processing: 5,2,2
// Enqueue: 5,0,3
// Processing: 6,3,2
// Enqueue: 7,1,3
// Enqueue: 8,2,3
// Enqueue: 9,3,3
// Processing: 7,4,2
// Enqueue: 9,2,3
// Processing: 4,0,3
// Processing: 5,1,3
// Processing: 6,2,3
// Enqueue: 6,0,4
// Processing: 7,3,3
// Enqueue: 8,1,4
// Processing: 8,4,3
// Processing: 6,1,3
// Processing: 7,2,3
// Enqueue: 7,0,4
// Processing: 8,3,3
// Enqueue: 9,1,4
// Processing: 9,4,3
// Processing: 5,0,3
// Processing: 7,1,3
// Processing: 8,2,3
// Enqueue: 8,0,4
// Processing: 9,3,3
// Processing: 9,2,3
// Enqueue: 9,0,4
// Processing: 6,0,4
// Processing: 8,1,4
// Processing: 7,0,4
// Processing: 9,1,4
// Processing: 8,0,4
// Processing: 9,0,4
// Reached: 9,0,4
// Result for (9, 2): 3
