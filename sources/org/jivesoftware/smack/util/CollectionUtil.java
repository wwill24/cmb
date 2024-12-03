package org.jivesoftware.smack.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CollectionUtil {

    public interface Predicate<T> {
        boolean test(T t10);
    }

    public static <T> List<T> cloneAndSeal(Collection<? extends T> collection) {
        if (collection == null) {
            return Collections.emptyList();
        }
        return Collections.unmodifiableList(newListWith(collection));
    }

    public static <T> List<T> emptyOrSingletonListFrom(T t10) {
        if (t10 == null) {
            return Collections.emptyList();
        }
        return Collections.singletonList(t10);
    }

    public static <T> ArrayList<T> newListWith(Collection<? extends T> collection) {
        if (collection == null) {
            return null;
        }
        return new ArrayList<>(collection);
    }

    public static <T> Set<T> newSetWith(Collection<? extends T> collection) {
        if (collection == null) {
            return null;
        }
        return new HashSet(collection);
    }

    public static <T, C extends Collection<T>> List<T> removeUntil(C c10, Predicate<T> predicate) {
        ArrayList arrayList = new ArrayList(c10.size());
        Iterator it = c10.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            if (predicate.test(next)) {
                break;
            }
            arrayList.add(next);
            it.remove();
        }
        return arrayList;
    }

    public static <T> Collection<T> requireNotEmpty(Collection<T> collection, String str) {
        if (collection == null) {
            throw new NullPointerException(str + " must not be null.");
        } else if (!collection.isEmpty()) {
            return collection;
        } else {
            throw new IllegalArgumentException(str + " must not be empty.");
        }
    }

    public static <K, V> Map<K, V> cloneAndSeal(Map<K, V> map) {
        return Collections.unmodifiableMap(new HashMap(map));
    }
}
