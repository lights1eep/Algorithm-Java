package com.lightsleep.array.sort;

import com.lightsleep.utils.SortUtil;

/*
    选择排序
 */
public class SelectionSort implements Sort {
    /**
     *
     * @param nums 被排序数组
     */
    @Override
    public void sort(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            int index = i;
            for(int j = i; j < n ; j++) {
                if(nums[j] < nums[index]) {
                    index = j;
                }
            }
            SortUtil.swap(nums, index, i);
        }
    }
}
