class Solution
{
	public int maxSumIS(int arr[], int n)  
	{  
	    int dp[] = new int[n];
	    int omax = Integer.MIN_VALUE;
	    
	    for(int i = 0; i < n; i++)
	    {
	        int max = 0;
	        for(int j = 0; j < i; j++)
	        {
	            if(arr[j] < arr[i])
                    max = Math.max(max, dp[j]);
	            
	        }
	        dp[i] = max + arr[i];
	        
	        omax = Math.max(omax , dp[i]);
	    }
	    return omax;
	}  
}