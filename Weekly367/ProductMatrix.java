import java.math.BigInteger;
import java.util.Arrays;

class Solution {
    private static final BigInteger MOD = new BigInteger("12345");
    private static final long MOD_INT = 12345;

    public int[][] constructProductMatrix(int[][] grid) {
        long[][] prefixProduct = new long[grid.length][grid[0].length];
        long[][] suffixProduct = new long[grid.length][grid[0].length];

        // Make a pass to compute the prefixProduct of all elements in the grid
        long product = 1;
        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[0].length; column++) {
                prefixProduct[row][column] = product;
                product = (product * grid[row][column]) % MOD_INT;
            }
        }

        // Make a pass to compute the prefixProduct and suffixProduct of all elements in the grid
        product = 1;
        for (int row = grid.length - 1; row >= 0; row--) {
            for (int column = grid[0].length - 1; column >= 0; column--) {
                suffixProduct[row][column] = product;
                product = (product * grid[row][column]) % MOD_INT;
            }
        }

        // Build the result matrix
        int[][] result = new int[grid.length][grid[0].length];
        for (int row = 0; row < result.length; row++) {
            for (int column = 0; column < result[0].length; column++) {
                // Divide the product by the current element
                result[row][column] = (int)((prefixProduct[row][column] * suffixProduct[row][column]) % MOD_INT);
            }
        }

        return result;
    }

    public int[][] constructProductMatrixSlow(int[][] grid) {
        // Make a pass to compute the product of all elements in the grid
        BigInteger product = BigInteger.ONE;
        for (int[] row : grid) {
            for (int element : row) {
                product = product.multiply(BigInteger.valueOf(element));
            }
        }

        // Build the result matrix
        int[][] result = new int[grid.length][grid[0].length];
        for (int row = 0; row < result.length; row++) {
            for (int column = 0; column < result[0].length; column++) {
                // Divide the product by the current element
                result[row][column] = product.divide(BigInteger.valueOf(grid[row][column])).mod(MOD).intValue();
            }
        }

        return result;
    }

    public static void main(String[] args)
    {
        Solution sol = new Solution();
        System.out.println(
                Arrays.deepToString(sol.constructProductMatrix(new int[][]{{414750857}, {449145368}, {767292749}})));
    }
}