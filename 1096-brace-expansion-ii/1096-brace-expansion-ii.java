import java.util.*;

class Solution {
    TreeSet<String> ans = new TreeSet<>();

    void search(String s) {
        int c = s.indexOf("}");
        
       
        if (c == -1) {
            for (String option : s.split(",")) {
                ans.add(option);
            }
            return;
        }

        int o = s.lastIndexOf("{", c);

        String left = s.substring(0, o);
        String right = s.substring(c + 1);
        String middle = s.substring(o + 1, c);
        
        for (String option : middle.split(",")) {
            search(left + option + right);
        }
    }

    public List<String> braceExpansionII(String expression) {
        search(expression);
        return new ArrayList<>(ans);
    }
}