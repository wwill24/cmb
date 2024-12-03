package com.google.android.gms.common.moduleinstall.internal;

import com.google.android.gms.common.api.internal.q;
import com.google.android.gms.tasks.TaskCompletionSource;
import ie.a;
import java.util.concurrent.atomic.AtomicReference;

public final /* synthetic */ class d implements q {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ i f39113a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AtomicReference f39114b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ a f39115c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ ApiFeatureRequest f39116d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ b f39117e;

    public /* synthetic */ d(i iVar, AtomicReference atomicReference, a aVar, ApiFeatureRequest apiFeatureRequest, b bVar) {
        this.f39113a = iVar;
        this.f39114b = atomicReference;
        this.f39115c = aVar;
        this.f39116d = apiFeatureRequest;
        this.f39117e = bVar;
    }

    public final void accept(Object obj, Object obj2) {
        i iVar = this.f39113a;
        AtomicReference atomicReference = this.f39114b;
        a aVar = this.f39115c;
        ApiFeatureRequest apiFeatureRequest = this.f39116d;
        b bVar = this.f39117e;
        ((c) ((j) obj).getService()).f(new g(iVar, atomicReference, (TaskCompletionSource) obj2, aVar), apiFeatureRequest, bVar);
    }
}
