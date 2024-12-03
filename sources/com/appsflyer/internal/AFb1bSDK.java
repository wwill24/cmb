package com.appsflyer.internal;

import android.content.Context;
import androidx.annotation.NonNull;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.CreateOneLinkHttpTask;
import com.appsflyer.PurchaseHandler;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.commons.cli.HelpFormatter;

public final class AFb1bSDK implements AFc1xSDK {
    private final int AFInAppEventParameterName = ((int) TimeUnit.SECONDS.toMillis(30));
    private ExecutorService AFInAppEventType;
    private ExecutorService AFKeystoreWrapper;
    private AFb1fSDK AFLogger;
    private AFe1xSDK AFLogger$LogLevel;
    private AFd1xSDK AFVersionDeclaration;
    private AFe1nSDK afDebugLog;
    private CreateOneLinkHttpTask afErrorLog;
    private AFf1sSDK afErrorLogForExcManagerOnly;
    private PurchaseHandler afInfoLog;
    private AFb1vSDK afRDLog;
    private AFc1wSDK afWarnLog;
    private AFa1lSDK getLevel;
    private AFc1cSDK onAppOpenAttributionNative;
    public final AFc1ySDK valueOf = new AFc1ySDK();
    private ScheduledExecutorService values;

    static class AFa1wSDK implements ThreadFactory {
        private static final AtomicInteger AFKeystoreWrapper = new AtomicInteger();
        private final AtomicInteger AFInAppEventParameterName = new AtomicInteger();

        public AFa1wSDK() {
            AFKeystoreWrapper.incrementAndGet();
        }

        public final Thread newThread(Runnable runnable) {
            int i10 = AFKeystoreWrapper.get();
            int incrementAndGet = this.AFInAppEventParameterName.incrementAndGet();
            StringBuilder sb2 = new StringBuilder("queue-");
            sb2.append(i10);
            sb2.append(HelpFormatter.DEFAULT_OPT_PREFIX);
            sb2.append(incrementAndGet);
            return new Thread(runnable, sb2.toString());
        }
    }

    private synchronized CreateOneLinkHttpTask onAppOpenAttributionNative() {
        if (this.afErrorLog == null) {
            this.afErrorLog = new CreateOneLinkHttpTask(new AFc1mSDK(this.AFInAppEventParameterName), AFInAppEventParameterName());
        }
        return this.afErrorLog;
    }

    /* access modifiers changed from: private */
    @NonNull
    /* renamed from: onInstallConversionFailureNative */
    public synchronized AFc1wSDK onInstallConversionDataLoadedNative() {
        if (this.afWarnLog == null) {
            this.afWarnLog = new AFc1wSDK(this);
        }
        return this.afWarnLog;
    }

    @NonNull
    public final synchronized ExecutorService AFInAppEventParameterName() {
        if (this.AFKeystoreWrapper == null) {
            this.AFKeystoreWrapper = Executors.newCachedThreadPool();
        }
        return this.AFKeystoreWrapper;
    }

    @NonNull
    public final synchronized ScheduledExecutorService AFInAppEventType() {
        if (this.values == null) {
            this.values = Executors.newScheduledThreadPool(2);
        }
        return this.values;
    }

    public final AFc1pSDK AFKeystoreWrapper() {
        return new AFc1pSDK(onAppOpenAttributionNative(), values(), AppsFlyerProperties.getInstance(), AppsFlyer2dXConversionCallback());
    }

    public final synchronized PurchaseHandler AFLogger() {
        if (this.afInfoLog == null) {
            this.afInfoLog = new PurchaseHandler(this);
        }
        return this.afInfoLog;
    }

    public final synchronized AFb1uSDK AFLogger$LogLevel() {
        return AFb1uSDK.AFInAppEventType();
    }

    @NonNull
    public final synchronized AFe1xSDK AFVersionDeclaration() {
        if (this.AFLogger$LogLevel == null) {
            this.AFLogger$LogLevel = new AFe1xSDK(afErrorLogForExcManagerOnly(), new AFe1vSDK());
        }
        return this.AFLogger$LogLevel;
    }

