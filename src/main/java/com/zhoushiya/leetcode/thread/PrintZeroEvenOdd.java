package com.zhoushiya.leetcode.thread;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * @author zhoushiya
 * @date 2020/11/8 10:44
 */
public class PrintZeroEvenOdd {

    private int n;

    public PrintZeroEvenOdd(int n) {
        this.n = n;
    }

    /* 原始线程同步：14s */
    private volatile int state = -1;
    private volatile int i = 1;

    public void zero(IntConsumer printNumber) throws InterruptedException {
        while (true) {
            if (i > n) return;
            while (state != -1) {
                Thread.yield();
            }
            if (i <= n) {
                printNumber.accept(0);
                state = i % 2;
            } else {
                state = i % 2;
                return;
            }

        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        while (true) {
            if (i > n) return;
            while (state != 0) {
                Thread.yield();
            }

            if (i <= n) {
                printNumber.accept(i);
                i++;
                state = -1;
            } else {
                state = -1;
                return;
            }
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        while (true) {
            if (i > n) return;
            while (state != 1) {
                Thread.yield();
            }
            if (i <= n) {
                printNumber.accept(i);
                i++;
                state = -1;
            } else {
                state = -1;
                return;
            }
        }
    }

    /* 信号量实现 47s749ms
    private volatile int i = 1;


    Semaphore z = new Semaphore(1);
    Semaphore e = new Semaphore(0);
    Semaphore o = new Semaphore(0);

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        while (true) {
            z.acquire();
            if(i<=n){
                printNumber.accept(0);
                if (i % 2 == 1) {
                    o.release();
                } else {
                    e.release();
                }
            }
            else{
                e.release();
                o.release();
                return;
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        while (true) {
            e.acquire();
            if(i<=n){
                printNumber.accept(i);
                i++;
                z.release();
            }
            else {
                z.release();
                return;
            }
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        while (true) {
            o.acquire();
            if(i<=n){
                printNumber.accept(i);
                i++;
                z.release();
            }
            else {
                z.release();
                return;
            }
        }
    }
     */



}
