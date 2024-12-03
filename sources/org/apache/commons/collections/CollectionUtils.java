package org.apache.commons.collections;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import org.apache.commons.collections.collection.PredicatedCollection;
import org.apache.commons.collections.collection.SynchronizedCollection;
import org.apache.commons.collections.collection.TransformedCollection;
import org.apache.commons.collections.collection.TypedCollection;
import org.apache.commons.collections.collection.UnmodifiableBoundedCollection;
import org.apache.commons.collections.collection.UnmodifiableCollection;

public class CollectionUtils {
    public static final Collection EMPTY_COLLECTION = UnmodifiableCollection.decorate(new ArrayList());
    private static Integer INTEGER_ONE = new Integer(1);

    public static void addAll(Collection collection, Iterator it) {
        while (it.hasNext()) {
            collection.add(it.next());
        }
    }

    public static boolean addIgnoreNull(Collection collection, Object obj) {
        if (obj == null) {
            return false;
        }
        return collection.add(obj);
    }

    public static int cardinality(Object obj, Collection collection) {
        if (collection instanceof Set) {
            return collection.contains(obj) ? 1 : 0;
        }
        if (collection instanceof Bag) {
            return ((Bag) collection).getCount(obj);
        }
        int i10 = 0;
        if (obj == null) {
            for (Object obj2 : collection) {
                if (obj2 == null) {
                    i10++;
                }
            }
        } else {
            for (Object equals : collection) {
                if (obj.equals(equals)) {
                    i10++;
                }
            }
        }
        return i10;
    }

    public static Collection collect(Collection collection, Transformer transformer) {
        ArrayList arrayList = new ArrayList(collection.size());
        collect(collection, transformer, (Collection) arrayList);
        return arrayList;
    }

    public static boolean containsAny(Collection collection, Collection collection2) {
        if (collection.size() < collection2.size()) {
            for (Object contains : collection) {
                if (collection2.contains(contains)) {
                    return true;
                }
            }
            return false;
        }
        for (Object contains2 : collection2) {
            if (collection.contains(contains2)) {
                return true;
            }
        }
        return false;
    }

    public static int countMatches(Collection collection, Predicate predicate) {
        int i10 = 0;
        if (!(collection == null || predicate == null)) {
            for (Object evaluate : collection) {
                if (predicate.evaluate(evaluate)) {
                    i10++;
                }
            }
        }
        return i10;
    }

