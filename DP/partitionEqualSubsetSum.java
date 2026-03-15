class Solution {
    public boolean canPartition(int[] nums) {
        int total = 0;
        for (int x : nums) total += x;

        
        if (total % 2 != 0) return false;

        int target = total / 2;
        int n = nums.length;

        Boolean dp[][] = new Boolean[n][target + 1];

        return solve(nums, 0, 0, target, dp);
    }

    private boolean solve(int nums[], int currSum, int i, int target, Boolean dp[][]) {

      
        if (currSum == target) return true;

        
        if (i >= nums.length || currSum > target) return false;

       
        if (dp[i][currSum] != null) return dp[i][currSum];

       
        boolean include = solve(nums, currSum + nums[i], i + 1, target, dp);

        
        boolean exclude = solve(nums, currSum, i + 1, target, dp);

        return dp[i][currSum] = include || exclude;
    }
}
