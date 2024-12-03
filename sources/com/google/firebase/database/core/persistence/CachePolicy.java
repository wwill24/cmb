package com.google.firebase.database.core.persistence;

public interface CachePolicy {
    public static final CachePolicy NONE = new CachePolicy() {
        public long getMaxNumberOfQueriesToKeep() {
            return Long.MAX_VALUE;
        }

        public float getPercentOfQueriesToPruneAtOnce() {
            return 0.0f;
        }

        public boolean shouldCheckCacheSize(long j10) {
            return false;
        }

        public boolean shouldPrune(long j10, long j11) {
            return false;
        }
    };

    long getMaxNumberOfQueriesToKeep();

    float getPercentOfQueriesToPruneAtOnce();

    boolean shouldCheckCacheSize(long j10);

    boolean shouldPrune(long j10, long j11);
}
