package com.google.firebase.database.snapshot;

import com.google.firebase.database.core.Path;
import com.google.firebase.database.core.utilities.Utilities;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class RangeMerge {
    private final Path optExclusiveStart;
    private final Path optInclusiveEnd;
    private final Node snap;

    public RangeMerge(Path path, Path path2, Node node) {
        this.optExclusiveStart = path;
        this.optInclusiveEnd = path2;
        this.snap = node;
    }

    private Node updateRangeInNode(Path path, Node node, Node node2) {
        int i10;
        int i11;
        boolean z10;
        boolean z11;
        Path path2 = this.optExclusiveStart;
        boolean z12 = true;
        if (path2 == null) {
            i10 = 1;
        } else {
            i10 = path.compareTo(path2);
        }
        Path path3 = this.optInclusiveEnd;
        if (path3 == null) {
            i11 = -1;
        } else {
            i11 = path.compareTo(path3);
        }
        Path path4 = this.optExclusiveStart;
        if (path4 == null || !path.contains(path4)) {
            z10 = false;
        } else {
            z10 = true;
        }
        Path path5 = this.optInclusiveEnd;
        if (path5 == null || !path.contains(path5)) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (i10 > 0 && i11 < 0 && !z11) {
            return node2;
        }
        if (i10 > 0 && z11 && node2.isLeafNode()) {
            return node2;
        }
        if (i10 > 0 && i11 == 0) {
            Utilities.hardAssert(z11);
            Utilities.hardAssert(!node2.isLeafNode());
            if (node.isLeafNode()) {
                return EmptyNode.Empty();
            }
            return node;
        } else if (z10 || z11) {
            HashSet hashSet = new HashSet();
            Iterator it = node.iterator();
            while (it.hasNext()) {
                hashSet.add(((NamedNode) it.next()).getName());
            }
            Iterator it2 = node2.iterator();
            while (it2.hasNext()) {
                hashSet.add(((NamedNode) it2.next()).getName());
            }
            ArrayList<ChildKey> arrayList = new ArrayList<>(hashSet.size() + 1);
            arrayList.addAll(hashSet);
            if (!node2.getPriority().isEmpty() || !node.getPriority().isEmpty()) {
                arrayList.add(ChildKey.getPriorityKey());
            }
            Node node3 = node;
            for (ChildKey childKey : arrayList) {
                Node immediateChild = node.getImmediateChild(childKey);
                Node updateRangeInNode = updateRangeInNode(path.child(childKey), node.getImmediateChild(childKey), node2.getImmediateChild(childKey));
                if (updateRangeInNode != immediateChild) {
                    node3 = node3.updateImmediateChild(childKey, updateRangeInNode);
                }
            }
            return node3;
        } else {
            if (i11 <= 0 && i10 > 0) {
                z12 = false;
            }
            Utilities.hardAssert(z12);
            return node;
        }
    }

    public Node applyTo(Node node) {
        return updateRangeInNode(Path.getEmptyPath(), node, this.snap);
    }

    /* access modifiers changed from: package-private */
    public Path getEnd() {
        return this.optInclusiveEnd;
    }

    /* access modifiers changed from: package-private */
    public Path getStart() {
        return this.optExclusiveStart;
    }

    public String toString() {
        return "RangeMerge{optExclusiveStart=" + this.optExclusiveStart + ", optInclusiveEnd=" + this.optInclusiveEnd + ", snap=" + this.snap + '}';
    }

    public RangeMerge(com.google.firebase.database.connection.RangeMerge rangeMerge) {
        List<String> optExclusiveStart2 = rangeMerge.getOptExclusiveStart();
        Path path = null;
        this.optExclusiveStart = optExclusiveStart2 != null ? new Path(optExclusiveStart2) : null;
        List<String> optInclusiveEnd2 = rangeMerge.getOptInclusiveEnd();
        this.optInclusiveEnd = optInclusiveEnd2 != null ? new Path(optInclusiveEnd2) : path;
        this.snap = NodeUtilities.NodeFromJSON(rangeMerge.getSnap());
    }
}
