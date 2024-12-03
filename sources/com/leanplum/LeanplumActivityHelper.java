package com.leanplum;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import com.leanplum.actions.internal.ActionManagerExecutionKt;
import com.leanplum.annotations.Parser;
import com.leanplum.internal.ActionManager;
import com.leanplum.internal.Constants;
import com.leanplum.internal.LeanplumInternal;
import com.leanplum.internal.Log;
import com.leanplum.internal.OperationQueue;
import com.leanplum.migration.MigrationManager;
import com.leanplum.utils.BuildUtil;
import java.util.LinkedList;
import java.util.Queue;

public class LeanplumActivityHelper {
    private static Activity currentActivity;
    static boolean isActivityPaused;
    private static Activity lastForegroundActivity;
    private static final Queue<Runnable> pendingActions = new LinkedList();
    private static boolean registeredCallbacks;
    private static final Runnable runPendingActionsRunnable = new Runnable() {
        public void run() {
            LeanplumActivityHelper.runPendingActions();
        }
    };
    private final Activity activity;
    private LeanplumInflater inflater;
    private LeanplumResources res;

    static class LeanplumLifecycleCallbacks implements Application.ActivityLifecycleCallbacks {
        LeanplumLifecycleCallbacks() {
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public void onActivityDestroyed(Activity activity) {
            try {
                LeanplumActivityHelper.onDestroy(activity);
            } catch (Throwable th2) {
                Log.exception(th2);
            }
        }

        public void onActivityPaused(Activity activity) {
            try {
                LeanplumActivityHelper.onPause(activity);
            } catch (Throwable th2) {
                Log.exception(th2);
            }
        }

        public void onActivityResumed(Activity activity) {
            try {
                LeanplumActivityHelper.onResume(activity);
                if (Leanplum.isScreenTrackingEnabled()) {
                    Leanplum.advanceTo(activity.getLocalClassName());
                }
            } catch (Throwable th2) {
                Log.exception(th2);
            }
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
        }

        public void onActivityStopped(Activity activity) {
            try {
                LeanplumActivityHelper.onStop(activity);
            } catch (Throwable th2) {
                Log.exception(th2);
            }
        }
    }

    @TargetApi(31)
    static class NoTrampolinesLifecycleCallbacks extends LeanplumLifecycleCallbacks {
        NoTrampolinesLifecycleCallbacks() {
        }

        /* access modifiers changed from: private */
        /* renamed from: handleNotificationPayload */
        public void lambda$onActivityResumed$0(Bundle bundle) {
            Class<LeanplumPushService> cls = LeanplumPushService.class;
            try {
                String str = LeanplumPushService.LEANPLUM_SENDER_ID;
                cls.getDeclaredMethod("onActivityNotificationClick", new Class[]{Bundle.class}).invoke((Object) null, new Object[]{bundle});
            } catch (Throwable th2) {
                Log.e("Push Notification action not run. Did you forget leanplum-push module?", th2);
            }
        }

        public void onActivityResumed(Activity activity) {
            Bundle extras;
            super.onActivityResumed(activity);
            if (activity.getIntent() != null && (extras = activity.getIntent().getExtras()) != null && extras.containsKey(Constants.Keys.PUSH_MESSAGE_TEXT)) {
                OperationQueue.sharedInstance().addParallelOperation(new p(this, extras));
            }
        }
    }

    public LeanplumActivityHelper(Activity activity2) {
        this.activity = activity2;
        Leanplum.setApplicationContext(activity2.getApplicationContext());
        Parser.parseVariables(activity2);
    }

    private static void avoidWindowLeaks(Activity activity2) {
        boolean z10;
        Activity activity3;
        boolean z11 = true;
        if (currentActivity != null || (activity3 = lastForegroundActivity) == null || activity3.equals(activity2)) {
            z10 = false;
        } else {
            z10 = true;
        }
        Activity activity4 = currentActivity;
        if (activity4 == null || activity4.equals(activity2)) {
            z11 = false;
        }
        if (z10 || z11) {
            ActionManagerExecutionKt.dismissCurrentAction(ActionManager.getInstance());
        }
    }

    static boolean canPresentMessages() {
        Activity activity2 = currentActivity;
        if (activity2 == null || activity2.isFinishing() || isActivityPaused) {
            return false;
        }
        return true;
    }

