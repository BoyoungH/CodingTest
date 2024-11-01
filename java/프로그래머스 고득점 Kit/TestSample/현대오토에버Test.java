package TestSample;

import java.util.*;
import java.io.*;


public class 현대오토에버Test
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), "-");
        StringBuilder sb = new StringBuilder();

        while(st.hasMoreTokens()){
            String str = st.nextToken();
            sb.append(str.charAt(0));
        }

        System.out.println(sb.toString());
    }
}