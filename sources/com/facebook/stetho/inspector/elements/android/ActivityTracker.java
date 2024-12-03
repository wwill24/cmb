package com.facebook.stetho.inspector.elements.android;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.facebook.stetho.common.Util;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public final class ActivityTracker {
    private static final ActivityTracker sInstance = new ActivityTracker();
    private final ArrayList<WeakReference<Activity>> mActivities;
    private final List<WeakReference<Activity>> mActivitiesUnmodifiable;
    private AutomaticTracker mAutomaticTracker;
    private final List<Listener> mListeners = new CopyOnWriteArrayList();

    private static abstract class AutomaticTracker {

        @TargetApi(14)
        private static class AutomaticTrackerICSAndBeyond extends AutomaticTracker {
            private final Application mApplication;
            private final Application.ActivityLifecycleCallbacks mLifecycleCallbacks = new Application.ActivityLifecycleCallbacks() {
                public void onActivityCreated(Activity activity, Bundle bundle) {
                    AutomaticTrackerICSAndBeyond.this.mTracker.add(activity);
                }

                public void onActivityDestroyed(Activity activity) {
                    AutomaticTrackerICSAndBeyond.this.mTracker.remove(activity);
                }

                public void onActivityPaused(Activity activity) {
                }

                public void onActivityResumed(Activity activity) {
                }

                public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                }

                public void onActivityStarted(Activity activity) {
                }

                public void onActivityStopped(Activity activity) {
                }
            };
            /* access modifiers changed from: private */
            public final ActivityTracker mTracker;

            public AutomaticTrackerICSAndBeyond(Application application, ActivityTracker activityTracker) {
                super();
                this.mApplication = application;
                this.mTracker = activityTracker;
            }

            public void register() {
                this.mApplication.registerActivityLifecycleCallbacks(this.mLifecycleCallbacks);
            }

            public void unregister() {
                this.mApplication.unregisterActivityLifecycleCallbacks(this.mLifecycleCallbacks);
            }
        }

        private AutomaticTracker() {
        }

        @NonNull
        public static AutomaticTracker newInstance(Application application, ActivityTracker activityTracker) {
            return new AutomaticTrackerICSAndBeyond(application, activityTracker);
        }

        public abstract void register();

        public abstract void unregister();
    }

    public interface Listener {
        void onActivityAdded(Activity activity);

        void onActivityRemoved(Activity activity);
    }

    public ActivityTracker() {
        ArrayList<WeakReference<Activity>> arrayList = new ArrayList<>();
        this.mActivities = arrayList;
        this.mActivitiesUnmodifiable = Collections.unmodifiableList(arrayList);
    }

    public static ActivityTracker get() {
        return sInstance;
    }

    private static <T> boolean removeFromWeakList(ArrayList<WeakReference<T>> arrayList, T t10) {
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (arrayList.get(i10).get() == t10) {
                arrayList.remove(i10);
                return true;
            }
        }
        return false;
    }

    public void add(Activity activity) {
        boolean z10;
        Util.throwIfNull(activity);
        if (Looper.myLooper() == Looper.getMainLooper()) {
            z10 = true;
        } else {
            z10 = false;
        }
        Util.throwIfNot(z10);
        this.mActivities.add(new WeakReference(activity));
        for (Listener onActivityAdded : this.mListeners) {
            onActivityAdded.onActivityAdded(activity);
        }
    }

    public boolean beginTrackingIfPossible(Application application) {
        if (this.mAutomaticTracker != null) {
            return false;
        }
        AutomaticTracker newInstance = AutomaticTracker.newInstance(application, this);
        newInstance.register();
        this.mAutomaticTracker = newInstance;
        return true;
    }

    public boolean endTracking() {
        AutomaticTracker automaticTracker = this.mAutomaticTracker;
        if (automaticTracker == null) {
            return false;
        }
        automaticTracker.unregister();
        this.mAutomaticTracker = null;
        return true;
    }

    public List<WeakReference<Activity>> getActivitiesView() {
        return this.mActivitiesUnmodifiable;
    }

    public void registerListener(Listener listener) {
        this.mListeners.add(listener);
    }

    public void remove(Activity activity) {
        boolean z10;
        Util.throwIfNull(activity);
        if (Looper.myLooper() == Looper.getMainLooper()) {
            z10 = true;
        } else {
            z10 = false;
        }
        Util.throwIfNot(z10);
        if (removeFromWeakList(this.mActivities, activity)) {
            for (Listener onActivityRemoved : this.mListeners) {
                onActivityRemoved.onActivityRemoved(activity);
            }
        }
    }

    public Activity tryGetTopActivity() {
        if (this.mActivitiesUnmodifiable.isEmpty()) {
            return null;
        }
        for (int size = this.mActivitiesUnmodifiable.size() - 1; size >= 0; size--) {
            Activity activity = (Activity) this.mActivitiesUnmodifiable.get(size).get();
            if (activity != null) {
                return activity;
            }
        }
        return null;
    }

    public void unregisterListener(Listener listener) {
        this.mListeners.remove(listener);
    }
}
