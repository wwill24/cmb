package com.google.firebase.database.core.utilities;

import com.google.firebase.database.collection.ImmutableSortedMap;
import com.google.firebase.database.collection.StandardComparator;
import com.google.firebase.database.core.Path;
import com.google.firebase.database.snapshot.ChildKey;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public final class ImmutableTree<T> implements Iterable<Map.Entry<Path, T>> {
    private static final ImmutableTree EMPTY;
    private static final ImmutableSortedMap EMPTY_CHILDREN;
    private final ImmutableSortedMap<ChildKey, ImmutableTree<T>> children;
    private final T value;

    public interface TreeVisitor<T, R> {
        R onNodeValue(Path path, T t10, R r10);
    }

    static {
        ImmutableSortedMap<K, V> emptyMap = ImmutableSortedMap.Builder.emptyMap(StandardComparator.getComparator(ChildKey.class));
        EMPTY_CHILDREN = emptyMap;
        EMPTY = new ImmutableTree((Object) null, emptyMap);
    }

    public ImmutableTree(T t10, ImmutableSortedMap<ChildKey, ImmutableTree<T>> immutableSortedMap) {
        this.value = t10;
        this.children = immutableSortedMap;
    }

    public static <V> ImmutableTree<V> emptyInstance() {
        return EMPTY;
    }

    public boolean containsMatchingValue(Predicate<? super T> predicate) {
        T t10 = this.value;
        if (t10 != null && predicate.evaluate(t10)) {
            return true;
        }
        Iterator<Map.Entry<ChildKey, ImmutableTree<T>>> it = this.children.iterator();
        while (it.hasNext()) {
            if (((ImmutableTree) it.next().getValue()).containsMatchingValue(predicate)) {
                return true;
            }
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ImmutableTree.class != obj.getClass()) {
            return false;
        }
        ImmutableTree immutableTree = (ImmutableTree) obj;
        ImmutableSortedMap<ChildKey, ImmutableTree<T>> immutableSortedMap = this.children;
        if (immutableSortedMap == null ? immutableTree.children != null : !immutableSortedMap.equals(immutableTree.children)) {
            return false;
        }
        T t10 = this.value;
        T t11 = immutableTree.value;
        if (t10 == null ? t11 == null : t10.equals(t11)) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0017, code lost:
        r0 = r4.getFront();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.firebase.database.core.Path findRootMostMatchingPath(com.google.firebase.database.core.Path r4, com.google.firebase.database.core.utilities.Predicate<? super T> r5) {
        /*
            r3 = this;
            T r0 = r3.value
            if (r0 == 0) goto L_0x000f
            boolean r0 = r5.evaluate(r0)
            if (r0 == 0) goto L_0x000f
            com.google.firebase.database.core.Path r4 = com.google.firebase.database.core.Path.getEmptyPath()
            return r4
        L_0x000f:
            boolean r0 = r4.isEmpty()
            r1 = 0
            if (r0 == 0) goto L_0x0017
            return r1
        L_0x0017:
            com.google.firebase.database.snapshot.ChildKey r0 = r4.getFront()
            com.google.firebase.database.collection.ImmutableSortedMap<com.google.firebase.database.snapshot.ChildKey, com.google.firebase.database.core.utilities.ImmutableTree<T>> r2 = r3.children
            java.lang.Object r2 = r2.get(r0)
            com.google.firebase.database.core.utilities.ImmutableTree r2 = (com.google.firebase.database.core.utilities.ImmutableTree) r2
            if (r2 == 0) goto L_0x003f
            com.google.firebase.database.core.Path r4 = r4.popFront()
            com.google.firebase.database.core.Path r4 = r2.findRootMostMatchingPath(r4, r5)
            if (r4 == 0) goto L_0x003f
            com.google.firebase.database.core.Path r5 = new com.google.firebase.database.core.Path
            r1 = 1
            com.google.firebase.database.snapshot.ChildKey[] r1 = new com.google.firebase.database.snapshot.ChildKey[r1]
            r2 = 0
            r1[r2] = r0
            r5.<init>((com.google.firebase.database.snapshot.ChildKey[]) r1)
            com.google.firebase.database.core.Path r4 = r5.child((com.google.firebase.database.core.Path) r4)
            return r4
        L_0x003f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.database.core.utilities.ImmutableTree.findRootMostMatchingPath(com.google.firebase.database.core.Path, com.google.firebase.database.core.utilities.Predicate):com.google.firebase.database.core.Path");
    }

    public Path findRootMostPathWithValue(Path path) {
        return findRootMostMatchingPath(path, Predicate.TRUE);
    }

    public <R> R fold(R r10, TreeVisitor<? super T, R> treeVisitor) {
        return fold(Path.getEmptyPath(), treeVisitor, r10);
    }

    public void foreach(TreeVisitor<T, Void> treeVisitor) {
        fold(Path.getEmptyPath(), treeVisitor, (Object) null);
    }

    public T get(Path path) {
        if (path.isEmpty()) {
            return this.value;
        }
        ImmutableTree immutableTree = this.children.get(path.getFront());
        if (immutableTree != null) {
            return immutableTree.get(path.popFront());
        }
        return null;
    }

    public ImmutableTree<T> getChild(ChildKey childKey) {
        ImmutableTree<T> immutableTree = this.children.get(childKey);
        if (immutableTree != null) {
            return immutableTree;
        }
        return emptyInstance();
    }

    public ImmutableSortedMap<ChildKey, ImmutableTree<T>> getChildren() {
        return this.children;
    }

    public T getValue() {
        return this.value;
    }

    public int hashCode() {
        int i10;
        T t10 = this.value;
        int i11 = 0;
        if (t10 != null) {
            i10 = t10.hashCode();
        } else {
            i10 = 0;
        }
        int i12 = i10 * 31;
        ImmutableSortedMap<ChildKey, ImmutableTree<T>> immutableSortedMap = this.children;
        if (immutableSortedMap != null) {
            i11 = immutableSortedMap.hashCode();
        }
        return i12 + i11;
    }

    public boolean isEmpty() {
        return this.value == null && this.children.isEmpty();
    }

    public Iterator<Map.Entry<Path, T>> iterator() {
        final ArrayList arrayList = new ArrayList();
        foreach(new TreeVisitor<T, Void>() {
            public Void onNodeValue(Path path, T t10, Void voidR) {
                arrayList.add(new AbstractMap.SimpleImmutableEntry(path, t10));
                return null;
            }
        });
        return arrayList.iterator();
    }

    public T leafMostValue(Path path) {
        return leafMostValueMatching(path, Predicate.TRUE);
    }

    public T leafMostValueMatching(Path path, Predicate<? super T> predicate) {
        T t10;
        T t11 = this.value;
        if (t11 == null || !predicate.evaluate(t11)) {
            t10 = null;
        } else {
            t10 = this.value;
        }
        Iterator<ChildKey> it = path.iterator();
        ImmutableTree immutableTree = this;
        while (it.hasNext() && (immutableTree = immutableTree.children.get(it.next())) != null) {
            T t12 = immutableTree.value;
            if (t12 != null && predicate.evaluate(t12)) {
                t10 = immutableTree.value;
            }
        }
        return t10;
    }

    public ImmutableTree<T> remove(Path path) {
        ImmutableSortedMap<ChildKey, ImmutableTree<T>> immutableSortedMap;
        if (!path.isEmpty()) {
            ChildKey front = path.getFront();
            ImmutableTree immutableTree = this.children.get(front);
            if (immutableTree == null) {
                return this;
            }
            ImmutableTree remove = immutableTree.remove(path.popFront());
            if (remove.isEmpty()) {
                immutableSortedMap = this.children.remove(front);
            } else {
                immutableSortedMap = this.children.insert(front, remove);
            }
            if (this.value != null || !immutableSortedMap.isEmpty()) {
                return new ImmutableTree<>(this.value, immutableSortedMap);
            }
            return emptyInstance();
        } else if (this.children.isEmpty()) {
            return emptyInstance();
        } else {
            return new ImmutableTree<>((Object) null, this.children);
        }
    }

    public T rootMostValue(Path path) {
        return rootMostValueMatching(path, Predicate.TRUE);
    }

    public T rootMostValueMatching(Path path, Predicate<? super T> predicate) {
        T t10 = this.value;
        if (t10 != null && predicate.evaluate(t10)) {
            return this.value;
        }
        Iterator<ChildKey> it = path.iterator();
        ImmutableTree immutableTree = this;
        while (it.hasNext() && (immutableTree = immutableTree.children.get(it.next())) != null) {
            T t11 = immutableTree.value;
            if (t11 != null && predicate.evaluate(t11)) {
                return immutableTree.value;
            }
        }
        return null;
    }

    public ImmutableTree<T> set(Path path, T t10) {
        if (path.isEmpty()) {
            return new ImmutableTree<>(t10, this.children);
        }
        ChildKey front = path.getFront();
        ImmutableTree immutableTree = this.children.get(front);
        if (immutableTree == null) {
            immutableTree = emptyInstance();
        }
        return new ImmutableTree<>(this.value, this.children.insert(front, immutableTree.set(path.popFront(), t10)));
    }

    public ImmutableTree<T> setTree(Path path, ImmutableTree<T> immutableTree) {
        ImmutableSortedMap<ChildKey, ImmutableTree<T>> immutableSortedMap;
        if (path.isEmpty()) {
            return immutableTree;
        }
        ChildKey front = path.getFront();
        ImmutableTree immutableTree2 = this.children.get(front);
        if (immutableTree2 == null) {
            immutableTree2 = emptyInstance();
        }
        ImmutableTree<T> tree = immutableTree2.setTree(path.popFront(), immutableTree);
        if (tree.isEmpty()) {
            immutableSortedMap = this.children.remove(front);
        } else {
            immutableSortedMap = this.children.insert(front, tree);
        }
        return new ImmutableTree<>(this.value, immutableSortedMap);
    }

    public ImmutableTree<T> subtree(Path path) {
        if (path.isEmpty()) {
            return this;
        }
        ImmutableTree immutableTree = this.children.get(path.getFront());
        if (immutableTree != null) {
            return immutableTree.subtree(path.popFront());
        }
        return emptyInstance();
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("ImmutableTree { value=");
        sb2.append(getValue());
        sb2.append(", children={");
        Iterator<Map.Entry<ChildKey, ImmutableTree<T>>> it = this.children.iterator();
        while (it.hasNext()) {
            Map.Entry next = it.next();
            sb2.append(((ChildKey) next.getKey()).asString());
            sb2.append("=");
            sb2.append(next.getValue());
        }
        sb2.append("} }");
        return sb2.toString();
    }

    public Collection<T> values() {
        final ArrayList arrayList = new ArrayList();
        foreach(new TreeVisitor<T, Void>() {
            public Void onNodeValue(Path path, T t10, Void voidR) {
                arrayList.add(t10);
                return null;
            }
        });
        return arrayList;
    }

    private <R> R fold(Path path, TreeVisitor<? super T, R> treeVisitor, R r10) {
        Iterator<Map.Entry<ChildKey, ImmutableTree<T>>> it = this.children.iterator();
        while (it.hasNext()) {
            Map.Entry next = it.next();
            r10 = ((ImmutableTree) next.getValue()).fold(path.child((ChildKey) next.getKey()), treeVisitor, r10);
        }
        T t10 = this.value;
        return t10 != null ? treeVisitor.onNodeValue(path, t10, r10) : r10;
    }

    public ImmutableTree(T t10) {
        this(t10, EMPTY_CHILDREN);
    }
}
