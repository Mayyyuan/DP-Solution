package DP;

/**
 * �Ƕ�̬�滮�⡣
 * n�������и���ȷ�m�ݣ�����󳤶�
 * @author myy
 *
 */
public class m8_cord2 {
	public static void main(String[] args) {
		int[] L={1,2,3};
		System.out.println(maxLength(L,L.length,3));
	}
	public static double maxLength(int[] L,int n,int m) {
		for(int i=0;i<L.length;i++) {
			L[i]*=100;
		}
		int l=1;
		while(isOK(L,n,m,l)) {
			l*=2;
		}
		int end=l;  // ��ʱ��lΪ�����Էָ�ĳ���
		int start=l/2;  // Ŀǰ���Էָ�ĳ���
		while(true) {
			if(isOK(L,n,m,start) && !isOK(L,n,m,start+1)) {
				break;
			}
			int mid=(start+end)/2;
			if(isOK(L,n,m,mid)) {
				start=mid;
			}
			else {
				end=mid;
			}
		}
		return start/100.0;
	}
	public static boolean isOK(int[] L,int n,int m,int l) {
		int count=0;
		for(int i=0;i<L.length;i++) {
			count+=L[i]/l;
		}
		if(count>=m) {
			return true;
		}
		return false;
	}
}
