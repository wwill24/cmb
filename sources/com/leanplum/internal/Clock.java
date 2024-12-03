package com.leanplum.internal;

import androidx.annotation.NonNull;
import java.util.Date;

public abstract class Clock {
    public static final long DAY_MILLIS = 86400000;
    private static Clock INSTANCE = null;
    public static final long MONTH_MILLIS = 2592000000L;
    public static final Clock SYSTEM;

    static {
        AnonymousClass1 r02 = new Clock() {
            /* access modifiers changed from: package-private */
            public long currentTimeMillis() {
                return System.currentTimeMillis();
            }

            /* access modifiers changed from: package-private */
            @NonNull
            public Date newDate() {
                return new Date();
            }
        };
        SYSTEM = r02;
        INSTANCE = r02;
    }

    public static Clock getInstance() {
        return INSTANCE;
    }

    static void setInstance(Clock clock) {
        INSTANCE = clock;
    }

    /* access modifiers changed from: package-private */
    public abstract long currentTimeMillis();

    public boolean lessThanMonthAgo(long j10) {
        return currentTimeMillis() - j10 < MONTH_MILLIS;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public abstract Date newDate();
}
