import java.util.*;

public class Q4 {
    public static void main(String[] args) {
        String[] 페이지 = {"척추동물", "어류", "척추동물", "무척추동물", "파충류", "척추동물", "어류", "파충류"};
        System.out.println(solution(페이지));
    }

    public static String solution(String[] 페이지){
        List<String> 의자 = new ArrayList<String>();
        int answer = 0;
        for(String i : 페이지){
            if(의자.contains(i)){ // 같은 요소가 있는지 확인
                의자.remove(i);
                의자.add(i);
                answer += 1;
            }
            else{
                if(의자.size() < 3){ // 모든 페이지가 사용중이지 않을때 -> 각 로직마다 page fault가 발생함
                    의자.add(i);
                    answer += 60;
                }
                else{// 모든 페이지가 사용중일때, 가장 오래된 요소 제거 -> list에서 0번째 리스트가 가장 오래된 것이고 add할때마다 뒤에 추가됨
                    의자.remove(0);
                    의자.add(i);
                    answer += 60;
                }
            }
            System.out.println(의자);
        }

        return answer/60 + "분 " + answer%60 + "초"; 
    }
}
