import java.io.*;
import java.util.*;

public class 동일값 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        for(int tc=1; tc<=T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            List<String> list = new ArrayList<>();
            st = new StringTokenizer(br.readLine());

            while(st.hasMoreTokens()){
                list.add(st.nextToken());
            }

            boolean checkfirst = true;
            for(int i=1; i<list.size(); i++){
                if(Integer.parseInt(list.get(i)) != Integer.parseInt(list.get(i-1))){
                    checkfirst = false;
                    break;
                }
            }

            if(checkfirst){
                sb.append("#" + tc + " " + 0).append('\n');
                continue;
            }


            HashSet<String> set = new HashSet<>();
            int count=0;

            while(true){
                Boolean check = true;
                if(!list.isEmpty()){
                    list.add(list.get(K-1));
                    list.remove(0);
                    count++;
                }

                for(int i=1; i<list.size(); i++){
                    if(Integer.parseInt(list.get(i)) != Integer.parseInt(list.get(i-1))){
                        check = false;
                        break;
                    }
                }

                if(check){
                    sb.append("#" + tc + " " + count).append('\n');
                    break;
                }

                String str = "";

                for(String a: list){
                    str += a;
                }

                if(set.contains(str) && !check){
                    sb.append("#" + tc + " " + -1).append('\n');
                    break;
                }

                set.add(str);

            }
        }

        System.out.print(sb.toString());
    }
}


// 수열 A[1], A[2], …, A[N]이 주어진다.
// 이 수열에 다음 작업을 반복하면 몇 번째 만에 모든 값이 같아지는지 계산하라.
// 모두 같아지는 것이 불가능한 경우 -1을 출력한다.
// 작업: 수열의 K번째 원소를 제일 마지막에 추가하고, 수열의 첫 원소를 지운다.

// 아래 첫 번째 입력으로 주어진 수열에서 작업을 진행하는 경우를 보자.
// 수열은 {1, 5, 5, 3} -> {5, 5, 3, 5} -> {5, 3, 5, 5} -> {3, 5, 5, 3} -> {5, 5, 3, 5}와 같이 바뀌어 모두 같아지는 일 없이 반복된다.
// 따라서 이 경우의 답은 -1이다.

// [제약사항]
// 1.	N은 4 이상 500 이하이다. (4 ≤ N ≤ 500)
// 2.	수열의 원소는 1 이상 10 이하의 자연수이다.

// [입력]
// 가장 첫 줄에는 테스트 케이스의 총 수가 주어진다.
// 그 다음 줄부터 각 테스트 케이스가 주어지며, 각 테스트 케이스는 2줄로 구성된다.
// 각 테스트 케이스의 첫 줄에는 N과 K의 값이 주어진다.
// 다음 줄에 수열의 원소들의 순서대로 주어진다. 

// [출력]
// 출력의 각 줄은 ‘#x’로 시작하고, 공백을 한 칸 두고 최소 작업 횟수 혹은 -1을 출력한다.
// 단, x는 테스트 케이스의 번호이다.

// [입력 예]
// 3                              // 테스트 케이스의 수
// 4 2                           // N = 4, 테스트 케이스 #1
// 1 5 5 3
// 4 1                           // N = 4, 테스트 케이스 #2
// 3 3 3 3
// 4 3                           // N = 4, 테스트 케이스 #3
// 2 3 4 4

// [출력 예]
// #1 -1
// #2 0
// #3 2