package org.apache.commons.collections;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class CursorableLinkedList implements List, Serializable {
    private static final long serialVersionUID = 8836393098519411393L;
    protected transient List _cursors = new ArrayList();
    protected transient Listable _head = new Listable((Listable) null, (Listable) null, (Object) null);
    protected transient int _modCount = 0;
    protected transient int _size = 0;

    public class Cursor extends ListIter {
        boolean _valid = true;
        private final /* synthetic */ CursorableLinkedList this$0;

        Cursor(CursorableLinkedList cursorableLinkedList, int i10) {
            super(i10);
            this.this$0 = cursorableLinkedList;
            cursorableLinkedList.registerCursor(this);
        }

        public void add(Object obj) {
            checkForComod();
            Listable insertListable = this.this$0.insertListable(this._cur.prev(), this._cur.next(), obj);
            this._cur.setPrev(insertListable);
            this._cur.setNext(insertListable.next());
            this._lastReturned = null;
            this._nextIndex++;
            this._expectedModCount++;
        }

        /* access modifiers changed from: protected */
        public void checkForComod() {
            if (!this._valid) {
                throw new ConcurrentModificationException();
            }
        }

        public void close() {
            if (this._valid) {
                this._valid = false;
                this.this$0.unregisterCursor(this);
            }
        }

        /* access modifiers changed from: protected */
        public void invalidate() {
            this._valid = false;
        }

        /* access modifiers changed from: protected */
        public void listableChanged(Listable listable) {
            if (this._lastReturned == listable) {
                this._lastReturned = null;
            }
        }

        /* access modifiers changed from: protected */
        public void listableInserted(Listable listable) {
            if (this._cur.next() == null && this._cur.prev() == null) {
                this._cur.setNext(listable);
            } else if (this._cur.prev() == listable.prev()) {
                this._cur.setNext(listable);
            }
            if (this._cur.next() == listable.next()) {
                this._cur.setPrev(listable);
            }
            if (this._lastReturned == listable) {
                this._lastReturned = null;
            }
        }

        /* access modifiers changed from: protected */
        public void listableRemoved(Listable listable) {
            if (this.this$0._head.prev() == null) {
                this._cur.setNext((Listable) null);
            } else if (this._cur.next() == listable) {
                this._cur.setNext(listable.next());
            }
            if (this.this$0._head.next() == null) {
                this._cur.setPrev((Listable) null);
            } else if (this._cur.prev() == listable) {
                this._cur.setPrev(listable.prev());
            }
            if (this._lastReturned == listable) {
                this._lastReturned = null;
            }
        }

        public int nextIndex() {
            throw new UnsupportedOperationException();
        }

        public int previousIndex() {
            throw new UnsupportedOperationException();
        }
    }

    class ListIter implements ListIterator {
        Listable _cur = null;
        int _expectedModCount;
        Listable _lastReturned = null;
        int _nextIndex;

        ListIter(int i10) {
            this._expectedModCount = CursorableLinkedList.this._modCount;
            this._nextIndex = 0;
            if (i10 == 0) {
                this._cur = new Listable((Listable) null, CursorableLinkedList.this._head.next(), (Object) null);
                this._nextIndex = 0;
            } else if (i10 == CursorableLinkedList.this._size) {
                this._cur = new Listable(CursorableLinkedList.this._head.prev(), (Listable) null, (Object) null);
                this._nextIndex = CursorableLinkedList.this._size;
            } else {
                Listable listableAt = CursorableLinkedList.this.getListableAt(i10);
                this._cur = new Listable(listableAt.prev(), listableAt, (Object) null);
                this._nextIndex = i10;
            }
        }

        public void add(Object obj) {
            checkForComod();
            Listable listable = this._cur;
            listable.setPrev(CursorableLinkedList.this.insertListable(listable.prev(), this._cur.next(), obj));
            this._lastReturned = null;
            this._nextIndex++;
            this._expectedModCount++;
        }

        /* access modifiers changed from: protected */
        public void checkForComod() {
            if (this._expectedModCount != CursorableLinkedList.this._modCount) {
                throw new ConcurrentModificationException();
            }
        }

        public boolean hasNext() {
            checkForComod();
            if (this._cur.next() == null || this._cur.prev() == CursorableLinkedList.this._head.prev()) {
                return false;
            }
            return true;
        }

        public boolean hasPrevious() {
            checkForComod();
            if (this._cur.prev() == null || this._cur.next() == CursorableLinkedList.this._head.next()) {
                return false;
            }
            return true;
        }

        public Object next() {
            checkForComod();
            if (hasNext()) {
                Object value = this._cur.next().value();
                this._lastReturned = this._cur.next();
                Listable listable = this._cur;
                listable.setPrev(listable.next());
                Listable listable2 = this._cur;
                listable2.setNext(listable2.next().next());
                this._nextIndex++;
                return value;
            }
            throw new NoSuchElementException();
        }

        public int nextIndex() {
            checkForComod();
            if (!hasNext()) {
                return CursorableLinkedList.this.size();
            }
            return this._nextIndex;
        }

        public Object previous() {
            checkForComod();
            if (hasPrevious()) {
                Object value = this._cur.prev().value();
                this._lastReturned = this._cur.prev();
                Listable listable = this._cur;
                listable.setNext(listable.prev());
                Listable listable2 = this._cur;
                listable2.setPrev(listable2.prev().prev());
                this._nextIndex--;
                return value;
            }
            throw new NoSuchElementException();
        }

        public int previousIndex() {
            checkForComod();
            if (!hasPrevious()) {
                return -1;
            }
            return this._nextIndex - 1;
        }

        public void remove() {
            Listable listable;
            Listable listable2;
            checkForComod();
            Listable listable3 = this._lastReturned;
            if (listable3 != null) {
                Listable listable4 = this._cur;
                if (listable3 == CursorableLinkedList.this._head.prev()) {
                    listable = null;
                } else {
                    listable = this._lastReturned.next();
                }
                listable4.setNext(listable);
                Listable listable5 = this._cur;
                if (this._lastReturned == CursorableLinkedList.this._head.next()) {
                    listable2 = null;
                } else {
                    listable2 = this._lastReturned.prev();
                }
                listable5.setPrev(listable2);
                CursorableLinkedList.this.removeListable(this._lastReturned);
                this._lastReturned = null;
                this._nextIndex--;
                this._expectedModCount++;
                return;
            }
            throw new IllegalStateException();
        }

        public void set(Object obj) {
            checkForComod();
            try {
                this._lastReturned.setValue(obj);
            } catch (NullPointerException unused) {
                throw new IllegalStateException();
            }
        }
    }

    static class Listable implements Serializable {
        private Listable _next;
        private Listable _prev;
        private Object _val;

        Listable(Listable listable, Listable listable2, Object obj) {
            this._prev = listable;
            this._next = listable2;
            this._val = obj;
        }

        /* access modifiers changed from: package-private */
        public Listable next() {
            return this._next;
        }

        /* access modifiers changed from: package-private */
        public Listable prev() {
            return this._prev;
        }

        /* access modifiers changed from: package-private */
        public void setNext(Listable listable) {
            this._next = listable;
        }

        /* access modifiers changed from: package-private */
        public void setPrev(Listable listable) {
            this._prev = listable;
        }

        /* access modifiers changed from: package-private */
        public Object setValue(Object obj) {
            Object obj2 = this._val;
            this._val = obj;
            return obj2;
        }

        /* access modifiers changed from: package-private */
        public Object value() {
            return this._val;
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this._size = 0;
        this._modCount = 0;
        this._cursors = new ArrayList();
        this._head = new Listable((Listable) null, (Listable) null, (Object) null);
        int readInt = objectInputStream.readInt();
        for (int i10 = 0; i10 < readInt; i10++) {
            add(objectInputStream.readObject());
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(this._size);
        for (Listable next = this._head.next(); next != null; next = next.next()) {
            objectOutputStream.writeObject(next.value());
        }
    }

    public boolean add(Object obj) {
        insertListable(this._head.prev(), (Listable) null, obj);
        return true;
    }

    public boolean addAll(Collection collection) {
        if (collection.isEmpty()) {
            return false;
        }
        for (Object insertListable : collection) {
            insertListable(this._head.prev(), (Listable) null, insertListable);
        }
        return true;
    }

    public boolean addFirst(Object obj) {
        insertListable((Listable) null, this._head.next(), obj);
        return true;
    }

    public boolean addLast(Object obj) {
        insertListable(this._head.prev(), (Listable) null, obj);
        return true;
    }

    /* access modifiers changed from: protected */
    public void broadcastListableChanged(Listable listable) {
        Iterator it = this._cursors.iterator();
        while (it.hasNext()) {
            Cursor cursor = (Cursor) ((WeakReference) it.next()).get();
            if (cursor == null) {
                it.remove();
            } else {
                cursor.listableChanged(listable);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void broadcastListableInserted(Listable listable) {
        Iterator it = this._cursors.iterator();
        while (it.hasNext()) {
            Cursor cursor = (Cursor) ((WeakReference) it.next()).get();
            if (cursor == null) {
                it.remove();
            } else {
                cursor.listableInserted(listable);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void broadcastListableRemoved(Listable listable) {
        Iterator it = this._cursors.iterator();
        while (it.hasNext()) {
            Cursor cursor = (Cursor) ((WeakReference) it.next()).get();
            if (cursor == null) {
                it.remove();
            } else {
                cursor.listableRemoved(listable);
            }
        }
    }

    public void clear() {
        Iterator it = iterator();
        while (it.hasNext()) {
            it.next();
            it.remove();
        }
    }

    public boolean contains(Object obj) {
        Listable listable = null;
        for (Listable next = this._head.next(); next != null && listable != this._head.prev(); next = next.next()) {
            if (obj == null && next.value() == null) {
                return true;
            }
            if (obj != null && obj.equals(next.value())) {
                return true;
            }
            listable = next;
        }
        return false;
    }

    public boolean containsAll(Collection collection) {
        for (Object contains : collection) {
            if (!contains(contains)) {
                return false;
            }
        }
        return true;
    }

    public Cursor cursor() {
        return new Cursor(this, 0);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        ListIterator listIterator = ((List) obj).listIterator();
        Listable next = this._head.next();
        Listable listable = null;
        while (next != null && listable != this._head.prev()) {
            if (listIterator.hasNext()) {
                if (next.value() == null) {
                    if (listIterator.next() != null) {
                    }
                } else if (!next.value().equals(listIterator.next())) {
                }
                listable = next;
                next = next.next();
            }
            return false;
        }
        return !listIterator.hasNext();
    }

    public Object get(int i10) {
        return getListableAt(i10).value();
    }

    public Object getFirst() {
        try {
            return this._head.next().value();
        } catch (NullPointerException unused) {
            throw new NoSuchElementException();
        }
    }

    public Object getLast() {
        try {
            return this._head.prev().value();
        } catch (NullPointerException unused) {
            throw new NoSuchElementException();
        }
    }

    /* access modifiers changed from: protected */
    public Listable getListableAt(int i10) {
        int i11;
        if (i10 < 0 || i10 >= (i11 = this._size)) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(String.valueOf(i10));
            stringBuffer.append(" < 0 or ");
            stringBuffer.append(String.valueOf(i10));
            stringBuffer.append(" >= ");
            stringBuffer.append(this._size);
            throw new IndexOutOfBoundsException(stringBuffer.toString());
        } else if (i10 <= i11 / 2) {
            Listable next = this._head.next();
            for (int i12 = 0; i12 < i10; i12++) {
                next = next.next();
            }
            return next;
        } else {
            Listable prev = this._head.prev();
            for (int i13 = this._size - 1; i13 > i10; i13--) {
                prev = prev.prev();
            }
            return prev;
        }
    }

    public int hashCode() {
        int i10;
        int i11 = 1;
        Listable listable = null;
        for (Listable next = this._head.next(); next != null && listable != this._head.prev(); next = next.next()) {
            int i12 = i11 * 31;
            if (next.value() == null) {
                i10 = 0;
            } else {
                i10 = next.value().hashCode();
            }
            i11 = i12 + i10;
            listable = next;
        }
        return i11;
    }

    public int indexOf(Object obj) {
        Listable listable = null;
        int i10 = 0;
        if (obj == null) {
            Listable next = this._head.next();
            while (true) {
                Listable listable2 = listable;
                listable = next;
                Listable listable3 = listable2;
                if (listable == null || listable3 == this._head.prev()) {
                    return -1;
                }
                if (listable.value() == null) {
                    return i10;
                }
                i10++;
                next = listable.next();
            }
        } else {
            Listable listable4 = null;
            int i11 = 0;
            for (Listable next2 = this._head.next(); next2 != null && listable4 != this._head.prev(); next2 = next2.next()) {
                if (obj.equals(next2.value())) {
                    return i11;
                }
                i11++;
                listable4 = next2;
            }
            return -1;
        }
    }

    /* access modifiers changed from: protected */
    public Listable insertListable(Listable listable, Listable listable2, Object obj) {
        this._modCount++;
        this._size++;
        Listable listable3 = new Listable(listable, listable2, obj);
        if (listable != null) {
            listable.setNext(listable3);
        } else {
            this._head.setNext(listable3);
        }
        if (listable2 != null) {
            listable2.setPrev(listable3);
        } else {
            this._head.setPrev(listable3);
        }
        broadcastListableInserted(listable3);
        return listable3;
    }

    /* access modifiers changed from: protected */
    public void invalidateCursors() {
        Iterator it = this._cursors.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            Cursor cursor = (Cursor) weakReference.get();
            if (cursor != null) {
                cursor.invalidate();
                weakReference.clear();
            }
            it.remove();
        }
    }

    public boolean isEmpty() {
        return this._size == 0;
    }

    public Iterator iterator() {
        return listIterator(0);
    }

    public int lastIndexOf(Object obj) {
        int i10 = this._size - 1;
        Listable listable = null;
        if (obj == null) {
            Listable prev = this._head.prev();
            while (true) {
                Listable listable2 = listable;
                listable = prev;
                Listable listable3 = listable2;
                if (listable == null || listable3 == this._head.next()) {
                    return -1;
                }
                if (listable.value() == null) {
                    return i10;
                }
                i10--;
                prev = listable.prev();
            }
        } else {
            Listable prev2 = this._head.prev();
            while (true) {
                Listable listable4 = prev2;
                Listable listable5 = listable;
                listable = listable4;
                if (listable == null || listable5 == this._head.next()) {
                    return -1;
                }
                if (obj.equals(listable.value())) {
                    return i10;
                }
                i10--;
                prev2 = listable.prev();
            }
        }
    }

    public ListIterator listIterator() {
        return listIterator(0);
    }

    /* access modifiers changed from: protected */
    public void registerCursor(Cursor cursor) {
        Iterator it = this._cursors.iterator();
        while (it.hasNext()) {
            if (((WeakReference) it.next()).get() == null) {
                it.remove();
            }
        }
        this._cursors.add(new WeakReference(cursor));
    }

    public boolean remove(Object obj) {
        Listable next = this._head.next();
        Listable listable = null;
        while (next != null && listable != this._head.prev()) {
            if (obj == null && next.value() == null) {
                removeListable(next);
                return true;
            } else if (obj == null || !obj.equals(next.value())) {
                listable = next;
                next = next.next();
            } else {
                removeListable(next);
                return true;
            }
        }
        return false;
    }

    public boolean removeAll(Collection collection) {
        boolean z10 = false;
        if (!(collection.size() == 0 || this._size == 0)) {
            Iterator it = iterator();
            while (it.hasNext()) {
                if (collection.contains(it.next())) {
                    it.remove();
                    z10 = true;
                }
            }
        }
        return z10;
    }

    public Object removeFirst() {
        if (this._head.next() != null) {
            Object value = this._head.next().value();
            removeListable(this._head.next());
            return value;
        }
        throw new NoSuchElementException();
    }

    public Object removeLast() {
        if (this._head.prev() != null) {
            Object value = this._head.prev().value();
            removeListable(this._head.prev());
            return value;
        }
        throw new NoSuchElementException();
    }

    /* access modifiers changed from: protected */
    public void removeListable(Listable listable) {
        this._modCount++;
        this._size--;
        if (this._head.next() == listable) {
            this._head.setNext(listable.next());
        }
        if (listable.next() != null) {
            listable.next().setPrev(listable.prev());
        }
        if (this._head.prev() == listable) {
            this._head.setPrev(listable.prev());
        }
        if (listable.prev() != null) {
            listable.prev().setNext(listable.next());
        }
        broadcastListableRemoved(listable);
    }

    public boolean retainAll(Collection collection) {
        Iterator it = iterator();
        boolean z10 = false;
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
                z10 = true;
            }
        }
        return z10;
    }

    public Object set(int i10, Object obj) {
        Listable listableAt = getListableAt(i10);
        Object value = listableAt.setValue(obj);
        broadcastListableChanged(listableAt);
        return value;
    }

    public int size() {
        return this._size;
    }

    public List subList(int i10, int i11) {
        int i12;
        if (i10 < 0 || i11 > (i12 = this._size) || i10 > i11) {
            throw new IndexOutOfBoundsException();
        } else if (i10 == 0 && i11 == i12) {
            return this;
        } else {
            return new CursorableSubList(this, i10, i11);
        }
    }

    public Object[] toArray() {
        Object[] objArr = new Object[this._size];
        Listable next = this._head.next();
        int i10 = 0;
        Listable listable = null;
        while (next != null && listable != this._head.prev()) {
            objArr[i10] = next.value();
            int i11 = i10 + 1;
            listable = next;
            next = next.next();
            i10 = i11;
        }
        return objArr;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[");
        Listable listable = null;
        for (Listable next = this._head.next(); next != null && listable != this._head.prev(); next = next.next()) {
            if (this._head.next() != next) {
                stringBuffer.append(", ");
            }
            stringBuffer.append(next.value());
            listable = next;
        }
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    /* access modifiers changed from: protected */
    public void unregisterCursor(Cursor cursor) {
        Iterator it = this._cursors.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            Cursor cursor2 = (Cursor) weakReference.get();
            if (cursor2 == null) {
                it.remove();
            } else if (cursor2 == cursor) {
                weakReference.clear();
                it.remove();
                return;
            }
        }
    }

    public void add(int i10, Object obj) {
        int i11 = this._size;
        if (i10 == i11) {
            add(obj);
        } else if (i10 < 0 || i10 > i11) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(String.valueOf(i10));
            stringBuffer.append(" < 0 or ");
            stringBuffer.append(String.valueOf(i10));
            stringBuffer.append(" > ");
            stringBuffer.append(this._size);
            throw new IndexOutOfBoundsException(stringBuffer.toString());
        } else {
            Listable listable = null;
            Listable listableAt = isEmpty() ? null : getListableAt(i10);
            if (listableAt != null) {
                listable = listableAt.prev();
            }
            insertListable(listable, listableAt, obj);
        }
    }

    public Cursor cursor(int i10) {
        return new Cursor(this, i10);
    }

    public ListIterator listIterator(int i10) {
        if (i10 >= 0 && i10 <= this._size) {
            return new ListIter(i10);
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(i10);
        stringBuffer.append(" < 0 or > ");
        stringBuffer.append(this._size);
        throw new IndexOutOfBoundsException(stringBuffer.toString());
    }

    public boolean addAll(int i10, Collection collection) {
        Listable listable;
        if (collection.isEmpty()) {
            return false;
        }
        int i11 = this._size;
        if (i11 == i10 || i11 == 0) {
            return addAll(collection);
        }
        Listable listableAt = getListableAt(i10);
        if (listableAt == null) {
            listable = null;
        } else {
            listable = listableAt.prev();
        }
        for (Object insertListable : collection) {
            listable = insertListable(listable, listableAt, insertListable);
        }
        return true;
    }

    public Object[] toArray(Object[] objArr) {
        if (objArr.length < this._size) {
            objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), this._size);
        }
        int i10 = 0;
        Listable next = this._head.next();
        Listable listable = null;
        while (next != null && listable != this._head.prev()) {
            objArr[i10] = next.value();
            Listable listable2 = next;
            next = next.next();
            i10++;
            listable = listable2;
        }
        int length = objArr.length;
        int i11 = this._size;
        if (length > i11) {
            objArr[i11] = null;
        }
        return objArr;
    }

    public Object remove(int i10) {
        Listable listableAt = getListableAt(i10);
        Object value = listableAt.value();
        removeListable(listableAt);
        return value;
    }
}
