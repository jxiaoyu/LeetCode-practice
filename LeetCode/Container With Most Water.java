/**
 * 这种收尾两指针向中间扫描的思路还是蛮常见的
 * 选择正确的策略就一定会经过要找的两个点
 */
public class Solution {
    public int maxArea(int[] height) {
    	if (height == null || height.length < 2) {
    		return 0;
    	}
     
    	int max = 0;
    	int left = 0;
    	int right = height.length - 1;
     
    	while (left < right) {
    		max = Math.max(max, (right - left) * Math.min(height[left], height[right]));
    		if (height[left] < height[right])
    			left++;
    		else
    			right--;
    	}
     
    	return max;
    }
}