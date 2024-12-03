package org.apache.commons.collections.bag;

import java.util.Set;
import org.apache.commons.collections.Bag;
import org.apache.commons.collections.collection.SynchronizedCollection;
import org.apache.commons.collections.set.SynchronizedSet;

public class SynchronizedBag extends SynchronizedCollection implements Bag {
    private static final long serialVersionUID = 8084674570753837109L;

    class SynchronizedBagSet extends SynchronizedSet {
        private final /* synthetic */ SynchronizedBag this$0;

        SynchronizedBagSet(SynchronizedBag synchronizedBag, Set set, Object obj) {
            super(set, obj);
            this.this$0 = synchronizedBag;
        }
    }

    protected SynchronizedBag(Bag bag) {
        super(bag);
    }

    public static Bag decorate(Bag bag) {
        return new SynchronizedBag(bag);
    }

    public boolean add(Object obj, int i10) {
        boolean add;
        synchronized (this.lock) {
            add = getBag().add(obj, i10);
        }
        return add;
    }

    /* access modifiers changed from: protected */
    public Bag getBag() {
        return (Bag) this.collection;
    }

    public int getCount(Object obj) {
        int count;
        synchronized (this.lock) {
            count = getBag().getCount(obj);
        }
        return count;
    }

    public boolean remove(Object obj, int i10) {
        boolean remove;
        synchronized (this.lock) {
            remove = getBag().remove(obj, i10);
        }
        return remove;
    }

    public Set uniqueSet() {
        SynchronizedBagSet synchronizedBagSet;
        synchronized (this.lock) {
            synchronizedBagSet = new SynchronizedBagSet(this, getBag().uniqueSet(), this.lock);
        }
        return synchronizedBagSet;
    }

    protected SynchronizedBag(Bag bag, Object obj) {
        super(bag, obj);
    }
}
