class Solution {
    public int sumCounts(List<Integer> nums) {
        int total = 0;
        int n = nums.size();
        for (int i = 0; i < n; i++) {
            java.util.Set<Integer> distinct = new java.util.HashSet<>();
            for (int j = i; j < n; j++) {
                distinct.add(nums.get(j));
                total += distinct.size() * distinct.size();
            }
        }
        return total;
    }
}