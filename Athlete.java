import java.util.Arrays;

public class Athlete {
    public static String solution(String[] participant, String[] completion) {
        Arrays.sort(participant);
        Arrays.sort(completion);
        int i=0;
        for(;i<=completion.length-1;i++){
            if(!participant[i].equals(completion[i]))
                break;
        }
        return participant[i];
    }

    public static void main(String[] args){
        String[] participant={"leo","kiki","eden"};
        String[] completion={"eden","kiki"};
        String result=solution(participant, completion);
        System.out.println(result);
    }
}
