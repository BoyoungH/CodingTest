class Solution {
    public int solution(int n, int[][] computers) {
        int count = 0;
        boolean[] visited = new boolean[n];
        // 모든 노드 순회하기
        for(int i=0; i<n; i++){
            if(!visited[i]){ 
                dfs(i, visited, computers); // 연결되어 있는 네트워크 하나 계산 끝
                count++;
            }
        }
        return count;
    }
    public void dfs(int start, boolean[] visited, int[][] computers){
        visited[start] = true;
        
        for(int j=0; j<computers.length; j++){
            if(computers[start][j] ==1 && !visited[j]){
                dfs(j, visited, computers);
            }
        }
    }
}