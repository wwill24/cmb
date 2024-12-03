package androidx.camera.video.internal.encoder;

import android.media.MediaCodec;
import androidx.annotation.NonNull;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.h;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicReference;
import zf.a;

public class f implements g {

    /* renamed from: a  reason: collision with root package name */
    private final ByteBuffer f3303a;

    /* renamed from: b  reason: collision with root package name */
    private final MediaCodec.BufferInfo f3304b;

    /* renamed from: c  reason: collision with root package name */
    private final a<Void> f3305c;

    /* renamed from: d  reason: collision with root package name */
    private final CallbackToFutureAdapter.a<Void> f3306d;

    public f(@NonNull g gVar) {
        this.f3304b = c(gVar);
        this.f3303a = b(gVar);
        AtomicReference atomicReference = new AtomicReference();
        this.f3305c = CallbackToFutureAdapter.a(new e(atomicReference));
        this.f3306d = (CallbackToFutureAdapter.a) h.g((CallbackToFutureAdapter.a) atomicReference.get());
    }

    @NonNull
    private ByteBuffer b(@NonNull g gVar) {
        ByteBuffer q10 = gVar.q();
        MediaCodec.BufferInfo W = gVar.W();
        q10.position(W.offset);
        q10.limit(W.offset + W.size);
        ByteBuffer allocate = ByteBuffer.allocate(W.size);
        allocate.order(q10.order());
        allocate.put(q10);
        allocate.flip();
        return allocate;
    }

    @NonNull
    private MediaCodec.BufferInfo c(@NonNull g gVar) {
        MediaCodec.BufferInfo W = gVar.W();
        MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
        bufferInfo.set(0, W.size, W.presentationTimeUs, W.flags);
        return bufferInfo;
    }

    @NonNull
    public MediaCodec.BufferInfo W() {
        return this.f3304b;
    }

    public void close() {
        this.f3306d.c(null);
    }

    public boolean d0() {
        return (this.f3304b.flags & 1) != 0;
    }

    @NonNull
    public ByteBuffer q() {
        return this.f3303a;
    }

    public long size() {
        return (long) this.f3304b.size;
    }

    public long z0() {
        return this.f3304b.presentationTimeUs;
    }
}
