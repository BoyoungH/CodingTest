import java.io.*;
import java.util.*;

public class 로또{
    static int k;
    static int[] arr;
    static int[] lotto;
    static boolean[] checked;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());

            if(k == 0){
                break;
            }
            arr = new int[k];

            for(int i=0; i<k; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            lotto = new int[6];
            checked = new boolean[k];
            dfs(0, 0);
            sb.append("\n");

        }
        System.out.println(sb); // 이거 while 문 안에 넣으면 입력 다 끝나기도 전에 결과 나옴
    }

    public static void dfs(int start, int depth){
        if(depth == 6){
            for(int i=0; i<6; i++){
                sb.append(lotto[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=start; i<k; i++){
            if(!checked[i]){
                checked[i] = true;
                lotto[depth] = arr[i];
                dfs(i, depth+1);
                checked[i] = false;
            }
        }
    }
}
