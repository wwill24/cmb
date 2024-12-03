package org.apache.commons.collections;

import com.facebook.internal.security.CertificateUtil;
import com.mparticle.kits.AppsFlyerKit;
import java.util.ArrayList;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.commons.collections.set.UnmodifiableSet;

public abstract class DefaultMapBag implements Bag {
    private Map _map = null;
    private int _mods = 0;
    private int _total = 0;

    static class BagIterator implements Iterator {
        private Object _current;
        private int _mods = 0;
        private DefaultMapBag _parent;
        private Iterator _support;

        public BagIterator(DefaultMapBag defaultMapBag, Iterator it) {
            this._parent = defaultMapBag;
            this._support = it;
            this._current = null;
            this._mods = defaultMapBag.modCount();
        }

        public boolean hasNext() {
            return this._support.hasNext();
        }

        public Object next() {
            if (this._parent.modCount() == this._mods) {
                Object next = this._support.next();
                this._current = next;
                return next;
            }
            throw new ConcurrentModificationException();
        }

        public void remove() {
            if (this._parent.modCount() == this._mods) {
                this._support.remove();
                this._parent.remove(this._current, 1);
                this._mods++;
                return;
            }
            throw new ConcurrentModificationException();
        }
    }

    public DefaultMapBag() {
    }

    private List extractList() {
        ArrayList arrayList = new ArrayList();
        for (Object next : uniqueSet()) {
            for (int count = getCount(next); count > 0; count--) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public int modCount() {
        return this._mods;
    }

    public boolean add(Object obj) {
        return add(obj, 1);
    }

    public boolean addAll(Collection collection) {
        Iterator it = collection.iterator();
        while (true) {
            boolean z10 = false;
            while (true) {
                if (!it.hasNext()) {
                    return z10;
                }
                boolean add = add(it.next());
                if (z10 || add) {
                    z10 = true;
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public int calcTotalSize() {
        int size = extractList().size();
        this._total = size;
        return size;
    }

    public void clear() {
        this._mods++;
        this._map.clear();
        this._total = 0;
    }

    public boolean contains(Object obj) {
        return this._map.containsKey(obj);
    }

    public boolean containsAll(Collection collection) {
        return containsAll((Bag) new HashBag(collection));
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Bag)) {
            return false;
        }
        Bag bag = (Bag) obj;
        if (bag.size() != size()) {
            return false;
        }
        for (Object next : this._map.keySet()) {
            if (bag.getCount(next) != getCount(next)) {
                return false;
            }
        }
        return true;
    }

    public int getCount(Object obj) {
        Integer integer = MapUtils.getInteger(this._map, obj);
        if (integer != null) {
            return integer.intValue();
        }
        return 0;
    }

    /* access modifiers changed from: protected */
    public Map getMap() {
        return this._map;
    }

    public int hashCode() {
        return this._map.hashCode();
    }

    public boolean isEmpty() {
        return this._map.isEmpty();
    }

    public Iterator iterator() {
        return new BagIterator(this, extractList().iterator());
    }

    public boolean remove(Object obj) {
        return remove(obj, getCount(obj));
    }

    public boolean removeAll(Collection collection) {
        if (collection == null) {
            return false;
        }
        Iterator it = collection.iterator();
        while (true) {
            boolean z10 = false;
            while (true) {
                if (!it.hasNext()) {
                    return z10;
                }
                boolean remove = remove(it.next(), 1);
                if (z10 || remove) {
                    z10 = true;
                }
            }
        }
    }

    public boolean retainAll(Collection collection) {
        return retainAll((Bag) new HashBag(collection));
    }

    /* access modifiers changed from: protected */
    public void setMap(Map map) {
        if (map == null || !map.isEmpty()) {
            throw new IllegalArgumentException("The map must be non-null and empty");
        }
        this._map = map;
    }

    public int size() {
        return this._total;
    }

    public Object[] toArray() {
        return extractList().toArray();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[");
        Iterator it = uniqueSet().iterator();
        while (it.hasNext()) {
            Object next = it.next();
            stringBuffer.append(getCount(next));
            stringBuffer.append(CertificateUtil.DELIMITER);
            stringBuffer.append(next);
            if (it.hasNext()) {
                stringBuffer.append(AppsFlyerKit.COMMA);
            }
        }
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    public Set uniqueSet() {
        return UnmodifiableSet.decorate(this._map.keySet());
    }

    public boolean add(Object obj, int i10) {
        this._mods++;
        if (i10 <= 0) {
            return false;
        }
        int count = getCount(obj) + i10;
        this._map.put(obj, new Integer(count));
        this._total += i10;
        if (count == i10) {
            return true;
        }
        return false;
    }

    public boolean containsAll(Bag bag) {
        Iterator it = bag.uniqueSet().iterator();
        while (true) {
            boolean z10 = true;
            while (true) {
                if (!it.hasNext()) {
                    return z10;
                }
                Object next = it.next();
                boolean z11 = getCount(next) >= bag.getCount(next);
                if (!z10 || !z11) {
                    z10 = false;
                }
            }
        }
    }

    public boolean remove(Object obj, int i10) {
        boolean z10 = true;
        this._mods++;
        int count = getCount(obj);
        if (i10 <= 0) {
            return false;
        }
        if (count > i10) {
            this._map.put(obj, new Integer(count - i10));
            this._total -= i10;
            return true;
        }
        if (this._map.remove(obj) == null) {
            z10 = false;
        }
        this._total -= count;
        return z10;
    }

    public boolean retainAll(Bag bag) {
        HashBag hashBag = new HashBag();
        for (Object next : uniqueSet()) {
            int count = getCount(next);
            int count2 = bag.getCount(next);
            if (1 > count2 || count2 > count) {
                hashBag.add(next, count);
            } else {
                hashBag.add(next, count - count2);
            }
        }
        if (!hashBag.isEmpty()) {
            return removeAll(hashBag);
        }
        return false;
    }

    public Object[] toArray(Object[] objArr) {
        return extractList().toArray(objArr);
    }

    protected DefaultMapBag(Map map) {
        setMap(map);
    }
}
