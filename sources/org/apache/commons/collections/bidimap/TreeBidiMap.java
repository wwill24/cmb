package org.apache.commons.collections.bidimap;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;
import org.apache.commons.collections.BidiMap;
import org.apache.commons.collections.KeyValue;
import org.apache.commons.collections.MapIterator;
import org.apache.commons.collections.OrderedBidiMap;
import org.apache.commons.collections.OrderedIterator;
import org.apache.commons.collections.OrderedMapIterator;
import org.apache.commons.collections.iterators.EmptyOrderedMapIterator;
import org.apache.commons.collections.keyvalue.UnmodifiableMapEntry;

public class TreeBidiMap implements OrderedBidiMap {
    private static final int FIRST_INDEX = 0;
    private static final int INVERSEMAPENTRY = 3;
    private static final int KEY = 0;
    private static final int MAPENTRY = 2;
    private static final int NUMBER_OF_INDICES = 2;
    private static final int SUM_OF_INDICES = 1;
    private static final int VALUE = 1;
    private static final String[] dataName = {SDKConstants.PARAM_KEY, "value"};
    private Set entrySet;
    private Inverse inverse = null;
    private Set keySet;
    /* access modifiers changed from: private */
    public int modifications = 0;
    /* access modifiers changed from: private */
    public int nodeCount = 0;
    /* access modifiers changed from: private */
    public Node[] rootNode = new Node[2];
    private Set valuesSet;

    static class EntryView extends View {
        private final int oppositeType;

        EntryView(TreeBidiMap treeBidiMap, int i10, int i11) {
            super(treeBidiMap, i10, i11);
            this.oppositeType = TreeBidiMap.oppositeIndex(i10);
        }

        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object value = entry.getValue();
            Node access$1400 = this.main.lookup((Comparable) entry.getKey(), this.orderType);
            if (access$1400 == null || !access$1400.getData(this.oppositeType).equals(value)) {
                return false;
            }
            return true;
        }

