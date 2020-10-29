package com.zhoushiya.leetcode.thread;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 我们提供了一个类：
 * <p>
 * public class Foo {
 * public void first() { print("first"); }
 * public void second() { print("second"); }
 * public void third() { print("third"); }
 * }
 * 三个不同的线程将会共用一个Foo实例。
 * <p>
 * 线程 A 将会调用 first() 方法
 * 线程 B 将会调用 second() 方法
 * 线程 C 将会调用 third() 方法
 * 请设计修改程序，以确保 second() 方法在 first() 方法之后被执行，third() 方法在 second() 方法之后被执行。
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3]
 * 输出: "firstsecondthird"
 * 解释:
 * 有三个线程会被异步启动。
 * 输入 [1,2,3] 表示线程 A 将会调用 first() 方法，线程 B 将会调用 second() 方法，线程 C 将会调用 third() 方法。
 * 正确的输出是 "firstsecondthird"。
 * 示例 2:
 * <p>
 * 输入: [1,3,2]
 * 输出: "firstsecondthird"
 * 解释:
 * 输入 [1,3,2] 表示线程 A 将会调用 first() 方法，线程 B 将会调用 third() 方法，线程 C 将会调用 second() 方法。
 * 正确的输出是 "firstsecondthird"。
 * <p>
 * 提示：
 * <p>
 * 尽管输入中的数字似乎暗示了顺序，但是我们并不保证线程在操作系统中的调度顺序。
 * 你看到的输入格式主要是为了确保测试的全面性。
 */
public class PrintInOrder {

    /** 使用原子类
    AtomicBoolean firstJobDone=new AtomicBoolean(false);
    AtomicBoolean secondJobDone=new AtomicBoolean(false);

    public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        firstJobDone.set(true);
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (firstJobDone.get()==false) {

        }
        printSecond.run();
        secondJobDone.set(true);
    }

    public void third(Runnable printThird) throws InterruptedException {
        while(secondJobDone.get()==false){

        }
        printThird.run();
    }
     **/



    Semaphore f=new Semaphore(0);
    Semaphore s=new Semaphore(0);

    public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        f.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        f.acquire();
        printSecond.run();
        s.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        s.acquire();
        printThird.run();
    }
}
