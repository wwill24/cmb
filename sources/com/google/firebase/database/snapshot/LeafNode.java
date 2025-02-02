package com.google.firebase.database.snapshot;

import com.facebook.internal.security.CertificateUtil;
import com.google.firebase.database.core.Path;
import com.google.firebase.database.core.utilities.Utilities;
import com.google.firebase.database.snapshot.LeafNode;
import com.google.firebase.database.snapshot.Node;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

public abstract class LeafNode<T extends LeafNode> implements Node {
    private String lazyHash;
    protected final Node priority;

    /* renamed from: com.google.firebase.database.snapshot.LeafNode$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$firebase$database$snapshot$Node$HashVersion;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.google.firebase.database.snapshot.Node$HashVersion[] r0 = com.google.firebase.database.snapshot.Node.HashVersion.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$google$firebase$database$snapshot$Node$HashVersion = r0
                com.google.firebase.database.snapshot.Node$HashVersion r1 = com.google.firebase.database.snapshot.Node.HashVersion.V1     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$google$firebase$database$snapshot$Node$HashVersion     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.firebase.database.snapshot.Node$HashVersion r1 = com.google.firebase.database.snapshot.Node.HashVersion.V2     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.database.snapshot.LeafNode.AnonymousClass1.<clinit>():void");
        }
    }

    protected enum LeafType {
        DeferredValue,
        Boolean,
        Number,
        String
    }

    LeafNode(Node node) {
        this.priority = node;
    }

    private static int compareLongDoubleNodes(LongNode longNode, DoubleNode doubleNode) {
        return Double.valueOf((double) ((Long) longNode.getValue()).longValue()).compareTo((Double) doubleNode.getValue());
    }

    /* access modifiers changed from: protected */
    public abstract int compareLeafValues(T t10);

    public abstract boolean equals(Object obj);

    public Node getChild(Path path) {
        if (path.isEmpty()) {
            return this;
        }
        if (path.getFront().isPriorityChildName()) {
            return this.priority;
        }
        return EmptyNode.Empty();
    }

    public int getChildCount() {
        return 0;
    }

    public String getHash() {
        if (this.lazyHash == null) {
            this.lazyHash = Utilities.sha1HexDigest(getHashRepresentation(Node.HashVersion.V1));
        }
        return this.lazyHash;
    }

    public Node getImmediateChild(ChildKey childKey) {
        if (childKey.isPriorityChildName()) {
            return this.priority;
        }
        return EmptyNode.Empty();
    }

    /* access modifiers changed from: protected */
    public abstract LeafType getLeafType();

    public ChildKey getPredecessorChildKey(ChildKey childKey) {
        return null;
    }

    public Node getPriority() {
        return this.priority;
    }

    /* access modifiers changed from: protected */
    public String getPriorityHash(Node.HashVersion hashVersion) {
        int i10 = AnonymousClass1.$SwitchMap$com$google$firebase$database$snapshot$Node$HashVersion[hashVersion.ordinal()];
        if (i10 != 1 && i10 != 2) {
            throw new IllegalArgumentException("Unknown hash version: " + hashVersion);
        } else if (this.priority.isEmpty()) {
            return "";
        } else {
            return "priority:" + this.priority.getHashRepresentation(hashVersion) + CertificateUtil.DELIMITER;
        }
    }

    public ChildKey getSuccessorChildKey(ChildKey childKey) {
        return null;
    }

    public Object getValue(boolean z10) {
        if (!z10 || this.priority.isEmpty()) {
            return getValue();
        }
        HashMap hashMap = new HashMap();
        hashMap.put(".value", getValue());
        hashMap.put(".priority", this.priority.getValue());
        return hashMap;
    }

    public boolean hasChild(ChildKey childKey) {
        return false;
    }

    public abstract int hashCode();

    public boolean isEmpty() {
        return false;
    }

    public boolean isLeafNode() {
        return true;
    }

    public Iterator<NamedNode> iterator() {
        return Collections.emptyList().iterator();
    }

    /* access modifiers changed from: protected */
    public int leafCompare(LeafNode<?> leafNode) {
        LeafType leafType = getLeafType();
        LeafType leafType2 = leafNode.getLeafType();
        if (leafType.equals(leafType2)) {
            return compareLeafValues(leafNode);
        }
        return leafType.compareTo(leafType2);
    }

    public Iterator<NamedNode> reverseIterator() {
        return Collections.emptyList().iterator();
    }

    public String toString() {
        String obj = getValue(true).toString();
        if (obj.length() <= 100) {
            return obj;
        }
        return obj.substring(0, 100) + "...";
    }

    public Node updateChild(Path path, Node node) {
        ChildKey front = path.getFront();
        if (front == null) {
            return node;
        }
        if (node.isEmpty() && !front.isPriorityChildName()) {
            return this;
        }
        boolean z10 = true;
        if (path.getFront().isPriorityChildName() && path.size() != 1) {
            z10 = false;
        }
        Utilities.hardAssert(z10);
        return updateImmediateChild(front, EmptyNode.Empty().updateChild(path.popFront(), node));
    }

    public Node updateImmediateChild(ChildKey childKey, Node node) {
        if (childKey.isPriorityChildName()) {
            return updatePriority(node);
        }
        if (node.isEmpty()) {
            return this;
        }
        return EmptyNode.Empty().updateImmediateChild(childKey, node).updatePriority(this.priority);
    }

    public int compareTo(Node node) {
        if (node.isEmpty()) {
            return 1;
        }
        if (node instanceof ChildrenNode) {
            return -1;
        }
        Utilities.hardAssert(node.isLeafNode(), "Node is not leaf node!");
        if ((this instanceof LongNode) && (node instanceof DoubleNode)) {
            return compareLongDoubleNodes((LongNode) this, (DoubleNode) node);
        }
        if (!(this instanceof DoubleNode) || !(node instanceof LongNode)) {
            return leafCompare((LeafNode) node);
        }
        return compareLongDoubleNodes((LongNode) node, (DoubleNode) this) * -1;
    }
}
