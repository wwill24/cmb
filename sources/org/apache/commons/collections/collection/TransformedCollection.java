package org.apache.commons.collections.collection;

import java.util.ArrayList;
import java.util.Collection;
import org.apache.commons.collections.Transformer;

public class TransformedCollection extends AbstractSerializableCollectionDecorator {
    private static final long serialVersionUID = 8692300188161871514L;
    protected final Transformer transformer;

    protected TransformedCollection(Collection collection, Transformer transformer2) {
        super(collection);
        if (transformer2 != null) {
            this.transformer = transformer2;
            return;
        }
        throw new IllegalArgumentException("Transformer must not be null");
    }

    public static Collection decorate(Collection collection, Transformer transformer2) {
        return new TransformedCollection(collection, transformer2);
    }

    public boolean add(Object obj) {
        return getCollection().add(transform(obj));
    }

    public boolean addAll(Collection collection) {
        return getCollection().addAll(transform(collection));
    }

    /* access modifiers changed from: protected */
    public Object transform(Object obj) {
        return this.transformer.transform(obj);
    }

    /* access modifiers changed from: protected */
    public Collection transform(Collection collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        for (Object transform : collection) {
            arrayList.add(transform(transform));
        }
        return arrayList;
    }
}
