class Solution {
    int minCost(int[] height) {
        int n=height.length;
        int dp[]=new int[n+1];
        for(int i=0;i<n;i++){
            dp[i]=-1;
        }
        return solve(height, n-1, dp);
    }
    private int solve(int height[], int i, int dp[]){
        if(i==0){
            return 0;
        }
        if(i==1){
            return Math.abs(height[1]-height[0]);
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        int cost1=solve(height,i-1, dp)+Math.abs(height[i]-height[i-1]);
        int cost2=Integer.MAX_VALUE;
        if(i>1){
            cost2=solve(height, i-2, dp)+Math.abs(height[i]-height[i-2]);
        }
        dp[i]= Math.min(cost1, cost2);
        return dp[i];
    }
}
