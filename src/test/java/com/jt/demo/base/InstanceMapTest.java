package com.jt.demo.base;

import com.google.common.collect.MutableClassToInstanceMap;
import org.junit.Test;

/**
 * @author he
 * @since 2015/1/17
 */
public class InstanceMapTest {

    @Test
    public void test01() {
        MutableClassToInstanceMap mutableClassToInstanceMap = MutableClassToInstanceMap.create();
        mutableClassToInstanceMap.putInstance(Integer.class, 12);
        mutableClassToInstanceMap.putInstance(Integer.class, 14);
        mutableClassToInstanceMap.putInstance(String.class, "hello");
        System.out.println(mutableClassToInstanceMap.getInstance(Integer.class));
        System.out.println(mutableClassToInstanceMap.get(String.class));

    }
}
