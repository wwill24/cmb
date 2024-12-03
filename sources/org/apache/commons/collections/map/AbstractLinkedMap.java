package org.apache.commons.collections.map;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import org.apache.commons.collections.MapIterator;
import org.apache.commons.collections.OrderedIterator;
import org.apache.commons.collections.OrderedMap;
import org.apache.commons.collections.OrderedMapIterator;
import org.apache.commons.collections.ResettableIterator;
import org.apache.commons.collections.iterators.EmptyOrderedIterator;
import org.apache.commons.collections.iterators.EmptyOrderedMapIterator;
import org.apache.commons.collections.map.AbstractHashedMap;

public class AbstractLinkedMap extends AbstractHashedMap implements OrderedMap {
    protected transient LinkEntry header;

    protected static class EntrySetIterator extends LinkIterator {
        protected EntrySetIterator(AbstractLinkedMap abstractLinkedMap) {
            super(abstractLinkedMap);
        }

        public Object next() {
            return super.nextEntry();
        }

        public Object previous() {
            return super.previousEntry();
        }
    }

    protected static class KeySetIterator extends EntrySetIterator {
        protected KeySetIterator(AbstractLinkedMap abstractLinkedMap) {
            super(abstractLinkedMap);
        }

        public Object next() {
            return super.nextEntry().getKey();
        }

        public Object previous() {
            return super.previousEntry().getKey();
        }
    }

    protected static class LinkEntry extends AbstractHashedMap.HashEntry {
        protected LinkEntry after;
        protected LinkEntry before;

        protected LinkEntry(AbstractHashedMap.HashEntry hashEntry, int i10, Object obj, Object obj2) {
            super(hashEntry, i10, obj, obj2);
        }
    }

    protected static abstract class LinkIterator implements OrderedIterator, ResettableIterator {
        protected int expectedModCount;
        protected LinkEntry last;
        protected LinkEntry next;
        protected final AbstractLinkedMap parent;

        protected LinkIterator(AbstractLinkedMap abstractLinkedMap) {
            this.parent = abstractLinkedMap;
            this.next = abstractLinkedMap.header.after;
            this.expectedModCount = abstractLinkedMap.modCount;
        }

        /* access modifiers changed from: protected */
        public LinkEntry currentEntry() {
            return this.last;
        }

        public boolean hasNext() {
            return this.next != this.parent.header;
        }

        public boolean hasPrevious() {
            return this.next.before != this.parent.header;
        }

        /* access modifiers changed from: protected */
        public LinkEntry nextEntry() {
            AbstractLinkedMap abstractLinkedMap = this.parent;
            if (abstractLinkedMap.modCount == this.expectedModCount) {
                LinkEntry linkEntry = this.next;
                if (linkEntry != abstractLinkedMap.header) {
                    this.last = linkEntry;
                    this.next = linkEntry.after;
                    return linkEntry;
                }
                throw new NoSuchElementException("No next() entry in the iteration");
            }
            throw new ConcurrentModificationException();
        }

        /* access modifiers changed from: protected */
        public LinkEntry previousEntry() {
            AbstractLinkedMap abstractLinkedMap = this.parent;
            if (abstractLinkedMap.modCount == this.expectedModCount) {
                LinkEntry linkEntry = this.next.before;
                if (linkEntry != abstractLinkedMap.header) {
                    this.next = linkEntry;
                    this.last = linkEntry;
                    return linkEntry;
                }
                throw new NoSuchElementException("No previous() entry in the iteration");
            }
            throw new ConcurrentModificationException();
        }

        public void remove() {
            LinkEntry linkEntry = this.last;
            if (linkEntry != null) {
                AbstractLinkedMap abstractLinkedMap = this.parent;
                if (abstractLinkedMap.modCount == this.expectedModCount) {
                    abstractLinkedMap.remove(linkEntry.getKey());
                    this.last = null;
                    this.expectedModCount = this.parent.modCount;
                    return;
                }
                throw new ConcurrentModificationException();
            }
            throw new IllegalStateException("remove() can only be called once after next()");
        }

