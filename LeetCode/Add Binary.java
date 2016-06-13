/**
 * Created by river on 2016/6/12.
 */
public class Solution {
    public String addBinary(String a, String b) {

        int add = 0, len = a.length() > b.length() ? a.length() : b.length();
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < len; i++) {
            int v1 = i < a.length() ? Character.getNumericValue(a.charAt(a.length() -1 - i)) : 0;
            int v2 = i < b.length() ? Character.getNumericValue(b.charAt(b.length() -1 - i)) : 0;
            builder.append((v1 + v2 + add) % 2);
            add = (v1 + v2 + add) / 2;
        }
        if (add > 0) {
            builder.append(add);
        }

        return builder.reverse().toString();
    }

}