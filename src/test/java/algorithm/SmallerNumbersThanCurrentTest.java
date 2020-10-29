package algorithm;

import com.zhoushiya.leetcode.algorithm.SmallerNumbersThanCurrent;
import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

public class SmallerNumbersThanCurrentTest {

    @Test
    public void test1() {
        int[] result = SmallerNumbersThanCurrent.sample2(new int[]{8, 1, 2, 2, 3});
        Assert.assertArrayEquals(new int[]{4, 0, 1, 1, 3}, result);
    }

    @Test
    public void test2() {
        final int m = 20000000;
        Random random = new Random();
        int[] p = new int[m];
        for (int i = 0; i < p.length; i++) {
            p[i] = random.nextInt(m);
        }

        long start = System.currentTimeMillis();
        SmallerNumbersThanCurrent.sample3(p);
        System.out.println("cost: " + (System.currentTimeMillis() - start));
    }
}

