package okio;

import kotlin.Metadata;

@Metadata(bv = {}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0007\u001a\u00020\u00028\u0000X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\f\u001a\u00020\b8\u0000X\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0003\u0010\u000bR\"\u0010\u0013\u001a\u00020\r8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\t\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0016\u001a\u00020\r8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u000f\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\"\u0010\u0019\u001a\u00020\r8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R$\u0010\u001f\u001a\u0004\u0018\u00010\u001a8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u001b\u001a\u0004\b\u000e\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0017\u0010!\u001a\u00020\u001a8G¢\u0006\f\n\u0004\b\u0015\u0010\u001b\u001a\u0004\b \u0010\u001c¨\u0006\""}, d2 = {"Lokio/Pipe;", "", "", "a", "J", "d", "()J", "maxBufferSize", "Lokio/Buffer;", "b", "Lokio/Buffer;", "()Lokio/Buffer;", "buffer", "", "c", "Z", "()Z", "setCanceled$okio", "(Z)V", "canceled", "e", "g", "sinkClosed", "f", "h", "sourceClosed", "Lokio/Sink;", "Lokio/Sink;", "()Lokio/Sink;", "setFoldedSink$okio", "(Lokio/Sink;)V", "foldedSink", "i", "sink", "okio"}, k = 1, mv = {1, 6, 0})
public final class Pipe {

    /* renamed from: a  reason: collision with root package name */
    private final long f33388a;

    /* renamed from: b  reason: collision with root package name */
    private final Buffer f33389b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f33390c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f33391d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f33392e;

    /* renamed from: f  reason: collision with root package name */
    private Sink f33393f;

    /* renamed from: g  reason: collision with root package name */
    private final Sink f33394g;

    public final Buffer a() {
        return this.f33389b;
    }

    public final boolean b() {
        return this.f33390c;
    }

    public final Sink c() {
        return this.f33393f;
    }

    public final long d() {
        return this.f33388a;
    }

    public final boolean e() {
        return this.f33391d;
    }

    public final boolean f() {
        return this.f33392e;
    }

    public final void g(boolean z10) {
        this.f33391d = z10;
    }

    public final void h(boolean z10) {
        this.f33392e = z10;
    }

    public final Sink i() {
        return this.f33394g;
    }
}
