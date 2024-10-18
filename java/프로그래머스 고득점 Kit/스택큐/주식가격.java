package 스택큐;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length]; // 단순히 다음 것들이 크거나 같은 경우만 count하면 안됌 -> 5,4,3,2,1 이 예제에서는 1, 1, 1, 1, 0이 나와야함
        // 구간을 따질 때에는 j-i로(index활용) 풀어도 가능, 내가 푼거는 단순히 count한 것
        for(int i=0; i<prices.length; i++){
            int count=0;
            for(int j=i+1; j<prices.length; j++){
                count++; // 다음걸 고려하기 전에 1초가 지났다고 판단하는 것
                if(prices[i] > prices[j]){ 
                    break;
                }
            }
            answer[i] = count;
        }
        return answer;
    }
}