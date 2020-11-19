package org.effective.guava;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @author 6c6763
 * @date 2020/11/18
 */
public class PreconditionValidAction {
    private static final Logger logger = LoggerFactory.getLogger(PreconditionValidAction.class);
    private static final List<String> list = Lists.newArrayList("a", "b", "c", "d", "e");

    public static void main(String[] args) {
        preconditionValidArgs();
    }

    static void preconditionValidArgs() {
        String param = "param";
        String arg = null;
        try {
            Preconditions.checkNotNull(param);
//            Preconditions.checkNotNull(arg);
//            Preconditions.checkNotNull(arg, "NPE");
            Preconditions.checkElementIndex(5, list.size());
            Preconditions.checkElementIndex(5, list.size(), "index out of size");
            Preconditions.checkArgument(param.equals(arg), "param not equal arg");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
