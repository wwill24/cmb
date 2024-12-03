package org.apache.commons.collections.set;

import java.util.Comparator;
import java.util.SortedSet;
import org.apache.commons.collections.Transformer;

public class TransformedSortedSet extends TransformedSet implements SortedSet {
    private static final long serialVersionUID = -1675486811351124386L;

    protected TransformedSortedSet(SortedSet sortedSet, Transformer transformer) {
        super(sortedSet, transformer);
    }

    public static SortedSet decorate(SortedSet sortedSet, Transformer transformer) {
        return new TransformedSortedSet(sortedSet, transformer);
    }

    public Comparator comparator() {
        return getSortedSet().comparator();
    }

    public Object first() {
        return getSortedSet().first();
    }

    /* access modifiers changed from: protected */
    public SortedSet getSortedSet() {
        return (SortedSet) this.collection;
    }

    public SortedSet headSet(Object obj) {
        return new TransformedSortedSet(getSortedSet().headSet(obj), this.transformer);
    }

    public Object last() {
        return getSortedSet().last();
    }

    public SortedSet subSet(Object obj, Object obj2) {
        return new TransformedSortedSet(getSortedSet().subSet(obj, obj2), this.transformer);
    }

    public SortedSet tailSet(Object obj) {
        return new TransformedSortedSet(getSortedSet().tailSet(obj), this.transformer);
    }
}
