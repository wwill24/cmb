package com.google.firebase.database.snapshot;

import com.google.firebase.database.core.utilities.Utilities;
import com.google.firebase.database.snapshot.LeafNode;
import com.google.firebase.database.snapshot.Node;

public class LongNode extends LeafNode<LongNode> {
    private final long value;

    public LongNode(Long l10, Node node) {
        super(node);
        this.value = l10.longValue();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof LongNode)) {
            return false;
        }
        LongNode longNode = (LongNode) obj;
        if (this.value != longNode.value || !this.priority.equals(longNode.priority)) {
            return false;
        }
        return true;
    }

    public String getHashRepresentation(Node.HashVersion hashVersion) {
        return (getPriorityHash(hashVersion) + "number:") + Utilities.doubleToHashString((double) this.value);
    }

    /* access modifiers changed from: protected */
    public LeafNode.LeafType getLeafType() {
        return LeafNode.LeafType.Number;
    }

    public Object getValue() {
        return Long.valueOf(this.value);
    }

    public int hashCode() {
        long j10 = this.value;
        return ((int) (j10 ^ (j10 >>> 32))) + this.priority.hashCode();
    }

    /* access modifiers changed from: protected */
    public int compareLeafValues(LongNode longNode) {
        return Utilities.compareLongs(this.value, longNode.value);
    }

    public LongNode updatePriority(Node node) {
        return new LongNode(Long.valueOf(this.value), node);
    }
}
