package Greedy;

import java.util.*;

/*
 * 이 문제가 Greedy로 풀어야하는 이유
 * min 무게와 max 무게를 짝지어서 계산해야 보트 수가 가장 적게 필요하다는 사실이 보장됌
 * 다른 조합으로 하면 무조건 보트 수가 많아질 수 밖에 없음
 * (최대 무게 제한을 넘지 않으려면 가벼운 사람과 무거운 사람을 짝지어야 다른 조합보다 보트 수가 적어짐)
 */

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        int count = 0;
        int left = 0;
        int right = people.length - 1;
        
        // 무게가 초과하면 최대무게(right)을 줄여야하고 아니면 최소무게(left)는 키우고 최대무게(right)는 줄이기
        while(left<=right){ //left==right인 경우도 고려해야 정답이 됌
            if(people[left] + people[right] <= limit){
                left++;
            } 
            right--;
            count++;
        }
        return count;

        // 블로그 정답
        // int answer = 0;

        // Arrays.sort(people);

        // int min = 0;

        // for (int max = people.length - 1; min <= max; max--){
        // if (people[min] + people[max] <= limit) min++;
        // answer++;
        // }

        // return answer;
    }
}