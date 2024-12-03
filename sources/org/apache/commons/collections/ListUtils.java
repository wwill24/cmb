package org.apache.commons.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.collections.list.FixedSizeList;
import org.apache.commons.collections.list.LazyList;
import org.apache.commons.collections.list.PredicatedList;
import org.apache.commons.collections.list.SynchronizedList;
import org.apache.commons.collections.list.TransformedList;
import org.apache.commons.collections.list.TypedList;
import org.apache.commons.collections.list.UnmodifiableList;

public class ListUtils {
    public static final List EMPTY_LIST = Collections.EMPTY_LIST;

    public static List fixedSizeList(List list) {
        return FixedSizeList.decorate(list);
    }

    public static int hashCodeForList(Collection collection) {
        int i10;
        if (collection == null) {
            return 0;
        }
        int i11 = 1;
        for (Object next : collection) {
            int i12 = i11 * 31;
            if (next == null) {
                i10 = 0;
            } else {
                i10 = next.hashCode();
            }
            i11 = i12 + i10;
        }
        return i11;
    }

    public static List intersection(List list, List list2) {
        ArrayList arrayList = new ArrayList();
        for (Object next : list2) {
            if (list.contains(next)) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public static boolean isEqualList(Collection collection, Collection collection2) {
        if (collection == collection2) {
            return true;
        }
        if (collection == null || collection2 == null || collection.size() != collection2.size()) {
            return false;
        }
        Iterator it = collection.iterator();
        Iterator it2 = collection2.iterator();
        while (it.hasNext() && it2.hasNext()) {
            Object next = it.next();
            Object next2 = it2.next();
            if (next == null) {
                if (next2 == null) {
                }
            } else if (!next.equals(next2)) {
            }
            return false;
        }
        if (it.hasNext() || it2.hasNext()) {
            return false;
        }
        return true;
    }

    public static List lazyList(List list, Factory factory) {
        return LazyList.decorate(list, factory);
    }

    public static List predicatedList(List list, Predicate predicate) {
        return PredicatedList.decorate(list, predicate);
    }

    public static List removeAll(Collection collection, Collection collection2) {
        ArrayList arrayList = new ArrayList();
        for (Object next : collection) {
            if (!collection2.contains(next)) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public static List retainAll(Collection collection, Collection collection2) {
        ArrayList arrayList = new ArrayList(Math.min(collection.size(), collection2.size()));
        for (Object next : collection) {
            if (collection2.contains(next)) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public static List subtract(List list, List list2) {
        ArrayList arrayList = new ArrayList(list);
        for (Object remove : list2) {
            arrayList.remove(remove);
        }
        return arrayList;
    }

    public static List sum(List list, List list2) {
        return subtract(union(list, list2), intersection(list, list2));
    }

    public static List synchronizedList(List list) {
        return SynchronizedList.decorate(list);
    }

    public static List transformedList(List list, Transformer transformer) {
        return TransformedList.decorate(list, transformer);
    }

    public static List typedList(List list, Class cls) {
        return TypedList.decorate(list, cls);
    }

    public static List union(List list, List list2) {
        ArrayList arrayList = new ArrayList(list);
        arrayList.addAll(list2);
        return arrayList;
    }

    public static List unmodifiableList(List list) {
        return UnmodifiableList.decorate(list);
    }
}
