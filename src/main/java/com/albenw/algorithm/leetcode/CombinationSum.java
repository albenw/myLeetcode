package com.albenw.algorithm.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author alben.wong
 * @since 2020/11/9.
 * leetcode 39. 组合总和
 * 这题可以用贪心：对于每个数字尽取，然后再减少一个去尝试去取下一个数
 * 不过，我个人比较喜欢用回溯，因为逻辑清晰一点
 *
 * 我的写法需要将结果去重...并不是最优，效率很低，不过总算过了
 */
@Slf4j
public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(candidates, target, res, new ArrayList<>());
        return res;
    }

    public void backtrack(int[] candidates, int target, List<List<Integer>> res, List<Integer> combinationList){
        if(target < 0){
            return;
        }
        if(target == 0){
            if(!isDup(res, combinationList)){
                res.add(new ArrayList<>(combinationList));
            }
            return;
        }
        for(int i = 0; i < candidates.length; i++){
            int count = target / candidates[i];
            for(int j = 1; j <= count; j++){
                //加入k个candidates[i]
                for(int k = 0; k < j; k++){
                    combinationList.add(candidates[i]);
                }
                backtrack(candidates, target - candidates[i] * j, res, combinationList);
                //去掉k个candidates[i]
                for(int k = 0; k < j; k++){
                    combinationList.remove(combinationList.size() - 1);
                }
            }
        }
    }

    private boolean isDup(List<List<Integer>> res, List<Integer> combinationList){
        ArrayList<Integer> copy = new ArrayList<>(combinationList);
        Collections.sort(copy);
        for(List<Integer> tmp : res){
            if(tmp.size() != combinationList.size()){
                continue;
            }
            Collections.sort(tmp);
            if(copy.equals(tmp)){
                return true;
            }
        }
        return false;
    }

    @Test
    public void test(){
        CombinationSum combinationSum = new CombinationSum();
        int[] nums = new int[]{2,7,6,3,5,1};
        List<List<Integer>> lists = combinationSum.combinationSum(nums, 9);
        log.info("lists={}", lists);
    }
}
