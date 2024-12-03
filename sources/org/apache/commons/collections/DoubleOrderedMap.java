package org.apache.commons.collections;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

public final class DoubleOrderedMap extends AbstractMap {
    private static final int FIRST_INDEX = 0;
    private static final int KEY = 0;
    private static final int NUMBER_OF_INDICES = 2;
    private static final int SUM_OF_INDICES = 1;
    private static final int VALUE = 1;
    private static final String[] dataName = {SDKConstants.PARAM_KEY, "value"};
    private Collection[] collectionOfValues = {null, null};
    /* access modifiers changed from: private */
    public int modifications = 0;
    /* access modifiers changed from: private */
    public int nodeCount = 0;
    /* access modifiers changed from: private */
    public Node[] rootNode = {null, null};
    private Set[] setOfEntries = {null, null};
    private Set[] setOfKeys = {null, null};

    private abstract class DoubleOrderedMapIterator implements Iterator {
        private int expectedModifications;
        private int iteratorType;
        protected Node lastReturnedNode = null;
        private Node nextNode;

        DoubleOrderedMapIterator(int i10) {
            this.iteratorType = i10;
            this.expectedModifications = DoubleOrderedMap.this.modifications;
            Node[] access$2300 = DoubleOrderedMap.this.rootNode;
            int i11 = this.iteratorType;
            this.nextNode = DoubleOrderedMap.leastNode(access$2300[i11], i11);
        }

        /* access modifiers changed from: protected */
        public abstract Object doGetNext();

        public final boolean hasNext() {
            return this.nextNode != null;
        }

        public final Object next() throws NoSuchElementException, ConcurrentModificationException {
            if (this.nextNode == null) {
                throw new NoSuchElementException();
            } else if (DoubleOrderedMap.this.modifications == this.expectedModifications) {
                Node node = this.nextNode;
                this.lastReturnedNode = node;
                this.nextNode = DoubleOrderedMap.this.nextGreater(node, this.iteratorType);
                return doGetNext();
            } else {
                throw new ConcurrentModificationException();
            }
        }

        public final void remove() throws IllegalStateException, ConcurrentModificationException {
            if (this.lastReturnedNode == null) {
                throw new IllegalStateException();
            } else if (DoubleOrderedMap.this.modifications == this.expectedModifications) {
                DoubleOrderedMap.this.doRedBlackDelete(this.lastReturnedNode);
                this.expectedModifications++;
                this.lastReturnedNode = null;
            } else {
                throw new ConcurrentModificationException();
            }
        }
    }

    private static final class Node implements Map.Entry, KeyValue {
        private boolean[] blackColor = {true, true};
        private boolean calculatedHashCode = false;
        private Comparable[] data;
        private int hashcodeValue;
        private Node[] leftNode = {null, null};
        private Node[] parentNode = {null, null};
        private Node[] rightNode = {null, null};

        Node(Comparable comparable, Comparable comparable2) {
            this.data = new Comparable[]{comparable, comparable2};
        }

        /* access modifiers changed from: private */
        public void copyColor(Node node, int i10) {
            this.blackColor[i10] = node.blackColor[i10];
        }

        /* access modifiers changed from: private */
        public Comparable getData(int i10) {
            return this.data[i10];
        }

        /* access modifiers changed from: private */
        public Node getLeft(int i10) {
            return this.leftNode[i10];
        }

        /* access modifiers changed from: private */
        public Node getParent(int i10) {
            return this.parentNode[i10];
        }

        /* access modifiers changed from: private */
        public Node getRight(int i10) {
            return this.rightNode[i10];
        }

        /* access modifiers changed from: private */
        public boolean isBlack(int i10) {
            return this.blackColor[i10];
        }

        /* access modifiers changed from: private */
        public boolean isRed(int i10) {
            return !this.blackColor[i10];
        }

        /* access modifiers changed from: private */
        public void setBlack(int i10) {
            this.blackColor[i10] = true;
        }

