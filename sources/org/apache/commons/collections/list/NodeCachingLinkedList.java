package org.apache.commons.collections.list;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import org.apache.commons.collections.list.AbstractLinkedList;

public class NodeCachingLinkedList extends AbstractLinkedList implements Serializable {
    protected static final int DEFAULT_MAXIMUM_CACHE_SIZE = 20;
    private static final long serialVersionUID = 6897789178562232073L;
    protected transient int cacheSize;
    protected transient AbstractLinkedList.Node firstCachedNode;
    protected int maximumCacheSize;

    public NodeCachingLinkedList() {
        this(20);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        doReadObject(objectInputStream);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        doWriteObject(objectOutputStream);
    }

    /* access modifiers changed from: protected */
    public void addNodeToCache(AbstractLinkedList.Node node) {
        if (!isCacheFull()) {
            AbstractLinkedList.Node node2 = this.firstCachedNode;
            node.previous = null;
            node.next = node2;
            node.setValue((Object) null);
            this.firstCachedNode = node;
            this.cacheSize++;
        }
    }

    /* access modifiers changed from: protected */
    public AbstractLinkedList.Node createNode(Object obj) {
        AbstractLinkedList.Node nodeFromCache = getNodeFromCache();
        if (nodeFromCache == null) {
            return super.createNode(obj);
        }
        nodeFromCache.setValue(obj);
        return nodeFromCache;
    }

    /* access modifiers changed from: protected */
    public int getMaximumCacheSize() {
        return this.maximumCacheSize;
    }

    /* access modifiers changed from: protected */
    public AbstractLinkedList.Node getNodeFromCache() {
        int i10 = this.cacheSize;
        if (i10 == 0) {
            return null;
        }
        AbstractLinkedList.Node node = this.firstCachedNode;
        this.firstCachedNode = node.next;
        node.next = null;
        this.cacheSize = i10 - 1;
        return node;
    }

    /* access modifiers changed from: protected */
    public boolean isCacheFull() {
        return this.cacheSize >= this.maximumCacheSize;
    }

    /* access modifiers changed from: protected */
    public void removeAllNodes() {
        int min = Math.min(this.size, this.maximumCacheSize - this.cacheSize);
        AbstractLinkedList.Node node = this.header.next;
        int i10 = 0;
        while (i10 < min) {
            AbstractLinkedList.Node node2 = node.next;
            addNodeToCache(node);
            i10++;
            node = node2;
        }
        super.removeAllNodes();
    }

    /* access modifiers changed from: protected */
    public void removeNode(AbstractLinkedList.Node node) {
        super.removeNode(node);
        addNodeToCache(node);
    }

    /* access modifiers changed from: protected */
    public void setMaximumCacheSize(int i10) {
        this.maximumCacheSize = i10;
        shrinkCacheToMaximumSize();
    }

    /* access modifiers changed from: protected */
    public void shrinkCacheToMaximumSize() {
        while (this.cacheSize > this.maximumCacheSize) {
            getNodeFromCache();
        }
    }

    public NodeCachingLinkedList(Collection collection) {
        super(collection);
        this.maximumCacheSize = 20;
    }

    public NodeCachingLinkedList(int i10) {
        this.maximumCacheSize = i10;
        init();
    }
}
