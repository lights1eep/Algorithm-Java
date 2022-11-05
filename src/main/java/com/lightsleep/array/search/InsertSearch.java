package com.lightsleep.array.search;

public class InsertSearch implements Search{
    /**
     * 插值查找
     * @param nums  有序数组
     * @param value 被查找的值
     * @return      如果找到则返回该值在数组中的索引，否则返回-1
     */
    @Override
    public int search(int[] nums, int value) {
        int left = 0, right = nums.length - 1;
        while(left <= right) {
            // 最右侧值是被查找的值需要单独判断，否则可能会有除零的问题
            if(nums[right] == value) {
                return right;
            }
            int mid = left + (right - left) * (value - nums[left]) / (nums[right] - value);
            if(nums[mid] < value) {
                left = mid + 1;
            } else if (nums[mid] > value) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
