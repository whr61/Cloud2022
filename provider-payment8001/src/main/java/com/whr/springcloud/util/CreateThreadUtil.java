package com.whr.springcloud.util;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/*
 * @author Reed
 * @Description
 * @date 2022/11/20 14:23
 **/

public class CreateThreadUtil {

    public static ThreadPoolExecutor createThread(int threadSize)
    {
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
                .setNameFormat("测试信息").build();//创建线程工厂

        //创建线程池
        ThreadPoolExecutor executor = new ThreadPoolExecutor(threadSize,
                threadSize,
                0L,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(1024),
                namedThreadFactory,
                new ThreadPoolExecutor.AbortPolicy());
        return executor;
    }
}