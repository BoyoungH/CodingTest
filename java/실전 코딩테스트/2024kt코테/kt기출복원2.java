import java.util.*;

public class kt기출복원2 {
    public int minimumMemorizedCharacters(String[] problems, int[] answers) {
        int n = problems.length;
        Map<String, Integer> memo = new HashMap<>();

        // 각 문제에 대해 가능한 가장 짧은 접두사를 찾기
        for (int i = 0; i < n; i++) {
            String problem = problems[i].substring(0, problems[i].length() - 1); // ? 제거
            int answer = answers[i];

            for (int len = 1; len <= problem.length(); len++) {
                String prefix = problem.substring(0, len);

                // 다른 문제의 지문에서 같은 접두사를 갖고 있지만 다른 답을 가질 경우, 더 긴 접두사를 찾아야 함
                boolean isUnique = true;
                for (int j = 0; j < n; j++) {
                    if (i != j && problems[j].startsWith(prefix) && answers[j] != answer) {
                        isUnique = false;
                        break;
                    }
                }

                if (isUnique) {
                    // 접두사가 유일하게 답을 구분할 수 있으면 저장
                    memo.putIfAbsent(prefix, answer);
                    break;
                }
            }
        }

        // 암기할 접두사의 길이를 모두 합산
        int totalCharacters = 0;
        for (String key : memo.keySet()) {
            totalCharacters += key.length();
        }

        return totalCharacters;
    }

    public static void main(String[] args) {
        kt기출복원2 solution = new kt기출복원2();

        // 테스트 케이스 1
        String[] problems1 = {"abcdef?", "bbab?", "bbabab?", "abcd?", "cacsdc?", "cacabc?", "cacsz?"};
        int[] answers1 = {2, 3, 1, 2, 4, 5, 3};
        System.out.println("Test Case 1: " + solution.minimumMemorizedCharacters(problems1, answers1)); // Expected output: 25

        // 테스트 케이스 2
        String[] problems2 = {"apple?", "banana?", "apply?", "app?", "bab?", "a?"};
        int[] answers2 = {1, 5, 1, 1, 2, 4};
        System.out.println("Test Case 2: " + solution.minimumMemorizedCharacters(problems2, answers2)); // Expected output: 10
    }
}
