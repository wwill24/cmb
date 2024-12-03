package okio;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\r\b\u0000\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001fB\t\b\u0016¢\u0006\u0004\b\u001b\u0010\u001cB1\b\u0016\u0012\u0006\u0010\u000f\u001a\u00020\r\u0012\u0006\u0010\u0011\u001a\u00020\u0006\u0012\u0006\u0010\u0012\u001a\u00020\u0006\u0012\u0006\u0010\u0015\u001a\u00020\u0013\u0012\u0006\u0010\u0016\u001a\u00020\u0013¢\u0006\u0004\b\u001b\u0010\u001dJ\u0006\u0010\u0002\u001a\u00020\u0000J\b\u0010\u0003\u001a\u0004\u0018\u00010\u0000J\u000e\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0000J\u000e\u0010\b\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\n\u001a\u00020\tJ\u0016\u0010\f\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006R\u0014\u0010\u000f\u001a\u00020\r8\u0006X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000eR\u0016\u0010\u0011\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0010R\u0016\u0010\u0012\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00138\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\b\u0002\u0010\u0014R\u0016\u0010\u0016\u001a\u00020\u00138\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u0014R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00008\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\b\f\u0010\u0017R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00008\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u0017¨\u0006 "}, d2 = {"Lokio/Segment;", "", "d", "b", "segment", "c", "", "byteCount", "e", "", "a", "sink", "f", "", "[B", "data", "I", "pos", "limit", "", "Z", "shared", "owner", "Lokio/Segment;", "next", "g", "prev", "<init>", "()V", "([BIIZZ)V", "h", "Companion", "okio"}, k = 1, mv = {1, 6, 0})
public final class Segment {

    /* renamed from: h  reason: collision with root package name */
    public static final Companion f33407h = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f33408a;

    /* renamed from: b  reason: collision with root package name */
    public int f33409b;

    /* renamed from: c  reason: collision with root package name */
    public int f33410c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f33411d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f33412e;

    /* renamed from: f  reason: collision with root package name */
    public Segment f33413f;

    /* renamed from: g  reason: collision with root package name */
    public Segment f33414g;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lokio/Segment$Companion;", "", "()V", "SHARE_MINIMUM", "", "SIZE", "okio"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public Segment() {
        this.f33408a = new byte[8192];
        this.f33412e = true;
        this.f33411d = false;
    }

    public final void a() {
        boolean z10;
        Segment segment = this.f33414g;
        int i10 = 0;
        if (segment != this) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            j.d(segment);
            if (segment.f33412e) {
                int i11 = this.f33410c - this.f33409b;
                Segment segment2 = this.f33414g;
                j.d(segment2);
                int i12 = 8192 - segment2.f33410c;
                Segment segment3 = this.f33414g;
                j.d(segment3);
                if (!segment3.f33411d) {
                    Segment segment4 = this.f33414g;
                    j.d(segment4);
                    i10 = segment4.f33409b;
                }
                if (i11 <= i12 + i10) {
                    Segment segment5 = this.f33414g;
                    j.d(segment5);
                    f(segment5, i11);
                    b();
                    SegmentPool.b(this);
                    return;
                }
                return;
            }
            return;
        }
        throw new IllegalStateException("cannot compact".toString());
    }

    public final Segment b() {
        Segment segment = this.f33413f;
        if (segment == this) {
            segment = null;
        }
        Segment segment2 = this.f33414g;
        j.d(segment2);
        segment2.f33413f = this.f33413f;
        Segment segment3 = this.f33413f;
        j.d(segment3);
        segment3.f33414g = this.f33414g;
        this.f33413f = null;
        this.f33414g = null;
        return segment;
    }

    public final Segment c(Segment segment) {
        j.g(segment, "segment");
        segment.f33414g = this;
        segment.f33413f = this.f33413f;
        Segment segment2 = this.f33413f;
        j.d(segment2);
        segment2.f33414g = segment;
        this.f33413f = segment;
        return segment;
    }

    public final Segment d() {
        this.f33411d = true;
        return new Segment(this.f33408a, this.f33409b, this.f33410c, true, false);
    }

    public final Segment e(int i10) {
        boolean z10;
        Segment segment;
        if (i10 <= 0 || i10 > this.f33410c - this.f33409b) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (z10) {
            if (i10 >= 1024) {
                segment = d();
            } else {
                segment = SegmentPool.c();
                byte[] bArr = this.f33408a;
                byte[] bArr2 = segment.f33408a;
                int i11 = this.f33409b;
                byte[] unused = k.h(bArr, bArr2, 0, i11, i11 + i10, 2, (Object) null);
            }
            segment.f33410c = segment.f33409b + i10;
            this.f33409b += i10;
            Segment segment2 = this.f33414g;
            j.d(segment2);
            segment2.c(segment);
            return segment;
        }
        throw new IllegalArgumentException("byteCount out of range".toString());
    }

    public final void f(Segment segment, int i10) {
        j.g(segment, "sink");
        if (segment.f33412e) {
            int i11 = segment.f33410c;
            if (i11 + i10 > 8192) {
                if (!segment.f33411d) {
                    int i12 = segment.f33409b;
                    if ((i11 + i10) - i12 <= 8192) {
                        byte[] bArr = segment.f33408a;
                        byte[] unused = k.h(bArr, bArr, 0, i12, i11, 2, (Object) null);
                        segment.f33410c -= segment.f33409b;
                        segment.f33409b = 0;
                    } else {
                        throw new IllegalArgumentException();
                    }
                } else {
                    throw new IllegalArgumentException();
                }
            }
            byte[] bArr2 = this.f33408a;
            byte[] bArr3 = segment.f33408a;
            int i13 = segment.f33410c;
            int i14 = this.f33409b;
            byte[] unused2 = k.f(bArr2, bArr3, i13, i14, i14 + i10);
            segment.f33410c += i10;
            this.f33409b += i10;
            return;
        }
        throw new IllegalStateException("only owner can write".toString());
    }

    public Segment(byte[] bArr, int i10, int i11, boolean z10, boolean z11) {
        j.g(bArr, "data");
        this.f33408a = bArr;
        this.f33409b = i10;
        this.f33410c = i11;
        this.f33411d = z10;
        this.f33412e = z11;
    }
}
