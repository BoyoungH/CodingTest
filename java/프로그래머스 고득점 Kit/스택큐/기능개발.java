package 스택큐;

import java.util.*;

class Solution {
    public List<Integer> solution(int[] progresses, int[] speeds) {
        int N = progresses.length;
        int[] memo = new int[N];
        
        for(int i=0; i<N;i++){
            if((100-progresses[i])%speeds[i]==0){
                memo[i] = (100-progresses[i])/speeds[i];
            }
            else{
                memo[i] = (100-progresses[i])/speeds[i]+1;
            }
        }
        
        //개수 세는거 유의해서 공부하기
        int count=1;
        int firstdeploy=memo[0];
        List<Integer> answer = new ArrayList<>();
        
        for(int i=1; i<N; i++){
            if(memo[i] <= firstdeploy){
                count++;
            }else{
                answer.add(count);
                count=1;
                firstdeploy = memo[i];
            }
        }
        answer.add(count);
        
        
        return answer;
    }
}