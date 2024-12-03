package org.apache.commons.collections.list;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.util.AbstractList;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import org.apache.commons.collections.OrderedIterator;
import org.apache.commons.validator.Field;

public abstract class AbstractLinkedList implements List {
    protected transient Node header;
    protected transient int modCount;
    protected transient int size;

    protected static class LinkedListIterator implements ListIterator, OrderedIterator {
        protected Node current;
        protected int expectedModCount;
        protected Node next;
        protected int nextIndex;
        protected final AbstractLinkedList parent;

        protected LinkedListIterator(AbstractLinkedList abstractLinkedList, int i10) throws IndexOutOfBoundsException {
            this.parent = abstractLinkedList;
            this.expectedModCount = abstractLinkedList.modCount;
            this.next = abstractLinkedList.getNode(i10, true);
            this.nextIndex = i10;
        }

        public void add(Object obj) {
            checkModCount();
            this.parent.addNodeBefore(this.next, obj);
            this.current = null;
            this.nextIndex++;
            this.expectedModCount++;
        }

        /* access modifiers changed from: protected */
        public void checkModCount() {
            if (this.parent.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }

        /* access modifiers changed from: protected */
        public Node getLastNodeReturned() throws IllegalStateException {
            Node node = this.current;
            if (node != null) {
                return node;
            }
            throw new IllegalStateException();
        }

        public boolean hasNext() {
            return this.next != this.parent.header;
        }

        public boolean hasPrevious() {
            return this.next.previous != this.parent.header;
        }

        public Object next() {
            checkModCount();
            if (hasNext()) {
                Object value = this.next.getValue();
                Node node = this.next;
                this.current = node;
                this.next = node.next;
                this.nextIndex++;
                return value;
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("No element at index ");
            stringBuffer.append(this.nextIndex);
            stringBuffer.append(".");
            throw new NoSuchElementException(stringBuffer.toString());
        }

        public int nextIndex() {
            return this.nextIndex;
        }

        public Object previous() {
            checkModCount();
            if (hasPrevious()) {
                Node node = this.next.previous;
                this.next = node;
                Object value = node.getValue();
                this.current = this.next;
                this.nextIndex--;
                return value;
            }
            throw new NoSuchElementException("Already at start of list.");
        }

        public int previousIndex() {
            return nextIndex() - 1;
        }

        public void remove() {
            checkModCount();
            Node node = this.current;
            Node node2 = this.next;
            if (node == node2) {
                this.next = node2.next;
                this.parent.removeNode(getLastNodeReturned());
            } else {
                this.parent.removeNode(getLastNodeReturned());
                this.nextIndex--;
            }
            this.current = null;
            this.expectedModCount++;
        }

        public void set(Object obj) {
            checkModCount();
            getLastNodeReturned().setValue(obj);
        }
    }

    protected static class LinkedSubList extends AbstractList {
        int expectedModCount;
        int offset;
        AbstractLinkedList parent;
        int size;

        protected LinkedSubList(AbstractLinkedList abstractLinkedList, int i10, int i11) {
            if (i10 < 0) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("fromIndex = ");
                stringBuffer.append(i10);
                throw new IndexOutOfBoundsException(stringBuffer.toString());
            } else if (i11 > abstractLinkedList.size()) {
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append("toIndex = ");
                stringBuffer2.append(i11);
                throw new IndexOutOfBoundsException(stringBuffer2.toString());
            } else if (i10 <= i11) {
                this.parent = abstractLinkedList;
                this.offset = i10;
                this.size = i11 - i10;
                this.expectedModCount = abstractLinkedList.modCount;
            } else {
                StringBuffer stringBuffer3 = new StringBuffer();
                stringBuffer3.append("fromIndex(");
                stringBuffer3.append(i10);
                stringBuffer3.append(") > toIndex(");
                stringBuffer3.append(i11);
                stringBuffer3.append(")");
                throw new IllegalArgumentException(stringBuffer3.toString());
            }
        }

        public void add(int i10, Object obj) {
            rangeCheck(i10, this.size + 1);
            checkModCount();
            this.parent.add(i10 + this.offset, obj);
            this.expectedModCount = this.parent.modCount;
            this.size++;
            this.modCount++;
        }

        public boolean addAll(Collection collection) {
            return addAll(this.size, collection);
        }

        /* access modifiers changed from: protected */
        public void checkModCount() {
            if (this.parent.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }

        public void clear() {
            checkModCount();
            Iterator it = iterator();
            while (it.hasNext()) {
                it.next();
                it.remove();
            }
        }

        public Object get(int i10) {
            rangeCheck(i10, this.size);
            checkModCount();
            return this.parent.get(i10 + this.offset);
        }

        public Iterator iterator() {
            checkModCount();
            return this.parent.createSubListIterator(this);
        }

        public ListIterator listIterator(int i10) {
            rangeCheck(i10, this.size + 1);
            checkModCount();
            return this.parent.createSubListListIterator(this, i10);
        }

        /* access modifiers changed from: protected */
        public void rangeCheck(int i10, int i11) {
            if (i10 < 0 || i10 >= i11) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("Index '");
                stringBuffer.append(i10);
                stringBuffer.append("' out of bounds for size '");
                stringBuffer.append(this.size);
                stringBuffer.append("'");
                throw new IndexOutOfBoundsException(stringBuffer.toString());
            }
        }

        public Object remove(int i10) {
            rangeCheck(i10, this.size);
            checkModCount();
            Object remove = this.parent.remove(i10 + this.offset);
            this.expectedModCount = this.parent.modCount;
            this.size--;
            this.modCount++;
            return remove;
        }

        public Object set(int i10, Object obj) {
            rangeCheck(i10, this.size);
            checkModCount();
            return this.parent.set(i10 + this.offset, obj);
        }

        public int size() {
            checkModCount();
            return this.size;
        }

        public List subList(int i10, int i11) {
            AbstractLinkedList abstractLinkedList = this.parent;
            int i12 = this.offset;
            return new LinkedSubList(abstractLinkedList, i10 + i12, i11 + i12);
        }

        public boolean addAll(int i10, Collection collection) {
            rangeCheck(i10, this.size + 1);
            int size2 = collection.size();
            if (size2 == 0) {
                return false;
            }
            checkModCount();
            this.parent.addAll(this.offset + i10, collection);
            this.expectedModCount = this.parent.modCount;
            this.size += size2;
            this.modCount++;
            return true;
        }
    }

