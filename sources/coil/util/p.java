package coil.util;

import coil.decode.ExifOrientationPolicy;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u0012\b\b\u0002\u0010\f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0010\u001a\u00020\r\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0011¢\u0006\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u0017\u0010\t\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0005R\u0017\u0010\f\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u000b\u0010\u0005R\u0017\u0010\u0010\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\b\u0010\u000e\u001a\u0004\b\n\u0010\u000fR\u0017\u0010\u0014\u001a\u00020\u00118\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0012\u001a\u0004\b\u0007\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcoil/util/p;", "", "", "a", "Z", "()Z", "addLastModifiedToFileCacheKey", "b", "d", "networkObserverEnabled", "c", "e", "respectCacheHeaders", "", "I", "()I", "bitmapFactoryMaxParallelism", "Lcoil/decode/ExifOrientationPolicy;", "Lcoil/decode/ExifOrientationPolicy;", "()Lcoil/decode/ExifOrientationPolicy;", "bitmapFactoryExifOrientationPolicy", "<init>", "(ZZZILcoil/decode/ExifOrientationPolicy;)V", "coil-base_release"}, k = 1, mv = {1, 7, 1})
public final class p {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f8442a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f8443b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f8444c;

    /* renamed from: d  reason: collision with root package name */
    private final int f8445d;

    /* renamed from: e  reason: collision with root package name */
    private final ExifOrientationPolicy f8446e;

    public p(boolean z10, boolean z11, boolean z12, int i10, ExifOrientationPolicy exifOrientationPolicy) {
        this.f8442a = z10;
        this.f8443b = z11;
        this.f8444c = z12;
        this.f8445d = i10;
        this.f8446e = exifOrientationPolicy;
    }

    public final boolean a() {
        return this.f8442a;
    }

    public final ExifOrientationPolicy b() {
        return this.f8446e;
    }

    public final int c() {
        return this.f8445d;
    }

    public final boolean d() {
        return this.f8443b;
    }

    public final boolean e() {
        return this.f8444c;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ p(boolean r4, boolean r5, boolean r6, int r7, coil.decode.ExifOrientationPolicy r8, int r9, kotlin.jvm.internal.DefaultConstructorMarker r10) {
        /*
            r3 = this;
            r10 = r9 & 1
            r0 = 1
            if (r10 == 0) goto L_0x0007
            r10 = r0
            goto L_0x0008
        L_0x0007:
            r10 = r4
        L_0x0008:
            r4 = r9 & 2
            if (r4 == 0) goto L_0x000e
            r1 = r0
            goto L_0x000f
        L_0x000e:
            r1 = r5
        L_0x000f:
            r4 = r9 & 4
            if (r4 == 0) goto L_0x0014
            goto L_0x0015
        L_0x0014:
            r0 = r6
        L_0x0015:
            r4 = r9 & 8
            if (r4 == 0) goto L_0x001a
            r7 = 4
        L_0x001a:
            r2 = r7
            r4 = r9 & 16
            if (r4 == 0) goto L_0x0021
            coil.decode.ExifOrientationPolicy r8 = coil.decode.ExifOrientationPolicy.RESPECT_PERFORMANCE
        L_0x0021:
            r9 = r8
            r4 = r3
            r5 = r10
            r6 = r1
            r7 = r0
            r8 = r2
            r4.<init>(r5, r6, r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.util.p.<init>(boolean, boolean, boolean, int, coil.decode.ExifOrientationPolicy, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
