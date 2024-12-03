package org.apache.commons.collections.list;

import com.mparticle.kits.AppsFlyerKit;
import java.util.AbstractList;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import org.apache.commons.collections.OrderedIterator;

public class TreeList extends AbstractList {
    /* access modifiers changed from: private */
    public AVLNode root;
    private int size;

    static class AVLNode {
        private int height;
        private AVLNode left;
        private boolean leftIsPrevious;
        /* access modifiers changed from: private */
        public int relativePosition;
        private AVLNode right;
        private boolean rightIsNext;
        /* access modifiers changed from: private */
        public Object value;

        private AVLNode balance() {
            int heightRightMinusLeft = heightRightMinusLeft();
            if (heightRightMinusLeft == -2) {
                if (this.left.heightRightMinusLeft() > 0) {
                    setLeft(this.left.rotateLeft(), (AVLNode) null);
                }
                return rotateRight();
            } else if (heightRightMinusLeft == -1 || heightRightMinusLeft == 0 || heightRightMinusLeft == 1) {
                return this;
            } else {
                if (heightRightMinusLeft == 2) {
                    if (this.right.heightRightMinusLeft() < 0) {
                        setRight(this.right.rotateRight(), (AVLNode) null);
                    }
                    return rotateLeft();
                }
                throw new RuntimeException("tree inconsistent!");
            }
        }

        private int getHeight(AVLNode aVLNode) {
            if (aVLNode == null) {
                return -1;
            }
            return aVLNode.height;
        }

        private AVLNode getLeftSubTree() {
            if (this.leftIsPrevious) {
                return null;
            }
            return this.left;
        }

        private int getOffset(AVLNode aVLNode) {
            if (aVLNode == null) {
                return 0;
            }
            return aVLNode.relativePosition;
        }

        private AVLNode getRightSubTree() {
            if (this.rightIsNext) {
                return null;
            }
            return this.right;
        }

        private int heightRightMinusLeft() {
            return getHeight(getRightSubTree()) - getHeight(getLeftSubTree());
        }

        private AVLNode insertOnLeft(int i10, Object obj) {
            if (getLeftSubTree() == null) {
                setLeft(new AVLNode(-1, obj, this, this.left), (AVLNode) null);
            } else {
                setLeft(this.left.insert(i10, obj), (AVLNode) null);
            }
            int i11 = this.relativePosition;
            if (i11 >= 0) {
                this.relativePosition = i11 + 1;
            }
            AVLNode balance = balance();
            recalcHeight();
            return balance;
        }

        private AVLNode insertOnRight(int i10, Object obj) {
            if (getRightSubTree() == null) {
                setRight(new AVLNode(1, obj, this.right, this), (AVLNode) null);
            } else {
                setRight(this.right.insert(i10, obj), (AVLNode) null);
            }
            int i11 = this.relativePosition;
            if (i11 < 0) {
                this.relativePosition = i11 - 1;
            }
            AVLNode balance = balance();
            recalcHeight();
            return balance;
        }

        private AVLNode max() {
            return getRightSubTree() == null ? this : this.right.max();
        }

        private AVLNode min() {
            return getLeftSubTree() == null ? this : this.left.min();
        }

        private void recalcHeight() {
            int i10 = -1;
            int i11 = getLeftSubTree() == null ? -1 : getLeftSubTree().height;
            if (getRightSubTree() != null) {
                i10 = getRightSubTree().height;
            }
            this.height = Math.max(i11, i10) + 1;
        }

        private AVLNode removeMax() {
            if (getRightSubTree() == null) {
                return removeSelf();
            }
            setRight(this.right.removeMax(), this.right.right);
            int i10 = this.relativePosition;
            if (i10 < 0) {
                this.relativePosition = i10 + 1;
            }
            recalcHeight();
            return balance();
        }

        private AVLNode removeMin() {
            if (getLeftSubTree() == null) {
                return removeSelf();
            }
            setLeft(this.left.removeMin(), this.left.left);
            int i10 = this.relativePosition;
            if (i10 > 0) {
                this.relativePosition = i10 - 1;
            }
            recalcHeight();
            return balance();
        }

