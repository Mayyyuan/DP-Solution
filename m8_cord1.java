package DP;
/**
 * 切割绳子使乘积最大
 * @author myy
 *
 */
public class m8_cord1 {
	
	public static void main(String[] args) {
		System.out.println(maxProductAfterCutting(8));
	}
	
	public static int maxProductAfterCutting(int length){
		if(length<2) {  //长度小于2 无法分割
			return 0;
		}
		if(length==2) {
			return 1;
		}
		if(length==3) {
			return 2;
		}
		int[] dp=new int[length+1];  //定义一个存放>=4 长度的数组 ，对>=4长度的最大的乘积进行临时存储
		dp[1]=1;
		dp[2]=2;
		dp[3]=3;
		for(int i=4;i<=length;i++) {
			
			for(int j=1;j<=i/2;j++) {
				dp[i]=Math.max(dp[i], dp[j]*dp[i-j]);
			}
		}
		return dp[length];
	}
}
