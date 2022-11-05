package com.lightsleep.array.search;

public class BinarySearch implements Search{

    /**
     * 二分查找
     * @param nums  有序数组
     * @param value 被查找的值
     * @return 如果找到则返回该值在数组中的索引，否则返回-1
     */
    @Override
    public int search(int[] nums, int value) {
        int left = 0, right = nums.length - 1;
        while(left <= right) {
            int mid = (right - left) / 2 + left;
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
