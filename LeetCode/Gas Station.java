/** 
 * 从 gas[0] 开始，到下一站，发现汽油不够，则向上一站回溯，够则一直往下跑
 */
public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int i = 0, j = gas.length, remain = 0;
        boolean forward = true;
        while (j > i) {
            if (forward) {
                remain += gas[i] - cost[i];
            } else {
                remain += gas[j] - cost[j];
            }
            if (remain >= 0) {
                forward = true;
                i++;
            } else {
                forward = false;
                j--;
            }
        }
        if (remain >= 0) {
            return j % (gas.length);
        } else {
            return -1;
        }
    }
}