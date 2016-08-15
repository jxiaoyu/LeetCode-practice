/**
 * 这题简直就是为 Binary Indexed Tree 而设
 */
class BIT {
    private int[] bit;

    public int query(int index) {
        index = index + 1;
        int sum = 0;
        while (index > 0) {
            sum += bit[index];
            index -= index & (-index);
        }
        return sum;
    }

    public void add(int index, int val) {
        index = index + 1;
        while (index < bit.length) {
            bit[index] += val;
            index += index & (-index);
        }
    }

    public BIT(int len) {
        bit = new int[len + 1];
    }
}

public class NumArray {

    private BIT bit;

    public NumArray(int[] nums) {
        bit = new BIT(nums.length);
        for (int i = 0; i < nums.length; i++) {
            bit.add(i, nums[i]);
        }
    }

    void update(int i, int val) {
        bit.add(i, val - (bit.query(i) - bit.query(i - 1)));
    }

    public int sumRange(int i, int j) {
        return bit.query(j) - bit.query(i - 1);
    }
}

// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.update(1, 10);
// numArray.sumRange(1, 2);