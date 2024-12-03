package org.apache.commons.collections.bag;

import java.util.Set;
import org.apache.commons.collections.Bag;
import org.apache.commons.collections.Predicate;
import org.apache.commons.collections.collection.PredicatedCollection;

public class PredicatedBag extends PredicatedCollection implements Bag {
    private static final long serialVersionUID = -2575833140344736876L;

    protected PredicatedBag(Bag bag, Predicate predicate) {
        super(bag, predicate);
    }

    public static Bag decorate(Bag bag, Predicate predicate) {
        return new PredicatedBag(bag, predicate);
    }

    public boolean add(Object obj, int i10) {
        validate(obj);
        return getBag().add(obj, i10);
    }

    /* access modifiers changed from: protected */
    public Bag getBag() {
        return (Bag) getCollection();
    }

    public int getCount(Object obj) {
        return getBag().getCount(obj);
    }

    public boolean remove(Object obj, int i10) {
        return getBag().remove(obj, i10);
    }

    public Set uniqueSet() {
        return getBag().uniqueSet();
    }
}
