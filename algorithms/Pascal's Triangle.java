/**
 * 杨辉三角西方叫帕斯卡三角
 */
public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if (numRows <= 0) {
            return list;
        }
        List<Integer> first = new ArrayList<>();
        first.add(1);
        list.add(first);
        
        if (numRows == 1) {
            return list;
        }
        
        for (int i = 1; i < numRows; i++) {
            List<Integer> line = new ArrayList<>();
            line.add(1);
            List<Integer> last = list.get(i-1);
            for (int j = 0; j < last.size() - 1; j++) {
                line.add(last.get(j) + last.get(j + 1));
            }
            line.add(1);
            list.add(line);
        }
        return list;
    }
}