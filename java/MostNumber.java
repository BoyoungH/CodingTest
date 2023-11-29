import java.util.Arrays;
public class MostNumber {
    public static String solution(int[] numbers) {
        String[] arr=new String[numbers.length];
        for(int i=0;i<arr.length;i++){
            arr[i]=String.valueOf(numbers[i]);
        }
        Arrays.sort(arr, (o1, o2)-> (o2+o1).compareTo(o1+o2));

        if(arr[0].equals(0)){
            return "0";
        }
        StringBuilder sb=new StringBuilder();

        for(int i=0;i<arr.length;i++){
            sb.append(arr[i]);
        }

        return sb.toString();
    }
    public static void main(String args[]){
        int[] arr={6,10,2};
        String result=solution(arr);
        System.out.println(result);
    }
}
