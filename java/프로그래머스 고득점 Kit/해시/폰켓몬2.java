package 해시;
import java.util.HashSet;

class 폰켓몬2 {
    public static int solution(int[] nums) {
        HashSet<Integer> set=new HashSet<Integer>();
        int max=nums.length/2;
        for(int s:nums){
            set.add(s);
        }
        if (set.size()>max){
            return max;
        }
        else{
            return set.size();
        }
    }
    public static void main(String[] args){
        int[] num={3,1,2,3};
        int result=solution(num);
        System.out.println(result);
    }
}
