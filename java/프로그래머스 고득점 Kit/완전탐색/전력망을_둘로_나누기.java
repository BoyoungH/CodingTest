package 완전탐색;

import java.util.*;

class Solution {
    static List<Integer>[] list;
    static boolean[] visited;
    
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        list = new ArrayList[n+1];
        
        for(int i=0; i<n+1; i++){
            list[i] = new ArrayList<>();
        }
        
        for(int[] e : wires) {
            list[e[0]].add(e[1]);
            list[e[1]].add(e[0]);
        }
        
        for(int[] e : wires) {
            // 특정 간선을 끊기 위해 값으로 삭제
            list[e[0]].remove((Integer) e[1]);
            list[e[1]].remove((Integer) e[0]);
            
            visited = new boolean[n+1];
            
            int count = bfs(1);  // 노드 1을 기준으로 BFS 탐색
            int result = Math.abs((n - count) - count);
            answer = Math.min(result, answer);  // 최솟값을 찾도록 수정
            
            // 삭제한 간선 복구
            list[e[0]].add(e[1]);
            list[e[1]].add(e[0]);
        }
        
        return answer;
    }
    
    int bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;
        int count = 1;
        
        while(!q.isEmpty()) {
            int c = q.poll();
            
            for(int neighbor : list[c]) {
                if(visited[neighbor]) continue;
                visited[neighbor] = true;
                q.add(neighbor);
                count++;
            }
        }
        
        return count;
    }
}

