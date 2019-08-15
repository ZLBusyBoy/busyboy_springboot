/*
 * DrinkTeaManage.java  * Created on  2019/8/15
 * Copyright (c) 2019 YueTu
 * YueTu TECHNOLOGY CO.,LTD. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of
 * YueTu Ltd. ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use
 * it only in accordance with the terms of the license agreement you
 * entered into with YueTu Ltd.
 */
package cn.busyboy.spingboot_demo.drink_tea;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * @author ling.zhang
 */
public class DrinkTeaManage {


    public static void main(String[] args) throws ExecutionException, InterruptedException {

        FutureTask<String> f2 = new FutureTask<>(new Task2());
        FutureTask<String> f1 = new FutureTask<String>(new Task1(f2));

        Thread t1 = new Thread(f1);
        t1.start();
        Thread t2 = new Thread(f2);
        t2.start();

        System.out.println(f1.get());
    }


    static class Task1 implements Callable<String>{

        FutureTask<String> ft2;

        Task1(FutureTask<String> ft2){
            this.ft2 = ft2;
        }

        @Override
        public String call() throws Exception {

            System.out.println("洗水壶.......");
            TimeUnit.SECONDS.sleep(1);

            System.out.println("烧开水........");
            TimeUnit.SECONDS.sleep(15);

            String tfS = ft2.get();
            System.out.println("拿到茶叶：" + tfS);

            System.out.println("泡茶.....");
            return "上茶" + tfS;
        }
    }


    static class Task2 implements Callable<String>{
        @Override
        public String call() throws Exception {

            System.out.println("洗茶壶.......");
            TimeUnit.SECONDS.sleep(1);

            System.out.println("洗茶杯........");
            TimeUnit.SECONDS.sleep(1);

            System.out.println("拿到茶叶...");

            return "铁观音";
        }
    }
}
