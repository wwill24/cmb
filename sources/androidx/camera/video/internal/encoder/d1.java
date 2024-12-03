package androidx.camera.video.internal.encoder;

import android.media.MediaCodec;
import androidx.annotation.NonNull;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.h;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import u.f;
import zf.a;

class d1 implements b1 {

    /* renamed from: a  reason: collision with root package name */
    private final MediaCodec f3292a;

    /* renamed from: b  reason: collision with root package name */
    private final int f3293b;

    /* renamed from: c  reason: collision with root package name */
    private final ByteBuffer f3294c;

    /* renamed from: d  reason: collision with root package name */
    private final a<Void> f3295d;

    /* renamed from: e  reason: collision with root package name */
    private final CallbackToFutureAdapter.a<Void> f3296e;

    /* renamed from: f  reason: collision with root package name */
    private final AtomicBoolean f3297f = new AtomicBoolean(false);

    /* renamed from: g  reason: collision with root package name */
    private long f3298g = 0;

    /* renamed from: h  reason: collision with root package name */
    private boolean f3299h = false;

    d1(@NonNull MediaCodec mediaCodec, int i10) throws MediaCodec.CodecException {
        this.f3292a = (MediaCodec) h.g(mediaCodec);
        this.f3293b = h.d(i10);
        this.f3294c = mediaCodec.getInputBuffer(i10);
        AtomicReference atomicReference = new AtomicReference();
        this.f3295d = CallbackToFutureAdapter.a(new c1(atomicReference));
        this.f3296e = (CallbackToFutureAdapter.a) h.g((CallbackToFutureAdapter.a) atomicReference.get());
    }

    private void g() {
        if (this.f3297f.get()) {
            throw new IllegalStateException("The buffer is submitted or canceled.");
        }
    }

    public void a(boolean z10) {
        g();
        this.f3299h = z10;
    }

    public boolean b() {
        int i10;
        if (this.f3297f.getAndSet(true)) {
            return false;
        }
        try {
            MediaCodec mediaCodec = this.f3292a;
            int i11 = this.f3293b;
            int position = this.f3294c.position();
            int limit = this.f3294c.limit();
            long j10 = this.f3298g;
            if (this.f3299h) {
                i10 = 4;
            } else {
                i10 = 0;
            }
            mediaCodec.queueInputBuffer(i11, position, limit, j10, i10);
            this.f3296e.c(null);
            return true;
        } catch (IllegalStateException e10) {
            this.f3296e.f(e10);
            return false;
        }
    }

    public void c(long j10) {
        boolean z10;
        g();
        if (j10 >= 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        h.a(z10);
        this.f3298g = j10;
    }

    public boolean cancel() {
        if (this.f3297f.getAndSet(true)) {
            return false;
        }
        try {
            this.f3292a.queueInputBuffer(this.f3293b, 0, 0, 0, 0);
            this.f3296e.c(null);
        } catch (IllegalStateException e10) {
            this.f3296e.f(e10);
        }
        return true;
    }

    @NonNull
    public a<Void> d() {
        return f.j(this.f3295d);
    }

    @NonNull
    public ByteBuffer q() {
        g();
        return this.f3294c;
    }
}
