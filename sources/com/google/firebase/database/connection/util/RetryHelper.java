package com.google.firebase.database.connection.util;

import com.google.firebase.database.logging.LogWrapper;
import com.google.firebase.database.logging.Logger;
import java.util.Random;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class RetryHelper {
    private long currentRetryDelay;
    private final ScheduledExecutorService executorService;
    private final double jitterFactor;
    private boolean lastWasSuccess;
    private final LogWrapper logger;
    private final long maxRetryDelay;
    private final long minRetryDelayAfterFailure;
    private final Random random;
    private final double retryExponent;
    /* access modifiers changed from: private */
    public ScheduledFuture<?> scheduledRetry;

    public static class Builder {
        private double jitterFactor = 0.5d;
        private final LogWrapper logger;
        private long minRetryDelayAfterFailure = 1000;
        private double retryExponent = 1.3d;
        private long retryMaxDelay = 30000;
        private final ScheduledExecutorService service;

        public Builder(ScheduledExecutorService scheduledExecutorService, Logger logger2, String str) {
            this.service = scheduledExecutorService;
            this.logger = new LogWrapper(logger2, str);
        }

        public RetryHelper build() {
            return new RetryHelper(this.service, this.logger, this.minRetryDelayAfterFailure, this.retryMaxDelay, this.retryExponent, this.jitterFactor);
        }

        public Builder withJitterFactor(double d10) {
            if (d10 < 0.0d || d10 > 1.0d) {
                throw new IllegalArgumentException("Argument out of range: " + d10);
            }
            this.jitterFactor = d10;
            return this;
        }

        public Builder withMaxDelay(long j10) {
            this.retryMaxDelay = j10;
            return this;
        }

        public Builder withMinDelayAfterFailure(long j10) {
            this.minRetryDelayAfterFailure = j10;
            return this;
        }

        public Builder withRetryExponent(double d10) {
            this.retryExponent = d10;
            return this;
        }
    }

    public void cancel() {
        if (this.scheduledRetry != null) {
            this.logger.debug("Cancelling existing retry attempt", new Object[0]);
            this.scheduledRetry.cancel(false);
            this.scheduledRetry = null;
        } else {
            this.logger.debug("No existing retry attempt to cancel", new Object[0]);
        }
        this.currentRetryDelay = 0;
    }

    public void retry(final Runnable runnable) {
        AnonymousClass1 r02 = new Runnable() {
            public void run() {
                ScheduledFuture unused = RetryHelper.this.scheduledRetry = null;
                runnable.run();
            }
        };
        if (this.scheduledRetry != null) {
            this.logger.debug("Cancelling previous scheduled retry", new Object[0]);
            this.scheduledRetry.cancel(false);
            this.scheduledRetry = null;
        }
        long j10 = 0;
        if (!this.lastWasSuccess) {
            long j11 = this.currentRetryDelay;
            if (j11 == 0) {
                this.currentRetryDelay = this.minRetryDelayAfterFailure;
            } else {
                this.currentRetryDelay = Math.min((long) (((double) j11) * this.retryExponent), this.maxRetryDelay);
            }
            double d10 = this.jitterFactor;
            long j12 = this.currentRetryDelay;
            j10 = (long) (((1.0d - d10) * ((double) j12)) + (d10 * ((double) j12) * this.random.nextDouble()));
        }
        this.lastWasSuccess = false;
        this.logger.debug("Scheduling retry in %dms", Long.valueOf(j10));
        this.scheduledRetry = this.executorService.schedule(r02, j10, TimeUnit.MILLISECONDS);
    }

    public void setMaxDelay() {
        this.currentRetryDelay = this.maxRetryDelay;
    }

    public void signalSuccess() {
        this.lastWasSuccess = true;
        this.currentRetryDelay = 0;
    }

    private RetryHelper(ScheduledExecutorService scheduledExecutorService, LogWrapper logWrapper, long j10, long j11, double d10, double d11) {
        this.random = new Random();
        this.lastWasSuccess = true;
        this.executorService = scheduledExecutorService;
        this.logger = logWrapper;
        this.minRetryDelayAfterFailure = j10;
        this.maxRetryDelay = j11;
        this.retryExponent = d10;
        this.jitterFactor = d11;
    }
}
