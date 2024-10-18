import java.io.*;
import java.util.*;

public class 뱀과_사다리_게임 {
    static int N, M;
    static boolean[] visited;
    static int[] game;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        game = new int[101];
        visited = new boolean[101];

        for(int i=1; i<=100; i++){
            game[i] = i;
        }

        for(int i=0; i<N+M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            game[start] = end;
        }

        int answer = bfs();
        System.out.println(answer);


    }
    private static int bfs(){ // 처음 목적지에 도달한 경우가 최단경로가 됨
        Queue<Node> q = new LinkedList<>();
        Node now = new Node(1, 0);
        visited[now.index] = true;

        q.add(now);

        while(!q.isEmpty()){
            Node node = q.poll();

            if(node.index==100){
                return node.count;
            }
            
            for(int i=1; i<=6; i++){
                int nextIndex = node.index + i;
                if(nextIndex>100) continue;

                int next = game[nextIndex];

                if(!visited[next]){
                    visited[next] = true;
                    q.add(new Node(next, node.count+1));
                }
            }
        }

        return -1;
    }
}
class Node{
    int index;
    int count;
    public Node(int index, int count){
        this.index = index;
        this.count = count;
    }
}