    public static void enableLifecycleCallbacks(Application application) {
        Leanplum.setApplicationContext(application.getApplicationContext());
        if (BuildUtil.shouldDisableTrampolines(application)) {
            application.registerActivityLifecycleCallbacks(new NoTrampolinesLifecycleCallbacks());
        } else {
            application.registerActivityLifecycleCallbacks(new LeanplumLifecycleCallbacks());
        }
        MigrationManager.getWrapper().registerLifecycleCallback(application);
        registeredCallbacks = true;
        LeanplumInternal.addStartIssuedHandler(runPendingActionsRunnable);
    }

    public static Activity getCurrentActivity() {
        return currentActivity;
    }

    public static boolean isActivityPaused() {
        return isActivityPaused;
    }

    /* access modifiers changed from: private */
    public static void onDestroy(Activity activity2) {
        Activity activity3;
        if (isActivityPaused && (activity3 = lastForegroundActivity) != null && activity3.equals(activity2)) {
            lastForegroundActivity = null;
            ActionManagerExecutionKt.dismissCurrentAction(ActionManager.getInstance());
        }
    }

    /* access modifiers changed from: private */
    public static void onPause(Activity activity2) {
        isActivityPaused = true;
        ActionManager.getInstance().setPaused(true);
    }

    /* access modifiers changed from: private */
    public static void onResume(Activity activity2) {
        avoidWindowLeaks(activity2);
        isActivityPaused = false;
        currentActivity = activity2;
        if (ActionManager.getInstance().getContinueOnActivityResumed()) {
            ActionManager.getInstance().setPaused(false);
        }
        if (LeanplumInternal.isPaused() || LeanplumInternal.hasStartedInBackground()) {
            Leanplum.resume();
            LocationManager locationManager = ActionManager.getLocationManager();
            if (locationManager != null) {
                locationManager.updateGeofencing();
                locationManager.updateUserLocation();
            }
        }
        LeanplumInternal.addStartIssuedHandler(runPendingActionsRunnable);
    }

    /* access modifiers changed from: private */
    public static void onStop(Activity activity2) {
        if (isActivityPaused) {
            Leanplum.pause();
            LocationManager locationManager = ActionManager.getLocationManager();
            if (locationManager != null) {
                locationManager.updateGeofencing();
            }
        }
        Activity activity3 = currentActivity;
        if (activity3 != null && activity3.equals(activity2)) {
            lastForegroundActivity = currentActivity;
            currentActivity = null;
        }
    }

    public static void queueActionUponActive(Runnable runnable) {
        try {
            if (canPresentMessages()) {
                runnable.run();
                return;
            }
            Queue<Runnable> queue = pendingActions;
            synchronized (queue) {
                queue.add(runnable);
            }
        } catch (Throwable th2) {
            Log.exception(th2);
        }
    }

    /* access modifiers changed from: private */
    public static void runPendingActions() {
        LinkedList<Runnable> linkedList;
        if (!isActivityPaused && currentActivity != null) {
            Queue<Runnable> queue = pendingActions;
            synchronized (queue) {
                linkedList = new LinkedList<>(queue);
                queue.clear();
            }
            for (Runnable run : linkedList) {
                run.run();
            }
        }
    }

    public static void setCurrentActivity(Context context) {
        if (context instanceof Activity) {
            currentActivity = (Activity) context;
            LeanplumInternal.addStartIssuedHandler(runPendingActionsRunnable);
        }
    }

    public LeanplumResources getLeanplumResources() {
        return getLeanplumResources((Resources) null);
    }

    public void setContentView(int i10) {
        if (this.inflater == null) {
            this.inflater = LeanplumInflater.from(this.activity);
        }
        this.activity.setContentView(this.inflater.inflate(i10));
    }

    public LeanplumResources getLeanplumResources(Resources resources) {
        LeanplumResources leanplumResources = this.res;
        if (leanplumResources != null) {
            return leanplumResources;
        }
        if (resources == null) {
            resources = this.activity.getResources();
        }
        if (resources instanceof LeanplumResources) {
            return (LeanplumResources) resources;
        }
        LeanplumResources leanplumResources2 = new LeanplumResources(resources);
        this.res = leanplumResources2;
        return leanplumResources2;
    }

    public void onPause() {
        try {
            if (!registeredCallbacks) {
                onPause(this.activity);
            }
        } catch (Throwable th2) {
            Log.exception(th2);
        }
    }

    public void onStop() {
        try {
            if (!registeredCallbacks) {
                onStop(this.activity);
            }
        } catch (Throwable th2) {
            Log.exception(th2);
        }
    }

    public void onResume() {
        try {
            if (!registeredCallbacks) {
                onResume(this.activity);
            }
        } catch (Throwable th2) {
            Log.exception(th2);
        }
    }
}
