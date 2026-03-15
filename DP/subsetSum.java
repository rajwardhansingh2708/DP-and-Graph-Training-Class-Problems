class Solution {

    static Boolean isSubsetSum(int arr[], int sum) {

        int n = arr.length;
        Boolean dp[][] = new Boolean[n+1][sum+1];

        return solve(arr,n,sum,dp);
    }
    
    static Boolean solve(int arr[], int n, int sum, Boolean dp[][]){

        if(sum == 0) {
            return true;
        }
        if(n == 0){
            return false;
        }

        if(dp[n][sum] != null) {
            return dp[n][sum];
        }

        if(arr[n-1] <= sum){
            dp[n][sum] = solve(arr,n-1,sum-arr[n-1],dp) 
                         || solve(arr,n-1,sum,dp);
        } 
        else{
            dp[n][sum] = solve(arr,n-1,sum,dp);
        }

        return dp[n][sum];
    }
}