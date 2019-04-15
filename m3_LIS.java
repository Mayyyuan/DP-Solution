package DP;
/**
 * LIS
 * �����������
 * @author myy
 *
 */
import java.util.ArrayList;
import java.util.Scanner;

public class m3_LIS{
    public static void main(String[] args) {
//            LIS1(L);
//        	LIS(L);
            
        	int[] L={1,2,3,4};
        	LIS2(L);
//            ArrayList<Integer> res=maxSubIncreaseArray(L);
//            Object[] ress=res.toArray();
//            for(int i=0;i<ress.length;i++) {
//            	System.out.println(ress[i]);
//            }
    }
    
    // ����������У���������(O(n2))
    public static int LIS1(int[] L) {
    	int res=0;
    	int[] dp = new int[L.length];
        dp[0]=1;
        for(int i = 1;i<L.length;i++) {
        	dp[i]=1;
            for(int j=0;j<i;j++) {
            	if(L[j]<L[i]) {
            		dp[i]=Math.max(dp[j]+1,dp[i]);
            	}
            }
            System.out.println(i+":"+dp[i]);
            res=Math.max(dp[i],res);
        }
        System.out.println("LIS1:"+res);    
        return res;
    }
    
    // ����������� ����
    public static int LIS(int[] L) {
    	int res=0;
    	int[] dp=new int[L.length];
    	dp[0]=1;
    	for(int i=1;i<L.length;i++) {
    		dp[i]=1;
    		if(L[i]>L[i-1]) {
    			dp[i]=dp[i-1]+1;
    		}
    		res=Math.max(dp[i],res);
    	}
    	System.out.println("LIS:"+res);
    	return res;
    }
    
    // ����������У���������(O(logn))
    public static void LIS2(int[] L) {
    	int[] dp=new int[L.length+1];
    	dp[1]=L[0];
    	int len=1;
    	int start=0;
    	int end=len;
    	int mid;
    	for(int i=1;i<L.length;i++) {
    		if(L[i]>dp[len]) {
    			len++;
    			dp[len]=L[i];
    		}
    		else {
    			start=1;
    			end=len;
    			while(start<=end) {
    				mid=(start+end)/2;
    				if(dp[mid]<L[i]) {
    					start=mid+1;
    				}
    				else {
    					end=mid-1;
    				}
    			}
    			dp[start]=L[i];
    		}
    	}
    	System.out.println("LIS2:"+len);
    }
    
    // ����������е�����
    public static ArrayList<Integer> maxSubIncreaseArray(int[] L){    
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(L[0]);
        res.add(list);
        int[] dp = new int[L.length];
        int index = -1;  //���ڱ�ǵ�ǰԪ��֮ǰ�ĵ�һ�����������е�λ��
        int maxIndex = 0;  //���ڱ�Ǹ����е�����������е�λ��
        int max = 0;  //����������еĳ���
        dp[0] = 1;  //���б����ڱ�ǰ�����ǰԪ�����ڵ�ǰ�벿�ֵ�����������еĳ���        
        for(int i=1;i<L.length;i++){
            index = -1;
            list = new ArrayList<Integer>();
            dp[i]=1;
            for(int j=0;j<i;j++){
                if(L[j]<L[i] && dp[j]>dp[i]-1){
                    dp[i] = dp[j]+1;
                    index = j; 
                }
            }
            if(index>-1) {
                list.addAll(res.get(index));
            }
            list.add(L[i]);
            res.add(list);
            if(dp[i]>max){
                max = dp[i];
                maxIndex = i;
            }
        }
        System.out.println(max);
        return res.get(6);
    }
}
