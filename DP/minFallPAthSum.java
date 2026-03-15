class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        int ans=Integer.MAX_VALUE;
        int dp[][]=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=Integer.MIN_VALUE;
            }
        }
        for(int j=0;j<n;j++){
            ans=Math.min(ans, minFallpathsum(matrix,0,j,m,n,dp));
        
        }
        return ans;
        }
        private int minFallpathsum(int matrix[][], int i, int j, int m, int n, int dp[][]){
        if(i<0||i>=m||j<0||j>=n){
            return Integer.MAX_VALUE;
        }

        if(i==m-1){  //last row m pahoch gye
            return matrix[i][j];
        }

        if(dp[i][j]!=Integer.MIN_VALUE){
            return dp[i][j];
        }
        
        int min=  Math.min(minFallpathsum(matrix,i+1,j,m,n,dp), minFallpathsum(matrix, i+1, j-1, m, n,dp));
        dp[i][j]=matrix[i][j]+ Math.min(min,  minFallpathsum(matrix, i+1, j+1, m, n,dp));
         
         return dp[i][j];
    }
}