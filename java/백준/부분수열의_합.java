import java.io.*;
import java.util.*;

public class 부분수열의_합{
    static int N, S;
    static int[] arr;
    static int answer = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0, 0);

        System.out.println(answer);
    }

    public static void dfs(int depth, int sum, int count){
        if(depth == N){
            if(sum == S && count>0){
                answer += 1;
            }
            return;
        }

        dfs(depth+1, sum + arr[depth], count + 1);
        dfs(depth+1, sum, count);
    }
}