    @NonNull
    public final synchronized AFc1cSDK AppsFlyer2dXConversionCallback() {
        if (this.onAppOpenAttributionNative == null) {
            this.onAppOpenAttributionNative = new AFc1cSDK(values(), afErrorLog());
        }
        return this.onAppOpenAttributionNative;
    }

    public final synchronized AFd1xSDK afDebugLog() {
        if (this.AFVersionDeclaration == null) {
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 6, 300, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>() {
                /* access modifiers changed from: private */
                /* renamed from: AFInAppEventParameterName */
                public boolean offer(Runnable runnable) {
                    if (isEmpty()) {
                        return super.offer(runnable);
                    }
                    return false;
                }
            }, new AFa1wSDK());
            threadPoolExecutor.setRejectedExecutionHandler(new b());
            this.AFVersionDeclaration = new AFd1xSDK(threadPoolExecutor);
        }
        return this.AFVersionDeclaration;
    }

    public final AFb1gSDK afErrorLog() {
        Context context = this.valueOf.values;
        if (context != null) {
            return new AFb1eSDK(AFb1zSDK.AFInAppEventType(context));
        }
        throw new IllegalStateException("Context must be set via setContext method before calling this dependency.");
    }

    @NonNull
    public final synchronized AFc1ySDK afErrorLogForExcManagerOnly() {
        return this.valueOf;
    }

    public final synchronized AFb1vSDK afInfoLog() {
        if (this.afRDLog == null) {
            AFe1wSDK aFe1wSDK = new AFe1wSDK(afErrorLog());
            this.afRDLog = new AFb1vSDK(new AFe1zSDK(), values(), AFVersionDeclaration(), aFe1wSDK, new AFc1pSDK(onAppOpenAttributionNative(), values(), AppsFlyerProperties.getInstance(), AppsFlyer2dXConversionCallback()), new AFe1uSDK(values(), aFe1wSDK), afDebugLog());
        }
        return this.afRDLog;
    }

    public final synchronized AFe1nSDK afRDLog() {
        if (this.afDebugLog == null) {
            this.afDebugLog = new AFe1nSDK(afErrorLog());
        }
        return this.afDebugLog;
    }

    @NonNull
    public final synchronized AFa1lSDK afWarnLog() {
        if (this.getLevel == null) {
            this.getLevel = new AFa1lSDK(afErrorLogForExcManagerOnly());
        }
        return this.getLevel;
    }

    public final synchronized AFf1sSDK getLevel() {
        if (this.afErrorLogForExcManagerOnly == null) {
            this.afErrorLogForExcManagerOnly = new AFf1sSDK();
        }
        return this.afErrorLogForExcManagerOnly;
    }

    @NonNull
    public final synchronized ExecutorService valueOf() {
        if (this.AFInAppEventType == null) {
            this.AFInAppEventType = Executors.newSingleThreadExecutor();
        }
        return this.AFInAppEventType;
    }

    public final synchronized AFb1fSDK values() {
        if (this.AFLogger == null) {
            AFc1ySDK afErrorLogForExcManagerOnly2 = afErrorLogForExcManagerOnly();
            Context context = this.valueOf.values;
            if (context != null) {
                this.AFLogger = new AFb1fSDK(afErrorLogForExcManagerOnly2, new AFb1eSDK(AFb1zSDK.AFInAppEventType(context)));
            } else {
                throw new IllegalStateException("Context must be set via setContext method before calling this dependency.");
            }
        }
        return this.AFLogger;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void valueOf(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
        try {
            threadPoolExecutor.getQueue().put(runnable);
        } catch (InterruptedException e10) {
            AFLogger.afErrorLogForExcManagerOnly("could not create executor for queue", e10);
            Thread.currentThread().interrupt();
        }
    }
}
