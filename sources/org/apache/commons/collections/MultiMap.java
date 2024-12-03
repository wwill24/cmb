package org.apache.commons.collections;

import java.util.Collection;
import java.util.Map;

public interface MultiMap extends Map {
    boolean containsValue(Object obj);

    Object get(Object obj);

    Object put(Object obj, Object obj2);

    Object remove(Object obj);

    Object remove(Object obj, Object obj2);

    int size();

    Collection values();
}
