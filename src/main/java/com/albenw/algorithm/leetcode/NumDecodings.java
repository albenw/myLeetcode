package com.albenw.algorithm.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author alben.wong
 * @since 2020/12/22.
 * leetcode 91. 解码方法
 *
 * 1、递归 - 自上而下
 * 这个是我第一时间想到，但是实现起来思路还有有点混乱，看了别人的代码才恍然大悟
 * 递归，感觉就是：如果要求"这个"，那么要先求"那个"，然后一直递归下去，最后把所有的"那个"的结果加起来
 *
 * 2、dp - 自下而上
 * 这题的dp是比较难想到的，因为如果缺少经验的话，挺难判断一道题究竟可不可以用dp
 * 定义dp[i]为到s[i]的解码总数，那么下面就是要分析dp[i]怎么依赖之前的结果，即dp[i - 1]，dp[i - 2]等等
 *
 * dp更像是递推，比较直观的就是"一个个字母"的递推下去
 */
@Slf4j
public class NumDecodings {

    public int numDecodings(String s) {
        if(s.length() == 0){
            return 0;
        }
        return dp(s);
    }

    private int dp(String s){
        int n = s.length();
        if(s.charAt(0) == '0'){
            return 0;
        }
        int[] dp = new int[n + 1];
        // 代码里的dp[0]，实际上表示的是公式里的dp[-1]。-1这个肯定没有含义，但是注意到情况二和情况三，在一开始i=1，没有dp[i-2]这个值，
        // 而此时又必须给现有的编码数量加一（因为在这两种情况下多了一种编码方案），所以最好的办法就是初始化一个dp[-1] 或者 pre 等于1。
        // 这种做法保证了代码的统一和简洁。
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 1; i < n; i++){
            if(s.charAt(i) == '0'){
                //10或20的情况
                if(s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2'){
                    dp[i + 1] = dp[i - 1];
                }else{
                    //不存在"0"开头的情况
                    return 0;
                }
            }else{
                //s[i-1]s[i]两位数要小于26的情况
                if(s.charAt(i - 1) == '1' || (s.charAt(i - 1) == '2' && s.charAt(i) < '7')){
                    dp[i + 1] = dp[i] + dp[i - 1];
                }else{
                    //其他情况
                    dp[i + 1] = dp[i];
                }
            }
        }
        return dp[n];
    }

    /**
     * 递归方法 - 自上而下
     * 例如求"123"，先求"23"，然后递归求"3"
     * PS：在leetcode上用递归会超时...
     * @param s
     * @param index - 当前递归的层次
     * @return
     */
    private int dfs(String s, int index){
        if(index == s.length()){
            return 1;
        }
        //出现为"0"开头的情况，因为没有对应的编码，所以为0
        if(s.charAt(index) == '0'){
            return 0;
        }
        //递归用一个字母的情况
        int one = dfs(s, index + 1);
        //递归用两个字母的情况，包括"当前" + "下一个"
        int two = 0;
        if(index + 1 < s.length()){
            //在字母范围内才有意义，否则没有递归下去的意义
            if(s.charAt(index) == '1' || (s.charAt(index) == '2' && s.charAt(index + 1) < '7')){
                two = dfs(s, index + 2);
            }
        }
        //总数 = 一个字母的情况 + 两个字母的情况
        return one + two;
    }

    @Test
    public void test(){
        NumDecodings numDecodings = new NumDecodings();
        int i = numDecodings.numDecodings("2611055971756562");
        log.info("i={}", i);
    }

}
