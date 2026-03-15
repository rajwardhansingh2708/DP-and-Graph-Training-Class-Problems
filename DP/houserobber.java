class Solution{
    public int rob(int[] nums){
        int n =nums.length;
        int dp[]=new int[n+1];
        for(int i=0; i<n;i++){
            dp[i]=-1;
        }
        

        return maxMoney(nums, n-1, dp);
        
    }
        
        private int maxMoney(int[] nums, int i, int[] dp){
            if(i==0){
                return nums[0];

            }
             if(i==1){
                return Math.max(nums[0], nums[1]);
             }
             if(dp[i]!=-1){
                return dp[i];
             }
             int include=nums[i]+maxMoney(nums, i-2, dp);
             int exclude=maxMoney(nums, i-1, dp);
             dp[i]=Math.max(include, exclude);
             return dp[i];
        }
    }
