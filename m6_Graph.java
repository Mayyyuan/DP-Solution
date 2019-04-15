package DP;
/**
 * ������ͼ�����·��
 * @author myy
 *
 */
import java.util.Arrays;

public class m6_Graph {
	public static void main(String[] args) {
		int[][] a={{0,1,3,0},{0,0,0,7},{0,0,0,4},{0,7,4,0}};  // �ڵ��������
		System.out.println(helper(a));
	}
	
	public static int helper(int[][] array) {
		int[] dp=new int[array.length];
		Arrays.fill(dp,Integer.MAX_VALUE);
		dp[0]=0;
		int[] pre=new int[array.length];
		for(int i = 0;i<array.length;i++){  //�Ӿ���a�ĵ�һ�п�ʼ��һ�����������Ľڵ�
			for(int j = 0;j<array.length;j++){
				if(array[i][j]!=0){  //�ҵ��������ڵ�
					int d = dp[i]+array[i][j];  //��һ���ڵ�����·����ֵ+����һ���ڵ�����·���ϵ�ֵ
					if(d<dp[j]){  //�ж��Ƿ��ԭ�ȵ�ֵҪС�����С�ͽ�0-j�ڵ�ĳ����滻
						dp[j] = d;
						pre[j] = i+1;  //��¼ǰһ���ڵ�����
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
