package com.google.firebase.database.core.persistence;

import com.google.firebase.database.core.CompoundWrite;
import com.google.firebase.database.core.Context;
import com.google.firebase.database.core.Path;
import com.google.firebase.database.core.UserWriteRecord;
import com.google.firebase.database.core.utilities.Clock;
import com.google.firebase.database.core.utilities.DefaultClock;
import com.google.firebase.database.core.utilities.Utilities;
import com.google.firebase.database.core.view.CacheNode;
import com.google.firebase.database.core.view.QuerySpec;
import com.google.firebase.database.logging.LogWrapper;
import com.google.firebase.database.snapshot.ChildKey;
import com.google.firebase.database.snapshot.EmptyNode;
import com.google.firebase.database.snapshot.IndexedNode;
import com.google.firebase.database.snapshot.Node;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;

public class DefaultPersistenceManager implements PersistenceManager {
    private final CachePolicy cachePolicy;
    private final LogWrapper logger;
    private long serverCacheUpdatesSinceLastPruneCheck;
    private final PersistenceStorageEngine storageLayer;
    private final TrackedQueryManager trackedQueryManager;

    public DefaultPersistenceManager(Context context, PersistenceStorageEngine persistenceStorageEngine, CachePolicy cachePolicy2) {
        this(context, persistenceStorageEngine, cachePolicy2, new DefaultClock());
    }

    private void doPruneCheckAfterServerUpdate() {
        long j10 = this.serverCacheUpdatesSinceLastPruneCheck + 1;
        this.serverCacheUpdatesSinceLastPruneCheck = j10;
        if (this.cachePolicy.shouldCheckCacheSize(j10)) {
            if (this.logger.logsDebug()) {
                this.logger.debug("Reached prune check threshold.", new Object[0]);
            }
            this.serverCacheUpdatesSinceLastPruneCheck = 0;
            boolean z10 = true;
            long serverCacheEstimatedSizeInBytes = this.storageLayer.serverCacheEstimatedSizeInBytes();
            if (this.logger.logsDebug()) {
                this.logger.debug("Cache size: " + serverCacheEstimatedSizeInBytes, new Object[0]);
            }
            while (z10 && this.cachePolicy.shouldPrune(serverCacheEstimatedSizeInBytes, this.trackedQueryManager.countOfPrunableQueries())) {
                PruneForest pruneOldQueries = this.trackedQueryManager.pruneOldQueries(this.cachePolicy);
                if (pruneOldQueries.prunesAnything()) {
                    this.storageLayer.pruneCache(Path.getEmptyPath(), pruneOldQueries);
                } else {
                    z10 = false;
                }
                serverCacheEstimatedSizeInBytes = this.storageLayer.serverCacheEstimatedSizeInBytes();
                if (this.logger.logsDebug()) {
                    this.logger.debug("Cache size after prune: " + serverCacheEstimatedSizeInBytes, new Object[0]);
                }
            }
        }
    }

    public void applyUserWriteToServerCache(Path path, Node node) {
        if (!this.trackedQueryManager.hasActiveDefaultQuery(path)) {
            this.storageLayer.overwriteServerCache(path, node);
            this.trackedQueryManager.ensureCompleteTrackedQuery(path);
        }
    }

    public List<UserWriteRecord> loadUserWrites() {
        return this.storageLayer.loadUserWrites();
    }

    public void removeAllUserWrites() {
        this.storageLayer.removeAllUserWrites();
    }

    public void removeUserWrite(long j10) {
        this.storageLayer.removeUserWrite(j10);
    }

    public <T> T runInTransaction(Callable<T> callable) {
        this.storageLayer.beginTransaction();
        try {
            T call = callable.call();
            this.storageLayer.setTransactionSuccessful();
            this.storageLayer.endTransaction();
            return call;
        } catch (Throwable th2) {
            this.storageLayer.endTransaction();
            throw th2;
        }
    }

    public void saveUserMerge(Path path, CompoundWrite compoundWrite, long j10) {
        this.storageLayer.saveUserMerge(path, compoundWrite, j10);
    }

    public void saveUserOverwrite(Path path, Node node, long j10) {
        this.storageLayer.saveUserOverwrite(path, node, j10);
    }

