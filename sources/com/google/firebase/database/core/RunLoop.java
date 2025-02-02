package com.google.firebase.database.core;

import java.util.concurrent.ScheduledFuture;

public interface RunLoop {
    void restart();

    ScheduledFuture schedule(Runnable runnable, long j10);

    void scheduleNow(Runnable runnable);

    void shutdown();
}
