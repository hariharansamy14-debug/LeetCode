class Solution {
    public String reverseParentheses(String s) {
        StringBuilder sb = new StringBuilder(s);
      
      for(int i =0; i<sb.length(); i++){
            
            if(sb.charAt(i) == ')'){
                  
                      int end =i;
                      int start = sb.lastIndexOf("(",end);
                      String mid = sb.substring(start+1,end);
                      String rev = new StringBuilder(mid).reverse().toString();

                      sb.replace(start,end+1,rev);

                      i-=2;

            }

      }
         return sb.toString();
    }
}