    public static Collection disjunction(Collection collection, Collection collection2) {
        ArrayList arrayList = new ArrayList();
        Map cardinalityMap = getCardinalityMap(collection);
        Map cardinalityMap2 = getCardinalityMap(collection2);
        HashSet hashSet = new HashSet(collection);
        hashSet.addAll(collection2);
        for (Object next : hashSet) {
            int max = Math.max(getFreq(next, cardinalityMap), getFreq(next, cardinalityMap2)) - Math.min(getFreq(next, cardinalityMap), getFreq(next, cardinalityMap2));
            for (int i10 = 0; i10 < max; i10++) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public static boolean exists(Collection collection, Predicate predicate) {
        if (collection == null || predicate == null) {
            return false;
        }
        for (Object evaluate : collection) {
            if (predicate.evaluate(evaluate)) {
                return true;
            }
        }
        return false;
    }

    public static void filter(Collection collection, Predicate predicate) {
        if (collection != null && predicate != null) {
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                if (!predicate.evaluate(it.next())) {
                    it.remove();
                }
            }
        }
    }

    public static Object find(Collection collection, Predicate predicate) {
        if (collection == null || predicate == null) {
            return null;
        }
        for (Object next : collection) {
            if (predicate.evaluate(next)) {
                return next;
            }
        }
        return null;
    }

    public static void forAllDo(Collection collection, Closure closure) {
        if (collection != null && closure != null) {
            for (Object execute : collection) {
                closure.execute(execute);
            }
        }
    }

    public static Object get(Object obj, int i10) {
        if (i10 < 0) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Index cannot be negative: ");
            stringBuffer.append(i10);
            throw new IndexOutOfBoundsException(stringBuffer.toString());
        } else if (obj instanceof Map) {
            return get(((Map) obj).entrySet().iterator(), i10);
        } else {
            if (obj instanceof List) {
                return ((List) obj).get(i10);
            }
            if (obj instanceof Object[]) {
                return ((Object[]) obj)[i10];
            }
            if (obj instanceof Iterator) {
                Iterator it = (Iterator) obj;
                while (it.hasNext()) {
                    i10--;
                    if (i10 == -1) {
                        return it.next();
                    }
                    it.next();
                }
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append("Entry does not exist: ");
                stringBuffer2.append(i10);
                throw new IndexOutOfBoundsException(stringBuffer2.toString());
            } else if (obj instanceof Collection) {
                return get(((Collection) obj).iterator(), i10);
            } else {
                if (obj instanceof Enumeration) {
                    Enumeration enumeration = (Enumeration) obj;
                    while (enumeration.hasMoreElements()) {
                        i10--;
                        if (i10 == -1) {
                            return enumeration.nextElement();
                        }
                        enumeration.nextElement();
                    }
                    StringBuffer stringBuffer3 = new StringBuffer();
                    stringBuffer3.append("Entry does not exist: ");
                    stringBuffer3.append(i10);
                    throw new IndexOutOfBoundsException(stringBuffer3.toString());
                } else if (obj != null) {
                    try {
                        return Array.get(obj, i10);
                    } catch (IllegalArgumentException unused) {
                        StringBuffer stringBuffer4 = new StringBuffer();
                        stringBuffer4.append("Unsupported object type: ");
                        stringBuffer4.append(obj.getClass().getName());
                        throw new IllegalArgumentException(stringBuffer4.toString());
                    }
                } else {
                    throw new IllegalArgumentException("Unsupported object type: null");
                }
            }
        }
    }

    public static Map getCardinalityMap(Collection collection) {
        HashMap hashMap = new HashMap();
        for (Object next : collection) {
            Integer num = (Integer) hashMap.get(next);
            if (num == null) {
                hashMap.put(next, INTEGER_ONE);
            } else {
                hashMap.put(next, new Integer(num.intValue() + 1));
            }
        }
        return hashMap;
    }

