import java.util.*;

public class 슈어소프트1번문제복원{
    public static void main(String[] args) {
        // 테스트 케이스 1
        int[] prices1 = {3, 2, 4, 8, 7};
        System.out.println("테스트 케이스 1 - 최대 이익: " + maxProfit(prices1));  // 예상 결과: 6

        // 테스트 케이스 2
        int[] prices2 = {3, 4, 1, 5, 4};
        System.out.println("테스트 케이스 2 - 최대 이익: " + maxProfit(prices2));  // 예상 결과: 4

        // 테스트 케이스 3 - 가격이 감소하는 경우 (이익이 없음)
        int[] prices3 = {10, 9, 8, 7, 6};
        System.out.println("테스트 케이스 3 - 최대 이익: " + maxProfit(prices3));  // 예상 결과: 0

        // 테스트 케이스 4 - 가격이 동일한 경우 (이익이 없음)
        int[] prices4 = {5, 5, 5, 5, 5};
        System.out.println("테스트 케이스 4 - 최대 이익: " + maxProfit(prices4));  // 예상 결과: 0

        // 테스트 케이스 5 - 단일 요소 (이익이 없음)
        int[] prices5 = {7};
        System.out.println("테스트 케이스 5 - 최대 이익: " + maxProfit(prices5));  // 예상 결과: 0
    }
    
    static int maxProfit(int[] prices){
        // (1)아래처럼 풀면 시간 흐름을 무시하는 것이기 때문에 이렇게 풀면 안됌
        // int[] prices = {10, 9, 8, 7, 6}; 이 경우 계산할 수 없으므로 0이 나와야하지만 4가 나옴

        // Arrays.sort(prices);
        // int n = prices.length;
        // int min = prices[0];
        // int max = prices[n-1];

        // return max-min;

        // (2)아래처럼 풀면 정답은 맞을 수 있어도 문제의도와는 거리가 멀고 배열의 크기가 클수록 비효율적임
        // int max=Integer.MIN_VALUE;

        // for(int i=0; i<prices.length; i++){
        //     for(int j=i+1; j<prices.length; j++){
        //         if(prices[j]-prices[i]>max){
        //             max = prices[j]-prices[i];
        //         }
        //     }
        // }

        // return max<=0 ? 0 : max;

        // (3)아래처럼 푸는 것이 최적
        if(prices == null || prices.length < 2) return 0;

        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for(int price : prices){
            minPrice = Math.min(minPrice, price); // 현재 가격이 최소인지 판단
            maxProfit = Math.max(maxProfit, price-minPrice); // 현재가격과 최소가격의 차(최대 이익) 계산
        }

        return maxProfit;
    }

}