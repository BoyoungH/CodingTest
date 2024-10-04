package 해시;

import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int max = nums.length / 2;

        HashSet<Integer> hashSet = new HashSet<>();

        for (int n : nums) {
            hashSet.add(n); //중복 제거
        }

        return Math.min(hashSet.size(), max);
    }
}