        private AVLNode removeSelf() {
            if (getRightSubTree() == null && getLeftSubTree() == null) {
                return null;
            }
            int i10 = 0;
            if (getRightSubTree() == null) {
                int i11 = this.relativePosition;
                if (i11 > 0) {
                    AVLNode aVLNode = this.left;
                    int i12 = aVLNode.relativePosition;
                    if (i11 <= 0) {
                        i10 = 1;
                    }
                    aVLNode.relativePosition = i12 + i11 + i10;
                }
                this.left.max().setRight((AVLNode) null, this.right);
                return this.left;
            } else if (getLeftSubTree() == null) {
                AVLNode aVLNode2 = this.right;
                int i13 = aVLNode2.relativePosition;
                int i14 = this.relativePosition;
                if (i14 >= 0) {
                    i10 = 1;
                }
                aVLNode2.relativePosition = i13 + (i14 - i10);
                aVLNode2.min().setLeft((AVLNode) null, this.left);
                return this.right;
            } else {
                if (heightRightMinusLeft() > 0) {
                    AVLNode min = this.right.min();
                    this.value = min.value;
                    if (this.leftIsPrevious) {
                        this.left = min.left;
                    }
                    this.right = this.right.removeMin();
                    int i15 = this.relativePosition;
                    if (i15 < 0) {
                        this.relativePosition = i15 + 1;
                    }
                } else {
                    AVLNode max = this.left.max();
                    this.value = max.value;
                    if (this.rightIsNext) {
                        this.right = max.right;
                    }
                    AVLNode aVLNode3 = this.left;
                    AVLNode aVLNode4 = aVLNode3.left;
                    AVLNode removeMax = aVLNode3.removeMax();
                    this.left = removeMax;
                    if (removeMax == null) {
                        this.left = aVLNode4;
                        this.leftIsPrevious = true;
                    }
                    int i16 = this.relativePosition;
                    if (i16 > 0) {
                        this.relativePosition = i16 - 1;
                    }
                }
                recalcHeight();
                return this;
            }
        }

        private AVLNode rotateLeft() {
            AVLNode aVLNode = this.right;
            AVLNode leftSubTree = getRightSubTree().getLeftSubTree();
            int offset = this.relativePosition + getOffset(aVLNode);
            setRight(leftSubTree, aVLNode);
            aVLNode.setLeft(this, (AVLNode) null);
            setOffset(aVLNode, offset);
            setOffset(this, -aVLNode.relativePosition);
            setOffset(leftSubTree, getOffset(aVLNode) + getOffset(leftSubTree));
            return aVLNode;
        }

        private AVLNode rotateRight() {
            AVLNode aVLNode = this.left;
            AVLNode rightSubTree = getLeftSubTree().getRightSubTree();
            int offset = this.relativePosition + getOffset(aVLNode);
            setLeft(rightSubTree, aVLNode);
            aVLNode.setRight(this, (AVLNode) null);
            setOffset(aVLNode, offset);
            setOffset(this, -aVLNode.relativePosition);
            setOffset(rightSubTree, getOffset(aVLNode) + getOffset(rightSubTree));
            return aVLNode;
        }

        private void setLeft(AVLNode aVLNode, AVLNode aVLNode2) {
            boolean z10;
            if (aVLNode == null) {
                z10 = true;
            } else {
                z10 = false;
            }
            this.leftIsPrevious = z10;
            if (z10) {
                aVLNode = aVLNode2;
            }
            this.left = aVLNode;
            recalcHeight();
        }

        private int setOffset(AVLNode aVLNode, int i10) {
            if (aVLNode == null) {
                return 0;
            }
            int offset = getOffset(aVLNode);
            aVLNode.relativePosition = i10;
            return offset;
        }

        private void setRight(AVLNode aVLNode, AVLNode aVLNode2) {
            boolean z10;
            if (aVLNode == null) {
                z10 = true;
            } else {
                z10 = false;
            }
            this.rightIsNext = z10;
            if (z10) {
                aVLNode = aVLNode2;
            }
            this.right = aVLNode;
            recalcHeight();
        }

        /* access modifiers changed from: package-private */
        public AVLNode get(int i10) {
            AVLNode aVLNode;
            int i11 = i10 - this.relativePosition;
            if (i11 == 0) {
                return this;
            }
            if (i11 < 0) {
                aVLNode = getLeftSubTree();
            } else {
                aVLNode = getRightSubTree();
            }
            if (aVLNode == null) {
                return null;
            }
            return aVLNode.get(i11);
        }

        /* access modifiers changed from: package-private */
        public Object getValue() {
            return this.value;
        }

