package okio.internal;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.j;
import okio.Path;

@Metadata(bv = {}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010!\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001Ba\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\b\b\u0002\u0010\f\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0012\u001a\u00020\r\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0013\u0012\b\b\u0002\u0010!\u001a\u00020\u001e\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0013\u0012\b\b\u0002\u0010&\u001a\u00020\u0013¢\u0006\u0004\b,\u0010-R\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u0017\u0010\f\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0012\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0018\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u001a\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u0015\u001a\u0004\b\u000e\u0010\u0017R\u0017\u0010\u001d\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u0015\u001a\u0004\b\u001c\u0010\u0017R\u0017\u0010!\u001a\u00020\u001e8\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001f\u001a\u0004\b\u0014\u0010 R\u0019\u0010$\u001a\u0004\u0018\u00010\u00138\u0006¢\u0006\f\n\u0004\b\n\u0010\"\u001a\u0004\b\u0019\u0010#R\u0017\u0010&\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\b%\u0010\u0015\u001a\u0004\b\u001b\u0010\u0017R\u001d\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00020'8\u0006¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b\b\u0010*¨\u0006."}, d2 = {"Lokio/internal/c;", "", "Lokio/Path;", "a", "Lokio/Path;", "()Lokio/Path;", "canonicalPath", "", "b", "Z", "h", "()Z", "isDirectory", "", "c", "Ljava/lang/String;", "getComment", "()Ljava/lang/String;", "comment", "", "d", "J", "getCrc", "()J", "crc", "e", "compressedSize", "f", "g", "size", "", "I", "()I", "compressionMethod", "Ljava/lang/Long;", "()Ljava/lang/Long;", "lastModifiedAtMillis", "i", "offset", "", "j", "Ljava/util/List;", "()Ljava/util/List;", "children", "<init>", "(Lokio/Path;ZLjava/lang/String;JJJILjava/lang/Long;J)V", "okio"}, k = 1, mv = {1, 6, 0})
public final class c {

    /* renamed from: a  reason: collision with root package name */
    private final Path f33454a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f33455b;

    /* renamed from: c  reason: collision with root package name */
    private final String f33456c;

    /* renamed from: d  reason: collision with root package name */
    private final long f33457d;

    /* renamed from: e  reason: collision with root package name */
    private final long f33458e;

    /* renamed from: f  reason: collision with root package name */
    private final long f33459f;

    /* renamed from: g  reason: collision with root package name */
    private final int f33460g;

    /* renamed from: h  reason: collision with root package name */
    private final Long f33461h;

    /* renamed from: i  reason: collision with root package name */
    private final long f33462i;

    /* renamed from: j  reason: collision with root package name */
    private final List<Path> f33463j;

    public c(Path path, boolean z10, String str, long j10, long j11, long j12, int i10, Long l10, long j13) {
        j.g(path, "canonicalPath");
        j.g(str, "comment");
        this.f33454a = path;
        this.f33455b = z10;
        this.f33456c = str;
        this.f33457d = j10;
        this.f33458e = j11;
        this.f33459f = j12;
        this.f33460g = i10;
        this.f33461h = l10;
        this.f33462i = j13;
        this.f33463j = new ArrayList();
    }

    public final Path a() {
        return this.f33454a;
    }

    public final List<Path> b() {
        return this.f33463j;
    }

    public final long c() {
        return this.f33458e;
    }

    public final int d() {
        return this.f33460g;
    }

    public final Long e() {
        return this.f33461h;
    }

    public final long f() {
        return this.f33462i;
    }

    public final long g() {
        return this.f33459f;
    }

    public final boolean h() {
        return this.f33455b;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ c(okio.Path r14, boolean r15, java.lang.String r16, long r17, long r19, long r21, int r23, java.lang.Long r24, long r25, int r27, kotlin.jvm.internal.DefaultConstructorMarker r28) {
        /*
            r13 = this;
            r0 = r27
            r1 = r0 & 2
            if (r1 == 0) goto L_0x0008
            r1 = 0
            goto L_0x0009
        L_0x0008:
            r1 = r15
        L_0x0009:
            r2 = r0 & 4
            if (r2 == 0) goto L_0x0010
            java.lang.String r2 = ""
            goto L_0x0012
        L_0x0010:
            r2 = r16
        L_0x0012:
            r3 = r0 & 8
            r4 = -1
            if (r3 == 0) goto L_0x001a
            r6 = r4
            goto L_0x001c
        L_0x001a:
            r6 = r17
        L_0x001c:
            r3 = r0 & 16
            if (r3 == 0) goto L_0x0022
            r8 = r4
            goto L_0x0024
        L_0x0022:
            r8 = r19
        L_0x0024:
            r3 = r0 & 32
            if (r3 == 0) goto L_0x002a
            r10 = r4
            goto L_0x002c
        L_0x002a:
            r10 = r21
        L_0x002c:
            r3 = r0 & 64
            if (r3 == 0) goto L_0x0032
            r3 = -1
            goto L_0x0034
        L_0x0032:
            r3 = r23
        L_0x0034:
            r12 = r0 & 128(0x80, float:1.794E-43)
            if (r12 == 0) goto L_0x003a
            r12 = 0
            goto L_0x003c
        L_0x003a:
            r12 = r24
        L_0x003c:
            r0 = r0 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x0041
            goto L_0x0043
        L_0x0041:
            r4 = r25
        L_0x0043:
            r15 = r13
            r16 = r14
            r17 = r1
            r18 = r2
            r19 = r6
            r21 = r8
            r23 = r10
            r25 = r3
            r26 = r12
            r27 = r4
            r15.<init>(r16, r17, r18, r19, r21, r23, r25, r26, r27)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal.c.<init>(okio.Path, boolean, java.lang.String, long, long, long, int, java.lang.Long, long, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
