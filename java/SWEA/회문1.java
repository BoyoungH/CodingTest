import java.util.*;
import java.io.*;

public class 회문1 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for(int tc=1; tc<=10; tc++){
            int n = Integer.parseInt(br.readLine());
            char[][] map = new char[8][8];

            for(int i=0; i<8; i++){
                String str = br.readLine();
                for(int j=0; j<8; j++){
                    map[i][j] = str.charAt(j);
                }
            }

            boolean flag = true;
            int count = 0;

            //행 방향
            for(int i=0; i<8; i++){
                for(int j=0; j<8-n+1; j++){
                    flag = true;
                    for(int k=0; k<n/2; k++){
                        if(map[i][j+k] != map[i][j+n-1-k]){
                            flag = false;
                        }
                    }
                    if(flag) count++;
                }
            }

            //열 방향
            for(int i=0; i<8-n+1; i++){
                for(int j=0; j<8; j++){
                    flag = true;
                    for(int k=0; k<n/2; k++){
                        if(map[i+k][j] != map[i+n-1-k][j]){
                            flag = false;
                        }
                    }
                    if(flag) count++;
                }
            }

            sb.append("#" + tc + " " +count).append('\n');
        }
        System.out.print(sb.toString());
    }
}
