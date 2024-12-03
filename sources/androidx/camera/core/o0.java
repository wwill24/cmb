package androidx.camera.core;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.ImageWriter;
import androidx.annotation.NonNull;
import androidx.camera.core.impl.a2;
import androidx.camera.core.impl.utils.q;
import androidx.camera.core.impl.x0;
import androidx.camera.core.l0;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.os.OperationCanceledException;
import java.nio.ByteBuffer;
import java.util.concurrent.Executor;
import w.a;

abstract class o0 implements x0.a {

    /* renamed from: a  reason: collision with root package name */
    private l0.a f2832a;

    /* renamed from: b  reason: collision with root package name */
    private volatile int f2833b;

    /* renamed from: c  reason: collision with root package name */
    private volatile int f2834c;

    /* renamed from: d  reason: collision with root package name */
    private volatile int f2835d = 1;

    /* renamed from: e  reason: collision with root package name */
    private volatile boolean f2836e;

    /* renamed from: f  reason: collision with root package name */
    private volatile boolean f2837f;

    /* renamed from: g  reason: collision with root package name */
    private Executor f2838g;

    /* renamed from: h  reason: collision with root package name */
    private s2 f2839h;

    /* renamed from: i  reason: collision with root package name */
    private ImageWriter f2840i;

    /* renamed from: j  reason: collision with root package name */
    private Rect f2841j = new Rect();

    /* renamed from: k  reason: collision with root package name */
    private Rect f2842k = new Rect();

    /* renamed from: l  reason: collision with root package name */
    private Matrix f2843l = new Matrix();

    /* renamed from: m  reason: collision with root package name */
    private Matrix f2844m = new Matrix();

    /* renamed from: n  reason: collision with root package name */
    ByteBuffer f2845n;

    /* renamed from: o  reason: collision with root package name */
    ByteBuffer f2846o;

    /* renamed from: p  reason: collision with root package name */
    ByteBuffer f2847p;

    /* renamed from: q  reason: collision with root package name */
    ByteBuffer f2848q;

    /* renamed from: r  reason: collision with root package name */
    private final Object f2849r = new Object();

    /* renamed from: s  reason: collision with root package name */
    protected boolean f2850s = true;

    o0() {
    }

    private void h(@NonNull o1 o1Var) {
        if (this.f2835d == 1) {
            if (this.f2846o == null) {
                this.f2846o = ByteBuffer.allocateDirect(o1Var.getWidth() * o1Var.getHeight());
            }
            this.f2846o.position(0);
            if (this.f2847p == null) {
                this.f2847p = ByteBuffer.allocateDirect((o1Var.getWidth() * o1Var.getHeight()) / 4);
            }
            this.f2847p.position(0);
            if (this.f2848q == null) {
                this.f2848q = ByteBuffer.allocateDirect((o1Var.getWidth() * o1Var.getHeight()) / 4);
            }
            this.f2848q.position(0);
        } else if (this.f2835d == 2 && this.f2845n == null) {
            this.f2845n = ByteBuffer.allocateDirect(o1Var.getWidth() * o1Var.getHeight() * 4);
        }
    }

