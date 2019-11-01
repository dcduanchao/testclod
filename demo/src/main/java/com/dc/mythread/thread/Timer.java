package com.dc.mythread.thread;

import java.util.TimerTask;

/**
 * @author duanchao
 * @CreateDate: 2019/10/18 0018 13:44
 */
public class
Timer {

    public static void main(String[] args) {

        timerTest1();
    }

    private static void timerTest1() {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("on *********");
            }
        };

        java.util.Timer timer = new java.util.Timer();
        timer.schedule(task,0,1000);
    }
}