        public boolean remove(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object value = entry.getValue();
            Node access$1400 = this.main.lookup((Comparable) entry.getKey(), this.orderType);
            if (access$1400 == null || !access$1400.getData(this.oppositeType).equals(value)) {
                return false;
            }
            this.main.doRedBlackDelete(access$1400);
            return true;
        }
    }

    static class Inverse implements OrderedBidiMap {
        private Set entrySet;
        private Set keySet;
        private final TreeBidiMap main;
        private Set valuesSet;

        Inverse(TreeBidiMap treeBidiMap) {
            this.main = treeBidiMap;
        }

        public void clear() {
            this.main.clear();
        }

        public boolean containsKey(Object obj) {
            return this.main.containsValue(obj);
        }

        public boolean containsValue(Object obj) {
            return this.main.containsKey(obj);
        }

        public Set entrySet() {
            Set set = this.entrySet;
            if (set == null) {
                return new EntryView(this.main, 1, 3);
            }
            return set;
        }

        public boolean equals(Object obj) {
            return this.main.doEquals(obj, 1);
        }

        public Object firstKey() {
            if (this.main.nodeCount != 0) {
                return TreeBidiMap.leastNode(this.main.rootNode[1], 1).getValue();
            }
            throw new NoSuchElementException("Map is empty");
        }

        public Object get(Object obj) {
            return this.main.getKey(obj);
        }

        public Object getKey(Object obj) {
            return this.main.get(obj);
        }

        public int hashCode() {
            return this.main.doHashCode(1);
        }

        public BidiMap inverseBidiMap() {
            return this.main;
        }

        public OrderedBidiMap inverseOrderedBidiMap() {
            return this.main;
        }

        public boolean isEmpty() {
            return this.main.isEmpty();
        }

        public Set keySet() {
            if (this.keySet == null) {
                this.keySet = new View(this.main, 1, 1);
            }
            return this.keySet;
        }

        public Object lastKey() {
            if (this.main.nodeCount != 0) {
                return TreeBidiMap.greatestNode(this.main.rootNode[1], 1).getValue();
            }
            throw new NoSuchElementException("Map is empty");
        }

        public MapIterator mapIterator() {
            if (isEmpty()) {
                return EmptyOrderedMapIterator.INSTANCE;
            }
            return new ViewMapIterator(this.main, 1);
        }

        public Object nextKey(Object obj) {
            TreeBidiMap.checkKey(obj);
            TreeBidiMap treeBidiMap = this.main;
            Node access$1900 = treeBidiMap.nextGreater(treeBidiMap.lookup((Comparable) obj, 1), 1);
            if (access$1900 == null) {
                return null;
            }
            return access$1900.getValue();
        }

        public OrderedMapIterator orderedMapIterator() {
            if (isEmpty()) {
                return EmptyOrderedMapIterator.INSTANCE;
            }
            return new ViewMapIterator(this.main, 1);
        }

        public Object previousKey(Object obj) {
            TreeBidiMap.checkKey(obj);
            TreeBidiMap treeBidiMap = this.main;
            Node access$2000 = treeBidiMap.nextSmaller(treeBidiMap.lookup((Comparable) obj, 1), 1);
            if (access$2000 == null) {
                return null;
            }
            return access$2000.getValue();
        }

        public Object put(Object obj, Object obj2) {
            return this.main.doPut((Comparable) obj2, (Comparable) obj, 1);
        }

        public void putAll(Map map) {
            for (Map.Entry entry : map.entrySet()) {
                put(entry.getKey(), entry.getValue());
            }
        }

        public Object remove(Object obj) {
            return this.main.removeValue(obj);
        }

        public Object removeValue(Object obj) {
            return this.main.remove(obj);
        }

        public int size() {
            return this.main.size();
        }

        public String toString() {
            return this.main.doToString(1);
        }

        public Collection values() {
            if (this.valuesSet == null) {
                this.valuesSet = new View(this.main, 1, 0);
            }
            return this.valuesSet;
        }
    }

    static class Node implements Map.Entry, KeyValue {
        private boolean[] blackColor = {true, true};
        private boolean calculatedHashCode = false;
        private Comparable[] data;
        private int hashcodeValue;
        private Node[] leftNode = new Node[2];
        private Node[] parentNode = new Node[2];
        private Node[] rightNode = new Node[2];

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
            if (obj == this) {
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

    static class View extends AbstractSet {
        protected final int dataType;
        protected final TreeBidiMap main;
        protected final int orderType;

        View(TreeBidiMap treeBidiMap, int i10, int i11) {
            this.main = treeBidiMap;
            this.orderType = i10;
            this.dataType = i11;
        }

        public void clear() {
            this.main.clear();
        }

        public boolean contains(Object obj) {
            TreeBidiMap.checkNonNullComparable(obj, this.dataType);
            if (this.main.lookup((Comparable) obj, this.dataType) != null) {
                return true;
            }
            return false;
        }

        public Iterator iterator() {
            return new ViewIterator(this.main, this.orderType, this.dataType);
        }

        public boolean remove(Object obj) {
            return this.main.doRemove((Comparable) obj, this.dataType) != null;
        }

        public int size() {
            return this.main.size();
        }
    }

    static class ViewIterator implements OrderedIterator {
        protected final int dataType;
        private int expectedModifications;
        protected Node lastReturnedNode = null;
        protected final TreeBidiMap main;
        protected Node nextNode;
        protected final int orderType;
        protected Node previousNode = null;

        ViewIterator(TreeBidiMap treeBidiMap, int i10, int i11) {
            this.main = treeBidiMap;
            this.orderType = i10;
            this.dataType = i11;
            this.expectedModifications = treeBidiMap.modifications;
            this.nextNode = TreeBidiMap.leastNode(treeBidiMap.rootNode[i10], i10);
        }

        /* access modifiers changed from: protected */
        public Object doGetData() {
            int i10 = this.dataType;
            if (i10 == 0) {
                return this.lastReturnedNode.getKey();
            }
            if (i10 == 1) {
                return this.lastReturnedNode.getValue();
            }
            if (i10 == 2) {
                return this.lastReturnedNode;
            }
            if (i10 != 3) {
                return null;
            }
            return new UnmodifiableMapEntry(this.lastReturnedNode.getValue(), this.lastReturnedNode.getKey());
        }

        public final boolean hasNext() {
            return this.nextNode != null;
        }

        public boolean hasPrevious() {
            return this.previousNode != null;
        }

        public final Object next() {
            if (this.nextNode == null) {
                throw new NoSuchElementException();
            } else if (this.main.modifications == this.expectedModifications) {
                Node node = this.nextNode;
                this.lastReturnedNode = node;
                this.previousNode = node;
                this.nextNode = this.main.nextGreater(node, this.orderType);
                return doGetData();
            } else {
                throw new ConcurrentModificationException();
            }
        }

        public Object previous() {
            if (this.previousNode == null) {
                throw new NoSuchElementException();
            } else if (this.main.modifications == this.expectedModifications) {
                Node node = this.lastReturnedNode;
                this.nextNode = node;
                if (node == null) {
                    this.nextNode = this.main.nextGreater(this.previousNode, this.orderType);
                }
                Node node2 = this.previousNode;
                this.lastReturnedNode = node2;
                this.previousNode = this.main.nextSmaller(node2, this.orderType);
                return doGetData();
            } else {
                throw new ConcurrentModificationException();
            }
        }

        public final void remove() {
            if (this.lastReturnedNode == null) {
                throw new IllegalStateException();
            } else if (this.main.modifications == this.expectedModifications) {
                this.main.doRedBlackDelete(this.lastReturnedNode);
                this.expectedModifications++;
                this.lastReturnedNode = null;
                Node node = this.nextNode;
                if (node == null) {
                    Node[] access$1700 = this.main.rootNode;
                    int i10 = this.orderType;
                    this.previousNode = TreeBidiMap.greatestNode(access$1700[i10], i10);
                    return;
                }
                this.previousNode = this.main.nextSmaller(node, this.orderType);
            } else {
                throw new ConcurrentModificationException();
            }
        }
    }

    static class ViewMapIterator extends ViewIterator implements OrderedMapIterator {
        private final int oppositeType = TreeBidiMap.oppositeIndex(this.dataType);

        ViewMapIterator(TreeBidiMap treeBidiMap, int i10) {
            super(treeBidiMap, i10, i10);
        }

        public Object getKey() {
            Node node = this.lastReturnedNode;
            if (node != null) {
                return node.getData(this.dataType);
            }
            throw new IllegalStateException("Iterator getKey() can only be called after next() and before remove()");
        }

        public Object getValue() {
            Node node = this.lastReturnedNode;
            if (node != null) {
                return node.getData(this.oppositeType);
            }
            throw new IllegalStateException("Iterator getValue() can only be called after next() and before remove()");
        }

        public Object setValue(Object obj) {
            throw new UnsupportedOperationException();
        }
    }

    public TreeBidiMap() {
    }

    /* access modifiers changed from: private */
    public static void checkKey(Object obj) {
        checkNonNullComparable(obj, 0);
    }

    private static void checkKeyAndValue(Object obj, Object obj2) {
        checkKey(obj);
        checkValue(obj2);
    }

    /* access modifiers changed from: private */
    public static void checkNonNullComparable(Object obj, int i10) {
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

    /* access modifiers changed from: private */
    public boolean doEquals(Object obj, int i10) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map)) {
            return false;
        }
        Map map = (Map) obj;
        if (map.size() != size()) {
            return false;
        }
        if (this.nodeCount > 0) {
            try {
                ViewMapIterator viewMapIterator = new ViewMapIterator(this, i10);
                while (viewMapIterator.hasNext()) {
                    if (!viewMapIterator.getValue().equals(map.get(viewMapIterator.next()))) {
                        return false;
                    }
                }
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return true;
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
    public int doHashCode(int i10) {
        int i11 = 0;
        if (this.nodeCount > 0) {
            ViewMapIterator viewMapIterator = new ViewMapIterator(this, i10);
            while (viewMapIterator.hasNext()) {
                i11 += viewMapIterator.next().hashCode() ^ viewMapIterator.getValue().hashCode();
            }
        }
        return i11;
    }

    /* access modifiers changed from: private */
    public Object doPut(Comparable comparable, Comparable comparable2, int i10) {
        Object obj;
        Node node;
        checkKeyAndValue(comparable, comparable2);
        if (i10 == 0) {
            obj = doGet(comparable, 0);
        } else {
            obj = doGet(comparable2, 1);
        }
        doRemove(comparable, 0);
        doRemove(comparable2, 1);
        Node node2 = this.rootNode[0];
        if (node2 == null) {
            Node node3 = new Node(comparable, comparable2);
            Node[] nodeArr = this.rootNode;
            nodeArr[0] = node3;
            nodeArr[1] = node3;
            grow();
        } else {
            while (true) {
                int compare = compare(comparable, node2.getData(0));
                if (compare != 0) {
                    if (compare >= 0) {
                        if (node2.getRight(0) == null) {
                            Node node4 = new Node(comparable, comparable2);
                            insertValue(node4);
                            node2.setRight(node4, 0);
                            node4.setParent(node2, 0);
                            doRedBlackInsert(node4, 0);
                            grow();
                            break;
                        }
                        node = node2.getRight(0);
                    } else if (node2.getLeft(0) == null) {
                        Node node5 = new Node(comparable, comparable2);
                        insertValue(node5);
                        node2.setLeft(node5, 0);
                        node5.setParent(node2, 0);
                        doRedBlackInsert(node5, 0);
                        grow();
                        break;
                    } else {
                        node = node2.getLeft(0);
                    }
                    node2 = node;
                } else {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("Cannot store a duplicate key (\"");
                    stringBuffer.append(comparable);
                    stringBuffer.append("\") in this Map");
                    throw new IllegalArgumentException(stringBuffer.toString());
                }
            }
        }
        return obj;
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

    /* access modifiers changed from: private */
    public Object doRemove(Comparable comparable, int i10) {
        Node lookup = lookup(comparable, i10);
        if (lookup == null) {
            return null;
        }
        Comparable access$000 = lookup.getData(oppositeIndex(i10));
        doRedBlackDelete(lookup);
        return access$000;
    }

    /* access modifiers changed from: private */
    public String doToString(int i10) {
        int i11 = this.nodeCount;
        if (i11 == 0) {
            return "{}";
        }
        StringBuffer stringBuffer = new StringBuffer(i11 * 32);
        stringBuffer.append('{');
        ViewMapIterator viewMapIterator = new ViewMapIterator(this, i10);
        boolean hasNext = viewMapIterator.hasNext();
        while (hasNext) {
            Object next = viewMapIterator.next();
            Object value = viewMapIterator.getValue();
            if (next == this) {
                next = "(this Map)";
            }
            stringBuffer.append(next);
            stringBuffer.append(SignatureVisitor.INSTANCEOF);
            if (value == this) {
                value = "(this Map)";
            }
            stringBuffer.append(value);
            hasNext = viewMapIterator.hasNext();
            if (hasNext) {
                stringBuffer.append(", ");
            }
        }
        stringBuffer.append('}');
        return stringBuffer.toString();
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

    /* access modifiers changed from: private */
    public static Node greatestNode(Node node, int i10) {
        if (node != null) {
            while (node.getRight(i10) != null) {
                node = node.getRight(i10);
            }
        }
        return node;
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
        Node access$600 = node.getParent(i10);
        while (true) {
            Node node2 = access$600;
            Node node3 = node;
            node = node2;
            if (node == null || node3 != node.getRight(i10)) {
                return node;
            }
            access$600 = node.getParent(i10);
        }
    }

    /* access modifiers changed from: private */
    public Node nextSmaller(Node node, int i10) {
        if (node == null) {
            return null;
        }
        if (node.getLeft(i10) != null) {
            return greatestNode(node.getLeft(i10), i10);
        }
        Node access$600 = node.getParent(i10);
        while (true) {
            Node node2 = access$600;
            Node node3 = node;
            node = node2;
            if (node == null || node3 != node.getLeft(i10)) {
                return node;
            }
            access$600 = node.getParent(i10);
        }
    }

    /* access modifiers changed from: private */
    public static int oppositeIndex(int i10) {
        return 1 - i10;
    }

    private void rotateLeft(Node node, int i10) {
        Node access$400 = node.getRight(i10);
        node.setRight(access$400.getLeft(i10), i10);
        if (access$400.getLeft(i10) != null) {
            access$400.getLeft(i10).setParent(node, i10);
        }
        access$400.setParent(node.getParent(i10), i10);
        if (node.getParent(i10) == null) {
            this.rootNode[i10] = access$400;
        } else if (node.getParent(i10).getLeft(i10) == node) {
            node.getParent(i10).setLeft(access$400, i10);
        } else {
            node.getParent(i10).setRight(access$400, i10);
        }
        access$400.setLeft(node, i10);
        node.setParent(access$400, i10);
    }

    private void rotateRight(Node node, int i10) {
        Node access$100 = node.getLeft(i10);
        node.setLeft(access$100.getRight(i10), i10);
        if (access$100.getRight(i10) != null) {
            access$100.getRight(i10).setParent(node, i10);
        }
        access$100.setParent(node.getParent(i10), i10);
        if (node.getParent(i10) == null) {
            this.rootNode[i10] = access$100;
        } else if (node.getParent(i10).getRight(i10) == node) {
            node.getParent(i10).setRight(access$100, i10);
        } else {
            node.getParent(i10).setLeft(access$100, i10);
        }
        access$100.setRight(node, i10);
        node.setParent(access$100, i10);
    }

    private void shrink() {
        modify();
        this.nodeCount--;
    }

    private void swapPosition(Node node, Node node2, int i10) {
        boolean z10;
        Node access$600 = node.getParent(i10);
        Node access$100 = node.getLeft(i10);
        Node access$400 = node.getRight(i10);
        Node access$6002 = node2.getParent(i10);
        Node access$1002 = node2.getLeft(i10);
        Node access$4002 = node2.getRight(i10);
        boolean z11 = true;
        if (node.getParent(i10) == null || node != node.getParent(i10).getLeft(i10)) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (node2.getParent(i10) == null || node2 != node2.getParent(i10).getLeft(i10)) {
            z11 = false;
        }
        if (node == access$6002) {
            node.setParent(node2, i10);
            if (z11) {
                node2.setLeft(node, i10);
                node2.setRight(access$400, i10);
            } else {
                node2.setRight(node, i10);
                node2.setLeft(access$100, i10);
            }
        } else {
            node.setParent(access$6002, i10);
            if (access$6002 != null) {
                if (z11) {
                    access$6002.setLeft(node, i10);
                } else {
                    access$6002.setRight(node, i10);
                }
            }
            node2.setLeft(access$100, i10);
            node2.setRight(access$400, i10);
        }
        if (node2 == access$600) {
            node2.setParent(node, i10);
            if (z10) {
                node.setLeft(node2, i10);
                node.setRight(access$4002, i10);
            } else {
                node.setRight(node2, i10);
                node.setLeft(access$1002, i10);
            }
        } else {
            node2.setParent(access$600, i10);
            if (access$600 != null) {
                if (z10) {
                    access$600.setLeft(node2, i10);
                } else {
                    access$600.setRight(node2, i10);
                }
            }
            node.setLeft(access$1002, i10);
            node.setRight(access$4002, i10);
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

    public boolean containsKey(Object obj) {
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
        if (this.entrySet == null) {
            this.entrySet = new EntryView(this, 0, 2);
        }
        return this.entrySet;
    }

    public boolean equals(Object obj) {
        return doEquals(obj, 0);
    }

    public Object firstKey() {
        if (this.nodeCount != 0) {
            return leastNode(this.rootNode[0], 0).getKey();
        }
        throw new NoSuchElementException("Map is empty");
    }

    public Object get(Object obj) {
        return doGet((Comparable) obj, 0);
    }

    public Object getKey(Object obj) {
        return doGet((Comparable) obj, 1);
    }

    public int hashCode() {
        return doHashCode(0);
    }

    public BidiMap inverseBidiMap() {
        return inverseOrderedBidiMap();
    }

    public OrderedBidiMap inverseOrderedBidiMap() {
        if (this.inverse == null) {
            this.inverse = new Inverse(this);
        }
        return this.inverse;
    }

    public boolean isEmpty() {
        return this.nodeCount == 0;
    }

    public Set keySet() {
        if (this.keySet == null) {
            this.keySet = new View(this, 0, 0);
        }
        return this.keySet;
    }

    public Object lastKey() {
        if (this.nodeCount != 0) {
            return greatestNode(this.rootNode[0], 0).getKey();
        }
        throw new NoSuchElementException("Map is empty");
    }

    public MapIterator mapIterator() {
        if (isEmpty()) {
            return EmptyOrderedMapIterator.INSTANCE;
        }
        return new ViewMapIterator(this, 0);
    }

    public Object nextKey(Object obj) {
        checkKey(obj);
        Node nextGreater = nextGreater(lookup((Comparable) obj, 0), 0);
        if (nextGreater == null) {
            return null;
        }
        return nextGreater.getKey();
    }

    public OrderedMapIterator orderedMapIterator() {
        if (isEmpty()) {
            return EmptyOrderedMapIterator.INSTANCE;
        }
        return new ViewMapIterator(this, 0);
    }

    public Object previousKey(Object obj) {
        checkKey(obj);
        Node nextSmaller = nextSmaller(lookup((Comparable) obj, 0), 0);
        if (nextSmaller == null) {
            return null;
        }
        return nextSmaller.getKey();
    }

    public Object put(Object obj, Object obj2) {
        return doPut((Comparable) obj, (Comparable) obj2, 0);
    }

    public void putAll(Map map) {
        for (Map.Entry entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
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

    public String toString() {
        return doToString(0);
    }

    public Collection values() {
        if (this.valuesSet == null) {
            this.valuesSet = new View(this, 0, 1);
        }
        return this.valuesSet;
    }

    public TreeBidiMap(Map map) {
        putAll(map);
    }
}
