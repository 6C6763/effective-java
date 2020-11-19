package org.effective.guava;

import com.google.common.collect.ForwardingList;

import java.util.List;

/**
 * @author 6c6763
 * @date 2020/11/18
 */
public class FordingList<E> extends ForwardingList<E> {

    @Override
    protected List<E> delegate() {
        return null;
    }
}
