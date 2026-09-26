import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> map = new HashMap<>((int) (knowledge.size() / 0.75f) + 1);
        for (List<String> pair : knowledge) {
            map.put(pair.get(0), pair.get(1));
        }

        StringBuilder result = new StringBuilder();
        int keyStart = -1;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                keyStart = i;
            } else if (c == ')') {
                String key = s.substring(keyStart + 1, i);
                result.append(map.getOrDefault(key, "?"));
                keyStart = -1;
            } else if (keyStart == -1) {
                result.append(c);
            }
        }

        return result.toString();
    }
}