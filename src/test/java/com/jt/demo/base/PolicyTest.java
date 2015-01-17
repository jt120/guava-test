package com.jt.demo.base;

import com.google.common.base.Enums;
import com.google.common.base.Function;
import com.google.common.base.Supplier;
import com.google.common.collect.ImmutableClassToInstanceMap;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;

/**
 * @author he
 * @since 2015/1/17
 */
public class PolicyTest {

    @Test
    public void test01() {
        ImmutableClassToInstanceMap.Builder<Policy> builder = ImmutableClassToInstanceMap.builder();

        ImmutableClassToInstanceMap<Policy> build = builder.put(OneWayPolicy.class, new OneWayPolicy())
                .put(ReturnPolicy.class, new ReturnPolicy()).build();
        List<String> list = Lists.newArrayList("ONE_WAY", "RETURN");
        List<Class<? extends Policy>> transform = Lists.transform(list, new MyFun());
        for (Class p : transform) {
            Policy instance = build.getInstance(p);
            instance.add();
        }
    }

    @Test
    public void test02() {
        ImmutableClassToInstanceMap.Builder<Policy> builder = ImmutableClassToInstanceMap.builder();
        ImmutableClassToInstanceMap<Policy> build = builder.build();

    }

}

class MyFun implements Function<String, Class<? extends Policy>> {
    @Override
    public Class<? extends Policy> apply(String input) {
        if (input.equals(PolicyType.ONE_WAY.name())) {
            return OneWayPolicy.class;
        } else if (input.equals(PolicyType.RETURN.name())) {
            return ReturnPolicy.class;
        }
        return null;
    }
}

enum PolicyType {
    ONE_WAY(1, "单程"),
    RETURN(2, "往返");

    int code;
    String desc;

    PolicyType(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}

class MySup implements Supplier<Policy> {
    @Override
    public Policy get() {
        return null;
    }
}

interface Policy{
    void add();
}

class OneWayPolicy implements Policy {

    @Override
    public void add() {
        System.out.println("one way");
    }
}

class ReturnPolicy implements Policy {
    @Override
    public void add() {
        System.out.println("return");
    }
}
