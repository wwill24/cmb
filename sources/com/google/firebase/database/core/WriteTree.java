package com.google.firebase.database.core;

import com.google.firebase.database.core.utilities.Predicate;
import com.google.firebase.database.core.utilities.Utilities;
import com.google.firebase.database.core.view.CacheNode;
import com.google.firebase.database.snapshot.ChildKey;
import com.google.firebase.database.snapshot.EmptyNode;
import com.google.firebase.database.snapshot.Index;
import com.google.firebase.database.snapshot.NamedNode;
import com.google.firebase.database.snapshot.Node;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class WriteTree {
    private static final Predicate<UserWriteRecord> DEFAULT_FILTER = new Predicate<UserWriteRecord>() {
        public boolean evaluate(UserWriteRecord userWriteRecord) {
            return userWriteRecord.isVisible();
        }
    };
    private List<UserWriteRecord> allWrites = new ArrayList();
    private Long lastWriteId = -1L;
    private CompoundWrite visibleWrites = CompoundWrite.emptyWrite();

    private static CompoundWrite layerTree(List<UserWriteRecord> list, Predicate<UserWriteRecord> predicate, Path path) {
        CompoundWrite emptyWrite = CompoundWrite.emptyWrite();
        for (UserWriteRecord next : list) {
            if (predicate.evaluate(next)) {
                Path path2 = next.getPath();
                if (next.isOverwrite()) {
                    if (path.contains(path2)) {
                        emptyWrite = emptyWrite.addWrite(Path.getRelative(path, path2), next.getOverwrite());
                    } else if (path2.contains(path)) {
                        emptyWrite = emptyWrite.addWrite(Path.getEmptyPath(), next.getOverwrite().getChild(Path.getRelative(path2, path)));
                    }
                } else if (path.contains(path2)) {
                    emptyWrite = emptyWrite.addWrites(Path.getRelative(path, path2), next.getMerge());
                } else if (path2.contains(path)) {
                    Path relative = Path.getRelative(path2, path);
                    if (relative.isEmpty()) {
                        emptyWrite = emptyWrite.addWrites(Path.getEmptyPath(), next.getMerge());
                    } else {
                        Node completeNode = next.getMerge().getCompleteNode(relative);
                        if (completeNode != null) {
                            emptyWrite = emptyWrite.addWrite(Path.getEmptyPath(), completeNode);
                        }
                    }
                }
            }
        }
        return emptyWrite;
    }

    private boolean recordContainsPath(UserWriteRecord userWriteRecord, Path path) {
        if (userWriteRecord.isOverwrite()) {
            return userWriteRecord.getPath().contains(path);
        }
        Iterator<Map.Entry<Path, Node>> it = userWriteRecord.getMerge().iterator();
        while (it.hasNext()) {
            if (userWriteRecord.getPath().child((Path) it.next().getKey()).contains(path)) {
                return true;
            }
        }
        return false;
    }

    private void resetTree() {
        this.visibleWrites = layerTree(this.allWrites, DEFAULT_FILTER, Path.getEmptyPath());
        if (this.allWrites.size() > 0) {
            List<UserWriteRecord> list = this.allWrites;
            this.lastWriteId = Long.valueOf(list.get(list.size() - 1).getWriteId());
            return;
        }
        this.lastWriteId = -1L;
    }

    public void addMerge(Path path, CompoundWrite compoundWrite, Long l10) {
        boolean z10;
        if (l10.longValue() > this.lastWriteId.longValue()) {
            z10 = true;
        } else {
            z10 = false;
        }
        Utilities.hardAssert(z10);
        this.allWrites.add(new UserWriteRecord(l10.longValue(), path, compoundWrite));
        this.visibleWrites = this.visibleWrites.addWrites(path, compoundWrite);
        this.lastWriteId = l10;
    }

    public void addOverwrite(Path path, Node node, Long l10, boolean z10) {
        boolean z11;
        if (l10.longValue() > this.lastWriteId.longValue()) {
            z11 = true;
        } else {
            z11 = false;
        }
        Utilities.hardAssert(z11);
        this.allWrites.add(new UserWriteRecord(l10.longValue(), path, node, z10));
        if (z10) {
            this.visibleWrites = this.visibleWrites.addWrite(path, node);
        }
        this.lastWriteId = l10;
    }

    public Node calcCompleteChild(Path path, ChildKey childKey, CacheNode cacheNode) {
        Path child = path.child(childKey);
        Node completeNode = this.visibleWrites.getCompleteNode(child);
        if (completeNode != null) {
            return completeNode;
        }
        if (cacheNode.isCompleteForChild(childKey)) {
            return this.visibleWrites.childCompoundWrite(child).apply(cacheNode.getNode().getImmediateChild(childKey));
        }
        return null;
    }

    public Node calcCompleteEventCache(Path path, Node node) {
        return calcCompleteEventCache(path, node, new ArrayList());
    }

    public Node calcCompleteEventChildren(Path path, Node node) {
        Node Empty = EmptyNode.Empty();
        Node<NamedNode> completeNode = this.visibleWrites.getCompleteNode(path);
        if (completeNode != null) {
            if (!completeNode.isLeafNode()) {
                for (NamedNode namedNode : completeNode) {
                    Empty = Empty.updateImmediateChild(namedNode.getName(), namedNode.getNode());
                }
            }
            return Empty;
        }
        CompoundWrite childCompoundWrite = this.visibleWrites.childCompoundWrite(path);
        Iterator it = node.iterator();
        while (it.hasNext()) {
            NamedNode namedNode2 = (NamedNode) it.next();
            Empty = Empty.updateImmediateChild(namedNode2.getName(), childCompoundWrite.childCompoundWrite(new Path(namedNode2.getName())).apply(namedNode2.getNode()));
        }
        for (NamedNode next : childCompoundWrite.getCompleteChildren()) {
            Empty = Empty.updateImmediateChild(next.getName(), next.getNode());
        }
        return Empty;
    }

    public Node calcEventCacheAfterServerOverwrite(Path path, Path path2, Node node, Node node2) {
        boolean z10;
        if (node == null && node2 == null) {
            z10 = false;
        } else {
            z10 = true;
        }
        Utilities.hardAssert(z10, "Either existingEventSnap or existingServerSnap must exist");
        Path child = path.child(path2);
        if (this.visibleWrites.hasCompleteWrite(child)) {
            return null;
        }
        CompoundWrite childCompoundWrite = this.visibleWrites.childCompoundWrite(child);
        if (childCompoundWrite.isEmpty()) {
            return node2.getChild(path2);
        }
        return childCompoundWrite.apply(node2.getChild(path2));
    }

    public NamedNode calcNextNodeAfterPost(Path path, Node node, NamedNode namedNode, boolean z10, Index index) {
        CompoundWrite childCompoundWrite = this.visibleWrites.childCompoundWrite(path);
        Node<NamedNode> completeNode = childCompoundWrite.getCompleteNode(Path.getEmptyPath());
        NamedNode namedNode2 = null;
        if (completeNode == null) {
            if (node != null) {
                completeNode = childCompoundWrite.apply(node);
            }
            return namedNode2;
        }
        for (NamedNode namedNode3 : completeNode) {
            if (index.compare(namedNode3, namedNode, z10) > 0 && (namedNode2 == null || index.compare(namedNode3, namedNode2, z10) < 0)) {
                namedNode2 = namedNode3;
            }
        }
        return namedNode2;
    }

    public WriteTreeRef childWrites(Path path) {
        return new WriteTreeRef(path, this);
    }

    public Node getCompleteWriteData(Path path) {
        return this.visibleWrites.getCompleteNode(path);
    }

    public UserWriteRecord getWrite(long j10) {
        for (UserWriteRecord next : this.allWrites) {
            if (next.getWriteId() == j10) {
                return next;
            }
        }
        return null;
    }

    public List<UserWriteRecord> purgeAllWrites() {
        ArrayList arrayList = new ArrayList(this.allWrites);
        this.visibleWrites = CompoundWrite.emptyWrite();
        this.allWrites = new ArrayList();
        return arrayList;
    }

    public boolean removeWrite(long j10) {
        UserWriteRecord userWriteRecord;
        boolean z10;
        Iterator<UserWriteRecord> it = this.allWrites.iterator();
        int i10 = 0;
        while (true) {
            if (!it.hasNext()) {
                userWriteRecord = null;
                break;
            }
            userWriteRecord = it.next();
            if (userWriteRecord.getWriteId() == j10) {
                break;
            }
            i10++;
        }
        if (userWriteRecord != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        Utilities.hardAssert(z10, "removeWrite called with nonexistent writeId");
        this.allWrites.remove(userWriteRecord);
        boolean isVisible = userWriteRecord.isVisible();
        int size = this.allWrites.size() - 1;
        boolean z11 = false;
        while (isVisible && size >= 0) {
            UserWriteRecord userWriteRecord2 = this.allWrites.get(size);
            if (userWriteRecord2.isVisible()) {
                if (size >= i10 && recordContainsPath(userWriteRecord2, userWriteRecord.getPath())) {
                    isVisible = false;
                } else if (userWriteRecord.getPath().contains(userWriteRecord2.getPath())) {
                    z11 = true;
                }
            }
            size--;
        }
        if (!isVisible) {
            return false;
        }
        if (z11) {
            resetTree();
            return true;
        }
        if (userWriteRecord.isOverwrite()) {
            this.visibleWrites = this.visibleWrites.removeWrite(userWriteRecord.getPath());
        } else {
            Iterator<Map.Entry<Path, Node>> it2 = userWriteRecord.getMerge().iterator();
            while (it2.hasNext()) {
                this.visibleWrites = this.visibleWrites.removeWrite(userWriteRecord.getPath().child((Path) it2.next().getKey()));
            }
        }
        return true;
    }

    public Node shadowingWrite(Path path) {
        return this.visibleWrites.getCompleteNode(path);
    }

    public Node calcCompleteEventCache(Path path, Node node, List<Long> list) {
        return calcCompleteEventCache(path, node, list, false);
    }

    public Node calcCompleteEventCache(final Path path, Node node, final List<Long> list, final boolean z10) {
        if (!list.isEmpty() || z10) {
            CompoundWrite childCompoundWrite = this.visibleWrites.childCompoundWrite(path);
            if (!z10 && childCompoundWrite.isEmpty()) {
                return node;
            }
            if (!z10 && node == null && !childCompoundWrite.hasCompleteWrite(Path.getEmptyPath())) {
                return null;
            }
            CompoundWrite layerTree = layerTree(this.allWrites, new Predicate<UserWriteRecord>() {
                public boolean evaluate(UserWriteRecord userWriteRecord) {
                    return (userWriteRecord.isVisible() || z10) && !list.contains(Long.valueOf(userWriteRecord.getWriteId())) && (userWriteRecord.getPath().contains(path) || path.contains(userWriteRecord.getPath()));
                }
            }, path);
            if (node == null) {
                node = EmptyNode.Empty();
            }
            return layerTree.apply(node);
        }
        Node completeNode = this.visibleWrites.getCompleteNode(path);
        if (completeNode != null) {
            return completeNode;
        }
        CompoundWrite childCompoundWrite2 = this.visibleWrites.childCompoundWrite(path);
        if (childCompoundWrite2.isEmpty()) {
            return node;
        }
        if (node == null && !childCompoundWrite2.hasCompleteWrite(Path.getEmptyPath())) {
            return null;
        }
        if (node == null) {
            node = EmptyNode.Empty();
        }
        return childCompoundWrite2.apply(node);
    }
}
