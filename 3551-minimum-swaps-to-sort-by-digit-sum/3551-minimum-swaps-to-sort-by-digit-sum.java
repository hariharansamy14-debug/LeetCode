import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int minSwaps(int[] nums) {
        int ans = 0;
        boolean[] seen = new boolean[nums.length];
        int[][] pairs = new int[nums.length][2];
        for (int i = 0; i < nums.length; ++i) {
            pairs[i][0] = getDigitSum(nums[i]);
            pairs[i][1] = nums[i];
        }
        Arrays.sort(pairs, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });
        Map<Integer, Integer> numToIndex = new HashMap<>();
        for (int i = 0; i < pairs.length; ++i) {
            numToIndex.put(pairs[i][1], i);
        }
        for (int i = 0; i < nums.length; ++i) {
            if (seen[i] || numToIndex.get(nums[i]) == i) {
                continue;
            }
            int cycleSize = 0;
            int j = i;
            while (!seen[j]) {
                seen[j] = true;
                j = numToIndex.get(nums[j]);
                cycleSize++;
            }
            ans += cycleSize - 1;
        }
        return ans;
    }

    private int getDigitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}