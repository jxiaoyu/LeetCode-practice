public class Solution {
     public int lengthLongestPath(String input) {
        List<String> path = new ArrayList<String>();
        String[] elements = input.split("\n");
        int maxLen = 0;
        for (int i = 0; i < elements.length; i++) {
            String element = elements[i];
            int level = 0;
            while('\t' == element.charAt(0)) {      // num of \t identify level
                element = element.substring(1);
                level++;
            }
            if (path.size() > level)               // only keep directories up to my level
                path = path.subList(0, level);
            path.add(element);
            if (element.indexOf(".") != -1) {
                String filePath = String.join("/",path);
                if (filePath.length() > maxLen) maxLen = filePath.length();
            }
        }
        return maxLen;
    }
}