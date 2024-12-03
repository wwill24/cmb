package com.google.firebase.perf.application;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.h;
import com.google.firebase.perf.config.ConfigResolver;
import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.metrics.FrameMetricsCalculator;
import com.google.firebase.perf.metrics.Trace;
import com.google.firebase.perf.session.SessionManager;
import com.google.firebase.perf.transport.TransportManager;
import com.google.firebase.perf.util.Clock;
import com.google.firebase.perf.util.Constants;
import com.google.firebase.perf.util.Optional;
import com.google.firebase.perf.util.ScreenTraceUtil;
import com.google.firebase.perf.util.Timer;
import com.google.firebase.perf.v1.ApplicationProcessState;
import com.google.firebase.perf.v1.TraceMetric;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class AppStateMonitor implements Application.ActivityLifecycleCallbacks {
    private static volatile AppStateMonitor instance;
    private static final AndroidLogger logger = AndroidLogger.getInstance();
    private final WeakHashMap<Activity, FragmentStateMonitor> activityToFragmentStateMonitorMap;
    private final WeakHashMap<Activity, FrameMetricsRecorder> activityToRecorderMap;
    private final WeakHashMap<Activity, Boolean> activityToResumedMap;
    private final WeakHashMap<Activity, Trace> activityToScreenTraceMap;
    private Set<AppColdStartCallback> appColdStartSubscribers;
    private final Set<WeakReference<AppStateCallback>> appStateSubscribers;
    private final Clock clock;
    private final ConfigResolver configResolver;
    private ApplicationProcessState currentAppState;
    private boolean isColdStart;
    private boolean isRegisteredForLifecycleCallbacks;
    private final Map<String, Long> metricToCountMap;
    private Timer resumeTime;
    private final boolean screenPerformanceRecordingSupported;
    private Timer stopTime;
    private final TransportManager transportManager;
    private final AtomicInteger tsnsCount;

    public interface AppColdStartCallback {
        void onAppColdStart();
    }

    public interface AppStateCallback {
        void onUpdateAppState(ApplicationProcessState applicationProcessState);
    }

    AppStateMonitor(TransportManager transportManager2, Clock clock2) {
        this(transportManager2, clock2, ConfigResolver.getInstance(), isScreenPerformanceRecordingSupported());
    }

    public static AppStateMonitor getInstance() {
        if (instance == null) {
            synchronized (AppStateMonitor.class) {
                if (instance == null) {
                    instance = new AppStateMonitor(TransportManager.getInstance(), new Clock());
                }
            }
        }
        return instance;
    }

    public static String getScreenTraceName(Activity activity) {
        return Constants.SCREEN_TRACE_PREFIX + activity.getClass().getSimpleName();
    }

    private static boolean isScreenPerformanceRecordingSupported() {
        return FrameMetricsRecorder.isFrameMetricsRecordingSupported();
    }

    private void sendAppColdStartUpdate() {
        synchronized (this.appColdStartSubscribers) {
            for (AppColdStartCallback next : this.appColdStartSubscribers) {
                if (next != null) {
                    next.onAppColdStart();
                }
            }
        }
    }

    private void sendScreenTrace(Activity activity) {
        Trace trace = this.activityToScreenTraceMap.get(activity);
        if (trace != null) {
            this.activityToScreenTraceMap.remove(activity);
            Optional<FrameMetricsCalculator.PerfFrameMetrics> stop = this.activityToRecorderMap.get(activity).stop();
            if (!stop.isAvailable()) {
                logger.warn("Failed to record frame data for %s.", activity.getClass().getSimpleName());
                return;
            }
            ScreenTraceUtil.addFrameCounters(trace, stop.get());
            trace.stop();
        }
    }

    private void sendSessionLog(String str, Timer timer, Timer timer2) {
        if (this.configResolver.isPerformanceMonitoringEnabled()) {
            TraceMetric.Builder addPerfSessions = TraceMetric.newBuilder().setName(str).setClientStartTimeUs(timer.getMicros()).setDurationUs(timer.getDurationMicros(timer2)).addPerfSessions(SessionManager.getInstance().perfSession().build());
            int andSet = this.tsnsCount.getAndSet(0);
            synchronized (this.metricToCountMap) {
                addPerfSessions.putAllCounters(this.metricToCountMap);
                if (andSet != 0) {
                    addPerfSessions.putCounters(Constants.CounterNames.TRACE_STARTED_NOT_STOPPED.toString(), (long) andSet);
                }
                this.metricToCountMap.clear();
            }
            this.transportManager.log((TraceMetric) addPerfSessions.build(), ApplicationProcessState.FOREGROUND_BACKGROUND);
        }
    }

    private void startFrameMonitoring(Activity activity) {
        if (isScreenTraceSupported() && this.configResolver.isPerformanceMonitoringEnabled()) {
            FrameMetricsRecorder frameMetricsRecorder = new FrameMetricsRecorder(activity);
            this.activityToRecorderMap.put(activity, frameMetricsRecorder);
            if (activity instanceof h) {
                FragmentStateMonitor fragmentStateMonitor = new FragmentStateMonitor(this.clock, this.transportManager, this, frameMetricsRecorder);
                this.activityToFragmentStateMonitorMap.put(activity, fragmentStateMonitor);
                ((h) activity).getSupportFragmentManager().j1(fragmentStateMonitor, true);
            }
        }
    }

    private void updateAppState(ApplicationProcessState applicationProcessState) {
        this.currentAppState = applicationProcessState;
        synchronized (this.appStateSubscribers) {
            Iterator<WeakReference<AppStateCallback>> it = this.appStateSubscribers.iterator();
            while (it.hasNext()) {
                AppStateCallback appStateCallback = (AppStateCallback) it.next().get();
                if (appStateCallback != null) {
                    appStateCallback.onUpdateAppState(this.currentAppState);
                } else {
                    it.remove();
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public WeakHashMap<Activity, Trace> getActivity2ScreenTrace() {
        return this.activityToScreenTraceMap;
    }

    public ApplicationProcessState getAppState() {
        return this.currentAppState;
    }

    /* access modifiers changed from: package-private */
    public Timer getPauseTime() {
        return this.stopTime;
    }

    /* access modifiers changed from: package-private */
    public Timer getResumeTime() {
        return this.resumeTime;
    }

    /* access modifiers changed from: package-private */
    public WeakHashMap<Activity, Boolean> getResumed() {
        return this.activityToResumedMap;
    }

    public void incrementCount(@NonNull String str, long j10) {
        synchronized (this.metricToCountMap) {
            Long l10 = this.metricToCountMap.get(str);
            if (l10 == null) {
                this.metricToCountMap.put(str, Long.valueOf(j10));
            } else {
                this.metricToCountMap.put(str, Long.valueOf(l10.longValue() + j10));
            }
        }
    }

    public void incrementTsnsCount(int i10) {
        this.tsnsCount.addAndGet(i10);
    }

    public boolean isColdStart() {
        return this.isColdStart;
    }

    public boolean isForeground() {
        return this.currentAppState == ApplicationProcessState.FOREGROUND;
    }

    /* access modifiers changed from: protected */
    public boolean isScreenTraceSupported() {
        return this.screenPerformanceRecordingSupported;
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        startFrameMonitoring(activity);
    }

    public void onActivityDestroyed(Activity activity) {
        this.activityToRecorderMap.remove(activity);
        if (this.activityToFragmentStateMonitorMap.containsKey(activity)) {
            ((h) activity).getSupportFragmentManager().A1(this.activityToFragmentStateMonitorMap.remove(activity));
        }
    }

    public void onActivityPaused(Activity activity) {
    }

    public synchronized void onActivityResumed(Activity activity) {
        if (this.activityToResumedMap.isEmpty()) {
            this.resumeTime = this.clock.getTime();
            this.activityToResumedMap.put(activity, Boolean.TRUE);
            if (this.isColdStart) {
                updateAppState(ApplicationProcessState.FOREGROUND);
                sendAppColdStartUpdate();
                this.isColdStart = false;
            } else {
                sendSessionLog(Constants.TraceNames.BACKGROUND_TRACE_NAME.toString(), this.stopTime, this.resumeTime);
                updateAppState(ApplicationProcessState.FOREGROUND);
            }
        } else {
            this.activityToResumedMap.put(activity, Boolean.TRUE);
        }
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public synchronized void onActivityStarted(Activity activity) {
        if (isScreenTraceSupported() && this.configResolver.isPerformanceMonitoringEnabled()) {
            if (!this.activityToRecorderMap.containsKey(activity)) {
                startFrameMonitoring(activity);
            }
            this.activityToRecorderMap.get(activity).start();
            Trace trace = new Trace(getScreenTraceName(activity), this.transportManager, this.clock, this);
            trace.start();
            this.activityToScreenTraceMap.put(activity, trace);
        }
    }

    public synchronized void onActivityStopped(Activity activity) {
        if (isScreenTraceSupported()) {
            sendScreenTrace(activity);
        }
        if (this.activityToResumedMap.containsKey(activity)) {
            this.activityToResumedMap.remove(activity);
            if (this.activityToResumedMap.isEmpty()) {
                this.stopTime = this.clock.getTime();
                sendSessionLog(Constants.TraceNames.FOREGROUND_TRACE_NAME.toString(), this.resumeTime, this.stopTime);
                updateAppState(ApplicationProcessState.BACKGROUND);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0018, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void registerActivityLifecycleCallbacks(android.content.Context r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r0 = r1.isRegisteredForLifecycleCallbacks     // Catch:{ all -> 0x0019 }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r1)
            return
        L_0x0007:
            android.content.Context r2 = r2.getApplicationContext()     // Catch:{ all -> 0x0019 }
            boolean r0 = r2 instanceof android.app.Application     // Catch:{ all -> 0x0019 }
            if (r0 == 0) goto L_0x0017
            android.app.Application r2 = (android.app.Application) r2     // Catch:{ all -> 0x0019 }
            r2.registerActivityLifecycleCallbacks(r1)     // Catch:{ all -> 0x0019 }
            r2 = 1
            r1.isRegisteredForLifecycleCallbacks = r2     // Catch:{ all -> 0x0019 }
        L_0x0017:
            monitor-exit(r1)
            return
        L_0x0019:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.perf.application.AppStateMonitor.registerActivityLifecycleCallbacks(android.content.Context):void");
    }

    public void registerForAppColdStart(AppColdStartCallback appColdStartCallback) {
        synchronized (this.appColdStartSubscribers) {
            this.appColdStartSubscribers.add(appColdStartCallback);
        }
    }

    public void registerForAppState(WeakReference<AppStateCallback> weakReference) {
        synchronized (this.appStateSubscribers) {
            this.appStateSubscribers.add(weakReference);
        }
    }

    public void setIsColdStart(boolean z10) {
        this.isColdStart = z10;
    }

    /* access modifiers changed from: package-private */
    public void setStopTime(Timer timer) {
        this.stopTime = timer;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0018, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void unregisterActivityLifecycleCallbacks(android.content.Context r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r0 = r1.isRegisteredForLifecycleCallbacks     // Catch:{ all -> 0x0019 }
            if (r0 != 0) goto L_0x0007
            monitor-exit(r1)
            return
        L_0x0007:
            android.content.Context r2 = r2.getApplicationContext()     // Catch:{ all -> 0x0019 }
            boolean r0 = r2 instanceof android.app.Application     // Catch:{ all -> 0x0019 }
            if (r0 == 0) goto L_0x0017
            android.app.Application r2 = (android.app.Application) r2     // Catch:{ all -> 0x0019 }
            r2.unregisterActivityLifecycleCallbacks(r1)     // Catch:{ all -> 0x0019 }
            r2 = 0
            r1.isRegisteredForLifecycleCallbacks = r2     // Catch:{ all -> 0x0019 }
        L_0x0017:
            monitor-exit(r1)
            return
        L_0x0019:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.perf.application.AppStateMonitor.unregisterActivityLifecycleCallbacks(android.content.Context):void");
    }

    public void unregisterForAppState(WeakReference<AppStateCallback> weakReference) {
        synchronized (this.appStateSubscribers) {
            this.appStateSubscribers.remove(weakReference);
        }
    }

    AppStateMonitor(TransportManager transportManager2, Clock clock2, ConfigResolver configResolver2, boolean z10) {
        this.activityToResumedMap = new WeakHashMap<>();
        this.activityToRecorderMap = new WeakHashMap<>();
        this.activityToFragmentStateMonitorMap = new WeakHashMap<>();
        this.activityToScreenTraceMap = new WeakHashMap<>();
        this.metricToCountMap = new HashMap();
        this.appStateSubscribers = new HashSet();
        this.appColdStartSubscribers = new HashSet();
        this.tsnsCount = new AtomicInteger(0);
        this.currentAppState = ApplicationProcessState.BACKGROUND;
        this.isRegisteredForLifecycleCallbacks = false;
        this.isColdStart = true;
        this.transportManager = transportManager2;
        this.clock = clock2;
        this.configResolver = configResolver2;
        this.screenPerformanceRecordingSupported = z10;
    }
}
