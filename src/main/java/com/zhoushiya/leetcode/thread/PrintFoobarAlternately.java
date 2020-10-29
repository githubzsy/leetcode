package com.zhoushiya.leetcode.thread;

import java.util.concurrent.Semaphore;

public class PrintFoobarAlternately {
    private int n;

    public PrintFoobarAlternately(int n) {
        this.n = n;
    }

    Semaphore foo=new Semaphore(1);
    Semaphore bar=new Semaphore(0);
    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            foo.acquire();
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            bar.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            bar.acquire();
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            foo.release();
        }
    }
}
