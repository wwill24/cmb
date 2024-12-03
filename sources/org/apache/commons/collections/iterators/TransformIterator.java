package org.apache.commons.collections.iterators;

import java.util.Iterator;
import org.apache.commons.collections.Transformer;

public class TransformIterator implements Iterator {
    private Iterator iterator;
    private Transformer transformer;

    public TransformIterator() {
    }

    public Iterator getIterator() {
        return this.iterator;
    }

    public Transformer getTransformer() {
        return this.transformer;
    }

    public boolean hasNext() {
        return this.iterator.hasNext();
    }

    public Object next() {
        return transform(this.iterator.next());
    }

    public void remove() {
        this.iterator.remove();
    }

    public void setIterator(Iterator it) {
        this.iterator = it;
    }

    public void setTransformer(Transformer transformer2) {
        this.transformer = transformer2;
    }

    /* access modifiers changed from: protected */
    public Object transform(Object obj) {
        Transformer transformer2 = this.transformer;
        if (transformer2 != null) {
            return transformer2.transform(obj);
        }
        return obj;
    }

    public TransformIterator(Iterator it) {
        this.iterator = it;
    }

    public TransformIterator(Iterator it, Transformer transformer2) {
        this.iterator = it;
        this.transformer = transformer2;
    }
}
