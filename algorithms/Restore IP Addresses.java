/**
 * 典型的 dfs
 */
public class Solution {
    public ArrayList<String> restoreIpAddresses(String s) {
        ArrayList<String> res = new ArrayList<String>();
        if (s.length() < 4 || s.length() > 12) {
            return res;
        }
        dfs(s, "", res, 0);
        return res;
    }

    public void dfs(String s, String temp, ArrayList<String> res, int depth) {
        if (depth == 3 && isvalid(s)) {
            res.add(temp + s);
            return;
        }
        for (int i = 1; i < 4 && i < s.length(); i++) {
            String substr = s.substring(0, i);
            if (isvalid(substr)) {
                dfs(s.substring(i), temp + substr + ".", res, depth + 1);
            }
        }
    }

    public boolean isvalid(String s) {
        if (s.charAt(0) == '0') {
            return s.equals("0");
        }
        int num = Integer.parseInt(s);
        return num > 0 && num <= 255;
    }
}