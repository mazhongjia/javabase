package com.mzj.javabase.thread.spinlock.demo2._02_ticketLock;

import com.mzj.javabase.thread.spinlock.demo2.Lock;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Ticket Lock自旋锁
 */
public class TicketLock implements Lock {
    private AtomicInteger serviceNum = new AtomicInteger(0);
    private AtomicInteger ticketNum = new AtomicInteger(0);
    private final ThreadLocal<Integer> myNum = new ThreadLocal<>();

    @Override
    public void lock() {
        myNum.set(ticketNum.getAndIncrement());
        while (serviceNum.get() != myNum.get()) {
        }
    }

    @Override
    public void unlock() {
        serviceNum.compareAndSet(myNum.get(), myNum.get() + 1);
        myNum.remove();
    }
}
