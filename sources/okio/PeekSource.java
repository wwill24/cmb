package okio;

import kotlin.Metadata;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b!\u0010\"J\u0018\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\tH\u0016R\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u0011\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010 \u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006#"}, d2 = {"Lokio/PeekSource;", "Lokio/Source;", "Lokio/Buffer;", "sink", "", "byteCount", "N1", "Lokio/Timeout;", "p", "", "close", "Lokio/BufferedSource;", "a", "Lokio/BufferedSource;", "upstream", "b", "Lokio/Buffer;", "buffer", "Lokio/Segment;", "c", "Lokio/Segment;", "expectedSegment", "", "d", "I", "expectedPos", "", "e", "Z", "closed", "f", "J", "pos", "<init>", "(Lokio/BufferedSource;)V", "okio"}, k = 1, mv = {1, 6, 0})
public final class PeekSource implements Source {

    /* renamed from: a  reason: collision with root package name */
    private final BufferedSource f33382a;

    /* renamed from: b  reason: collision with root package name */
    private final Buffer f33383b;

    /* renamed from: c  reason: collision with root package name */
    private Segment f33384c;

    /* renamed from: d  reason: collision with root package name */
    private int f33385d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f33386e;

    /* renamed from: f  reason: collision with root package name */
    private long f33387f;

    public PeekSource(BufferedSource bufferedSource) {
        int i10;
        j.g(bufferedSource, "upstream");
        this.f33382a = bufferedSource;
        Buffer d10 = bufferedSource.d();
        this.f33383b = d10;
        Segment segment = d10.f33298a;
        this.f33384c = segment;
        if (segment != null) {
            i10 = segment.f33409b;
        } else {
            i10 = -1;
        }
        this.f33385d = i10;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0028, code lost:
        if (r5 == r6.f33409b) goto L_0x002a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x002d  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x006f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long N1(okio.Buffer r9, long r10) {
        /*
            r8 = this;
            java.lang.String r0 = "sink"
            kotlin.jvm.internal.j.g(r9, r0)
            r0 = 0
            int r2 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            r3 = 0
            r4 = 1
            if (r2 < 0) goto L_0x000f
            r5 = r4
            goto L_0x0010
        L_0x000f:
            r5 = r3
        L_0x0010:
            if (r5 == 0) goto L_0x0087
            boolean r5 = r8.f33386e
            r5 = r5 ^ r4
            if (r5 == 0) goto L_0x007b
            okio.Segment r5 = r8.f33384c
            if (r5 == 0) goto L_0x002a
            okio.Buffer r6 = r8.f33383b
            okio.Segment r6 = r6.f33298a
            if (r5 != r6) goto L_0x002b
            int r5 = r8.f33385d
            kotlin.jvm.internal.j.d(r6)
            int r6 = r6.f33409b
            if (r5 != r6) goto L_0x002b
        L_0x002a:
            r3 = r4
        L_0x002b:
            if (r3 == 0) goto L_0x006f
            if (r2 != 0) goto L_0x0030
            return r0
        L_0x0030:
            okio.BufferedSource r0 = r8.f33382a
            long r1 = r8.f33387f
            r3 = 1
            long r1 = r1 + r3
            boolean r0 = r0.r(r1)
            if (r0 != 0) goto L_0x0040
            r9 = -1
            return r9
        L_0x0040:
            okio.Segment r0 = r8.f33384c
            if (r0 != 0) goto L_0x0053
            okio.Buffer r0 = r8.f33383b
            okio.Segment r0 = r0.f33298a
            if (r0 == 0) goto L_0x0053
            r8.f33384c = r0
            kotlin.jvm.internal.j.d(r0)
            int r0 = r0.f33409b
            r8.f33385d = r0
        L_0x0053:
            okio.Buffer r0 = r8.f33383b
            long r0 = r0.size()
            long r2 = r8.f33387f
            long r0 = r0 - r2
            long r10 = java.lang.Math.min(r10, r0)
            okio.Buffer r2 = r8.f33383b
            long r4 = r8.f33387f
            r3 = r9
            r6 = r10
            r2.h(r3, r4, r6)
            long r0 = r8.f33387f
            long r0 = r0 + r10
            r8.f33387f = r0
            return r10
        L_0x006f:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "Peek source is invalid because upstream source was used"
            java.lang.String r10 = r10.toString()
            r9.<init>(r10)
            throw r9
        L_0x007b:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "closed"
            java.lang.String r10 = r10.toString()
            r9.<init>(r10)
            throw r9
        L_0x0087:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r0 = "byteCount < 0: "
            r9.append(r0)
            r9.append(r10)
            java.lang.String r9 = r9.toString()
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            java.lang.String r9 = r9.toString()
            r10.<init>(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.PeekSource.N1(okio.Buffer, long):long");
    }

    public void close() {
        this.f33386e = true;
    }

    public Timeout p() {
        return this.f33382a.p();
    }
}
