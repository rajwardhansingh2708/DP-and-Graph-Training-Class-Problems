class Solution {
    
    public int knapsack(int W, int val[], int wt[]) {
        int n = val.length;
        return solve(n-1, W, val, wt);
    }
    
    int solve(int i, int W, int val[], int wt[]) {
        
        if(i == 0){
            if(wt[0] <= W) return val[0];
            return 0;
        }
        
        int notTake = solve(i-1, W, val, wt);
        
        int take = Integer.MIN_VALUE;
        if(wt[i] <= W)
            take = val[i] + solve(i-1, W - wt[i], val, wt);
        
        return Math.max(take, notTake);
    }
}
