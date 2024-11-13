package Greedy;
import java.util.*;

/*백트래킹 문제풀이
목표가 모든 조합을 찾는 것이 아니라 최대값을 만드는 것이 목표기 때문에
백트래킹으로 풀면 모든 조합을 고려하는 것이므로 비효율적
실제 제출 결과 시간 초과, 메모리 초과가 뜸
*/

// class Solution {
//     int n;
//     List<Integer> list = new ArrayList<>();
//     public String solution(String number, int k) {
//         String answer = "";
//         n = number.length();
//         dfs(number, n-k, 0, 0, "");
        
//         Collections.sort(list, Comparator.reverseOrder());
        
//         answer = list.get(0).toString();
//         return answer;
//     }
//     void dfs(String number, int size, int depth, int start, String num){
//         if(depth == size){
//             list.add(Integer.parseInt(num));
//             return;
//         }
        
//         for(int i=start; i<n; i++){
//             dfs(number, size, depth+1, i+1, num + number.charAt(i));
//         }
//     }
// }


class Solution {
    public String solution(String number, int k) {
        int n = number.length();
        Stack<Character> st = new Stack<>();
        for(int i=0; i<n; i++){
            char c = number.charAt(i);
            
            while(!st.isEmpty() && c > st.peek() && k>0){ // k번 지우는 작업
                st.pop();
                k--;
            }
            
            st.push(c); // 스택이 비었거나 현재거가 이전거보다 작은 경우
        }
        
        while(k>0){ // number="8654321", k=3 인경우 k는 줄지 않고 stack에 모든 수가 쌓이는 경우, k개의 숫자를 뒤에서부터 지워야함
            st.pop();
            k--;
        }
        
        StringBuilder sb = new StringBuilder();
        for(char c : st){ // 스택 바닥부터 하나씩 가져옴
            sb.append(c);
        }
        
        return sb.toString();
    }
}


/*
 * 정답 코드(https://hyojun.tistory.com/entry/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%ED%81%B0-%EC%88%98-%EB%A7%8C%EB%93%A4%EA%B8%B0-Java)
 * 특정 구간에서 최대값을 찾아서 붙임
 * 슬라이딩 윈도우는 아님
 */

// for(int i = 0; i < number.length() - k; i++) {
// 	// 전체길이 - k 번 반복
//     char max = 0; // 최대값 변수
    
//     for(int j = idx; j <= i + k; j++) {
// 		if(max < number.charAt(j)) {
// 			max = number.charAt(j);
// 			idx = j + 1;
// 		}
// 		sb.append(max);
// 	}
// }