    protected static class LinkedSubListIterator extends LinkedListIterator {
        protected final LinkedSubList sub;

        protected LinkedSubListIterator(LinkedSubList linkedSubList, int i10) {
            super(linkedSubList.parent, i10 + linkedSubList.offset);
            this.sub = linkedSubList;
        }

        public void add(Object obj) {
            super.add(obj);
            LinkedSubList linkedSubList = this.sub;
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
            LinkedSubList linkedSubList = this.sub;
            linkedSubList.expectedModCount = this.parent.modCount;
            linkedSubList.size--;
        }
    }

    protected AbstractLinkedList() {
    }

    public boolean add(Object obj) {
        addLast(obj);
        return true;
    }

    public boolean addAll(Collection collection) {
        return addAll(this.size, collection);
    }

    public boolean addFirst(Object obj) {
        addNodeAfter(this.header, obj);
        return true;
    }

    public boolean addLast(Object obj) {
        addNodeBefore(this.header, obj);
        return true;
    }

    /* access modifiers changed from: protected */
    public void addNode(Node node, Node node2) {
        node.next = node2;
        node.previous = node2.previous;
        node2.previous.next = node;
        node2.previous = node;
        this.size++;
        this.modCount++;
    }

    /* access modifiers changed from: protected */
    public void addNodeAfter(Node node, Object obj) {
        addNode(createNode(obj), node.next);
    }

    /* access modifiers changed from: protected */
    public void addNodeBefore(Node node, Object obj) {
        addNode(createNode(obj), node);
    }

