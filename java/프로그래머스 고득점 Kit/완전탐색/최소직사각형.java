package 완전탐색;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;

        for(int i=0; i<sizes.length; i++){
            if(sizes[i][0]>sizes[i][1]){
                int tmp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = tmp;
            }
        }

        int wmax=0;
        int hmax=0;

        for(int i=0; i<sizes.length; i++){
            wmax = Math.max(sizes[i][0], wmax);
            hmax = Math.max(sizes[i][1], hmax);
        }

        return wmax*hmax;
    }
}

//둘이 비교 후 작으면 바꾸기
