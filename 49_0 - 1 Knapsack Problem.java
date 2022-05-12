class Solution 
{ 
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
         // your code here 
         int dp[][]=new int[n+1][W+1];
         for(int i=0;i<W+1;i++)
         {
             dp[0][i]=0;
         }
         //Did this for 1 based indexing. Avoid to reduce space complexity
         int nwt[]=new int[n+1];
         for(int i=0;i<n+1;i++)
         {
             if(i==0)
             nwt[i]=0;
             else
             nwt[i]=wt[i-1];
         }
         //Did this for 1 based indexing. Avoid to reduce space complexity
         int nval[]=new int[n+1];
         for(int i=0;i<n+1;i++)
         {
             if(i==0)
             nval[i]=0;
             else
             nval[i]=val[i-1];
         }
         for(int item=1;item<n+1;item++)
         {
             for(int capacity=0;capacity<W+1;capacity++)
             {
                if(nwt[item]>capacity)
                dp[item][capacity]=dp[item-1][capacity];
             else
             {
                 dp[item][capacity]=Math.max(dp[item-1][capacity],nval[item]+dp[item-1][capacity-nwt[item]]);
             }
             }
         }
         return dp[n][W];
    } 
}
