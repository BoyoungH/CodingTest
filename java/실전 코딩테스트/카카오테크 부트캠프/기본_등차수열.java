import java.io.*;

public class 기본_등차수열 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int count = 0;
		
		for(int i=0; i<N; i++){
			String ch = br.readLine();
            boolean flag = true;
			int minus = Character.getNumericValue(ch.charAt(1)) - Character.getNumericValue(ch.charAt(0)); // ++

			for(int j=0; j<ch.length()-1; j++){ //++
				int a = Character.getNumericValue(ch.charAt(j));
				int b = Character.getNumericValue(ch.charAt(j+1));
				if(b-a != minus) {
                    flag = false; 
                    break; //++
                }
			}
			if(flag) count++;
		}
		
		System.out.println(count);
	}
}