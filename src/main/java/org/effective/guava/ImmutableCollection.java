package org.effective.guava;

import com.google.common.collect.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Map;

/**
 * @author 6c6763
 * @date 2020/11/18
 */
public class ImmutableCollection {
    private static final Logger logger =LoggerFactory.getLogger(ImmutableCollection.class);
    public static void main(String[] args) {
        immutableSet();
        immutableList();
        immutableMap();
    }

    /**
     * UnsupportedOperationException
     */
    private static void immutableSet() {
        logger.info("start create immutableSet");
        //
        ImmutableSet<String> stringImmutableSet = ImmutableSet.of("a", "b", "c", "d");
        stringImmutableSet.forEach(System.out::println);
        //
        ImmutableSet<String> immutableSet = ImmutableSet.<String>builder()
                .add("hello")
                .add("immutable")
                .build();
        immutableSet.forEach(System.out::println);
        //
        ArrayList<String> stringArrayList = Lists.newArrayList("a", "b", "c");
        ImmutableSet<String> ims = ImmutableSet.copyOf(stringArrayList);
        ims.forEach(System.out::println);


    }
    private static void immutableList(){
        logger.info("start create immutableList");
        ArrayList<String> stringArrayList = Lists.newArrayList("a", "b", "c");
        ImmutableList<String> ims = ImmutableList.<String>builder().add("d").addAll(stringArrayList).build();
        ims.forEach(System.out::println);
    }
    private static void immutableMap(){
        logger.info("start create immutableMap");
        Map<String, Object> map = Maps.newHashMap();
        map.put("name","nns6763");
        map.put("age",23);
        ImmutableMap<String, Object> immutableMap = ImmutableMap.<String, Object>builder().putAll(map).build();
    }
}
