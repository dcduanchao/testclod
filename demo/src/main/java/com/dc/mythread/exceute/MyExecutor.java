package com.dc.mythread.exceute;

import com.dc.mythread.thread.MyRunable;

import java.util.concurrent.*;

/**
 * @author duanchao
 * @CreateDate: 2019/10/18 0018 14:25
 */
public class MyExecutor implements  Executor{
 volatile  static int a =10;

    @Override
    public void execute(Runnable command) {
        System.out.println("123456");
    }


    public static void main(String[] args) throws Exception {
//        MyExecutor myExecutor = new MyExecutor();
//
//        MyRunable myRunable = new MyRunable();
//        myExecutor.execute(myRunable);

//        Callable<Object> rung = Executors.callable(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("rung");
//                a--;
//                System.out.println(a);
//            }
//        },a);
//
//        Object call = rung.call();
//        System.out.println(call);

//        ExecutorService executorService = Executors.newFixedThreadPool(1);
//
//        Future<Integer> submit = executorService.submit(new MyCallable());
//        Integer integer = submit.get();
//        System.out.println(integer);
//*******************************************
        FutureTask<Integer> task = new FutureTask(() -> {
            int i =0;
            while (true){
                i++;
                if(i>5){
                    break;
                }
            }
            Thread.sleep(1000);
            System.out.println("i值"+i);
            return  i;

        });
        boolean done = task.isDone();
        System.out.println(done);

        new Thread(task).start();
        System.out.println(task.get());




    }



}
