package com.zhoushiya.leetcode.algorithm;

import sun.reflect.generics.tree.Tree;

import java.awt.*;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.*;
import java.util.List;

/**
 * 129. 求根到叶子节点数字之和
 * 给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。
 *
 * 例如，从根到叶子节点路径 1->2->3 代表数字 123。
 *
 * 计算从根到叶子节点生成的所有数字之和。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 *     1
 *    / \
 *   2   3
 * 输出: 25
 * 解释:
 * 从根到叶子节点路径 1->2 代表数字 12.
 * 从根到叶子节点路径 1->3 代表数字 13.
 * 因此，数字总和 = 12 + 13 = 25.
 * 示例 2:
 *
 * 输入: [4,9,0,5,1]
 *     4
 *    / \
 *   9   0
 *  / \
 * 5   1
 * 输出: 1026
 * 解释:
 * 从根到叶子节点路径 4->9->5 代表数字 495.
 * 从根到叶子节点路径 4->9->1 代表数字 491.
 * 从根到叶子节点路径 4->0 代表数字 40.
 * 因此，数字总和 = 495 + 491 + 40 = 1026.
 */
public class SumRootToLeafNumbers {

    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    public int dfs(TreeNode root, int prevSum) {
        if (root == null) {
            return 0;
        }
        int sum = prevSum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        } else {
            // 左树之和 + 右树之和
            return dfs(root.left, sum) + dfs(root.right, sum);
        }
    }


    /**
     * 遍历实现
     * @param pointer
     */
    public static int myMethod(TreeNode pointer) {
        if(pointer==null) return 0;
        List<TreeNode> nodes =new LinkedList<>();
        Stack<Integer> rightNoScanIndexes=new Stack<>();
        List<Integer> numbers=new LinkedList<>();

        boolean rightNoScan=false;
        int one=0;

        while(true){

            if(pointer.left!=null){
                rightNoScan=pointer.right!=null;
                nodes.add(pointer);
                one = one*10+pointer.val;
                if(rightNoScan){
                    rightNoScanIndexes.push(nodes.size()-1);
                }
                pointer=pointer.left;
                continue;
            }

            if(pointer.right!=null){
                nodes.add(pointer);
                one = one*10+pointer.val;
                pointer=pointer.right;
                continue;
            }

            // 加入末级节点
            nodes.add(pointer);

            // 计算数值
            one = one*10+pointer.val;
            numbers.add(one);

            if(rightNoScanIndexes.empty()){
                break;
            }

            // 跳转到上一个未扫描的右节点
            int returnIndex=rightNoScanIndexes.pop();

            int size=nodes.size();
            for (int i = size-1; i >returnIndex  ; i--) {
                one=one/10;
                nodes.remove(i);
            }

            pointer=nodes.get(returnIndex).right;

        }

        return numbers.stream().mapToInt(t->t).sum();
    }
}
