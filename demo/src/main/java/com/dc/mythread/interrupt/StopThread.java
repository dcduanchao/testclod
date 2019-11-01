package com.dc.mythread.interrupt;

/**
 * @author duanchao
 * @CreateDate: 2019/10/17 0017 15:58
 */
public class StopThread  {

    public static void main(String[] args) {
        class  StopT extends Thread{

            private  boolean stop;
            @Override
            public void run() {
            synchronized (this){
                while (!stop){
                    System.out.println("running");
                }
                System.out.println("stop");

            }

            }

            synchronized  void  stopS(){
                stop=true;
            }
        }

        StopT stopT = new StopT();
        stopT.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        stopT.stopS();


    }
}
