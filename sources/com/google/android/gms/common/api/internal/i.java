package com.google.android.gms.common.api.internal;

import android.app.Activity;
import androidx.annotation.NonNull;
import androidx.fragment.app.h;
import com.google.android.gms.common.internal.p;

public class i {

    /* renamed from: a  reason: collision with root package name */
    private final Object f38635a;

    public i(@NonNull Activity activity) {
        p.l(activity, "Activity must not be null");
        this.f38635a = activity;
    }

    @NonNull
    public final Activity a() {
        return (Activity) this.f38635a;
    }

    @NonNull
    public final h b() {
        return (h) this.f38635a;
    }

    public final boolean c() {
        return this.f38635a instanceof Activity;
    }

    public final boolean d() {
        return this.f38635a instanceof h;
    }
}