    public void clear() {
        removeAllNodes();
    }

    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public boolean containsAll(Collection collection) {
        for (Object contains : collection) {
            if (!contains(contains)) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public Node createHeaderNode() {
        return new Node();
    }

    /* access modifiers changed from: protected */
    public Node createNode(Object obj) {
        return new Node(obj);
    }

    /* access modifiers changed from: protected */
    public Iterator createSubListIterator(LinkedSubList linkedSubList) {
        return createSubListListIterator(linkedSubList, 0);
    }

    /* access modifiers changed from: protected */
    public ListIterator createSubListListIterator(LinkedSubList linkedSubList, int i10) {
        return new LinkedSubListIterator(linkedSubList, i10);
    }

    /* access modifiers changed from: protected */
    public void doReadObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        init();
        int readInt = objectInputStream.readInt();
        for (int i10 = 0; i10 < readInt; i10++) {
            add(objectInputStream.readObject());
        }
    }

    /* access modifiers changed from: protected */
    public void doWriteObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(size());
        Iterator it = iterator();
        while (it.hasNext()) {
            objectOutputStream.writeObject(it.next());
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        List list = (List) obj;
        if (list.size() != size()) {
            return false;
        }
        ListIterator listIterator = listIterator();
        ListIterator listIterator2 = list.listIterator();
        while (listIterator.hasNext() && listIterator2.hasNext()) {
            Object next = listIterator.next();
            Object next2 = listIterator2.next();
            if (next == null) {
                if (next2 == null) {
                }
            } else if (!next.equals(next2)) {
            }
            return false;
        }
        if (listIterator.hasNext() || listIterator2.hasNext()) {
            return false;
        }
        return true;
    }

    public Object get(int i10) {
        return getNode(i10, false).getValue();
    }

    public Object getFirst() {
        Node node = this.header;
        Node node2 = node.next;
        if (node2 != node) {
            return node2.getValue();
        }
        throw new NoSuchElementException();
    }

    public Object getLast() {
        Node node = this.header;
        Node node2 = node.previous;
        if (node2 != node) {
            return node2.getValue();
        }
        throw new NoSuchElementException();
    }

    /* access modifiers changed from: protected */
    public Node getNode(int i10, boolean z10) throws IndexOutOfBoundsException {
        if (i10 < 0) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Couldn't get the node: index (");
            stringBuffer.append(i10);
            stringBuffer.append(") less than zero.");
            throw new IndexOutOfBoundsException(stringBuffer.toString());
        } else if (z10 || i10 != this.size) {
            int i11 = this.size;
            if (i10 > i11) {
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append("Couldn't get the node: index (");
                stringBuffer2.append(i10);
                stringBuffer2.append(") greater than the size of the ");
                stringBuffer2.append("list (");
                stringBuffer2.append(this.size);
                stringBuffer2.append(").");
                throw new IndexOutOfBoundsException(stringBuffer2.toString());
            } else if (i10 < i11 / 2) {
                Node node = this.header.next;
                for (int i12 = 0; i12 < i10; i12++) {
                    node = node.next;
                }
                return node;
            } else {
                Node node2 = this.header;
                while (i11 > i10) {
                    node2 = node2.previous;
                    i11--;
                }
                return node2;
            }
        } else {
            StringBuffer stringBuffer3 = new StringBuffer();
            stringBuffer3.append("Couldn't get the node: index (");
            stringBuffer3.append(i10);
            stringBuffer3.append(") is the size of the list.");
            throw new IndexOutOfBoundsException(stringBuffer3.toString());
        }
    }

