package com.google.firebase.crashlytics.internal.send;

import android.annotation.SuppressLint;
import android.database.SQLException;
import android.os.SystemClock;
import cd.c;
import cd.e;
import com.google.android.datatransport.Priority;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.CrashlyticsReportWithSessionId;
import com.google.firebase.crashlytics.internal.common.OnDemandCounter;
import com.google.firebase.crashlytics.internal.common.Utils;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.crashlytics.internal.settings.Settings;
import ed.l;
import java.util.Locale;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

final class ReportQueue {
    private static final int MAX_DELAY_MS = 3600000;
    private static final int MS_PER_MINUTE = 60000;
    private static final int MS_PER_SECOND = 1000;
    private static final int STARTUP_DURATION_MS = 2000;
    private final double base;
    private long lastUpdatedMs;
    /* access modifiers changed from: private */
    public final OnDemandCounter onDemandCounter;
    private final BlockingQueue<Runnable> queue;
    private final int queueCapacity;
    private final double ratePerMinute;
    private final ThreadPoolExecutor singleThreadExecutor;
    private final long startTimeMs;
    private int step;
    private final long stepDurationMs;
    private final e<CrashlyticsReport> transport;

    private final class ReportRunnable implements Runnable {
        private final CrashlyticsReportWithSessionId reportWithSessionId;
        private final TaskCompletionSource<CrashlyticsReportWithSessionId> tcs;

        public void run() {
            ReportQueue.this.sendReport(this.reportWithSessionId, this.tcs);
            ReportQueue.this.onDemandCounter.resetDroppedOnDemandExceptions();
            double access$300 = ReportQueue.this.calcDelay();
            Logger logger = Logger.getLogger();
            logger.d("Delay for: " + String.format(Locale.US, "%.2f", new Object[]{Double.valueOf(access$300 / 1000.0d)}) + " s for report: " + this.reportWithSessionId.getSessionId());
            ReportQueue.sleep(access$300);
        }

        private ReportRunnable(CrashlyticsReportWithSessionId crashlyticsReportWithSessionId, TaskCompletionSource<CrashlyticsReportWithSessionId> taskCompletionSource) {
            this.reportWithSessionId = crashlyticsReportWithSessionId;
            this.tcs = taskCompletionSource;
        }
    }

    ReportQueue(e<CrashlyticsReport> eVar, Settings settings, OnDemandCounter onDemandCounter2) {
        this(settings.onDemandUploadRatePerMinute, settings.onDemandBackoffBase, ((long) settings.onDemandBackoffStepDurationSeconds) * 1000, eVar, onDemandCounter2);
    }

    /* access modifiers changed from: private */
    public double calcDelay() {
        return Math.min(3600000.0d, (60000.0d / this.ratePerMinute) * Math.pow(this.base, (double) calcStep()));
    }

    private int calcStep() {
        int i10;
        if (this.lastUpdatedMs == 0) {
            this.lastUpdatedMs = now();
        }
        int now = (int) ((now() - this.lastUpdatedMs) / this.stepDurationMs);
        if (isQueueFull()) {
            i10 = Math.min(100, this.step + now);
        } else {
            i10 = Math.max(0, this.step - now);
        }
        if (this.step != i10) {
            this.step = i10;
            this.lastUpdatedMs = now();
        }
        return i10;
    }

    private boolean isQueueAvailable() {
        return this.queue.size() < this.queueCapacity;
    }

    private boolean isQueueFull() {
        return this.queue.size() == this.queueCapacity;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$flushScheduledReportsIfAble$0(CountDownLatch countDownLatch) {
        try {
            l.a(this.transport, Priority.HIGHEST);
        } catch (SQLException unused) {
        }
        countDownLatch.countDown();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$sendReport$1(TaskCompletionSource taskCompletionSource, boolean z10, CrashlyticsReportWithSessionId crashlyticsReportWithSessionId, Exception exc) {
        if (exc != null) {
            taskCompletionSource.trySetException(exc);
            return;
        }
        if (z10) {
            flushScheduledReportsIfAble();
        }
        taskCompletionSource.trySetResult(crashlyticsReportWithSessionId);
    }

    private long now() {
        return System.currentTimeMillis();
    }

    /* access modifiers changed from: private */
    public void sendReport(CrashlyticsReportWithSessionId crashlyticsReportWithSessionId, TaskCompletionSource<CrashlyticsReportWithSessionId> taskCompletionSource) {
        boolean z10;
        Logger logger = Logger.getLogger();
        logger.d("Sending report through Google DataTransport: " + crashlyticsReportWithSessionId.getSessionId());
        if (SystemClock.elapsedRealtime() - this.startTimeMs < 2000) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.transport.a(c.f(crashlyticsReportWithSessionId.getReport()), new b(this, taskCompletionSource, z10, crashlyticsReportWithSessionId));
    }

    /* access modifiers changed from: private */
    public static void sleep(double d10) {
        try {
            Thread.sleep((long) d10);
        } catch (InterruptedException unused) {
        }
    }

    /* access modifiers changed from: package-private */
    public TaskCompletionSource<CrashlyticsReportWithSessionId> enqueueReport(CrashlyticsReportWithSessionId crashlyticsReportWithSessionId, boolean z10) {
        synchronized (this.queue) {
            TaskCompletionSource<CrashlyticsReportWithSessionId> taskCompletionSource = new TaskCompletionSource<>();
            if (z10) {
                this.onDemandCounter.incrementRecordedOnDemandExceptions();
                if (isQueueAvailable()) {
                    Logger logger = Logger.getLogger();
                    logger.d("Enqueueing report: " + crashlyticsReportWithSessionId.getSessionId());
                    Logger logger2 = Logger.getLogger();
                    logger2.d("Queue size: " + this.queue.size());
                    this.singleThreadExecutor.execute(new ReportRunnable(crashlyticsReportWithSessionId, taskCompletionSource));
                    Logger logger3 = Logger.getLogger();
                    logger3.d("Closing task for report: " + crashlyticsReportWithSessionId.getSessionId());
                    taskCompletionSource.trySetResult(crashlyticsReportWithSessionId);
                    return taskCompletionSource;
                }
                calcStep();
                Logger logger4 = Logger.getLogger();
                logger4.d("Dropping report due to queue being full: " + crashlyticsReportWithSessionId.getSessionId());
                this.onDemandCounter.incrementDroppedOnDemandExceptions();
                taskCompletionSource.trySetResult(crashlyticsReportWithSessionId);
                return taskCompletionSource;
            }
            sendReport(crashlyticsReportWithSessionId, taskCompletionSource);
            return taskCompletionSource;
        }
    }

    @SuppressLint({"DiscouragedApi", "ThreadPoolCreation"})
    public void flushScheduledReportsIfAble() {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        new Thread(new c(this, countDownLatch)).start();
        Utils.awaitUninterruptibly(countDownLatch, 2, TimeUnit.SECONDS);
    }

    @SuppressLint({"ThreadPoolCreation"})
    ReportQueue(double d10, double d11, long j10, e<CrashlyticsReport> eVar, OnDemandCounter onDemandCounter2) {
        this.ratePerMinute = d10;
        this.base = d11;
        this.stepDurationMs = j10;
        this.transport = eVar;
        this.onDemandCounter = onDemandCounter2;
        this.startTimeMs = SystemClock.elapsedRealtime();
        int i10 = (int) d10;
        this.queueCapacity = i10;
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(i10);
        this.queue = arrayBlockingQueue;
        this.singleThreadExecutor = new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, arrayBlockingQueue);
        this.step = 0;
        this.lastUpdatedMs = 0;
    }
}
