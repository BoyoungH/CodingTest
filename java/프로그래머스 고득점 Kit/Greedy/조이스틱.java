package Greedy;

import java.util.*;

class Solution {
    public int solution(String name) {
        int n = name.length();
        
        int count=0;
        int index=0;
        int move = n-1;
        
        for(int i=0; i<n; i++){
            count += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i)+1); // A -> Z로 가는거 1 추가 이후 Z에서 해당 알파벳까지 계산 
            
            index=i+1; //현재 위치 다음거부터 해서 마지막 index가 가르키는게 현재 조취가 필요한 문자위치가 되므로 1을 더함 n(length)-index, +1을 안하면 마지막 A가 끝나는 거기 위치임
            while(index<n && name.charAt(index)=='A') index++;
            
            // 왼쪽에서 시작하여 오른쪽으로 갔다가 뒤로 돌아오는 경우
            move = Math.min(move, i*2 + n-index);
            
            // 끝에서부터 왼쪽으로 갔다가 다시 돌아오는 경우
            move = Math.min(move, (n-index)*2 + i);
        }
        return count + move;
    }
}