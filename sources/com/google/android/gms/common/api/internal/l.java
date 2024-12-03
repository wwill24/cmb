package com.google.android.gms.common.api.internal;

import android.os.Looper;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.internal.k;
import com.google.android.gms.common.internal.p;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.Executor;

public class l {

    /* renamed from: a  reason: collision with root package name */
    private final Set f38657a = Collections.newSetFromMap(new WeakHashMap());

    @NonNull
    public static <L> k<L> a(@NonNull L l10, @NonNull Looper looper, @NonNull String str) {
        p.l(l10, "Listener must not be null");
        p.l(looper, "Looper must not be null");
        p.l(str, "Listener type must not be null");
        return new k<>(looper, l10, str);
    }

    @NonNull
    public static <L> k<L> b(@NonNull L l10, @NonNull Executor executor, @NonNull String str) {
        p.l(l10, "Listener must not be null");
        p.l(executor, "Executor must not be null");
        p.l(str, "Listener type must not be null");
        return new k<>(executor, l10, str);
    }

    @NonNull
    public static <L> k.a<L> c(@NonNull L l10, @NonNull String str) {
        p.l(l10, "Listener must not be null");
        p.l(str, "Listener type must not be null");
        p.h(str, "Listener type must not be empty");
        return new k.a<>(l10, str);
    }

    public final void d() {
        for (k a10 : this.f38657a) {
            a10.a();
        }
        this.f38657a.clear();
    }
}
