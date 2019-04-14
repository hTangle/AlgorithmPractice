package com.nevergetme.designmode.productconsumer;


import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducterAndConsumer {
    private final int MAX_LEN=10;
    final Lock lock=new ReentrantLock();
    final Condition notFull=lock.newCondition();
    final Condition notEmpty=lock.newCondition();
    public void put()throws InterruptedException{
        lock.lock();
        try {
            while (queue.size()>=MAX_LEN){
                notFull.await();
            }
            queue.add(1);
            System.out.println("add one and total "+queue.size());
            notEmpty.signal();
        }finally {
            lock.unlock();
        }
    }
    public void take()throws InterruptedException{
        lock.lock();
        try {
            while (queue.size()==0){
                notEmpty.await();
            }
            queue.poll();
            System.out.println("take one and left "+queue.size());
            notFull.signal();
        }finally {
            lock.unlock();
        }
    }
    private Queue<Integer> queue=new LinkedList<Integer>();
//    class Producter extends Thread{
//        public void run(){
//            producer();
//        }
//        private void producer(){
//            while (true){
//                synchronized (queue){
//                    while (queue.size()==MAX_LEN){
//                        queue.notify();
//                        System.out.println("full");
//                        try {
//                            queue.wait();
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                    queue.add(1);
//                    System.out.println("produce:"+queue.size());
//                    queue.notifyAll();
//                    try {
//                        Thread.sleep(500);
//                    }catch (InterruptedException e){
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }
//    }
//    class Consumer extends Thread{
//        public void run(){
//            consumer();
//        }
//        private void consumer(){
//            while (true){
//                synchronized (queue){
//                    while (queue.size()==0){
//                        System.out.println("empty");
//                        try {
//                            queue.wait();
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                    queue.poll();
//                    System.out.println("consumer:"+queue.size());
//                    queue.notifyAll();
//                    try {
//                        Thread.sleep(500);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }
//    }
    public static void main(String[] args){
        ProducterAndConsumer pac=new ProducterAndConsumer();
        Productor p=new Productor(pac);
        Consumer c=new Consumer(pac);
        Thread t1=new Thread(p);
        Thread t2=new Thread(c);
        t1.start();
        t2.start();
//        Producter p=pac.new Producter();
//        Consumer c=pac.new Consumer();
//        p.start();
//        c.start();
    }
}
class Productor implements Runnable{
    private ProducterAndConsumer p;
    public Productor(ProducterAndConsumer p){
        this.p=p;
    }
    @Override
    public void run() {
        while (true){
            try {
                p.put();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class Consumer implements Runnable{
    private ProducterAndConsumer p;
    public Consumer(ProducterAndConsumer p){
        this.p=p;
    }
    @Override
    public void run() {
        while (true){
            try {
                p.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