        /* access modifiers changed from: package-private */
        public int indexOf(Object obj, int i10) {
            if (getLeftSubTree() != null) {
                AVLNode aVLNode = this.left;
                int indexOf = aVLNode.indexOf(obj, aVLNode.relativePosition + i10);
                if (indexOf != -1) {
                    return indexOf;
                }
            }
            Object obj2 = this.value;
            if (obj2 != null ? obj2.equals(obj) : obj2 == obj) {
                return i10;
            }
            if (getRightSubTree() == null) {
                return -1;
            }
            AVLNode aVLNode2 = this.right;
            return aVLNode2.indexOf(obj, i10 + aVLNode2.relativePosition);
        }

        /* access modifiers changed from: package-private */
        public AVLNode insert(int i10, Object obj) {
            int i11 = i10 - this.relativePosition;
            if (i11 <= 0) {
                return insertOnLeft(i11, obj);
            }
            return insertOnRight(i11, obj);
        }

        /* access modifiers changed from: package-private */
        public AVLNode next() {
            AVLNode aVLNode;
            if (this.rightIsNext || (aVLNode = this.right) == null) {
                return this.right;
            }
            return aVLNode.min();
        }

        /* access modifiers changed from: package-private */
        public AVLNode previous() {
            AVLNode aVLNode;
            if (this.leftIsPrevious || (aVLNode = this.left) == null) {
                return this.left;
            }
            return aVLNode.max();
        }

        /* access modifiers changed from: package-private */
        public AVLNode remove(int i10) {
            int i11 = i10 - this.relativePosition;
            if (i11 == 0) {
                return removeSelf();
            }
            if (i11 > 0) {
                setRight(this.right.remove(i11), this.right.right);
                int i12 = this.relativePosition;
                if (i12 < 0) {
                    this.relativePosition = i12 + 1;
                }
            } else {
                setLeft(this.left.remove(i11), this.left.left);
                int i13 = this.relativePosition;
                if (i13 > 0) {
                    this.relativePosition = i13 - 1;
                }
            }
            recalcHeight();
            return balance();
        }

        /* access modifiers changed from: package-private */
        public void setValue(Object obj) {
            this.value = obj;
        }

        /* access modifiers changed from: package-private */
        public void toArray(Object[] objArr, int i10) {
            objArr[i10] = this.value;
            if (getLeftSubTree() != null) {
                AVLNode aVLNode = this.left;
                aVLNode.toArray(objArr, aVLNode.relativePosition + i10);
            }
            if (getRightSubTree() != null) {
                AVLNode aVLNode2 = this.right;
                aVLNode2.toArray(objArr, i10 + aVLNode2.relativePosition);
            }
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("AVLNode(");
            stringBuffer.append(this.relativePosition);
            stringBuffer.append(AppsFlyerKit.COMMA);
            boolean z10 = true;
            stringBuffer.append(this.left != null);
            stringBuffer.append(AppsFlyerKit.COMMA);
            stringBuffer.append(this.value);
            stringBuffer.append(AppsFlyerKit.COMMA);
            if (getRightSubTree() == null) {
                z10 = false;
            }
            stringBuffer.append(z10);
            stringBuffer.append(", faedelung ");
            stringBuffer.append(this.rightIsNext);
            stringBuffer.append(" )");
            return stringBuffer.toString();
        }

        private AVLNode(int i10, Object obj, AVLNode aVLNode, AVLNode aVLNode2) {
            this.relativePosition = i10;
            this.value = obj;
            this.rightIsNext = true;
            this.leftIsPrevious = true;
            this.right = aVLNode;
            this.left = aVLNode2;
        }
    }

    static class TreeListIterator implements ListIterator, OrderedIterator {
        protected AVLNode current;
        protected int currentIndex;
        protected int expectedModCount;
        protected AVLNode next;
        protected int nextIndex;
        protected final TreeList parent;

        protected TreeListIterator(TreeList treeList, int i10) throws IndexOutOfBoundsException {
            AVLNode aVLNode;
            this.parent = treeList;
            this.expectedModCount = treeList.modCount;
            if (treeList.root == null) {
                aVLNode = null;
            } else {
                aVLNode = treeList.root.get(i10);
            }
            this.next = aVLNode;
            this.nextIndex = i10;
            this.currentIndex = -1;
        }

