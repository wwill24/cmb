package coil.network;

import coil.util.j;
import gk.f;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import okhttp3.a0;
import okhttp3.d;
import okhttp3.s;
import okhttp3.v;
import okio.BufferedSink;
import okio.BufferedSource;

@Metadata(bv = {}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010!\u001a\u00020 ¢\u0006\u0004\b\"\u0010#B\u0011\b\u0016\u0012\u0006\u0010%\u001a\u00020$¢\u0006\u0004\b\"\u0010&J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u001b\u0010\n\u001a\u00020\u00068FX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0007\u0010\tR\u001d\u0010\u000e\u001a\u0004\u0018\u00010\u000b8FX\u0002¢\u0006\f\n\u0004\b\f\u0010\b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0014\u001a\u00020\u000f8\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0016\u001a\u00020\u000f8\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0011\u001a\u0004\b\u0010\u0010\u0013R\u0017\u0010\u001b\u001a\u00020\u00178\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\u001f\u001a\u00020\u001c8\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001d\u001a\u0004\b\u0015\u0010\u001e¨\u0006'"}, d2 = {"Lcoil/network/CacheResponse;", "", "Lokio/BufferedSink;", "sink", "", "g", "Lokhttp3/d;", "a", "Lgk/f;", "()Lokhttp3/d;", "cacheControl", "Lokhttp3/v;", "b", "()Lokhttp3/v;", "contentType", "", "c", "J", "e", "()J", "sentRequestAtMillis", "d", "receivedResponseAtMillis", "", "Z", "f", "()Z", "isTls", "Lokhttp3/s;", "Lokhttp3/s;", "()Lokhttp3/s;", "responseHeaders", "Lokio/BufferedSource;", "source", "<init>", "(Lokio/BufferedSource;)V", "Lokhttp3/a0;", "response", "(Lokhttp3/a0;)V", "coil-base_release"}, k = 1, mv = {1, 7, 1})
public final class CacheResponse {

    /* renamed from: a  reason: collision with root package name */
    private final f f8230a;

    /* renamed from: b  reason: collision with root package name */
    private final f f8231b;

    /* renamed from: c  reason: collision with root package name */
    private final long f8232c;

    /* renamed from: d  reason: collision with root package name */
    private final long f8233d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f8234e;

    /* renamed from: f  reason: collision with root package name */
    private final s f8235f;

    public CacheResponse(BufferedSource bufferedSource) {
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        this.f8230a = b.a(lazyThreadSafetyMode, new CacheResponse$cacheControl$2(this));
        this.f8231b = b.a(lazyThreadSafetyMode, new CacheResponse$contentType$2(this));
        this.f8232c = Long.parseLong(bufferedSource.w0());
        this.f8233d = Long.parseLong(bufferedSource.w0());
        this.f8234e = Integer.parseInt(bufferedSource.w0()) > 0;
        int parseInt = Integer.parseInt(bufferedSource.w0());
        s.a aVar = new s.a();
        for (int i10 = 0; i10 < parseInt; i10++) {
            j.b(aVar, bufferedSource.w0());
        }
        this.f8235f = aVar.f();
    }

    public final d a() {
        return (d) this.f8230a.getValue();
    }

    public final v b() {
        return (v) this.f8231b.getValue();
    }

    public final long c() {
        return this.f8233d;
    }

    public final s d() {
        return this.f8235f;
    }

    public final long e() {
        return this.f8232c;
    }

    public final boolean f() {
        return this.f8234e;
    }

    public final void g(BufferedSink bufferedSink) {
        long j10;
        bufferedSink.J0(this.f8232c).writeByte(10);
        bufferedSink.J0(this.f8233d).writeByte(10);
        if (this.f8234e) {
            j10 = 1;
        } else {
            j10 = 0;
        }
        bufferedSink.J0(j10).writeByte(10);
        bufferedSink.J0((long) this.f8235f.size()).writeByte(10);
        int size = this.f8235f.size();
        for (int i10 = 0; i10 < size; i10++) {
            bufferedSink.h0(this.f8235f.f(i10)).h0(": ").h0(this.f8235f.n(i10)).writeByte(10);
        }
    }

    public CacheResponse(a0 a0Var) {
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        this.f8230a = b.a(lazyThreadSafetyMode, new CacheResponse$cacheControl$2(this));
        this.f8231b = b.a(lazyThreadSafetyMode, new CacheResponse$contentType$2(this));
        this.f8232c = a0Var.G();
        this.f8233d = a0Var.E();
        this.f8234e = a0Var.h() != null;
        this.f8235f = a0Var.n();
    }
}
