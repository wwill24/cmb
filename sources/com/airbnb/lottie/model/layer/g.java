package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.Typeface;
import androidx.collection.e;
import c3.j;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.h;
import com.airbnb.lottie.h0;
import com.airbnb.lottie.model.DocumentData;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import u2.o;
import u2.q;
import x2.k;

public class g extends a {
    private final StringBuilder D = new StringBuilder(2);
    private final RectF E = new RectF();
    private final Matrix F = new Matrix();
    private final Paint G = new a(1);
    private final Paint H = new b(1);
    private final Map<w2.c, List<t2.d>> I = new HashMap();
    private final e<String> J = new e<>();
    private final List<d> K = new ArrayList();
    private final o L;
    private final LottieDrawable M;
    private final h N;
    private u2.a<Integer, Integer> O;
    private u2.a<Integer, Integer> P;
    private u2.a<Integer, Integer> Q;
    private u2.a<Integer, Integer> R;
    private u2.a<Float, Float> S;
    private u2.a<Float, Float> T;
    private u2.a<Float, Float> U;
    private u2.a<Float, Float> V;
    private u2.a<Float, Float> W;
    private u2.a<Typeface, Typeface> X;

    class a extends Paint {
        a(int i10) {
            super(i10);
            setStyle(Paint.Style.FILL);
        }
    }

    class b extends Paint {
        b(int i10) {
            super(i10);
            setStyle(Paint.Style.STROKE);
        }
    }

