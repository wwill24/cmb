package org.apache.commons.collections;

import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import org.apache.commons.collections.CursorableLinkedList;

class CursorableSubList extends CursorableLinkedList {
    protected CursorableLinkedList _list = null;
    protected CursorableLinkedList.Listable _post = null;
    protected CursorableLinkedList.Listable _pre = null;

    CursorableSubList(CursorableLinkedList cursorableLinkedList, int i10, int i11) {
        CursorableLinkedList.Listable listable;
        if (i10 < 0 || cursorableLinkedList.size() < i11) {
            throw new IndexOutOfBoundsException();
        } else if (i10 <= i11) {
            this._list = cursorableLinkedList;
            if (i10 < cursorableLinkedList.size()) {
                this._head.setNext(this._list.getListableAt(i10));
                if (this._head.next() == null) {
                    listable = null;
                } else {
                    listable = this._head.next().prev();
                }
                this._pre = listable;
            } else {
                this._pre = this._list.getListableAt(i10 - 1);
            }
            if (i10 == i11) {
                this._head.setNext((CursorableLinkedList.Listable) null);
                this._head.setPrev((CursorableLinkedList.Listable) null);
                if (i11 < cursorableLinkedList.size()) {
                    this._post = this._list.getListableAt(i11);
                } else {
                    this._post = null;
                }
            } else {
                this._head.setPrev(this._list.getListableAt(i11 - 1));
                this._post = this._head.prev().next();
            }
            this._size = i11 - i10;
            this._modCount = this._list._modCount;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public boolean add(Object obj) {
        checkForComod();
        return super.add(obj);
    }

    public boolean addAll(Collection collection) {
        checkForComod();
        return super.addAll(collection);
    }

    public boolean addFirst(Object obj) {
        checkForComod();
        return super.addFirst(obj);
    }

    public boolean addLast(Object obj) {
        checkForComod();
        return super.addLast(obj);
    }

    /* access modifiers changed from: protected */
    public void checkForComod() throws ConcurrentModificationException {
        if (this._modCount != this._list._modCount) {
            throw new ConcurrentModificationException();
        }
    }

    public void clear() {
        checkForComod();
        Iterator it = iterator();
        while (it.hasNext()) {
            it.next();
            it.remove();
        }
    }

    public boolean contains(Object obj) {
        checkForComod();
        return super.contains(obj);
    }

    public boolean containsAll(Collection collection) {
        checkForComod();
        return super.containsAll(collection);
    }

    public boolean equals(Object obj) {
        checkForComod();
        return super.equals(obj);
    }

    public Object get(int i10) {
        checkForComod();
        return super.get(i10);
    }

    public Object getFirst() {
        checkForComod();
        return super.getFirst();
    }

    public Object getLast() {
        checkForComod();
        return super.getLast();
    }

    public int hashCode() {
        checkForComod();
        return super.hashCode();
    }

    public int indexOf(Object obj) {
        checkForComod();
        return super.indexOf(obj);
    }

    /* access modifiers changed from: protected */
    public CursorableLinkedList.Listable insertListable(CursorableLinkedList.Listable listable, CursorableLinkedList.Listable listable2, Object obj) {
        CursorableLinkedList.Listable listable3;
        CursorableLinkedList.Listable listable4;
        this._modCount++;
        this._size++;
        CursorableLinkedList cursorableLinkedList = this._list;
        if (listable == null) {
            listable3 = this._pre;
        } else {
            listable3 = listable;
        }
        if (listable2 == null) {
            listable4 = this._post;
        } else {
            listable4 = listable2;
        }
        CursorableLinkedList.Listable insertListable = cursorableLinkedList.insertListable(listable3, listable4, obj);
        if (this._head.next() == null) {
            this._head.setNext(insertListable);
            this._head.setPrev(insertListable);
        }
        if (listable == this._head.prev()) {
            this._head.setPrev(insertListable);
        }
        if (listable2 == this._head.next()) {
            this._head.setNext(insertListable);
        }
        broadcastListableInserted(insertListable);
        return insertListable;
    }

    public boolean isEmpty() {
        checkForComod();
        return super.isEmpty();
    }

    public Iterator iterator() {
        checkForComod();
        return super.iterator();
    }

    public int lastIndexOf(Object obj) {
        checkForComod();
        return super.lastIndexOf(obj);
    }

    public ListIterator listIterator(int i10) {
        checkForComod();
        return super.listIterator(i10);
    }

    public boolean remove(Object obj) {
        checkForComod();
        return super.remove(obj);
    }

    public boolean removeAll(Collection collection) {
        checkForComod();
        return super.removeAll(collection);
    }

    public Object removeFirst() {
        checkForComod();
        return super.removeFirst();
    }

    public Object removeLast() {
        checkForComod();
        return super.removeLast();
    }

    /* access modifiers changed from: protected */
    public void removeListable(CursorableLinkedList.Listable listable) {
        this._modCount++;
        this._size--;
        if (this._head.next() == listable && this._head.prev() == listable) {
            this._head.setNext((CursorableLinkedList.Listable) null);
            this._head.setPrev((CursorableLinkedList.Listable) null);
        }
        if (this._head.next() == listable) {
            this._head.setNext(listable.next());
        }
        if (this._head.prev() == listable) {
            this._head.setPrev(listable.prev());
        }
        this._list.removeListable(listable);
        broadcastListableRemoved(listable);
    }

    public boolean retainAll(Collection collection) {
        checkForComod();
        return super.retainAll(collection);
    }

    public Object set(int i10, Object obj) {
        checkForComod();
        return super.set(i10, obj);
    }

    public int size() {
        checkForComod();
        return super.size();
    }

    public List subList(int i10, int i11) {
        checkForComod();
        return super.subList(i10, i11);
    }

    public Object[] toArray() {
        checkForComod();
        return super.toArray();
    }

    public void add(int i10, Object obj) {
        checkForComod();
        super.add(i10, obj);
    }

    public boolean addAll(int i10, Collection collection) {
        checkForComod();
        return super.addAll(i10, collection);
    }

    public ListIterator listIterator() {
        checkForComod();
        return super.listIterator();
    }

    public Object remove(int i10) {
        checkForComod();
        return super.remove(i10);
    }

    public Object[] toArray(Object[] objArr) {
        checkForComod();
        return super.toArray(objArr);
    }
}
