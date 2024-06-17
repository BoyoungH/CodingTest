//문제 기억 안남
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 기본_가장_긴_계단_경로 {
    static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	static int N;
	static int[][] graph;
	static boolean[][] visited;
	static int max = Integer.MIN_VALUE;
	static int count = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		graph = new int[N][N];
		visited = new boolean[N][N];
		StringTokenizer st;
		
		for(int i=0; i<N; i++){
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++){
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int max = Integer.MIN_VALUE;
		
		for(int i=0; i<N; i++){
			for(int j=0; j<N; j++){
				count = dfs(i, j, 0);
				max = Math.max(max, count);
			}
		}
		
		System.out.println(max+1);
	}
	
	public static int dfs(int x, int y, int count){
		visited[x][y] = true;
		//System.out.println(count);
		
		for(int d=0; d<4; d++){
			int nx = x + dx[d];
			int ny = y + dy[d];
			if(nx<0 || ny<0 || nx>=N || ny>=N) continue;
			if(visited[nx][ny]) continue;
			if(Math.abs(graph[nx][ny] - graph[x][y]) == 1){
				dfs(nx, ny, count+1);
			}
		}
		max = Math.max(count, max);
		//System.out.println(max);
		return max;
	}
}
