class Solution {
    public int reverseDegree(String s) {
     long sum =0;
        int n = s.length();
       for (int i = n-1;i>=0;i--){
        int charvalue = 'z'- s.charAt(i)+1;
        int reversepos = i+1;
        sum += charvalue * reversepos;
       }
          
    return (int)sum;
    }
}