    @NonNull
    private static s2 i(int i10, int i11, int i12, int i13, int i14) {
        boolean z10;
        int i15;
        if (i12 == 90 || i12 == 270) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            i15 = i11;
        } else {
            i15 = i10;
        }
        if (!z10) {
            i10 = i11;
        }
        return new s2(q1.a(i15, i10, i13, i14));
    }

    @NonNull
    static Matrix k(int i10, int i11, int i12, int i13, int i14) {
        Matrix matrix = new Matrix();
        if (i14 > 0) {
            matrix.setRectToRect(new RectF(0.0f, 0.0f, (float) i10, (float) i11), q.f2688a, Matrix.ScaleToFit.FILL);
            matrix.postRotate((float) i14);
            matrix.postConcat(q.b(new RectF(0.0f, 0.0f, (float) i12, (float) i13)));
        }
        return matrix;
    }

    @NonNull
    static Rect l(@NonNull Rect rect, @NonNull Matrix matrix) {
        RectF rectF = new RectF(rect);
        matrix.mapRect(rectF);
        Rect rect2 = new Rect();
        rectF.round(rect2);
        return rect2;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void m(o1 o1Var, Matrix matrix, o1 o1Var2, Rect rect, l0.a aVar, CallbackToFutureAdapter.a aVar2) {
        int i10;
        if (this.f2850s) {
            a2 c10 = o1Var.z1().c();
            long timestamp = o1Var.z1().getTimestamp();
            if (this.f2836e) {
                i10 = 0;
            } else {
                i10 = this.f2833b;
            }
            t2 t2Var = new t2(o1Var2, u1.e(c10, timestamp, i10, matrix));
            if (!rect.isEmpty()) {
                t2Var.p0(rect);
            }
            aVar.i(t2Var);
            aVar2.c(null);
            return;
        }
        aVar2.f(new OperationCanceledException("ImageAnalysis is detached"));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object n(Executor executor, o1 o1Var, Matrix matrix, o1 o1Var2, Rect rect, l0.a aVar, CallbackToFutureAdapter.a aVar2) throws Exception {
        Executor executor2 = executor;
        executor.execute(new n0(this, o1Var, matrix, o1Var2, rect, aVar, aVar2));
        return "analyzeImage";
    }

    private void p(int i10, int i11, int i12, int i13) {
        Matrix k10 = k(i10, i11, i12, i13, this.f2833b);
        this.f2842k = l(this.f2841j, k10);
        this.f2844m.setConcat(this.f2843l, k10);
    }

    private void q(@NonNull o1 o1Var, int i10) {
        s2 s2Var = this.f2839h;
        if (s2Var != null) {
            s2Var.l();
            this.f2839h = i(o1Var.getWidth(), o1Var.getHeight(), i10, this.f2839h.c(), this.f2839h.e());
            if (this.f2835d == 1) {
                ImageWriter imageWriter = this.f2840i;
                if (imageWriter != null) {
                    a.a(imageWriter);
                }
                this.f2840i = a.c(this.f2839h.getSurface(), this.f2839h.e());
            }
        }
    }

    public void a(@NonNull x0 x0Var) {
        try {
            o1 d10 = d(x0Var);
            if (d10 != null) {
                o(d10);
            }
        } catch (IllegalStateException e10) {
            v1.d("ImageAnalysisAnalyzer", "Failed to acquire image.", e10);
        }
    }

    /* access modifiers changed from: package-private */
    public abstract o1 d(@NonNull x0 x0Var);

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0076  */
    zf.a<java.lang.Void> e(@androidx.annotation.NonNull androidx.camera.core.o1 r17) {
        /*
            r16 = this;
            r9 = r16
            r0 = r17
            boolean r1 = r9.f2836e
            r8 = 0
            if (r1 == 0) goto L_0x000d
            int r1 = r9.f2833b
            r10 = r1
            goto L_0x000e
        L_0x000d:
            r10 = r8
        L_0x000e:
            java.lang.Object r1 = r9.f2849r
            monitor-enter(r1)
            java.util.concurrent.Executor r11 = r9.f2838g     // Catch:{ all -> 0x00c8 }
            androidx.camera.core.l0$a r12 = r9.f2832a     // Catch:{ all -> 0x00c8 }
            boolean r2 = r9.f2836e     // Catch:{ all -> 0x00c8 }
            r13 = 1
            if (r2 == 0) goto L_0x0020
            int r2 = r9.f2834c     // Catch:{ all -> 0x00c8 }
            if (r10 == r2) goto L_0x0020
            r14 = r13
            goto L_0x0021
        L_0x0020:
            r14 = r8
        L_0x0021:
            if (r14 == 0) goto L_0x0026
            r9.q(r0, r10)     // Catch:{ all -> 0x00c8 }
        L_0x0026:
            boolean r2 = r9.f2836e     // Catch:{ all -> 0x00c8 }
            if (r2 == 0) goto L_0x002d
            r16.h(r17)     // Catch:{ all -> 0x00c8 }
        L_0x002d:
            androidx.camera.core.s2 r2 = r9.f2839h     // Catch:{ all -> 0x00c8 }
            android.media.ImageWriter r3 = r9.f2840i     // Catch:{ all -> 0x00c8 }
            java.nio.ByteBuffer r4 = r9.f2845n     // Catch:{ all -> 0x00c8 }
            java.nio.ByteBuffer r5 = r9.f2846o     // Catch:{ all -> 0x00c8 }
            java.nio.ByteBuffer r6 = r9.f2847p     // Catch:{ all -> 0x00c8 }
            java.nio.ByteBuffer r7 = r9.f2848q     // Catch:{ all -> 0x00c8 }
            monitor-exit(r1)     // Catch:{ all -> 0x00c8 }
            if (r12 == 0) goto L_0x00bc
            if (r11 == 0) goto L_0x00bc
            boolean r1 = r9.f2850s
            if (r1 == 0) goto L_0x00bc
            if (r2 == 0) goto L_0x006e
            int r15 = r9.f2835d
            r1 = 2
            if (r15 != r1) goto L_0x0050
            boolean r1 = r9.f2837f
            androidx.camera.core.o1 r1 = androidx.camera.core.ImageProcessingUtil.f(r0, r2, r4, r10, r1)
            goto L_0x006f
        L_0x0050:
            int r1 = r9.f2835d
            if (r1 != r13) goto L_0x006e
            boolean r1 = r9.f2837f
            if (r1 == 0) goto L_0x005b
            androidx.camera.core.ImageProcessingUtil.c(r17)
        L_0x005b:
            if (r3 == 0) goto L_0x006e
            if (r5 == 0) goto L_0x006e
            if (r6 == 0) goto L_0x006e
            if (r7 == 0) goto L_0x006e
            r1 = r17
            r4 = r5
            r5 = r6
            r6 = r7
            r7 = r10
            androidx.camera.core.o1 r1 = androidx.camera.core.ImageProcessingUtil.l(r1, r2, r3, r4, r5, r6, r7)
            goto L_0x006f
        L_0x006e:
            r1 = 0
        L_0x006f:
            if (r1 != 0) goto L_0x0072
            r8 = r13
        L_0x0072:
            if (r8 == 0) goto L_0x0076
            r6 = r0
            goto L_0x0077
        L_0x0076:
            r6 = r1
        L_0x0077:
            android.graphics.Rect r7 = new android.graphics.Rect
            r7.<init>()
            android.graphics.Matrix r5 = new android.graphics.Matrix
            r5.<init>()
            java.lang.Object r1 = r9.f2849r
            monitor-enter(r1)
            if (r14 == 0) goto L_0x009b
            if (r8 != 0) goto L_0x009b
            int r2 = r17.getWidth()     // Catch:{ all -> 0x00b9 }
            int r3 = r17.getHeight()     // Catch:{ all -> 0x00b9 }
            int r4 = r6.getWidth()     // Catch:{ all -> 0x00b9 }
            int r8 = r6.getHeight()     // Catch:{ all -> 0x00b9 }
            r9.p(r2, r3, r4, r8)     // Catch:{ all -> 0x00b9 }
        L_0x009b:
            r9.f2834c = r10     // Catch:{ all -> 0x00b9 }
            android.graphics.Rect r2 = r9.f2842k     // Catch:{ all -> 0x00b9 }
            r7.set(r2)     // Catch:{ all -> 0x00b9 }
            android.graphics.Matrix r2 = r9.f2844m     // Catch:{ all -> 0x00b9 }
            r5.set(r2)     // Catch:{ all -> 0x00b9 }
            monitor-exit(r1)     // Catch:{ all -> 0x00b9 }
            androidx.camera.core.m0 r10 = new androidx.camera.core.m0
            r1 = r10
            r2 = r16
            r3 = r11
            r4 = r17
            r8 = r12
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)
            zf.a r0 = androidx.concurrent.futures.CallbackToFutureAdapter.a(r10)
            goto L_0x00c7
        L_0x00b9:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x00b9 }
            throw r0
        L_0x00bc:
            androidx.core.os.OperationCanceledException r0 = new androidx.core.os.OperationCanceledException
            java.lang.String r1 = "No analyzer or executor currently set."
            r0.<init>(r1)
            zf.a r0 = u.f.f(r0)
        L_0x00c7:
            return r0
        L_0x00c8:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x00c8 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.o0.e(androidx.camera.core.o1):zf.a");
    }

    /* access modifiers changed from: package-private */
    public void f() {
        this.f2850s = true;
    }

    /* access modifiers changed from: package-private */
    public abstract void g();

    /* access modifiers changed from: package-private */
    public void j() {
        this.f2850s = false;
        g();
    }

    /* access modifiers changed from: package-private */
    public abstract void o(@NonNull o1 o1Var);

    /* access modifiers changed from: package-private */
    public void r(Executor executor, l0.a aVar) {
        if (aVar == null) {
            g();
        }
        synchronized (this.f2849r) {
            this.f2832a = aVar;
            this.f2838g = executor;
        }
    }

    /* access modifiers changed from: package-private */
    public void s(boolean z10) {
        this.f2837f = z10;
    }

    /* access modifiers changed from: package-private */
    public void t(int i10) {
        this.f2835d = i10;
    }

    /* access modifiers changed from: package-private */
    public void u(boolean z10) {
        this.f2836e = z10;
    }

    /* access modifiers changed from: package-private */
    public void v(@NonNull s2 s2Var) {
        synchronized (this.f2849r) {
            this.f2839h = s2Var;
        }
    }

    /* access modifiers changed from: package-private */
    public void w(int i10) {
        this.f2833b = i10;
    }

    /* access modifiers changed from: package-private */
    public void x(@NonNull Matrix matrix) {
        synchronized (this.f2849r) {
            this.f2843l = matrix;
            this.f2844m = new Matrix(this.f2843l);
        }
    }

    /* access modifiers changed from: package-private */
    public void y(@NonNull Rect rect) {
        synchronized (this.f2849r) {
            this.f2841j = rect;
            this.f2842k = new Rect(this.f2841j);
        }
    }
}
