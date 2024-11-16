import java.io.*;
import java.util.*;

public class 숫자의_신 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        String[] arr = new String[K];
        int max = 0;
        
        for(int i=0; i<K; i++){
            arr[i] = br.readLine();
            max = Math.max(max, Integer.parseInt(arr[i])); // 자리수가 가장 큰 걸 반복 이어붙이는게 숫자가 커짐
        }

        Arrays.sort(arr, (a, b) -> (b+a).compareTo(a+b));

        StringBuilder sb = new StringBuilder();

        boolean checkMax = true; // 중복된 숫자를 여러개 가지고 있는 경우 하나의 숫자에 대해서만 반복 처리를 위해 둠
        for(String str : arr){
            sb.append(str); // 조합했을 때 큰 수대로 붙여놓고 자리수(가장 큰 수)가 남은 숫자만큼 반복되도록 구현
            if(Integer.parseInt(str) == max && checkMax){
                for(int i=0; i<N-K; i++){
                    sb.append(max);
                }
                checkMax = false;
            }
        }

        System.out.println(sb.toString());
    }   
}