    static /* synthetic */ class c {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f8779a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.airbnb.lottie.model.DocumentData$Justification[] r0 = com.airbnb.lottie.model.DocumentData.Justification.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f8779a = r0
                com.airbnb.lottie.model.DocumentData$Justification r1 = com.airbnb.lottie.model.DocumentData.Justification.LEFT_ALIGN     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f8779a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.airbnb.lottie.model.DocumentData$Justification r1 = com.airbnb.lottie.model.DocumentData.Justification.RIGHT_ALIGN     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f8779a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.airbnb.lottie.model.DocumentData$Justification r1 = com.airbnb.lottie.model.DocumentData.Justification.CENTER     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.model.layer.g.c.<clinit>():void");
        }
    }

    g(LottieDrawable lottieDrawable, Layer layer) {
        super(lottieDrawable, layer);
        x2.b bVar;
        x2.b bVar2;
        x2.a aVar;
        x2.a aVar2;
        this.M = lottieDrawable;
        this.N = layer.b();
        o c10 = layer.s().a();
        this.L = c10;
        c10.a(this);
        i(c10);
        k t10 = layer.t();
        if (!(t10 == null || (aVar2 = t10.f18512a) == null)) {
            u2.a<Integer, Integer> a10 = aVar2.a();
            this.O = a10;
            a10.a(this);
            i(this.O);
        }
        if (!(t10 == null || (aVar = t10.f18513b) == null)) {
            u2.a<Integer, Integer> a11 = aVar.a();
            this.Q = a11;
            a11.a(this);
            i(this.Q);
        }
        if (!(t10 == null || (bVar2 = t10.f18514c) == null)) {
            u2.a<Float, Float> a12 = bVar2.a();
            this.S = a12;
            a12.a(this);
            i(this.S);
        }
        if (t10 != null && (bVar = t10.f18515d) != null) {
            u2.a<Float, Float> a13 = bVar.a();
            this.U = a13;
            a13.a(this);
            i(this.U);
        }
    }

    private String O(String str, int i10) {
        int codePointAt = str.codePointAt(i10);
        int charCount = Character.charCount(codePointAt) + i10;
        while (charCount < str.length()) {
            int codePointAt2 = str.codePointAt(charCount);
            if (!c0(codePointAt2)) {
                break;
            }
            charCount += Character.charCount(codePointAt2);
            codePointAt = (codePointAt * 31) + codePointAt2;
        }
        long j10 = (long) codePointAt;
        if (this.J.c(j10)) {
            return this.J.e(j10);
        }
        this.D.setLength(0);
        while (i10 < charCount) {
            int codePointAt3 = str.codePointAt(i10);
            this.D.appendCodePoint(codePointAt3);
            i10 += Character.charCount(codePointAt3);
        }
        String sb2 = this.D.toString();
        this.J.l(j10, sb2);
        return sb2;
    }

    private void P(DocumentData documentData, Matrix matrix) {
        int i10;
        u2.a<Integer, Integer> aVar = this.P;
        if (aVar != null) {
            this.G.setColor(aVar.h().intValue());
        } else {
            u2.a<Integer, Integer> aVar2 = this.O;
            if (aVar2 != null) {
                this.G.setColor(aVar2.h().intValue());
            } else {
                this.G.setColor(documentData.f8622h);
            }
        }
        u2.a<Integer, Integer> aVar3 = this.R;
        if (aVar3 != null) {
            this.H.setColor(aVar3.h().intValue());
        } else {
            u2.a<Integer, Integer> aVar4 = this.Q;
            if (aVar4 != null) {
                this.H.setColor(aVar4.h().intValue());
            } else {
                this.H.setColor(documentData.f8623i);
            }
        }
        if (this.f8771x.h() == null) {
            i10 = 100;
        } else {
            i10 = this.f8771x.h().h().intValue();
        }
        int i11 = (i10 * 255) / 100;
        this.G.setAlpha(i11);
        this.H.setAlpha(i11);
        u2.a<Float, Float> aVar5 = this.T;
        if (aVar5 != null) {
            this.H.setStrokeWidth(aVar5.h().floatValue());
            return;
        }
        u2.a<Float, Float> aVar6 = this.S;
        if (aVar6 != null) {
            this.H.setStrokeWidth(aVar6.h().floatValue());
        } else {
            this.H.setStrokeWidth(documentData.f8624j * j.e());
        }
    }

    private void Q(String str, Paint paint, Canvas canvas) {
        if (paint.getColor() != 0) {
            if (paint.getStyle() != Paint.Style.STROKE || paint.getStrokeWidth() != 0.0f) {
                canvas.drawText(str, 0, str.length(), 0.0f, 0.0f, paint);
            }
        }
    }

    private void R(w2.c cVar, float f10, DocumentData documentData, Canvas canvas) {
        List<t2.d> Z = Z(cVar);
        for (int i10 = 0; i10 < Z.size(); i10++) {
            Path path = Z.get(i10).getPath();
            path.computeBounds(this.E, false);
            this.F.reset();
            this.F.preTranslate(0.0f, (-documentData.f8621g) * j.e());
            this.F.preScale(f10, f10);
            path.transform(this.F);
            if (documentData.f8625k) {
                U(path, this.G, canvas);
                U(path, this.H, canvas);
            } else {
                U(path, this.H, canvas);
                U(path, this.G, canvas);
            }
        }
    }

    private void S(String str, DocumentData documentData, Canvas canvas) {
        if (documentData.f8625k) {
            Q(str, this.G, canvas);
            Q(str, this.H, canvas);
            return;
        }
        Q(str, this.H, canvas);
        Q(str, this.G, canvas);
    }

    private void T(String str, DocumentData documentData, Canvas canvas, float f10) {
        int i10 = 0;
        while (i10 < str.length()) {
            String O2 = O(str, i10);
            i10 += O2.length();
            S(O2, documentData, canvas);
            canvas.translate(this.G.measureText(O2) + f10, 0.0f);
        }
    }

    private void U(Path path, Paint paint, Canvas canvas) {
        if (paint.getColor() != 0) {
            if (paint.getStyle() != Paint.Style.STROKE || paint.getStrokeWidth() != 0.0f) {
                canvas.drawPath(path, paint);
            }
        }
    }

    private void V(String str, DocumentData documentData, w2.b bVar, Canvas canvas, float f10, float f11, float f12) {
        for (int i10 = 0; i10 < str.length(); i10++) {
            w2.c e10 = this.N.c().e(w2.c.c(str.charAt(i10), bVar.a(), bVar.c()));
            if (e10 != null) {
                R(e10, f11, documentData, canvas);
                canvas.translate((((float) e10.b()) * f11 * j.e()) + f12, 0.0f);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0089  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void W(com.airbnb.lottie.model.DocumentData r19, w2.b r20, android.graphics.Canvas r21) {
        /*
            r18 = this;
            r7 = r18
            r8 = r19
            r9 = r20
            r10 = r21
            android.graphics.Typeface r0 = r7.b0(r9)
            if (r0 != 0) goto L_0x000f
            return
        L_0x000f:
            java.lang.String r1 = r8.f8615a
            com.airbnb.lottie.LottieDrawable r2 = r7.M
            r2.W()
            android.graphics.Paint r2 = r7.G
            r2.setTypeface(r0)
            u2.a<java.lang.Float, java.lang.Float> r0 = r7.W
            if (r0 == 0) goto L_0x002a
            java.lang.Object r0 = r0.h()
            java.lang.Float r0 = (java.lang.Float) r0
            float r0 = r0.floatValue()
            goto L_0x002c
        L_0x002a:
            float r0 = r8.f8617c
        L_0x002c:
            android.graphics.Paint r2 = r7.G
            float r3 = c3.j.e()
            float r3 = r3 * r0
            r2.setTextSize(r3)
            android.graphics.Paint r2 = r7.H
            android.graphics.Paint r3 = r7.G
            android.graphics.Typeface r3 = r3.getTypeface()
            r2.setTypeface(r3)
            android.graphics.Paint r2 = r7.H
            android.graphics.Paint r3 = r7.G
            float r3 = r3.getTextSize()
            r2.setTextSize(r3)
            int r2 = r8.f8619e
            float r2 = (float) r2
            r3 = 1092616192(0x41200000, float:10.0)
            float r2 = r2 / r3
            u2.a<java.lang.Float, java.lang.Float> r3 = r7.V
            if (r3 == 0) goto L_0x0062
            java.lang.Object r3 = r3.h()
            java.lang.Float r3 = (java.lang.Float) r3
            float r3 = r3.floatValue()
        L_0x0060:
            float r2 = r2 + r3
            goto L_0x0071
        L_0x0062:
            u2.a<java.lang.Float, java.lang.Float> r3 = r7.U
            if (r3 == 0) goto L_0x0071
            java.lang.Object r3 = r3.h()
            java.lang.Float r3 = (java.lang.Float) r3
            float r3 = r3.floatValue()
            goto L_0x0060
        L_0x0071:
            float r3 = c3.j.e()
            float r2 = r2 * r3
            float r2 = r2 * r0
            r0 = 1120403456(0x42c80000, float:100.0)
            float r11 = r2 / r0
            java.util.List r12 = r7.a0(r1)
            int r13 = r12.size()
            r0 = -1
            r14 = 0
            r15 = r0
            r6 = r14
        L_0x0087:
            if (r6 >= r13) goto L_0x00d2
            java.lang.Object r0 = r12.get(r6)
            r1 = r0
            java.lang.String r1 = (java.lang.String) r1
            android.graphics.PointF r0 = r8.f8627m
            if (r0 != 0) goto L_0x0096
            r0 = 0
            goto L_0x0098
        L_0x0096:
            float r0 = r0.x
        L_0x0098:
            r2 = r0
            r4 = 0
            r16 = 0
            r0 = r18
            r3 = r20
            r5 = r11
            r17 = r6
            r6 = r16
            java.util.List r0 = r0.e0(r1, r2, r3, r4, r5, r6)
            r1 = r14
        L_0x00aa:
            int r2 = r0.size()
            if (r1 >= r2) goto L_0x00cf
            java.lang.Object r2 = r0.get(r1)
            com.airbnb.lottie.model.layer.g$d r2 = (com.airbnb.lottie.model.layer.g.d) r2
            int r15 = r15 + 1
            r21.save()
            float r3 = r2.f8781b
            r7.d0(r10, r8, r15, r3)
            java.lang.String r2 = r2.f8780a
            r7.T(r2, r8, r10, r11)
            r21.restore()
            int r1 = r1 + 1
            goto L_0x00aa
        L_0x00cf:
            int r6 = r17 + 1
            goto L_0x0087
        L_0x00d2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.model.layer.g.W(com.airbnb.lottie.model.DocumentData, w2.b, android.graphics.Canvas):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0053  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void X(com.airbnb.lottie.model.DocumentData r21, android.graphics.Matrix r22, w2.b r23, android.graphics.Canvas r24) {
        /*
            r20 = this;
            r8 = r20
            r9 = r21
            u2.a<java.lang.Float, java.lang.Float> r0 = r8.W
            if (r0 == 0) goto L_0x0013
            java.lang.Object r0 = r0.h()
            java.lang.Float r0 = (java.lang.Float) r0
            float r0 = r0.floatValue()
            goto L_0x0015
        L_0x0013:
            float r0 = r9.f8617c
        L_0x0015:
            r1 = 1120403456(0x42c80000, float:100.0)
            float r10 = r0 / r1
            float r11 = c3.j.g(r22)
            java.lang.String r0 = r9.f8615a
            java.util.List r12 = r8.a0(r0)
            int r13 = r12.size()
            int r0 = r9.f8619e
            float r0 = (float) r0
            r1 = 1092616192(0x41200000, float:10.0)
            float r0 = r0 / r1
            u2.a<java.lang.Float, java.lang.Float> r1 = r8.V
            if (r1 == 0) goto L_0x003d
            java.lang.Object r1 = r1.h()
            java.lang.Float r1 = (java.lang.Float) r1
            float r1 = r1.floatValue()
        L_0x003b:
            float r0 = r0 + r1
            goto L_0x004c
        L_0x003d:
            u2.a<java.lang.Float, java.lang.Float> r1 = r8.U
            if (r1 == 0) goto L_0x004c
            java.lang.Object r1 = r1.h()
            java.lang.Float r1 = (java.lang.Float) r1
            float r1 = r1.floatValue()
            goto L_0x003b
        L_0x004c:
            r14 = r0
            r0 = -1
            r15 = 0
            r7 = r0
            r6 = r15
        L_0x0051:
            if (r6 >= r13) goto L_0x00b1
            java.lang.Object r0 = r12.get(r6)
            r1 = r0
            java.lang.String r1 = (java.lang.String) r1
            android.graphics.PointF r0 = r9.f8627m
            if (r0 != 0) goto L_0x0060
            r0 = 0
            goto L_0x0062
        L_0x0060:
            float r0 = r0.x
        L_0x0062:
            r2 = r0
            r16 = 1
            r0 = r20
            r3 = r23
            r4 = r10
            r5 = r14
            r17 = r6
            r6 = r16
            java.util.List r6 = r0.e0(r1, r2, r3, r4, r5, r6)
            r5 = r15
        L_0x0074:
            int r0 = r6.size()
            if (r5 >= r0) goto L_0x00ae
            java.lang.Object r0 = r6.get(r5)
            com.airbnb.lottie.model.layer.g$d r0 = (com.airbnb.lottie.model.layer.g.d) r0
            int r7 = r7 + 1
            r24.save()
            float r1 = r0.f8781b
            r4 = r24
            r8.d0(r4, r9, r7, r1)
            java.lang.String r1 = r0.f8780a
            r0 = r20
            r2 = r21
            r3 = r23
            r16 = r5
            r5 = r11
            r18 = r6
            r6 = r10
            r19 = r7
            r7 = r14
            r0.V(r1, r2, r3, r4, r5, r6, r7)
            r24.restore()
            int r5 = r16 + 1
            r6 = r18
            r7 = r19
            goto L_0x0074
        L_0x00ae:
            int r6 = r17 + 1
            goto L_0x0051
        L_0x00b1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.model.layer.g.X(com.airbnb.lottie.model.DocumentData, android.graphics.Matrix, w2.b, android.graphics.Canvas):void");
    }

    private d Y(int i10) {
        for (int size = this.K.size(); size < i10; size++) {
            this.K.add(new d((a) null));
        }
        return this.K.get(i10 - 1);
    }

    private List<t2.d> Z(w2.c cVar) {
        if (this.I.containsKey(cVar)) {
            return this.I.get(cVar);
        }
        List<y2.k> a10 = cVar.a();
        int size = a10.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i10 = 0; i10 < size; i10++) {
            arrayList.add(new t2.d(this.M, this, a10.get(i10), this.N));
        }
        this.I.put(cVar, arrayList);
        return arrayList;
    }

    private List<String> a0(String str) {
        return Arrays.asList(str.replaceAll("\r\n", "\r").replaceAll("\u0003", "\r").replaceAll("\n", "\r").split("\r"));
    }

    private Typeface b0(w2.b bVar) {
        Typeface h10;
        u2.a<Typeface, Typeface> aVar = this.X;
        if (aVar != null && (h10 = aVar.h()) != null) {
            return h10;
        }
        Typeface X2 = this.M.X(bVar);
        if (X2 != null) {
            return X2;
        }
        return bVar.d();
    }

    private boolean c0(int i10) {
        if (Character.getType(i10) == 16 || Character.getType(i10) == 27 || Character.getType(i10) == 6 || Character.getType(i10) == 28 || Character.getType(i10) == 8 || Character.getType(i10) == 19) {
            return true;
        }
        return false;
    }

    private void d0(Canvas canvas, DocumentData documentData, int i10, float f10) {
        float f11;
        float f12;
        PointF pointF = documentData.f8626l;
        PointF pointF2 = documentData.f8627m;
        float e10 = j.e();
        float f13 = 0.0f;
        if (pointF == null) {
            f11 = 0.0f;
        } else {
            f11 = (documentData.f8620f * e10) + pointF.y;
        }
        float f14 = (((float) i10) * documentData.f8620f * e10) + f11;
        if (pointF == null) {
            f12 = 0.0f;
        } else {
            f12 = pointF.x;
        }
        if (pointF2 != null) {
            f13 = pointF2.x;
        }
        int i11 = c.f8779a[documentData.f8618d.ordinal()];
        if (i11 == 1) {
            canvas.translate(f12, f14);
        } else if (i11 == 2) {
            canvas.translate((f12 + f13) - f10, f14);
        } else if (i11 == 3) {
            canvas.translate((f12 + (f13 / 2.0f)) - (f10 / 2.0f), f14);
        }
    }

    private List<d> e0(String str, float f10, w2.b bVar, float f11, float f12, boolean z10) {
        float f13;
        String str2 = str;
        float f14 = 0.0f;
        float f15 = 0.0f;
        float f16 = 0.0f;
        int i10 = 0;
        int i11 = 0;
        boolean z11 = false;
        int i12 = 0;
        for (int i13 = 0; i13 < str.length(); i13++) {
            char charAt = str2.charAt(i13);
            if (z10) {
                w2.c e10 = this.N.c().e(w2.c.c(charAt, bVar.a(), bVar.c()));
                if (e10 == null) {
                } else {
                    f13 = ((float) e10.b()) * f11 * j.e();
                }
            } else {
                f13 = this.G.measureText(str2.substring(i13, i13 + 1));
            }
            float f17 = f13 + f12;
            if (charAt == ' ') {
                z11 = true;
                f16 = f17;
            } else if (z11) {
                z11 = false;
                i12 = i13;
                f15 = f17;
            } else {
                f15 += f17;
            }
            f14 += f17;
            if (f10 > 0.0f && f14 >= f10 && charAt != ' ') {
                i10++;
                d Y = Y(i10);
                if (i12 == i11) {
                    String substring = str2.substring(i11, i13);
                    String trim = substring.trim();
                    Y.c(trim, (f14 - f17) - (((float) (trim.length() - substring.length())) * f16));
                    i11 = i13;
                    i12 = i11;
                    f14 = f17;
                    f15 = f14;
                } else {
                    String substring2 = str2.substring(i11, i12 - 1);
                    String trim2 = substring2.trim();
                    Y.c(trim2, ((f14 - f15) - (((float) (substring2.length() - trim2.length())) * f16)) - f16);
                    f14 = f15;
                    i11 = i12;
                }
            }
        }
        if (f14 > 0.0f) {
            i10++;
            Y(i10).c(str2.substring(i11), f14);
        }
        return this.K.subList(0, i10);
    }

    public <T> void c(T t10, d3.c<T> cVar) {
        super.c(t10, cVar);
        if (t10 == h0.f8565a) {
            u2.a<Integer, Integer> aVar = this.P;
            if (aVar != null) {
                G(aVar);
            }
            if (cVar == null) {
                this.P = null;
                return;
            }
            q qVar = new q(cVar);
            this.P = qVar;
            qVar.a(this);
            i(this.P);
        } else if (t10 == h0.f8566b) {
            u2.a<Integer, Integer> aVar2 = this.R;
            if (aVar2 != null) {
                G(aVar2);
            }
            if (cVar == null) {
                this.R = null;
                return;
            }
            q qVar2 = new q(cVar);
            this.R = qVar2;
            qVar2.a(this);
            i(this.R);
        } else if (t10 == h0.f8583s) {
            u2.a<Float, Float> aVar3 = this.T;
            if (aVar3 != null) {
                G(aVar3);
            }
            if (cVar == null) {
                this.T = null;
                return;
            }
            q qVar3 = new q(cVar);
            this.T = qVar3;
            qVar3.a(this);
            i(this.T);
        } else if (t10 == h0.f8584t) {
            u2.a<Float, Float> aVar4 = this.V;
            if (aVar4 != null) {
                G(aVar4);
            }
            if (cVar == null) {
                this.V = null;
                return;
            }
            q qVar4 = new q(cVar);
            this.V = qVar4;
            qVar4.a(this);
            i(this.V);
        } else if (t10 == h0.F) {
            u2.a<Float, Float> aVar5 = this.W;
            if (aVar5 != null) {
                G(aVar5);
            }
            if (cVar == null) {
                this.W = null;
                return;
            }
            q qVar5 = new q(cVar);
            this.W = qVar5;
            qVar5.a(this);
            i(this.W);
        } else if (t10 == h0.M) {
            u2.a<Typeface, Typeface> aVar6 = this.X;
            if (aVar6 != null) {
                G(aVar6);
            }
            if (cVar == null) {
                this.X = null;
                return;
            }
            q qVar6 = new q(cVar);
            this.X = qVar6;
            qVar6.a(this);
            i(this.X);
        } else if (t10 == h0.O) {
            this.L.q(cVar);
        }
    }

    public void f(RectF rectF, Matrix matrix, boolean z10) {
        super.f(rectF, matrix, z10);
        rectF.set(0.0f, 0.0f, (float) this.N.b().width(), (float) this.N.b().height());
    }

    /* access modifiers changed from: package-private */
    public void t(Canvas canvas, Matrix matrix, int i10) {
        DocumentData documentData = (DocumentData) this.L.h();
        w2.b bVar = this.N.g().get(documentData.f8616b);
        if (bVar != null) {
            canvas.save();
            canvas.concat(matrix);
            P(documentData, matrix);
            if (this.M.b1()) {
                X(documentData, matrix, bVar, canvas);
            } else {
                W(documentData, bVar, canvas);
            }
            canvas.restore();
        }
    }

    private static class d {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public String f8780a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public float f8781b;

        private d() {
            this.f8780a = "";
            this.f8781b = 0.0f;
        }

        /* access modifiers changed from: package-private */
        public void c(String str, float f10) {
            this.f8780a = str;
            this.f8781b = f10;
        }

        /* synthetic */ d(a aVar) {
            this();
        }
    }
}
