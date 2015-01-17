package com.jt.demo.base;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import org.junit.Test;

import java.util.Date;
import java.util.Random;

/**
 * @author he
 * @since 2015/1/17
 */
public class SupplyTest {

    @Test
    public void test01() {
        Supplier<Date> memoize = Suppliers.memoize(new MyDate());
        Date date = memoize.get();
        for (int i = 0; i < 100; i++) {
            System.out.println(date);
        }
    }

    @Test
    public void test02() {
        MyRandom myRandom = new MyRandom(10, 9);
        System.out.println(myRandom.get());

    }

    @Test
    public void test03() {
        Supplier<String> compose = Suppliers.compose(new MyCal(), new MyRandom(20, 30));
        for (int i = 0; i < 10; i++) {
            System.out.println(compose.get());
        }
    }

    class MyDate implements Supplier<Date> {

        @Override
        public Date get() {
            System.out.println("init");
            return new Date();
        }
    }


    class MyRandom implements Supplier<Integer> {

        Random random = new Random();

        final int start;
        final int end;

        public MyRandom(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public Integer get() {
            Preconditions.checkArgument(end >= start,"end must be larger than start");
            return start + random.nextInt(end - start);
        }
    }

    class MyCal implements Function<Integer, String> {

        @Override
        public String apply(Integer input) {
            return "hello " + input;
        }
    }

}
