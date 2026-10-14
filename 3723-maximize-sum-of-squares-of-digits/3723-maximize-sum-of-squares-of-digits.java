class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if (sum > (long) 9 * num) {
            return "";
        }
        
        StringBuilder ans = new StringBuilder();
        int nines = sum / 9;
        int remainder = sum % 9;
        
        for (int i = 0; i < nines && ans.length() < num; i++) {
            ans.append('9');
        }
        
        if (ans.length() < num && remainder > 0) {
            ans.append((char) ('0' + remainder));
        }
        
        while (ans.length() < num) {
            ans.append('0');
        }
        
        if (ans.length() > num) {
            return "";
        }
        
        return ans.toString();
    }
}