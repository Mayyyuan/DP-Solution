package DP;
/**
 * LCS
 * 最长公共子序列
 * @author myy
 *
 */
import java.util.Arrays;
import java.util.Scanner;
 
public class m2_LCS {
    public static void main(String[] args) {
    	int[] A={3,6,5,7,8,3,4};
    	int[] B={4,1,3,6,2,3,4};
        System.out.println(findLCSLianXu(A, A.length, B, B.length));
//        System.out.println(findLCS2(A,B,A.length));
    }
    
    // O(n2)，不要求子序列连续
    public static int findLCS(int[] A, int n, int[] B, int m) {
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (A[i - 1] == B[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                	dp[i][j]=Math.max(dp[i - 1][j] , dp[i][j - 1]);
                }
                
            }
        }
        return dp[n][m];
    }
    
    // 要求子序列连续
    public static int findLCSLianXu(int[] A, int n, int[] B, int m) {
        int[][] dp = new int[n + 1][m + 1];
        int max=0;
        int lo=-1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (A[i - 1] == B[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                if(max<dp[i][j]) {
                	max=dp[i][j];
                	lo=i-1;
                }
            }
        }
        for(int i=lo-max+1;i<=lo;i++) {
        	System.out.print(A[i]+"ij");
        }
        return max;
    }
    
    // 0(nlogn)，类似二分法
    public static int findLCS2(int[] A,int[] B,int n) {
    	int[] pos=new int[n];
    	for(int i=1;i<n;i++) {
    		pos[B[i]]=i;
    	}
    	for(int i=0;i<n;i++) {
    		A[i]=pos[A[i]];
    	}
    	int[] dp=new int[n+1];
    	dp[1]=A[0];
    	int len=1;
    	int start=0;
    	int end=len;
    	int mid;
    	for(int i=0;i<n;i++) {
    		if(A[i]>dp[len]) {
    			len++;
    			dp[len]=A[i];
    		}
    		else {
    			start=1;
    			end=len;
    			mid=(start+end)/2;
    			if(dp[mid]<A[i]) {
    				start=mid+1;
    			}
    			else {
    				end=mid-1;
    			}
    		}
    		dp[start]=A[i];
    	}
    	return len;
    }
}