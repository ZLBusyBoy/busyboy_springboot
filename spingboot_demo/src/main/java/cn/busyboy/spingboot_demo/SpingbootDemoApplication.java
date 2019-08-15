package cn.busyboy.spingboot_demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootApplication
@EnableConfigurationProperties
public class SpingbootDemoApplication {

    public static void main(String[] args) {

        int startThreadNum = 10;
        ConcurrentHashMap<String,Long> hashMap = new ConcurrentHashMap<>();
        ExecutorService executorService = Executors.newFixedThreadPool(startThreadNum);
        CountDownLatch downLatch = new CountDownLatch(startThreadNum);
        for (int i = 0; i < startThreadNum ; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        long begin =System.currentTimeMillis();
                        Thread.sleep(new Random(1000).nextInt());
                        long end = System.currentTimeMillis() - begin;

                        hashMap.put(Thread.currentThread().getId() + "",end);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }finally {
                        downLatch.countDown();
                    }
                }
            });
        }
        try {
            downLatch.await();
        }catch (Exception e){
            e.printStackTrace();
        }


        hashMap.forEach((k,v)-> {

        });

        /*SpringApplication.run(SpingbootDemoApplication.class, args);*/
    }

}
