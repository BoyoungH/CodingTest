package 스택큐;

import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0; // 전체 흐른 시간 -> 누적됌
        Queue<Integer> waiting = new LinkedList<>();
        Queue<Node> bridge = new LinkedList<>();
        List<Integer> passedTrucks = new ArrayList<>();
        
        // 대기 트럭 큐에 트럭을 추가합니다.
        for (int truck : truck_weights) {
            waiting.add(truck);
        }
        
        int totalWeightOnBridge = 0; // 다리 위에 있는 트럭들의 총 무게
        
        while (passedTrucks.size() < truck_weights.length) {
            // 1. 다리 위에 있는 트럭 이동 처리
            if (!bridge.isEmpty() && bridge.peek().time == answer) {
                Node passedTruck = bridge.poll();
                totalWeightOnBridge -= passedTruck.truck;
                passedTrucks.add(passedTruck.truck);
            }
            
            // 2. 대기 중인 트럭을 다리에 올릴 수 있는지 확인
            if (!waiting.isEmpty() && totalWeightOnBridge + waiting.peek() <= weight) {
                int truck = waiting.poll();
                bridge.add(new Node(truck, answer + bridge_length));
                totalWeightOnBridge += truck;
            }
            
            // 3. 시간 증가
            answer++;
        }
        
        return answer;
    }
}

class Node {
    int truck; // 트럭의 무게
    int time;  // 트럭이 다리를 완전히 건너는 시간 -> 현재 올라간 시각 + 다리의 길이(이만큼만 머물러야 함) 따라서 이 값이랑 현재 계속 갱신한 answer의 시각이 같으면 poll해줌
    
    public Node(int truck, int time) {
        this.truck = truck;
        this.time = time;
    }
}