    public CacheNode serverCache(QuerySpec querySpec) {
        boolean z10;
        Set<ChildKey> set;
        if (this.trackedQueryManager.isQueryComplete(querySpec)) {
            TrackedQuery findTrackedQuery = this.trackedQueryManager.findTrackedQuery(querySpec);
            if (querySpec.loadsAllData() || findTrackedQuery == null || !findTrackedQuery.complete) {
                set = null;
            } else {
                set = this.storageLayer.loadTrackedQueryKeys(findTrackedQuery.f21077id);
            }
            z10 = true;
        } else {
            set = this.trackedQueryManager.getKnownCompleteChildren(querySpec.getPath());
            z10 = false;
        }
        Node serverCache = this.storageLayer.serverCache(querySpec.getPath());
        if (set == null) {
            return new CacheNode(IndexedNode.from(serverCache, querySpec.getIndex()), z10, false);
        }
        Node Empty = EmptyNode.Empty();
        for (ChildKey next : set) {
            Empty = Empty.updateImmediateChild(next, serverCache.getImmediateChild(next));
        }
        return new CacheNode(IndexedNode.from(Empty, querySpec.getIndex()), z10, true);
    }

    public void setQueryActive(QuerySpec querySpec) {
        this.trackedQueryManager.setQueryActive(querySpec);
    }

    public void setQueryComplete(QuerySpec querySpec) {
        if (querySpec.loadsAllData()) {
            this.trackedQueryManager.setQueriesComplete(querySpec.getPath());
        } else {
            this.trackedQueryManager.setQueryCompleteIfExists(querySpec);
        }
    }

    public void setQueryInactive(QuerySpec querySpec) {
        this.trackedQueryManager.setQueryInactive(querySpec);
    }

    public void setTrackedQueryKeys(QuerySpec querySpec, Set<ChildKey> set) {
        boolean z10 = true;
        Utilities.hardAssert(!querySpec.loadsAllData(), "We should only track keys for filtered queries.");
        TrackedQuery findTrackedQuery = this.trackedQueryManager.findTrackedQuery(querySpec);
        if (findTrackedQuery == null || !findTrackedQuery.active) {
            z10 = false;
        }
        Utilities.hardAssert(z10, "We only expect tracked keys for currently-active queries.");
        this.storageLayer.saveTrackedQueryKeys(findTrackedQuery.f21077id, set);
    }

    public void updateServerCache(QuerySpec querySpec, Node node) {
        if (querySpec.loadsAllData()) {
            this.storageLayer.overwriteServerCache(querySpec.getPath(), node);
        } else {
            this.storageLayer.mergeIntoServerCache(querySpec.getPath(), node);
        }
        setQueryComplete(querySpec);
        doPruneCheckAfterServerUpdate();
    }

    public void updateTrackedQueryKeys(QuerySpec querySpec, Set<ChildKey> set, Set<ChildKey> set2) {
        boolean z10 = true;
        Utilities.hardAssert(!querySpec.loadsAllData(), "We should only track keys for filtered queries.");
        TrackedQuery findTrackedQuery = this.trackedQueryManager.findTrackedQuery(querySpec);
        if (findTrackedQuery == null || !findTrackedQuery.active) {
            z10 = false;
        }
        Utilities.hardAssert(z10, "We only expect tracked keys for currently-active queries.");
        this.storageLayer.updateTrackedQueryKeys(findTrackedQuery.f21077id, set, set2);
    }

    public DefaultPersistenceManager(Context context, PersistenceStorageEngine persistenceStorageEngine, CachePolicy cachePolicy2, Clock clock) {
        this.serverCacheUpdatesSinceLastPruneCheck = 0;
        this.storageLayer = persistenceStorageEngine;
        LogWrapper logger2 = context.getLogger("Persistence");
        this.logger = logger2;
        this.trackedQueryManager = new TrackedQueryManager(persistenceStorageEngine, logger2, clock);
        this.cachePolicy = cachePolicy2;
    }

    public void applyUserWriteToServerCache(Path path, CompoundWrite compoundWrite) {
        Iterator<Map.Entry<Path, Node>> it = compoundWrite.iterator();
        while (it.hasNext()) {
            Map.Entry next = it.next();
            applyUserWriteToServerCache(path.child((Path) next.getKey()), (Node) next.getValue());
        }
    }

    public void updateServerCache(Path path, CompoundWrite compoundWrite) {
        this.storageLayer.mergeIntoServerCache(path, compoundWrite);
        doPruneCheckAfterServerUpdate();
    }
}
