package DP;
/**
 * �Ƕ�̬�滮�⡣
 * KMP�㷨
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
    
    public static int kmp(String str, String dest,int[] next){//str�ı���  dest ģʽ��
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
//            	j=next[j-1];  ����������ƥ��ɹ��Ĵ�����
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
    
	// �����ⷨ
    public static int bruteForceStringMatch(String source, String pattern)
    {
        int slen = source.length();
        int plen = pattern.length();
        char[] s = source.toCharArray();
        char[] p = pattern.toCharArray();
        int i = 0;
        int j = 0;
        if(slen < plen)
            return -1;                        //�����������С��ģʽ����ֱ�ӷ���-1��ƥ��ʧ��
        else
        {
            while(i < slen && j < plen)        
            {
                if(s[i] == p[j])            //���i,jλ���ϵ��ַ�ƥ��ɹ��ͼ������ƥ��
                {
                    i++;
                    j++;
                }
                else
                {
                    i = i - (j -1);            //i���ݵ�������һ�ο�ʼƥ����һ��λ�õĵط�
                    j = 0;                    //j���ã�ģʽ���ӿ�ʼ�ٴν���ƥ��
                }
            }
            if(j == plen)                    //ƥ��ɹ�
                return i - j;
            else
                return -1;                    //ƥ��ʧ��
        }
    }
}
