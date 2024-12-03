package androidx.camera.core.impl;

import androidx.concurrent.futures.CallbackToFutureAdapter;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

public final /* synthetic */ class k0 implements CallbackToFutureAdapter.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ List f2557a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ScheduledExecutorService f2558b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Executor f2559c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ long f2560d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ boolean f2561e;

    public /* synthetic */ k0(List list, ScheduledExecutorService scheduledExecutorService, Executor executor, long j10, boolean z10) {
        this.f2557a = list;
        this.f2558b = scheduledExecutorService;
        this.f2559c = executor;
        this.f2560d = j10;
        this.f2561e = z10;
    }

    public final Object a(CallbackToFutureAdapter.a aVar) {
        return o0.j(this.f2557a, this.f2558b, this.f2559c, this.f2560d, this.f2561e, aVar);
    }
}
