package coil.request;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import coil.size.Precision;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.CoroutineDispatcher;
import net.bytebuddy.asm.Advice;
import net.bytebuddy.jar.asm.Opcodes;
import r2.c;

@Metadata(bv = {}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\"\u0018\u00002\u00020\u0001B£\u0001\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u0012\b\b\u0002\u0010\u000f\u001a\u00020\r\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0014¢\u0006\u0004\b;\u0010<J¢\u0001\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\r2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0016\u001a\u00020\u00142\b\b\u0002\u0010\u0017\u001a\u00020\u0014J\u0013\u0010\u001a\u001a\u00020\r2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u001c\u001a\u00020\u001bH\u0016R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b \u0010\u001d\u001a\u0004\b!\u0010\u001fR\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\"\u0010\u001d\u001a\u0004\b#\u0010\u001fR\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b$\u0010\u001d\u001a\u0004\b%\u0010\u001fR\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b#\u0010*\u001a\u0004\b+\u0010,R\u0017\u0010\f\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b&\u0010/R\u0017\u0010\u000e\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b\"\u00102R\u0017\u0010\u000f\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b3\u00101\u001a\u0004\b$\u00102R\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006¢\u0006\f\n\u0004\b!\u00104\u001a\u0004\b5\u00106R\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00108\u0006¢\u0006\f\n\u0004\b\u001e\u00104\u001a\u0004\b0\u00106R\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u00108\u0006¢\u0006\f\n\u0004\b7\u00104\u001a\u0004\b3\u00106R\u0017\u0010\u0015\u001a\u00020\u00148\u0006¢\u0006\f\n\u0004\b8\u00109\u001a\u0004\b7\u0010:R\u0017\u0010\u0016\u001a\u00020\u00148\u0006¢\u0006\f\n\u0004\b5\u00109\u001a\u0004\b-\u0010:R\u0017\u0010\u0017\u001a\u00020\u00148\u0006¢\u0006\f\n\u0004\b+\u00109\u001a\u0004\b8\u0010:¨\u0006="}, d2 = {"Lcoil/request/a;", "", "Lkotlinx/coroutines/CoroutineDispatcher;", "interceptorDispatcher", "fetcherDispatcher", "decoderDispatcher", "transformationDispatcher", "Lr2/c$a;", "transitionFactory", "Lcoil/size/Precision;", "precision", "Landroid/graphics/Bitmap$Config;", "bitmapConfig", "", "allowHardware", "allowRgb565", "Landroid/graphics/drawable/Drawable;", "placeholder", "error", "fallback", "Lcoil/request/CachePolicy;", "memoryCachePolicy", "diskCachePolicy", "networkCachePolicy", "a", "other", "equals", "", "hashCode", "Lkotlinx/coroutines/CoroutineDispatcher;", "k", "()Lkotlinx/coroutines/CoroutineDispatcher;", "b", "j", "c", "f", "d", "p", "e", "Lr2/c$a;", "q", "()Lr2/c$a;", "Lcoil/size/Precision;", "o", "()Lcoil/size/Precision;", "g", "Landroid/graphics/Bitmap$Config;", "()Landroid/graphics/Bitmap$Config;", "h", "Z", "()Z", "i", "Landroid/graphics/drawable/Drawable;", "n", "()Landroid/graphics/drawable/Drawable;", "l", "m", "Lcoil/request/CachePolicy;", "()Lcoil/request/CachePolicy;", "<init>", "(Lkotlinx/coroutines/CoroutineDispatcher;Lkotlinx/coroutines/CoroutineDispatcher;Lkotlinx/coroutines/CoroutineDispatcher;Lkotlinx/coroutines/CoroutineDispatcher;Lr2/c$a;Lcoil/size/Precision;Landroid/graphics/Bitmap$Config;ZZLandroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Lcoil/request/CachePolicy;Lcoil/request/CachePolicy;Lcoil/request/CachePolicy;)V", "coil-base_release"}, k = 1, mv = {1, 7, 1})
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private final CoroutineDispatcher f8271a;

    /* renamed from: b  reason: collision with root package name */
    private final CoroutineDispatcher f8272b;

    /* renamed from: c  reason: collision with root package name */
    private final CoroutineDispatcher f8273c;

    /* renamed from: d  reason: collision with root package name */
    private final CoroutineDispatcher f8274d;

    /* renamed from: e  reason: collision with root package name */
    private final c.a f8275e;

    /* renamed from: f  reason: collision with root package name */
    private final Precision f8276f;

    /* renamed from: g  reason: collision with root package name */
    private final Bitmap.Config f8277g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f8278h;

    /* renamed from: i  reason: collision with root package name */
    private final boolean f8279i;

    /* renamed from: j  reason: collision with root package name */
    private final Drawable f8280j;

    /* renamed from: k  reason: collision with root package name */
    private final Drawable f8281k;

    /* renamed from: l  reason: collision with root package name */
    private final Drawable f8282l;

    /* renamed from: m  reason: collision with root package name */
    private final CachePolicy f8283m;

    /* renamed from: n  reason: collision with root package name */
    private final CachePolicy f8284n;

    /* renamed from: o  reason: collision with root package name */
    private final CachePolicy f8285o;

    public a() {
        this((CoroutineDispatcher) null, (CoroutineDispatcher) null, (CoroutineDispatcher) null, (CoroutineDispatcher) null, (c.a) null, (Precision) null, (Bitmap.Config) null, false, false, (Drawable) null, (Drawable) null, (Drawable) null, (CachePolicy) null, (CachePolicy) null, (CachePolicy) null, Advice.MethodSizeHandler.UNDEFINED_SIZE, (DefaultConstructorMarker) null);
    }

    public a(CoroutineDispatcher coroutineDispatcher, CoroutineDispatcher coroutineDispatcher2, CoroutineDispatcher coroutineDispatcher3, CoroutineDispatcher coroutineDispatcher4, c.a aVar, Precision precision, Bitmap.Config config, boolean z10, boolean z11, Drawable drawable, Drawable drawable2, Drawable drawable3, CachePolicy cachePolicy, CachePolicy cachePolicy2, CachePolicy cachePolicy3) {
        this.f8271a = coroutineDispatcher;
        this.f8272b = coroutineDispatcher2;
        this.f8273c = coroutineDispatcher3;
        this.f8274d = coroutineDispatcher4;
        this.f8275e = aVar;
        this.f8276f = precision;
        this.f8277g = config;
        this.f8278h = z10;
        this.f8279i = z11;
        this.f8280j = drawable;
        this.f8281k = drawable2;
        this.f8282l = drawable3;
        this.f8283m = cachePolicy;
        this.f8284n = cachePolicy2;
        this.f8285o = cachePolicy3;
    }

    public static /* synthetic */ a b(a aVar, CoroutineDispatcher coroutineDispatcher, CoroutineDispatcher coroutineDispatcher2, CoroutineDispatcher coroutineDispatcher3, CoroutineDispatcher coroutineDispatcher4, c.a aVar2, Precision precision, Bitmap.Config config, boolean z10, boolean z11, Drawable drawable, Drawable drawable2, Drawable drawable3, CachePolicy cachePolicy, CachePolicy cachePolicy2, CachePolicy cachePolicy3, int i10, Object obj) {
        a aVar3 = aVar;
        int i11 = i10;
        return aVar.a((i11 & 1) != 0 ? aVar3.f8271a : coroutineDispatcher, (i11 & 2) != 0 ? aVar3.f8272b : coroutineDispatcher2, (i11 & 4) != 0 ? aVar3.f8273c : coroutineDispatcher3, (i11 & 8) != 0 ? aVar3.f8274d : coroutineDispatcher4, (i11 & 16) != 0 ? aVar3.f8275e : aVar2, (i11 & 32) != 0 ? aVar3.f8276f : precision, (i11 & 64) != 0 ? aVar3.f8277g : config, (i11 & 128) != 0 ? aVar3.f8278h : z10, (i11 & 256) != 0 ? aVar3.f8279i : z11, (i11 & 512) != 0 ? aVar3.f8280j : drawable, (i11 & 1024) != 0 ? aVar3.f8281k : drawable2, (i11 & 2048) != 0 ? aVar3.f8282l : drawable3, (i11 & Opcodes.ACC_SYNTHETIC) != 0 ? aVar3.f8283m : cachePolicy, (i11 & 8192) != 0 ? aVar3.f8284n : cachePolicy2, (i11 & Opcodes.ACC_ENUM) != 0 ? aVar3.f8285o : cachePolicy3);
    }

    public final a a(CoroutineDispatcher coroutineDispatcher, CoroutineDispatcher coroutineDispatcher2, CoroutineDispatcher coroutineDispatcher3, CoroutineDispatcher coroutineDispatcher4, c.a aVar, Precision precision, Bitmap.Config config, boolean z10, boolean z11, Drawable drawable, Drawable drawable2, Drawable drawable3, CachePolicy cachePolicy, CachePolicy cachePolicy2, CachePolicy cachePolicy3) {
        return new a(coroutineDispatcher, coroutineDispatcher2, coroutineDispatcher3, coroutineDispatcher4, aVar, precision, config, z10, z11, drawable, drawable2, drawable3, cachePolicy, cachePolicy2, cachePolicy3);
    }

    public final boolean c() {
        return this.f8278h;
    }

    public final boolean d() {
        return this.f8279i;
    }

    public final Bitmap.Config e() {
        return this.f8277g;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (!j.b(this.f8271a, aVar.f8271a) || !j.b(this.f8272b, aVar.f8272b) || !j.b(this.f8273c, aVar.f8273c) || !j.b(this.f8274d, aVar.f8274d) || !j.b(this.f8275e, aVar.f8275e) || this.f8276f != aVar.f8276f || this.f8277g != aVar.f8277g || this.f8278h != aVar.f8278h || this.f8279i != aVar.f8279i || !j.b(this.f8280j, aVar.f8280j) || !j.b(this.f8281k, aVar.f8281k) || !j.b(this.f8282l, aVar.f8282l) || this.f8283m != aVar.f8283m || this.f8284n != aVar.f8284n || this.f8285o != aVar.f8285o) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final CoroutineDispatcher f() {
        return this.f8273c;
    }

    public final CachePolicy g() {
        return this.f8284n;
    }

    public final Drawable h() {
        return this.f8281k;
    }

    public int hashCode() {
        int i10;
        int i11;
        int hashCode = ((((((((((((((((this.f8271a.hashCode() * 31) + this.f8272b.hashCode()) * 31) + this.f8273c.hashCode()) * 31) + this.f8274d.hashCode()) * 31) + this.f8275e.hashCode()) * 31) + this.f8276f.hashCode()) * 31) + this.f8277g.hashCode()) * 31) + Boolean.hashCode(this.f8278h)) * 31) + Boolean.hashCode(this.f8279i)) * 31;
        Drawable drawable = this.f8280j;
        int i12 = 0;
        if (drawable != null) {
            i10 = drawable.hashCode();
        } else {
            i10 = 0;
        }
        int i13 = (hashCode + i10) * 31;
        Drawable drawable2 = this.f8281k;
        if (drawable2 != null) {
            i11 = drawable2.hashCode();
        } else {
            i11 = 0;
        }
        int i14 = (i13 + i11) * 31;
        Drawable drawable3 = this.f8282l;
        if (drawable3 != null) {
            i12 = drawable3.hashCode();
        }
        return ((((((i14 + i12) * 31) + this.f8283m.hashCode()) * 31) + this.f8284n.hashCode()) * 31) + this.f8285o.hashCode();
    }

    public final Drawable i() {
        return this.f8282l;
    }

    public final CoroutineDispatcher j() {
        return this.f8272b;
    }

    public final CoroutineDispatcher k() {
        return this.f8271a;
    }

    public final CachePolicy l() {
        return this.f8283m;
    }

    public final CachePolicy m() {
        return this.f8285o;
    }

    public final Drawable n() {
        return this.f8280j;
    }

    public final Precision o() {
        return this.f8276f;
    }

    public final CoroutineDispatcher p() {
        return this.f8274d;
    }

    public final c.a q() {
        return this.f8275e;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ a(kotlinx.coroutines.CoroutineDispatcher r16, kotlinx.coroutines.CoroutineDispatcher r17, kotlinx.coroutines.CoroutineDispatcher r18, kotlinx.coroutines.CoroutineDispatcher r19, r2.c.a r20, coil.size.Precision r21, android.graphics.Bitmap.Config r22, boolean r23, boolean r24, android.graphics.drawable.Drawable r25, android.graphics.drawable.Drawable r26, android.graphics.drawable.Drawable r27, coil.request.CachePolicy r28, coil.request.CachePolicy r29, coil.request.CachePolicy r30, int r31, kotlin.jvm.internal.DefaultConstructorMarker r32) {
        /*
            r15 = this;
            r0 = r31
            r1 = r0 & 1
            if (r1 == 0) goto L_0x000f
            kotlinx.coroutines.c2 r1 = kotlinx.coroutines.x0.c()
            kotlinx.coroutines.c2 r1 = r1.Y()
            goto L_0x0011
        L_0x000f:
            r1 = r16
        L_0x0011:
            r2 = r0 & 2
            if (r2 == 0) goto L_0x001a
            kotlinx.coroutines.CoroutineDispatcher r2 = kotlinx.coroutines.x0.b()
            goto L_0x001c
        L_0x001a:
            r2 = r17
        L_0x001c:
            r3 = r0 & 4
            if (r3 == 0) goto L_0x0025
            kotlinx.coroutines.CoroutineDispatcher r3 = kotlinx.coroutines.x0.b()
            goto L_0x0027
        L_0x0025:
            r3 = r18
        L_0x0027:
            r4 = r0 & 8
            if (r4 == 0) goto L_0x0030
            kotlinx.coroutines.CoroutineDispatcher r4 = kotlinx.coroutines.x0.b()
            goto L_0x0032
        L_0x0030:
            r4 = r19
        L_0x0032:
            r5 = r0 & 16
            if (r5 == 0) goto L_0x0039
            r2.c$a r5 = r2.c.a.f17259b
            goto L_0x003b
        L_0x0039:
            r5 = r20
        L_0x003b:
            r6 = r0 & 32
            if (r6 == 0) goto L_0x0042
            coil.size.Precision r6 = coil.size.Precision.AUTOMATIC
            goto L_0x0044
        L_0x0042:
            r6 = r21
        L_0x0044:
            r7 = r0 & 64
            if (r7 == 0) goto L_0x004d
            android.graphics.Bitmap$Config r7 = coil.util.j.f()
            goto L_0x004f
        L_0x004d:
            r7 = r22
        L_0x004f:
            r8 = r0 & 128(0x80, float:1.794E-43)
            if (r8 == 0) goto L_0x0055
            r8 = 1
            goto L_0x0057
        L_0x0055:
            r8 = r23
        L_0x0057:
            r9 = r0 & 256(0x100, float:3.59E-43)
            if (r9 == 0) goto L_0x005d
            r9 = 0
            goto L_0x005f
        L_0x005d:
            r9 = r24
        L_0x005f:
            r10 = r0 & 512(0x200, float:7.175E-43)
            r11 = 0
            if (r10 == 0) goto L_0x0066
            r10 = r11
            goto L_0x0068
        L_0x0066:
            r10 = r25
        L_0x0068:
            r12 = r0 & 1024(0x400, float:1.435E-42)
            if (r12 == 0) goto L_0x006e
            r12 = r11
            goto L_0x0070
        L_0x006e:
            r12 = r26
        L_0x0070:
            r13 = r0 & 2048(0x800, float:2.87E-42)
            if (r13 == 0) goto L_0x0075
            goto L_0x0077
        L_0x0075:
            r11 = r27
        L_0x0077:
            r13 = r0 & 4096(0x1000, float:5.74E-42)
            if (r13 == 0) goto L_0x007e
            coil.request.CachePolicy r13 = coil.request.CachePolicy.ENABLED
            goto L_0x0080
        L_0x007e:
            r13 = r28
        L_0x0080:
            r14 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r14 == 0) goto L_0x0087
            coil.request.CachePolicy r14 = coil.request.CachePolicy.ENABLED
            goto L_0x0089
        L_0x0087:
            r14 = r29
        L_0x0089:
            r0 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r0 == 0) goto L_0x0090
            coil.request.CachePolicy r0 = coil.request.CachePolicy.ENABLED
            goto L_0x0092
        L_0x0090:
            r0 = r30
        L_0x0092:
            r16 = r15
            r17 = r1
            r18 = r2
            r19 = r3
            r20 = r4
            r21 = r5
            r22 = r6
            r23 = r7
            r24 = r8
            r25 = r9
            r26 = r10
            r27 = r12
            r28 = r11
            r29 = r13
            r30 = r14
            r31 = r0
            r16.<init>(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.request.a.<init>(kotlinx.coroutines.CoroutineDispatcher, kotlinx.coroutines.CoroutineDispatcher, kotlinx.coroutines.CoroutineDispatcher, kotlinx.coroutines.CoroutineDispatcher, r2.c$a, coil.size.Precision, android.graphics.Bitmap$Config, boolean, boolean, android.graphics.drawable.Drawable, android.graphics.drawable.Drawable, android.graphics.drawable.Drawable, coil.request.CachePolicy, coil.request.CachePolicy, coil.request.CachePolicy, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
