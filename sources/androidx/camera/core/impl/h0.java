package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.camera.core.impl.l1;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import u.f;
import zf.a;

public final class h0<T> implements l1<T> {

    /* renamed from: b  reason: collision with root package name */
    private static final h0<Object> f2546b = new h0<>((Object) null);

    /* renamed from: a  reason: collision with root package name */
    private final a<T> f2547a;

    private h0(T t10) {
        this.f2547a = f.h(t10);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void f(l1.a aVar) {
        try {
            aVar.a(this.f2547a.get());
        } catch (InterruptedException | ExecutionException e10) {
            aVar.onError(e10);
        }
    }

    @NonNull
    public static <U> l1<U> g(U u10) {
        if (u10 == null) {
            return f2546b;
        }
        return new h0(u10);
    }

    @NonNull
    public a<T> b() {
        return this.f2547a;
    }

    public void c(@NonNull Executor executor, @NonNull l1.a<? super T> aVar) {
        this.f2547a.addListener(new g0(this, aVar), executor);
    }

    public void d(@NonNull l1.a<? super T> aVar) {
    }
}
