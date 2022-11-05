package com.lightsleep.array.search;

public class SequenceSearch implements Search{
    /**
     * 顺序查找
     * @param nums  数组
     * @param value 被查找值
     * @return  如果找到则返回该值在数组中的索引，否则返回-1
     */
    @Override
    public int search(int[] nums, int value) {
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            if(nums[i] == value) {
                return i;
            }
        }
        return -1;
    }
}