        /* access modifiers changed from: private */
        public void setLeft(Node node, int i10) {
            this.leftNode[i10] = node;
        }

        /* access modifiers changed from: private */
        public void setParent(Node node, int i10) {
            this.parentNode[i10] = node;
        }

        /* access modifiers changed from: private */
        public void setRed(int i10) {
            this.blackColor[i10] = false;
        }

        /* access modifiers changed from: private */
        public void setRight(Node node, int i10) {
            this.rightNode[i10] = node;
        }

        /* access modifiers changed from: private */
        public void swapColors(Node node, int i10) {
            boolean[] zArr = this.blackColor;
            boolean z10 = zArr[i10];
            boolean[] zArr2 = node.blackColor;
            boolean z11 = z10 ^ zArr2[i10];
            zArr[i10] = z11;
            boolean z12 = z11 ^ zArr2[i10];
            zArr2[i10] = z12;
            zArr[i10] = zArr[i10] ^ z12;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            if (!this.data[0].equals(entry.getKey()) || !this.data[1].equals(entry.getValue())) {
                return false;
            }
            return true;
        }

        public Object getKey() {
            return this.data[0];
        }

        public Object getValue() {
            return this.data[1];
        }

        public int hashCode() {
            if (!this.calculatedHashCode) {
                this.hashcodeValue = this.data[0].hashCode() ^ this.data[1].hashCode();
                this.calculatedHashCode = true;
            }
            return this.hashcodeValue;
        }

        public Object setValue(Object obj) throws UnsupportedOperationException {
            throw new UnsupportedOperationException("Map.Entry.setValue is not supported");
        }
    }

    public DoubleOrderedMap() {
    }

    private static void checkKey(Object obj) {
        checkNonNullComparable(obj, 0);
    }

    private static void checkKeyAndValue(Object obj, Object obj2) {
        checkKey(obj);
        checkValue(obj2);
    }

