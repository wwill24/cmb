package com.clevertap.android.sdk;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f10117a = false;

    class a implements Application.ActivityLifecycleCallbacks {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f10118a;

        a(String str) {
            this.f10118a = str;
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
            String str = this.f10118a;
            if (str != null) {
                CleverTapAPI.M(activity, str);
            } else {
                CleverTapAPI.L(activity);
            }
        }

        public void onActivityDestroyed(Activity activity) {
        }

        public void onActivityPaused(Activity activity) {
            CleverTapAPI.N();
        }

        public void onActivityResumed(Activity activity) {
            String str = this.f10118a;
            if (str != null) {
                CleverTapAPI.P(activity, str);
            } else {
                CleverTapAPI.O(activity);
            }
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
        }

        public void onActivityStopped(Activity activity) {
        }
    }

    @TargetApi(14)
    public static synchronized void a(Application application) {
        synchronized (b.class) {
            b(application, (String) null);
        }
    }

    @TargetApi(14)
    public static synchronized void b(Application application, String str) {
        synchronized (b.class) {
            if (application == null) {
                p.j("Application instance is null/system API is too old");
            } else if (f10117a) {
                p.o("Lifecycle callbacks have already been registered");
            } else {
                f10117a = true;
                application.registerActivityLifecycleCallbacks(new a(str));
                p.j("Activity Lifecycle Callback successfully registered");
            }
        }
    }
}
