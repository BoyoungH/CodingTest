//(0,4)(1,4)(2,4)
//(0.3)(1.3)(2,3)
public class Q6 {
    public static void main(String[] args) {
        int[][] 첫번째밭 = {
                            {1, 0, 0, 0, 0},
                            {0, 0, 1, 0, 1},
                            {0, 0, 1, 0, 1},
                            {0, 0, 1, 0, 1},
                            {0, 0, 1, 0, 1}
                        };

        int[][] 두번째밭 = {
                            {0, 0, 0, 0, 1},
                            {0, 0, 0, 0, 3},
                            {0, 0, 0, 0, 4},
                            {0, 2, 0, 0, 2},
                            {4, 5, 0, 2, 0}
                        };

        solution(첫번째밭, 두번째밭);
    }

    public static void solution(int[][] 첫번째밭, int[][] 두번째밭) {
        int len = 첫번째밭.length;
        int[][] sample = new int[len][len];

        for(int i = 0; i < len; i++){
            for(int j = 0 ; j < len; j++){
                sample[i][j] = 두번째밭[j][len-1-i];
                sample[i][j] += 첫번째밭[i][j];
            }
        }

        for(int i = 0; i < len; i++){
            String str = "";
            for(int j = 0 ; j < len; j++){
                str += sample[i][j];
            }
            System.out.println(str);
            int v = Integer.parseInt(str, 8);//Integer v는 객체임으로 char형으로 형변환 되지 않음 , 8진수를 10진수로 변환하는 과정
            System.out.println((char)v);
        }
    }
}