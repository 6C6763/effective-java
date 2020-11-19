package org.effective.guava;

import com.google.common.base.Splitter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class SplitterTest {
    private static final Logger logger = LoggerFactory.getLogger(Splitter.class);
    private static final Pattern compile = Pattern.compile("\\|");

    public static void main(String[] args) {
        testSplitter();
    }

    private static void testSplitter() {
        List<String> strings = Splitter.on("|").splitToList("hello|guava|splitter");
        logger.info("splitter on:{}", strings);

        List<String> stringOmit = Splitter.on("|").omitEmptyStrings().splitToList("hello|guava|splitter|||");
        logger.info("splitter omitEmptyStrings:{}", stringOmit);

        List<String> stringOmitTrim = Splitter.on("|").trimResults().omitEmptyStrings().splitToList("hello | guava|splitter|||");
        logger.info("splitter trim&omitEmptyStrings:{}", stringOmitTrim);

        List<String> stringFix = Splitter.fixedLength(5).splitToList("abcdefghijklmn");
        logger.info("splitter fixedLength:{}", stringFix);

        List<String> result = Splitter.on("#").limit(3).splitToList("hello#google#guava#scala#java");
        logger.info("splitter limit:{}", result);

        List<String> patternList = Splitter.onPattern("\\|").trimResults().omitEmptyStrings().splitToList("hello|google|");
        logger.info("splitter pattern split:{}", patternList);

        List<String> patternRex = Splitter.on(compile).trimResults().omitEmptyStrings().splitToList("hello|google|");
        logger.info("splitter Rex split:{}", patternRex);

        Map<String, String> listMap = Splitter.on(compile).trimResults().omitEmptyStrings().withKeyValueSeparator("=").split("hello=google|google=guava");
        logger.info("splitter rex-split2map:{}", listMap);
    }
}