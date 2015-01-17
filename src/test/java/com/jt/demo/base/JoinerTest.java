package com.jt.demo.base;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;

/**
 * @author he
 * @since 2015/1/17
 */
public class JoinerTest {

    @Test
    public void test01() {
        Joiner joiner = Joiner.on(",").skipNulls();
        List<String> list = Lists.asList("hello", "ok", new String[]{"ggg"});
        String join = joiner.join(list);
        System.out.println(join);
    }
}
