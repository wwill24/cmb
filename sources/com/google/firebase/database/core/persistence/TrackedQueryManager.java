package com.google.firebase.database.core.persistence;

import com.google.firebase.database.core.Path;
import com.google.firebase.database.core.utilities.Clock;
import com.google.firebase.database.core.utilities.ImmutableTree;
import com.google.firebase.database.core.utilities.Predicate;
import com.google.firebase.database.core.utilities.Utilities;
import com.google.firebase.database.core.view.QueryParams;
import com.google.firebase.database.core.view.QuerySpec;
import com.google.firebase.database.logging.LogWrapper;
import com.google.firebase.database.snapshot.ChildKey;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TrackedQueryManager {
    private static final Predicate<Map<QueryParams, TrackedQuery>> HAS_ACTIVE_DEFAULT_PREDICATE = new Predicate<Map<QueryParams, TrackedQuery>>() {
        public boolean evaluate(Map<QueryParams, TrackedQuery> map) {
            TrackedQuery trackedQuery = map.get(QueryParams.DEFAULT_PARAMS);
            return trackedQuery != null && trackedQuery.active;
        }
    };
    private static final Predicate<Map<QueryParams, TrackedQuery>> HAS_DEFAULT_COMPLETE_PREDICATE = new Predicate<Map<QueryParams, TrackedQuery>>() {
        public boolean evaluate(Map<QueryParams, TrackedQuery> map) {
            TrackedQuery trackedQuery = map.get(QueryParams.DEFAULT_PARAMS);
            return trackedQuery != null && trackedQuery.complete;
        }
    };
    /* access modifiers changed from: private */
    public static final Predicate<TrackedQuery> IS_QUERY_PRUNABLE_PREDICATE = new Predicate<TrackedQuery>() {
        public boolean evaluate(TrackedQuery trackedQuery) {
            return !trackedQuery.active;
        }
    };
    private static final Predicate<TrackedQuery> IS_QUERY_UNPRUNABLE_PREDICATE = new Predicate<TrackedQuery>() {
        public boolean evaluate(TrackedQuery trackedQuery) {
            return !TrackedQueryManager.IS_QUERY_PRUNABLE_PREDICATE.evaluate(trackedQuery);
        }
    };
    private final Clock clock;
    private long currentQueryId = 0;
    private final LogWrapper logger;
    private final PersistenceStorageEngine storageLayer;
    private ImmutableTree<Map<QueryParams, TrackedQuery>> trackedQueryTree;

    public TrackedQueryManager(PersistenceStorageEngine persistenceStorageEngine, LogWrapper logWrapper, Clock clock2) {
        this.storageLayer = persistenceStorageEngine;
        this.logger = logWrapper;
        this.clock = clock2;
        this.trackedQueryTree = new ImmutableTree<>(null);
        resetPreviouslyActiveTrackedQueries();
        for (TrackedQuery next : persistenceStorageEngine.loadTrackedQueries()) {
            this.currentQueryId = Math.max(next.f21077id + 1, this.currentQueryId);
            cacheTrackedQuery(next);
        }
    }

    private static void assertValidTrackedQuery(QuerySpec querySpec) {
        boolean z10;
        if (!querySpec.loadsAllData() || querySpec.isDefault()) {
            z10 = true;
        } else {
            z10 = false;
        }
        Utilities.hardAssert(z10, "Can't have tracked non-default query that loads all data");
    }

    private void cacheTrackedQuery(TrackedQuery trackedQuery) {
        boolean z10;
        assertValidTrackedQuery(trackedQuery.querySpec);
        Map map = this.trackedQueryTree.get(trackedQuery.querySpec.getPath());
        if (map == null) {
            map = new HashMap();
            this.trackedQueryTree = this.trackedQueryTree.set(trackedQuery.querySpec.getPath(), map);
        }
        TrackedQuery trackedQuery2 = (TrackedQuery) map.get(trackedQuery.querySpec.getParams());
        if (trackedQuery2 == null || trackedQuery2.f21077id == trackedQuery.f21077id) {
            z10 = true;
        } else {
            z10 = false;
        }
        Utilities.hardAssert(z10);
        map.put(trackedQuery.querySpec.getParams(), trackedQuery);
    }

    private static long calculateCountToPrune(CachePolicy cachePolicy, long j10) {
        return j10 - Math.min((long) Math.floor((double) (((float) j10) * (1.0f - cachePolicy.getPercentOfQueriesToPruneAtOnce()))), cachePolicy.getMaxNumberOfQueriesToKeep());
    }

    private Set<Long> filteredQueryIdsAtPath(Path path) {
        HashSet hashSet = new HashSet();
        Map map = this.trackedQueryTree.get(path);
        if (map != null) {
            for (TrackedQuery trackedQuery : map.values()) {
                if (!trackedQuery.querySpec.loadsAllData()) {
                    hashSet.add(Long.valueOf(trackedQuery.f21077id));
                }
            }
        }
        return hashSet;
    }

    private List<TrackedQuery> getQueriesMatching(Predicate<TrackedQuery> predicate) {
        ArrayList arrayList = new ArrayList();
        Iterator<Map.Entry<Path, Map<QueryParams, TrackedQuery>>> it = this.trackedQueryTree.iterator();
        while (it.hasNext()) {
            for (TrackedQuery trackedQuery : ((Map) it.next().getValue()).values()) {
                if (predicate.evaluate(trackedQuery)) {
                    arrayList.add(trackedQuery);
                }
            }
        }
        return arrayList;
    }

    private boolean includedInDefaultCompleteQuery(Path path) {
        return this.trackedQueryTree.findRootMostMatchingPath(path, HAS_DEFAULT_COMPLETE_PREDICATE) != null;
    }

    private static QuerySpec normalizeQuery(QuerySpec querySpec) {
        return querySpec.loadsAllData() ? QuerySpec.defaultQueryAtPath(querySpec.getPath()) : querySpec;
    }

    private void resetPreviouslyActiveTrackedQueries() {
        try {
            this.storageLayer.beginTransaction();
            this.storageLayer.resetPreviouslyActiveTrackedQueries(this.clock.millis());
            this.storageLayer.setTransactionSuccessful();
        } finally {
            this.storageLayer.endTransaction();
        }
    }

    /* access modifiers changed from: private */
    public void saveTrackedQuery(TrackedQuery trackedQuery) {
        cacheTrackedQuery(trackedQuery);
        this.storageLayer.saveTrackedQuery(trackedQuery);
    }

    private void setQueryActiveFlag(QuerySpec querySpec, boolean z10) {
        TrackedQuery trackedQuery;
        QuerySpec normalizeQuery = normalizeQuery(querySpec);
        TrackedQuery findTrackedQuery = findTrackedQuery(normalizeQuery);
        long millis = this.clock.millis();
        if (findTrackedQuery != null) {
            trackedQuery = findTrackedQuery.updateLastUse(millis).setActiveState(z10);
        } else {
            Utilities.hardAssert(z10, "If we're setting the query to inactive, we should already be tracking it!");
            long j10 = this.currentQueryId;
            this.currentQueryId = 1 + j10;
            trackedQuery = new TrackedQuery(j10, normalizeQuery, millis, false, z10);
        }
        saveTrackedQuery(trackedQuery);
    }

    public long countOfPrunableQueries() {
        return (long) getQueriesMatching(IS_QUERY_PRUNABLE_PREDICATE).size();
    }

    public void ensureCompleteTrackedQuery(Path path) {
        TrackedQuery trackedQuery;
        if (!includedInDefaultCompleteQuery(path)) {
            QuerySpec defaultQueryAtPath = QuerySpec.defaultQueryAtPath(path);
            TrackedQuery findTrackedQuery = findTrackedQuery(defaultQueryAtPath);
            if (findTrackedQuery == null) {
                long j10 = this.currentQueryId;
                this.currentQueryId = 1 + j10;
                trackedQuery = new TrackedQuery(j10, defaultQueryAtPath, this.clock.millis(), true, false);
            } else {
                Utilities.hardAssert(!findTrackedQuery.complete, "This should have been handled above!");
                trackedQuery = findTrackedQuery.setComplete();
            }
            saveTrackedQuery(trackedQuery);
        }
    }

    public TrackedQuery findTrackedQuery(QuerySpec querySpec) {
        QuerySpec normalizeQuery = normalizeQuery(querySpec);
        Map map = this.trackedQueryTree.get(normalizeQuery.getPath());
        if (map != null) {
            return (TrackedQuery) map.get(normalizeQuery.getParams());
        }
        return null;
    }

    public Set<ChildKey> getKnownCompleteChildren(Path path) {
        Utilities.hardAssert(!isQueryComplete(QuerySpec.defaultQueryAtPath(path)), "Path is fully complete.");
        HashSet hashSet = new HashSet();
        Set<Long> filteredQueryIdsAtPath = filteredQueryIdsAtPath(path);
        if (!filteredQueryIdsAtPath.isEmpty()) {
            hashSet.addAll(this.storageLayer.loadTrackedQueryKeys(filteredQueryIdsAtPath));
        }
        Iterator<Map.Entry<ChildKey, ImmutableTree<Map<QueryParams, TrackedQuery>>>> it = this.trackedQueryTree.subtree(path).getChildren().iterator();
        while (it.hasNext()) {
            Map.Entry next = it.next();
            ChildKey childKey = (ChildKey) next.getKey();
            ImmutableTree immutableTree = (ImmutableTree) next.getValue();
            if (immutableTree.getValue() != null && HAS_DEFAULT_COMPLETE_PREDICATE.evaluate((Map) immutableTree.getValue())) {
                hashSet.add(childKey);
            }
        }
        return hashSet;
    }

    public boolean hasActiveDefaultQuery(Path path) {
        return this.trackedQueryTree.rootMostValueMatching(path, HAS_ACTIVE_DEFAULT_PREDICATE) != null;
    }

    public boolean isQueryComplete(QuerySpec querySpec) {
        if (includedInDefaultCompleteQuery(querySpec.getPath())) {
            return true;
        }
        if (querySpec.loadsAllData()) {
            return false;
        }
        Map map = this.trackedQueryTree.get(querySpec.getPath());
        if (map == null || !map.containsKey(querySpec.getParams()) || !((TrackedQuery) map.get(querySpec.getParams())).complete) {
            return false;
        }
        return true;
    }

    public PruneForest pruneOldQueries(CachePolicy cachePolicy) {
        List<TrackedQuery> queriesMatching = getQueriesMatching(IS_QUERY_PRUNABLE_PREDICATE);
        long calculateCountToPrune = calculateCountToPrune(cachePolicy, (long) queriesMatching.size());
        PruneForest pruneForest = new PruneForest();
        if (this.logger.logsDebug()) {
            this.logger.debug("Pruning old queries.  Prunable: " + queriesMatching.size() + " Count to prune: " + calculateCountToPrune, new Object[0]);
        }
        Collections.sort(queriesMatching, new Comparator<TrackedQuery>() {
            public int compare(TrackedQuery trackedQuery, TrackedQuery trackedQuery2) {
                return Utilities.compareLongs(trackedQuery.lastUse, trackedQuery2.lastUse);
            }
        });
        for (int i10 = 0; ((long) i10) < calculateCountToPrune; i10++) {
            TrackedQuery trackedQuery = queriesMatching.get(i10);
            pruneForest = pruneForest.prune(trackedQuery.querySpec.getPath());
            removeTrackedQuery(trackedQuery.querySpec);
        }
        for (int i11 = (int) calculateCountToPrune; i11 < queriesMatching.size(); i11++) {
            pruneForest = pruneForest.keep(queriesMatching.get(i11).querySpec.getPath());
        }
        List<TrackedQuery> queriesMatching2 = getQueriesMatching(IS_QUERY_UNPRUNABLE_PREDICATE);
        if (this.logger.logsDebug()) {
            this.logger.debug("Unprunable queries: " + queriesMatching2.size(), new Object[0]);
        }
        for (TrackedQuery trackedQuery2 : queriesMatching2) {
            pruneForest = pruneForest.keep(trackedQuery2.querySpec.getPath());
        }
        return pruneForest;
    }

    public void removeTrackedQuery(QuerySpec querySpec) {
        boolean z10;
        QuerySpec normalizeQuery = normalizeQuery(querySpec);
        TrackedQuery findTrackedQuery = findTrackedQuery(normalizeQuery);
        if (findTrackedQuery != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        Utilities.hardAssert(z10, "Query must exist to be removed.");
        this.storageLayer.deleteTrackedQuery(findTrackedQuery.f21077id);
        Map map = this.trackedQueryTree.get(normalizeQuery.getPath());
        map.remove(normalizeQuery.getParams());
        if (map.isEmpty()) {
            this.trackedQueryTree = this.trackedQueryTree.remove(normalizeQuery.getPath());
        }
    }

    public void setQueriesComplete(Path path) {
        this.trackedQueryTree.subtree(path).foreach(new ImmutableTree.TreeVisitor<Map<QueryParams, TrackedQuery>, Void>() {
            public Void onNodeValue(Path path, Map<QueryParams, TrackedQuery> map, Void voidR) {
                for (Map.Entry<QueryParams, TrackedQuery> value : map.entrySet()) {
                    TrackedQuery trackedQuery = (TrackedQuery) value.getValue();
                    if (!trackedQuery.complete) {
                        TrackedQueryManager.this.saveTrackedQuery(trackedQuery.setComplete());
                    }
                }
                return null;
            }
        });
    }

    public void setQueryActive(QuerySpec querySpec) {
        setQueryActiveFlag(querySpec, true);
    }

    public void setQueryCompleteIfExists(QuerySpec querySpec) {
        TrackedQuery findTrackedQuery = findTrackedQuery(normalizeQuery(querySpec));
        if (findTrackedQuery != null && !findTrackedQuery.complete) {
            saveTrackedQuery(findTrackedQuery.setComplete());
        }
    }

    public void setQueryInactive(QuerySpec querySpec) {
        setQueryActiveFlag(querySpec, false);
    }

    /* access modifiers changed from: package-private */
    public void verifyCache() {
        List<TrackedQuery> loadTrackedQueries = this.storageLayer.loadTrackedQueries();
        final ArrayList arrayList = new ArrayList();
        this.trackedQueryTree.foreach(new ImmutableTree.TreeVisitor<Map<QueryParams, TrackedQuery>, Void>() {
            public Void onNodeValue(Path path, Map<QueryParams, TrackedQuery> map, Void voidR) {
                for (TrackedQuery add : map.values()) {
                    arrayList.add(add);
                }
                return null;
            }
        });
        Collections.sort(arrayList, new Comparator<TrackedQuery>() {
            public int compare(TrackedQuery trackedQuery, TrackedQuery trackedQuery2) {
                return Utilities.compareLongs(trackedQuery.f21077id, trackedQuery2.f21077id);
            }
        });
        boolean equals = loadTrackedQueries.equals(arrayList);
        Utilities.hardAssert(equals, "Tracked queries out of sync.  Tracked queries: " + arrayList + " Stored queries: " + loadTrackedQueries);
    }
}
