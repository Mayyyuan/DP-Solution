package DP;

import java.util.Arrays;

public class m1_coins {
	
	public static void main(String[] args) {
		int[] coins={1,5,10,21};
		int moneys=41;
		System.out.println(makeChange1(coins,moneys));
		System.out.println(makeChange2(coins,moneys));
	}
	
	public static int makeChange1(int[] coins,int moneys) {
		int[] dp=new int[moneys+1];
		Arrays.fill(dp,moneys+1);
		dp[0]=0;
		for(int money=0;money<=moneys;money++) {
			for(int kind=0;kind<coins.length;kind++) {
				if(coins[kind]<=money) {
					dp[money]=Math.min(dp[money],dp[money-coins[kind]]+1);
				}
			}
		}
		return dp[moneys]>moneys? -1:dp[moneys];
	}

	// ̰���㷨���������������������
	// �磬��6�������㣬3+3Ӳ����<4+1+1Ӳ����
	public static int makeChange2(int[] coins,int moneys) {
		int[] nums=new int[coins.length];
		int res=0;
		for(int kind=coins.length-1;kind>=0;kind--) {
			while((nums[kind]+1)*coins[kind]<=moneys) {
				nums[kind]++;
			}
			moneys-=nums[kind]*coins[kind];
		}
		for(int i=0;i<nums.length;i++) {
			res+=nums[i];
		}
		System.out.println(res);
		return res;
	}
}
