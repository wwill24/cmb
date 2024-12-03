package com.google.firebase.perf.transport;

import android.content.Context;
import androidx.annotation.NonNull;
import com.google.firebase.perf.config.ConfigResolver;
import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.metrics.resource.ResourceType;
import com.google.firebase.perf.util.Clock;
import com.google.firebase.perf.util.Constants;
import com.google.firebase.perf.util.Rate;
import com.google.firebase.perf.util.Timer;
import com.google.firebase.perf.util.Utils;
import com.google.firebase.perf.v1.PerfMetric;
import com.google.firebase.perf.v1.PerfSession;
import com.google.firebase.perf.v1.SessionVerbosity;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

final class RateLimiter {
    private final ConfigResolver configResolver;
    private final double fragmentBucketId;
    private boolean isLogcatEnabled;
    private RateLimiterImpl networkLimiter;
    private final double samplingBucketId;
    private RateLimiterImpl traceLimiter;

    static class RateLimiterImpl {
        private static final long MICROS_IN_A_SECOND = TimeUnit.SECONDS.toMicros(1);
        private static final AndroidLogger logger = AndroidLogger.getInstance();
        private long backgroundCapacity;
        private Rate backgroundRate;
        private long capacity;
        private final Clock clock;
        private long foregroundCapacity;
        private Rate foregroundRate;
        private final boolean isLogcatEnabled;
        private Timer lastTimeTokenReplenished;
        private Rate rate;
        private double tokenCount;

        RateLimiterImpl(Rate rate2, long j10, Clock clock2, ConfigResolver configResolver, @ResourceType String str, boolean z10) {
            this.clock = clock2;
            this.capacity = j10;
            this.rate = rate2;
            this.tokenCount = (double) j10;
            this.lastTimeTokenReplenished = clock2.getTime();
            setRateByReadingRemoteConfigValues(configResolver, str, z10);
            this.isLogcatEnabled = z10;
        }

        private static long getBlimitEvents(ConfigResolver configResolver, @ResourceType String str) {
            if (str == ResourceType.TRACE) {
                return configResolver.getTraceEventCountBackground();
            }
            return configResolver.getNetworkEventCountBackground();
        }

        private static long getBlimitSec(ConfigResolver configResolver, @ResourceType String str) {
            if (str == ResourceType.TRACE) {
                return configResolver.getRateLimitSec();
            }
            return configResolver.getRateLimitSec();
        }

        private static long getFlimitEvents(ConfigResolver configResolver, @ResourceType String str) {
            if (str == ResourceType.TRACE) {
                return configResolver.getTraceEventCountForeground();
            }
            return configResolver.getNetworkEventCountForeground();
        }

        private static long getFlimitSec(ConfigResolver configResolver, @ResourceType String str) {
            if (str == ResourceType.TRACE) {
                return configResolver.getRateLimitSec();
            }
            return configResolver.getRateLimitSec();
        }

        private void setRateByReadingRemoteConfigValues(ConfigResolver configResolver, @ResourceType String str, boolean z10) {
            long flimitSec = getFlimitSec(configResolver, str);
            long flimitEvents = getFlimitEvents(configResolver, str);
            TimeUnit timeUnit = TimeUnit.SECONDS;
            Rate rate2 = new Rate(flimitEvents, flimitSec, timeUnit);
            this.foregroundRate = rate2;
            this.foregroundCapacity = flimitEvents;
            if (z10) {
                logger.debug("Foreground %s logging rate:%f, burst capacity:%d", str, rate2, Long.valueOf(flimitEvents));
            }
            long blimitSec = getBlimitSec(configResolver, str);
            long blimitEvents = getBlimitEvents(configResolver, str);
            Rate rate3 = new Rate(blimitEvents, blimitSec, timeUnit);
            this.backgroundRate = rate3;
            this.backgroundCapacity = blimitEvents;
            if (z10) {
                logger.debug("Background %s logging rate:%f, capacity:%d", str, rate3, Long.valueOf(blimitEvents));
            }
        }

        /* access modifiers changed from: package-private */
        public synchronized void changeRate(boolean z10) {
            Rate rate2;
            long j10;
            if (z10) {
                rate2 = this.foregroundRate;
            } else {
                rate2 = this.backgroundRate;
            }
            this.rate = rate2;
            if (z10) {
                j10 = this.foregroundCapacity;
            } else {
                j10 = this.backgroundCapacity;
            }
            this.capacity = j10;
        }

