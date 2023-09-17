import java.util.ArrayList;
import java.util.List;

public class fibonacci {
    public static int fibonacci(int n) {
        if (n <= 1)
            return n;
        
        return fibonacci(n - 2) + fibonacci(n - 1);
    }
    public static void fibonacci1(int n) {
        int a=0;
        int b=1;
        int next=0;

        for(int i=3;i<=n;i++){
            next=a+b;
            a=b;
            b=next;
        }
        System.out.println(next);

    }

    static long[] memo;
    public static long fibonacci2(int n) {
        if (n <= 1)
            return n;
        else if (memo[n] != 0)
            return memo[n];
        else
            return memo[n] = fibonacci(n - 1) + fibonacci(n - 2);
     
    }

 
    public static void main(String[] args) {
        long beforeTime = System.currentTimeMillis();
        System.out.println(fibonacci(30));
        long afterTime = System.currentTimeMillis();

        long diffTime = afterTime - beforeTime; 
        System.out.println("실행 시간(ms): " + diffTime);

        System.out.println("============================");

        long beforeTime1 = System.currentTimeMillis();
        fibonacci1(30);
        long afterTime1 = System.currentTimeMillis();
        long diffTime1 = afterTime1 - beforeTime1; 
        System.out.println("실행 시간(ms): " + diffTime1);

        System.out.println("============================");
        memo=new long[41];
        long beforeTime2 = System.currentTimeMillis();
        fibonacci1(40);
        long afterTime2 = System.currentTimeMillis();
        long diffTime2 = afterTime2 - beforeTime2; 
        System.out.println("실행 시간(ms): " + diffTime2);
    }
}
