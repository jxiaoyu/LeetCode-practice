public class RandomizedCollection {
    List<Integer> nums;
    HashMap<Integer, Set<Integer>> locs;
    Random rand = new Random();

    /**
     * Initialize your data structure here.
     */
    public RandomizedCollection() {
        nums = new ArrayList<Integer>();
        locs = new HashMap<Integer, Set<Integer>>();
    }

    /**
     * Inserts a value to the collection. Returns true if the collection did not already contain the specified element.
     */
    public boolean insert(int val) {
        Set<Integer> indexSet;
        boolean contain = locs.containsKey(val);
        if (!contain) {
            indexSet = new HashSet<Integer>();
        } else {
            indexSet = locs.get(val);
        }
        indexSet.add(nums.size());
        locs.put(val, indexSet);
        nums.add(val);
        return !contain;
    }

    /**
     * Removes a value from the collection. Returns true if the collection contained the specified element.
     */
    public boolean remove(int val) {
        boolean contain = locs.containsKey(val);
        if (!contain) {
            return false;
        }
        Set<Integer> indexSet = locs.get(val);
        Integer loc = indexSet.iterator().next();
        if (loc < nums.size() - 1 && nums.get(nums.size() - 1) != val) {
            int lastone = nums.get(nums.size() - 1);
            nums.set(loc, lastone);
            locs.get(lastone).remove(nums.size() - 1);
            locs.get(lastone).add(loc);
            indexSet.remove(loc);
        } else {
            indexSet.remove(nums.size() - 1);
        }
        if (indexSet.size() == 0) {
            locs.remove(val);
        }
        nums.remove(nums.size() - 1);
        return true;
    }

    /**
     * Get a random element from the collection.
     */
    public int getRandom() {
        return nums.get(rand.nextInt(nums.size()));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */