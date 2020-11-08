package thread;

import com.zhoushiya.leetcode.algorithm.BestTimeToBuyAndSellStockII;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author zhoushiya
 * @date 2020/11/8 12:46
 */
public class BestTimeToBuyAndSellStockIITest {
    int[] arr=new int[]{7,1,5,3,6,4};
    int result=7;

    @Test
    public void test1(){
        BestTimeToBuyAndSellStockII bestTimeToBuyAndSellStockII = new BestTimeToBuyAndSellStockII();
        int i= bestTimeToBuyAndSellStockII.myMethod(arr);
        Assert.assertEquals(result,i);

    }
}
