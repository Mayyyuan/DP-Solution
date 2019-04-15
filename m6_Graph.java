package DP;
/**
 * 求有向图的最短路径
 * @author myy
 *
 */
import java.util.Arrays;

public class m6_Graph {
	public static void main(String[] args) {
		int[][] a={{0,1,3,0},{0,0,0,7},{0,0,0,4},{0,7,4,0}};  // 节点连接情况
		System.out.println(helper(a));
	}
	
	public static int helper(int[][] array) {
		int[] dp=new int[array.length];
		Arrays.fill(dp,Integer.MAX_VALUE);
		dp[0]=0;
		int[] pre=new int[array.length];
		for(int i = 0;i<array.length;i++){  //从矩阵a的第一行开始，一行行找相连的节点
			for(int j = 0;j<array.length;j++){
				if(array[i][j]!=0){  //找到了相连节点
					int d = dp[i]+array[i][j];  //上一个节点的最短路径的值+与下一个节点相连路径上的值
					if(d<dp[j]){  //判断是否比原先的值要小，如果小就将0-j节点的长度替换
						dp[j] = d;
						pre[j] = i+1;  //记录前一个节点的序号
					}
				}
			}
		}
		int i=pre.length-1;
		while(i>0) {
			System.out.print(pre[i]+",");
			i=pre[i]-1;
		}
		return dp[array.length-1];
	}
}
