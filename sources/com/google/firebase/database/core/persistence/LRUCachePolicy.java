package com.google.firebase.database.core.persistence;

public class LRUCachePolicy implements CachePolicy {
    private static final long MAX_NUMBER_OF_PRUNABLE_QUERIES_TO_KEEP = 1000;
    private static final float PERCENT_OF_QUERIES_TO_PRUNE_AT_ONCE = 0.2f;
    private static final long SERVER_UPDATES_BETWEEN_CACHE_SIZE_CHECKS = 1000;
    public final long maxSizeBytes;

    public LRUCachePolicy(long j10) {
        this.maxSizeBytes = j10;
    }

    public long getMaxNumberOfQueriesToKeep() {
        return 1000;
    }

    public float getPercentOfQueriesToPruneAtOnce() {
        return PERCENT_OF_QUERIES_TO_PRUNE_AT_ONCE;
    }

    public boolean shouldCheckCacheSize(long j10) {
        return j10 > 1000;
    }

    public boolean shouldPrune(long j10, long j11) {
        return j10 > this.maxSizeBytes || j11 > 1000;
    }
}
