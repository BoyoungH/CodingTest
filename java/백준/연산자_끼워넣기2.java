import java.io.*;
import java.util.*;

public class 연산자_끼워넣기2 {
    static int N;
    static int[] A;
    static int[] plus;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = new int[N];
        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        plus = new int[4];
        for(int i=0; i<4; i++){
            plus[i] = Integer.parseInt(st.nextToken());
        }

        dfs(A[0], 1); // 첫 값을 넘겨주기 때문에 그 다음 깊이부터 시작

        System.out.println(max);
        System.out.println(min);
    }

    public static void dfs(int result, int depth){
        if(depth == N){ // not depth == N-1
            max = Math.max(result, max);
            min = Math.min(result, min);
            return;
        }

        for(int i=0; i<4; i++){ //0->+, 1->-, 2->x, 3->%
            if(plus[i]>0){
                plus[i]--;
                switch (i) {
                    case 0: dfs(result + A[depth], depth+1); break;
                    case 1: dfs(result - A[depth], depth+1); break;
                    case 2: dfs(result * A[depth], depth+1); break;
                    case 3: dfs(result / A[depth], depth+1); break;
                }
                plus[i]++; // 다른 경우에서도 고려하기 위해 원상복귀
            }
        }
    }
}
