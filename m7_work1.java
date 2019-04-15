package DP;
/**
 * ��������������ֵ
 * @author myy
 *
 */
public class m7_work1 {
	
	public static void main(String[] args) {
		int[] pre = new int[] {0,0,0,1,0,2,3,5};  //�洢��ѡ���i������ʱ����ǰ��������������ţ�0��ʾ������
		int[] v = new int[] {5,1,8,4,6,3,2,4};  //�洢ÿ����������Ӧ�ļ�ֵ
		
		System.out.println(rec_opt(v,pre,8));
		System.out.println(dp_opt(v,pre));
	}
		
	//����������Եõ�������ֵ(�ݹ鷨)
	public static int rec_opt(int[] v,int[] pre,int i) {
		if(i<=0)
			return 0;
		if(i==1) 
			return v[i-1];
		int choice = v[i-1] + rec_opt(v,pre,pre[i-1]);
		int notChoice = rec_opt(v,pre,i-1);
		return Math.max(notChoice,choice);
	}
		
	//����������Եõ�������ֵ(��̬�滮��)
	public static int dp_opt(int[] v,int[] pre) {
		int[] dp = new int[v.length+1];
		dp[0] = 0;
		dp[1] = v[0];
		for(int i=1;i<dp.length;i++) {
//			int choice = v[i-1]+dp[pre[i-1]];
//			int notChoice = dp[i-1];
			
			dp[i] = Math.max(dp[i-1],v[i-1]+dp[pre[i-1]]);
		}
		return dp[dp.length-1];
	}
}