import java.io.*;
import java.util.*;

public class 최대_상금 {
    static int T;
    static char[] arr;
    static int N;
    static int max;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr = st.nextToken().toCharArray();
            N = Integer.parseInt(st.nextToken());
            max = 0;
            dfs(0, 0);
            sb.append("#").append(tc).append(" ").append(max).append('\n');
        }

        System.out.print(sb.toString());
    }

    static void dfs(int start, int depth){
        if(depth == N){
            int value = Integer.parseInt(new String(arr));
            max = Math.max(max, value);
            return;
        }

        for(int i=start; i<arr.length; i++){
            for(int j=i+1; j<arr.length; j++){
                swap(i, j);
                dfs(i, depth+1);
                swap(i, j);
            }
        }
    }

    static void swap(int a, int b){
        char tmp;
        tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
