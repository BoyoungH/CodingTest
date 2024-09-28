
import java.util.*;

class Solution {
    HashSet<Integer> set = new HashSet<>();
    public void recursive(String comb, String others){
        if(!comb.equals("")) set.add(Integer.parseInt(comb));

        for(int i=0; i<others.length(); i++){
            recursive(comb+others.charAt(i), others.substring(0,i) + others.substring(i+1,others.length()));
        }

    }

    public boolean check_prime(int num){
        if(num==0 || num==1) return false;
        int limit = (int) Math.sqrt(num);

        for(int i=2; i<=limit; i++){
            if(num%i==0) return false;
        }

        return true;
    }

    public int solution(String numbers) {
        int count = 0;
        //1. 숫자 조합하기
        recursive("", numbers);

        //2. 소수 확인하기
        Iterator<Integer> it = set.iterator();

        while(it.hasNext()){
            if(check_prime(it.next())){
                count++;
            }
        }

        return count;
    }
}

// int index 배열 생성 후 초기화
// 조합하여 숫자 만들고 prime 함수 호출해서 소수인지 판별
// count 하기