    private static final int getFreq(Object obj, Map map) {
        Integer num = (Integer) map.get(obj);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public static Object index(Object obj, int i10) {
        return index(obj, (Object) new Integer(i10));
    }

    public static Collection intersection(Collection collection, Collection collection2) {
        ArrayList arrayList = new ArrayList();
        Map cardinalityMap = getCardinalityMap(collection);
        Map cardinalityMap2 = getCardinalityMap(collection2);
        HashSet hashSet = new HashSet(collection);
        hashSet.addAll(collection2);
        for (Object next : hashSet) {
            int min = Math.min(getFreq(next, cardinalityMap), getFreq(next, cardinalityMap2));
            for (int i10 = 0; i10 < min; i10++) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public static boolean isEmpty(Collection collection) {
        return collection == null || collection.isEmpty();
    }

    public static boolean isEqualCollection(Collection collection, Collection collection2) {
        if (collection.size() != collection2.size()) {
            return false;
        }
        Map cardinalityMap = getCardinalityMap(collection);
        Map cardinalityMap2 = getCardinalityMap(collection2);
        if (cardinalityMap.size() != cardinalityMap2.size()) {
            return false;
        }
        for (Object next : cardinalityMap.keySet()) {
            if (getFreq(next, cardinalityMap) != getFreq(next, cardinalityMap2)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isFull(Collection collection) {
        if (collection == null) {
            throw new NullPointerException("The collection must not be null");
        } else if (collection instanceof BoundedCollection) {
            return ((BoundedCollection) collection).isFull();
        } else {
            try {
                return UnmodifiableBoundedCollection.decorateUsing(collection).isFull();
            } catch (IllegalArgumentException unused) {
                return false;
            }
        }
    }

    public static boolean isNotEmpty(Collection collection) {
        return !isEmpty(collection);
    }

    public static boolean isProperSubCollection(Collection collection, Collection collection2) {
        return collection.size() < collection2.size() && isSubCollection(collection, collection2);
    }

    public static boolean isSubCollection(Collection collection, Collection collection2) {
        Map cardinalityMap = getCardinalityMap(collection);
        Map cardinalityMap2 = getCardinalityMap(collection2);
        for (Object next : collection) {
            if (getFreq(next, cardinalityMap) > getFreq(next, cardinalityMap2)) {
                return false;
            }
        }
        return true;
    }

    public static int maxSize(Collection collection) {
        if (collection == null) {
            throw new NullPointerException("The collection must not be null");
        } else if (collection instanceof BoundedCollection) {
            return ((BoundedCollection) collection).maxSize();
        } else {
            try {
                return UnmodifiableBoundedCollection.decorateUsing(collection).maxSize();
            } catch (IllegalArgumentException unused) {
                return -1;
            }
        }
    }

    public static Collection predicatedCollection(Collection collection, Predicate predicate) {
        return PredicatedCollection.decorate(collection, predicate);
    }

    public static Collection removeAll(Collection collection, Collection collection2) {
        return ListUtils.removeAll(collection, collection2);
    }

    public static Collection retainAll(Collection collection, Collection collection2) {
        return ListUtils.retainAll(collection, collection2);
    }

    public static void reverseArray(Object[] objArr) {
        int length = objArr.length - 1;
        for (int i10 = 0; length > i10; i10++) {
            Object obj = objArr[length];
            objArr[length] = objArr[i10];
            objArr[i10] = obj;
            length--;
        }
    }

    public static Collection select(Collection collection, Predicate predicate) {
        ArrayList arrayList = new ArrayList(collection.size());
        select(collection, predicate, arrayList);
        return arrayList;
    }

    public static Collection selectRejected(Collection collection, Predicate predicate) {
        ArrayList arrayList = new ArrayList(collection.size());
        selectRejected(collection, predicate, arrayList);
        return arrayList;
    }

    public static int size(Object obj) {
        if (obj instanceof Map) {
            return ((Map) obj).size();
        }
        if (obj instanceof Collection) {
            return ((Collection) obj).size();
        }
        if (obj instanceof Object[]) {
            return ((Object[]) obj).length;
        }
        int i10 = 0;
        if (obj instanceof Iterator) {
            Iterator it = (Iterator) obj;
            while (it.hasNext()) {
                i10++;
                it.next();
            }
        } else if (obj instanceof Enumeration) {
            Enumeration enumeration = (Enumeration) obj;
            while (enumeration.hasMoreElements()) {
                i10++;
                enumeration.nextElement();
            }
        } else if (obj != null) {
            try {
                return Array.getLength(obj);
            } catch (IllegalArgumentException unused) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("Unsupported object type: ");
                stringBuffer.append(obj.getClass().getName());
                throw new IllegalArgumentException(stringBuffer.toString());
            }
        } else {
            throw new IllegalArgumentException("Unsupported object type: null");
        }
        return i10;
    }

    public static boolean sizeIsEmpty(Object obj) {
        if (obj instanceof Collection) {
            return ((Collection) obj).isEmpty();
        }
        if (obj instanceof Map) {
            return ((Map) obj).isEmpty();
        }
        if (obj instanceof Object[]) {
            if (((Object[]) obj).length == 0) {
                return true;
            }
            return false;
        } else if (obj instanceof Iterator) {
            return !((Iterator) obj).hasNext();
        } else {
            if (obj instanceof Enumeration) {
                return !((Enumeration) obj).hasMoreElements();
            }
            if (obj != null) {
                try {
                    if (Array.getLength(obj) == 0) {
                        return true;
                    }
                    return false;
                } catch (IllegalArgumentException unused) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("Unsupported object type: ");
                    stringBuffer.append(obj.getClass().getName());
                    throw new IllegalArgumentException(stringBuffer.toString());
                }
            } else {
                throw new IllegalArgumentException("Unsupported object type: null");
            }
        }
    }

    public static Collection subtract(Collection collection, Collection collection2) {
        ArrayList arrayList = new ArrayList(collection);
        for (Object remove : collection2) {
            arrayList.remove(remove);
        }
        return arrayList;
    }

    public static Collection synchronizedCollection(Collection collection) {
        return SynchronizedCollection.decorate(collection);
    }

    public static void transform(Collection collection, Transformer transformer) {
        if (collection != null && transformer != null) {
            if (collection instanceof List) {
                ListIterator listIterator = ((List) collection).listIterator();
                while (listIterator.hasNext()) {
                    listIterator.set(transformer.transform(listIterator.next()));
                }
                return;
            }
            Collection collect = collect(collection, transformer);
            collection.clear();
            collection.addAll(collect);
        }
    }

    public static Collection transformedCollection(Collection collection, Transformer transformer) {
        return TransformedCollection.decorate(collection, transformer);
    }

    public static Collection typedCollection(Collection collection, Class cls) {
        return TypedCollection.decorate(collection, cls);
    }

    public static Collection union(Collection collection, Collection collection2) {
        ArrayList arrayList = new ArrayList();
        Map cardinalityMap = getCardinalityMap(collection);
        Map cardinalityMap2 = getCardinalityMap(collection2);
        HashSet hashSet = new HashSet(collection);
        hashSet.addAll(collection2);
        for (Object next : hashSet) {
            int max = Math.max(getFreq(next, cardinalityMap), getFreq(next, cardinalityMap2));
            for (int i10 = 0; i10 < max; i10++) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public static Collection unmodifiableCollection(Collection collection) {
        return UnmodifiableCollection.decorate(collection);
    }

    public static Object index(Object obj, Object obj2) {
        boolean z10 = obj instanceof Map;
        if (z10) {
            Map map = (Map) obj;
            if (map.containsKey(obj2)) {
                return map.get(obj2);
            }
        }
        int intValue = obj2 instanceof Integer ? ((Integer) obj2).intValue() : -1;
        if (intValue < 0) {
            return obj;
        }
        if (z10) {
            return index(((Map) obj).keySet().iterator(), intValue);
        }
        if (obj instanceof List) {
            return ((List) obj).get(intValue);
        }
        if (obj instanceof Object[]) {
            return ((Object[]) obj)[intValue];
        }
        if (obj instanceof Enumeration) {
            Enumeration enumeration = (Enumeration) obj;
            while (enumeration.hasMoreElements()) {
                intValue--;
                if (intValue == -1) {
                    return enumeration.nextElement();
                }
                enumeration.nextElement();
            }
            return obj;
        } else if (obj instanceof Iterator) {
            return index((Iterator) obj, intValue);
        } else {
            return obj instanceof Collection ? index(((Collection) obj).iterator(), intValue) : obj;
        }
    }

    public static void addAll(Collection collection, Enumeration enumeration) {
        while (enumeration.hasMoreElements()) {
            collection.add(enumeration.nextElement());
        }
    }

    public static Collection collect(Iterator it, Transformer transformer) {
        ArrayList arrayList = new ArrayList();
        collect(it, transformer, (Collection) arrayList);
        return arrayList;
    }

    public static void select(Collection collection, Predicate predicate, Collection collection2) {
        if (collection != null && predicate != null) {
            for (Object next : collection) {
                if (predicate.evaluate(next)) {
                    collection2.add(next);
                }
            }
        }
    }

    public static void selectRejected(Collection collection, Predicate predicate, Collection collection2) {
        if (collection != null && predicate != null) {
            for (Object next : collection) {
                if (!predicate.evaluate(next)) {
                    collection2.add(next);
                }
            }
        }
    }

    public static void addAll(Collection collection, Object[] objArr) {
        for (Object add : objArr) {
            collection.add(add);
        }
    }

    public static Collection collect(Collection collection, Transformer transformer, Collection collection2) {
        return collection != null ? collect(collection.iterator(), transformer, collection2) : collection2;
    }

    public static Collection collect(Iterator it, Transformer transformer, Collection collection) {
        if (!(it == null || transformer == null)) {
            while (it.hasNext()) {
                collection.add(transformer.transform(it.next()));
            }
        }
        return collection;
    }

    private static Object index(Iterator it, int i10) {
        while (it.hasNext()) {
            i10--;
            if (i10 == -1) {
                return it.next();
            }
            it.next();
        }
        return it;
    }
}
