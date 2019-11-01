package com.dc.mythread.exceute;

import java.util.concurrent.Callable;

/**
 * @author duanchao
 * @CreateDate: 2019/10/18 0018 18:37
 */
public class MyCallable implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        return 90;
    }
}
