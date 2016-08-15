/**
 * 巧妙的思路，如果是比较两个数的排序，情况比较多
 * 但实际上就两种拼接方式，比较这两者的大小即可
 */
public class Solution {
    public String largestNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for(int i=0; i<nums.length; i++){
            strs[i] = String.valueOf(nums[i]);
        }
     
        Arrays.sort(strs, new Comparator<String>(){
            public int compare(String s1, String s2){
                String leftRight = s1+s2;
                String rightLeft = s2+s1;
                return -leftRight.compareTo(rightLeft);
     
            }
        });
     
        StringBuilder sb = new StringBuilder();
        for(String s: strs){
            sb.append(s);
        }
     
        while(sb.charAt(0)=='0' && sb.length()>1){
            sb.deleteCharAt(0);
        }
     
        return sb.toString();
    }
}