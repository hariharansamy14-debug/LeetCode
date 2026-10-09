class Solution {
    public int minInsertions(String s) {
        int res = 0;
        int right = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                right += 2;
                if (right % 2 != 0) {
                    res++;
                    right--;
                }
            } else {
                right--;
                if (right < 0) {
                    res++;
                    right += 2;
                }
            }
        }

        return res + right;
    }
}