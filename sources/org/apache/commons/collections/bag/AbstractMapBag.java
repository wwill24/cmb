package org.apache.commons.collections.bag;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.collections.Bag;
import org.apache.commons.collections.set.UnmodifiableSet;
import org.apache.commons.validator.Field;

public abstract class AbstractMapBag implements Bag {
    /* access modifiers changed from: private */
    public transient Map map;
    /* access modifiers changed from: private */
    public transient int modCount;
    private int size;
    private transient Set uniqueSet;

    static class BagIterator implements Iterator {
        private boolean canRemove;
        private Map.Entry current = null;
        private Iterator entryIterator;
        private int itemCount;
        private final int mods;
        private AbstractMapBag parent;

        public BagIterator(AbstractMapBag abstractMapBag) {
            this.parent = abstractMapBag;
            this.entryIterator = abstractMapBag.map.entrySet().iterator();
            this.mods = abstractMapBag.modCount;
            this.canRemove = false;
        }

        public boolean hasNext() {
            return this.itemCount > 0 || this.entryIterator.hasNext();
        }

        public Object next() {
            if (this.parent.modCount == this.mods) {
                if (this.itemCount == 0) {
                    Map.Entry entry = (Map.Entry) this.entryIterator.next();
                    this.current = entry;
                    this.itemCount = ((MutableInteger) entry.getValue()).value;
                }
                this.canRemove = true;
                this.itemCount--;
                return this.current.getKey();
            }
            throw new ConcurrentModificationException();
        }

        public void remove() {
            if (this.parent.modCount != this.mods) {
                throw new ConcurrentModificationException();
            } else if (this.canRemove) {
                MutableInteger mutableInteger = (MutableInteger) this.current.getValue();
                int i10 = mutableInteger.value;
                if (i10 > 1) {
                    mutableInteger.value = i10 - 1;
                } else {
                    this.entryIterator.remove();
                }
                AbstractMapBag.access$210(this.parent);
                this.canRemove = false;
            } else {
                throw new IllegalStateException();
            }
        }
    }

    protected static class MutableInteger {
        protected int value;

        MutableInteger(int i10) {
            this.value = i10;
        }

        public boolean equals(Object obj) {
            if ((obj instanceof MutableInteger) && ((MutableInteger) obj).value == this.value) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.value;
        }
    }

    protected AbstractMapBag() {
    }

    static /* synthetic */ int access$210(AbstractMapBag abstractMapBag) {
        int i10 = abstractMapBag.size;
        abstractMapBag.size = i10 - 1;
        return i10;
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

    public void clear() {
        this.modCount++;
        this.map.clear();
        this.size = 0;
    }

    public boolean contains(Object obj) {
        return this.map.containsKey(obj);
    }

    public boolean containsAll(Collection collection) {
        if (collection instanceof Bag) {
            return containsAll((Bag) collection);
        }
        return containsAll((Bag) new HashBag(collection));
    }

    /* access modifiers changed from: protected */
    public void doReadObject(Map map2, ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        this.map = map2;
        int readInt = objectInputStream.readInt();
        for (int i10 = 0; i10 < readInt; i10++) {
            Object readObject = objectInputStream.readObject();
            int readInt2 = objectInputStream.readInt();
            map2.put(readObject, new MutableInteger(readInt2));
            this.size += readInt2;
        }
    }

    /* access modifiers changed from: protected */
    public void doWriteObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(this.map.size());
        for (Map.Entry entry : this.map.entrySet()) {
            objectOutputStream.writeObject(entry.getKey());
            objectOutputStream.writeInt(((MutableInteger) entry.getValue()).value);
        }
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
        for (Object next : this.map.keySet()) {
            if (bag.getCount(next) != getCount(next)) {
                return false;
            }
        }
        return true;
    }

    public int getCount(Object obj) {
        MutableInteger mutableInteger = (MutableInteger) this.map.get(obj);
        if (mutableInteger != null) {
            return mutableInteger.value;
        }
        return 0;
    }

    /* access modifiers changed from: protected */
    public Map getMap() {
        return this.map;
    }

    public int hashCode() {
        int i10;
        int i11 = 0;
        for (Map.Entry entry : this.map.entrySet()) {
            Object key = entry.getKey();
            MutableInteger mutableInteger = (MutableInteger) entry.getValue();
            if (key == null) {
                i10 = 0;
            } else {
                i10 = key.hashCode();
            }
            i11 += mutableInteger.value ^ i10;
        }
        return i11;
    }

    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    public Iterator iterator() {
        return new BagIterator(this);
    }

    public boolean remove(Object obj) {
        MutableInteger mutableInteger = (MutableInteger) this.map.get(obj);
        if (mutableInteger == null) {
            return false;
        }
        this.modCount++;
        this.map.remove(obj);
        this.size -= mutableInteger.value;
        return true;
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
        if (collection instanceof Bag) {
            return retainAll((Bag) collection);
        }
        return retainAll((Bag) new HashBag(collection));
    }

    public int size() {
        return this.size;
    }

    public Object[] toArray() {
        Object[] objArr = new Object[size()];
        int i10 = 0;
        for (Object next : this.map.keySet()) {
            int count = getCount(next);
            while (count > 0) {
                objArr[i10] = next;
                count--;
                i10++;
            }
        }
        return objArr;
    }

    public String toString() {
        if (size() == 0) {
            return Field.TOKEN_INDEXED;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append('[');
        Iterator it = uniqueSet().iterator();
        while (it.hasNext()) {
            Object next = it.next();
            stringBuffer.append(getCount(next));
            stringBuffer.append(':');
            stringBuffer.append(next);
            if (it.hasNext()) {
                stringBuffer.append(',');
            }
        }
        stringBuffer.append(PropertyUtils.INDEXED_DELIM2);
        return stringBuffer.toString();
    }

    public Set uniqueSet() {
        if (this.uniqueSet == null) {
            this.uniqueSet = UnmodifiableSet.decorate(this.map.keySet());
        }
        return this.uniqueSet;
    }

    protected AbstractMapBag(Map map2) {
        this.map = map2;
    }

    public boolean add(Object obj, int i10) {
        this.modCount++;
        if (i10 > 0) {
            MutableInteger mutableInteger = (MutableInteger) this.map.get(obj);
            this.size += i10;
            if (mutableInteger == null) {
                this.map.put(obj, new MutableInteger(i10));
                return true;
            }
            mutableInteger.value += i10;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
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

    /* access modifiers changed from: package-private */
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

    public boolean remove(Object obj, int i10) {
        MutableInteger mutableInteger = (MutableInteger) this.map.get(obj);
        if (mutableInteger == null || i10 <= 0) {
            return false;
        }
        this.modCount++;
        int i11 = mutableInteger.value;
        if (i10 < i11) {
            mutableInteger.value = i11 - i10;
            this.size -= i10;
        } else {
            this.map.remove(obj);
            this.size -= mutableInteger.value;
        }
        return true;
    }

    public Object[] toArray(Object[] objArr) {
        int size2 = size();
        if (objArr.length < size2) {
            objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), size2);
        }
        int i10 = 0;
        for (Object next : this.map.keySet()) {
            int count = getCount(next);
            while (count > 0) {
                objArr[i10] = next;
                count--;
                i10++;
            }
        }
        if (objArr.length > size2) {
            objArr[size2] = null;
        }
        return objArr;
    }
}
