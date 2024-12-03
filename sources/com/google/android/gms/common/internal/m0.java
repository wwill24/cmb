package com.google.android.gms.common.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.f;
import com.google.android.gms.common.internal.o;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.TimeUnit;

final class m0 implements f.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ f f39021a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ TaskCompletionSource f39022b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ o.a f39023c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ o0 f39024d;

    m0(f fVar, TaskCompletionSource taskCompletionSource, o.a aVar, o0 o0Var) {
        this.f39021a = fVar;
        this.f39022b = taskCompletionSource;
        this.f39023c = aVar;
        this.f39024d = o0Var;
    }

    public final void a(Status status) {
        if (status.i0()) {
            this.f39022b.setResult(this.f39023c.a(this.f39021a.await(0, TimeUnit.MILLISECONDS)));
            return;
        }
        this.f39022b.setException(b.a(status));
    }
}