        public void add(Object obj) {
            checkModCount();
            this.parent.add(this.nextIndex, obj);
            this.current = null;
            this.currentIndex = -1;
            this.nextIndex++;
            this.expectedModCount++;
        }

        /* access modifiers changed from: protected */
        public void checkModCount() {
            if (this.parent.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }

        public boolean hasNext() {
            return this.nextIndex < this.parent.size();
        }

        public boolean hasPrevious() {
            return this.nextIndex > 0;
        }

        public Object next() {
            checkModCount();
            if (hasNext()) {
                if (this.next == null) {
                    this.next = this.parent.root.get(this.nextIndex);
                }
                Object value = this.next.getValue();
                AVLNode aVLNode = this.next;
                this.current = aVLNode;
                int i10 = this.nextIndex;
                this.nextIndex = i10 + 1;
                this.currentIndex = i10;
                this.next = aVLNode.next();
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
                AVLNode aVLNode = this.next;
                if (aVLNode == null) {
                    this.next = this.parent.root.get(this.nextIndex - 1);
                } else {
                    this.next = aVLNode.previous();
                }
                Object value = this.next.getValue();
                this.current = this.next;
                int i10 = this.nextIndex - 1;
                this.nextIndex = i10;
                this.currentIndex = i10;
                return value;
            }
            throw new NoSuchElementException("Already at start of list.");
        }

        public int previousIndex() {
            return nextIndex() - 1;
        }

        public void remove() {
            checkModCount();
            int i10 = this.currentIndex;
            if (i10 != -1) {
                this.parent.remove(i10);
                int i11 = this.nextIndex;
                if (i11 != this.currentIndex) {
                    this.nextIndex = i11 - 1;
                }
                this.next = null;
                this.current = null;
                this.currentIndex = -1;
                this.expectedModCount++;
                return;
            }
            throw new IllegalStateException();
        }

        public void set(Object obj) {
            checkModCount();
            AVLNode aVLNode = this.current;
            if (aVLNode != null) {
                aVLNode.setValue(obj);
                return;
            }
            throw new IllegalStateException();
        }
    }

    public TreeList() {
    }

    private void checkInterval(int i10, int i11, int i12) {
        if (i10 < i11 || i10 > i12) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Invalid index:");
            stringBuffer.append(i10);
            stringBuffer.append(", size=");
            stringBuffer.append(size());
            throw new IndexOutOfBoundsException(stringBuffer.toString());
        }
    }

    public void add(int i10, Object obj) {
        this.modCount++;
        checkInterval(i10, 0, size());
        AVLNode aVLNode = this.root;
        if (aVLNode == null) {
            this.root = new AVLNode(i10, obj, (AVLNode) null, (AVLNode) null);
        } else {
            this.root = aVLNode.insert(i10, obj);
        }
        this.size++;
    }

    public void clear() {
        this.modCount++;
        this.root = null;
        this.size = 0;
    }

    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    public Object get(int i10) {
        checkInterval(i10, 0, size() - 1);
        return this.root.get(i10).getValue();
    }

    public int indexOf(Object obj) {
        AVLNode aVLNode = this.root;
        if (aVLNode == null) {
            return -1;
        }
        return aVLNode.indexOf(obj, aVLNode.relativePosition);
    }

    public Iterator iterator() {
        return listIterator(0);
    }

    public ListIterator listIterator() {
        return listIterator(0);
    }

    public Object remove(int i10) {
        this.modCount++;
        checkInterval(i10, 0, size() - 1);
        Object obj = get(i10);
        this.root = this.root.remove(i10);
        this.size--;
        return obj;
    }

    public Object set(int i10, Object obj) {
        checkInterval(i10, 0, size() - 1);
        AVLNode aVLNode = this.root.get(i10);
        Object access$200 = aVLNode.value;
        aVLNode.setValue(obj);
        return access$200;
    }

    public int size() {
        return this.size;
    }

    public Object[] toArray() {
        Object[] objArr = new Object[size()];
        AVLNode aVLNode = this.root;
        if (aVLNode != null) {
            aVLNode.toArray(objArr, aVLNode.relativePosition);
        }
        return objArr;
    }

    public TreeList(Collection collection) {
        addAll(collection);
    }

    public ListIterator listIterator(int i10) {
        checkInterval(i10, 0, size());
        return new TreeListIterator(this, i10);
    }
}
