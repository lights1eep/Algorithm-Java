package com.lightsleep.array.sort;

import com.lightsleep.utils.SortUtil;


public class BubbleSort implements Sort {
    /**
     * 冒泡排序
     * @param nums  被排序数组
     */
    @Override
    public void sort(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < n - 1; i++) {
            for(int j = 0; j < n - i - 1; j++) {
                if(nums[j] > nums[j + 1]) {
                    SortUtil.swap(nums, j, j + 1);
                }
            }
        }
    }
}
