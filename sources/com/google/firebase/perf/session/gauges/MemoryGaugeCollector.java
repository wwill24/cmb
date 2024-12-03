package com.google.firebase.perf.session.gauges;

import android.annotation.SuppressLint;
import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.util.StorageUnit;
import com.google.firebase.perf.util.Timer;
import com.google.firebase.perf.util.Utils;
import com.google.firebase.perf.v1.AndroidMemoryReading;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class MemoryGaugeCollector {
    public static final long INVALID_MEMORY_COLLECTION_FREQUENCY = -1;
    private static final int UNSET_MEMORY_METRIC_COLLECTION_RATE = -1;
    private static final AndroidLogger logger = AndroidLogger.getInstance();
    private long memoryMetricCollectionRateMs;
    private final ScheduledExecutorService memoryMetricCollectorExecutor;
    private ScheduledFuture memoryMetricCollectorJob;
    public final ConcurrentLinkedQueue<AndroidMemoryReading> memoryMetricReadings;
    private final Runtime runtime;

    @SuppressLint({"ThreadPoolCreation"})
    MemoryGaugeCollector() {
        this(Executors.newSingleThreadScheduledExecutor(), Runtime.getRuntime());
    }

    private int getCurrentUsedAppJavaHeapMemoryKb() {
        return Utils.saturatedIntCast(StorageUnit.BYTES.toKilobytes(this.runtime.totalMemory() - this.runtime.freeMemory()));
    }

    public static boolean isInvalidCollectionFrequency(long j10) {
        return j10 <= 0;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$scheduleMemoryMetricCollectionOnce$1(Timer timer) {
        AndroidMemoryReading syncCollectMemoryMetric = syncCollectMemoryMetric(timer);
        if (syncCollectMemoryMetric != null) {
            this.memoryMetricReadings.add(syncCollectMemoryMetric);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$scheduleMemoryMetricCollectionWithRate$0(Timer timer) {
        AndroidMemoryReading syncCollectMemoryMetric = syncCollectMemoryMetric(timer);
        if (syncCollectMemoryMetric != null) {
            this.memoryMetricReadings.add(syncCollectMemoryMetric);
        }
    }

    private synchronized void scheduleMemoryMetricCollectionOnce(Timer timer) {
        try {
            this.memoryMetricCollectorExecutor.schedule(new i(this, timer), 0, TimeUnit.MILLISECONDS);
        } catch (RejectedExecutionException e10) {
            AndroidLogger androidLogger = logger;
            androidLogger.warn("Unable to collect Memory Metric: " + e10.getMessage());
        }
        return;
    }

    private synchronized void scheduleMemoryMetricCollectionWithRate(long j10, Timer timer) {
        this.memoryMetricCollectionRateMs = j10;
        try {
            this.memoryMetricCollectorJob = this.memoryMetricCollectorExecutor.scheduleAtFixedRate(new h(this, timer), 0, j10, TimeUnit.MILLISECONDS);
        } catch (RejectedExecutionException e10) {
            AndroidLogger androidLogger = logger;
            androidLogger.warn("Unable to start collecting Memory Metrics: " + e10.getMessage());
        }
        return;
    }

    private AndroidMemoryReading syncCollectMemoryMetric(Timer timer) {
        if (timer == null) {
            return null;
        }
        return (AndroidMemoryReading) AndroidMemoryReading.newBuilder().setClientTimeUs(timer.getCurrentTimestampMicros()).setUsedAppJavaHeapMemoryKb(getCurrentUsedAppJavaHeapMemoryKb()).build();
    }

    public void collectOnce(Timer timer) {
        scheduleMemoryMetricCollectionOnce(timer);
    }

    public void startCollecting(long j10, Timer timer) {
        if (!isInvalidCollectionFrequency(j10)) {
            if (this.memoryMetricCollectorJob == null) {
                scheduleMemoryMetricCollectionWithRate(j10, timer);
            } else if (this.memoryMetricCollectionRateMs != j10) {
                stopCollecting();
                scheduleMemoryMetricCollectionWithRate(j10, timer);
            }
        }
    }

    public void stopCollecting() {
        ScheduledFuture scheduledFuture = this.memoryMetricCollectorJob;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
            this.memoryMetricCollectorJob = null;
            this.memoryMetricCollectionRateMs = -1;
        }
    }

    MemoryGaugeCollector(ScheduledExecutorService scheduledExecutorService, Runtime runtime2) {
        this.memoryMetricCollectorJob = null;
        this.memoryMetricCollectionRateMs = -1;
        this.memoryMetricCollectorExecutor = scheduledExecutorService;
        this.memoryMetricReadings = new ConcurrentLinkedQueue<>();
        this.runtime = runtime2;
    }
}
