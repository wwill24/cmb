package com.bumptech.glide;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import b4.b;
import b4.c;
import c4.h;
import c4.i;
import com.bumptech.glide.request.RequestCoordinator;
import com.bumptech.glide.request.SingleRequest;
import f4.e;
import f4.j;
import f4.k;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

public class g<TranscodeType> extends com.bumptech.glide.request.a<g<TranscodeType>> {
    protected static final c V = ((c) ((c) ((c) new c().e(l3.a.f15996c)).Y(Priority.LOW)).g0(true));
    private final Context H;
    private final h I;
    private final Class<TranscodeType> J;
    private final c K;
    private final e L;
    @NonNull
    private i<?, ? super TranscodeType> M;
    private Object N;
    private List<b<TranscodeType>> O;
    private g<TranscodeType> P;
    private g<TranscodeType> Q;
    private Float R;
    private boolean S = true;
    private boolean T;
    private boolean U;

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f9195a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f9196b;

        /* JADX WARNING: Can't wrap try/catch for region: R(27:0|(2:1|2)|3|(2:5|6)|7|9|10|11|(2:13|14)|15|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|34) */
        /* JADX WARNING: Can't wrap try/catch for region: R(29:0|1|2|3|(2:5|6)|7|9|10|11|13|14|15|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|34) */
        /* JADX WARNING: Can't wrap try/catch for region: R(30:0|1|2|3|5|6|7|9|10|11|13|14|15|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|34) */
        /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0044 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x004e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0058 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0062 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x006d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x0083 */
        static {
            /*
                com.bumptech.glide.Priority[] r0 = com.bumptech.glide.Priority.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f9196b = r0
                r1 = 1
                com.bumptech.glide.Priority r2 = com.bumptech.glide.Priority.LOW     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f9196b     // Catch:{ NoSuchFieldError -> 0x001d }
                com.bumptech.glide.Priority r3 = com.bumptech.glide.Priority.NORMAL     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = f9196b     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.bumptech.glide.Priority r4 = com.bumptech.glide.Priority.HIGH     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                r3 = 4
                int[] r4 = f9196b     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.bumptech.glide.Priority r5 = com.bumptech.glide.Priority.IMMEDIATE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                android.widget.ImageView$ScaleType[] r4 = android.widget.ImageView.ScaleType.values()
                int r4 = r4.length
                int[] r4 = new int[r4]
                f9195a = r4
                android.widget.ImageView$ScaleType r5 = android.widget.ImageView.ScaleType.CENTER_CROP     // Catch:{ NoSuchFieldError -> 0x0044 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0044 }
                r4[r5] = r1     // Catch:{ NoSuchFieldError -> 0x0044 }
            L_0x0044:
                int[] r1 = f9195a     // Catch:{ NoSuchFieldError -> 0x004e }
                android.widget.ImageView$ScaleType r4 = android.widget.ImageView.ScaleType.CENTER_INSIDE     // Catch:{ NoSuchFieldError -> 0x004e }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x004e }
                r1[r4] = r0     // Catch:{ NoSuchFieldError -> 0x004e }
            L_0x004e:
                int[] r0 = f9195a     // Catch:{ NoSuchFieldError -> 0x0058 }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_CENTER     // Catch:{ NoSuchFieldError -> 0x0058 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0058 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0058 }
            L_0x0058:
                int[] r0 = f9195a     // Catch:{ NoSuchFieldError -> 0x0062 }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_START     // Catch:{ NoSuchFieldError -> 0x0062 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0062 }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x0062 }
            L_0x0062:
                int[] r0 = f9195a     // Catch:{ NoSuchFieldError -> 0x006d }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_END     // Catch:{ NoSuchFieldError -> 0x006d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006d }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006d }
            L_0x006d:
                int[] r0 = f9195a     // Catch:{ NoSuchFieldError -> 0x0078 }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_XY     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = f9195a     // Catch:{ NoSuchFieldError -> 0x0083 }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.CENTER     // Catch:{ NoSuchFieldError -> 0x0083 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0083 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0083 }
            L_0x0083:
                int[] r0 = f9195a     // Catch:{ NoSuchFieldError -> 0x008f }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.MATRIX     // Catch:{ NoSuchFieldError -> 0x008f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x008f }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x008f }
            L_0x008f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.g.a.<clinit>():void");
        }
    }

    @SuppressLint({"CheckResult"})
    protected g(@NonNull c cVar, h hVar, Class<TranscodeType> cls, Context context) {
        this.K = cVar;
        this.I = hVar;
        this.J = cls;
        this.H = context;
        this.M = hVar.s(cls);
        this.L = cVar.i();
        t0(hVar.q());
        a(hVar.r());
    }

    @NonNull
    private g<TranscodeType> D0(Object obj) {
        this.N = obj;
        this.T = true;
        return this;
    }

    private b4.a E0(Object obj, h<TranscodeType> hVar, b<TranscodeType> bVar, com.bumptech.glide.request.a<?> aVar, RequestCoordinator requestCoordinator, i<?, ? super TranscodeType> iVar, Priority priority, int i10, int i11, Executor executor) {
        Context context = this.H;
        e eVar = this.L;
        return SingleRequest.x(context, eVar, obj, this.N, this.J, aVar, i10, i11, priority, hVar, bVar, this.O, requestCoordinator, eVar.f(), iVar.b(), executor);
    }

    private b4.a o0(h<TranscodeType> hVar, b<TranscodeType> bVar, com.bumptech.glide.request.a<?> aVar, Executor executor) {
        return p0(new Object(), hVar, bVar, (RequestCoordinator) null, this.M, aVar.x(), aVar.u(), aVar.t(), aVar, executor);
    }

    private b4.a p0(Object obj, h<TranscodeType> hVar, b<TranscodeType> bVar, RequestCoordinator requestCoordinator, i<?, ? super TranscodeType> iVar, Priority priority, int i10, int i11, com.bumptech.glide.request.a<?> aVar, Executor executor) {
        com.bumptech.glide.request.b bVar2;
        com.bumptech.glide.request.b bVar3;
        if (this.Q != null) {
            bVar3 = new com.bumptech.glide.request.b(obj, requestCoordinator);
            bVar2 = bVar3;
        } else {
            Object obj2 = obj;
            bVar2 = null;
            bVar3 = requestCoordinator;
        }
        b4.a q02 = q0(obj, hVar, bVar, bVar3, iVar, priority, i10, i11, aVar, executor);
        if (bVar2 == null) {
            return q02;
        }
        int u10 = this.Q.u();
        int t10 = this.Q.t();
        if (k.r(i10, i11) && !this.Q.O()) {
            u10 = aVar.u();
            t10 = aVar.t();
        }
        g<TranscodeType> gVar = this.Q;
        com.bumptech.glide.request.b bVar4 = bVar2;
        bVar4.o(q02, gVar.p0(obj, hVar, bVar, bVar4, gVar.M, gVar.x(), u10, t10, this.Q, executor));
        return bVar4;
    }

    /* JADX WARNING: type inference failed for: r27v0, types: [com.bumptech.glide.request.a, com.bumptech.glide.request.a<?>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private b4.a q0(java.lang.Object r19, c4.h<TranscodeType> r20, b4.b<TranscodeType> r21, com.bumptech.glide.request.RequestCoordinator r22, com.bumptech.glide.i<?, ? super TranscodeType> r23, com.bumptech.glide.Priority r24, int r25, int r26, com.bumptech.glide.request.a<?> r27, java.util.concurrent.Executor r28) {
        /*
            r18 = this;
            r11 = r18
            r12 = r19
            r5 = r22
            r13 = r24
            com.bumptech.glide.g<TranscodeType> r0 = r11.P
            if (r0 == 0) goto L_0x0094
            boolean r1 = r11.U
            if (r1 != 0) goto L_0x008c
            com.bumptech.glide.i<?, ? super TranscodeType> r1 = r0.M
            boolean r2 = r0.S
            if (r2 == 0) goto L_0x0019
            r14 = r23
            goto L_0x001a
        L_0x0019:
            r14 = r1
        L_0x001a:
            boolean r0 = r0.G()
            if (r0 == 0) goto L_0x0027
            com.bumptech.glide.g<TranscodeType> r0 = r11.P
            com.bumptech.glide.Priority r0 = r0.x()
            goto L_0x002b
        L_0x0027:
            com.bumptech.glide.Priority r0 = r11.s0(r13)
        L_0x002b:
            r15 = r0
            com.bumptech.glide.g<TranscodeType> r0 = r11.P
            int r0 = r0.u()
            com.bumptech.glide.g<TranscodeType> r1 = r11.P
            int r1 = r1.t()
            boolean r2 = f4.k.r(r25, r26)
            if (r2 == 0) goto L_0x004e
            com.bumptech.glide.g<TranscodeType> r2 = r11.P
            boolean r2 = r2.O()
            if (r2 != 0) goto L_0x004e
            int r0 = r27.u()
            int r1 = r27.t()
        L_0x004e:
            r16 = r0
            r17 = r1
            com.bumptech.glide.request.c r10 = new com.bumptech.glide.request.c
            r10.<init>(r12, r5)
            r0 = r18
            r1 = r19
            r2 = r20
            r3 = r21
            r4 = r27
            r5 = r10
            r6 = r23
            r7 = r24
            r8 = r25
            r9 = r26
            r13 = r10
            r10 = r28
            b4.a r10 = r0.E0(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            r0 = 1
            r11.U = r0
            com.bumptech.glide.g<TranscodeType> r9 = r11.P
            r0 = r9
            r4 = r13
            r5 = r14
            r6 = r15
            r7 = r16
            r8 = r17
            r12 = r10
            r10 = r28
            b4.a r0 = r0.p0(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            r1 = 0
            r11.U = r1
            r13.n(r12, r0)
            return r13
        L_0x008c:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "You cannot use a request as both the main request and a thumbnail, consider using clone() on the request(s) passed to thumbnail()"
            r0.<init>(r1)
            throw r0
        L_0x0094:
            java.lang.Float r0 = r11.R
            if (r0 == 0) goto L_0x00d4
            com.bumptech.glide.request.c r14 = new com.bumptech.glide.request.c
            r14.<init>(r12, r5)
            r0 = r18
            r1 = r19
            r2 = r20
            r3 = r21
            r4 = r27
            r5 = r14
            r6 = r23
            r7 = r24
            r8 = r25
            r9 = r26
            r10 = r28
            b4.a r15 = r0.E0(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            com.bumptech.glide.request.a r0 = r27.clone()
            java.lang.Float r1 = r11.R
            float r1 = r1.floatValue()
            com.bumptech.glide.request.a r4 = r0.f0(r1)
            com.bumptech.glide.Priority r7 = r11.s0(r13)
            r0 = r18
            r1 = r19
            b4.a r0 = r0.E0(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            r14.n(r15, r0)
            return r14
        L_0x00d4:
            r0 = r18
            r1 = r19
            r2 = r20
            r3 = r21
            r4 = r27
            r5 = r22
            r6 = r23
            r7 = r24
            r8 = r25
            r9 = r26
            r10 = r28
            b4.a r0 = r0.E0(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.g.q0(java.lang.Object, c4.h, b4.b, com.bumptech.glide.request.RequestCoordinator, com.bumptech.glide.i, com.bumptech.glide.Priority, int, int, com.bumptech.glide.request.a, java.util.concurrent.Executor):b4.a");
    }

    @NonNull
    private Priority s0(@NonNull Priority priority) {
        int i10 = a.f9196b[priority.ordinal()];
        if (i10 == 1) {
            return Priority.NORMAL;
        }
        if (i10 == 2) {
            return Priority.HIGH;
        }
        if (i10 == 3 || i10 == 4) {
            return Priority.IMMEDIATE;
        }
        throw new IllegalArgumentException("unknown priority: " + x());
    }

    @SuppressLint({"CheckResult"})
    private void t0(List<b<Object>> list) {
        for (b<Object> m02 : list) {
            m0(m02);
        }
    }

    private <Y extends h<TranscodeType>> Y v0(@NonNull Y y10, b<TranscodeType> bVar, com.bumptech.glide.request.a<?> aVar, Executor executor) {
        j.d(y10);
        if (this.T) {
            b4.a o02 = o0(y10, bVar, aVar, executor);
            b4.a a10 = y10.a();
            if (!o02.e(a10) || y0(aVar, a10)) {
                this.I.p(y10);
                y10.g(o02);
                this.I.A(y10, o02);
                return y10;
            }
            if (!((b4.a) j.d(a10)).isRunning()) {
                a10.j();
            }
            return y10;
        }
        throw new IllegalArgumentException("You must call #load() before calling #into()");
    }

    private boolean y0(com.bumptech.glide.request.a<?> aVar, b4.a aVar2) {
        return !aVar.F() && aVar2.h();
    }

    @NonNull
    public g<TranscodeType> A0(Integer num) {
        return D0(num).a(c.o0(e4.a.a(this.H)));
    }

    @NonNull
    public g<TranscodeType> B0(Object obj) {
        return D0(obj);
    }

    @NonNull
    public g<TranscodeType> C0(String str) {
        return D0(str);
    }

    @NonNull
    public g<TranscodeType> F0(@NonNull i<?, ? super TranscodeType> iVar) {
        this.M = (i) j.d(iVar);
        this.S = false;
        return this;
    }

    @NonNull
    public g<TranscodeType> m0(b<TranscodeType> bVar) {
        if (bVar != null) {
            if (this.O == null) {
                this.O = new ArrayList();
            }
            this.O.add(bVar);
        }
        return this;
    }

    @NonNull
    /* renamed from: n0 */
    public g<TranscodeType> a(@NonNull com.bumptech.glide.request.a<?> aVar) {
        j.d(aVar);
        return (g) super.a(aVar);
    }

    /* renamed from: r0 */
    public g<TranscodeType> clone() {
        g<TranscodeType> gVar = (g) super.clone();
        gVar.M = gVar.M.clone();
        return gVar;
    }

    @NonNull
    public <Y extends h<TranscodeType>> Y u0(@NonNull Y y10) {
        return w0(y10, (b) null, e.b());
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public <Y extends h<TranscodeType>> Y w0(@NonNull Y y10, b<TranscodeType> bVar, Executor executor) {
        return v0(y10, bVar, this, executor);
    }

    @NonNull
    public i<ImageView, TranscodeType> x0(@NonNull ImageView imageView) {
        com.bumptech.glide.request.a aVar;
        k.a();
        j.d(imageView);
        if (!N() && K() && imageView.getScaleType() != null) {
            switch (a.f9195a[imageView.getScaleType().ordinal()]) {
                case 1:
                    aVar = clone().R();
                    break;
                case 2:
                    aVar = clone().S();
                    break;
                case 3:
                case 4:
                case 5:
                    aVar = clone().T();
                    break;
                case 6:
                    aVar = clone().S();
                    break;
            }
        }
        aVar = this;
        return (i) v0(this.L.a(imageView, this.J), (b) null, aVar, e.b());
    }

    @NonNull
    public g<TranscodeType> z0(b<TranscodeType> bVar) {
        this.O = null;
        return m0(bVar);
    }
}
