/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
 
/**
 * 很朴素的解法
 * 但是如果能想到用栈，思路和代码会清晰得多，可见合适的数据结构的重要性
 */
public class NestedIterator implements Iterator<Integer> {
    
    private List<NestedInteger> nestedList;
    
    private int index = 0;
    
    private NestedIterator nest = null;

    public NestedIterator(List<NestedInteger> nestedList) {
        this.nestedList = nestedList;
    }

    @Override
    public Integer next() {
        if (nest != null) {
            return nest.next();
        } else {
            return nestedList.get(index++).getInteger();
        }
    }

    @Override
    public boolean hasNext() {
        while (index < nestedList.size()) {
            if (nest != null) {
                if (!nest.hasNext()) {
                    nest = null;
                    continue;
                }
            } else {
                if (!nestedList.get(index).isInteger()) {
                    nest = new NestedIterator(nestedList.get(index++).getList());
                    continue;
                }
            }
            break;
        }
        if (index < nestedList.size()) {
            return true;
        } else if (nest != null && nest.hasNext()) {
            return true;
        } else {
            return false;
        }
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */