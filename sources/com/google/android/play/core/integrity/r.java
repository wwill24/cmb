package com.google.android.play.core.integrity;

import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.play.integrity.internal.o;
import com.google.android.play.integrity.internal.w;

final class r extends o {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ byte[] f20493a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Long f20494b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ TaskCompletionSource f20495c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ IntegrityTokenRequest f20496d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ t f20497e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    r(t tVar, TaskCompletionSource taskCompletionSource, byte[] bArr, Long l10, TaskCompletionSource taskCompletionSource2, IntegrityTokenRequest integrityTokenRequest) {
        super(taskCompletionSource);
        this.f20497e = tVar;
        this.f20493a = bArr;
        this.f20494b = l10;
        this.f20495c = taskCompletionSource2;
        this.f20496d = integrityTokenRequest;
    }

    public final void a(Exception exc) {
        if (exc instanceof w) {
            super.a(new IntegrityServiceException(-9, exc));
        } else {
            super.a(exc);
        }
    }

    /* JADX WARNING: type inference failed for: r0v3, types: [android.os.IInterface, com.google.android.play.integrity.internal.k] */
    /* access modifiers changed from: protected */
    public final void b() {
        try {
            this.f20497e.f20501a.e().p0(t.a(this.f20497e, this.f20493a, this.f20494b), new s(this.f20497e, this.f20495c));
        } catch (RemoteException e10) {
            this.f20497e.f20502b.c(e10, "requestIntegrityToken(%s)", this.f20496d);
            this.f20495c.trySetException(new IntegrityServiceException(-100, e10));
        }
    }
}
