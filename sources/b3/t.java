package b3;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.collection.h;
import androidx.core.view.animation.a;
import c3.i;
import c3.j;
import com.airbnb.lottie.c;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.mparticle.kits.ReportingMessage;
import java.io.IOException;
import java.lang.ref.WeakReference;

class t {

    /* renamed from: a  reason: collision with root package name */
    private static final Interpolator f7808a = new LinearInterpolator();

    /* renamed from: b  reason: collision with root package name */
    private static h<WeakReference<Interpolator>> f7809b;

    /* renamed from: c  reason: collision with root package name */
    static JsonReader.a f7810c = JsonReader.a.a("t", "s", ReportingMessage.MessageType.EVENT, ReportingMessage.MessageType.OPT_OUT, "i", "h", "to", "ti");

    /* renamed from: d  reason: collision with root package name */
    static JsonReader.a f7811d = JsonReader.a.a("x", "y");

    t() {
    }

    private static WeakReference<Interpolator> a(int i10) {
        WeakReference<Interpolator> e10;
        synchronized (t.class) {
            e10 = g().e(i10);
        }
        return e10;
    }

    private static Interpolator b(PointF pointF, PointF pointF2) {
        WeakReference<Interpolator> weakReference;
        Interpolator interpolator;
        pointF.x = i.b(pointF.x, -1.0f, 1.0f);
        pointF.y = i.b(pointF.y, -100.0f, 100.0f);
        pointF2.x = i.b(pointF2.x, -1.0f, 1.0f);
        float b10 = i.b(pointF2.y, -100.0f, 100.0f);
        pointF2.y = b10;
        int i10 = j.i(pointF.x, pointF.y, pointF2.x, b10);
        Interpolator interpolator2 = null;
        if (c.c()) {
            weakReference = null;
        } else {
            weakReference = a(i10);
        }
        if (weakReference != null) {
            interpolator2 = weakReference.get();
        }
        if (weakReference == null || interpolator2 == null) {
            try {
                interpolator = a.a(pointF.x, pointF.y, pointF2.x, pointF2.y);
            } catch (IllegalArgumentException e10) {
                if ("The Path cannot loop back on itself.".equals(e10.getMessage())) {
                    interpolator = a.a(Math.min(pointF.x, 1.0f), pointF.y, Math.max(pointF2.x, 0.0f), pointF2.y);
                } else {
                    interpolator = new LinearInterpolator();
                }
            }
            interpolator2 = interpolator;
            if (!c.c()) {
                try {
                    h(i10, new WeakReference(interpolator2));
                } catch (ArrayIndexOutOfBoundsException unused) {
                }
            }
        }
        return interpolator2;
    }

    static <T> d3.a<T> c(JsonReader jsonReader, com.airbnb.lottie.h hVar, float f10, n0<T> n0Var, boolean z10, boolean z11) throws IOException {
        if (z10 && z11) {
            return e(hVar, jsonReader, f10, n0Var);
        }
        if (z10) {
            return d(hVar, jsonReader, f10, n0Var);
        }
        return f(jsonReader, f10, n0Var);
    }

