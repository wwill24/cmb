package org.apache.commons.collections.list;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import org.apache.commons.collections.list.AbstractLinkedList;

public class CursorableLinkedList extends AbstractLinkedList implements Serializable {
    private static final long serialVersionUID = 8836393098519411393L;
    protected transient List cursors = new ArrayList();

    public static class Cursor extends AbstractLinkedList.LinkedListIterator {
        boolean currentRemovedByAnother = false;
        boolean nextIndexValid = true;
        boolean valid = true;

        protected Cursor(CursorableLinkedList cursorableLinkedList, int i10) {
            super(cursorableLinkedList, i10);
        }

        public void add(Object obj) {
            super.add(obj);
            this.next = this.next.next;
        }

        /* access modifiers changed from: protected */
        public void checkModCount() {
            if (!this.valid) {
                throw new ConcurrentModificationException("Cursor closed");
            }
        }

        public void close() {
            if (this.valid) {
                ((CursorableLinkedList) this.parent).unregisterCursor(this);
                this.valid = false;
            }
        }

        public int nextIndex() {
            if (!this.nextIndexValid) {
                AbstractLinkedList.Node node = this.next;
                AbstractLinkedList abstractLinkedList = this.parent;
                AbstractLinkedList.Node node2 = abstractLinkedList.header;
                if (node == node2) {
                    this.nextIndex = abstractLinkedList.size();
                } else {
                    int i10 = 0;
                    for (AbstractLinkedList.Node node3 = node2.next; node3 != this.next; node3 = node3.next) {
                        i10++;
                    }
                    this.nextIndex = i10;
                }
                this.nextIndexValid = true;
            }
            return this.nextIndex;
        }

        /* access modifiers changed from: protected */
        public void nodeChanged(AbstractLinkedList.Node node) {
        }

        /* access modifiers changed from: protected */
        public void nodeInserted(AbstractLinkedList.Node node) {
            if (node.previous == this.current) {
                this.next = node;
            } else if (this.next.previous == node) {
                this.next = node;
            } else {
                this.nextIndexValid = false;
            }
        }

        /* access modifiers changed from: protected */
        public void nodeRemoved(AbstractLinkedList.Node node) {
            AbstractLinkedList.Node node2 = this.next;
            if (node == node2 && node == this.current) {
                this.next = node.next;
                this.current = null;
                this.currentRemovedByAnother = true;
            } else if (node == node2) {
                this.next = node.next;
                this.currentRemovedByAnother = false;
            } else if (node == this.current) {
                this.current = null;
                this.currentRemovedByAnother = true;
                this.nextIndex--;
            } else {
                this.nextIndexValid = false;
                this.currentRemovedByAnother = false;
            }
        }

        public void remove() {
            if (this.current != null || !this.currentRemovedByAnother) {
                checkModCount();
                this.parent.removeNode(getLastNodeReturned());
            }
            this.currentRemovedByAnother = false;
        }
    }

    protected static class SubCursor extends Cursor {
        protected final AbstractLinkedList.LinkedSubList sub;

        protected SubCursor(AbstractLinkedList.LinkedSubList linkedSubList, int i10) {
            super((CursorableLinkedList) linkedSubList.parent, i10 + linkedSubList.offset);
            this.sub = linkedSubList;
        }

        public void add(Object obj) {
            super.add(obj);
            AbstractLinkedList.LinkedSubList linkedSubList = this.sub;
            linkedSubList.expectedModCount = this.parent.modCount;
            linkedSubList.size++;
        }

        public boolean hasNext() {
            return nextIndex() < this.sub.size;
        }

        public boolean hasPrevious() {
            return previousIndex() >= 0;
        }

        public int nextIndex() {
            return super.nextIndex() - this.sub.offset;
        }

        public void remove() {
            super.remove();
            AbstractLinkedList.LinkedSubList linkedSubList = this.sub;
            linkedSubList.expectedModCount = this.parent.modCount;
            linkedSubList.size--;
        }
    }

    public CursorableLinkedList() {
        init();
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
    public void addNode(AbstractLinkedList.Node node, AbstractLinkedList.Node node2) {
        super.addNode(node, node2);
        broadcastNodeInserted(node);
    }

    /* access modifiers changed from: protected */
    public void broadcastNodeChanged(AbstractLinkedList.Node node) {
        Iterator it = this.cursors.iterator();
        while (it.hasNext()) {
            Cursor cursor = (Cursor) ((WeakReference) it.next()).get();
            if (cursor == null) {
                it.remove();
            } else {
                cursor.nodeChanged(node);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void broadcastNodeInserted(AbstractLinkedList.Node node) {
        Iterator it = this.cursors.iterator();
        while (it.hasNext()) {
            Cursor cursor = (Cursor) ((WeakReference) it.next()).get();
            if (cursor == null) {
                it.remove();
            } else {
                cursor.nodeInserted(node);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void broadcastNodeRemoved(AbstractLinkedList.Node node) {
        Iterator it = this.cursors.iterator();
        while (it.hasNext()) {
            Cursor cursor = (Cursor) ((WeakReference) it.next()).get();
            if (cursor == null) {
                it.remove();
            } else {
                cursor.nodeRemoved(node);
            }
        }
    }

    /* access modifiers changed from: protected */
    public ListIterator createSubListListIterator(AbstractLinkedList.LinkedSubList linkedSubList, int i10) {
        SubCursor subCursor = new SubCursor(linkedSubList, i10);
        registerCursor(subCursor);
        return subCursor;
    }

    public Cursor cursor() {
        return cursor(0);
    }

    /* access modifiers changed from: protected */
    public void init() {
        super.init();
        this.cursors = new ArrayList();
    }

    public Iterator iterator() {
        return super.listIterator(0);
    }

    public ListIterator listIterator() {
        return cursor(0);
    }

    /* access modifiers changed from: protected */
    public void registerCursor(Cursor cursor) {
        Iterator it = this.cursors.iterator();
        while (it.hasNext()) {
            if (((WeakReference) it.next()).get() == null) {
                it.remove();
            }
        }
        this.cursors.add(new WeakReference(cursor));
    }

    /* access modifiers changed from: protected */
    public void removeAllNodes() {
        if (size() > 0) {
            Iterator it = iterator();
            while (it.hasNext()) {
                it.next();
                it.remove();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void removeNode(AbstractLinkedList.Node node) {
        super.removeNode(node);
        broadcastNodeRemoved(node);
    }

    /* access modifiers changed from: protected */
    public void unregisterCursor(Cursor cursor) {
        Iterator it = this.cursors.iterator();
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

    /* access modifiers changed from: protected */
    public void updateNode(AbstractLinkedList.Node node, Object obj) {
        super.updateNode(node, obj);
        broadcastNodeChanged(node);
    }

    public Cursor cursor(int i10) {
        Cursor cursor = new Cursor(this, i10);
        registerCursor(cursor);
        return cursor;
    }

    public ListIterator listIterator(int i10) {
        return cursor(i10);
    }

    public CursorableLinkedList(Collection collection) {
        super(collection);
    }
}
