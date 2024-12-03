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

public class i implements g {

    /* renamed from: a  reason: collision with root package name */
    private final MediaCodec f3313a;

    /* renamed from: b  reason: collision with root package name */
    private final MediaCodec.BufferInfo f3314b;

    /* renamed from: c  reason: collision with root package name */
    private final int f3315c;

    /* renamed from: d  reason: collision with root package name */
    private final ByteBuffer f3316d;

    /* renamed from: e  reason: collision with root package name */
    private final a<Void> f3317e;

    /* renamed from: f  reason: collision with root package name */
    private final CallbackToFutureAdapter.a<Void> f3318f;

    /* renamed from: g  reason: collision with root package name */
    private final AtomicBoolean f3319g = new AtomicBoolean(false);

    i(@NonNull MediaCodec mediaCodec, int i10, @NonNull MediaCodec.BufferInfo bufferInfo) throws MediaCodec.CodecException {
        this.f3313a = (MediaCodec) h.g(mediaCodec);
        this.f3315c = i10;
        this.f3316d = mediaCodec.getOutputBuffer(i10);
        this.f3314b = (MediaCodec.BufferInfo) h.g(bufferInfo);
        AtomicReference atomicReference = new AtomicReference();
        this.f3317e = CallbackToFutureAdapter.a(new h(atomicReference));
        this.f3318f = (CallbackToFutureAdapter.a) h.g((CallbackToFutureAdapter.a) atomicReference.get());
    }

    private void e() {
        if (this.f3319g.get()) {
            throw new IllegalStateException("encoded data is closed.");
        }
    }

    @NonNull
    public MediaCodec.BufferInfo W() {
        return this.f3314b;
    }

    @NonNull
    public a<Void> b() {
        return f.j(this.f3317e);
    }

    public void close() {
        if (!this.f3319g.getAndSet(true)) {
            try {
                this.f3313a.releaseOutputBuffer(this.f3315c, false);
                this.f3318f.c(null);
            } catch (IllegalStateException e10) {
                this.f3318f.f(e10);
            }
        }
    }

    public boolean d0() {
        return (this.f3314b.flags & 1) != 0;
    }

    @NonNull
    public ByteBuffer q() {
        e();
        this.f3316d.position(this.f3314b.offset);
        ByteBuffer byteBuffer = this.f3316d;
        MediaCodec.BufferInfo bufferInfo = this.f3314b;
        byteBuffer.limit(bufferInfo.offset + bufferInfo.size);
        return this.f3316d;
    }

    public long size() {
        return (long) this.f3314b.size;
    }

    public long z0() {
        return this.f3314b.presentationTimeUs;
    }
}
