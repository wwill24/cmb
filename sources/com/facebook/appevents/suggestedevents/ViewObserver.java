package com.facebook.appevents.suggestedevents;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewTreeObserver;
import com.facebook.appevents.codeless.internal.SensitiveUserDataUtils;
import com.facebook.appevents.internal.AppEventUtility;
import com.facebook.appevents.suggestedevents.ViewOnClickListener;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import vc.b;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0001\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000e\u001a\u00020\fH\u0002J\b\u0010\u000f\u001a\u00020\fH\u0002R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/facebook/appevents/suggestedevents/ViewObserver;", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "activityWeakReference", "Ljava/lang/ref/WeakReference;", "isTracking", "Ljava/util/concurrent/atomic/AtomicBoolean;", "uiThreadHandler", "Landroid/os/Handler;", "onGlobalLayout", "", "process", "startTracking", "stopTracking", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ViewObserver implements ViewTreeObserver.OnGlobalLayoutListener {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int MAX_TEXT_LENGTH = 300;
    private static final Map<Integer, ViewObserver> observers = new HashMap();
    private final WeakReference<Activity> activityWeakReference;
    private final AtomicBoolean isTracking;
    private final Handler uiThreadHandler;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/facebook/appevents/suggestedevents/ViewObserver$Companion;", "", "()V", "MAX_TEXT_LENGTH", "", "observers", "", "Lcom/facebook/appevents/suggestedevents/ViewObserver;", "startTrackingActivity", "", "activity", "Landroid/app/Activity;", "stopTrackingActivity", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void startTrackingActivity(Activity activity) {
            j.g(activity, "activity");
            int hashCode = activity.hashCode();
            Map access$getObservers$cp = ViewObserver.access$getObservers$cp();
            Integer valueOf = Integer.valueOf(hashCode);
            Object obj = access$getObservers$cp.get(valueOf);
            if (obj == null) {
                obj = new ViewObserver(activity, (DefaultConstructorMarker) null);
                access$getObservers$cp.put(valueOf, obj);
            }
            ViewObserver.access$startTracking((ViewObserver) obj);
        }

        public final void stopTrackingActivity(Activity activity) {
            j.g(activity, "activity");
            ViewObserver viewObserver = (ViewObserver) ViewObserver.access$getObservers$cp().remove(Integer.valueOf(activity.hashCode()));
            if (viewObserver != null) {
                ViewObserver.access$stopTracking(viewObserver);
            }
        }
    }

    private ViewObserver(Activity activity) {
        this.activityWeakReference = new WeakReference<>(activity);
        this.uiThreadHandler = new Handler(Looper.getMainLooper());
        this.isTracking = new AtomicBoolean(false);
    }

    public /* synthetic */ ViewObserver(Activity activity, DefaultConstructorMarker defaultConstructorMarker) {
        this(activity);
    }

    public static final /* synthetic */ Map access$getObservers$cp() {
        if (CrashShieldHandler.isObjectCrashing(ViewObserver.class)) {
            return null;
        }
        try {
            return observers;
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, ViewObserver.class);
            return null;
        }
    }

    public static final /* synthetic */ void access$startTracking(ViewObserver viewObserver) {
        if (!CrashShieldHandler.isObjectCrashing(ViewObserver.class)) {
            try {
                viewObserver.startTracking();
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, ViewObserver.class);
            }
        }
    }

    public static final /* synthetic */ void access$stopTracking(ViewObserver viewObserver) {
        if (!CrashShieldHandler.isObjectCrashing(ViewObserver.class)) {
            try {
                viewObserver.stopTracking();
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, ViewObserver.class);
            }
        }
    }

    private final void process() {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                b bVar = new b(this);
                if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                    bVar.run();
                } else {
                    this.uiThreadHandler.post(bVar);
                }
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, this);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: process$lambda-0  reason: not valid java name */
    public static final void m84process$lambda0(ViewObserver viewObserver) {
        boolean z10;
        if (!CrashShieldHandler.isObjectCrashing(ViewObserver.class)) {
            try {
                j.g(viewObserver, "this$0");
                try {
                    AppEventUtility appEventUtility = AppEventUtility.INSTANCE;
                    View rootView = AppEventUtility.getRootView(viewObserver.activityWeakReference.get());
                    Activity activity = viewObserver.activityWeakReference.get();
                    if (rootView == null) {
                        return;
                    }
                    if (activity != null) {
                        for (View next : SuggestedEventViewHierarchy.getAllClickableViews(rootView)) {
                            if (!SensitiveUserDataUtils.isSensitiveUserData(next)) {
                                String textOfViewRecursively = SuggestedEventViewHierarchy.getTextOfViewRecursively(next);
                                if (textOfViewRecursively.length() > 0) {
                                    z10 = true;
                                } else {
                                    z10 = false;
                                }
                                if (z10 && textOfViewRecursively.length() <= 300) {
                                    ViewOnClickListener.Companion companion = ViewOnClickListener.Companion;
                                    String localClassName = activity.getLocalClassName();
                                    j.f(localClassName, "activity.localClassName");
                                    companion.attachListener$facebook_core_release(next, rootView, localClassName);
                                }
                            }
                        }
                    }
                } catch (Exception unused) {
                }
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, ViewObserver.class);
            }
        }
    }

    private final void startTracking() {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                if (!this.isTracking.getAndSet(true)) {
                    AppEventUtility appEventUtility = AppEventUtility.INSTANCE;
                    View rootView = AppEventUtility.getRootView(this.activityWeakReference.get());
                    if (rootView != null) {
                        ViewTreeObserver viewTreeObserver = rootView.getViewTreeObserver();
                        if (viewTreeObserver.isAlive()) {
                            viewTreeObserver.addOnGlobalLayoutListener(this);
                            process();
                        }
                    }
                }
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, this);
            }
        }
    }

    public static final void startTrackingActivity(Activity activity) {
        if (!CrashShieldHandler.isObjectCrashing(ViewObserver.class)) {
            try {
                Companion.startTrackingActivity(activity);
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, ViewObserver.class);
            }
        }
    }

    private final void stopTracking() {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                if (this.isTracking.getAndSet(false)) {
                    AppEventUtility appEventUtility = AppEventUtility.INSTANCE;
                    View rootView = AppEventUtility.getRootView(this.activityWeakReference.get());
                    if (rootView != null) {
                        ViewTreeObserver viewTreeObserver = rootView.getViewTreeObserver();
                        if (viewTreeObserver.isAlive()) {
                            viewTreeObserver.removeOnGlobalLayoutListener(this);
                        }
                    }
                }
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, this);
            }
        }
    }

    public static final void stopTrackingActivity(Activity activity) {
        if (!CrashShieldHandler.isObjectCrashing(ViewObserver.class)) {
            try {
                Companion.stopTrackingActivity(activity);
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, ViewObserver.class);
            }
        }
    }

    public void onGlobalLayout() {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                process();
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, this);
            }
        }
    }
}
