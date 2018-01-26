package com.springboot.javaBase.ThreadPoolBase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestThreadPoolExecutoService {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < 5; i++) {
            executorService.execute(new MyThreadRunable(i+""));
        }

        executorService.shutdown();

    }


    static class MyThreadRunable implements Runnable{

        private String runableName;

        MyThreadRunable(String runableName){
            this.runableName = runableName;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName()+":"+runableName);
        }
    }
}
