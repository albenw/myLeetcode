package com.albenw.algorithm.other;

/**
 * @author alben.wong
 * @date 2018/7/13.
 */
import java.util.Arrays;
import java.util.LinkedList;

/**
 * 给出有 n 张牌，第一张放在桌上，第二张放到牌堆底部，要求桌上的牌是有序的 1,2,3,4...n，求原始牌堆的顺序
 */

public class DeskQ1 {

    public static void main(String[] args) {
        initDesk(9);
    }

    public static void initDesk(int n){
        if(n <= 0){
            return;
        }
        int[] origin = initOrigin(n);
        int[] desk = new int[n];
        fillHalfToDesk(desk, origin, 0, n-1, 0, n);
        validate(desk);
    }

    public static void fillHalfToDesk(int[] desk, int[] origin, int startIndex, int lastIndex, int step, int remain){
        if(remain == 1){
            fillLast(desk, origin[lastIndex]);
            return;
        }
        boolean singleMode = remain % 2 == 1 && step > 0;
        int halfIndex = (startIndex + lastIndex ) / 2;
        for(int i = startIndex; i <= halfIndex; i++){
            //空的index（将空的位置看作一个整体）
            int relativeIndex = (i - startIndex) * 2;
            if(!singleMode){

            }else{
                if(step > 0){
                    relativeIndex++;
                    if(relativeIndex >= remain){
                        relativeIndex -= remain;
                    }
                }
            }
            //实际desk的index
            int absoluteIndex = getAbsoluteIndex(relativeIndex, step);
            desk[absoluteIndex] = origin[i];
        }
        System.out.println(String.format("step=%d, desk=%s", step, Arrays.toString(desk)));
        fillHalfToDesk(desk, origin, halfIndex + 1, lastIndex, step + 1,  lastIndex - startIndex + 1);
    }

    public static void fillLast(int[] desk, int value){
        for(int i=0; i < desk.length; i++){
            if(desk[i] == 0){
                desk[i] = value;
            }
        }
    }

    public static int getAbsoluteIndex(int index, int step){
        if(step == 0){
            return index;
        }else {
            while (step > 0) {
                index = 2 * index + 1;
                --step;
            }
        }
        return index;
    }

    public static int[] initOrigin(int n){
        int[] ori = new int[n];
        for(int i = 0; i < n; i++){
            ori[i] = i + 1;
        }
        System.out.println("ori=" + Arrays.toString(ori));
        return ori;
    }

    public static void validate(int[] desk){
        LinkedList<Integer> linkedList = new LinkedList<>();
        for(int i= 0; i < desk.length; i++){
            linkedList.addLast(desk[i]);
        }
        int count = 0;
        while(linkedList.peek() != null){
            int el = linkedList.poll();
            if(count % 2 == 0){
                System.out.print(el + ",");
            }else{
                linkedList.addLast(el);
            }
            count++;
        }
    }

}
