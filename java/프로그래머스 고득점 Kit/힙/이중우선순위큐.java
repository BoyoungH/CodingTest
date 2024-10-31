package 힙;

import java.util.*;

class Solution {
    public List<Integer> solution(String[] operations) {
        List<Integer> answer = new ArrayList<>();
        PriorityQueue<Integer> minpq = new PriorityQueue<>(); // 오름차순 -> 최소힙
        PriorityQueue<Integer> maxpq = new PriorityQueue<>(Collections.reverseOrder()); // 내림차순 -> 최대힙
        
        for(int i=0; i<operations.length; i++){
            String str = operations[i];
            
            if(str.equals("D 1")){
                if(!maxpq.isEmpty()){
                    int now = maxpq.poll();
                    minpq.remove(now);
                }
            }else if(str.equals("D -1")){
                if(!maxpq.isEmpty()){
                    int now = minpq.poll();
                    maxpq.remove(now);
                }
            }else if(str.substring(0,1).equals("I")){
                maxpq.add(Integer.parseInt(str.substring(2)));
                minpq.add(Integer.parseInt(str.substring(2)));
            }
        }
        
        if(maxpq.isEmpty()){
            answer.add(0);
            answer.add(0);
        }else{
            answer.add(maxpq.poll());
            answer.add(minpq.poll());
        }
        return answer;
    }
}