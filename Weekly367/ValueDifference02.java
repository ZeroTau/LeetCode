import java.util.Arrays;

class Solution03 {
    public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        // Min and max locations in nums[:index]
        int minIndex = 0;
        int maxIndex = 0;

        // Current locations in nums, index and prefixIndex will always be indexDifference apart
        int prefixIndex = 0;
        int index = indexDifference;

        // Iterate over all ending indices
        while(index < nums.length)
        {
            // Update min and max locations
            if (nums[prefixIndex] < nums[minIndex]) {
                minIndex = prefixIndex;
            }
            if (nums[prefixIndex] > nums[maxIndex]) {
                maxIndex = prefixIndex;
            }

            // Check if the difference is large enough
            if (nums[maxIndex] - nums[index] >= valueDifference) {
                return new int[]{maxIndex, index};
            }
            if (nums[index] - nums[minIndex] >= valueDifference) {
                return new int[]{minIndex, index};
            }

            // Move to then next pair
            prefixIndex++;
            index++;
        }

        // No such pair found
        return new int[]{-1, -1};
    }

    public static void main(String[] args)
    {
        Solution03 sol = new Solution03();
        System.out.println(Arrays.toString(sol.findIndices(new int[]{5, 1, 4, 1}, 2, 4)));
        System.out.println(Arrays.toString(sol.findIndices(new int[]{2, 1}, 0, 0)));
        System.out.println(Arrays.toString(sol.findIndices(new int[]{1, 2, 3}, 2, 4)));
    }
}