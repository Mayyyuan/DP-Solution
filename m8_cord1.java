package DP;
/**
 * �и�����ʹ�˻����
 * @author myy
 *
 */
public class m8_cord1 {
	
	public static void main(String[] args) {
		System.out.println(maxProductAfterCutting(8));
	}
	
	public static int maxProductAfterCutting(int length){
		if(length<2) {  //����С��2 �޷��ָ�
			return 0;
		}
		if(length==2) {
			return 1;
		}
		if(length==3) {
			return 2;
		}
		int[] dp=new int[length+1];  //����һ�����>=4 ���ȵ����� ����>=4���ȵ����ĳ˻�������ʱ�洢
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
