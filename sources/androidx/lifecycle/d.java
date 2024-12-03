package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import kotlin.jvm.internal.j;

public class d implements Application.ActivityLifecycleCallbacks {
    public void onActivityCreated(Activity activity, Bundle bundle) {
        j.g(activity, "activity");
    }

    public void onActivityDestroyed(Activity activity) {
        j.g(activity, "activity");
    }

    public void onActivityPaused(Activity activity) {
        j.g(activity, "activity");
    }

    public void onActivityResumed(Activity activity) {
        j.g(activity, "activity");
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        j.g(activity, "activity");
        j.g(bundle, "outState");
    }

    public void onActivityStarted(Activity activity) {
        j.g(activity, "activity");
    }

    public void onActivityStopped(Activity activity) {
        j.g(activity, "activity");
    }
}
