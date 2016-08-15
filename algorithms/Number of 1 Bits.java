/**
 * 这题本来没什么可说的，注释部分是我的思路。/2 就是右移，%2 自然就是最右的那位数
 * 但是提交时却遇到一个 2147483648(即2^31) 过不了，才明白这个数强制转换为 int 型后是负数，
 * 像我那样做数学运算的时候会把这个数当成负数处理，而做位运算则不理会它的正负
 */
public class Solution {
    // you need to treat n as an unsigned value
//    public int hammingWeight(int n) {
//        int num = 0;
//        while (n != 0) {
//            if (n % 2 == 1) {
//                num++;
//            }
//            n /= 2;
//        }
//        return num;
//    }

    public int hammingWeight(int n) {
        int count = 0;
        for(int i=1; i<33; i++){
            if(getBit(n, i) == true){
                count++;

            }
        }
        return count;
    }

    public boolean getBit(int n, int i){
        return (n & (1 << i)) != 0;
    }

}