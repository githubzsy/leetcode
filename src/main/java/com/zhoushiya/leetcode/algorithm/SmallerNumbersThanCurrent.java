package com.zhoushiya.leetcode.algorithm;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;

/**
 * 给你一个数组nums，对于其中每个元素nums[i]，请你统计数组中比它小的所有数字的数目。
 * <p>
 * 换而言之，对于每个nums[i]你必须计算出有效的j的数量，其中 j 满足j != i 且 nums[j] < nums[i]。
 * <p>
 * 以数组形式返回答案。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [8,1,2,2,3]
 * 输出：[4,0,1,1,3]
 * 解释：
 * 对于 nums[0]=8 存在四个比它小的数字：（1，2，2 和 3）。
 * 对于 nums[1]=1 不存在比它小的数字。
 * 对于 nums[2]=2 存在一个比它小的数字：（1）。
 * 对于 nums[3]=2 存在一个比它小的数字：（1）。
 * 对于 nums[4]=3 存在三个比它小的数字：（1，2 和 2）。
 * 示例 2：
 * <p>
 * 输入：nums = [6,5,4,8]
 * 输出：[2,1,0,3]
 * 示例 3：
 * <p>
 * 输入：nums = [7,7,7,7]
 * 输出：[0,0,0,0]
 */
public class SmallerNumbersThanCurrent {
    public static void main(String[] args) {

    }

    /**
     * 我的算法，使用哈希表和快速排序
     * @param nums
     * @return
     */
    public static int[] myMethod(int[] nums) {
        int[] sort = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sort);

        // 使用哈希表，提升性能
        // {元素，元素最小索引}
        HashMap<Integer,Integer> smallerCount = new HashMap<Integer, Integer>();
        for (int i = 0; i < sort.length; i++) {
            if (!smallerCount.containsKey(sort[i])) {
                smallerCount.put(sort[i], i);
            }
        }

        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = smallerCount.get(nums[i]);
        }

        return result;
    }

    /**
     * 官方解答2，使用二元数组和快排
     * @param nums
     * @return
     */
    public static int[] sample2(int[] nums) {
        int n = nums.length;
        // 二元数组，记录值与索引
        int[][] data = new int[n][2];
        for (int i = 0; i < n; i++) {
            data[i][0] = nums[i];
            data[i][1] = i;
        }

        // 快速排序
        Arrays.sort(data, new Comparator<int[]>() {
            public int compare(int[] data1, int[] data2) {
                return data1[0] - data2[0];
            }
        });


        int[] ret = new int[n];
        int smallerCount = -1;
        for (int i = 0; i < n; i++) {
            // 如果当前为第一个索引的元素，那么它一定最小，即smallerCount为0
            // 或者如果当前索引的元素与前一个索引的元素相等，那么比它小的元素数目不会改变，即smallerCount不变
            if (smallerCount == -1 || data[i][0] != data[i - 1][0]) {
                smallerCount = i;
            }
            ret[data[i][1]] = smallerCount;
        }
        return ret;
    }

    /**
     * 官方算法3
     * @param nums
     * @return
     */
    public static int[] sample3(int[] nums) {
        int[] cnt = new int[nums.length];
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            cnt[nums[i]]++;
        }
        for (int i = 1; i <= 100; i++) {
            cnt[i] += cnt[i - 1];
        }
        int[] ret = new int[n];
        for (int i = 0; i < n; i++) {
            ret[i] = nums[i] == 0 ? 0 : cnt[nums[i] - 1];
        }
        return ret;
    }




    /**
     * 快速排序
     *
     * @param arr        待排序列
     * @param leftIndex  待排序列起始位置
     * @param rightIndex 待排序列结束位置
     */
    private static void quickSort(int[] arr, int leftIndex, int rightIndex) {
        if (leftIndex >= rightIndex) {
            return;
        }

        int left = leftIndex;
        int right = rightIndex;
        //待排序的第一个元素作为基准值
        int key = arr[left];

        //从左右两边交替扫描，直到left = right
        while (left < right) {
            while (right > left && arr[right] >= key) {
                //从右往左扫描，找到第一个比基准值小的元素
                right--;
            }

            //找到这种元素将arr[right]放入arr[left]中
            arr[left] = arr[right];

            while (left < right && arr[left] <= key) {
                //从左往右扫描，找到第一个比基准值大的元素
                left++;
            }

            //找到这种元素将arr[left]放入arr[right]中
            arr[right] = arr[left];
        }
        //基准值归位
        arr[left] = key;
        //对基准值左边的元素进行递归排序
        quickSort(arr, leftIndex, left - 1);
        //对基准值右边的元素进行递归排序。
        quickSort(arr, right + 1, rightIndex);
    }


    /**
     * 冒泡排序
     *
     * @param nums
     */
    static void popSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    int temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                }
            }
        }
    }
}
