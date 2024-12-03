package com.google.android.gms.common.api.internal;

import androidx.collection.a;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.AvailabilityException;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Set;

public final class e3 {

    /* renamed from: a  reason: collision with root package name */
    private final a f38594a;

    /* renamed from: b  reason: collision with root package name */
    private final a f38595b;

    /* renamed from: c  reason: collision with root package name */
    private final TaskCompletionSource f38596c;

    /* renamed from: d  reason: collision with root package name */
    private int f38597d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f38598e;

    public final Set a() {
        return this.f38594a.keySet();
    }

    public final void b(b bVar, ConnectionResult connectionResult, String str) {
        this.f38594a.put(bVar, connectionResult);
        this.f38595b.put(bVar, str);
        this.f38597d--;
        if (!connectionResult.i0()) {
            this.f38598e = true;
        }
        if (this.f38597d != 0) {
            return;
        }
        if (this.f38598e) {
            this.f38596c.setException(new AvailabilityException(this.f38594a));
            return;
        }
        this.f38596c.setResult(this.f38595b);
    }
}
