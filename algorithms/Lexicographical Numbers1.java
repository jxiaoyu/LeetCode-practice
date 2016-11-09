public class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> list = new ArrayList(n);
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        
        Collections.sort(list, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return String.valueOf(a).compareTo(String.valueOf(b));
            }
        });
        
        return list;
    }
}