package algorithm;

import com.zhoushiya.leetcode.algorithm.BinaryTreePreorderTraversal;
import com.zhoushiya.leetcode.algorithm.TreeNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreePreorderTraversalTest {
    TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4, null, new TreeNode(6, null, new TreeNode(7, null, null))), null), new TreeNode(3, new TreeNode(5, null, null), null));

    List<Integer> result = Arrays.asList(1, 2, 4, 6, 7, 3, 5);
    BinaryTreePreorderTraversal b= new BinaryTreePreorderTraversal();
    @Test
    public void test1() {
        List<Integer> r=new LinkedList<>();
        b.myMethod(root,r);
        System.out.println(r);
        Assert.assertEquals(result,r);
    }

    @Test
    public void test2(){
        List<Integer> r =b.myMethod2(root);
        System.out.println(r);
        Assert.assertEquals(result,r);
    }

    @Test
    public void test3(){
        List<Integer> r = b.myMethod3(root);
        System.out.println(r);
        Assert.assertEquals(result,r);
    }
}
