class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int n = seq.length();
        int[] res = new int[n];
        int depth =0;

        for(int i =0;i<seq.length();i++){
            if(seq.charAt(i)=='('){
                res[i]=depth%2;
                depth++;
            }else{
                 depth--;
                 res[i]=depth%2;
            }
        }
        return res;
    }
}