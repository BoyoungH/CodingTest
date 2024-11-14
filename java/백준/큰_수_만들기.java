import java.io.*;
import java.util.*;

public class 큰_수_만들기 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        String[] arr = new String[N];

        for(int i=0; i<N; i++){
            arr[i] = st.nextToken();
        }

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
