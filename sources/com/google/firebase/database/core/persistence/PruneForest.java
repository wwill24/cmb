package com.google.firebase.database.core.persistence;

import com.google.firebase.database.collection.ImmutableSortedMap;
import com.google.firebase.database.core.Path;
import com.google.firebase.database.core.utilities.ImmutableTree;
import com.google.firebase.database.core.utilities.Predicate;
import com.google.firebase.database.snapshot.ChildKey;
import java.util.Set;

public class PruneForest {
    private static final Predicate<Boolean> KEEP_PREDICATE = new Predicate<Boolean>() {
        public boolean evaluate(Boolean bool) {
            return !bool.booleanValue();
        }
    };
    private static final ImmutableTree<Boolean> KEEP_TREE = new ImmutableTree<>(Boolean.FALSE);
    private static final Predicate<Boolean> PRUNE_PREDICATE = new Predicate<Boolean>() {
        public boolean evaluate(Boolean bool) {
            return bool.booleanValue();
        }
    };
    private static final ImmutableTree<Boolean> PRUNE_TREE = new ImmutableTree<>(Boolean.TRUE);
    private final ImmutableTree<Boolean> pruneForest;

    public PruneForest() {
        this.pruneForest = ImmutableTree.emptyInstance();
    }

    private PruneForest doAll(Path path, Set<ChildKey> set, ImmutableTree<Boolean> immutableTree) {
        ImmutableTree subtree = this.pruneForest.subtree(path);
        ImmutableSortedMap<K, V> children = subtree.getChildren();
        for (ChildKey insert : set) {
            children = children.insert(insert, immutableTree);
        }
        return new PruneForest(this.pruneForest.setTree(path, new ImmutableTree((Boolean) subtree.getValue(), children)));
    }

    public boolean affectsPath(Path path) {
        if (this.pruneForest.rootMostValue(path) != null || !this.pruneForest.subtree(path).isEmpty()) {
            return true;
        }
        return false;
    }

    public PruneForest child(ChildKey childKey) {
        ImmutableTree<Boolean> child = this.pruneForest.getChild(childKey);
        if (child == null) {
            child = new ImmutableTree<>(this.pruneForest.getValue());
        } else if (child.getValue() == null && this.pruneForest.getValue() != null) {
            child = child.set(Path.getEmptyPath(), this.pruneForest.getValue());
        }
        return new PruneForest(child);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof PruneForest) && this.pruneForest.equals(((PruneForest) obj).pruneForest)) {
            return true;
        }
        return false;
    }

    public <T> T foldKeptNodes(T t10, final ImmutableTree.TreeVisitor<Void, T> treeVisitor) {
        return this.pruneForest.fold(t10, new ImmutableTree.TreeVisitor<Boolean, T>() {
            public T onNodeValue(Path path, Boolean bool, T t10) {
                return !bool.booleanValue() ? treeVisitor.onNodeValue(path, null, t10) : t10;
            }
        });
    }

    public int hashCode() {
        return this.pruneForest.hashCode();
    }

    public PruneForest keep(Path path) {
        if (this.pruneForest.rootMostValueMatching(path, KEEP_PREDICATE) != null) {
            return this;
        }
        return new PruneForest(this.pruneForest.setTree(path, KEEP_TREE));
    }

    public PruneForest keepAll(Path path, Set<ChildKey> set) {
        if (this.pruneForest.rootMostValueMatching(path, KEEP_PREDICATE) != null) {
            return this;
        }
        return doAll(path, set, KEEP_TREE);
    }

    public PruneForest prune(Path path) {
        if (this.pruneForest.rootMostValueMatching(path, KEEP_PREDICATE) != null) {
            throw new IllegalArgumentException("Can't prune path that was kept previously!");
        } else if (this.pruneForest.rootMostValueMatching(path, PRUNE_PREDICATE) != null) {
            return this;
        } else {
            return new PruneForest(this.pruneForest.setTree(path, PRUNE_TREE));
        }
    }

    public PruneForest pruneAll(Path path, Set<ChildKey> set) {
        if (this.pruneForest.rootMostValueMatching(path, KEEP_PREDICATE) != null) {
            throw new IllegalArgumentException("Can't prune path that was kept previously!");
        } else if (this.pruneForest.rootMostValueMatching(path, PRUNE_PREDICATE) != null) {
            return this;
        } else {
            return doAll(path, set, PRUNE_TREE);
        }
    }

    public boolean prunesAnything() {
        return this.pruneForest.containsMatchingValue(PRUNE_PREDICATE);
    }

    public boolean shouldKeep(Path path) {
        Boolean leafMostValue = this.pruneForest.leafMostValue(path);
        if (leafMostValue == null || leafMostValue.booleanValue()) {
            return false;
        }
        return true;
    }

    public boolean shouldPruneUnkeptDescendants(Path path) {
        Boolean leafMostValue = this.pruneForest.leafMostValue(path);
        if (leafMostValue == null || !leafMostValue.booleanValue()) {
            return false;
        }
        return true;
    }

    public String toString() {
        return "{PruneForest:" + this.pruneForest.toString() + "}";
    }

    private PruneForest(ImmutableTree<Boolean> immutableTree) {
        this.pruneForest = immutableTree;
    }

    public PruneForest child(Path path) {
        if (path.isEmpty()) {
            return this;
        }
        return child(path.getFront()).child(path.popFront());
    }
}
