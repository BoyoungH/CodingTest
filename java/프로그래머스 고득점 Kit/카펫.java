class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        int area = brown + yellow;

        for(int i=3; i<area; i++){
            if(area%i == 0){
                int j = area/i;

                if(i>=j && j>=3){
                    if(yellow == (i-2)*(j-2)) {
                        answer[0] = i;
                        answer[1] = j;
                    }
                }
            }
        }

        return answer;
    }
}
