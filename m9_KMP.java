package DP;
/**
 * 非动态规划题。
 * KMP算法
 * @author myy
 *
 */
import java.util.Scanner;

public class m9_KMP {
	
	public static void main(String[] args){
        String a = "aa";
        String b = "ssdfgaaababasdaba";
        int[] next = kmpnext(a);
        int res = kmp(b, a,next);
        System.out.println(res);
        for(int i = 0; i < next.length; i++){
            System.out.print(next[i]+",");            
        }
        System.out.println(next.length);
    }
    
    public static int kmp(String str, String dest,int[] next){//str文本串  dest 模式串
    	int count=0;
        for(int i = 0, j = 0; i < str.length(); i++){
            if(j > 0 && str.charAt(i) != dest.charAt(j)){
                j = next[j - 1];
            }
            if(str.charAt(i) == dest.charAt(j)){
                j++;
            }
            if(j == dest.length()){
                return i-j+1;
//            	count++;
//            	j=next[j-1];  可用来计算匹配成功的次数。
            }
        }
        return count;
    }
    
    public static int[] kmpnext(String dest){
        int[] next = new int[dest.length()];
        next[0] = 0;
        for(int i = 1,j = 0; i < dest.length(); i++){
            if(j > 0 && dest.charAt(j) != dest.charAt(i)){
                j = next[j - 1];
            }
            if(dest.charAt(i) == dest.charAt(j)){
                j++;
            }
            next[i] = j;
        }
        return next;
    }
    
	// 暴力解法
    public static int bruteForceStringMatch(String source, String pattern)
    {
        int slen = source.length();
        int plen = pattern.length();
        char[] s = source.toCharArray();
        char[] p = pattern.toCharArray();
        int i = 0;
        int j = 0;
        if(slen < plen)
            return -1;                        //如果主串长度小于模式串，直接返回-1，匹配失败
        else
        {
            while(i < slen && j < plen)        
            {
                if(s[i] == p[j])            //如果i,j位置上的字符匹配成功就继续向后匹配
                {
                    i++;
                    j++;
                }
                else
                {
                    i = i - (j -1);            //i回溯到主串上一次开始匹配下一个位置的地方
                    j = 0;                    //j重置，模式串从开始再次进行匹配
                }
            }
            if(j == plen)                    //匹配成功
                return i - j;
            else
                return -1;                    //匹配失败
        }
    }
}
