/**
 * 求所有解的问题 很自然想到 dfs，但是直接 dfs 必然超时
 * 先 dp，求出每个位置的单词列表，然后 dfs 都是不浪费的
 */
public class Solution {
    public static List<String> wordBreak(String s, Set<String> wordDict) {
        //create an array of ArrayList<String>
        List<String> dp[] = new ArrayList[s.length()+1];
        dp[0] = new ArrayList<String>();
     
        for(int i=0; i<s.length(); i++){
            if( dp[i] == null ) 
                continue; 
     
            for(String word:wordDict){
                int len = word.length();
                int end = i+len;
                if(end > s.length()) 
                    continue;
     
                if(s.substring(i,end).equals(word)){
                    if(dp[end] == null){
                        dp[end] = new ArrayList<String>();
                    }
                    dp[end].add(word);
                }
            }
        }
     
        List<String> result = new LinkedList<String>();
        if(dp[s.length()] == null) 
            return result; 
     
        ArrayList<String> temp = new ArrayList<String>();
        dfs(dp, s.length(), result, temp);
     
        return result;
    }
     
    private static void dfs(List<String> dp[],int end,List<String> result, ArrayList<String> tmp){
        if(end <= 0){
            String path = tmp.get(tmp.size()-1);
            for(int i=tmp.size()-2; i>=0; i--){
                path += " " + tmp.get(i) ;
            }
     
            result.add(path);
            return;
        }
     
        for(String str : dp[end]){
            tmp.add(str);
            dfs(dp, end-str.length(), result, tmp);
            tmp.remove(tmp.size()-1);
        }
    }
}