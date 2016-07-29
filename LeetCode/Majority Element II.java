/**
 * 这思路很巧，出现次数大于 ⌊ n/3 ⌋ 的数最多就2个
 * 原来这方法是有名字的，叫 Boyer–Moore majority vote algorithm
 */
public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
     
        Integer n1=null, n2=null;
        int c1=0, c2=0;
     
        for(int i: nums){
            if(n1!=null && i==n1){
                c1++;
            }else if(n2!=null && i==n2){
                c2++;
            }else if(c1==0){
                c1=1;
                n1=i;
            }else if(c2==0){
                c2=1;
                n2=i;
            }else{
                c1--;
                c2--;
            }
        }
     
        c1=c2=0;
     
        for(int i: nums){
            if(i==n1){
                c1++;
            }else if(i==n2){
                c2++;
            }
        }
     
        if(c1>nums.length/3)
            result.add(n1);
        if(c2>nums.length/3)
            result.add(n2);
     
        return result;
    }
}