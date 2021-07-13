package zyz.algorithm.array.DynamicProgramming.medium;

import zyz.algorithm.utils.Utils;

/**
 * @author zyz
 * @title: 交错字符串  该题思路很秒
 * @seq: 27
 * @address: https://leetcode-cn.com/problems/interleaving-string/
 * @idea:
 *  当作走迷宫来做 当作那道只能向下或者向右走的迷宫,但是这里需要有个dp=new boolean[m+1][n+1]; 即考虑s1为空和s2匹配 s2为空和s1匹配
 *  作为初始条件 不清楚看题解
 *  1.dp[i][j]:字符串s1的前i个字符和字符串s2的前j个字符串是否交错组成s3的前i+j个字符
 *  2.if s1[i]==s3[i+j] dp[i][j]=dp[i-1][j]  if s1[j]==s3[i+j]  dp[i][j]=dp[i][j-1]
 */
public class InterleavingString_27 {
    public static void main(String[] args) {
        boolean[] f=new boolean[2];

        String s1="",  s2="", s3 = "a";
        System.out.println(isInterleave(s1,s2,s3));
    }

    public static boolean isInterleave(String s1, String s2, String s3) {

        if (s1.length()+s2.length()!=s3.length()) return  false;
        int m=s1.length();
        int n=s2.length();
        boolean[][] dp=new boolean[m+1][n+1];
        dp[0][0]=true;
        for(int j=1;j<=n;j++)
        {
            if(s2.substring(0,j).equals(s3.substring(0,j)))
                dp[0][j]=true;
        }
        for(int j=0;j<=m;j++)
        {
            if(s1.substring(0,j).equals(s3.substring(0,j)))
                dp[j][0]=true;
        }
        for(int i=1;i<=m;i++)
        {
            for(int j=1;j<=n;j++)
            {
                if((s1.charAt(i-1)==s3.charAt(i+j-1)&&dp[i-1][j])||(s2.charAt(j-1)==s3.charAt(i+j-1)&&dp[i][j-1]))
                {
                    dp[i][j]=true;
                }else{
                    dp[i][j]=false;
                }

            }
        }

        Utils.print2Arr(dp);
        return dp[m][n];
    }
}
