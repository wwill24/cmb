package org.apache.commons.collections.map;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
import org.apache.commons.collections.BoundedMap;
import org.apache.commons.collections.map.AbstractHashedMap;
import org.apache.commons.collections.map.AbstractLinkedMap;

public class LRUMap extends AbstractLinkedMap implements BoundedMap, Serializable, Cloneable {
    protected static final int DEFAULT_MAX_SIZE = 100;
    private static final long serialVersionUID = -612114643488955218L;
    private transient int maxSize;
    private boolean scanUntilRemovable;

    public LRUMap() {
        this(100, 0.75f, false);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        doReadObject(objectInputStream);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        doWriteObject(objectOutputStream);
    }

    /* access modifiers changed from: protected */
    public void addMapping(int i10, int i11, Object obj, Object obj2) {
        Object obj3 = obj;
        Object obj4 = obj2;
        if (isFull()) {
            AbstractLinkedMap.LinkEntry linkEntry = this.header.after;
            boolean z10 = false;
            if (this.scanUntilRemovable) {
                while (true) {
                    if (linkEntry == this.header || linkEntry == null) {
                        break;
                    } else if (removeLRU(linkEntry)) {
                        z10 = true;
                        break;
                    } else {
                        linkEntry = linkEntry.after;
                    }
                }
                if (linkEntry == null) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("Entry.after=null, header.after");
                    stringBuffer.append(this.header.after);
                    stringBuffer.append(" header.before");
                    stringBuffer.append(this.header.before);
                    stringBuffer.append(" key=");
                    stringBuffer.append(obj3);
                    stringBuffer.append(" value=");
                    stringBuffer.append(obj4);
                    stringBuffer.append(" size=");
                    stringBuffer.append(this.size);
                    stringBuffer.append(" maxSize=");
                    stringBuffer.append(this.maxSize);
                    stringBuffer.append(" Please check that your keys are immutable, and that you have used synchronization properly.");
                    stringBuffer.append(" If so, then please report this to commons-dev@jakarta.apache.org as a bug.");
                    throw new IllegalStateException(stringBuffer.toString());
                }
            } else {
                z10 = removeLRU(linkEntry);
            }
            AbstractLinkedMap.LinkEntry linkEntry2 = linkEntry;
            if (!z10) {
                super.addMapping(i10, i11, obj, obj2);
            } else if (linkEntry2 != null) {
                reuseMapping(linkEntry2, i10, i11, obj, obj2);
            } else {
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append("reuse=null, header.after=");
                stringBuffer2.append(this.header.after);
                stringBuffer2.append(" header.before");
                stringBuffer2.append(this.header.before);
                stringBuffer2.append(" key=");
                stringBuffer2.append(obj3);
                stringBuffer2.append(" value=");
                stringBuffer2.append(obj4);
                stringBuffer2.append(" size=");
                stringBuffer2.append(this.size);
                stringBuffer2.append(" maxSize=");
                stringBuffer2.append(this.maxSize);
                stringBuffer2.append(" Please check that your keys are immutable, and that you have used synchronization properly.");
                stringBuffer2.append(" If so, then please report this to commons-dev@jakarta.apache.org as a bug.");
                throw new IllegalStateException(stringBuffer2.toString());
            }
        } else {
            super.addMapping(i10, i11, obj, obj2);
        }
    }

    public Object clone() {
        return super.clone();
    }

    /* access modifiers changed from: protected */
    public void doReadObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        this.maxSize = objectInputStream.readInt();
        super.doReadObject(objectInputStream);
    }

    /* access modifiers changed from: protected */
    public void doWriteObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(this.maxSize);
        super.doWriteObject(objectOutputStream);
    }

    public Object get(Object obj) {
        AbstractLinkedMap.LinkEntry linkEntry = (AbstractLinkedMap.LinkEntry) getEntry(obj);
        if (linkEntry == null) {
            return null;
        }
        moveToMRU(linkEntry);
        return linkEntry.getValue();
    }

    public boolean isFull() {
        return this.size >= this.maxSize;
    }

    public boolean isScanUntilRemovable() {
        return this.scanUntilRemovable;
    }

    public int maxSize() {
        return this.maxSize;
    }

    /* access modifiers changed from: protected */
    public void moveToMRU(AbstractLinkedMap.LinkEntry linkEntry) {
        AbstractLinkedMap.LinkEntry linkEntry2 = linkEntry.after;
        AbstractLinkedMap.LinkEntry linkEntry3 = this.header;
        if (linkEntry2 != linkEntry3) {
            this.modCount++;
            AbstractLinkedMap.LinkEntry linkEntry4 = linkEntry.before;
            linkEntry4.after = linkEntry2;
            linkEntry.after.before = linkEntry4;
            linkEntry.after = linkEntry3;
            linkEntry.before = linkEntry3.before;
            linkEntry3.before.after = linkEntry;
            linkEntry3.before = linkEntry;
        } else if (linkEntry == linkEntry3) {
            throw new IllegalStateException("Can't move header to MRU (please report this to commons-dev@jakarta.apache.org)");
        }
    }

    /* access modifiers changed from: protected */
    public boolean removeLRU(AbstractLinkedMap.LinkEntry linkEntry) {
        return true;
    }

    /* access modifiers changed from: protected */
    public void reuseMapping(AbstractLinkedMap.LinkEntry linkEntry, int i10, int i11, Object obj, Object obj2) {
        AbstractLinkedMap.LinkEntry linkEntry2 = linkEntry;
        Object obj3 = obj;
        Object obj4 = obj2;
        boolean z10 = true;
        try {
            int hashIndex = hashIndex(linkEntry2.hashCode, this.data.length);
            AbstractHashedMap.HashEntry hashEntry = this.data[hashIndex];
            AbstractHashedMap.HashEntry hashEntry2 = null;
            while (hashEntry != linkEntry2 && hashEntry != null) {
                hashEntry2 = hashEntry;
                hashEntry = hashEntry.next;
            }
            if (hashEntry != null) {
                this.modCount++;
                removeEntry(linkEntry2, hashIndex, hashEntry2);
                reuseEntry(linkEntry, i10, i11, obj, obj2);
                addEntry(linkEntry, i10);
                return;
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Entry.next=null, data[removeIndex]=");
            stringBuffer.append(this.data[hashIndex]);
            stringBuffer.append(" previous=");
            stringBuffer.append(hashEntry2);
            stringBuffer.append(" key=");
            stringBuffer.append(obj3);
            stringBuffer.append(" value=");
            stringBuffer.append(obj4);
            stringBuffer.append(" size=");
            stringBuffer.append(this.size);
            stringBuffer.append(" maxSize=");
            stringBuffer.append(this.maxSize);
            stringBuffer.append(" Please check that your keys are immutable, and that you have used synchronization properly.");
            stringBuffer.append(" If so, then please report this to commons-dev@jakarta.apache.org as a bug.");
            throw new IllegalStateException(stringBuffer.toString());
        } catch (NullPointerException unused) {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("NPE, entry=");
            stringBuffer2.append(linkEntry2);
            stringBuffer2.append(" entryIsHeader=");
            if (linkEntry2 != this.header) {
                z10 = false;
            }
            stringBuffer2.append(z10);
            stringBuffer2.append(" key=");
            stringBuffer2.append(obj3);
            stringBuffer2.append(" value=");
            stringBuffer2.append(obj4);
            stringBuffer2.append(" size=");
            stringBuffer2.append(this.size);
            stringBuffer2.append(" maxSize=");
            stringBuffer2.append(this.maxSize);
            stringBuffer2.append(" Please check that your keys are immutable, and that you have used synchronization properly.");
            stringBuffer2.append(" If so, then please report this to commons-dev@jakarta.apache.org as a bug.");
            throw new IllegalStateException(stringBuffer2.toString());
        }
    }

    /* access modifiers changed from: protected */
    public void updateEntry(AbstractHashedMap.HashEntry hashEntry, Object obj) {
        moveToMRU((AbstractLinkedMap.LinkEntry) hashEntry);
        hashEntry.setValue(obj);
    }

    public LRUMap(int i10) {
        this(i10, 0.75f);
    }

    public LRUMap(int i10, boolean z10) {
        this(i10, 0.75f, z10);
    }

    public LRUMap(int i10, float f10) {
        this(i10, f10, false);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LRUMap(int i10, float f10, boolean z10) {
        super(i10 < 1 ? 16 : i10, f10);
        if (i10 >= 1) {
            this.maxSize = i10;
            this.scanUntilRemovable = z10;
            return;
        }
        throw new IllegalArgumentException("LRUMap max size must be greater than 0");
    }

    public LRUMap(Map map) {
        this(map, false);
    }

    public LRUMap(Map map, boolean z10) {
        this(map.size(), 0.75f, z10);
        putAll(map);
    }
}
