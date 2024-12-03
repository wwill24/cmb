package org.apache.commons.collections;

import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import org.apache.commons.collections.iterators.ArrayIterator;
import org.apache.commons.collections.iterators.ArrayListIterator;
import org.apache.commons.collections.iterators.CollatingIterator;
import org.apache.commons.collections.iterators.EmptyIterator;
import org.apache.commons.collections.iterators.EmptyListIterator;
import org.apache.commons.collections.iterators.EmptyMapIterator;
import org.apache.commons.collections.iterators.EmptyOrderedIterator;
import org.apache.commons.collections.iterators.EmptyOrderedMapIterator;
import org.apache.commons.collections.iterators.EnumerationIterator;
import org.apache.commons.collections.iterators.FilterIterator;
import org.apache.commons.collections.iterators.FilterListIterator;
import org.apache.commons.collections.iterators.IteratorChain;
import org.apache.commons.collections.iterators.IteratorEnumeration;
import org.apache.commons.collections.iterators.ListIteratorWrapper;
import org.apache.commons.collections.iterators.LoopingIterator;
import org.apache.commons.collections.iterators.LoopingListIterator;
import org.apache.commons.collections.iterators.ObjectArrayIterator;
import org.apache.commons.collections.iterators.ObjectArrayListIterator;
import org.apache.commons.collections.iterators.ObjectGraphIterator;
import org.apache.commons.collections.iterators.SingletonIterator;
import org.apache.commons.collections.iterators.SingletonListIterator;
import org.apache.commons.collections.iterators.TransformIterator;
import org.apache.commons.collections.iterators.UnmodifiableIterator;
import org.apache.commons.collections.iterators.UnmodifiableListIterator;
import org.apache.commons.collections.iterators.UnmodifiableMapIterator;

public class IteratorUtils {
    public static final ResettableIterator EMPTY_ITERATOR = EmptyIterator.RESETTABLE_INSTANCE;
    public static final ResettableListIterator EMPTY_LIST_ITERATOR = EmptyListIterator.RESETTABLE_INSTANCE;
    public static final MapIterator EMPTY_MAP_ITERATOR = EmptyMapIterator.INSTANCE;
    public static final OrderedIterator EMPTY_ORDERED_ITERATOR = EmptyOrderedIterator.INSTANCE;
    public static final OrderedMapIterator EMPTY_ORDERED_MAP_ITERATOR = EmptyOrderedMapIterator.INSTANCE;
    static /* synthetic */ Class class$java$util$Iterator;

    public static ResettableIterator arrayIterator(Object[] objArr) {
        return new ObjectArrayIterator(objArr);
    }

    public static ResettableListIterator arrayListIterator(Object[] objArr) {
        return new ObjectArrayListIterator(objArr);
    }

    public static Enumeration asEnumeration(Iterator it) {
        if (it != null) {
            return new IteratorEnumeration(it);
        }
        throw new NullPointerException("Iterator must not be null");
    }

    public static Iterator asIterator(Enumeration enumeration) {
        if (enumeration != null) {
            return new EnumerationIterator(enumeration);
        }
        throw new NullPointerException("Enumeration must not be null");
    }

