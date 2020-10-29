package com.zhoushiya.leetcode.algorithm;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个二叉树，返回它的 前序 遍历。
 * <p>
 *  示例:
 * <p>
 * 输入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * 输出: [1,2,3]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-preorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BinaryTreePreorderTraversal {
    /**
     * 递归实现
     *
     * @param root
     * @param r
     */
    public void myMethod(TreeNode root, List<Integer> r) {
        r.add(root.val);
        if (root.left != null) {
            myMethod(root.left, r);
        }
        if (root.right != null) {
            myMethod(root.right, r);
        }
    }

    /**
     * Morris 遍历的核心思想是利用树的大量空闲指针，实现空间开销的极限缩减。其前序遍历规则总结如下：
     *
     * 1.新建临时节点，令该节点为 root；
     *
     * 2.如果当前节点的左子节点为空，将当前节点加入答案，并遍历当前节点的右子节点；
     *
     * 3.如果当前节点的左子节点不为空，在当前节点的左子树中找到当前节点在中序遍历下的前驱节点：
     *
     *     - 如果前驱节点的右子节点为空，将前驱节点的右子节点设置为当前节点。然后将当前节点加入答案，并将前驱节点的右子节点更新为当前节点。
     *
     *     - 如果前驱节点的右子节点为当前节点，将它的右子节点重新设为空。当前节点更新为当前节点的右子节点。
     *
     * 重复步骤 2 和步骤 3，直到遍历结束。
     *
     * 这样我们利用 Morris 遍历的方法，前序遍历该二叉树，即可实现线性时间与常数空间的遍历。
     *
     * @param root
     */
    public List<Integer> morris(TreeNode root){
        List<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }

        TreeNode p1 = root, p2 = null;

        while (true) {

            if (p1.left == null) {
                res.add(p1.val);
                if(p1.right!=null){
                    p1=p1.right;
                }
                
            } else {

            }
        }

    }

    /**
     * 迭代实现
     * @param root
     * @return
     */
    public List<Integer> myMethod3(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        if(root==null) return result;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(stack.empty()==false){
            root=stack.pop();
            result.add(root.val);
            if(root.right!=null){
                stack.push(root.right);
            }

            if(root.left!=null){
                stack.push(root.left);
            }
        }
        return result;
    }



    /**
     * 迭代实现
     *
     * @param root
     * @return
     */
    public List<Integer> myMethod2(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        if(root==null) return result;
        result.add(root.val);

        Stack<TreeNode> stack = new Stack<>();
        while (true) {
            if (root.left != null) {
                result.add(root.left.val);
                if (root.right != null) {
                    stack.push(root.right);
                }
                root = root.left;
                continue;
            }

            if (root.right != null) {
                result.add(root.right.val);
                root = root.right;
                continue;
            }

            if (stack.empty()) {
                break;
            } else {
                root = stack.pop();
                result.add(root.val);
            }
        }

        return result;
    }
}
