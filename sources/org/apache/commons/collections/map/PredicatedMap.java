package org.apache.commons.collections.map;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
import org.apache.commons.collections.Predicate;

public class PredicatedMap extends AbstractInputCheckedMapDecorator implements Serializable {
    private static final long serialVersionUID = 7412622456128415156L;
    protected final Predicate keyPredicate;
    protected final Predicate valuePredicate;

    protected PredicatedMap(Map map, Predicate predicate, Predicate predicate2) {
        super(map);
        this.keyPredicate = predicate;
        this.valuePredicate = predicate2;
        for (Map.Entry entry : map.entrySet()) {
            validate(entry.getKey(), entry.getValue());
        }
    }

    public static Map decorate(Map map, Predicate predicate, Predicate predicate2) {
        return new PredicatedMap(map, predicate, predicate2);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.map = (Map) objectInputStream.readObject();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.map);
    }

    /* access modifiers changed from: protected */
    public Object checkSetValue(Object obj) {
        if (this.valuePredicate.evaluate(obj)) {
            return obj;
        }
        throw new IllegalArgumentException("Cannot set value - Predicate rejected it");
    }

    /* access modifiers changed from: protected */
    public boolean isSetValueChecking() {
        return this.valuePredicate != null;
    }

    public Object put(Object obj, Object obj2) {
        validate(obj, obj2);
        return this.map.put(obj, obj2);
    }

    public void putAll(Map map) {
        for (Map.Entry entry : map.entrySet()) {
            validate(entry.getKey(), entry.getValue());
        }
        this.map.putAll(map);
    }

    /* access modifiers changed from: protected */
    public void validate(Object obj, Object obj2) {
        Predicate predicate = this.keyPredicate;
        if (predicate == null || predicate.evaluate(obj)) {
            Predicate predicate2 = this.valuePredicate;
            if (predicate2 != null && !predicate2.evaluate(obj2)) {
                throw new IllegalArgumentException("Cannot add value - Predicate rejected it");
            }
            return;
        }
        throw new IllegalArgumentException("Cannot add key - Predicate rejected it");
    }
}
