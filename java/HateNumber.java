import java.util.Stack;

public class HateNumber {
    public static int[] solution(int []arr) {
        int[] answer;
        Stack<Integer> st=new Stack<Integer>();

        for(int i:arr){
            if(st.isEmpty()) st.push(i);
            else if(st.peek()!=i) st.push(i);
        }

        answer=new int[st.size()];
        for(int i=st.size()-1;i>=0;i--){
            answer[i]=st.pop();
        }
        return answer;
    }
    public static void main(String[] args){
        //int[] arr={1,1,3,3,0,1,1};
        int[] arr={4,4,4,3,3};

        int[] result = solution(arr);

        for (int num : result) {
            System.out.print(num + " ");
        }

    }
}
