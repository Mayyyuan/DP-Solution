package DP;
/**
 * 最大子序列乘积
 * @author myy
 *
 */
public class m4_MULP {
	public static void main(String[] args) {
		int[] A={2,5,-1,3};
		
		int res1=maxProduct1(A);
		System.out.println("1:"+res1);
		
		int res2=maxProduct2(A);
		System.out.println("2:"+res2);
	}
	
	// 子序列不连续
	private static int maxProduct1(int[] A) {
		if(A.length<1) {
			return Integer.MIN_VALUE;
		}
		int max=A[0];
		int min=A[0];
		int res = max;
		for(int i=1;i<A.length;i++) {
			int cur1=max*A[i];
			int cur2=min*A[i];
			max=Math.max(max,cur1);
			min=Math.min(min,cur2);
			res=Math.max(max,min);
		}
		return res;
	}
	
	// 子序列连续
	private static int maxProduct2(int[] A) {
		if(A.length<1) {
			return Integer.MIN_VALUE;
		}
		int max=A[0];
		int min=A[0];
		int res = max;
		for(int i=1;i<A.length;i++) {
			int cur1=max*A[i];
			int cur2=min*A[i];
			max=Math.max(Math.max(cur1,cur2),A[i]);
			min=Math.min(Math.min(cur1,cur2),A[i]);
			res=Math.max(res,max);
		}
		return res;
	}
}