    private static void checkNonNullComparable(Object obj, int i10) {
        if (obj == null) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(dataName[i10]);
            stringBuffer.append(" cannot be null");
            throw new NullPointerException(stringBuffer.toString());
        } else if (!(obj instanceof Comparable)) {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append(dataName[i10]);
            stringBuffer2.append(" must be Comparable");
            throw new ClassCastException(stringBuffer2.toString());
        }
    }

    private static void checkValue(Object obj) {
        checkNonNullComparable(obj, 1);
    }

    private static int compare(Comparable comparable, Comparable comparable2) {
        return comparable.compareTo(comparable2);
    }

    private static void copyColor(Node node, Node node2, int i10) {
        if (node2 == null) {
            return;
        }
        if (node == null) {
            node2.setBlack(i10);
        } else {
            node2.copyColor(node, i10);
        }
    }

    private Object doGet(Comparable comparable, int i10) {
        checkNonNullComparable(comparable, i10);
        Node lookup = lookup(comparable, i10);
        if (lookup == null) {
            return null;
        }
        return lookup.getData(oppositeIndex(i10));
    }

    /* access modifiers changed from: private */
    public void doRedBlackDelete(Node node) {
        Node node2;
        for (int i10 = 0; i10 < 2; i10++) {
            if (!(node.getLeft(i10) == null || node.getRight(i10) == null)) {
                swapPosition(nextGreater(node, i10), node, i10);
            }
            if (node.getLeft(i10) != null) {
                node2 = node.getLeft(i10);
            } else {
                node2 = node.getRight(i10);
            }
            if (node2 != null) {
                node2.setParent(node.getParent(i10), i10);
                if (node.getParent(i10) == null) {
                    this.rootNode[i10] = node2;
                } else if (node == node.getParent(i10).getLeft(i10)) {
                    node.getParent(i10).setLeft(node2, i10);
                } else {
                    node.getParent(i10).setRight(node2, i10);
                }
                node.setLeft((Node) null, i10);
                node.setRight((Node) null, i10);
                node.setParent((Node) null, i10);
                if (isBlack(node, i10)) {
                    doRedBlackDeleteFixup(node2, i10);
                }
            } else if (node.getParent(i10) == null) {
                this.rootNode[i10] = null;
            } else {
                if (isBlack(node, i10)) {
                    doRedBlackDeleteFixup(node, i10);
                }
                if (node.getParent(i10) != null) {
                    if (node == node.getParent(i10).getLeft(i10)) {
                        node.getParent(i10).setLeft((Node) null, i10);
                    } else {
                        node.getParent(i10).setRight((Node) null, i10);
                    }
                    node.setParent((Node) null, i10);
                }
            }
        }
        shrink();
    }

    private void doRedBlackDeleteFixup(Node node, int i10) {
        while (node != this.rootNode[i10] && isBlack(node, i10)) {
            if (isLeftChild(node, i10)) {
                Node rightChild = getRightChild(getParent(node, i10), i10);
                if (isRed(rightChild, i10)) {
                    makeBlack(rightChild, i10);
                    makeRed(getParent(node, i10), i10);
                    rotateLeft(getParent(node, i10), i10);
                    rightChild = getRightChild(getParent(node, i10), i10);
                }
                if (!isBlack(getLeftChild(rightChild, i10), i10) || !isBlack(getRightChild(rightChild, i10), i10)) {
                    if (isBlack(getRightChild(rightChild, i10), i10)) {
                        makeBlack(getLeftChild(rightChild, i10), i10);
                        makeRed(rightChild, i10);
                        rotateRight(rightChild, i10);
                        rightChild = getRightChild(getParent(node, i10), i10);
                    }
                    copyColor(getParent(node, i10), rightChild, i10);
                    makeBlack(getParent(node, i10), i10);
                    makeBlack(getRightChild(rightChild, i10), i10);
                    rotateLeft(getParent(node, i10), i10);
                    node = this.rootNode[i10];
                } else {
                    makeRed(rightChild, i10);
                    node = getParent(node, i10);
                }
            } else {
                Node leftChild = getLeftChild(getParent(node, i10), i10);
                if (isRed(leftChild, i10)) {
                    makeBlack(leftChild, i10);
                    makeRed(getParent(node, i10), i10);
                    rotateRight(getParent(node, i10), i10);
                    leftChild = getLeftChild(getParent(node, i10), i10);
                }
                if (!isBlack(getRightChild(leftChild, i10), i10) || !isBlack(getLeftChild(leftChild, i10), i10)) {
                    if (isBlack(getLeftChild(leftChild, i10), i10)) {
                        makeBlack(getRightChild(leftChild, i10), i10);
                        makeRed(leftChild, i10);
                        rotateLeft(leftChild, i10);
                        leftChild = getLeftChild(getParent(node, i10), i10);
                    }
                    copyColor(getParent(node, i10), leftChild, i10);
                    makeBlack(getParent(node, i10), i10);
                    makeBlack(getLeftChild(leftChild, i10), i10);
                    rotateRight(getParent(node, i10), i10);
                    node = this.rootNode[i10];
                } else {
                    makeRed(leftChild, i10);
                    node = getParent(node, i10);
                }
            }
        }
        makeBlack(node, i10);
    }

    private void doRedBlackInsert(Node node, int i10) {
        makeRed(node, i10);
        while (node != null && node != this.rootNode[i10] && isRed(node.getParent(i10), i10)) {
            if (isLeftChild(getParent(node, i10), i10)) {
                Node rightChild = getRightChild(getGrandParent(node, i10), i10);
                if (isRed(rightChild, i10)) {
                    makeBlack(getParent(node, i10), i10);
                    makeBlack(rightChild, i10);
                    makeRed(getGrandParent(node, i10), i10);
                    node = getGrandParent(node, i10);
                } else {
                    if (isRightChild(node, i10)) {
                        node = getParent(node, i10);
                        rotateLeft(node, i10);
                    }
                    makeBlack(getParent(node, i10), i10);
                    makeRed(getGrandParent(node, i10), i10);
                    if (getGrandParent(node, i10) != null) {
                        rotateRight(getGrandParent(node, i10), i10);
                    }
                }
            } else {
                Node leftChild = getLeftChild(getGrandParent(node, i10), i10);
                if (isRed(leftChild, i10)) {
                    makeBlack(getParent(node, i10), i10);
                    makeBlack(leftChild, i10);
                    makeRed(getGrandParent(node, i10), i10);
                    node = getGrandParent(node, i10);
                } else {
                    if (isLeftChild(node, i10)) {
                        node = getParent(node, i10);
                        rotateRight(node, i10);
                    }
                    makeBlack(getParent(node, i10), i10);
                    makeRed(getGrandParent(node, i10), i10);
                    if (getGrandParent(node, i10) != null) {
                        rotateLeft(getGrandParent(node, i10), i10);
                    }
                }
            }
        }
        makeBlack(this.rootNode[i10], i10);
    }

    private Object doRemove(Comparable comparable, int i10) {
        Node lookup = lookup(comparable, i10);
        if (lookup == null) {
            return null;
        }
        Comparable access$200 = lookup.getData(oppositeIndex(i10));
        doRedBlackDelete(lookup);
        return access$200;
    }

    private static Node getGrandParent(Node node, int i10) {
        return getParent(getParent(node, i10), i10);
    }

    private static Node getLeftChild(Node node, int i10) {
        if (node == null) {
            return null;
        }
        return node.getLeft(i10);
    }

    private static Node getParent(Node node, int i10) {
        if (node == null) {
            return null;
        }
        return node.getParent(i10);
    }

    private static Node getRightChild(Node node, int i10) {
        if (node == null) {
            return null;
        }
        return node.getRight(i10);
    }

    private void grow() {
        modify();
        this.nodeCount++;
    }

    private void insertValue(Node node) throws IllegalArgumentException {
        Node node2 = this.rootNode[1];
        while (true) {
            int compare = compare(node.getData(1), node2.getData(1));
            if (compare == 0) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("Cannot store a duplicate value (\"");
                stringBuffer.append(node.getData(1));
                stringBuffer.append("\") in this Map");
                throw new IllegalArgumentException(stringBuffer.toString());
            } else if (compare < 0) {
                if (node2.getLeft(1) != null) {
                    node2 = node2.getLeft(1);
                } else {
                    node2.setLeft(node, 1);
                    node.setParent(node2, 1);
                    doRedBlackInsert(node, 1);
                    return;
                }
            } else if (node2.getRight(1) != null) {
                node2 = node2.getRight(1);
            } else {
                node2.setRight(node, 1);
                node.setParent(node2, 1);
                doRedBlackInsert(node, 1);
                return;
            }
        }
    }

    private static boolean isBlack(Node node, int i10) {
        if (node == null) {
            return true;
        }
        return node.isBlack(i10);
    }

    private static boolean isLeftChild(Node node, int i10) {
        return node == null || (node.getParent(i10) != null && node == node.getParent(i10).getLeft(i10));
    }

    private static boolean isRed(Node node, int i10) {
        if (node == null) {
            return false;
        }
        return node.isRed(i10);
    }

    private static boolean isRightChild(Node node, int i10) {
        return node == null || (node.getParent(i10) != null && node == node.getParent(i10).getRight(i10));
    }

    /* access modifiers changed from: private */
    public static Node leastNode(Node node, int i10) {
        if (node != null) {
            while (node.getLeft(i10) != null) {
                node = node.getLeft(i10);
            }
        }
        return node;
    }

    /* access modifiers changed from: private */
    public Node lookup(Comparable comparable, int i10) {
        Node node = this.rootNode[i10];
        while (node != null) {
            int compare = compare(comparable, node.getData(i10));
            if (compare == 0) {
                return node;
            }
            if (compare < 0) {
                node = node.getLeft(i10);
            } else {
                node = node.getRight(i10);
            }
        }
        return null;
    }

    private static void makeBlack(Node node, int i10) {
        if (node != null) {
            node.setBlack(i10);
        }
    }

    private static void makeRed(Node node, int i10) {
        if (node != null) {
            node.setRed(i10);
        }
    }

    private void modify() {
        this.modifications++;
    }

    /* access modifiers changed from: private */
    public Node nextGreater(Node node, int i10) {
        if (node == null) {
            return null;
        }
        if (node.getRight(i10) != null) {
            return leastNode(node.getRight(i10), i10);
        }
        Node access$900 = node.getParent(i10);
        while (true) {
            Node node2 = access$900;
            Node node3 = node;
            node = node2;
            if (node == null || node3 != node.getRight(i10)) {
                return node;
            }
            access$900 = node.getParent(i10);
        }
    }

    private int oppositeIndex(int i10) {
        return 1 - i10;
    }

    private void rotateLeft(Node node, int i10) {
        Node access$800 = node.getRight(i10);
        node.setRight(access$800.getLeft(i10), i10);
        if (access$800.getLeft(i10) != null) {
            access$800.getLeft(i10).setParent(node, i10);
        }
        access$800.setParent(node.getParent(i10), i10);
        if (node.getParent(i10) == null) {
            this.rootNode[i10] = access$800;
        } else if (node.getParent(i10).getLeft(i10) == node) {
            node.getParent(i10).setLeft(access$800, i10);
        } else {
            node.getParent(i10).setRight(access$800, i10);
        }
        access$800.setLeft(node, i10);
        node.setParent(access$800, i10);
    }

    private void rotateRight(Node node, int i10) {
        Node access$700 = node.getLeft(i10);
        node.setLeft(access$700.getRight(i10), i10);
        if (access$700.getRight(i10) != null) {
            access$700.getRight(i10).setParent(node, i10);
        }
        access$700.setParent(node.getParent(i10), i10);
        if (node.getParent(i10) == null) {
            this.rootNode[i10] = access$700;
        } else if (node.getParent(i10).getRight(i10) == node) {
            node.getParent(i10).setRight(access$700, i10);
        } else {
            node.getParent(i10).setLeft(access$700, i10);
        }
        access$700.setRight(node, i10);
        node.setParent(access$700, i10);
    }

    private void shrink() {
        modify();
        this.nodeCount--;
    }

    private void swapPosition(Node node, Node node2, int i10) {
        boolean z10;
        Node access$900 = node.getParent(i10);
        Node access$700 = node.getLeft(i10);
        Node access$800 = node.getRight(i10);
        Node access$9002 = node2.getParent(i10);
        Node access$7002 = node2.getLeft(i10);
        Node access$8002 = node2.getRight(i10);
        boolean z11 = true;
        if (node.getParent(i10) == null || node != node.getParent(i10).getLeft(i10)) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (node2.getParent(i10) == null || node2 != node2.getParent(i10).getLeft(i10)) {
            z11 = false;
        }
        if (node == access$9002) {
            node.setParent(node2, i10);
            if (z11) {
                node2.setLeft(node, i10);
                node2.setRight(access$800, i10);
            } else {
                node2.setRight(node, i10);
                node2.setLeft(access$700, i10);
            }
        } else {
            node.setParent(access$9002, i10);
            if (access$9002 != null) {
                if (z11) {
                    access$9002.setLeft(node, i10);
                } else {
                    access$9002.setRight(node, i10);
                }
            }
            node2.setLeft(access$700, i10);
            node2.setRight(access$800, i10);
        }
        if (node2 == access$900) {
            node2.setParent(node, i10);
            if (z10) {
                node.setLeft(node2, i10);
                node.setRight(access$8002, i10);
            } else {
                node.setRight(node2, i10);
                node.setLeft(access$7002, i10);
            }
        } else {
            node2.setParent(access$900, i10);
            if (access$900 != null) {
                if (z10) {
                    access$900.setLeft(node2, i10);
                } else {
                    access$900.setRight(node2, i10);
                }
            }
            node.setLeft(access$7002, i10);
            node.setRight(access$8002, i10);
        }
        if (node.getLeft(i10) != null) {
            node.getLeft(i10).setParent(node, i10);
        }
        if (node.getRight(i10) != null) {
            node.getRight(i10).setParent(node, i10);
        }
        if (node2.getLeft(i10) != null) {
            node2.getLeft(i10).setParent(node2, i10);
        }
        if (node2.getRight(i10) != null) {
            node2.getRight(i10).setParent(node2, i10);
        }
        node.swapColors(node2, i10);
        Node[] nodeArr = this.rootNode;
        Node node3 = nodeArr[i10];
        if (node3 == node) {
            nodeArr[i10] = node2;
        } else if (node3 == node2) {
            nodeArr[i10] = node;
        }
    }

    public void clear() {
        modify();
        this.nodeCount = 0;
        Node[] nodeArr = this.rootNode;
        nodeArr[0] = null;
        nodeArr[1] = null;
    }

    public boolean containsKey(Object obj) throws ClassCastException, NullPointerException {
        checkKey(obj);
        if (lookup((Comparable) obj, 0) != null) {
            return true;
        }
        return false;
    }

    public boolean containsValue(Object obj) {
        checkValue(obj);
        if (lookup((Comparable) obj, 1) != null) {
            return true;
        }
        return false;
    }

    public Set entrySet() {
        Set[] setArr = this.setOfEntries;
        if (setArr[0] == null) {
            setArr[0] = new AbstractSet() {
                public void clear() {
                    DoubleOrderedMap.this.clear();
                }

                public boolean contains(Object obj) {
                    if (!(obj instanceof Map.Entry)) {
                        return false;
                    }
                    Map.Entry entry = (Map.Entry) obj;
                    Object value = entry.getValue();
                    Node access$100 = DoubleOrderedMap.this.lookup((Comparable) entry.getKey(), 0);
                    if (access$100 == null || !access$100.getData(1).equals(value)) {
                        return false;
                    }
                    return true;
                }

                public Iterator iterator() {
                    return new DoubleOrderedMapIterator(this, 0) {
                        private final /* synthetic */ AnonymousClass6 this$1;

                        {
                            this.this$1 = r2;
                        }

                        /* access modifiers changed from: protected */
                        public Object doGetNext() {
                            return this.lastReturnedNode;
                        }
                    };
                }

                public boolean remove(Object obj) {
                    if (!(obj instanceof Map.Entry)) {
                        return false;
                    }
                    Map.Entry entry = (Map.Entry) obj;
                    Object value = entry.getValue();
                    Node access$100 = DoubleOrderedMap.this.lookup((Comparable) entry.getKey(), 0);
                    if (access$100 == null || !access$100.getData(1).equals(value)) {
                        return false;
                    }
                    DoubleOrderedMap.this.doRedBlackDelete(access$100);
                    return true;
                }

                public int size() {
                    return DoubleOrderedMap.this.size();
                }
            };
        }
        return this.setOfEntries[0];
    }

    public Set entrySetByValue() {
        Set[] setArr = this.setOfEntries;
        if (setArr[1] == null) {
            setArr[1] = new AbstractSet() {
                public void clear() {
                    DoubleOrderedMap.this.clear();
                }

                public boolean contains(Object obj) {
                    if (!(obj instanceof Map.Entry)) {
                        return false;
                    }
                    Map.Entry entry = (Map.Entry) obj;
                    Object key = entry.getKey();
                    Node access$100 = DoubleOrderedMap.this.lookup((Comparable) entry.getValue(), 1);
                    if (access$100 == null || !access$100.getData(0).equals(key)) {
                        return false;
                    }
                    return true;
                }

                public Iterator iterator() {
                    return new DoubleOrderedMapIterator(this, 1) {
                        private final /* synthetic */ AnonymousClass1 this$1;

                        {
                            this.this$1 = r2;
                        }

                        /* access modifiers changed from: protected */
                        public Object doGetNext() {
                            return this.lastReturnedNode;
                        }
                    };
                }

                public boolean remove(Object obj) {
                    if (!(obj instanceof Map.Entry)) {
                        return false;
                    }
                    Map.Entry entry = (Map.Entry) obj;
                    Object key = entry.getKey();
                    Node access$100 = DoubleOrderedMap.this.lookup((Comparable) entry.getValue(), 1);
                    if (access$100 == null || !access$100.getData(0).equals(key)) {
                        return false;
                    }
                    DoubleOrderedMap.this.doRedBlackDelete(access$100);
                    return true;
                }

                public int size() {
                    return DoubleOrderedMap.this.size();
                }
            };
        }
        return this.setOfEntries[1];
    }

    public Object get(Object obj) throws ClassCastException, NullPointerException {
        return doGet((Comparable) obj, 0);
    }

    public Object getKeyForValue(Object obj) throws ClassCastException, NullPointerException {
        return doGet((Comparable) obj, 1);
    }

    public Set keySet() {
        Set[] setArr = this.setOfKeys;
        if (setArr[0] == null) {
            setArr[0] = new AbstractSet() {
                public void clear() {
                    DoubleOrderedMap.this.clear();
                }

                public boolean contains(Object obj) {
                    return DoubleOrderedMap.this.containsKey(obj);
                }

                public Iterator iterator() {
                    return new DoubleOrderedMapIterator(this, 0) {
                        private final /* synthetic */ AnonymousClass4 this$1;

                        {
                            this.this$1 = r2;
                        }

                        /* access modifiers changed from: protected */
                        public Object doGetNext() {
                            return this.lastReturnedNode.getData(0);
                        }
                    };
                }

                public boolean remove(Object obj) {
                    int access$500 = DoubleOrderedMap.this.nodeCount;
                    DoubleOrderedMap.this.remove(obj);
                    if (DoubleOrderedMap.this.nodeCount != access$500) {
                        return true;
                    }
                    return false;
                }

                public int size() {
                    return DoubleOrderedMap.this.size();
                }
            };
        }
        return this.setOfKeys[0];
    }

    public Set keySetByValue() {
        Set[] setArr = this.setOfKeys;
        if (setArr[1] == null) {
            setArr[1] = new AbstractSet() {
                public void clear() {
                    DoubleOrderedMap.this.clear();
                }

                public boolean contains(Object obj) {
                    return DoubleOrderedMap.this.containsKey(obj);
                }

                public Iterator iterator() {
                    return new DoubleOrderedMapIterator(this, 1) {
                        private final /* synthetic */ AnonymousClass2 this$1;

                        {
                            this.this$1 = r2;
                        }

                        /* access modifiers changed from: protected */
                        public Object doGetNext() {
                            return this.lastReturnedNode.getData(0);
                        }
                    };
                }

                public boolean remove(Object obj) {
                    int access$500 = DoubleOrderedMap.this.nodeCount;
                    DoubleOrderedMap.this.remove(obj);
                    if (DoubleOrderedMap.this.nodeCount != access$500) {
                        return true;
                    }
                    return false;
                }

                public int size() {
                    return DoubleOrderedMap.this.size();
                }
            };
        }
        return this.setOfKeys[1];
    }

    public Object put(Object obj, Object obj2) throws ClassCastException, NullPointerException, IllegalArgumentException {
        checkKeyAndValue(obj, obj2);
        Node node = this.rootNode[0];
        if (node == null) {
            Node node2 = new Node((Comparable) obj, (Comparable) obj2);
            Node[] nodeArr = this.rootNode;
            nodeArr[0] = node2;
            nodeArr[1] = node2;
            grow();
            return null;
        }
        while (true) {
            Comparable comparable = (Comparable) obj;
            int compare = compare(comparable, node.getData(0));
            if (compare == 0) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("Cannot store a duplicate key (\"");
                stringBuffer.append(obj);
                stringBuffer.append("\") in this Map");
                throw new IllegalArgumentException(stringBuffer.toString());
            } else if (compare < 0) {
                if (node.getLeft(0) != null) {
                    node = node.getLeft(0);
                } else {
                    Node node3 = new Node(comparable, (Comparable) obj2);
                    insertValue(node3);
                    node.setLeft(node3, 0);
                    node3.setParent(node, 0);
                    doRedBlackInsert(node3, 0);
                    grow();
                    return null;
                }
            } else if (node.getRight(0) != null) {
                node = node.getRight(0);
            } else {
                Node node4 = new Node(comparable, (Comparable) obj2);
                insertValue(node4);
                node.setRight(node4, 0);
                node4.setParent(node, 0);
                doRedBlackInsert(node4, 0);
                grow();
                return null;
            }
        }
    }

    public Object remove(Object obj) {
        return doRemove((Comparable) obj, 0);
    }

    public Object removeValue(Object obj) {
        return doRemove((Comparable) obj, 1);
    }

    public int size() {
        return this.nodeCount;
    }

    public Collection values() {
        Collection[] collectionArr = this.collectionOfValues;
        if (collectionArr[0] == null) {
            collectionArr[0] = new AbstractCollection() {
                public void clear() {
                    DoubleOrderedMap.this.clear();
                }

                public boolean contains(Object obj) {
                    return DoubleOrderedMap.this.containsValue(obj);
                }

                public Iterator iterator() {
                    return new DoubleOrderedMapIterator(this, 0) {
                        private final /* synthetic */ AnonymousClass5 this$1;

                        {
                            this.this$1 = r2;
                        }

                        /* access modifiers changed from: protected */
                        public Object doGetNext() {
                            return this.lastReturnedNode.getData(1);
                        }
                    };
                }

                public boolean remove(Object obj) {
                    int access$500 = DoubleOrderedMap.this.nodeCount;
                    DoubleOrderedMap.this.removeValue(obj);
                    if (DoubleOrderedMap.this.nodeCount != access$500) {
                        return true;
                    }
                    return false;
                }

                public boolean removeAll(Collection collection) {
                    boolean z10 = false;
                    for (Object removeValue : collection) {
                        if (DoubleOrderedMap.this.removeValue(removeValue) != null) {
                            z10 = true;
                        }
                    }
                    return z10;
                }

                public int size() {
                    return DoubleOrderedMap.this.size();
                }
            };
        }
        return this.collectionOfValues[0];
    }

    public Collection valuesByValue() {
        Collection[] collectionArr = this.collectionOfValues;
        if (collectionArr[1] == null) {
            collectionArr[1] = new AbstractCollection() {
                public void clear() {
                    DoubleOrderedMap.this.clear();
                }

                public boolean contains(Object obj) {
                    return DoubleOrderedMap.this.containsValue(obj);
                }

                public Iterator iterator() {
                    return new DoubleOrderedMapIterator(this, 1) {
                        private final /* synthetic */ AnonymousClass3 this$1;

                        {
                            this.this$1 = r2;
                        }

                        /* access modifiers changed from: protected */
                        public Object doGetNext() {
                            return this.lastReturnedNode.getData(1);
                        }
                    };
                }

                public boolean remove(Object obj) {
                    int access$500 = DoubleOrderedMap.this.nodeCount;
                    DoubleOrderedMap.this.removeValue(obj);
                    if (DoubleOrderedMap.this.nodeCount != access$500) {
                        return true;
                    }
                    return false;
                }

                public boolean removeAll(Collection collection) {
                    boolean z10 = false;
                    for (Object removeValue : collection) {
                        if (DoubleOrderedMap.this.removeValue(removeValue) != null) {
                            z10 = true;
                        }
                    }
                    return z10;
                }

                public int size() {
                    return DoubleOrderedMap.this.size();
                }
            };
        }
        return this.collectionOfValues[1];
    }

    public DoubleOrderedMap(Map map) throws ClassCastException, NullPointerException, IllegalArgumentException {
        putAll(map);
    }
}
