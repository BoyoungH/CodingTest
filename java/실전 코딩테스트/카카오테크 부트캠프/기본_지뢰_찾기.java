import java.io.*;
import java.util.*;

public class 기본_지뢰_찾기 {
    public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] graph = new int[N][M];
		int[] dx = {1, 1, 0, -1, -1, -1, 0, 1};  // 양 옆
		int[] dy = {0, 1, 1, 1, 0, -1, -1, -1}; // 위 아래
		
		for(int i=0; i<N; i++){
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++){
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int count=0;
		
		for(int i=0; i<N; i++){
			for(int j=0; j<M; j++){
				if(graph[i][j] == -1){
					for(int d=0; d<8; d++){
						int y = i + dy[d];
						int x = j + dx[d];
						
						if(x<0 || y<0 || x>=M || y>=N) continue; // 변경
						graph[x][y]++;
						count++;
					}
				}
			}
		}

        // for(int i=0; i<N; i++){
		// 	for(int j=0; j<M; j++){
        //         System.out.print(graph[i][j]);
        //     }
        //     System.out.println();
        // }
		
		System.out.println(count);
		
	}
}
