class Solution {
    public int maxSum(List<Integer> nums, int k) {
        int[] bitCount = new int[31];
        for (int num : nums) {
            for (int i = 0; i <= 30; i++) {
                if ((num & (1 << i)) != 0) {
                    bitCount[i]++;
                }
            }
        }
        
        long ans = 0;
        long mod = 1000000007;
        
        for (int step = 0; step < k; step++) {
            long currentNum = 0;
            for (int i = 0; i <= 30; i++) {
                if (bitCount[i] > 0) {
                    currentNum |= (1L << i);
                    bitCount[i]--;
                }
            }
            ans = (ans + currentNum * currentNum) % mod;
        }
        
        return (int) ans;
    }
}