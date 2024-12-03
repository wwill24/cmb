package com.google.firebase.perf.session.gauges;

import android.annotation.SuppressLint;
import android.os.Process;
import android.system.Os;
import android.system.OsConstants;
import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.util.Timer;
import com.google.firebase.perf.v1.CpuMetricReading;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class CpuGaugeCollector {
    private static final int CSTIME_POSITION_IN_PROC_PID_STAT = 16;
    private static final int CUTIME_POSITION_IN_PROC_PID_STAT = 15;
    public static final long INVALID_CPU_COLLECTION_FREQUENCY = -1;
    private static final int INVALID_SC_PER_CPU_CLOCK_TICK = -1;
    private static final long MICROSECONDS_PER_SECOND = TimeUnit.SECONDS.toMicros(1);
    private static final int STIME_POSITION_IN_PROC_PID_STAT = 14;
    private static final int UNSET_CPU_METRIC_COLLECTION_RATE = -1;
    private static final int UTIME_POSITION_IN_PROC_PID_STAT = 13;
    private static final AndroidLogger logger = AndroidLogger.getInstance();
    private final long clockTicksPerSecond;
    private long cpuMetricCollectionRateMs;
    private final ScheduledExecutorService cpuMetricCollectorExecutor;
    private ScheduledFuture cpuMetricCollectorJob;
    public final ConcurrentLinkedQueue<CpuMetricReading> cpuMetricReadings;
    private final String procFileName;

    @SuppressLint({"ThreadPoolCreation"})
    CpuGaugeCollector() {
        this.cpuMetricCollectorJob = null;
        this.cpuMetricCollectionRateMs = -1;
        this.cpuMetricReadings = new ConcurrentLinkedQueue<>();
        this.cpuMetricCollectorExecutor = Executors.newSingleThreadScheduledExecutor();
        int myPid = Process.myPid();
        this.procFileName = "/proc/" + Integer.toString(myPid) + "/stat";
        this.clockTicksPerSecond = getClockTicksPerSecond();
    }

    private long convertClockTicksToMicroseconds(long j10) {
        return Math.round((((double) j10) / ((double) this.clockTicksPerSecond)) * ((double) MICROSECONDS_PER_SECOND));
    }

    private long getClockTicksPerSecond() {
        return Os.sysconf(OsConstants._SC_CLK_TCK);
    }

    public static boolean isInvalidCollectionFrequency(long j10) {
        return j10 <= 0;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$scheduleCpuMetricCollectionOnce$1(Timer timer) {
        CpuMetricReading syncCollectCpuMetric = syncCollectCpuMetric(timer);
        if (syncCollectCpuMetric != null) {
            this.cpuMetricReadings.add(syncCollectCpuMetric);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$scheduleCpuMetricCollectionWithRate$0(Timer timer) {
        CpuMetricReading syncCollectCpuMetric = syncCollectCpuMetric(timer);
        if (syncCollectCpuMetric != null) {
            this.cpuMetricReadings.add(syncCollectCpuMetric);
        }
    }

    private synchronized void scheduleCpuMetricCollectionOnce(Timer timer) {
        try {
            this.cpuMetricCollectorExecutor.schedule(new b(this, timer), 0, TimeUnit.MILLISECONDS);
        } catch (RejectedExecutionException e10) {
            AndroidLogger androidLogger = logger;
            androidLogger.warn("Unable to collect Cpu Metric: " + e10.getMessage());
        }
        return;
    }

    private synchronized void scheduleCpuMetricCollectionWithRate(long j10, Timer timer) {
        this.cpuMetricCollectionRateMs = j10;
        try {
            this.cpuMetricCollectorJob = this.cpuMetricCollectorExecutor.scheduleAtFixedRate(new a(this, timer), 0, j10, TimeUnit.MILLISECONDS);
        } catch (RejectedExecutionException e10) {
            AndroidLogger androidLogger = logger;
            androidLogger.warn("Unable to start collecting Cpu Metrics: " + e10.getMessage());
        }
        return;
    }

    private CpuMetricReading syncCollectCpuMetric(Timer timer) {
        BufferedReader bufferedReader;
        if (timer == null) {
            return null;
        }
        try {
            bufferedReader = new BufferedReader(new FileReader(this.procFileName));
            long currentTimestampMicros = timer.getCurrentTimestampMicros();
            String[] split = bufferedReader.readLine().split(" ");
            long parseLong = Long.parseLong(split[13]);
            long parseLong2 = Long.parseLong(split[15]);
            CpuMetricReading cpuMetricReading = (CpuMetricReading) CpuMetricReading.newBuilder().setClientTimeUs(currentTimestampMicros).setSystemTimeUs(convertClockTicksToMicroseconds(Long.parseLong(split[14]) + Long.parseLong(split[16]))).setUserTimeUs(convertClockTicksToMicroseconds(parseLong + parseLong2)).build();
            bufferedReader.close();
            return cpuMetricReading;
        } catch (IOException e10) {
            AndroidLogger androidLogger = logger;
            androidLogger.warn("Unable to read 'proc/[pid]/stat' file: " + e10.getMessage());
            return null;
        } catch (ArrayIndexOutOfBoundsException | NullPointerException | NumberFormatException e11) {
            AndroidLogger androidLogger2 = logger;
            androidLogger2.warn("Unexpected '/proc/[pid]/stat' file format encountered: " + e11.getMessage());
            return null;
        } catch (Throwable th2) {
            th.addSuppressed(th2);
        }
        throw th;
    }

    public void collectOnce(Timer timer) {
        scheduleCpuMetricCollectionOnce(timer);
    }

    public void startCollecting(long j10, Timer timer) {
        long j11 = this.clockTicksPerSecond;
        if (j11 != -1 && j11 != 0 && !isInvalidCollectionFrequency(j10)) {
            if (this.cpuMetricCollectorJob == null) {
                scheduleCpuMetricCollectionWithRate(j10, timer);
            } else if (this.cpuMetricCollectionRateMs != j10) {
                stopCollecting();
                scheduleCpuMetricCollectionWithRate(j10, timer);
            }
        }
    }

    public void stopCollecting() {
        ScheduledFuture scheduledFuture = this.cpuMetricCollectorJob;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
            this.cpuMetricCollectorJob = null;
            this.cpuMetricCollectionRateMs = -1;
        }
    }

    CpuGaugeCollector(ScheduledExecutorService scheduledExecutorService, String str, long j10) {
        this.cpuMetricCollectorJob = null;
        this.cpuMetricCollectionRateMs = -1;
        this.cpuMetricReadings = new ConcurrentLinkedQueue<>();
        this.cpuMetricCollectorExecutor = scheduledExecutorService;
        this.procFileName = str;
        this.clockTicksPerSecond = j10;
    }
}