    public static Iterator chainedIterator(Iterator it, Iterator it2) {
        return new IteratorChain(it, it2);
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e10) {
            throw new NoClassDefFoundError(e10.getMessage());
        }
    }

    public static Iterator collatedIterator(Comparator comparator, Iterator it, Iterator it2) {
        return new CollatingIterator(comparator, it, it2);
    }

    public static ResettableIterator emptyIterator() {
        return EMPTY_ITERATOR;
    }

    public static ResettableListIterator emptyListIterator() {
        return EMPTY_LIST_ITERATOR;
    }

    public static MapIterator emptyMapIterator() {
        return EMPTY_MAP_ITERATOR;
    }

    public static OrderedIterator emptyOrderedIterator() {
        return EMPTY_ORDERED_ITERATOR;
    }

    public static OrderedMapIterator emptyOrderedMapIterator() {
        return EMPTY_ORDERED_MAP_ITERATOR;
    }

    public static Iterator filteredIterator(Iterator it, Predicate predicate) {
        if (it == null) {
            throw new NullPointerException("Iterator must not be null");
        } else if (predicate != null) {
            return new FilterIterator(it, predicate);
        } else {
            throw new NullPointerException("Predicate must not be null");
        }
    }

    public static ListIterator filteredListIterator(ListIterator listIterator, Predicate predicate) {
        if (listIterator == null) {
            throw new NullPointerException("ListIterator must not be null");
        } else if (predicate != null) {
            return new FilterListIterator(listIterator, predicate);
        } else {
            throw new NullPointerException("Predicate must not be null");
        }
    }

    public static Iterator getIterator(Object obj) {
        Iterator it;
        if (obj == null) {
            return emptyIterator();
        }
        if (obj instanceof Iterator) {
            return (Iterator) obj;
        }
        if (obj instanceof Collection) {
            return ((Collection) obj).iterator();
        }
        if (obj instanceof Object[]) {
            return new ObjectArrayIterator((Object[]) obj);
        }
        if (obj instanceof Enumeration) {
            return new EnumerationIterator((Enumeration) obj);
        }
        if (obj instanceof Map) {
            return ((Map) obj).values().iterator();
        }
        if (obj instanceof Dictionary) {
            return new EnumerationIterator(((Dictionary) obj).elements());
        }
        if (obj.getClass().isArray()) {
            return new ArrayIterator(obj);
        }
        try {
            Method method = obj.getClass().getMethod("iterator", (Class[]) null);
            Class cls = class$java$util$Iterator;
            if (cls == null) {
                cls = class$("java.util.Iterator");
                class$java$util$Iterator = cls;
            }
            if (cls.isAssignableFrom(method.getReturnType()) && (it = (Iterator) method.invoke(obj, (Object[]) null)) != null) {
                return it;
            }
        } catch (Exception unused) {
        }
        return singletonIterator(obj);
    }

    public static ResettableIterator loopingIterator(Collection collection) {
        if (collection != null) {
            return new LoopingIterator(collection);
        }
        throw new NullPointerException("Collection must not be null");
    }

    public static ResettableListIterator loopingListIterator(List list) {
        if (list != null) {
            return new LoopingListIterator(list);
        }
        throw new NullPointerException("List must not be null");
    }

    public static Iterator objectGraphIterator(Object obj, Transformer transformer) {
        return new ObjectGraphIterator(obj, transformer);
    }

    public static ResettableIterator singletonIterator(Object obj) {
        return new SingletonIterator(obj);
    }

    public static ListIterator singletonListIterator(Object obj) {
        return new SingletonListIterator(obj);
    }

    public static Object[] toArray(Iterator it) {
        if (it != null) {
            return toList(it, 100).toArray();
        }
        throw new NullPointerException("Iterator must not be null");
    }

    public static List toList(Iterator it) {
        return toList(it, 10);
    }

    public static ListIterator toListIterator(Iterator it) {
        if (it != null) {
            return new ListIteratorWrapper(it);
        }
        throw new NullPointerException("Iterator must not be null");
    }

    public static Iterator transformedIterator(Iterator it, Transformer transformer) {
        if (it == null) {
            throw new NullPointerException("Iterator must not be null");
        } else if (transformer != null) {
            return new TransformIterator(it, transformer);
        } else {
            throw new NullPointerException("Transformer must not be null");
        }
    }

    public static Iterator unmodifiableIterator(Iterator it) {
        return UnmodifiableIterator.decorate(it);
    }

    public static ListIterator unmodifiableListIterator(ListIterator listIterator) {
        return UnmodifiableListIterator.decorate(listIterator);
    }

    public static MapIterator unmodifiableMapIterator(MapIterator mapIterator) {
        return UnmodifiableMapIterator.decorate(mapIterator);
    }

    public static ResettableIterator arrayIterator(Object obj) {
        return new ArrayIterator(obj);
    }

    public static ResettableListIterator arrayListIterator(Object obj) {
        return new ArrayListIterator(obj);
    }

    public static Iterator chainedIterator(Iterator[] itArr) {
        return new IteratorChain(itArr);
    }

    public static Iterator collatedIterator(Comparator comparator, Iterator[] itArr) {
        return new CollatingIterator(comparator, itArr);
    }

    public static List toList(Iterator it, int i10) {
        if (it == null) {
            throw new NullPointerException("Iterator must not be null");
        } else if (i10 >= 1) {
            ArrayList arrayList = new ArrayList(i10);
            while (it.hasNext()) {
                arrayList.add(it.next());
            }
            return arrayList;
        } else {
            throw new IllegalArgumentException("Estimated size must be greater than 0");
        }
    }

    public static ResettableIterator arrayIterator(Object[] objArr, int i10) {
        return new ObjectArrayIterator(objArr, i10);
    }

    public static ResettableListIterator arrayListIterator(Object[] objArr, int i10) {
        return new ObjectArrayListIterator(objArr, i10);
    }

    public static Iterator asIterator(Enumeration enumeration, Collection collection) {
        if (enumeration == null) {
            throw new NullPointerException("Enumeration must not be null");
        } else if (collection != null) {
            return new EnumerationIterator(enumeration, collection);
        } else {
            throw new NullPointerException("Collection must not be null");
        }
    }

    public static Iterator chainedIterator(Collection collection) {
        return new IteratorChain(collection);
    }

    public static Iterator collatedIterator(Comparator comparator, Collection collection) {
        return new CollatingIterator(comparator, collection);
    }

    public static ResettableIterator arrayIterator(Object obj, int i10) {
        return new ArrayIterator(obj, i10);
    }

    public static ResettableListIterator arrayListIterator(Object obj, int i10) {
        return new ArrayListIterator(obj, i10);
    }

    public static Object[] toArray(Iterator it, Class cls) {
        if (it == null) {
            throw new NullPointerException("Iterator must not be null");
        } else if (cls != null) {
            List list = toList(it, 100);
            return list.toArray((Object[]) Array.newInstance(cls, list.size()));
        } else {
            throw new NullPointerException("Array class must not be null");
        }
    }

    public static ResettableIterator arrayIterator(Object[] objArr, int i10, int i11) {
        return new ObjectArrayIterator(objArr, i10, i11);
    }

    public static ResettableListIterator arrayListIterator(Object[] objArr, int i10, int i11) {
        return new ObjectArrayListIterator(objArr, i10, i11);
    }

    public static ResettableIterator arrayIterator(Object obj, int i10, int i11) {
        return new ArrayIterator(obj, i10, i11);
    }

    public static ResettableListIterator arrayListIterator(Object obj, int i10, int i11) {
        return new ArrayListIterator(obj, i10, i11);
    }
}
