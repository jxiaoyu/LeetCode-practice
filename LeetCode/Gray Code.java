/**
 * 从最小的规模开始讨论，找到规律就不难了
 */
public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        if (n < 1) {
            return list;
        }
        
        list.add(1);
        int base = 2;
        for (int i = 1; i < n; i++) {
            for (int j = list.size() - 1; j >= 0; j--) {
                list.add(base + list.get(j));
            }
            base <<= 1;
        }
        return list;
    }
}