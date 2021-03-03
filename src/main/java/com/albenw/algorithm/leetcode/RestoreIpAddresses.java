package com.albenw.algorithm.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * @author alben.wong
 * @since 2021/3/3.
 * leetcode 93. 复原 IP 地址
 *
 * 这题很明显就是用回溯解决的
 * 回溯方法要知道
 * 1、当前匹配字符的index
 * 2、当前尝试第几个IP（一共最多可以有4个）
 *
 * ps：回溯结束判断：当前已经有4个IP了，且刚好遍历完字符串
 */
@Slf4j
public class RestoreIpAddresses {

    private static final Integer MAX_COUNT = 4;

    //最终结果
    private List<String> ans = new LinkedList<>();
    //临时ip, 0 ~ 255
    private int[] segments = new int[MAX_COUNT];

    public List<String> restoreIpAddresses(String s) {
        dfs(s, 0, 0);
        return ans;
    }

    private void dfs(String s, int segStart, int curCount){
        //回溯结束
        if(curCount == MAX_COUNT){
            if(segStart == s.length()){
                addIp(segments, ans);
            }
            return;
        }
        //ip不够4个，但是已经遍历完字符
        if(segStart == s.length()){
            return;
        }
        //对"0"的处理，如果当前为0，则只能把"0"作为一个segment加入这样处理
        if(s.charAt(segStart) == '0'){
            segments[curCount] = 0;
            dfs(s, segStart + 1, curCount + 1);
        }
        //每个字符看看是不是有效ip范围，"segment"变量用作累加
        int segment = 0;
        for(int i = segStart; i < s.length(); i++){
            segment = segment * 10 + (s.charAt(i) - '0');
            if(segment > 0 && segment <= 255){
                //找到一个合法的ip，从下一个字符开始回溯
                segments[curCount] = segment;
                dfs(s, i + 1, curCount + 1);
            }else{
                //如果不在有效ip范围则直接退出
                break;
            }
        }
    }

    private void addIp(int[] segments, List<String> ans){
        String sb = segments[0] + "." +
                segments[1] + "." +
                segments[2] + "." +
                segments[3];
        ans.add(sb);
    }

    @Test
    public void test(){
        RestoreIpAddresses restoreIpAddresses = new RestoreIpAddresses();
        List<String> strings = restoreIpAddresses.restoreIpAddresses("010010");
        log.info("strings={}", strings);
    }
}
