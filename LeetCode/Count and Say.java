public class Solution {
    public String countAndSay(int n) {
        StringBuilder builder = new StringBuilder("1");
        for (int i = 1; i < n; i++) {
            StringBuilder tmp = new StringBuilder();
            char c = builder.charAt(0);
            int count = 1;
            for (int j = 1; j < builder.length(); j++) {
                if (builder.charAt(j) != c) {
                    tmp.append(count);
                    tmp.append(c);
                    c = builder.charAt(j);
                    count = 1;
                } else {
                    count++;
                }
            }
            tmp.append(count);
            tmp.append(c);
            builder = tmp;
        }
        return builder.toString();
    }
}