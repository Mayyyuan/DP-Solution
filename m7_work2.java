package DP;
/**
 * 求n小时工作的最大价值
 * @author myy
 *
 */
import java.util.HashMap;
import java.util.Map;

public class m7_work2 {
	public static void main(String[] args) {
        int[] L={1,2,3,4,5,6,7,8,9,10};  // 每个工作所花时间
        int[] v={1,5,8,9,10,17,17,20,24,30};  // 每个工作每小时的价值
 
        int n=5;
        System.out.println(getMaxProfit(L,v,n));  
        System.out.println(getMaxProfit_2(L,v,n));

    }
	
	//递归法
    public static int getMaxProfit(int[] L,int[] v,int n)
    {
        if(n==0)
            return 0;
        int profit = 0;
 
        for(int i=1;i<=n;i++)
        {
            profit = Math.max(profit,v[i-1]+getMaxProfit(L,v,n-L[i-1]));
        }
 
        return profit;
    }
    
    //自底向上的动态规划
    public static int getMaxProfit_2(int[] L,int[] v,int n)
    {
        int []dp=new int[L.length+1];
        for(int i=1;i<dp.length;i++)
        {
//            int bestProfit=-1;
            for(int j=0;j<L.length;j++) //内循环求得r[i]的最优解
            	if(L[j]<=i) {
            		dp[i]=Math.max(dp[i], v[j]+dp[i-L[j]]);
            	}
//            dp[i]=bestProfit;//外循环保存每个最优解
        }
        return dp[n];
    }
}
