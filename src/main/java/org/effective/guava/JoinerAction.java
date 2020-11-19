package org.effective.guava;

import com.google.common.base.Joiner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.google.common.collect.ImmutableMap.of;

/**
 * @author 6c6763
 * @date 2020/11/18
 */
public class JoinerAction {
    private static final Logger logger = LoggerFactory.getLogger(JoinerAction.class);

    private static final List<String> stringList = Arrays.asList("google", "guava", "action");
    private static final List<String> stringListWithNull = Arrays.asList("google", "guava", "action", null);
    private static final Map<String, String> stringMap = of("java", "guava", "go", "init");


    public static void main(String[] args) {
        testJoiner();
    }

    private static void testJoiner() {
        logger.info("joiner join:{}", Joiner.on("#").join(stringList));
        logger.info("joiner skipNulls:{}", Joiner.on("$").skipNulls().join(stringListWithNull));
        logger.info("joiner useForNull:{}", Joiner.on("%").useForNull("xxx").join(stringListWithNull));
        StringBuilder stringBuilder = Joiner.on("%").useForNull("DEFAULT").appendTo(new StringBuilder(), stringListWithNull);
        logger.info("stringBuilder:{}", new String(stringBuilder));
        try (FileWriter fileWriter = new FileWriter(new File(("/Users/6c6763/Desktop/guava.txt")))) {
            Joiner.on("^").useForNull("DEFAULT").appendTo(fileWriter, stringListWithNull);
        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.info("----user java 8 ----");
        String stream = stringListWithNull.stream().filter(item -> item != null || item != "").collect(Collectors.joining("$"));
        String stream1 = stringListWithNull.stream().map(JoinerAction::defaultDealByStream).collect(Collectors.joining("$"));
        logger.info(stream);
        logger.info(stream1);
        logger.info("---- joiner map ----");
        logger.info("joiner map-withKeyValueSeparator:{}", Joiner.on("$").withKeyValueSeparator("=").join(stringMap));
        try (FileWriter fileWriter = new FileWriter(new File(("/Users/6c6763/Desktop/guavaMap.txt")))) {
            Joiner.on("^").withKeyValueSeparator("=").appendTo(fileWriter, stringMap);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("FileWriter err:{}", e.getMessage());
        }
    }

    private static String defaultDealByStream(String param) {
        return param == null || param == "" ? "DEFAULT" : param;
    }
}
