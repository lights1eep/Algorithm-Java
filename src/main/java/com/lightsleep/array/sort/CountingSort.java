package com.lightsleep.array.sort;
/*
    计数排序
 */
public class CountingSort implements Sort{
    /**
     *
     * @param nums 被排序数组
     */
    public void sort(int[] nums) {
        int n = nums.length;
        int maxValue = nums[0];
        int minValue = nums[0];

        for(int num : nums) {
            maxValue = maxValue >= num ? maxValue : num;
            minValue = minValue <= num ? minValue : num;
        }

        int len = maxValue - minValue + 1;
        int[] buckets = new int[len];

        for(int num : nums) {
            buckets[num - minValue]++;
        }

        int index = 0;
        for(int i = 0; i < len; i++) {
            while(buckets[i] > 0) {
                nums[index++] = minValue + i;
                buckets[i]--;
            }
        }
    }
}
