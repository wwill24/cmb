package org.apache.commons.collections.iterators;

import org.apache.commons.collections.OrderedMapIterator;
import org.apache.commons.collections.ResettableIterator;

public class EmptyOrderedMapIterator extends AbstractEmptyIterator implements OrderedMapIterator, ResettableIterator {
    public static final OrderedMapIterator INSTANCE = new EmptyOrderedMapIterator();

    protected EmptyOrderedMapIterator() {
    }
}
