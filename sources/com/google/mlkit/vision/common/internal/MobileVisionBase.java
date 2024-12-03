package com.google.mlkit.vision.common.internal;

import ah.e;
import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.k;
import androidx.lifecycle.v;
import com.google.android.gms.common.internal.h;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.internal.mlkit_vision_common.zzlx;
import com.google.android.gms.tasks.CancellationTokenSource;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.common.sdkinternal.f;
import java.io.Closeable;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import zg.a;

public class MobileVisionBase<DetectionResultT> implements Closeable, k {

    /* renamed from: f  reason: collision with root package name */
    private static final h f21515f = new h("MobileVisionBase", "");

    /* renamed from: g  reason: collision with root package name */
    public static final /* synthetic */ int f21516g = 0;

    /* renamed from: a  reason: collision with root package name */
    private final AtomicBoolean f21517a = new AtomicBoolean(false);

    /* renamed from: b  reason: collision with root package name */
    private final f f21518b;

    /* renamed from: c  reason: collision with root package name */
    private final CancellationTokenSource f21519c;

    /* renamed from: d  reason: collision with root package name */
    private final Executor f21520d;

    /* renamed from: e  reason: collision with root package name */
    private final Task f21521e;

    public MobileVisionBase(@NonNull f<DetectionResultT, a> fVar, @NonNull Executor executor) {
        this.f21518b = fVar;
        CancellationTokenSource cancellationTokenSource = new CancellationTokenSource();
        this.f21519c = cancellationTokenSource;
        this.f21520d = executor;
        fVar.c();
        this.f21521e = fVar.a(executor, e.f18850a, cancellationTokenSource.getToken()).addOnFailureListener(c.f21533a);
    }

    @NonNull
    public synchronized Task<DetectionResultT> b(@NonNull a aVar) {
        p.l(aVar, "InputImage can not be null");
        if (this.f21517a.get()) {
            return Tasks.forException(new MlKitException("This detector is already closed!", 14));
        } else if (aVar.l() < 32 || aVar.h() < 32) {
            return Tasks.forException(new MlKitException("InputImage width and height should be at least 32!", 3));
        } else {
            return this.f21518b.a(this.f21520d, new b(this, aVar), this.f21519c.getToken());
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object c(a aVar) throws Exception {
        zzlx zze = zzlx.zze("detectorTaskWithResource#run");
        zze.zzb();
        try {
            Object i10 = this.f21518b.i(aVar);
            zze.close();
            return i10;
        } catch (Throwable th2) {
            try {
                Throwable.class.getDeclaredMethod("addSuppressed", new Class[]{Throwable.class}).invoke(th, new Object[]{th2});
            } catch (Exception unused) {
            }
        }
        throw th;
    }

    @v(Lifecycle.Event.ON_DESTROY)
    public synchronized void close() {
        if (!this.f21517a.getAndSet(true)) {
            this.f21519c.cancel();
            this.f21518b.e(this.f21520d);
        }
    }
}
