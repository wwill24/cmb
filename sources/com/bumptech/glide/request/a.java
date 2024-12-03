package com.bumptech.glide.request;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.request.a;
import e4.c;
import f4.k;
import i3.b;
import i3.e;
import i3.h;
import java.util.Map;
import net.bytebuddy.jar.asm.Opcodes;
import s3.j;
import s3.o;
import w3.i;

public abstract class a<T extends a<T>> implements Cloneable {
    private Resources.Theme B;
    private boolean C;
    private boolean D;
    private boolean E;
    private boolean F = true;
    private boolean G;

    /* renamed from: a  reason: collision with root package name */
    private int f9542a;

    /* renamed from: b  reason: collision with root package name */
    private float f9543b = 1.0f;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    private l3.a f9544c = l3.a.f15998e;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    private Priority f9545d = Priority.NORMAL;

    /* renamed from: e  reason: collision with root package name */
    private Drawable f9546e;

    /* renamed from: f  reason: collision with root package name */
    private int f9547f;

    /* renamed from: g  reason: collision with root package name */
    private Drawable f9548g;

    /* renamed from: h  reason: collision with root package name */
    private int f9549h;

    /* renamed from: j  reason: collision with root package name */
    private boolean f9550j = true;

    /* renamed from: k  reason: collision with root package name */
    private int f9551k = -1;

    /* renamed from: l  reason: collision with root package name */
    private int f9552l = -1;
    @NonNull

    /* renamed from: m  reason: collision with root package name */
    private b f9553m = c.a();

    /* renamed from: n  reason: collision with root package name */
    private boolean f9554n;

    /* renamed from: p  reason: collision with root package name */
    private boolean f9555p = true;

    /* renamed from: q  reason: collision with root package name */
    private Drawable f9556q;

    /* renamed from: t  reason: collision with root package name */
    private int f9557t;
    @NonNull

    /* renamed from: w  reason: collision with root package name */
    private e f9558w = new e();
    @NonNull

    /* renamed from: x  reason: collision with root package name */
    private Map<Class<?>, h<?>> f9559x = new f4.b();
    @NonNull

    /* renamed from: y  reason: collision with root package name */
    private Class<?> f9560y = Object.class;

    /* renamed from: z  reason: collision with root package name */
    private boolean f9561z;

    private boolean I(int i10) {
        return J(this.f9542a, i10);
    }

