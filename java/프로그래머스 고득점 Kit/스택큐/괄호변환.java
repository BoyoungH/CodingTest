package 스택큐;

import java.util.*;

class Solution {
    int pos; // v시작 인덱스
    public String solution(String p) {
        String answer = "";
        if(p.isEmpty()) return p;
        
        boolean correct = isCorrect(p); // 분리를 위한 인덱스 결정
        
        String u = p.substring(0,pos);
        String v = p.substring(pos, p.length());
        
        if(correct){
            return u + solution(v);
        }
        
        answer = '(' + solution(v) + ')';
        
        for(int i=1; i<u.length()-1; i++){
            if(u.charAt(i)=='(') answer+=')';
            else answer+='(';
        }
        
        return answer;
    }
    
    private boolean isCorrect(String p){
        boolean result = true;
        int left=0; int right=0;
        Stack<Character> st = new Stack<Character>();
        
        for(int i=0; i<p.length(); i++){
            if(p.charAt(i)=='('){ // 올바른 괄호 문자열 판별
                left++;
                st.push('(');
            }else{
                right++;
                if(st.isEmpty()) result = false; // 올바른 괄호 문자열이 아님
                else{
                    st.pop();
                }
            }
            
            if(left == right){ //균형잡힌 괄호 문자열 판별
                pos = i+1;
                return result; // result=true했다가 틀림, 두번째 테케의 경우 false 반환, 제일 짧은 균형 잡힌 괄호를 return 해야함
            }
        }
        return result;
    }
}

// 올바른 괄호 판단 : stack의 push pop 활용
// 균형잡힌 괄호 판단 : 개수만 같으면 됌
