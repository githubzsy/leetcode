package thread;

import com.zhoushiya.leetcode.thread.PrintZeroEvenOdd;
import org.junit.Test;

import java.util.function.IntConsumer;

/**
 * @author zhoushiya
 * @date 2020/11/8 11:07
 */
public class PrintZeroEvenOddTest {
    IntConsumer intConsumer=new IntConsumer() {
        @Override
        public void accept(int value) {
            System.out.print(value);
        }
    };

    @Test
    public void test1() throws InterruptedException {
        PrintZeroEvenOdd printZeroEvenOdd = new PrintZeroEvenOdd(2000000);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    printZeroEvenOdd.zero(intConsumer);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });


        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    printZeroEvenOdd.even(intConsumer);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    printZeroEvenOdd.odd(intConsumer);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        thread1.start();
        thread2.start();
        thread.join();
        thread1.join();
        thread2.join();
    }


}
