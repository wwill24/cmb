package androidx.camera.video;

import androidx.annotation.NonNull;
import androidx.camera.core.impl.utils.d;
import androidx.core.util.h;
import b0.e;
import com.leanplum.internal.RequestBuilder;
import java.util.concurrent.atomic.AtomicBoolean;

public final class d0 implements AutoCloseable {

    /* renamed from: a  reason: collision with root package name */
    private final AtomicBoolean f3093a;

    /* renamed from: b  reason: collision with root package name */
    private final Recorder f3094b;

    /* renamed from: c  reason: collision with root package name */
    private final long f3095c;

    /* renamed from: d  reason: collision with root package name */
    private final e f3096d;

    /* renamed from: e  reason: collision with root package name */
    private final d f3097e;

    d0(@NonNull Recorder recorder, long j10, @NonNull e eVar, boolean z10) {
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        this.f3093a = atomicBoolean;
        d b10 = d.b();
        this.f3097e = b10;
        this.f3094b = recorder;
        this.f3095c = j10;
        this.f3096d = eVar;
        if (z10) {
            atomicBoolean.set(true);
        } else {
            b10.c(RequestBuilder.ACTION_STOP);
        }
    }

    @NonNull
    static d0 a(@NonNull p pVar, long j10) {
        h.h(pVar, "The given PendingRecording cannot be null.");
        return new d0(pVar.e(), j10, pVar.d(), true);
    }

    @NonNull
    static d0 b(@NonNull p pVar, long j10) {
        h.h(pVar, "The given PendingRecording cannot be null.");
        return new d0(pVar.e(), j10, pVar.d(), false);
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public e c() {
        return this.f3096d;
    }

    public void close() {
        f();
    }

    /* access modifiers changed from: package-private */
    public long e() {
        return this.f3095c;
    }

    public void f() {
        this.f3097e.a();
        if (!this.f3093a.getAndSet(true)) {
            this.f3094b.x0(this);
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        try {
            this.f3097e.d();
            f();
        } finally {
            super.finalize();
        }
    }
}
