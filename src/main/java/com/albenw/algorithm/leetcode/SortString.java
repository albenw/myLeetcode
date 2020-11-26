package com.albenw.algorithm.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author alben.wong
 * @since 2020/11/25.
 * leetcode 1370. 上升下降字符串
 * 第一想法是排序后分别从头和尾遍历取字符，记录已经取过的字符
 *
 * 因为题目说明输入只有小写字母，可以用26个桶保存字母的个数。第一次bucket[0]~bucket[25]取出字母，
 * 第二次从bucket[25]~bucket[0]取出，并减1
 */
@Slf4j
public class SortString {

    public String sortString(String s) {
        int[] bucket = new int[26];
        for(int i = 0; i < s.length(); i++){
            bucket[s.charAt(i) - 'a']++;
        }
        StringBuffer sb = new StringBuffer();
        while (sb.length() < s.length()){
            for(int i = 0; i < bucket.length; i++){
                if(bucket[i] > 0){
                    sb.append((char)(i + 'a'));
                    bucket[i]--;
                }
            }
            for(int i = bucket.length - 1; i >= 0; i--){
                if(bucket[i] > 0){
                    sb.append((char)(i + 'a'));
                    bucket[i]--;
                }
            }
        }
        return sb.toString();
    }

    @Test
    public void test(){
        SortString sortString = new SortString();
        String res = sortString.sortString("leetcode");
        log.info("res={}", res);
    }

}