    public int hashCode() {
        int i10;
        Iterator it = iterator();
        int i11 = 1;
        while (it.hasNext()) {
            Object next = it.next();
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

    public int indexOf(Object obj) {
        int i10 = 0;
        for (Node node = this.header.next; node != this.header; node = node.next) {
            if (isEqualValue(node.getValue(), obj)) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    /* access modifiers changed from: protected */
    public void init() {
        this.header = createHeaderNode();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    /* access modifiers changed from: protected */
    public boolean isEqualValue(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public Iterator iterator() {
        return listIterator();
    }

    public int lastIndexOf(Object obj) {
        int i10 = this.size - 1;
        Node node = this.header;
        while (true) {
            node = node.previous;
            if (node == this.header) {
                return -1;
            }
            if (isEqualValue(node.getValue(), obj)) {
                return i10;
            }
            i10--;
        }
    }

    public ListIterator listIterator() {
        return new LinkedListIterator(this, 0);
    }

    public Object remove(int i10) {
        Node node = getNode(i10, false);
        Object value = node.getValue();
        removeNode(node);
        return value;
    }

    public boolean removeAll(Collection collection) {
        Iterator it = iterator();
        boolean z10 = false;
        while (it.hasNext()) {
            if (collection.contains(it.next())) {
                it.remove();
                z10 = true;
            }
        }
        return z10;
    }

    /* access modifiers changed from: protected */
    public void removeAllNodes() {
        Node node = this.header;
        node.next = node;
        node.previous = node;
        this.size = 0;
        this.modCount++;
    }

    public Object removeFirst() {
        Node node = this.header;
        Node node2 = node.next;
        if (node2 != node) {
            Object value = node2.getValue();
            removeNode(node2);
            return value;
        }
        throw new NoSuchElementException();
    }

    public Object removeLast() {
        Node node = this.header;
        Node node2 = node.previous;
        if (node2 != node) {
            Object value = node2.getValue();
            removeNode(node2);
            return value;
        }
        throw new NoSuchElementException();
    }

    /* access modifiers changed from: protected */
    public void removeNode(Node node) {
        Node node2 = node.previous;
        node2.next = node.next;
        node.next.previous = node2;
        this.size--;
        this.modCount++;
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
        Node node = getNode(i10, false);
        Object value = node.getValue();
        updateNode(node, obj);
        return value;
    }

    public int size() {
        return this.size;
    }

    public List subList(int i10, int i11) {
        return new LinkedSubList(this, i10, i11);
    }

    public Object[] toArray() {
        return toArray(new Object[this.size]);
    }

    public String toString() {
        if (size() == 0) {
            return Field.TOKEN_INDEXED;
        }
        StringBuffer stringBuffer = new StringBuffer(size() * 16);
        stringBuffer.append("[");
        Iterator it = iterator();
        boolean hasNext = it.hasNext();
        while (hasNext) {
            Object next = it.next();
            if (next == this) {
                next = "(this Collection)";
            }
            stringBuffer.append(next);
            hasNext = it.hasNext();
            if (hasNext) {
                stringBuffer.append(", ");
            }
        }
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    /* access modifiers changed from: protected */
    public void updateNode(Node node, Object obj) {
        node.setValue(obj);
    }

    protected AbstractLinkedList(Collection collection) {
        init();
        addAll(collection);
    }

    public void add(int i10, Object obj) {
        addNodeBefore(getNode(i10, true), obj);
    }

    public boolean addAll(int i10, Collection collection) {
        Node node = getNode(i10, true);
        for (Object addNodeBefore : collection) {
            addNodeBefore(node, addNodeBefore);
        }
        return true;
    }

    public ListIterator listIterator(int i10) {
        return new LinkedListIterator(this, i10);
    }

    public Object[] toArray(Object[] objArr) {
        if (objArr.length < this.size) {
            objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), this.size);
        }
        int i10 = 0;
        Node node = this.header.next;
        while (node != this.header) {
            objArr[i10] = node.getValue();
            node = node.next;
            i10++;
        }
        int length = objArr.length;
        int i11 = this.size;
        if (length > i11) {
            objArr[i11] = null;
        }
        return objArr;
    }

    protected static class Node {
        protected Node next;
        protected Node previous;
        protected Object value;

        protected Node() {
            this.previous = this;
            this.next = this;
        }

        /* access modifiers changed from: protected */
        public Node getNextNode() {
            return this.next;
        }

        /* access modifiers changed from: protected */
        public Node getPreviousNode() {
            return this.previous;
        }

        /* access modifiers changed from: protected */
        public Object getValue() {
            return this.value;
        }

        /* access modifiers changed from: protected */
        public void setNextNode(Node node) {
            this.next = node;
        }

        /* access modifiers changed from: protected */
        public void setPreviousNode(Node node) {
            this.previous = node;
        }

        /* access modifiers changed from: protected */
        public void setValue(Object obj) {
            this.value = obj;
        }

        protected Node(Object obj) {
            this.value = obj;
        }

        protected Node(Node node, Node node2, Object obj) {
            this.previous = node;
            this.next = node2;
            this.value = obj;
        }
    }

    public boolean remove(Object obj) {
        Node node = this.header;
        do {
            node = node.next;
            if (node == this.header) {
                return false;
            }
        } while (!isEqualValue(node.getValue(), obj));
        removeNode(node);
        return true;
    }
}
