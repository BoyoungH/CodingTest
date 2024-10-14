package 스택큐;

import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int p: priorities){
            pq.add(p);
        }
        
        while(!pq.isEmpty()){
            for(int i=0; i<priorities.length; i++){
                if(priorities[i]==pq.peek()){
                    pq.poll();
                    answer++;
                    if(i==location) return answer; //break하니까 null exception 뜸
                }
            }
        }
        
        return answer;
    }
}

