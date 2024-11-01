package 해시;
import java.util.*;

public class 전화번호_목록{
    public boolean solution(String[] phone_book){
        boolean answer=true;
        Arrays.sort(phone_book);
        for(int i=0;i<phone_book.length-1;i++){
            if(phone_book[i+1].startsWith(phone_book[i])){
                answer=false;
            }
        }
        return answer;
    }

    public static void main(String[] args){
        String[] phone_book={"119", "97674223","1195524421"};
        전화번호_목록 sol=new 전화번호_목록();
        boolean bol=sol.solution(phone_book);
        System.out.println(bol);

    }
}