import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;

public class AthleteHash {
    public static String solution(String[] participant, String[] completion) {
        String answer="";
        HashMap<String, Integer> map=new HashMap<String, Integer>();
        for(String player:participant){
            map.put(player, map.getOrDefault(player, 0)+1);
        }
        for(String player:completion){
            map.put(player, map.get(player)-1);//key값은 중복이 안되므로 기존 player에 해당하는 값을 변경
        }
        // for(String key:map.keySet()){
        //     if(map.get(key)!=0){
        //         answer=key;
        //         break;
        //     }
        // }
        Iterator <Map.Entry<String, Integer>> iter=map.entrySet().iterator();
        while(iter.hasNext()){
            Map.Entry<String, Integer>
            if()
        }

        return answer;
    }
    public static void main(String[] args){
        String[] participant={"leo","kiki","eden"};
        String[] completion={"eden","kiki"};
        String result=solution(participant, completion);
        System.out.println(result);
    }
}
