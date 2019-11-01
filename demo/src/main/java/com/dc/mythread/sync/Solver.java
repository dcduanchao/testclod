package com.dc.mythread.sync;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author duanchao
 * @CreateDate: 2019/10/21 0021 11:37
 */
public class Solver {
    final  int N;
    final float[][] data;
    final CyclicBarrier barrier;




    class  Worker implements Runnable{

        int  myRow;
        boolean done = false;

        Worker(int row){
            myRow = row;
        }

        boolean done(){
            return done;
        }

        void processRow(int myRow){
            System.out.println("processing row "+myRow);
            for (int i=0;i<N;i++){
                data[myRow][i]*=10;
                done=true;
            }
        }

        @Override
        public void run() {
            while (!done()){
                processRow(myRow);

                try {
                    barrier.await();
                } catch (InterruptedException e) {
                    return;
                } catch (BrokenBarrierException e) {
                    return;
                }
            }

        }
    }

    public  Solver(float[][] matrix){
        data=matrix;
        N=matrix.length;
        barrier= new CyclicBarrier(N, new Runnable() {
            @Override
            public void run() {
                mergeRow();
            }

          
        });
        for (int i=0;i<N;i++){
            new Thread(new Worker(i)).start();
        }
        waitUntilDone();

    }

    private void waitUntilDone() {
        synchronized ("abc"){
            try {
                System.out.println("main thread waiting");
                "abc".wait();
                System.out.println("main thread notify ");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void mergeRow() {
        System.out.println("merging");
        synchronized ("abc"){
            "abc".notify();
        }
    }


}
