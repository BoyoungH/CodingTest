import java.util.*;

public class Exam {
    public static int[] solution(int[] answers) {
        int[] person1={1,2,3,4,5};
        int[] person2={2,1,2,3,2,4,2,5};
        int[] person3={3,3,1,1,2,2,4,4,5,5};

        int[] cnt=new int[3];

        for(int i=0;i<answers.length;i++){
            if(answers[i]==person1[i%person1.length]) cnt[0]++;
            if(answers[i]==person2[i%person2.length]) cnt[1]++;
            if(answers[i]==person3[i%person3.length]) cnt[2]++;
        }
        int max=Math.max(cnt[0], Math.max(cnt[1], cnt[2]));

        List<Integer> list=new ArrayList<>();

        if(max==cnt[0]) list.add(1);
        if(max==cnt[1]) list.add(2);
        if(max==cnt[2]) list.add(3);
        
        int[] answer=new int[list.size()];

        for(int i=0;i<answer.length;i++){
            answer[i]=list.get(i);
        }

        return answer; 

    }

    public static void main(String[] args){
        int[] answers={1,3,2,4,2};
        int[] result=solution(answers);
        
        System.out.print("[");
        for(int i=0;i<result.length;i++){
            if(i!=result.length-1){
                System.out.print(result[i]+", ");
            }
            else{
                System.out.print(result[i]);
            }
        }
        System.out.print("]");

    }
}
