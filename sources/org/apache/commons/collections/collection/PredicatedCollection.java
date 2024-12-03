package org.apache.commons.collections.collection;

import java.util.Collection;
import org.apache.commons.collections.Predicate;

public class PredicatedCollection extends AbstractSerializableCollectionDecorator {
    private static final long serialVersionUID = -5259182142076705162L;
    protected final Predicate predicate;

    protected PredicatedCollection(Collection collection, Predicate predicate2) {
        super(collection);
        if (predicate2 != null) {
            this.predicate = predicate2;
            for (Object validate : collection) {
                validate(validate);
            }
            return;
        }
        throw new IllegalArgumentException("Predicate must not be null");
    }

    public static Collection decorate(Collection collection, Predicate predicate2) {
        return new PredicatedCollection(collection, predicate2);
    }

    public boolean add(Object obj) {
        validate(obj);
        return getCollection().add(obj);
    }

    public boolean addAll(Collection collection) {
        for (Object validate : collection) {
            validate(validate);
        }
        return getCollection().addAll(collection);
    }

    /* access modifiers changed from: protected */
    public void validate(Object obj) {
        if (!this.predicate.evaluate(obj)) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Cannot add Object '");
            stringBuffer.append(obj);
            stringBuffer.append("' - Predicate rejected it");
            throw new IllegalArgumentException(stringBuffer.toString());
        }
    }
}
