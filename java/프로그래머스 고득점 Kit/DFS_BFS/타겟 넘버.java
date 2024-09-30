package DFS_BFS;
class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;

        answer = dfs(0, 0, numbers, target);

        return answer;
    }

    public int dfs(int depth, int sum, int[] numbers, int target){
        if(depth == numbers.length){
            if(target == sum){
                return 1;
            }
            else{
                return 0;
            }
        }
        // +
        int plus = dfs(depth+1, sum+numbers[depth], numbers, target);

        //-
        int minus = dfs(depth+1, sum-numbers[depth], numbers, target);

        return plus + minus;
    }
}

//재귀함수에 덧셈, 뺄셈 두가지 dfs