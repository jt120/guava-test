package com.jt.demo.base;

import com.google.common.base.Splitter;
import org.junit.Test;

/**
 * @author he
 * @since 2015/1/17
 */
public class SplitterTest {

    Splitter splitter = Splitter.on(",").omitEmptyStrings().trimResults();

    @Test
    public void test01() {
        String s = "hello,ok,ggg";
        Iterable<String> split = splitter.split(s);
        System.out.println(split);
    }
}
