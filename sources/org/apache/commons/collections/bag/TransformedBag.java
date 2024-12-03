package org.apache.commons.collections.bag;

import java.util.Set;
import org.apache.commons.collections.Bag;
import org.apache.commons.collections.Transformer;
import org.apache.commons.collections.collection.TransformedCollection;
import org.apache.commons.collections.set.TransformedSet;

public class TransformedBag extends TransformedCollection implements Bag {
    private static final long serialVersionUID = 5421170911299074185L;

    protected TransformedBag(Bag bag, Transformer transformer) {
        super(bag, transformer);
    }

    public static Bag decorate(Bag bag, Transformer transformer) {
        return new TransformedBag(bag, transformer);
    }

    public boolean add(Object obj, int i10) {
        return getBag().add(transform(obj), i10);
    }

    /* access modifiers changed from: protected */
    public Bag getBag() {
        return (Bag) this.collection;
    }

    public int getCount(Object obj) {
        return getBag().getCount(obj);
    }

    public boolean remove(Object obj, int i10) {
        return getBag().remove(obj, i10);
    }

    public Set uniqueSet() {
        return TransformedSet.decorate(getBag().uniqueSet(), this.transformer);
    }
}
