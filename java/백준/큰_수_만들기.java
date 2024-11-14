import java.io.*;
import java.util.*;
/*
 * Greedy
 * 각 숫자 쌍을 비교하여 큰 조합을 앞으로 배치하면, 조합들이 모영 전체적으로 가장 큰 수가 됌
 */
public class 큰_수_만들기 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        String[] arr = new String[N];

        for(int i=0; i<N; i++){
            arr[i] = st.nextToken();
        }

        // 이어붙인 숫자가 큰 것을 기준으로 정렬, (x+y).compareTo(y+x) -> 이어붙인거 작은 것을 기준으로 정렬
        // (x, y)일때 default가 asc로 y가 더 크다고 가정하고 y+x가 앞에 있을때는 큰 거 기준, x+y가 앞에 있을때는 작은거 기준으로 생각하기
        // cf) Arrays.sort(arr, (a, b) -> b-a)가 내림차순인거랑 같은 원리
        Arrays.sort(arr, ((x, y) -> (y+x).compareTo(x+y)));

        StringBuilder sb = new StringBuilder();

        for(String s:arr){
            sb.append(s);
        }

        if(sb.charAt(0)=='0'){ // [0, 0, 0] 인 경우 000이 출력되면 안되고 0이 출력되어야함
            System.out.println("0");
            return;
        }

        System.out.println(sb.toString());

    }
}
