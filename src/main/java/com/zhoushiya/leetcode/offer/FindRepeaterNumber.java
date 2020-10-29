package com.zhoushiya.leetcode.offer;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 找出数组中重复的数字。
 * <p>
 * <p>
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 *  
 * <p>
 * 限制：
 * <p>
 * 2 <= n <= 100000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindRepeaterNumber {
    public int myMethod(int[] nums) {
        HashSet<Integer> repeater = new HashSet<>();
        int r = -1;
        for (int num : nums) {
            if (repeater.add(num) == false) {
                r = num;
                break;
            }
        }
        return r;
    }

    public int sample1ms1(int[] nums) {
        for (int i = 0; i < nums.length; ++i) {
            while (i != nums[i]) {
                if (nums[nums[i]] == nums[i]) {
                    return nums[i];
                }
                int temp = nums[nums[i]];
                nums[nums[i]] = nums[i];
                nums[i] = temp;
            }
        }
        return -1;
    }

    public int sample2ms1(int[] nums) {
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (res[nums[i]] < 0) return nums[i];
            res[nums[i]] = -1;
        }
        return 0;
    }
}