    private static <T> d3.a<T> d(com.airbnb.lottie.h hVar, JsonReader jsonReader, float f10, n0<T> n0Var) throws IOException {
        Interpolator interpolator;
        T t10;
        Interpolator interpolator2;
        jsonReader.c();
        PointF pointF = null;
        boolean z10 = false;
        T t11 = null;
        T t12 = null;
        PointF pointF2 = null;
        PointF pointF3 = null;
        float f11 = 0.0f;
        PointF pointF4 = null;
        while (jsonReader.g()) {
            switch (jsonReader.y(f7810c)) {
                case 0:
                    f11 = (float) jsonReader.k();
                    break;
                case 1:
                    t12 = n0Var.a(jsonReader, f10);
                    break;
                case 2:
                    t11 = n0Var.a(jsonReader, f10);
                    break;
                case 3:
                    pointF = s.e(jsonReader, 1.0f);
                    break;
                case 4:
                    pointF4 = s.e(jsonReader, 1.0f);
                    break;
                case 5:
                    if (jsonReader.l() != 1) {
                        z10 = false;
                        break;
                    } else {
                        z10 = true;
                        break;
                    }
                case 6:
                    pointF2 = s.e(jsonReader, f10);
                    break;
                case 7:
                    pointF3 = s.e(jsonReader, f10);
                    break;
                default:
                    jsonReader.E();
                    break;
            }
        }
        jsonReader.f();
        if (z10) {
            interpolator = f7808a;
            t10 = t12;
        } else {
            if (pointF == null || pointF4 == null) {
                interpolator2 = f7808a;
            } else {
                interpolator2 = b(pointF, pointF4);
            }
            interpolator = interpolator2;
            t10 = t11;
        }
        d3.a aVar = new d3.a(hVar, t12, t10, interpolator, f11, (Float) null);
        aVar.f14419o = pointF2;
        aVar.f14420p = pointF3;
        return aVar;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x017d, code lost:
        r14 = r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static <T> d3.a<T> e(com.airbnb.lottie.h r21, com.airbnb.lottie.parser.moshi.JsonReader r22, float r23, b3.n0<T> r24) throws java.io.IOException {
        /*
            r0 = r22
            r1 = r23
            r2 = r24
            r22.c()
            r3 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
        L_0x0016:
            boolean r17 = r22.g()
            if (r17 == 0) goto L_0x01a8
            com.airbnb.lottie.parser.moshi.JsonReader$a r4 = f7810c
            int r4 = r0.y(r4)
            r5 = 1
            switch(r4) {
                case 0: goto L_0x019b;
                case 1: goto L_0x0191;
                case 2: goto L_0x0187;
                case 3: goto L_0x00f3;
                case 4: goto L_0x0044;
                case 5: goto L_0x003a;
                case 6: goto L_0x0035;
                case 7: goto L_0x0030;
                default: goto L_0x0026;
            }
        L_0x0026:
            r19 = r3
            r3 = r14
            r18 = r15
            r22.E()
            goto L_0x01a4
        L_0x0030:
            android.graphics.PointF r3 = b3.s.e(r22, r23)
            goto L_0x0016
        L_0x0035:
            android.graphics.PointF r15 = b3.s.e(r22, r23)
            goto L_0x0016
        L_0x003a:
            int r4 = r22.l()
            if (r4 != r5) goto L_0x0042
            r6 = r5
            goto L_0x0016
        L_0x0042:
            r6 = 0
            goto L_0x0016
        L_0x0044:
            com.airbnb.lottie.parser.moshi.JsonReader$Token r4 = r22.v()
            com.airbnb.lottie.parser.moshi.JsonReader$Token r5 = com.airbnb.lottie.parser.moshi.JsonReader.Token.BEGIN_OBJECT
            if (r4 != r5) goto L_0x00e8
            r22.c()
            r4 = 0
            r5 = 0
            r12 = 0
            r13 = 0
        L_0x0053:
            boolean r18 = r22.g()
            if (r18 == 0) goto L_0x00d2
            r18 = r15
            com.airbnb.lottie.parser.moshi.JsonReader$a r15 = f7811d
            int r15 = r0.y(r15)
            if (r15 == 0) goto L_0x00a5
            r19 = r3
            r3 = 1
            if (r15 == r3) goto L_0x0070
            r22.E()
        L_0x006b:
            r15 = r18
            r3 = r19
            goto L_0x0053
        L_0x0070:
            com.airbnb.lottie.parser.moshi.JsonReader$Token r3 = r22.v()
            com.airbnb.lottie.parser.moshi.JsonReader$Token r5 = com.airbnb.lottie.parser.moshi.JsonReader.Token.NUMBER
            if (r3 != r5) goto L_0x0081
            r3 = r14
            double r13 = r22.k()
            float r13 = (float) r13
            r14 = r3
            r5 = r13
            goto L_0x006b
        L_0x0081:
            r3 = r14
            r22.b()
            double r13 = r22.k()
            float r13 = (float) r13
            com.airbnb.lottie.parser.moshi.JsonReader$Token r14 = r22.v()
            if (r14 != r5) goto L_0x0096
            double r14 = r22.k()
            float r5 = (float) r14
            goto L_0x0097
        L_0x0096:
            r5 = r13
        L_0x0097:
            r22.e()
            r14 = r3
            r15 = r18
            r3 = r19
            r20 = r13
            r13 = r5
            r5 = r20
            goto L_0x0053
        L_0x00a5:
            r19 = r3
            r3 = r14
            com.airbnb.lottie.parser.moshi.JsonReader$Token r4 = r22.v()
            com.airbnb.lottie.parser.moshi.JsonReader$Token r12 = com.airbnb.lottie.parser.moshi.JsonReader.Token.NUMBER
            if (r4 != r12) goto L_0x00b8
            double r14 = r22.k()
            float r12 = (float) r14
            r14 = r3
            r4 = r12
            goto L_0x006b
        L_0x00b8:
            r22.b()
            double r14 = r22.k()
            float r4 = (float) r14
            com.airbnb.lottie.parser.moshi.JsonReader$Token r14 = r22.v()
            if (r14 != r12) goto L_0x00cc
            double r14 = r22.k()
            float r12 = (float) r14
            goto L_0x00cd
        L_0x00cc:
            r12 = r4
        L_0x00cd:
            r22.e()
            r14 = r3
            goto L_0x006b
        L_0x00d2:
            r19 = r3
            r3 = r14
            r18 = r15
            android.graphics.PointF r14 = new android.graphics.PointF
            r14.<init>(r4, r5)
            android.graphics.PointF r4 = new android.graphics.PointF
            r4.<init>(r12, r13)
            r22.f()
            r13 = r4
            r12 = r14
            goto L_0x017d
        L_0x00e8:
            r19 = r3
            r3 = r14
            r18 = r15
            android.graphics.PointF r8 = b3.s.e(r22, r23)
            goto L_0x01a4
        L_0x00f3:
            r19 = r3
            r3 = r14
            r18 = r15
            com.airbnb.lottie.parser.moshi.JsonReader$Token r4 = r22.v()
            com.airbnb.lottie.parser.moshi.JsonReader$Token r5 = com.airbnb.lottie.parser.moshi.JsonReader.Token.BEGIN_OBJECT
            if (r4 != r5) goto L_0x017f
            r22.c()
            r4 = 0
            r5 = 0
            r9 = 0
            r11 = 0
        L_0x0107:
            boolean r14 = r22.g()
            if (r14 == 0) goto L_0x016c
            com.airbnb.lottie.parser.moshi.JsonReader$a r14 = f7811d
            int r14 = r0.y(r14)
            if (r14 == 0) goto L_0x0144
            r15 = 1
            if (r14 == r15) goto L_0x011c
            r22.E()
            goto L_0x0107
        L_0x011c:
            com.airbnb.lottie.parser.moshi.JsonReader$Token r5 = r22.v()
            com.airbnb.lottie.parser.moshi.JsonReader$Token r11 = com.airbnb.lottie.parser.moshi.JsonReader.Token.NUMBER
            if (r5 != r11) goto L_0x012b
            double r14 = r22.k()
            float r11 = (float) r14
            r5 = r11
            goto L_0x0107
        L_0x012b:
            r22.b()
            double r14 = r22.k()
            float r5 = (float) r14
            com.airbnb.lottie.parser.moshi.JsonReader$Token r14 = r22.v()
            if (r14 != r11) goto L_0x013f
            double r14 = r22.k()
            float r11 = (float) r14
            goto L_0x0140
        L_0x013f:
            r11 = r5
        L_0x0140:
            r22.e()
            goto L_0x0107
        L_0x0144:
            com.airbnb.lottie.parser.moshi.JsonReader$Token r4 = r22.v()
            com.airbnb.lottie.parser.moshi.JsonReader$Token r9 = com.airbnb.lottie.parser.moshi.JsonReader.Token.NUMBER
            if (r4 != r9) goto L_0x0153
            double r14 = r22.k()
            float r9 = (float) r14
            r4 = r9
            goto L_0x0107
        L_0x0153:
            r22.b()
            double r14 = r22.k()
            float r4 = (float) r14
            com.airbnb.lottie.parser.moshi.JsonReader$Token r14 = r22.v()
            if (r14 != r9) goto L_0x0167
            double r14 = r22.k()
            float r9 = (float) r14
            goto L_0x0168
        L_0x0167:
            r9 = r4
        L_0x0168:
            r22.e()
            goto L_0x0107
        L_0x016c:
            android.graphics.PointF r14 = new android.graphics.PointF
            r14.<init>(r4, r5)
            android.graphics.PointF r4 = new android.graphics.PointF
            r4.<init>(r9, r11)
            r22.f()
            r11 = r4
            r9 = r14
            r15 = r18
        L_0x017d:
            r14 = r3
            goto L_0x01a4
        L_0x017f:
            android.graphics.PointF r7 = b3.s.e(r22, r23)
            r14 = r3
            r15 = r18
            goto L_0x01a4
        L_0x0187:
            r19 = r3
            r3 = r14
            r18 = r15
            java.lang.Object r16 = r2.a(r0, r1)
            goto L_0x01a4
        L_0x0191:
            r19 = r3
            r3 = r14
            r18 = r15
            java.lang.Object r10 = r2.a(r0, r1)
            goto L_0x01a4
        L_0x019b:
            r19 = r3
            r18 = r15
            double r3 = r22.k()
            float r14 = (float) r3
        L_0x01a4:
            r3 = r19
            goto L_0x0016
        L_0x01a8:
            r19 = r3
            r3 = r14
            r18 = r15
            r22.f()
            if (r6 == 0) goto L_0x01b8
            android.view.animation.Interpolator r0 = f7808a
            r11 = r10
        L_0x01b5:
            r12 = 0
            r13 = 0
            goto L_0x01dc
        L_0x01b8:
            if (r7 == 0) goto L_0x01c1
            if (r8 == 0) goto L_0x01c1
            android.view.animation.Interpolator r0 = b(r7, r8)
            goto L_0x01d9
        L_0x01c1:
            if (r9 == 0) goto L_0x01d7
            if (r11 == 0) goto L_0x01d7
            if (r12 == 0) goto L_0x01d7
            if (r13 == 0) goto L_0x01d7
            android.view.animation.Interpolator r0 = b(r9, r12)
            android.view.animation.Interpolator r1 = b(r11, r13)
            r12 = r0
            r13 = r1
            r11 = r16
            r0 = 0
            goto L_0x01dc
        L_0x01d7:
            android.view.animation.Interpolator r0 = f7808a
        L_0x01d9:
            r11 = r16
            goto L_0x01b5
        L_0x01dc:
            if (r12 == 0) goto L_0x01ed
            if (r13 == 0) goto L_0x01ed
            d3.a r0 = new d3.a
            r15 = 0
            r8 = r0
            r9 = r21
            r14 = r3
            r5 = r18
            r8.<init>(r9, r10, r11, r12, r13, r14, r15)
            goto L_0x01fb
        L_0x01ed:
            r5 = r18
            d3.a r1 = new d3.a
            r14 = 0
            r8 = r1
            r9 = r21
            r12 = r0
            r13 = r3
            r8.<init>(r9, r10, r11, r12, r13, r14)
            r0 = r1
        L_0x01fb:
            r0.f14419o = r5
            r3 = r19
            r0.f14420p = r3
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: b3.t.e(com.airbnb.lottie.h, com.airbnb.lottie.parser.moshi.JsonReader, float, b3.n0):d3.a");
    }

    private static <T> d3.a<T> f(JsonReader jsonReader, float f10, n0<T> n0Var) throws IOException {
        return new d3.a<>(n0Var.a(jsonReader, f10));
    }

    private static h<WeakReference<Interpolator>> g() {
        if (f7809b == null) {
            f7809b = new h<>();
        }
        return f7809b;
    }

    private static void h(int i10, WeakReference<Interpolator> weakReference) {
        synchronized (t.class) {
            f7809b.k(i10, weakReference);
        }
    }
}
