package com.google.android.play.core.integrity;

import android.os.Bundle;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.play.integrity.internal.l;
import com.google.android.play.integrity.internal.n;

final class s extends l {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ t f20498a;

    /* renamed from: b  reason: collision with root package name */
    private final n f20499b = new n("OnRequestIntegrityTokenCallback");

    /* renamed from: c  reason: collision with root package name */
    private final TaskCompletionSource f20500c;

    s(t tVar, TaskCompletionSource taskCompletionSource) {
        this.f20498a = tVar;
        this.f20500c = taskCompletionSource;
    }

    public final void b(Bundle bundle) {
        this.f20498a.f20501a.r(this.f20500c);
        this.f20499b.d("onRequestIntegrityToken", new Object[0]);
        int i10 = bundle.getInt("error");
        if (i10 != 0) {
            this.f20500c.trySetException(new IntegrityServiceException(i10, (Throwable) null));
            return;
        }
        String string = bundle.getString("token");
        if (string == null) {
            this.f20500c.trySetException(new IntegrityServiceException(-100, (Throwable) null));
            return;
        }
        TaskCompletionSource taskCompletionSource = this.f20500c;
        d dVar = new d();
        dVar.a(string);
        taskCompletionSource.trySetResult(dVar.b());
    }
}
