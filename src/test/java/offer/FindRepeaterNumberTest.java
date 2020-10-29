package offer;

import com.zhoushiya.leetcode.offer.FindRepeaterNumber;
import org.junit.Assert;
import org.junit.Test;

public class FindRepeaterNumberTest {
    @Test
    public void test1(){
        int i = new FindRepeaterNumber().myMethod(new int[]{133456, 22, 2, 2, 5, 7, 5, 3, 9, 12});
        Assert.assertEquals(2,i);
    }

    @Test
    public void test2(){
        int i = new FindRepeaterNumber().sample1ms1(new int[]{133456, 22, 2, 2, 5, 7, 5, 3, 9, 12});
        Assert.assertEquals(2,i);
    }

    @Test
    public void test3(){
        int i = new FindRepeaterNumber().sample2ms1(new int[]{133456, 22, 2, 2, 5, 7, 5, 3, 9, 12});
        Assert.assertEquals(2,i);
    }
}
