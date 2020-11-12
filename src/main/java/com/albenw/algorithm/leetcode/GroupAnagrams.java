package com.albenw.algorithm.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.*;

/**
 * @author alben.wong
 * @since 2020/11/12.
 * leetcode 49. 字母异位词分组
 * 不出想法是，用一个map<string, list>来存放结果。两个字符串比较的逻辑是：先排序一下，再跟map的key比较，相同就放进去，key是排好序的字符串
 */
@Slf4j
public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length == 0){
            return new ArrayList<>();
        }
        Map<String, List<String>> map = new HashMap<>();
        for(String str : strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            List<String> strings = map.putIfAbsent(String.valueOf(chars), new ArrayList<String>(){{
                add(str);
            }});
            if(strings != null){
                strings.add(str);
            }
        }
        List<List<String>> res = new ArrayList<>();
        for(Map.Entry<String, List<String>> entry : map.entrySet()){
            res.add(entry.getValue());
        }
        return res;
    }

    @Test
    public void test(){
        GroupAnagrams groupAnagrams = new GroupAnagrams();
        String[] strs = new String[]{
                "eat", "tea", "tan", "ate", "nat", "bat"
        };
        List<List<String>> lists = groupAnagrams.groupAnagrams(strs);
        log.info("lists={}", lists);
    }

}
