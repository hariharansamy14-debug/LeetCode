class Solution {
    public boolean isValid(String s) {
      if (s.length() % 2 != 0) return false;
        char[] arr = s.toCharArray();
            Deque<Character> queue = new ArrayDeque<>();
            for(char ch : arr ){
             if(ch == '('){
                queue.push(')');
             }else if(ch == '{'){
                queue.push('}');
             }else if(ch == '['){
                queue.push(']');
             }else {
                if (queue.isEmpty() || queue.pop() != ch) {
                    return false;
                }
            }
           
    }
     return queue.isEmpty();
}
}