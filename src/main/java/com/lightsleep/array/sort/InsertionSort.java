package com.lightsleep.array.sort;
/*
    插入排序
 */
public class InsertionSort implements Sort{
    /**
     *
     * @param nums 被排序数组
     */
    @Override
    public void sort(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            int current = nums[i];
            int j = i - 1;
            // 从后往前遍历，如果元素比current大，则将其后移一位，继续比较
            while(j >= 0 && current < nums[j]) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = current;
        }
    }
}
