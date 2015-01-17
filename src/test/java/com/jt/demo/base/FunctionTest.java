package com.jt.demo.base;

import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.junit.Test;

import java.util.List;
import java.util.Map;

/**
 * @author he
 * @since 2015/1/17
 */
public class FunctionTest {

    @Test
    public void test01() {
        List<Integer> list = Lists.asList(13, new Integer[]{15, 19, 22});
        List<Boolean> transform = Lists.transform(list, new MyFun());
        System.out.println(transform);
    }

    @Test
    public void test02() {
        Map<Integer,String> map = Maps.newHashMap();
        map.put(1, "one");
        map.put(2, "two");
        Function<Integer, String> integerStringFunction = Functions.forMap(map);

    }

    @Test
    public void test03() {
        Map<String, Policy> map = Maps.newHashMap();
        map.put("ONE_WAY", new OneWayPolicy());
        map.put("RETURN", new ReturnPolicy());
        Function<String, Policy> integerStringFunction = Functions.forMap(map);

        MyStr<String,Policy> myStr = new MyStr(integerStringFunction);
        Policy one_way = myStr.transform("ONE_WAY");
        one_way.add();
    }

    abstract class StringTrans<F,T> {
        abstract T transform(F from);
    }

    class MyStr<F,T> extends StringTrans<F, T> {
        Function<F, T> ftFunction;
        MyStr(Function function) {
            this.ftFunction = function;
        }

        @Override
        T transform(F from) {
            return ftFunction.apply(from);
        }
    }

    class MyFun implements Function<Integer, Boolean> {

        @Override
        public Boolean apply(Integer input) {
            if (input > 18) {
                return true;
            }
            return false;
        }
    }
}