        /* access modifiers changed from: package-private */
        public synchronized boolean check(@NonNull PerfMetric perfMetric) {
            Timer time = this.clock.getTime();
            double durationMicros = (((double) this.lastTimeTokenReplenished.getDurationMicros(time)) * this.rate.getTokensPerSeconds()) / ((double) MICROS_IN_A_SECOND);
            if (durationMicros > 0.0d) {
                this.tokenCount = Math.min(this.tokenCount + durationMicros, (double) this.capacity);
                this.lastTimeTokenReplenished = time;
            }
            double d10 = this.tokenCount;
            if (d10 >= 1.0d) {
                this.tokenCount = d10 - 1.0d;
                return true;
            }
            if (this.isLogcatEnabled) {
                logger.warn("Exceeded log rate limit, dropping the log.");
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        public long getBackgroundCapacity() {
            return this.backgroundCapacity;
        }

        /* access modifiers changed from: package-private */
        public Rate getBackgroundRate() {
            return this.backgroundRate;
        }

        /* access modifiers changed from: package-private */
        public long getForegroundCapacity() {
            return this.foregroundCapacity;
        }

        /* access modifiers changed from: package-private */
        public Rate getForegroundRate() {
            return this.foregroundRate;
        }

        /* access modifiers changed from: package-private */
        public Rate getRate() {
            return this.rate;
        }

        /* access modifiers changed from: package-private */
        public void setRate(Rate rate2) {
            this.rate = rate2;
        }
    }

    public RateLimiter(@NonNull Context context, Rate rate, long j10) {
        this(rate, j10, new Clock(), getSamplingBucketId(), getSamplingBucketId(), ConfigResolver.getInstance());
        this.isLogcatEnabled = Utils.isDebugLoggingEnabled(context);
    }

    static double getSamplingBucketId() {
        return new Random().nextDouble();
    }

    private boolean hasVerboseSessions(List<PerfSession> list) {
        if (list.size() <= 0 || list.get(0).getSessionVerbosityCount() <= 0 || list.get(0).getSessionVerbosity(0) != SessionVerbosity.GAUGES_AND_SYSTEM_EVENTS) {
            return false;
        }
        return true;
    }

    private boolean isDeviceAllowedToSendFragmentScreenTraces() {
        if (this.fragmentBucketId < this.configResolver.getFragmentSamplingRate()) {
            return true;
        }
        return false;
    }

    private boolean isDeviceAllowedToSendNetworkEvents() {
        if (this.samplingBucketId < this.configResolver.getNetworkRequestSamplingRate()) {
            return true;
        }
        return false;
    }

    private boolean isDeviceAllowedToSendTraces() {
        if (this.samplingBucketId < this.configResolver.getTraceSamplingRate()) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void changeRate(boolean z10) {
        this.traceLimiter.changeRate(z10);
        this.networkLimiter.changeRate(z10);
    }

    /* access modifiers changed from: package-private */
    public boolean getIsDeviceAllowedToSendFragmentScreenTraces() {
        return isDeviceAllowedToSendFragmentScreenTraces();
    }

    /* access modifiers changed from: package-private */
    public boolean getIsDeviceAllowedToSendNetworkEvents() {
        return isDeviceAllowedToSendNetworkEvents();
    }

    /* access modifiers changed from: package-private */
    public boolean getIsDeviceAllowedToSendTraces() {
        return isDeviceAllowedToSendTraces();
    }

    /* access modifiers changed from: package-private */
    public boolean isEventRateLimited(PerfMetric perfMetric) {
        if (!isRateLimitApplicable(perfMetric)) {
            return false;
        }
        if (perfMetric.hasNetworkRequestMetric()) {
            return !this.networkLimiter.check(perfMetric);
        }
        if (perfMetric.hasTraceMetric()) {
            return !this.traceLimiter.check(perfMetric);
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean isEventSampled(PerfMetric perfMetric) {
        if (perfMetric.hasTraceMetric() && !isDeviceAllowedToSendTraces() && !hasVerboseSessions(perfMetric.getTraceMetric().getPerfSessionsList())) {
            return false;
        }
        if (isFragmentScreenTrace(perfMetric) && !isDeviceAllowedToSendFragmentScreenTraces() && !hasVerboseSessions(perfMetric.getTraceMetric().getPerfSessionsList())) {
            return false;
        }
        if (!perfMetric.hasNetworkRequestMetric() || isDeviceAllowedToSendNetworkEvents() || hasVerboseSessions(perfMetric.getNetworkRequestMetric().getPerfSessionsList())) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean isFragmentScreenTrace(PerfMetric perfMetric) {
        if (!perfMetric.hasTraceMetric() || !perfMetric.getTraceMetric().getName().startsWith(Constants.SCREEN_TRACE_PREFIX) || !perfMetric.getTraceMetric().containsCustomAttributes(Constants.ACTIVITY_ATTRIBUTE_KEY)) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean isRateLimitApplicable(@NonNull PerfMetric perfMetric) {
        if ((!perfMetric.hasTraceMetric() || ((!perfMetric.getTraceMetric().getName().equals(Constants.TraceNames.FOREGROUND_TRACE_NAME.toString()) && !perfMetric.getTraceMetric().getName().equals(Constants.TraceNames.BACKGROUND_TRACE_NAME.toString())) || perfMetric.getTraceMetric().getCountersCount() <= 0)) && !perfMetric.hasGaugeMetric()) {
            return true;
        }
        return false;
    }

    RateLimiter(Rate rate, long j10, Clock clock, double d10, double d11, ConfigResolver configResolver2) {
        double d12 = d10;
        double d13 = d11;
        this.traceLimiter = null;
        this.networkLimiter = null;
        boolean z10 = false;
        this.isLogcatEnabled = false;
        Utils.checkArgument(0.0d <= d12 && d12 < 1.0d, "Sampling bucket ID should be in range [0.0, 1.0).");
        if (0.0d <= d13 && d13 < 1.0d) {
            z10 = true;
        }
        Utils.checkArgument(z10, "Fragment sampling bucket ID should be in range [0.0, 1.0).");
        this.samplingBucketId = d12;
        this.fragmentBucketId = d13;
        this.configResolver = configResolver2;
        Rate rate2 = rate;
        long j11 = j10;
        Clock clock2 = clock;
        ConfigResolver configResolver3 = configResolver2;
        this.traceLimiter = new RateLimiterImpl(rate2, j11, clock2, configResolver3, ResourceType.TRACE, this.isLogcatEnabled);
        this.networkLimiter = new RateLimiterImpl(rate2, j11, clock2, configResolver3, ResourceType.NETWORK, this.isLogcatEnabled);
    }
}
