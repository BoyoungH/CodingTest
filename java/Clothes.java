import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
public class Clothes {
    public int solution(String[][] clothes){
        //1.옷을 종류별로 구분한다.
        HashMap<String, Integer> map=new HashMap<>();
        for(String[] clothe:clothes){
            String type=clothe[1];
            map.put(type, map.getOrDefault(type,0)+1);
        }
        //2.입지 않는 경우를 추가해서 모든 조합을 계산한다.
        int answer=1;
        Iterator<Integer> it=map.values().iterator();
        while(it.hasNext()){
            answer*=it.next().intValue()+1;
        }
        //3.아무것도 안입은 경우를 제외한다.
        return answer-1;
    }
    public static void main(String args[]){
        Clothes sol=new Clothes();
        String[][] clothes={{"yellohat","headgear"},
                            {"blueglasses","eyegear"},
                            {"green_turban","headgear"}};
        
        System.out.print(sol.solution(clothes));
    }
}
