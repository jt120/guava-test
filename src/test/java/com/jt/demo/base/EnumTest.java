package com.jt.demo.base;

import com.google.common.base.Enums;
import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.List;

/**
 * @author he
 * @since 2015/1/17
 */
public class EnumTest {

    @Test
    public void test01() {
        Field field = Enums.getField(Day.ONE);
        System.out.println(field);
    }

    @Test
    public void test02() {
        Optional<Day> one = Enums.getIfPresent(Day.class, "TWO");
        System.out.println(one.or(Day.ONE));
    }

    @Test
    public void test03() {
        Function<String, Day> stringDayFunction = Enums.valueOfFunction(Day.class);
        List<String> list = Lists.newArrayList("ONE", "hello");
        List<Day> transform = Lists.transform(list, stringDayFunction);
        System.out.println(transform);
    }

    @Test
    public void test04() {
        Day[] values = Day.values();
        for (Day day : values) {
            System.out.println(day.name()+":"+day.ordinal()+":"+day);
        }
    }


}

enum Day {
    ONE(1, "one"),
    TWO(2,"two");
    int day;
    String desc;

    Day(int i, String one) {
        this.day = i;
        this.desc = one;
    }
}