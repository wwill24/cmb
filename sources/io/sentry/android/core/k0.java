package io.sentry.android.core;

import android.app.Activity;
import androidx.annotation.NonNull;
import java.lang.ref.WeakReference;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
public class k0 {

    /* renamed from: b  reason: collision with root package name */
    private static final k0 f31058b = new k0();

    /* renamed from: a  reason: collision with root package name */
    private WeakReference<Activity> f31059a;

    private k0() {
    }

    @NonNull
    public static k0 c() {
        return f31058b;
    }

    public void a() {
        this.f31059a = null;
    }

    public Activity b() {
        WeakReference<Activity> weakReference = this.f31059a;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public void d(@NonNull Activity activity) {
        WeakReference<Activity> weakReference = this.f31059a;
        if (weakReference == null || weakReference.get() != activity) {
            this.f31059a = new WeakReference<>(activity);
        }
    }
}
