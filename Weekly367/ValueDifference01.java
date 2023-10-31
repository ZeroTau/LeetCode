import java.util.Arrays;

class Solution01 {
    public int[] findIndices(int[] nums, int minIndexDifference, int minValueDifference) {
        for (int startIndex = 0; startIndex < nums.length; startIndex++) {
            for (int endIndex = startIndex + minIndexDifference; endIndex < nums.length; endIndex++) {
                if (Math.abs(nums[startIndex] - nums[endIndex]) >= minValueDifference) {
                    return new int[]{startIndex, endIndex};
                }
            }
        }

        // No such pair found
        return new int[]{-1, -1};
    }

    public static void main(String[] args)
    {
        Solution01 sol = new Solution01();
        System.out.println(Arrays.toString(sol.findIndices(new int[]{5, 1, 4, 1}, 2, 4)));
        System.out.println(Arrays.toString(sol.findIndices(new int[]{2, 1}, 0, 0)));
        System.out.println(Arrays.toString(sol.findIndices(new int[]{1, 2, 3}, 2, 4)));
    }
}