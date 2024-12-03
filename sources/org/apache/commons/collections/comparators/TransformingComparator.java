package org.apache.commons.collections.comparators;

import java.util.Comparator;
import org.apache.commons.collections.Transformer;

public class TransformingComparator implements Comparator {
    protected Comparator decorated;
    protected Transformer transformer;

    public TransformingComparator(Transformer transformer2) {
        this(transformer2, new ComparableComparator());
    }

    public int compare(Object obj, Object obj2) {
        return this.decorated.compare(this.transformer.transform(obj), this.transformer.transform(obj2));
    }

    public TransformingComparator(Transformer transformer2, Comparator comparator) {
        this.decorated = comparator;
        this.transformer = transformer2;
    }
}
