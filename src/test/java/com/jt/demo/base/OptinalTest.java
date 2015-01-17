package com.jt.demo.base;

import com.google.common.base.Optional;
import org.junit.Test;

import java.io.OptionalDataException;

/**
 * @author he
 * @since 2015/1/17
 */
public class OptinalTest {

    @Test
    public void test01() {
        Optional<Integer> anInt = getInt(13);
        System.out.println(anInt.get());
        System.out.println(anInt.or(0));
    }


    @Test
    public void test02() {
        Optional<Integer> anInt = getInt(null);
        System.out.println(anInt.or(0));
    }

    public Optional<Integer> getInt(Integer integer) {
        if (integer == null) {
            return Optional.absent();
        }
        return Optional.of(integer);
    }

}