    private static boolean J(int i10, int i11) {
        return (i10 & i11) != 0;
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [i3.h, i3.h<android.graphics.Bitmap>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private T U(@androidx.annotation.NonNull com.bumptech.glide.load.resource.bitmap.DownsampleStrategy r2, @androidx.annotation.NonNull i3.h<android.graphics.Bitmap> r3) {
        /*
            r1 = this;
            r0 = 0
            com.bumptech.glide.request.a r2 = r1.Z(r2, r3, r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.a.U(com.bumptech.glide.load.resource.bitmap.DownsampleStrategy, i3.h):com.bumptech.glide.request.a");
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [i3.h, i3.h<android.graphics.Bitmap>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private T Z(@androidx.annotation.NonNull com.bumptech.glide.load.resource.bitmap.DownsampleStrategy r1, @androidx.annotation.NonNull i3.h<android.graphics.Bitmap> r2, boolean r3) {
        /*
            r0 = this;
            if (r3 == 0) goto L_0x0007
            com.bumptech.glide.request.a r1 = r0.h0(r1, r2)
            goto L_0x000b
        L_0x0007:
            com.bumptech.glide.request.a r1 = r0.V(r1, r2)
        L_0x000b:
            r2 = 1
            r1.F = r2
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.a.Z(com.bumptech.glide.load.resource.bitmap.DownsampleStrategy, i3.h, boolean):com.bumptech.glide.request.a");
    }

    private T a0() {
        return this;
    }

    @NonNull
    private T b0() {
        if (!this.f9561z) {
            return a0();
        }
        throw new IllegalStateException("You cannot modify locked T, consider clone()");
    }

    public final float A() {
        return this.f9543b;
    }

    public final Resources.Theme B() {
        return this.B;
    }

    @NonNull
    public final Map<Class<?>, h<?>> C() {
        return this.f9559x;
    }

    public final boolean D() {
        return this.G;
    }

    public final boolean E() {
        return this.D;
    }

    public final boolean F() {
        return this.f9550j;
    }

    public final boolean G() {
        return I(8);
    }

    /* access modifiers changed from: package-private */
    public boolean H() {
        return this.F;
    }

    public final boolean K() {
        return this.f9555p;
    }

    public final boolean M() {
        return this.f9554n;
    }

    public final boolean N() {
        return I(2048);
    }

    public final boolean O() {
        return k.r(this.f9552l, this.f9551k);
    }

    @NonNull
    public T Q() {
        this.f9561z = true;
        return a0();
    }

    @NonNull
    public T R() {
        return V(DownsampleStrategy.f9458e, new j());
    }

    @NonNull
    public T S() {
        return U(DownsampleStrategy.f9457d, new s3.k());
    }

    @NonNull
    public T T() {
        return U(DownsampleStrategy.f9456c, new o());
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [i3.h, i3.h<android.graphics.Bitmap>] */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Unknown variable types count: 1 */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final T V(@androidx.annotation.NonNull com.bumptech.glide.load.resource.bitmap.DownsampleStrategy r2, @androidx.annotation.NonNull i3.h<android.graphics.Bitmap> r3) {
        /*
            r1 = this;
            boolean r0 = r1.C
            if (r0 == 0) goto L_0x000d
            com.bumptech.glide.request.a r0 = r1.clone()
            com.bumptech.glide.request.a r2 = r0.V(r2, r3)
            return r2
        L_0x000d:
            r1.h(r2)
            r2 = 0
            com.bumptech.glide.request.a r2 = r1.j0(r3, r2)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.a.V(com.bumptech.glide.load.resource.bitmap.DownsampleStrategy, i3.h):com.bumptech.glide.request.a");
    }

    @NonNull
    public T W(int i10, int i11) {
        if (this.C) {
            return clone().W(i10, i11);
        }
        this.f9552l = i10;
        this.f9551k = i11;
        this.f9542a |= 512;
        return b0();
    }

    @NonNull
    public T X(int i10) {
        if (this.C) {
            return clone().X(i10);
        }
        this.f9549h = i10;
        this.f9548g = null;
        this.f9542a = (this.f9542a | 128) & -65;
        return b0();
    }

    @NonNull
    public T Y(@NonNull Priority priority) {
        if (this.C) {
            return clone().Y(priority);
        }
        this.f9545d = (Priority) f4.j.d(priority);
        this.f9542a |= 8;
        return b0();
    }

    @NonNull
    public T a(@NonNull a<?> aVar) {
        if (this.C) {
            return clone().a(aVar);
        }
        if (J(aVar.f9542a, 2)) {
            this.f9543b = aVar.f9543b;
        }
        if (J(aVar.f9542a, Opcodes.ASM4)) {
            this.D = aVar.D;
        }
        if (J(aVar.f9542a, 1048576)) {
            this.G = aVar.G;
        }
        if (J(aVar.f9542a, 4)) {
            this.f9544c = aVar.f9544c;
        }
        if (J(aVar.f9542a, 8)) {
            this.f9545d = aVar.f9545d;
        }
        if (J(aVar.f9542a, 16)) {
            this.f9546e = aVar.f9546e;
            this.f9547f = 0;
            this.f9542a &= -33;
        }
        if (J(aVar.f9542a, 32)) {
            this.f9547f = aVar.f9547f;
            this.f9546e = null;
            this.f9542a &= -17;
        }
        if (J(aVar.f9542a, 64)) {
            this.f9548g = aVar.f9548g;
            this.f9549h = 0;
            this.f9542a &= -129;
        }
        if (J(aVar.f9542a, 128)) {
            this.f9549h = aVar.f9549h;
            this.f9548g = null;
            this.f9542a &= -65;
        }
        if (J(aVar.f9542a, 256)) {
            this.f9550j = aVar.f9550j;
        }
        if (J(aVar.f9542a, 512)) {
            this.f9552l = aVar.f9552l;
            this.f9551k = aVar.f9551k;
        }
        if (J(aVar.f9542a, 1024)) {
            this.f9553m = aVar.f9553m;
        }
        if (J(aVar.f9542a, Opcodes.ACC_SYNTHETIC)) {
            this.f9560y = aVar.f9560y;
        }
        if (J(aVar.f9542a, 8192)) {
            this.f9556q = aVar.f9556q;
            this.f9557t = 0;
            this.f9542a &= -16385;
        }
        if (J(aVar.f9542a, Opcodes.ACC_ENUM)) {
            this.f9557t = aVar.f9557t;
            this.f9556q = null;
            this.f9542a &= -8193;
        }
        if (J(aVar.f9542a, 32768)) {
            this.B = aVar.B;
        }
        if (J(aVar.f9542a, 65536)) {
            this.f9555p = aVar.f9555p;
        }
        if (J(aVar.f9542a, Opcodes.ACC_DEPRECATED)) {
            this.f9554n = aVar.f9554n;
        }
        if (J(aVar.f9542a, 2048)) {
            this.f9559x.putAll(aVar.f9559x);
            this.F = aVar.F;
        }
        if (J(aVar.f9542a, Opcodes.ASM8)) {
            this.E = aVar.E;
        }
        if (!this.f9555p) {
            this.f9559x.clear();
            this.f9554n = false;
            this.f9542a = this.f9542a & -2049 & -131073;
            this.F = true;
        }
        this.f9542a |= aVar.f9542a;
        this.f9558w.b(aVar.f9558w);
        return b0();
    }

    @NonNull
    public T b() {
        if (!this.f9561z || this.C) {
            this.C = true;
            return Q();
        }
        throw new IllegalStateException("You cannot auto lock an already locked options object, try clone() first");
    }

    /* renamed from: c */
    public T clone() {
        try {
            T t10 = (a) super.clone();
            e eVar = new e();
            t10.f9558w = eVar;
            eVar.b(this.f9558w);
            f4.b bVar = new f4.b();
            t10.f9559x = bVar;
            bVar.putAll(this.f9559x);
            t10.f9561z = false;
            t10.C = false;
            return t10;
        } catch (CloneNotSupportedException e10) {
            throw new RuntimeException(e10);
        }
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [i3.d, i3.d<Y>, java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <Y> T c0(@androidx.annotation.NonNull i3.d<Y> r2, @androidx.annotation.NonNull Y r3) {
        /*
            r1 = this;
            boolean r0 = r1.C
            if (r0 == 0) goto L_0x000d
            com.bumptech.glide.request.a r0 = r1.clone()
            com.bumptech.glide.request.a r2 = r0.c0(r2, r3)
            return r2
        L_0x000d:
            f4.j.d(r2)
            f4.j.d(r3)
            i3.e r0 = r1.f9558w
            r0.c(r2, r3)
            com.bumptech.glide.request.a r2 = r1.b0()
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.a.c0(i3.d, java.lang.Object):com.bumptech.glide.request.a");
    }

    @NonNull
    public T d(@NonNull Class<?> cls) {
        if (this.C) {
            return clone().d(cls);
        }
        this.f9560y = (Class) f4.j.d(cls);
        this.f9542a |= Opcodes.ACC_SYNTHETIC;
        return b0();
    }

    @NonNull
    public T d0(@NonNull b bVar) {
        if (this.C) {
            return clone().d0(bVar);
        }
        this.f9553m = (b) f4.j.d(bVar);
        this.f9542a |= 1024;
        return b0();
    }

    @NonNull
    public T e(@NonNull l3.a aVar) {
        if (this.C) {
            return clone().e(aVar);
        }
        this.f9544c = (l3.a) f4.j.d(aVar);
        this.f9542a |= 4;
        return b0();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (Float.compare(aVar.f9543b, this.f9543b) == 0 && this.f9547f == aVar.f9547f && k.c(this.f9546e, aVar.f9546e) && this.f9549h == aVar.f9549h && k.c(this.f9548g, aVar.f9548g) && this.f9557t == aVar.f9557t && k.c(this.f9556q, aVar.f9556q) && this.f9550j == aVar.f9550j && this.f9551k == aVar.f9551k && this.f9552l == aVar.f9552l && this.f9554n == aVar.f9554n && this.f9555p == aVar.f9555p && this.D == aVar.D && this.E == aVar.E && this.f9544c.equals(aVar.f9544c) && this.f9545d == aVar.f9545d && this.f9558w.equals(aVar.f9558w) && this.f9559x.equals(aVar.f9559x) && this.f9560y.equals(aVar.f9560y) && k.c(this.f9553m, aVar.f9553m) && k.c(this.B, aVar.B)) {
            return true;
        }
        return false;
    }

    @NonNull
    public T f0(float f10) {
        if (this.C) {
            return clone().f0(f10);
        }
        if (f10 < 0.0f || f10 > 1.0f) {
            throw new IllegalArgumentException("sizeMultiplier must be between 0 and 1");
        }
        this.f9543b = f10;
        this.f9542a |= 2;
        return b0();
    }

    @NonNull
    public T g0(boolean z10) {
        if (this.C) {
            return clone().g0(true);
        }
        this.f9550j = !z10;
        this.f9542a |= 256;
        return b0();
    }

    @NonNull
    public T h(@NonNull DownsampleStrategy downsampleStrategy) {
        return c0(DownsampleStrategy.f9461h, f4.j.d(downsampleStrategy));
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [i3.h, i3.h<android.graphics.Bitmap>] */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Unknown variable types count: 1 */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final T h0(@androidx.annotation.NonNull com.bumptech.glide.load.resource.bitmap.DownsampleStrategy r2, @androidx.annotation.NonNull i3.h<android.graphics.Bitmap> r3) {
        /*
            r1 = this;
            boolean r0 = r1.C
            if (r0 == 0) goto L_0x000d
            com.bumptech.glide.request.a r0 = r1.clone()
            com.bumptech.glide.request.a r2 = r0.h0(r2, r3)
            return r2
        L_0x000d:
            r1.h(r2)
            com.bumptech.glide.request.a r2 = r1.i0(r3)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.a.h0(com.bumptech.glide.load.resource.bitmap.DownsampleStrategy, i3.h):com.bumptech.glide.request.a");
    }

    public int hashCode() {
        return k.m(this.B, k.m(this.f9553m, k.m(this.f9560y, k.m(this.f9559x, k.m(this.f9558w, k.m(this.f9545d, k.m(this.f9544c, k.n(this.E, k.n(this.D, k.n(this.f9555p, k.n(this.f9554n, k.l(this.f9552l, k.l(this.f9551k, k.n(this.f9550j, k.m(this.f9556q, k.l(this.f9557t, k.m(this.f9548g, k.l(this.f9549h, k.m(this.f9546e, k.l(this.f9547f, k.j(this.f9543b)))))))))))))))))))));
    }

    @NonNull
    public T i(int i10) {
        if (this.C) {
            return clone().i(i10);
        }
        this.f9547f = i10;
        this.f9546e = null;
        this.f9542a = (this.f9542a | 32) & -17;
        return b0();
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [i3.h, i3.h<android.graphics.Bitmap>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public T i0(@androidx.annotation.NonNull i3.h<android.graphics.Bitmap> r2) {
        /*
            r1 = this;
            r0 = 1
            com.bumptech.glide.request.a r2 = r1.j0(r2, r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.a.i0(i3.h):com.bumptech.glide.request.a");
    }

    @NonNull
    public T j(@NonNull DecodeFormat decodeFormat) {
        f4.j.d(decodeFormat);
        return c0(com.bumptech.glide.load.resource.bitmap.a.f9472f, decodeFormat).c0(i.f18236a, decodeFormat);
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [i3.h, i3.h<android.graphics.Bitmap>] */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Unknown variable types count: 1 */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public T j0(@androidx.annotation.NonNull i3.h<android.graphics.Bitmap> r3, boolean r4) {
        /*
            r2 = this;
            boolean r0 = r2.C
            if (r0 == 0) goto L_0x000d
            com.bumptech.glide.request.a r0 = r2.clone()
            com.bumptech.glide.request.a r3 = r0.j0(r3, r4)
            return r3
        L_0x000d:
            s3.m r0 = new s3.m
            r0.<init>(r3, r4)
            java.lang.Class<android.graphics.Bitmap> r1 = android.graphics.Bitmap.class
            r2.k0(r1, r3, r4)
            java.lang.Class<android.graphics.drawable.Drawable> r1 = android.graphics.drawable.Drawable.class
            r2.k0(r1, r0, r4)
            java.lang.Class<android.graphics.drawable.BitmapDrawable> r1 = android.graphics.drawable.BitmapDrawable.class
            i3.h r0 = r0.a()
            r2.k0(r1, r0, r4)
            java.lang.Class<w3.c> r0 = w3.c.class
            w3.f r1 = new w3.f
            r1.<init>(r3)
            r2.k0(r0, r1, r4)
            com.bumptech.glide.request.a r3 = r2.b0()
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.a.j0(i3.h, boolean):com.bumptech.glide.request.a");
    }

    @NonNull
    public final l3.a k() {
        return this.f9544c;
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [java.lang.Class<Y>, java.lang.Object, java.lang.Class] */
    /* JADX WARNING: type inference failed for: r3v0, types: [i3.h, java.lang.Object, i3.h<Y>] */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Unknown variable types count: 2 */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <Y> T k0(@androidx.annotation.NonNull java.lang.Class<Y> r2, @androidx.annotation.NonNull i3.h<Y> r3, boolean r4) {
        /*
            r1 = this;
            boolean r0 = r1.C
            if (r0 == 0) goto L_0x000d
            com.bumptech.glide.request.a r0 = r1.clone()
            com.bumptech.glide.request.a r2 = r0.k0(r2, r3, r4)
            return r2
        L_0x000d:
            f4.j.d(r2)
            f4.j.d(r3)
            java.util.Map<java.lang.Class<?>, i3.h<?>> r0 = r1.f9559x
            r0.put(r2, r3)
            int r2 = r1.f9542a
            r2 = r2 | 2048(0x800, float:2.87E-42)
            r3 = 1
            r1.f9555p = r3
            r0 = 65536(0x10000, float:9.18355E-41)
            r2 = r2 | r0
            r1.f9542a = r2
            r0 = 0
            r1.F = r0
            if (r4 == 0) goto L_0x0030
            r4 = 131072(0x20000, float:1.83671E-40)
            r2 = r2 | r4
            r1.f9542a = r2
            r1.f9554n = r3
        L_0x0030:
            com.bumptech.glide.request.a r2 = r1.b0()
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.a.k0(java.lang.Class, i3.h, boolean):com.bumptech.glide.request.a");
    }

    public final int l() {
        return this.f9547f;
    }

    @NonNull
    public T l0(boolean z10) {
        if (this.C) {
            return clone().l0(z10);
        }
        this.G = z10;
        this.f9542a |= 1048576;
        return b0();
    }

    public final Drawable o() {
        return this.f9546e;
    }

    public final Drawable p() {
        return this.f9556q;
    }

    public final int q() {
        return this.f9557t;
    }

    public final boolean r() {
        return this.E;
    }

    @NonNull
    public final e s() {
        return this.f9558w;
    }

    public final int t() {
        return this.f9551k;
    }

    public final int u() {
        return this.f9552l;
    }

    public final Drawable v() {
        return this.f9548g;
    }

    public final int w() {
        return this.f9549h;
    }

    @NonNull
    public final Priority x() {
        return this.f9545d;
    }

    @NonNull
    public final Class<?> y() {
        return this.f9560y;
    }

    @NonNull
    public final b z() {
        return this.f9553m;
    }
}
