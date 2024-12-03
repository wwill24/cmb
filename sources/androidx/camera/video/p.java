package androidx.camera.video;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.camera.core.impl.utils.h;
import androidx.core.content.g;
import androidx.core.util.a;
import b0.e;
import java.util.concurrent.Executor;

public final class p {

    /* renamed from: a  reason: collision with root package name */
    private final Context f3397a;

    /* renamed from: b  reason: collision with root package name */
    private final Recorder f3398b;

    /* renamed from: c  reason: collision with root package name */
    private final e f3399c;

    /* renamed from: d  reason: collision with root package name */
    private a<i0> f3400d;

    /* renamed from: e  reason: collision with root package name */
    private Executor f3401e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f3402f = false;

    p(@NonNull Context context, @NonNull Recorder recorder, @NonNull e eVar) {
        this.f3397a = h.a(context);
        this.f3398b = recorder;
        this.f3399c = eVar;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public Context a() {
        return this.f3397a;
    }

    /* access modifiers changed from: package-private */
    public a<i0> b() {
        return this.f3400d;
    }

    /* access modifiers changed from: package-private */
    public Executor c() {
        return this.f3401e;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public e d() {
        return this.f3399c;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public Recorder e() {
        return this.f3398b;
    }

    /* access modifiers changed from: package-private */
    public boolean f() {
        return this.f3402f;
    }

    @NonNull
    public d0 g(@NonNull Executor executor, @NonNull a<i0> aVar) {
        androidx.core.util.h.h(executor, "Listener Executor can't be null.");
        androidx.core.util.h.h(aVar, "Event listener can't be null");
        this.f3401e = executor;
        this.f3400d = aVar;
        return this.f3398b.u0(this);
    }

    @NonNull
    public p h() {
        if (g.b(this.f3397a, "android.permission.RECORD_AUDIO") != -1) {
            androidx.core.util.h.j(this.f3398b.G(), "The Recorder this recording is associated to doesn't support audio.");
            this.f3402f = true;
            return this;
        }
        throw new SecurityException("Attempted to enable audio for recording but application does not have RECORD_AUDIO permission granted.");
    }
}
