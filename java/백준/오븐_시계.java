import java.io.*;
import java.util.*;

public class 오븐_시계 {
    public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(System.in);

        int A = in.nextInt();
        int B = in.nextInt();

        int C = in.nextInt();
        in.close();

        if(B+C>=60){
            A += (B+C)/60;
            B = (B+C)%60;
            if(A==24) A=0;
            if(B==60) B=0;
        }else{
            B += C;
        }

        System.out.print(A +" "+B);
    }
}
