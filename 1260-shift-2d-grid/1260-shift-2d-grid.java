class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {

        int m = grid.length;
        int n = grid[0].length;

        k %= (m * n);

        int idx = 0;
        int[] nums = new int[m * n];

        // Flatten the grid
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                nums[idx++] = grid[i][j];
            }
        }

        // Rotate the 1D array
        rotate(nums, k);

        // Build the answer from the rotated array
        List<List<Integer>> ans = new ArrayList<>();
        idx = 0;

        for (int i = 0; i < m; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add(nums[idx++]);
            }
            ans.add(row);
        }

        return ans;
    }

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;

        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    private void reverse(int[] nums, int l, int r) {
        while (l < r) {
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
    }
}