package DP;
/**
 * 0-1背包问题，求最大价值
 * 核心公式：M[I,J]=max(M(i-1,j),M(i-1,j-si)+vi);
 * @author myy
 *
 */
import java.util.ArrayList;

public class m5_bag {
	
	public static void main(String[] args) {
		int[] v={1,2,4,5,6};  // 物品价值
		int[] s={1,2,1,4,2};  // 物品质量
		int c=9;  // 背包容量
		int res=zeroOneBag(v,s,c);
		System.out.println(res);
	}
	
	public static int zeroOneBag(int[] v,int[] s,int bag) {
		int[][] dp=new int[v.length+1][bag+1];
		for(int j=0;j<=bag;j++) {
			dp[0][j]=0;
		}
		for(int i=1;i<=v.length;i++) {
			for(int j=1;j<=bag;j++) {
				if(s[i-1]<=j) {
					dp[i][j]=Math.max(dp[i-1][j], dp[i-1][j-s[i-1]]+v[i-1]);
				}
				else {
					dp[i][j]=dp[i-1][j];
				}
			}
		}
		
		int cbag=bag;
		ArrayList<Integer> res=new ArrayList<Integer>();
		int count=0;
		for(int i=v.length;i>0;i--) {
			if(dp[i][cbag]!=dp[i-1][cbag]) {
				res.add(i);
				cbag-=s[i-1];
				count++;
			}
		}
		for(int i=0;i<count;i++) {
			System.out.println("res:"+res.get(i));
		}
		return dp[v.length][bag];
	}
}