        public void reset() {
            this.last = null;
            this.next = this.parent.header.after;
        }

        public String toString() {
            if (this.last == null) {
                return "Iterator[]";
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Iterator[");
            stringBuffer.append(this.last.getKey());
            stringBuffer.append("=");
            stringBuffer.append(this.last.getValue());
            stringBuffer.append("]");
            return stringBuffer.toString();
        }
    }

    protected static class LinkMapIterator extends LinkIterator implements OrderedMapIterator {
        protected LinkMapIterator(AbstractLinkedMap abstractLinkedMap) {
            super(abstractLinkedMap);
        }

        public Object getKey() {
            LinkEntry currentEntry = currentEntry();
            if (currentEntry != null) {
                return currentEntry.getKey();
            }
            throw new IllegalStateException("getKey() can only be called after next() and before remove()");
        }

        public Object getValue() {
            LinkEntry currentEntry = currentEntry();
            if (currentEntry != null) {
                return currentEntry.getValue();
            }
            throw new IllegalStateException("getValue() can only be called after next() and before remove()");
        }

        public Object next() {
            return super.nextEntry().getKey();
        }

        public Object previous() {
            return super.previousEntry().getKey();
        }

        public Object setValue(Object obj) {
            LinkEntry currentEntry = currentEntry();
            if (currentEntry != null) {
                return currentEntry.setValue(obj);
            }
            throw new IllegalStateException("setValue() can only be called after next() and before remove()");
        }
    }

    protected static class ValuesIterator extends LinkIterator {
        protected ValuesIterator(AbstractLinkedMap abstractLinkedMap) {
            super(abstractLinkedMap);
        }

        public Object next() {
            return super.nextEntry().getValue();
        }

        public Object previous() {
            return super.previousEntry().getValue();
        }
    }

    protected AbstractLinkedMap() {
    }

    /* access modifiers changed from: protected */
    public void addEntry(AbstractHashedMap.HashEntry hashEntry, int i10) {
        LinkEntry linkEntry = (LinkEntry) hashEntry;
        LinkEntry linkEntry2 = this.header;
        linkEntry.after = linkEntry2;
        linkEntry.before = linkEntry2.before;
        linkEntry2.before.after = linkEntry;
        linkEntry2.before = linkEntry;
        this.data[i10] = hashEntry;
    }

    public void clear() {
        super.clear();
        LinkEntry linkEntry = this.header;
        linkEntry.after = linkEntry;
        linkEntry.before = linkEntry;
    }

    public boolean containsValue(Object obj) {
        if (obj == null) {
            LinkEntry linkEntry = this.header;
            do {
                linkEntry = linkEntry.after;
                if (linkEntry == this.header) {
                    return false;
                }
            } while (linkEntry.getValue() != null);
            return true;
        }
        LinkEntry linkEntry2 = this.header;
        do {
            linkEntry2 = linkEntry2.after;
            if (linkEntry2 == this.header) {
                return false;
            }
        } while (!isEqualValue(obj, linkEntry2.getValue()));
        return true;
    }

    /* access modifiers changed from: protected */
    public AbstractHashedMap.HashEntry createEntry(AbstractHashedMap.HashEntry hashEntry, int i10, Object obj, Object obj2) {
        return new LinkEntry(hashEntry, i10, obj, obj2);
    }

    /* access modifiers changed from: protected */
    public Iterator createEntrySetIterator() {
        if (size() == 0) {
            return EmptyOrderedIterator.INSTANCE;
        }
        return new EntrySetIterator(this);
    }

    /* access modifiers changed from: protected */
    public Iterator createKeySetIterator() {
        if (size() == 0) {
            return EmptyOrderedIterator.INSTANCE;
        }
        return new KeySetIterator(this);
    }

    /* access modifiers changed from: protected */
    public Iterator createValuesIterator() {
        if (size() == 0) {
            return EmptyOrderedIterator.INSTANCE;
        }
        return new ValuesIterator(this);
    }

    /* access modifiers changed from: protected */
    public LinkEntry entryAfter(LinkEntry linkEntry) {
        return linkEntry.after;
    }

    /* access modifiers changed from: protected */
    public LinkEntry entryBefore(LinkEntry linkEntry) {
        return linkEntry.before;
    }

    public Object firstKey() {
        if (this.size != 0) {
            return this.header.after.getKey();
        }
        throw new NoSuchElementException("Map is empty");
    }

    /* access modifiers changed from: protected */
    public LinkEntry getEntry(int i10) {
        LinkEntry linkEntry;
        if (i10 >= 0) {
            int i11 = this.size;
            if (i10 < i11) {
                if (i10 < i11 / 2) {
                    linkEntry = this.header.after;
                    for (int i12 = 0; i12 < i10; i12++) {
                        linkEntry = linkEntry.after;
                    }
                } else {
                    LinkEntry linkEntry2 = this.header;
                    while (i11 > i10) {
                        linkEntry2 = linkEntry.before;
                        i11--;
                    }
                }
                return linkEntry;
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Index ");
            stringBuffer.append(i10);
            stringBuffer.append(" is invalid for size ");
            stringBuffer.append(this.size);
            throw new IndexOutOfBoundsException(stringBuffer.toString());
        }
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append("Index ");
        stringBuffer2.append(i10);
        stringBuffer2.append(" is less than zero");
        throw new IndexOutOfBoundsException(stringBuffer2.toString());
    }

    /* access modifiers changed from: protected */
    public void init() {
        LinkEntry linkEntry = (LinkEntry) createEntry((AbstractHashedMap.HashEntry) null, -1, (Object) null, (Object) null);
        this.header = linkEntry;
        linkEntry.after = linkEntry;
        linkEntry.before = linkEntry;
    }

    public Object lastKey() {
        if (this.size != 0) {
            return this.header.before.getKey();
        }
        throw new NoSuchElementException("Map is empty");
    }

    public MapIterator mapIterator() {
        if (this.size == 0) {
            return EmptyOrderedMapIterator.INSTANCE;
        }
        return new LinkMapIterator(this);
    }

    public Object nextKey(Object obj) {
        LinkEntry linkEntry;
        LinkEntry linkEntry2 = (LinkEntry) getEntry(obj);
        if (linkEntry2 == null || (linkEntry = linkEntry2.after) == this.header) {
            return null;
        }
        return linkEntry.getKey();
    }

    public OrderedMapIterator orderedMapIterator() {
        if (this.size == 0) {
            return EmptyOrderedMapIterator.INSTANCE;
        }
        return new LinkMapIterator(this);
    }

    public Object previousKey(Object obj) {
        LinkEntry linkEntry;
        LinkEntry linkEntry2 = (LinkEntry) getEntry(obj);
        if (linkEntry2 == null || (linkEntry = linkEntry2.before) == this.header) {
            return null;
        }
        return linkEntry.getKey();
    }

    /* access modifiers changed from: protected */
    public void removeEntry(AbstractHashedMap.HashEntry hashEntry, int i10, AbstractHashedMap.HashEntry hashEntry2) {
        LinkEntry linkEntry = (LinkEntry) hashEntry;
        LinkEntry linkEntry2 = linkEntry.before;
        linkEntry2.after = linkEntry.after;
        linkEntry.after.before = linkEntry2;
        linkEntry.after = null;
        linkEntry.before = null;
        super.removeEntry(hashEntry, i10, hashEntry2);
    }

    protected AbstractLinkedMap(int i10, float f10, int i11) {
        super(i10, f10, i11);
    }

    protected AbstractLinkedMap(int i10) {
        super(i10);
    }

    protected AbstractLinkedMap(int i10, float f10) {
        super(i10, f10);
    }

    protected AbstractLinkedMap(Map map) {
        super(map);
    }
}
