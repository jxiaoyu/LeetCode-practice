public class Solution {

    private int[] original, shuffled;
    Random rnd = new Random();

    public Solution(int[] nums) {
        this.original = nums;
        this.shuffled = original.clone();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return original;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        for (int i = shuffled.length - 1; i >= 1; i--) {
            int tmp = shuffled[i];
            int rand = rnd.nextInt(i + 1);
            shuffled[i] = shuffled[rand];
            shuffled[rand] = tmp;
        }
        return shuffled;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */