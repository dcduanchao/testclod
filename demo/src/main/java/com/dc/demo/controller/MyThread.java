package com.dc.demo.controller;

/**
 * @author duanchao
 * @CreateDate: 2019/9/19 0019 16:18
 */
public class MyThread   {


    public static void main(String[] args) {
        for (int i= 0;i<10;i++){
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    for (int i= 0;i<100000;i++){
                        if((i/100)==0){
                            System.out.println(Thread.currentThread().getName()+i);
                        }
                    }
                }
            };
            new Thread(runnable).start();
        }
    }

}
