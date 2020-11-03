package algorithm;

import com.zhoushiya.leetcode.algorithm.SumRootToLeafNumbers;
import com.zhoushiya.leetcode.algorithm.TreeNode;
import org.junit.Test;

public class SumRootToLeafNumbersTest {
    TreeNode t=new TreeNode(1,new TreeNode(2,new TreeNode(4,null,new TreeNode(6,null,new TreeNode(7,null,null))),new TreeNode(5,null,null)),new TreeNode(3,null,null));


    @Test
    public void test1(){
        int i = SumRootToLeafNumbers.myMethod(t);
        System.out.println(i);
    }

    @Test
    public void test2(){
        int sample = new SumRootToLeafNumbers().sumNumbers(t);
        System.out.println(sample);
    }
}
