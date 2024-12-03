package com.google.firebase.perf.metrics;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.Process;
import android.view.ViewTreeObserver;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ProcessLifecycleOwner;
import androidx.lifecycle.k;
import androidx.lifecycle.v;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.security.CertificateUtil;
import com.google.firebase.FirebaseApp;
import com.google.firebase.StartupTime;
import com.google.firebase.perf.config.ConfigResolver;
import com.google.firebase.perf.session.PerfSession;
import com.google.firebase.perf.transport.TransportManager;
import com.google.firebase.perf.util.Clock;
import com.google.firebase.perf.util.Constants;
import com.google.firebase.perf.util.Timer;
import com.google.firebase.perf.v1.ApplicationProcessState;
import com.google.firebase.perf.v1.TraceMetric;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class AppStartTrace implements Application.ActivityLifecycleCallbacks, k {
    private static final int CORE_POOL_SIZE = 0;
    private static final long MAX_LATENCY_BEFORE_UI_INIT = TimeUnit.MINUTES.toMicros(1);
    private static final int MAX_POOL_SIZE = 1;
    @NonNull
    private static final Timer PERF_CLASS_LOAD_TIME = new Clock().getTime();
    private static ExecutorService executorService;
    private static volatile AppStartTrace instance;
    private Context appContext;
    private WeakReference<Activity> appStartActivity;
    private final Clock clock;
    private final ConfigResolver configResolver;
    private final TraceMetric.Builder experimentTtid;
    private final Timer firebaseClassLoadTime;
    private Timer firstBackgroundTime;
    private Timer firstForegroundTime;
    private boolean isRegisteredForLifecycleCallbacks = false;
    /* access modifiers changed from: private */
    public boolean isStartedFromBackground;
    private boolean isTooLateToInitUI = false;
    private WeakReference<Activity> launchActivity;
    /* access modifiers changed from: private */
    public Timer onCreateTime;
    private int onDrawCount;
    private final DrawCounter onDrawCounterListener;
    private Timer onDrawPostAtFrontOfQueueTime;
    private Timer onResumeTime;
    private Timer onStartTime;
    private Timer preDrawPostAtFrontOfQueueTime;
    private Timer preDrawPostTime;
    private final Timer processStartTime;
    private PerfSession startSession;
    private boolean systemForegroundCheck;
    private final TransportManager transportManager;

    private final class DrawCounter implements ViewTreeObserver.OnDrawListener {
        private DrawCounter() {
        }

        public void onDraw() {
            AppStartTrace.access$308(AppStartTrace.this);
        }
    }

    public static class StartFromBackgroundRunnable implements Runnable {
        private final AppStartTrace trace;

        public StartFromBackgroundRunnable(AppStartTrace appStartTrace) {
            this.trace = appStartTrace;
        }

        public void run() {
            if (this.trace.onCreateTime == null) {
                boolean unused = this.trace.isStartedFromBackground = true;
            }
        }
    }

    AppStartTrace(@NonNull TransportManager transportManager2, @NonNull Clock clock2, @NonNull ConfigResolver configResolver2, @NonNull ExecutorService executorService2) {
        Timer timer = null;
        this.onCreateTime = null;
        this.onStartTime = null;
        this.onResumeTime = null;
        this.firstForegroundTime = null;
        this.firstBackgroundTime = null;
        this.preDrawPostTime = null;
        this.preDrawPostAtFrontOfQueueTime = null;
        this.onDrawPostAtFrontOfQueueTime = null;
        this.isStartedFromBackground = false;
        this.onDrawCount = 0;
        this.onDrawCounterListener = new DrawCounter();
        this.systemForegroundCheck = false;
        this.transportManager = transportManager2;
        this.clock = clock2;
        this.configResolver = configResolver2;
        executorService = executorService2;
        this.experimentTtid = TraceMetric.newBuilder().setName("_experiment_app_start_ttid");
        this.processStartTime = Timer.ofElapsedRealtime(Process.getStartElapsedRealtime());
        StartupTime startupTime = (StartupTime) FirebaseApp.getInstance().get(StartupTime.class);
        this.firebaseClassLoadTime = startupTime != null ? Timer.ofElapsedRealtime(startupTime.getElapsedRealtime()) : timer;
    }

    static /* synthetic */ int access$308(AppStartTrace appStartTrace) {
        int i10 = appStartTrace.onDrawCount;
        appStartTrace.onDrawCount = i10 + 1;
        return i10;
    }

    @NonNull
    private Timer getClassLoadTimeCompat() {
        Timer timer = this.firebaseClassLoadTime;
        if (timer != null) {
            return timer;
        }
        return PERF_CLASS_LOAD_TIME;
    }

    public static AppStartTrace getInstance() {
        return instance != null ? instance : getInstance(TransportManager.getInstance(), new Clock());
    }

    @NonNull
    private Timer getStartTimerCompat() {
        Timer timer = this.processStartTime;
        if (timer != null) {
            return timer;
        }
        return getClassLoadTimeCompat();
    }

    public static boolean isAnyAppProcessInForeground(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager == null) {
            return true;
        }
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return false;
        }
        String packageName = context.getPackageName();
        String str = packageName + CertificateUtil.DELIMITER;
        for (ActivityManager.RunningAppProcessInfo next : runningAppProcesses) {
            if (next.importance == 100 && (next.processName.equals(packageName) || next.processName.startsWith(str))) {
                return true;
            }
        }
        return false;
    }

    public static boolean isScreenOn(Context context) {
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        if (powerManager == null) {
            return true;
        }
        return powerManager.isInteractive();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$logExperimentTrace$0(TraceMetric.Builder builder) {
        this.transportManager.log((TraceMetric) builder.build(), ApplicationProcessState.FOREGROUND_BACKGROUND);
    }

    /* access modifiers changed from: private */
    public void logAppStartTrace() {
        TraceMetric.Builder durationUs = TraceMetric.newBuilder().setName(Constants.TraceNames.APP_START_TRACE_NAME.toString()).setClientStartTimeUs(getClassLoadTimeCompat().getMicros()).setDurationUs(getClassLoadTimeCompat().getDurationMicros(this.onResumeTime));
        ArrayList arrayList = new ArrayList(3);
        arrayList.add((TraceMetric) TraceMetric.newBuilder().setName(Constants.TraceNames.ON_CREATE_TRACE_NAME.toString()).setClientStartTimeUs(getClassLoadTimeCompat().getMicros()).setDurationUs(getClassLoadTimeCompat().getDurationMicros(this.onCreateTime)).build());
        if (this.onStartTime != null) {
            TraceMetric.Builder newBuilder = TraceMetric.newBuilder();
            newBuilder.setName(Constants.TraceNames.ON_START_TRACE_NAME.toString()).setClientStartTimeUs(this.onCreateTime.getMicros()).setDurationUs(this.onCreateTime.getDurationMicros(this.onStartTime));
            arrayList.add((TraceMetric) newBuilder.build());
            TraceMetric.Builder newBuilder2 = TraceMetric.newBuilder();
            newBuilder2.setName(Constants.TraceNames.ON_RESUME_TRACE_NAME.toString()).setClientStartTimeUs(this.onStartTime.getMicros()).setDurationUs(this.onStartTime.getDurationMicros(this.onResumeTime));
            arrayList.add((TraceMetric) newBuilder2.build());
        }
        durationUs.addAllSubtraces(arrayList).addPerfSessions(this.startSession.build());
        this.transportManager.log((TraceMetric) durationUs.build(), ApplicationProcessState.FOREGROUND_BACKGROUND);
    }

    private void logExperimentTrace(TraceMetric.Builder builder) {
        if (this.preDrawPostTime != null && this.preDrawPostAtFrontOfQueueTime != null && this.onDrawPostAtFrontOfQueueTime != null) {
            executorService.execute(new e(this, builder));
            unregisterActivityLifecycleCallbacks();
        }
    }

    /* access modifiers changed from: private */
    public void recordOnDrawFrontOfQueue() {
        String str;
        if (this.onDrawPostAtFrontOfQueueTime == null) {
            this.onDrawPostAtFrontOfQueueTime = this.clock.getTime();
            this.experimentTtid.addSubtraces((TraceMetric) TraceMetric.newBuilder().setName("_experiment_onDrawFoQ").setClientStartTimeUs(getStartTimerCompat().getMicros()).setDurationUs(getStartTimerCompat().getDurationMicros(this.onDrawPostAtFrontOfQueueTime)).build());
            if (this.processStartTime != null) {
                this.experimentTtid.addSubtraces((TraceMetric) TraceMetric.newBuilder().setName("_experiment_procStart_to_classLoad").setClientStartTimeUs(getStartTimerCompat().getMicros()).setDurationUs(getStartTimerCompat().getDurationMicros(getClassLoadTimeCompat())).build());
            }
            TraceMetric.Builder builder = this.experimentTtid;
            if (this.systemForegroundCheck) {
                str = ServerProtocol.DIALOG_RETURN_SCOPES_TRUE;
            } else {
                str = "false";
            }
            builder.putCustomAttributes("systemDeterminedForeground", str);
            this.experimentTtid.putCounters("onDrawCount", (long) this.onDrawCount);
            this.experimentTtid.addPerfSessions(this.startSession.build());
            logExperimentTrace(this.experimentTtid);
        }
    }

    /* access modifiers changed from: private */
    public void recordPreDraw() {
        if (this.preDrawPostTime == null) {
            this.preDrawPostTime = this.clock.getTime();
            this.experimentTtid.setClientStartTimeUs(getStartTimerCompat().getMicros()).setDurationUs(getStartTimerCompat().getDurationMicros(this.preDrawPostTime));
            logExperimentTrace(this.experimentTtid);
        }
    }

    /* access modifiers changed from: private */
    public void recordPreDrawFrontOfQueue() {
        if (this.preDrawPostAtFrontOfQueueTime == null) {
            this.preDrawPostAtFrontOfQueueTime = this.clock.getTime();
            this.experimentTtid.addSubtraces((TraceMetric) TraceMetric.newBuilder().setName("_experiment_preDrawFoQ").setClientStartTimeUs(getStartTimerCompat().getMicros()).setDurationUs(getStartTimerCompat().getDurationMicros(this.preDrawPostAtFrontOfQueueTime)).build());
            logExperimentTrace(this.experimentTtid);
        }
    }

    @Keep
    public static void setLauncherActivityOnCreateTime(String str) {
    }

    @Keep
    public static void setLauncherActivityOnResumeTime(String str) {
    }

    @Keep
    public static void setLauncherActivityOnStartTime(String str) {
    }

    /* access modifiers changed from: package-private */
    public Activity getAppStartActivity() {
        return this.appStartActivity.get();
    }

    /* access modifiers changed from: package-private */
    public Activity getLaunchActivity() {
        return this.launchActivity.get();
    }

    /* access modifiers changed from: package-private */
    public Timer getOnCreateTime() {
        return this.onCreateTime;
    }

    /* access modifiers changed from: package-private */
    public Timer getOnResumeTime() {
        return this.onResumeTime;
    }

    /* access modifiers changed from: package-private */
    public Timer getOnStartTime() {
        return this.onStartTime;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x003f, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0041, code lost:
        return;
     */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x003c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void onActivityCreated(android.app.Activity r4, android.os.Bundle r5) {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r5 = r3.isStartedFromBackground     // Catch:{ all -> 0x0042 }
            if (r5 != 0) goto L_0x0040
            com.google.firebase.perf.util.Timer r5 = r3.onCreateTime     // Catch:{ all -> 0x0042 }
            if (r5 == 0) goto L_0x000a
            goto L_0x0040
        L_0x000a:
            boolean r5 = r3.systemForegroundCheck     // Catch:{ all -> 0x0042 }
            r0 = 1
            if (r5 != 0) goto L_0x001a
            android.content.Context r5 = r3.appContext     // Catch:{ all -> 0x0042 }
            boolean r5 = isAnyAppProcessInForeground(r5)     // Catch:{ all -> 0x0042 }
            if (r5 == 0) goto L_0x0018
            goto L_0x001a
        L_0x0018:
            r5 = 0
            goto L_0x001b
        L_0x001a:
            r5 = r0
        L_0x001b:
            r3.systemForegroundCheck = r5     // Catch:{ all -> 0x0042 }
            java.lang.ref.WeakReference r5 = new java.lang.ref.WeakReference     // Catch:{ all -> 0x0042 }
            r5.<init>(r4)     // Catch:{ all -> 0x0042 }
            r3.launchActivity = r5     // Catch:{ all -> 0x0042 }
            com.google.firebase.perf.util.Clock r4 = r3.clock     // Catch:{ all -> 0x0042 }
            com.google.firebase.perf.util.Timer r4 = r4.getTime()     // Catch:{ all -> 0x0042 }
            r3.onCreateTime = r4     // Catch:{ all -> 0x0042 }
            com.google.firebase.perf.util.Timer r4 = r3.getStartTimerCompat()     // Catch:{ all -> 0x0042 }
            com.google.firebase.perf.util.Timer r5 = r3.onCreateTime     // Catch:{ all -> 0x0042 }
            long r4 = r4.getDurationMicros(r5)     // Catch:{ all -> 0x0042 }
            long r1 = MAX_LATENCY_BEFORE_UI_INIT     // Catch:{ all -> 0x0042 }
            int r4 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
            if (r4 <= 0) goto L_0x003e
            r3.isTooLateToInitUI = r0     // Catch:{ all -> 0x0042 }
        L_0x003e:
            monitor-exit(r3)
            return
        L_0x0040:
            monitor-exit(r3)
            return
        L_0x0042:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.perf.metrics.AppStartTrace.onActivityCreated(android.app.Activity, android.os.Bundle):void");
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivityPaused(Activity activity) {
        if (!this.isStartedFromBackground && !this.isTooLateToInitUI && this.configResolver.getIsExperimentTTIDEnabled()) {
            activity.findViewById(16908290).getViewTreeObserver().removeOnDrawListener(this.onDrawCounterListener);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x009e, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00a0, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void onActivityResumed(android.app.Activity r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            boolean r0 = r5.isStartedFromBackground     // Catch:{ all -> 0x00a1 }
            if (r0 != 0) goto L_0x009f
            boolean r0 = r5.isTooLateToInitUI     // Catch:{ all -> 0x00a1 }
            if (r0 == 0) goto L_0x000b
            goto L_0x009f
        L_0x000b:
            com.google.firebase.perf.config.ConfigResolver r0 = r5.configResolver     // Catch:{ all -> 0x00a1 }
            boolean r0 = r0.getIsExperimentTTIDEnabled()     // Catch:{ all -> 0x00a1 }
            if (r0 == 0) goto L_0x0038
            r1 = 16908290(0x1020002, float:2.3877235E-38)
            android.view.View r1 = r6.findViewById(r1)     // Catch:{ all -> 0x00a1 }
            android.view.ViewTreeObserver r2 = r1.getViewTreeObserver()     // Catch:{ all -> 0x00a1 }
            com.google.firebase.perf.metrics.AppStartTrace$DrawCounter r3 = r5.onDrawCounterListener     // Catch:{ all -> 0x00a1 }
            r2.addOnDrawListener(r3)     // Catch:{ all -> 0x00a1 }
            com.google.firebase.perf.metrics.a r2 = new com.google.firebase.perf.metrics.a     // Catch:{ all -> 0x00a1 }
            r2.<init>(r5)     // Catch:{ all -> 0x00a1 }
            com.google.firebase.perf.util.FirstDrawDoneListener.registerForNextDraw(r1, r2)     // Catch:{ all -> 0x00a1 }
            com.google.firebase.perf.metrics.b r2 = new com.google.firebase.perf.metrics.b     // Catch:{ all -> 0x00a1 }
            r2.<init>(r5)     // Catch:{ all -> 0x00a1 }
            com.google.firebase.perf.metrics.c r3 = new com.google.firebase.perf.metrics.c     // Catch:{ all -> 0x00a1 }
            r3.<init>(r5)     // Catch:{ all -> 0x00a1 }
            com.google.firebase.perf.util.PreDrawListener.registerForNextDraw(r1, r2, r3)     // Catch:{ all -> 0x00a1 }
        L_0x0038:
            com.google.firebase.perf.util.Timer r1 = r5.onResumeTime     // Catch:{ all -> 0x00a1 }
            if (r1 == 0) goto L_0x003e
            monitor-exit(r5)
            return
        L_0x003e:
            java.lang.ref.WeakReference r1 = new java.lang.ref.WeakReference     // Catch:{ all -> 0x00a1 }
            r1.<init>(r6)     // Catch:{ all -> 0x00a1 }
            r5.appStartActivity = r1     // Catch:{ all -> 0x00a1 }
            com.google.firebase.perf.util.Clock r1 = r5.clock     // Catch:{ all -> 0x00a1 }
            com.google.firebase.perf.util.Timer r1 = r1.getTime()     // Catch:{ all -> 0x00a1 }
            r5.onResumeTime = r1     // Catch:{ all -> 0x00a1 }
            com.google.firebase.perf.session.SessionManager r1 = com.google.firebase.perf.session.SessionManager.getInstance()     // Catch:{ all -> 0x00a1 }
            com.google.firebase.perf.session.PerfSession r1 = r1.perfSession()     // Catch:{ all -> 0x00a1 }
            r5.startSession = r1     // Catch:{ all -> 0x00a1 }
            com.google.firebase.perf.logging.AndroidLogger r1 = com.google.firebase.perf.logging.AndroidLogger.getInstance()     // Catch:{ all -> 0x00a1 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a1 }
            r2.<init>()     // Catch:{ all -> 0x00a1 }
            java.lang.String r3 = "onResume(): "
            r2.append(r3)     // Catch:{ all -> 0x00a1 }
            java.lang.Class r6 = r6.getClass()     // Catch:{ all -> 0x00a1 }
            java.lang.String r6 = r6.getName()     // Catch:{ all -> 0x00a1 }
            r2.append(r6)     // Catch:{ all -> 0x00a1 }
            java.lang.String r6 = ": "
            r2.append(r6)     // Catch:{ all -> 0x00a1 }
            com.google.firebase.perf.util.Timer r6 = r5.getClassLoadTimeCompat()     // Catch:{ all -> 0x00a1 }
            com.google.firebase.perf.util.Timer r3 = r5.onResumeTime     // Catch:{ all -> 0x00a1 }
            long r3 = r6.getDurationMicros(r3)     // Catch:{ all -> 0x00a1 }
            r2.append(r3)     // Catch:{ all -> 0x00a1 }
            java.lang.String r6 = " microseconds"
            r2.append(r6)     // Catch:{ all -> 0x00a1 }
            java.lang.String r6 = r2.toString()     // Catch:{ all -> 0x00a1 }
            r1.debug(r6)     // Catch:{ all -> 0x00a1 }
            java.util.concurrent.ExecutorService r6 = executorService     // Catch:{ all -> 0x00a1 }
            com.google.firebase.perf.metrics.d r1 = new com.google.firebase.perf.metrics.d     // Catch:{ all -> 0x00a1 }
            r1.<init>(r5)     // Catch:{ all -> 0x00a1 }
            r6.execute(r1)     // Catch:{ all -> 0x00a1 }
            if (r0 != 0) goto L_0x009d
            r5.unregisterActivityLifecycleCallbacks()     // Catch:{ all -> 0x00a1 }
        L_0x009d:
            monitor-exit(r5)
            return
        L_0x009f:
            monitor-exit(r5)
            return
        L_0x00a1:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.perf.metrics.AppStartTrace.onActivityResumed(android.app.Activity):void");
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0019, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void onActivityStarted(android.app.Activity r1) {
        /*
            r0 = this;
            monitor-enter(r0)
            boolean r1 = r0.isStartedFromBackground     // Catch:{ all -> 0x001a }
            if (r1 != 0) goto L_0x0018
            com.google.firebase.perf.util.Timer r1 = r0.onStartTime     // Catch:{ all -> 0x001a }
            if (r1 != 0) goto L_0x0018
            boolean r1 = r0.isTooLateToInitUI     // Catch:{ all -> 0x001a }
            if (r1 == 0) goto L_0x000e
            goto L_0x0018
        L_0x000e:
            com.google.firebase.perf.util.Clock r1 = r0.clock     // Catch:{ all -> 0x001a }
            com.google.firebase.perf.util.Timer r1 = r1.getTime()     // Catch:{ all -> 0x001a }
            r0.onStartTime = r1     // Catch:{ all -> 0x001a }
            monitor-exit(r0)
            return
        L_0x0018:
            monitor-exit(r0)
            return
        L_0x001a:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.perf.metrics.AppStartTrace.onActivityStarted(android.app.Activity):void");
    }

    public void onActivityStopped(Activity activity) {
    }

    @v(Lifecycle.Event.ON_STOP)
    @Keep
    public void onAppEnteredBackground() {
        if (!this.isStartedFromBackground && !this.isTooLateToInitUI && this.firstBackgroundTime == null) {
            this.firstBackgroundTime = this.clock.getTime();
            this.experimentTtid.addSubtraces((TraceMetric) TraceMetric.newBuilder().setName("_experiment_firstBackgrounding").setClientStartTimeUs(getStartTimerCompat().getMicros()).setDurationUs(getStartTimerCompat().getDurationMicros(this.firstBackgroundTime)).build());
        }
    }

    @v(Lifecycle.Event.ON_START)
    @Keep
    public void onAppEnteredForeground() {
        if (!this.isStartedFromBackground && !this.isTooLateToInitUI && this.firstForegroundTime == null) {
            this.firstForegroundTime = this.clock.getTime();
            this.experimentTtid.addSubtraces((TraceMetric) TraceMetric.newBuilder().setName("_experiment_firstForegrounding").setClientStartTimeUs(getStartTimerCompat().getMicros()).setDurationUs(getStartTimerCompat().getDurationMicros(this.firstForegroundTime)).build());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0036, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void registerActivityLifecycleCallbacks(@androidx.annotation.NonNull android.content.Context r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = r2.isRegisteredForLifecycleCallbacks     // Catch:{ all -> 0x0037 }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r2)
            return
        L_0x0007:
            androidx.lifecycle.l r0 = androidx.lifecycle.ProcessLifecycleOwner.l()     // Catch:{ all -> 0x0037 }
            androidx.lifecycle.Lifecycle r0 = r0.getLifecycle()     // Catch:{ all -> 0x0037 }
            r0.a(r2)     // Catch:{ all -> 0x0037 }
            android.content.Context r3 = r3.getApplicationContext()     // Catch:{ all -> 0x0037 }
            boolean r0 = r3 instanceof android.app.Application     // Catch:{ all -> 0x0037 }
            if (r0 == 0) goto L_0x0035
            r0 = r3
            android.app.Application r0 = (android.app.Application) r0     // Catch:{ all -> 0x0037 }
            r0.registerActivityLifecycleCallbacks(r2)     // Catch:{ all -> 0x0037 }
            boolean r0 = r2.systemForegroundCheck     // Catch:{ all -> 0x0037 }
            r1 = 1
            if (r0 != 0) goto L_0x002e
            boolean r0 = isAnyAppProcessInForeground(r3)     // Catch:{ all -> 0x0037 }
            if (r0 == 0) goto L_0x002c
            goto L_0x002e
        L_0x002c:
            r0 = 0
            goto L_0x002f
        L_0x002e:
            r0 = r1
        L_0x002f:
            r2.systemForegroundCheck = r0     // Catch:{ all -> 0x0037 }
            r2.isRegisteredForLifecycleCallbacks = r1     // Catch:{ all -> 0x0037 }
            r2.appContext = r3     // Catch:{ all -> 0x0037 }
        L_0x0035:
            monitor-exit(r2)
            return
        L_0x0037:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.perf.metrics.AppStartTrace.registerActivityLifecycleCallbacks(android.content.Context):void");
    }

    /* access modifiers changed from: package-private */
    public void setIsStartFromBackground() {
        this.isStartedFromBackground = true;
    }

    public synchronized void unregisterActivityLifecycleCallbacks() {
        if (this.isRegisteredForLifecycleCallbacks) {
            ProcessLifecycleOwner.l().getLifecycle().d(this);
            ((Application) this.appContext).unregisterActivityLifecycleCallbacks(this);
            this.isRegisteredForLifecycleCallbacks = false;
        }
    }

    @SuppressLint({"ThreadPoolCreation"})
    static AppStartTrace getInstance(TransportManager transportManager2, Clock clock2) {
        if (instance == null) {
            synchronized (AppStartTrace.class) {
                if (instance == null) {
                    instance = new AppStartTrace(transportManager2, clock2, ConfigResolver.getInstance(), new ThreadPoolExecutor(0, 1, MAX_LATENCY_BEFORE_UI_INIT + 10, TimeUnit.SECONDS, new LinkedBlockingQueue()));
                }
            }
        }
        return instance;
    }
}
