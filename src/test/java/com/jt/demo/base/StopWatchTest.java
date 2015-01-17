package com.jt.demo.base;

import com.google.common.base.Stopwatch;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * @author he
 * @since 2015/1/17
 */
public class StopWatchTest {

    @Test
    public void test01() throws InterruptedException {
        Stopwatch stopwatch = new Stopwatch();
        stopwatch.start();
        System.out.println("start");
        Thread.sleep(1000);
        stopwatch.stop();
        System.out.println("stop");
        System.out.println("waste " + stopwatch.elapsed(TimeUnit.MILLISECONDS));
    }
}
