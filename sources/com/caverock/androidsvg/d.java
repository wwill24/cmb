package com.caverock.androidsvg;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.util.Base64;
import com.caverock.androidsvg.CSSParser;
import com.caverock.androidsvg.SVG;
import com.leanplum.internal.Constants;
import com.mparticle.kits.AppsFlyerKit;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.Stack;
import net.bytebuddy.jar.asm.Opcodes;

class d {

    /* renamed from: i  reason: collision with root package name */
    private static HashSet<String> f9978i;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public Canvas f9979a;

    /* renamed from: b  reason: collision with root package name */
    private float f9980b;

    /* renamed from: c  reason: collision with root package name */
    private SVG f9981c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public h f9982d;

    /* renamed from: e  reason: collision with root package name */
    private Stack<h> f9983e;

    /* renamed from: f  reason: collision with root package name */
    private Stack<SVG.h0> f9984f;

    /* renamed from: g  reason: collision with root package name */
    private Stack<Matrix> f9985g;

    /* renamed from: h  reason: collision with root package name */
    private CSSParser.m f9986h = null;

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f9987a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f9988b;

        /* renamed from: c  reason: collision with root package name */
        static final /* synthetic */ int[] f9989c;

        /* JADX WARNING: Can't wrap try/catch for region: R(32:0|(2:1|2)|3|(2:5|6)|7|9|10|11|13|14|15|16|17|18|19|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|38) */
        /* JADX WARNING: Can't wrap try/catch for region: R(33:0|1|2|3|(2:5|6)|7|9|10|11|13|14|15|16|17|18|19|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|38) */
        /* JADX WARNING: Can't wrap try/catch for region: R(34:0|1|2|3|5|6|7|9|10|11|13|14|15|16|17|18|19|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|38) */
        /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0039 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0043 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x005e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0068 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0072 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x007d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x0088 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x0093 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x009e */
        static {
            /*
                com.caverock.androidsvg.SVG$Style$LineJoin[] r0 = com.caverock.androidsvg.SVG.Style.LineJoin.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f9989c = r0
                r1 = 1
                com.caverock.androidsvg.SVG$Style$LineJoin r2 = com.caverock.androidsvg.SVG.Style.LineJoin.Miter     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f9989c     // Catch:{ NoSuchFieldError -> 0x001d }
                com.caverock.androidsvg.SVG$Style$LineJoin r3 = com.caverock.androidsvg.SVG.Style.LineJoin.Round     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = f9989c     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.caverock.androidsvg.SVG$Style$LineJoin r4 = com.caverock.androidsvg.SVG.Style.LineJoin.Bevel     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                com.caverock.androidsvg.SVG$Style$LineCap[] r3 = com.caverock.androidsvg.SVG.Style.LineCap.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                f9988b = r3
                com.caverock.androidsvg.SVG$Style$LineCap r4 = com.caverock.androidsvg.SVG.Style.LineCap.Butt     // Catch:{ NoSuchFieldError -> 0x0039 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0039 }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0039 }
            L_0x0039:
                int[] r3 = f9988b     // Catch:{ NoSuchFieldError -> 0x0043 }
                com.caverock.androidsvg.SVG$Style$LineCap r4 = com.caverock.androidsvg.SVG.Style.LineCap.Round     // Catch:{ NoSuchFieldError -> 0x0043 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0043 }
                r3[r4] = r0     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                int[] r3 = f9988b     // Catch:{ NoSuchFieldError -> 0x004d }
                com.caverock.androidsvg.SVG$Style$LineCap r4 = com.caverock.androidsvg.SVG.Style.LineCap.Square     // Catch:{ NoSuchFieldError -> 0x004d }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x004d }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x004d }
            L_0x004d:
                com.caverock.androidsvg.PreserveAspectRatio$Alignment[] r3 = com.caverock.androidsvg.PreserveAspectRatio.Alignment.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                f9987a = r3
                com.caverock.androidsvg.PreserveAspectRatio$Alignment r4 = com.caverock.androidsvg.PreserveAspectRatio.Alignment.xMidYMin     // Catch:{ NoSuchFieldError -> 0x005e }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x005e }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x005e }
            L_0x005e:
                int[] r1 = f9987a     // Catch:{ NoSuchFieldError -> 0x0068 }
                com.caverock.androidsvg.PreserveAspectRatio$Alignment r3 = com.caverock.androidsvg.PreserveAspectRatio.Alignment.xMidYMid     // Catch:{ NoSuchFieldError -> 0x0068 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0068 }
                r1[r3] = r0     // Catch:{ NoSuchFieldError -> 0x0068 }
            L_0x0068:
                int[] r0 = f9987a     // Catch:{ NoSuchFieldError -> 0x0072 }
                com.caverock.androidsvg.PreserveAspectRatio$Alignment r1 = com.caverock.androidsvg.PreserveAspectRatio.Alignment.xMidYMax     // Catch:{ NoSuchFieldError -> 0x0072 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0072 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0072 }
            L_0x0072:
                int[] r0 = f9987a     // Catch:{ NoSuchFieldError -> 0x007d }
                com.caverock.androidsvg.PreserveAspectRatio$Alignment r1 = com.caverock.androidsvg.PreserveAspectRatio.Alignment.xMaxYMin     // Catch:{ NoSuchFieldError -> 0x007d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x007d }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x007d }
            L_0x007d:
                int[] r0 = f9987a     // Catch:{ NoSuchFieldError -> 0x0088 }
                com.caverock.androidsvg.PreserveAspectRatio$Alignment r1 = com.caverock.androidsvg.PreserveAspectRatio.Alignment.xMaxYMid     // Catch:{ NoSuchFieldError -> 0x0088 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0088 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0088 }
            L_0x0088:
                int[] r0 = f9987a     // Catch:{ NoSuchFieldError -> 0x0093 }
                com.caverock.androidsvg.PreserveAspectRatio$Alignment r1 = com.caverock.androidsvg.PreserveAspectRatio.Alignment.xMaxYMax     // Catch:{ NoSuchFieldError -> 0x0093 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0093 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0093 }
            L_0x0093:
                int[] r0 = f9987a     // Catch:{ NoSuchFieldError -> 0x009e }
                com.caverock.androidsvg.PreserveAspectRatio$Alignment r1 = com.caverock.androidsvg.PreserveAspectRatio.Alignment.xMinYMid     // Catch:{ NoSuchFieldError -> 0x009e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009e }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009e }
            L_0x009e:
                int[] r0 = f9987a     // Catch:{ NoSuchFieldError -> 0x00aa }
                com.caverock.androidsvg.PreserveAspectRatio$Alignment r1 = com.caverock.androidsvg.PreserveAspectRatio.Alignment.xMinYMax     // Catch:{ NoSuchFieldError -> 0x00aa }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00aa }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00aa }
            L_0x00aa:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.caverock.androidsvg.d.a.<clinit>():void");
        }
    }

    private class b implements SVG.w {

        /* renamed from: a  reason: collision with root package name */
        private List<c> f9990a = new ArrayList();

        /* renamed from: b  reason: collision with root package name */
        private float f9991b;

        /* renamed from: c  reason: collision with root package name */
        private float f9992c;

        /* renamed from: d  reason: collision with root package name */
        private c f9993d = null;

        /* renamed from: e  reason: collision with root package name */
        private boolean f9994e = false;

        /* renamed from: f  reason: collision with root package name */
        private boolean f9995f = true;

        /* renamed from: g  reason: collision with root package name */
        private int f9996g = -1;

        /* renamed from: h  reason: collision with root package name */
        private boolean f9997h;

        b(SVG.v vVar) {
            if (vVar != null) {
                vVar.h(this);
                if (this.f9997h) {
                    this.f9993d.b(this.f9990a.get(this.f9996g));
                    this.f9990a.set(this.f9996g, this.f9993d);
                    this.f9997h = false;
                }
                c cVar = this.f9993d;
                if (cVar != null) {
                    this.f9990a.add(cVar);
                }
            }
        }

        public void a(float f10, float f11, float f12, float f13) {
            this.f9993d.a(f10, f11);
            this.f9990a.add(this.f9993d);
            this.f9993d = new c(f12, f13, f12 - f10, f13 - f11);
            this.f9997h = false;
        }

        public void b(float f10, float f11) {
            if (this.f9997h) {
                this.f9993d.b(this.f9990a.get(this.f9996g));
                this.f9990a.set(this.f9996g, this.f9993d);
                this.f9997h = false;
            }
            c cVar = this.f9993d;
            if (cVar != null) {
                this.f9990a.add(cVar);
            }
            this.f9991b = f10;
            this.f9992c = f11;
            this.f9993d = new c(f10, f11, 0.0f, 0.0f);
            this.f9996g = this.f9990a.size();
        }

        public void c(float f10, float f11, float f12, float f13, float f14, float f15) {
            if (this.f9995f || this.f9994e) {
                this.f9993d.a(f10, f11);
                this.f9990a.add(this.f9993d);
                this.f9994e = false;
            }
            this.f9993d = new c(f14, f15, f14 - f12, f15 - f13);
            this.f9997h = false;
        }

        public void close() {
            this.f9990a.add(this.f9993d);
            e(this.f9991b, this.f9992c);
            this.f9997h = true;
        }

        public void d(float f10, float f11, float f12, boolean z10, boolean z11, float f13, float f14) {
            this.f9994e = true;
            this.f9995f = false;
            c cVar = this.f9993d;
            d.h(cVar.f9999a, cVar.f10000b, f10, f11, f12, z10, z11, f13, f14, this);
            this.f9995f = true;
            this.f9997h = false;
        }

        public void e(float f10, float f11) {
            this.f9993d.a(f10, f11);
            this.f9990a.add(this.f9993d);
            d dVar = d.this;
            c cVar = this.f9993d;
            this.f9993d = new c(f10, f11, f10 - cVar.f9999a, f11 - cVar.f10000b);
            this.f9997h = false;
        }

        /* access modifiers changed from: package-private */
        public List<c> f() {
            return this.f9990a;
        }
    }

    private class c {

        /* renamed from: a  reason: collision with root package name */
        float f9999a;

        /* renamed from: b  reason: collision with root package name */
        float f10000b;

        /* renamed from: c  reason: collision with root package name */
        float f10001c = 0.0f;

        /* renamed from: d  reason: collision with root package name */
        float f10002d = 0.0f;

        /* renamed from: e  reason: collision with root package name */
        boolean f10003e = false;

        c(float f10, float f11, float f12, float f13) {
            this.f9999a = f10;
            this.f10000b = f11;
            double sqrt = Math.sqrt((double) ((f12 * f12) + (f13 * f13)));
            if (sqrt != 0.0d) {
                this.f10001c = (float) (((double) f12) / sqrt);
                this.f10002d = (float) (((double) f13) / sqrt);
            }
        }

        /* access modifiers changed from: package-private */
        public void a(float f10, float f11) {
            float f12 = f10 - this.f9999a;
            float f13 = f11 - this.f10000b;
            double sqrt = Math.sqrt((double) ((f12 * f12) + (f13 * f13)));
            if (sqrt != 0.0d) {
                f12 = (float) (((double) f12) / sqrt);
                f13 = (float) (((double) f13) / sqrt);
            }
            float f14 = this.f10001c;
            if (f12 == (-f14) && f13 == (-this.f10002d)) {
                this.f10003e = true;
                this.f10001c = -f13;
                this.f10002d = f12;
                return;
            }
            this.f10001c = f14 + f12;
            this.f10002d += f13;
        }

        /* access modifiers changed from: package-private */
        public void b(c cVar) {
            float f10 = cVar.f10001c;
            float f11 = this.f10001c;
            if (f10 == (-f11)) {
                float f12 = cVar.f10002d;
                if (f12 == (-this.f10002d)) {
                    this.f10003e = true;
                    this.f10001c = -f12;
                    this.f10002d = cVar.f10001c;
                    return;
                }
            }
            this.f10001c = f11 + f10;
            this.f10002d += cVar.f10002d;
        }

        public String toString() {
            return "(" + this.f9999a + AppsFlyerKit.COMMA + this.f10000b + " " + this.f10001c + AppsFlyerKit.COMMA + this.f10002d + ")";
        }
    }

    /* renamed from: com.caverock.androidsvg.d$d  reason: collision with other inner class name */
    private class C0114d implements SVG.w {

        /* renamed from: a  reason: collision with root package name */
        Path f10005a = new Path();

        /* renamed from: b  reason: collision with root package name */
        float f10006b;

        /* renamed from: c  reason: collision with root package name */
        float f10007c;

        C0114d(SVG.v vVar) {
            if (vVar != null) {
                vVar.h(this);
            }
        }

        public void a(float f10, float f11, float f12, float f13) {
            this.f10005a.quadTo(f10, f11, f12, f13);
            this.f10006b = f12;
            this.f10007c = f13;
        }

        public void b(float f10, float f11) {
            this.f10005a.moveTo(f10, f11);
            this.f10006b = f10;
            this.f10007c = f11;
        }

        public void c(float f10, float f11, float f12, float f13, float f14, float f15) {
            this.f10005a.cubicTo(f10, f11, f12, f13, f14, f15);
            this.f10006b = f14;
            this.f10007c = f15;
        }

        public void close() {
            this.f10005a.close();
        }

        public void d(float f10, float f11, float f12, boolean z10, boolean z11, float f13, float f14) {
            d.h(this.f10006b, this.f10007c, f10, f11, f12, z10, z11, f13, f14, this);
            this.f10006b = f13;
            this.f10007c = f14;
        }

        public void e(float f10, float f11) {
            this.f10005a.lineTo(f10, f11);
            this.f10006b = f10;
            this.f10007c = f11;
        }

        /* access modifiers changed from: package-private */
        public Path f() {
            return this.f10005a;
        }
    }

    private class e extends f {

        /* renamed from: e  reason: collision with root package name */
        private Path f10009e;

        e(Path path, float f10, float f11) {
            super(f10, f11);
            this.f10009e = path;
        }

        public void b(String str) {
            if (d.this.Y0()) {
                if (d.this.f9982d.f10019b) {
                    d.this.f9979a.drawTextOnPath(str, this.f10009e, this.f10011b, this.f10012c, d.this.f9982d.f10021d);
                }
                if (d.this.f9982d.f10020c) {
                    d.this.f9979a.drawTextOnPath(str, this.f10009e, this.f10011b, this.f10012c, d.this.f9982d.f10022e);
                }
            }
            this.f10011b += d.this.f9982d.f10021d.measureText(str);
        }
    }

    private class f extends j {

        /* renamed from: b  reason: collision with root package name */
        float f10011b;

        /* renamed from: c  reason: collision with root package name */
        float f10012c;

        f(float f10, float f11) {
            super(d.this, (a) null);
            this.f10011b = f10;
            this.f10012c = f11;
        }

        public void b(String str) {
            d.y("TextSequence render", new Object[0]);
            if (d.this.Y0()) {
                if (d.this.f9982d.f10019b) {
                    d.this.f9979a.drawText(str, this.f10011b, this.f10012c, d.this.f9982d.f10021d);
                }
                if (d.this.f9982d.f10020c) {
                    d.this.f9979a.drawText(str, this.f10011b, this.f10012c, d.this.f9982d.f10022e);
                }
            }
            this.f10011b += d.this.f9982d.f10021d.measureText(str);
        }
    }

    private class g extends j {

        /* renamed from: b  reason: collision with root package name */
        float f10014b;

        /* renamed from: c  reason: collision with root package name */
        float f10015c;

        /* renamed from: d  reason: collision with root package name */
        Path f10016d;

        g(float f10, float f11, Path path) {
            super(d.this, (a) null);
            this.f10014b = f10;
            this.f10015c = f11;
            this.f10016d = path;
        }

        public boolean a(SVG.w0 w0Var) {
            if (!(w0Var instanceof SVG.x0)) {
                return true;
            }
            d.Z0("Using <textPath> elements in a clip path is not supported.", new Object[0]);
            return false;
        }

        public void b(String str) {
            if (d.this.Y0()) {
                Path path = new Path();
                d.this.f9982d.f10021d.getTextPath(str, 0, str.length(), this.f10014b, this.f10015c, path);
                this.f10016d.addPath(path);
            }
            this.f10014b += d.this.f9982d.f10021d.measureText(str);
        }
    }

    private class i extends j {

        /* renamed from: b  reason: collision with root package name */
        float f10027b;

        /* renamed from: c  reason: collision with root package name */
        float f10028c;

        /* renamed from: d  reason: collision with root package name */
        RectF f10029d = new RectF();

        i(float f10, float f11) {
            super(d.this, (a) null);
            this.f10027b = f10;
            this.f10028c = f11;
        }

        public boolean a(SVG.w0 w0Var) {
            if (!(w0Var instanceof SVG.x0)) {
                return true;
            }
            SVG.x0 x0Var = (SVG.x0) w0Var;
            SVG.l0 p10 = w0Var.f9818a.p(x0Var.f9871o);
            if (p10 == null) {
                d.F("TextPath path reference '%s' not found", x0Var.f9871o);
                return false;
            }
            SVG.u uVar = (SVG.u) p10;
            Path f10 = new C0114d(uVar.f9856o).f();
            Matrix matrix = uVar.f9812n;
            if (matrix != null) {
                f10.transform(matrix);
            }
            RectF rectF = new RectF();
            f10.computeBounds(rectF, true);
            this.f10029d.union(rectF);
            return false;
        }

        public void b(String str) {
            if (d.this.Y0()) {
                Rect rect = new Rect();
                d.this.f9982d.f10021d.getTextBounds(str, 0, str.length(), rect);
                RectF rectF = new RectF(rect);
                rectF.offset(this.f10027b, this.f10028c);
                this.f10029d.union(rectF);
            }
            this.f10027b += d.this.f9982d.f10021d.measureText(str);
        }
    }

    private abstract class j {
        private j() {
        }

        public boolean a(SVG.w0 w0Var) {
            return true;
        }

        public abstract void b(String str);

        /* synthetic */ j(d dVar, a aVar) {
            this();
        }
    }

    d(Canvas canvas, float f10) {
        this.f9979a = canvas;
        this.f9980b = f10;
    }

    private boolean A() {
        Boolean bool = this.f9982d.f10018a.H;
        if (bool != null) {
            return bool.booleanValue();
        }
        return true;
    }

    private void A0(SVG.l0 l0Var) {
        if (!(l0Var instanceof SVG.s)) {
            S0();
            u(l0Var);
            if (l0Var instanceof SVG.d0) {
                x0((SVG.d0) l0Var);
            } else if (l0Var instanceof SVG.b1) {
                E0((SVG.b1) l0Var);
            } else if (l0Var instanceof SVG.q0) {
                B0((SVG.q0) l0Var);
            } else if (l0Var instanceof SVG.l) {
                q0((SVG.l) l0Var);
            } else if (l0Var instanceof SVG.n) {
                r0((SVG.n) l0Var);
            } else if (l0Var instanceof SVG.u) {
                t0((SVG.u) l0Var);
            } else if (l0Var instanceof SVG.a0) {
                w0((SVG.a0) l0Var);
            } else if (l0Var instanceof SVG.d) {
                o0((SVG.d) l0Var);
            } else if (l0Var instanceof SVG.i) {
                p0((SVG.i) l0Var);
            } else if (l0Var instanceof SVG.p) {
                s0((SVG.p) l0Var);
            } else if (l0Var instanceof SVG.z) {
                v0((SVG.z) l0Var);
            } else if (l0Var instanceof SVG.y) {
                u0((SVG.y) l0Var);
            } else if (l0Var instanceof SVG.u0) {
                D0((SVG.u0) l0Var);
            }
            R0();
        }
    }

    private void B(SVG.i0 i0Var, Path path) {
        SVG.m0 m0Var = this.f9982d.f10018a.f9686b;
        if (m0Var instanceof SVG.t) {
            SVG.l0 p10 = this.f9981c.p(((SVG.t) m0Var).f9853a);
            if (p10 instanceof SVG.x) {
                L(i0Var, path, (SVG.x) p10);
                return;
            }
        }
        this.f9979a.drawPath(path, this.f9982d.f10021d);
    }

    private void B0(SVG.q0 q0Var) {
        y("Switch render", new Object[0]);
        W0(this.f9982d, q0Var);
        if (A()) {
            Matrix matrix = q0Var.f9817o;
            if (matrix != null) {
                this.f9979a.concat(matrix);
            }
            p(q0Var);
            boolean m02 = m0();
            K0(q0Var);
            if (m02) {
                j0(q0Var);
            }
            U0(q0Var);
        }
    }

    private void C(Path path) {
        h hVar = this.f9982d;
        if (hVar.f10018a.S == SVG.Style.VectorEffect.NonScalingStroke) {
            Matrix matrix = this.f9979a.getMatrix();
            Path path2 = new Path();
            path.transform(matrix, path2);
            this.f9979a.setMatrix(new Matrix());
            Shader shader = this.f9982d.f10022e.getShader();
            Matrix matrix2 = new Matrix();
            if (shader != null) {
                shader.getLocalMatrix(matrix2);
                Matrix matrix3 = new Matrix(matrix2);
                matrix3.postConcat(matrix);
                shader.setLocalMatrix(matrix3);
            }
            this.f9979a.drawPath(path2, this.f9982d.f10022e);
            this.f9979a.setMatrix(matrix);
            if (shader != null) {
                shader.setLocalMatrix(matrix2);
                return;
            }
            return;
        }
        this.f9979a.drawPath(path, hVar.f10022e);
    }

    private void C0(SVG.r0 r0Var, SVG.b bVar) {
        y("Symbol render", new Object[0]);
        if (bVar.f9761c != 0.0f && bVar.f9762d != 0.0f) {
            PreserveAspectRatio preserveAspectRatio = r0Var.f9826o;
            if (preserveAspectRatio == null) {
                preserveAspectRatio = PreserveAspectRatio.f9651e;
            }
            W0(this.f9982d, r0Var);
            h hVar = this.f9982d;
            hVar.f10023f = bVar;
            if (!hVar.f10018a.C.booleanValue()) {
                SVG.b bVar2 = this.f9982d.f10023f;
                O0(bVar2.f9759a, bVar2.f9760b, bVar2.f9761c, bVar2.f9762d);
            }
            SVG.b bVar3 = r0Var.f9838p;
            if (bVar3 != null) {
                this.f9979a.concat(o(this.f9982d.f10023f, bVar3, preserveAspectRatio));
                this.f9982d.f10024g = r0Var.f9838p;
            } else {
                Canvas canvas = this.f9979a;
                SVG.b bVar4 = this.f9982d.f10023f;
                canvas.translate(bVar4.f9759a, bVar4.f9760b);
            }
            boolean m02 = m0();
            F0(r0Var, true);
            if (m02) {
                j0(r0Var);
            }
            U0(r0Var);
        }
    }

    private float D(float f10, float f11, float f12, float f13) {
        return (f10 * f12) + (f11 * f13);
    }

    private void D0(SVG.u0 u0Var) {
        float f10;
        float f11;
        float f12;
        y("Text render", new Object[0]);
        W0(this.f9982d, u0Var);
        if (A()) {
            Matrix matrix = u0Var.f9858s;
            if (matrix != null) {
                this.f9979a.concat(matrix);
            }
            List<SVG.o> list = u0Var.f9875o;
            float f13 = 0.0f;
            if (list == null || list.size() == 0) {
                f10 = 0.0f;
            } else {
                f10 = u0Var.f9875o.get(0).e(this);
            }
            List<SVG.o> list2 = u0Var.f9876p;
            if (list2 == null || list2.size() == 0) {
                f11 = 0.0f;
            } else {
                f11 = u0Var.f9876p.get(0).h(this);
            }
            List<SVG.o> list3 = u0Var.f9877q;
            if (list3 == null || list3.size() == 0) {
                f12 = 0.0f;
            } else {
                f12 = u0Var.f9877q.get(0).e(this);
            }
            List<SVG.o> list4 = u0Var.f9878r;
            if (!(list4 == null || list4.size() == 0)) {
                f13 = u0Var.f9878r.get(0).h(this);
            }
            SVG.Style.TextAnchor O = O();
            if (O != SVG.Style.TextAnchor.Start) {
                float n10 = n(u0Var);
                if (O == SVG.Style.TextAnchor.Middle) {
                    n10 /= 2.0f;
                }
                f10 -= n10;
            }
            if (u0Var.f9801h == null) {
                i iVar = new i(f10, f11);
                E(u0Var, iVar);
                RectF rectF = iVar.f10029d;
                u0Var.f9801h = new SVG.b(rectF.left, rectF.top, rectF.width(), iVar.f10029d.height());
            }
            U0(u0Var);
            r(u0Var);
            p(u0Var);
            boolean m02 = m0();
            E(u0Var, new f(f10 + f12, f11 + f13));
            if (m02) {
                j0(u0Var);
            }
        }
    }

    private void E(SVG.w0 w0Var, j jVar) {
        if (A()) {
            Iterator<SVG.l0> it = w0Var.f9785i.iterator();
            boolean z10 = true;
            while (it.hasNext()) {
                SVG.l0 next = it.next();
                if (next instanceof SVG.a1) {
                    jVar.b(T0(((SVG.a1) next).f9757c, z10, !it.hasNext()));
                } else {
                    l0(next, jVar);
                }
                z10 = false;
            }
        }
    }

    private void E0(SVG.b1 b1Var) {
        float f10;
        y("Use render", new Object[0]);
        SVG.o oVar = b1Var.f9766s;
        if (oVar == null || !oVar.j()) {
            SVG.o oVar2 = b1Var.f9767t;
            if (oVar2 == null || !oVar2.j()) {
                W0(this.f9982d, b1Var);
                if (A()) {
                    SVG.l0 p10 = b1Var.f9818a.p(b1Var.f9763p);
                    if (p10 == null) {
                        F("Use reference '%s' not found", b1Var.f9763p);
                        return;
                    }
                    Matrix matrix = b1Var.f9817o;
                    if (matrix != null) {
                        this.f9979a.concat(matrix);
                    }
                    SVG.o oVar3 = b1Var.f9764q;
                    float f11 = 0.0f;
                    if (oVar3 != null) {
                        f10 = oVar3.e(this);
                    } else {
                        f10 = 0.0f;
                    }
                    SVG.o oVar4 = b1Var.f9765r;
                    if (oVar4 != null) {
                        f11 = oVar4.h(this);
                    }
                    this.f9979a.translate(f10, f11);
                    p(b1Var);
                    boolean m02 = m0();
                    i0(b1Var);
                    if (p10 instanceof SVG.d0) {
                        SVG.b f02 = f0((SVG.o) null, (SVG.o) null, b1Var.f9766s, b1Var.f9767t);
                        S0();
                        y0((SVG.d0) p10, f02);
                        R0();
                    } else if (p10 instanceof SVG.r0) {
                        SVG.o oVar5 = b1Var.f9766s;
                        if (oVar5 == null) {
                            oVar5 = new SVG.o(100.0f, SVG.Unit.percent);
                        }
                        SVG.o oVar6 = b1Var.f9767t;
                        if (oVar6 == null) {
                            oVar6 = new SVG.o(100.0f, SVG.Unit.percent);
                        }
                        SVG.b f03 = f0((SVG.o) null, (SVG.o) null, oVar5, oVar6);
                        S0();
                        C0((SVG.r0) p10, f03);
                        R0();
                    } else {
                        A0(p10);
                    }
                    h0();
                    if (m02) {
                        j0(b1Var);
                    }
                    U0(b1Var);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public static void F(String str, Object... objArr) {
        String.format(str, objArr);
    }

    private void F0(SVG.h0 h0Var, boolean z10) {
        if (z10) {
            i0(h0Var);
        }
        for (SVG.l0 A0 : h0Var.getChildren()) {
            A0(A0);
        }
        if (z10) {
            h0();
        }
    }

    private void G(SVG.w0 w0Var, StringBuilder sb2) {
        Iterator<SVG.l0> it = w0Var.f9785i.iterator();
        boolean z10 = true;
        while (it.hasNext()) {
            SVG.l0 next = it.next();
            if (next instanceof SVG.w0) {
                G((SVG.w0) next, sb2);
            } else if (next instanceof SVG.a1) {
                sb2.append(T0(((SVG.a1) next).f9757c, z10, !it.hasNext()));
            }
            z10 = false;
        }
    }

    private void H(SVG.j jVar, String str) {
        SVG.l0 p10 = jVar.f9818a.p(str);
        if (p10 == null) {
            Z0("Gradient reference '%s' not found", str);
        } else if (!(p10 instanceof SVG.j)) {
            F("Gradient href attributes must point to other gradient elements", new Object[0]);
        } else if (p10 == jVar) {
            F("Circular reference in gradient href attribute '%s'", str);
        } else {
            SVG.j jVar2 = (SVG.j) p10;
            if (jVar.f9803i == null) {
                jVar.f9803i = jVar2.f9803i;
            }
            if (jVar.f9804j == null) {
                jVar.f9804j = jVar2.f9804j;
            }
            if (jVar.f9805k == null) {
                jVar.f9805k = jVar2.f9805k;
            }
            if (jVar.f9802h.isEmpty()) {
                jVar.f9802h = jVar2.f9802h;
            }
            try {
                if (jVar instanceof SVG.k0) {
                    I((SVG.k0) jVar, (SVG.k0) p10);
                } else {
                    J((SVG.o0) jVar, (SVG.o0) p10);
                }
            } catch (ClassCastException unused) {
            }
            String str2 = jVar2.f9806l;
            if (str2 != null) {
                H(jVar, str2);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00e2, code lost:
        r0 = 0.0f - r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00e4, code lost:
        r7 = r8[r7.a().ordinal()];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00ef, code lost:
        if (r7 == 2) goto L_0x0105;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00f2, code lost:
        if (r7 == 3) goto L_0x0102;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00f5, code lost:
        if (r7 == 5) goto L_0x0105;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00f8, code lost:
        if (r7 == 6) goto L_0x0102;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00fb, code lost:
        if (r7 == 7) goto L_0x0105;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00ff, code lost:
        if (r7 == 8) goto L_0x0102;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0102, code lost:
        r13 = r4 - r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0105, code lost:
        r13 = (r4 - r13) / 2.0f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0108, code lost:
        r1 = 0.0f - r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0113, code lost:
        if (r11.f9982d.f10018a.C.booleanValue() != false) goto L_0x0118;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0115, code lost:
        O0(r0, r1, r2, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0118, code lost:
        r3.reset();
        r3.preScale(r6, r5);
        r11.f9979a.concat(r3);
     */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0124  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0147  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void H0(com.caverock.androidsvg.SVG.q r12, com.caverock.androidsvg.d.c r13) {
        /*
            r11 = this;
            r11.S0()
            java.lang.Float r0 = r12.f9844v
            r1 = 0
            if (r0 == 0) goto L_0x0033
            float r0 = r0.floatValue()
            boolean r0 = java.lang.Float.isNaN(r0)
            if (r0 == 0) goto L_0x002c
            float r0 = r13.f10001c
            int r2 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r2 != 0) goto L_0x001e
            float r2 = r13.f10002d
            int r2 = (r2 > r1 ? 1 : (r2 == r1 ? 0 : -1))
            if (r2 == 0) goto L_0x0033
        L_0x001e:
            float r2 = r13.f10002d
            double r2 = (double) r2
            double r4 = (double) r0
            double r2 = java.lang.Math.atan2(r2, r4)
            double r2 = java.lang.Math.toDegrees(r2)
            float r0 = (float) r2
            goto L_0x0034
        L_0x002c:
            java.lang.Float r0 = r12.f9844v
            float r0 = r0.floatValue()
            goto L_0x0034
        L_0x0033:
            r0 = r1
        L_0x0034:
            boolean r2 = r12.f9839q
            if (r2 == 0) goto L_0x003b
            r2 = 1065353216(0x3f800000, float:1.0)
            goto L_0x0047
        L_0x003b:
            com.caverock.androidsvg.d$h r2 = r11.f9982d
            com.caverock.androidsvg.SVG$Style r2 = r2.f10018a
            com.caverock.androidsvg.SVG$o r2 = r2.f9691g
            float r3 = r11.f9980b
            float r2 = r2.b(r3)
        L_0x0047:
            com.caverock.androidsvg.d$h r3 = r11.M(r12)
            r11.f9982d = r3
            android.graphics.Matrix r3 = new android.graphics.Matrix
            r3.<init>()
            float r4 = r13.f9999a
            float r13 = r13.f10000b
            r3.preTranslate(r4, r13)
            r3.preRotate(r0)
            r3.preScale(r2, r2)
            com.caverock.androidsvg.SVG$o r13 = r12.f9840r
            if (r13 == 0) goto L_0x0068
            float r13 = r13.e(r11)
            goto L_0x0069
        L_0x0068:
            r13 = r1
        L_0x0069:
            com.caverock.androidsvg.SVG$o r0 = r12.f9841s
            if (r0 == 0) goto L_0x0072
            float r0 = r0.h(r11)
            goto L_0x0073
        L_0x0072:
            r0 = r1
        L_0x0073:
            com.caverock.androidsvg.SVG$o r2 = r12.f9842t
            r4 = 1077936128(0x40400000, float:3.0)
            if (r2 == 0) goto L_0x007e
            float r2 = r2.e(r11)
            goto L_0x007f
        L_0x007e:
            r2 = r4
        L_0x007f:
            com.caverock.androidsvg.SVG$o r5 = r12.f9843u
            if (r5 == 0) goto L_0x0087
            float r4 = r5.h(r11)
        L_0x0087:
            com.caverock.androidsvg.SVG$b r5 = r12.f9838p
            if (r5 == 0) goto L_0x0124
            float r6 = r5.f9761c
            float r6 = r2 / r6
            float r5 = r5.f9762d
            float r5 = r4 / r5
            com.caverock.androidsvg.PreserveAspectRatio r7 = r12.f9826o
            if (r7 == 0) goto L_0x0098
            goto L_0x009a
        L_0x0098:
            com.caverock.androidsvg.PreserveAspectRatio r7 = com.caverock.androidsvg.PreserveAspectRatio.f9651e
        L_0x009a:
            com.caverock.androidsvg.PreserveAspectRatio r8 = com.caverock.androidsvg.PreserveAspectRatio.f9650d
            boolean r8 = r7.equals(r8)
            if (r8 != 0) goto L_0x00b5
            com.caverock.androidsvg.PreserveAspectRatio$Scale r8 = r7.b()
            com.caverock.androidsvg.PreserveAspectRatio$Scale r9 = com.caverock.androidsvg.PreserveAspectRatio.Scale.slice
            if (r8 != r9) goto L_0x00af
            float r5 = java.lang.Math.max(r6, r5)
            goto L_0x00b3
        L_0x00af:
            float r5 = java.lang.Math.min(r6, r5)
        L_0x00b3:
            r6 = r5
            r5 = r6
        L_0x00b5:
            float r13 = -r13
            float r13 = r13 * r6
            float r0 = -r0
            float r0 = r0 * r5
            r3.preTranslate(r13, r0)
            android.graphics.Canvas r13 = r11.f9979a
            r13.concat(r3)
            com.caverock.androidsvg.SVG$b r13 = r12.f9838p
            float r0 = r13.f9761c
            float r0 = r0 * r6
            float r13 = r13.f9762d
            float r13 = r13 * r5
            int[] r8 = com.caverock.androidsvg.d.a.f9987a
            com.caverock.androidsvg.PreserveAspectRatio$Alignment r9 = r7.a()
            int r9 = r9.ordinal()
            r9 = r8[r9]
            r10 = 1073741824(0x40000000, float:2.0)
            switch(r9) {
                case 1: goto L_0x00df;
                case 2: goto L_0x00df;
                case 3: goto L_0x00df;
                case 4: goto L_0x00dc;
                case 5: goto L_0x00dc;
                case 6: goto L_0x00dc;
                default: goto L_0x00da;
            }
        L_0x00da:
            r0 = r1
            goto L_0x00e4
        L_0x00dc:
            float r0 = r2 - r0
            goto L_0x00e2
        L_0x00df:
            float r0 = r2 - r0
            float r0 = r0 / r10
        L_0x00e2:
            float r0 = r1 - r0
        L_0x00e4:
            com.caverock.androidsvg.PreserveAspectRatio$Alignment r7 = r7.a()
            int r7 = r7.ordinal()
            r7 = r8[r7]
            r8 = 2
            if (r7 == r8) goto L_0x0105
            r8 = 3
            if (r7 == r8) goto L_0x0102
            r8 = 5
            if (r7 == r8) goto L_0x0105
            r8 = 6
            if (r7 == r8) goto L_0x0102
            r8 = 7
            if (r7 == r8) goto L_0x0105
            r8 = 8
            if (r7 == r8) goto L_0x0102
            goto L_0x0109
        L_0x0102:
            float r13 = r4 - r13
            goto L_0x0108
        L_0x0105:
            float r13 = r4 - r13
            float r13 = r13 / r10
        L_0x0108:
            float r1 = r1 - r13
        L_0x0109:
            com.caverock.androidsvg.d$h r13 = r11.f9982d
            com.caverock.androidsvg.SVG$Style r13 = r13.f10018a
            java.lang.Boolean r13 = r13.C
            boolean r13 = r13.booleanValue()
            if (r13 != 0) goto L_0x0118
            r11.O0(r0, r1, r2, r4)
        L_0x0118:
            r3.reset()
            r3.preScale(r6, r5)
            android.graphics.Canvas r13 = r11.f9979a
            r13.concat(r3)
            goto L_0x013d
        L_0x0124:
            float r13 = -r13
            float r0 = -r0
            r3.preTranslate(r13, r0)
            android.graphics.Canvas r13 = r11.f9979a
            r13.concat(r3)
            com.caverock.androidsvg.d$h r13 = r11.f9982d
            com.caverock.androidsvg.SVG$Style r13 = r13.f10018a
            java.lang.Boolean r13 = r13.C
            boolean r13 = r13.booleanValue()
            if (r13 != 0) goto L_0x013d
            r11.O0(r1, r1, r2, r4)
        L_0x013d:
            boolean r13 = r11.m0()
            r0 = 0
            r11.F0(r12, r0)
            if (r13 == 0) goto L_0x014a
            r11.j0(r12)
        L_0x014a:
            r11.R0()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.caverock.androidsvg.d.H0(com.caverock.androidsvg.SVG$q, com.caverock.androidsvg.d$c):void");
    }

    private void I(SVG.k0 k0Var, SVG.k0 k0Var2) {
        if (k0Var.f9813m == null) {
            k0Var.f9813m = k0Var2.f9813m;
        }
        if (k0Var.f9814n == null) {
            k0Var.f9814n = k0Var2.f9814n;
        }
        if (k0Var.f9815o == null) {
            k0Var.f9815o = k0Var2.f9815o;
        }
        if (k0Var.f9816p == null) {
            k0Var.f9816p = k0Var2.f9816p;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x009f A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00a0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void I0(com.caverock.androidsvg.SVG.k r10) {
        /*
            r9 = this;
            com.caverock.androidsvg.d$h r0 = r9.f9982d
            com.caverock.androidsvg.SVG$Style r0 = r0.f10018a
            java.lang.String r1 = r0.E
            if (r1 != 0) goto L_0x0011
            java.lang.String r2 = r0.F
            if (r2 != 0) goto L_0x0011
            java.lang.String r0 = r0.G
            if (r0 != 0) goto L_0x0011
            return
        L_0x0011:
            java.lang.String r0 = "Marker reference '%s' not found"
            r2 = 0
            r3 = 0
            r4 = 1
            if (r1 == 0) goto L_0x0030
            com.caverock.androidsvg.SVG r5 = r10.f9818a
            com.caverock.androidsvg.SVG$l0 r1 = r5.p(r1)
            if (r1 == 0) goto L_0x0023
            com.caverock.androidsvg.SVG$q r1 = (com.caverock.androidsvg.SVG.q) r1
            goto L_0x0031
        L_0x0023:
            java.lang.Object[] r1 = new java.lang.Object[r4]
            com.caverock.androidsvg.d$h r5 = r9.f9982d
            com.caverock.androidsvg.SVG$Style r5 = r5.f10018a
            java.lang.String r5 = r5.E
            r1[r3] = r5
            F(r0, r1)
        L_0x0030:
            r1 = r2
        L_0x0031:
            com.caverock.androidsvg.d$h r5 = r9.f9982d
            com.caverock.androidsvg.SVG$Style r5 = r5.f10018a
            java.lang.String r5 = r5.F
            if (r5 == 0) goto L_0x0051
            com.caverock.androidsvg.SVG r6 = r10.f9818a
            com.caverock.androidsvg.SVG$l0 r5 = r6.p(r5)
            if (r5 == 0) goto L_0x0044
            com.caverock.androidsvg.SVG$q r5 = (com.caverock.androidsvg.SVG.q) r5
            goto L_0x0052
        L_0x0044:
            java.lang.Object[] r5 = new java.lang.Object[r4]
            com.caverock.androidsvg.d$h r6 = r9.f9982d
            com.caverock.androidsvg.SVG$Style r6 = r6.f10018a
            java.lang.String r6 = r6.F
            r5[r3] = r6
            F(r0, r5)
        L_0x0051:
            r5 = r2
        L_0x0052:
            com.caverock.androidsvg.d$h r6 = r9.f9982d
            com.caverock.androidsvg.SVG$Style r6 = r6.f10018a
            java.lang.String r6 = r6.G
            if (r6 == 0) goto L_0x0072
            com.caverock.androidsvg.SVG r7 = r10.f9818a
            com.caverock.androidsvg.SVG$l0 r6 = r7.p(r6)
            if (r6 == 0) goto L_0x0065
            com.caverock.androidsvg.SVG$q r6 = (com.caverock.androidsvg.SVG.q) r6
            goto L_0x0073
        L_0x0065:
            java.lang.Object[] r6 = new java.lang.Object[r4]
            com.caverock.androidsvg.d$h r7 = r9.f9982d
            com.caverock.androidsvg.SVG$Style r7 = r7.f10018a
            java.lang.String r7 = r7.G
            r6[r3] = r7
            F(r0, r6)
        L_0x0072:
            r6 = r2
        L_0x0073:
            boolean r0 = r10 instanceof com.caverock.androidsvg.SVG.u
            if (r0 == 0) goto L_0x0085
            com.caverock.androidsvg.d$b r0 = new com.caverock.androidsvg.d$b
            com.caverock.androidsvg.SVG$u r10 = (com.caverock.androidsvg.SVG.u) r10
            com.caverock.androidsvg.SVG$v r10 = r10.f9856o
            r0.<init>(r10)
            java.util.List r10 = r0.f()
            goto L_0x0096
        L_0x0085:
            boolean r0 = r10 instanceof com.caverock.androidsvg.SVG.p
            if (r0 == 0) goto L_0x0090
            com.caverock.androidsvg.SVG$p r10 = (com.caverock.androidsvg.SVG.p) r10
            java.util.List r10 = r9.k(r10)
            goto L_0x0096
        L_0x0090:
            com.caverock.androidsvg.SVG$y r10 = (com.caverock.androidsvg.SVG.y) r10
            java.util.List r10 = r9.l(r10)
        L_0x0096:
            if (r10 != 0) goto L_0x0099
            return
        L_0x0099:
            int r0 = r10.size()
            if (r0 != 0) goto L_0x00a0
            return
        L_0x00a0:
            com.caverock.androidsvg.d$h r7 = r9.f9982d
            com.caverock.androidsvg.SVG$Style r7 = r7.f10018a
            r7.G = r2
            r7.F = r2
            r7.E = r2
            if (r1 == 0) goto L_0x00b5
            java.lang.Object r2 = r10.get(r3)
            com.caverock.androidsvg.d$c r2 = (com.caverock.androidsvg.d.c) r2
            r9.H0(r1, r2)
        L_0x00b5:
            if (r5 == 0) goto L_0x00e6
            int r1 = r10.size()
            r2 = 2
            if (r1 <= r2) goto L_0x00e6
            java.lang.Object r1 = r10.get(r3)
            com.caverock.androidsvg.d$c r1 = (com.caverock.androidsvg.d.c) r1
            java.lang.Object r2 = r10.get(r4)
            com.caverock.androidsvg.d$c r2 = (com.caverock.androidsvg.d.c) r2
            r3 = r4
        L_0x00cb:
            int r7 = r0 + -1
            if (r3 >= r7) goto L_0x00e6
            int r3 = r3 + 1
            java.lang.Object r7 = r10.get(r3)
            com.caverock.androidsvg.d$c r7 = (com.caverock.androidsvg.d.c) r7
            boolean r8 = r2.f10003e
            if (r8 == 0) goto L_0x00e0
            com.caverock.androidsvg.d$c r1 = r9.n0(r1, r2, r7)
            goto L_0x00e1
        L_0x00e0:
            r1 = r2
        L_0x00e1:
            r9.H0(r5, r1)
            r2 = r7
            goto L_0x00cb
        L_0x00e6:
            if (r6 == 0) goto L_0x00f2
            int r0 = r0 - r4
            java.lang.Object r10 = r10.get(r0)
            com.caverock.androidsvg.d$c r10 = (com.caverock.androidsvg.d.c) r10
            r9.H0(r6, r10)
        L_0x00f2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.caverock.androidsvg.d.I0(com.caverock.androidsvg.SVG$k):void");
    }

    private void J(SVG.o0 o0Var, SVG.o0 o0Var2) {
        if (o0Var.f9829m == null) {
            o0Var.f9829m = o0Var2.f9829m;
        }
        if (o0Var.f9830n == null) {
            o0Var.f9830n = o0Var2.f9830n;
        }
        if (o0Var.f9831o == null) {
            o0Var.f9831o = o0Var2.f9831o;
        }
        if (o0Var.f9832p == null) {
            o0Var.f9832p = o0Var2.f9832p;
        }
        if (o0Var.f9833q == null) {
            o0Var.f9833q = o0Var2.f9833q;
        }
    }

    private void J0(SVG.r rVar, SVG.i0 i0Var, SVG.b bVar) {
        boolean z10;
        float f10;
        float f11;
        float f12;
        y("Mask render", new Object[0]);
        Boolean bool = rVar.f9845o;
        boolean z11 = true;
        if (bool == null || !bool.booleanValue()) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (z10) {
            SVG.o oVar = rVar.f9849s;
            if (oVar != null) {
                f11 = oVar.e(this);
            } else {
                f11 = bVar.f9761c;
            }
            SVG.o oVar2 = rVar.f9850t;
            if (oVar2 != null) {
                f10 = oVar2.h(this);
            } else {
                f10 = bVar.f9762d;
            }
        } else {
            SVG.o oVar3 = rVar.f9849s;
            float f13 = 1.2f;
            if (oVar3 != null) {
                f12 = oVar3.d(this, 1.0f);
            } else {
                f12 = 1.2f;
            }
            SVG.o oVar4 = rVar.f9850t;
            if (oVar4 != null) {
                f13 = oVar4.d(this, 1.0f);
            }
            f11 = f12 * bVar.f9761c;
            f10 = f13 * bVar.f9762d;
        }
        if (f11 != 0.0f && f10 != 0.0f) {
            S0();
            h M = M(rVar);
            this.f9982d = M;
            M.f10018a.f9697n = Float.valueOf(1.0f);
            boolean m02 = m0();
            this.f9979a.save();
            Boolean bool2 = rVar.f9846p;
            if (bool2 != null && !bool2.booleanValue()) {
                z11 = false;
            }
            if (!z11) {
                this.f9979a.translate(bVar.f9759a, bVar.f9760b);
                this.f9979a.scale(bVar.f9761c, bVar.f9762d);
            }
            F0(rVar, false);
            this.f9979a.restore();
            if (m02) {
                k0(i0Var, bVar);
            }
            R0();
        }
    }

    private void K(SVG.x xVar, String str) {
        SVG.l0 p10 = xVar.f9818a.p(str);
        if (p10 == null) {
            Z0("Pattern reference '%s' not found", str);
        } else if (!(p10 instanceof SVG.x)) {
            F("Pattern href attributes must point to other pattern elements", new Object[0]);
        } else if (p10 == xVar) {
            F("Circular reference in pattern href attribute '%s'", str);
        } else {
            SVG.x xVar2 = (SVG.x) p10;
            if (xVar.f9863q == null) {
                xVar.f9863q = xVar2.f9863q;
            }
            if (xVar.f9864r == null) {
                xVar.f9864r = xVar2.f9864r;
            }
            if (xVar.f9865s == null) {
                xVar.f9865s = xVar2.f9865s;
            }
            if (xVar.f9866t == null) {
                xVar.f9866t = xVar2.f9866t;
            }
            if (xVar.f9867u == null) {
                xVar.f9867u = xVar2.f9867u;
            }
            if (xVar.f9868v == null) {
                xVar.f9868v = xVar2.f9868v;
            }
            if (xVar.f9869w == null) {
                xVar.f9869w = xVar2.f9869w;
            }
            if (xVar.f9785i.isEmpty()) {
                xVar.f9785i = xVar2.f9785i;
            }
            if (xVar.f9838p == null) {
                xVar.f9838p = xVar2.f9838p;
            }
            if (xVar.f9826o == null) {
                xVar.f9826o = xVar2.f9826o;
            }
            String str2 = xVar2.f9870x;
            if (str2 != null) {
                K(xVar, str2);
            }
        }
    }

    private void K0(SVG.q0 q0Var) {
        Set<String> a10;
        String language = Locale.getDefault().getLanguage();
        SVG.k();
        for (SVG.l0 next : q0Var.getChildren()) {
            if (next instanceof SVG.e0) {
                SVG.e0 e0Var = (SVG.e0) next;
                if (e0Var.b() == null && ((a10 = e0Var.a()) == null || (!a10.isEmpty() && a10.contains(language)))) {
                    Set<String> f10 = e0Var.f();
                    if (f10 != null) {
                        if (f9978i == null) {
                            V();
                        }
                        if (f10.isEmpty()) {
                            continue;
                        } else if (!f9978i.containsAll(f10)) {
                            continue;
                        }
                    }
                    Set<String> l10 = e0Var.l();
                    if (l10 != null) {
                        boolean isEmpty = l10.isEmpty();
                    } else {
                        Set<String> m10 = e0Var.m();
                        if (m10 != null) {
                            boolean isEmpty2 = m10.isEmpty();
                        } else {
                            A0(next);
                            return;
                        }
                    }
                }
            }
        }
    }

    private void L(SVG.i0 i0Var, Path path, SVG.x xVar) {
        boolean z10;
        float f10;
        float f11;
        float f12;
        float f13;
        float f14;
        boolean z11;
        float f15;
        float f16;
        float f17;
        float f18;
        SVG.i0 i0Var2 = i0Var;
        SVG.x xVar2 = xVar;
        Boolean bool = xVar2.f9863q;
        if (bool == null || !bool.booleanValue()) {
            z10 = false;
        } else {
            z10 = true;
        }
        String str = xVar2.f9870x;
        if (str != null) {
            K(xVar2, str);
        }
        if (z10) {
            SVG.o oVar = xVar2.f9866t;
            if (oVar != null) {
                f13 = oVar.e(this);
            } else {
                f13 = 0.0f;
            }
            SVG.o oVar2 = xVar2.f9867u;
            if (oVar2 != null) {
                f12 = oVar2.h(this);
            } else {
                f12 = 0.0f;
            }
            SVG.o oVar3 = xVar2.f9868v;
            if (oVar3 != null) {
                f11 = oVar3.e(this);
            } else {
                f11 = 0.0f;
            }
            SVG.o oVar4 = xVar2.f9869w;
            if (oVar4 != null) {
                f10 = oVar4.h(this);
            } else {
                f10 = 0.0f;
            }
        } else {
            SVG.o oVar5 = xVar2.f9866t;
            if (oVar5 != null) {
                f15 = oVar5.d(this, 1.0f);
            } else {
                f15 = 0.0f;
            }
            SVG.o oVar6 = xVar2.f9867u;
            if (oVar6 != null) {
                f16 = oVar6.d(this, 1.0f);
            } else {
                f16 = 0.0f;
            }
            SVG.o oVar7 = xVar2.f9868v;
            if (oVar7 != null) {
                f17 = oVar7.d(this, 1.0f);
            } else {
                f17 = 0.0f;
            }
            SVG.o oVar8 = xVar2.f9869w;
            if (oVar8 != null) {
                f18 = oVar8.d(this, 1.0f);
            } else {
                f18 = 0.0f;
            }
            SVG.b bVar = i0Var2.f9801h;
            float f19 = bVar.f9759a;
            float f20 = bVar.f9761c;
            f13 = (f15 * f20) + f19;
            float f21 = bVar.f9760b;
            float f22 = bVar.f9762d;
            float f23 = f17 * f20;
            f10 = f18 * f22;
            f12 = (f16 * f22) + f21;
            f11 = f23;
        }
        if (f11 != 0.0f && f10 != 0.0f) {
            PreserveAspectRatio preserveAspectRatio = xVar2.f9826o;
            if (preserveAspectRatio == null) {
                preserveAspectRatio = PreserveAspectRatio.f9651e;
            }
            S0();
            this.f9979a.clipPath(path);
            h hVar = new h();
            V0(hVar, SVG.Style.a());
            hVar.f10018a.C = Boolean.FALSE;
            this.f9982d = N(xVar2, hVar);
            SVG.b bVar2 = i0Var2.f9801h;
            Matrix matrix = xVar2.f9865s;
            if (matrix != null) {
                this.f9979a.concat(matrix);
                Matrix matrix2 = new Matrix();
                if (xVar2.f9865s.invert(matrix2)) {
                    SVG.b bVar3 = i0Var2.f9801h;
                    SVG.b bVar4 = i0Var2.f9801h;
                    SVG.b bVar5 = i0Var2.f9801h;
                    float[] fArr = {bVar3.f9759a, bVar3.f9760b, bVar3.b(), bVar4.f9760b, bVar4.b(), i0Var2.f9801h.c(), bVar5.f9759a, bVar5.c()};
                    matrix2.mapPoints(fArr);
                    float f24 = fArr[0];
                    float f25 = fArr[1];
                    RectF rectF = new RectF(f24, f25, f24, f25);
                    for (int i10 = 2; i10 <= 6; i10 += 2) {
                        float f26 = fArr[i10];
                        if (f26 < rectF.left) {
                            rectF.left = f26;
                        }
                        if (f26 > rectF.right) {
                            rectF.right = f26;
                        }
                        float f27 = fArr[i10 + 1];
                        if (f27 < rectF.top) {
                            rectF.top = f27;
                        }
                        if (f27 > rectF.bottom) {
                            rectF.bottom = f27;
                        }
                    }
                    float f28 = rectF.left;
                    float f29 = rectF.top;
                    bVar2 = new SVG.b(f28, f29, rectF.right - f28, rectF.bottom - f29);
                }
            }
            float floor = f13 + (((float) Math.floor((double) ((bVar2.f9759a - f13) / f11))) * f11);
            float b10 = bVar2.b();
            float c10 = bVar2.c();
            SVG.b bVar6 = new SVG.b(0.0f, 0.0f, f11, f10);
            boolean m02 = m0();
            for (float floor2 = f12 + (((float) Math.floor((double) ((bVar2.f9760b - f12) / f10))) * f10); floor2 < c10; floor2 += f10) {
                float f30 = floor;
                while (f30 < b10) {
                    bVar6.f9759a = f30;
                    bVar6.f9760b = floor2;
                    S0();
                    if (!this.f9982d.f10018a.C.booleanValue()) {
                        f14 = floor;
                        O0(bVar6.f9759a, bVar6.f9760b, bVar6.f9761c, bVar6.f9762d);
                    } else {
                        f14 = floor;
                    }
                    SVG.b bVar7 = xVar2.f9838p;
                    if (bVar7 != null) {
                        this.f9979a.concat(o(bVar6, bVar7, preserveAspectRatio));
                    } else {
                        Boolean bool2 = xVar2.f9864r;
                        if (bool2 == null || bool2.booleanValue()) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        this.f9979a.translate(f30, floor2);
                        if (!z11) {
                            Canvas canvas = this.f9979a;
                            SVG.b bVar8 = i0Var2.f9801h;
                            canvas.scale(bVar8.f9761c, bVar8.f9762d);
                        }
                    }
                    for (SVG.l0 A0 : xVar2.f9785i) {
                        A0(A0);
                    }
                    R0();
                    f30 += f11;
                    floor = f14;
                }
                float f31 = floor;
            }
            if (m02) {
                j0(xVar2);
            }
            R0();
        }
    }

    private void L0(SVG.x0 x0Var) {
        float f10;
        y("TextPath render", new Object[0]);
        W0(this.f9982d, x0Var);
        if (A() && Y0()) {
            SVG.l0 p10 = x0Var.f9818a.p(x0Var.f9871o);
            if (p10 == null) {
                F("TextPath reference '%s' not found", x0Var.f9871o);
                return;
            }
            SVG.u uVar = (SVG.u) p10;
            Path f11 = new C0114d(uVar.f9856o).f();
            Matrix matrix = uVar.f9812n;
            if (matrix != null) {
                f11.transform(matrix);
            }
            PathMeasure pathMeasure = new PathMeasure(f11, false);
            SVG.o oVar = x0Var.f9872p;
            if (oVar != null) {
                f10 = oVar.d(this, pathMeasure.getLength());
            } else {
                f10 = 0.0f;
            }
            SVG.Style.TextAnchor O = O();
            if (O != SVG.Style.TextAnchor.Start) {
                float n10 = n(x0Var);
                if (O == SVG.Style.TextAnchor.Middle) {
                    n10 /= 2.0f;
                }
                f10 -= n10;
            }
            r((SVG.i0) x0Var.d());
            boolean m02 = m0();
            E(x0Var, new e(f11, f10, 0.0f));
            if (m02) {
                j0(x0Var);
            }
        }
    }

    private h M(SVG.l0 l0Var) {
        h hVar = new h();
        V0(hVar, SVG.Style.a());
        return N(l0Var, hVar);
    }

    private boolean M0() {
        return this.f9982d.f10018a.f9697n.floatValue() < 1.0f || this.f9982d.f10018a.N != null;
    }

    private h N(SVG.l0 l0Var, h hVar) {
        ArrayList<SVG.j0> arrayList = new ArrayList<>();
        while (true) {
            if (l0Var instanceof SVG.j0) {
                arrayList.add(0, (SVG.j0) l0Var);
            }
            SVG.h0 h0Var = l0Var.f9819b;
            if (h0Var == null) {
                break;
            }
            l0Var = (SVG.l0) h0Var;
        }
        for (SVG.j0 W0 : arrayList) {
            W0(hVar, W0);
        }
        h hVar2 = this.f9982d;
        hVar.f10024g = hVar2.f10024g;
        hVar.f10023f = hVar2.f10023f;
        return hVar;
    }

    private void N0() {
        this.f9982d = new h();
        this.f9983e = new Stack<>();
        V0(this.f9982d, SVG.Style.a());
        h hVar = this.f9982d;
        hVar.f10023f = null;
        hVar.f10025h = false;
        this.f9983e.push(new h(hVar));
        this.f9985g = new Stack<>();
        this.f9984f = new Stack<>();
    }

    private SVG.Style.TextAnchor O() {
        SVG.Style.TextAnchor textAnchor;
        SVG.Style style = this.f9982d.f10018a;
        if (style.f9704z == SVG.Style.TextDirection.LTR || (textAnchor = style.B) == SVG.Style.TextAnchor.Middle) {
            return style.B;
        }
        SVG.Style.TextAnchor textAnchor2 = SVG.Style.TextAnchor.Start;
        if (textAnchor == textAnchor2) {
            return SVG.Style.TextAnchor.End;
        }
        return textAnchor2;
    }

    private void O0(float f10, float f11, float f12, float f13) {
        float f14 = f12 + f10;
        float f15 = f13 + f11;
        SVG.c cVar = this.f9982d.f10018a.D;
        if (cVar != null) {
            f10 += cVar.f9771d.e(this);
            f11 += this.f9982d.f10018a.D.f9768a.h(this);
            f14 -= this.f9982d.f10018a.D.f9769b.e(this);
            f15 -= this.f9982d.f10018a.D.f9770c.h(this);
        }
        this.f9979a.clipRect(f10, f11, f14, f15);
    }

    private Path.FillType P() {
        SVG.Style.FillRule fillRule = this.f9982d.f10018a.M;
        if (fillRule == null || fillRule != SVG.Style.FillRule.EvenOdd) {
            return Path.FillType.WINDING;
        }
        return Path.FillType.EVEN_ODD;
    }

    private void P0(h hVar, boolean z10, SVG.m0 m0Var) {
        Float f10;
        int i10;
        SVG.Style style = hVar.f10018a;
        if (z10) {
            f10 = style.f9688d;
        } else {
            f10 = style.f9690f;
        }
        float floatValue = f10.floatValue();
        if (m0Var instanceof SVG.f) {
            i10 = ((SVG.f) m0Var).f9784a;
        } else if (m0Var instanceof SVG.g) {
            i10 = hVar.f10018a.f9698p.f9784a;
        } else {
            return;
        }
        int x10 = x(i10, floatValue);
        if (z10) {
            hVar.f10021d.setColor(x10);
        } else {
            hVar.f10022e.setColor(x10);
        }
    }

    private void Q0(boolean z10, SVG.b0 b0Var) {
        boolean z11 = true;
        if (z10) {
            if (W(b0Var.f9809e, 2147483648L)) {
                h hVar = this.f9982d;
                SVG.Style style = hVar.f10018a;
                SVG.m0 m0Var = b0Var.f9809e.O;
                style.f9686b = m0Var;
                if (m0Var == null) {
                    z11 = false;
                }
                hVar.f10019b = z11;
            }
            if (W(b0Var.f9809e, 4294967296L)) {
                this.f9982d.f10018a.f9688d = b0Var.f9809e.P;
            }
            if (W(b0Var.f9809e, 6442450944L)) {
                h hVar2 = this.f9982d;
                P0(hVar2, z10, hVar2.f10018a.f9686b);
                return;
            }
            return;
        }
        if (W(b0Var.f9809e, 2147483648L)) {
            h hVar3 = this.f9982d;
            SVG.Style style2 = hVar3.f10018a;
            SVG.m0 m0Var2 = b0Var.f9809e.O;
            style2.f9689e = m0Var2;
            if (m0Var2 == null) {
                z11 = false;
            }
            hVar3.f10020c = z11;
        }
        if (W(b0Var.f9809e, 4294967296L)) {
            this.f9982d.f10018a.f9690f = b0Var.f9809e.P;
        }
        if (W(b0Var.f9809e, 6442450944L)) {
            h hVar4 = this.f9982d;
            P0(hVar4, z10, hVar4.f10018a.f9689e);
        }
    }

    private void R0() {
        this.f9979a.restore();
        this.f9982d = this.f9983e.pop();
    }

    private void S0() {
        this.f9979a.save();
        this.f9983e.push(this.f9982d);
        this.f9982d = new h(this.f9982d);
    }

    private String T0(String str, boolean z10, boolean z11) {
        if (this.f9982d.f10025h) {
            return str.replaceAll("[\\n\\t]", " ");
        }
        String replaceAll = str.replaceAll("\\n", "").replaceAll("\\t", " ");
        if (z10) {
            replaceAll = replaceAll.replaceAll("^\\s+", "");
        }
        if (z11) {
            replaceAll = replaceAll.replaceAll("\\s+$", "");
        }
        return replaceAll.replaceAll("\\s{2,}", " ");
    }

    private Path.FillType U() {
        SVG.Style.FillRule fillRule = this.f9982d.f10018a.f9687c;
        if (fillRule == null || fillRule != SVG.Style.FillRule.EvenOdd) {
            return Path.FillType.WINDING;
        }
        return Path.FillType.EVEN_ODD;
    }

    private void U0(SVG.i0 i0Var) {
        if (i0Var.f9819b != null && i0Var.f9801h != null) {
            Matrix matrix = new Matrix();
            if (this.f9985g.peek().invert(matrix)) {
                SVG.b bVar = i0Var.f9801h;
                SVG.b bVar2 = i0Var.f9801h;
                SVG.b bVar3 = i0Var.f9801h;
                float[] fArr = {bVar.f9759a, bVar.f9760b, bVar.b(), bVar2.f9760b, bVar2.b(), i0Var.f9801h.c(), bVar3.f9759a, bVar3.c()};
                matrix.preConcat(this.f9979a.getMatrix());
                matrix.mapPoints(fArr);
                float f10 = fArr[0];
                float f11 = fArr[1];
                RectF rectF = new RectF(f10, f11, f10, f11);
                for (int i10 = 2; i10 <= 6; i10 += 2) {
                    float f12 = fArr[i10];
                    if (f12 < rectF.left) {
                        rectF.left = f12;
                    }
                    if (f12 > rectF.right) {
                        rectF.right = f12;
                    }
                    float f13 = fArr[i10 + 1];
                    if (f13 < rectF.top) {
                        rectF.top = f13;
                    }
                    if (f13 > rectF.bottom) {
                        rectF.bottom = f13;
                    }
                }
                SVG.i0 i0Var2 = (SVG.i0) this.f9984f.peek();
                SVG.b bVar4 = i0Var2.f9801h;
                if (bVar4 == null) {
                    i0Var2.f9801h = SVG.b.a(rectF.left, rectF.top, rectF.right, rectF.bottom);
                } else {
                    bVar4.e(SVG.b.a(rectF.left, rectF.top, rectF.right, rectF.bottom));
                }
            }
        }
    }

    private static synchronized void V() {
        synchronized (d.class) {
            HashSet<String> hashSet = new HashSet<>();
            f9978i = hashSet;
            hashSet.add("Structure");
            f9978i.add("BasicStructure");
            f9978i.add("ConditionalProcessing");
            f9978i.add(Constants.Keys.INBOX_IMAGE);
            f9978i.add("Style");
            f9978i.add("ViewportAttribute");
            f9978i.add("Shape");
            f9978i.add("BasicText");
            f9978i.add("PaintAttribute");
            f9978i.add("BasicPaintAttribute");
            f9978i.add("OpacityAttribute");
            f9978i.add("BasicGraphicsAttribute");
            f9978i.add("Marker");
            f9978i.add("Gradient");
            f9978i.add("Pattern");
            f9978i.add("Clip");
            f9978i.add("BasicClip");
            f9978i.add("Mask");
            f9978i.add("View");
        }
    }

    private void V0(h hVar, SVG.Style style) {
        boolean z10;
        boolean z11;
        boolean z12;
        int i10;
        boolean z13;
        boolean z14;
        if (W(style, 4096)) {
            hVar.f10018a.f9698p = style.f9698p;
        }
        if (W(style, 2048)) {
            hVar.f10018a.f9697n = style.f9697n;
        }
        boolean z15 = false;
        if (W(style, 1)) {
            hVar.f10018a.f9686b = style.f9686b;
            SVG.m0 m0Var = style.f9686b;
            if (m0Var == null || m0Var == SVG.f.f9783c) {
                z14 = false;
            } else {
                z14 = true;
            }
            hVar.f10019b = z14;
        }
        if (W(style, 4)) {
            hVar.f10018a.f9688d = style.f9688d;
        }
        if (W(style, 6149)) {
            P0(hVar, true, hVar.f10018a.f9686b);
        }
        if (W(style, 2)) {
            hVar.f10018a.f9687c = style.f9687c;
        }
        if (W(style, 8)) {
            hVar.f10018a.f9689e = style.f9689e;
            SVG.m0 m0Var2 = style.f9689e;
            if (m0Var2 == null || m0Var2 == SVG.f.f9783c) {
                z13 = false;
            } else {
                z13 = true;
            }
            hVar.f10020c = z13;
        }
        if (W(style, 16)) {
            hVar.f10018a.f9690f = style.f9690f;
        }
        if (W(style, 6168)) {
            P0(hVar, false, hVar.f10018a.f9689e);
        }
        if (W(style, 34359738368L)) {
            hVar.f10018a.S = style.S;
        }
        if (W(style, 32)) {
            SVG.Style style2 = hVar.f10018a;
            SVG.o oVar = style.f9691g;
            style2.f9691g = oVar;
            hVar.f10022e.setStrokeWidth(oVar.c(this));
        }
        if (W(style, 64)) {
            hVar.f10018a.f9692h = style.f9692h;
            int i11 = a.f9988b[style.f9692h.ordinal()];
            if (i11 == 1) {
                hVar.f10022e.setStrokeCap(Paint.Cap.BUTT);
            } else if (i11 == 2) {
                hVar.f10022e.setStrokeCap(Paint.Cap.ROUND);
            } else if (i11 == 3) {
                hVar.f10022e.setStrokeCap(Paint.Cap.SQUARE);
            }
        }
        if (W(style, 128)) {
            hVar.f10018a.f9693j = style.f9693j;
            int i12 = a.f9989c[style.f9693j.ordinal()];
            if (i12 == 1) {
                hVar.f10022e.setStrokeJoin(Paint.Join.MITER);
            } else if (i12 == 2) {
                hVar.f10022e.setStrokeJoin(Paint.Join.ROUND);
            } else if (i12 == 3) {
                hVar.f10022e.setStrokeJoin(Paint.Join.BEVEL);
            }
        }
        if (W(style, 256)) {
            hVar.f10018a.f9694k = style.f9694k;
            hVar.f10022e.setStrokeMiter(style.f9694k.floatValue());
        }
        if (W(style, 512)) {
            hVar.f10018a.f9695l = style.f9695l;
        }
        if (W(style, 1024)) {
            hVar.f10018a.f9696m = style.f9696m;
        }
        Typeface typeface = null;
        if (W(style, 1536)) {
            SVG.o[] oVarArr = hVar.f10018a.f9695l;
            if (oVarArr == null) {
                hVar.f10022e.setPathEffect((PathEffect) null);
            } else {
                int length = oVarArr.length;
                if (length % 2 == 0) {
                    i10 = length;
                } else {
                    i10 = length * 2;
                }
                float[] fArr = new float[i10];
                float f10 = 0.0f;
                for (int i13 = 0; i13 < i10; i13++) {
                    float c10 = hVar.f10018a.f9695l[i13 % length].c(this);
                    fArr[i13] = c10;
                    f10 += c10;
                }
                if (f10 == 0.0f) {
                    hVar.f10022e.setPathEffect((PathEffect) null);
                } else {
                    float c11 = hVar.f10018a.f9696m.c(this);
                    if (c11 < 0.0f) {
                        c11 = (c11 % f10) + f10;
                    }
                    hVar.f10022e.setPathEffect(new DashPathEffect(fArr, c11));
                }
            }
        }
        if (W(style, 16384)) {
            float Q = Q();
            hVar.f10018a.f9700t = style.f9700t;
            hVar.f10021d.setTextSize(style.f9700t.d(this, Q));
            hVar.f10022e.setTextSize(style.f9700t.d(this, Q));
        }
        if (W(style, 8192)) {
            hVar.f10018a.f9699q = style.f9699q;
        }
        if (W(style, 32768)) {
            if (style.f9701w.intValue() == -1 && hVar.f10018a.f9701w.intValue() > 100) {
                SVG.Style style3 = hVar.f10018a;
                style3.f9701w = Integer.valueOf(style3.f9701w.intValue() - 100);
            } else if (style.f9701w.intValue() != 1 || hVar.f10018a.f9701w.intValue() >= 900) {
                hVar.f10018a.f9701w = style.f9701w;
            } else {
                SVG.Style style4 = hVar.f10018a;
                style4.f9701w = Integer.valueOf(style4.f9701w.intValue() + 100);
            }
        }
        if (W(style, 65536)) {
            hVar.f10018a.f9702x = style.f9702x;
        }
        if (W(style, 106496)) {
            if (hVar.f10018a.f9699q != null && this.f9981c != null) {
                SVG.k();
                for (String t10 : hVar.f10018a.f9699q) {
                    SVG.Style style5 = hVar.f10018a;
                    typeface = t(t10, style5.f9701w, style5.f9702x);
                    if (typeface != null) {
                        break;
                    }
                }
            }
            if (typeface == null) {
                SVG.Style style6 = hVar.f10018a;
                typeface = t("serif", style6.f9701w, style6.f9702x);
            }
            hVar.f10021d.setTypeface(typeface);
            hVar.f10022e.setTypeface(typeface);
        }
        if (W(style, 131072)) {
            hVar.f10018a.f9703y = style.f9703y;
            Paint paint = hVar.f10021d;
            SVG.Style.TextDecoration textDecoration = style.f9703y;
            SVG.Style.TextDecoration textDecoration2 = SVG.Style.TextDecoration.LineThrough;
            if (textDecoration == textDecoration2) {
                z10 = true;
            } else {
                z10 = false;
            }
            paint.setStrikeThruText(z10);
            Paint paint2 = hVar.f10021d;
            SVG.Style.TextDecoration textDecoration3 = style.f9703y;
            SVG.Style.TextDecoration textDecoration4 = SVG.Style.TextDecoration.Underline;
            if (textDecoration3 == textDecoration4) {
                z11 = true;
            } else {
                z11 = false;
            }
            paint2.setUnderlineText(z11);
            Paint paint3 = hVar.f10022e;
            if (style.f9703y == textDecoration2) {
                z12 = true;
            } else {
                z12 = false;
            }
            paint3.setStrikeThruText(z12);
            Paint paint4 = hVar.f10022e;
            if (style.f9703y == textDecoration4) {
                z15 = true;
            }
            paint4.setUnderlineText(z15);
        }
        if (W(style, 68719476736L)) {
            hVar.f10018a.f9704z = style.f9704z;
        }
        if (W(style, 262144)) {
            hVar.f10018a.B = style.B;
        }
        if (W(style, 524288)) {
            hVar.f10018a.C = style.C;
        }
        if (W(style, 2097152)) {
            hVar.f10018a.E = style.E;
        }
        if (W(style, 4194304)) {
            hVar.f10018a.F = style.F;
        }
        if (W(style, 8388608)) {
            hVar.f10018a.G = style.G;
        }
        if (W(style, 16777216)) {
            hVar.f10018a.H = style.H;
        }
        if (W(style, 33554432)) {
            hVar.f10018a.I = style.I;
        }
        if (W(style, 1048576)) {
            hVar.f10018a.D = style.D;
        }
        if (W(style, 268435456)) {
            hVar.f10018a.L = style.L;
        }
        if (W(style, 536870912)) {
            hVar.f10018a.M = style.M;
        }
        if (W(style, 1073741824)) {
            hVar.f10018a.N = style.N;
        }
        if (W(style, 67108864)) {
            hVar.f10018a.J = style.J;
        }
        if (W(style, 134217728)) {
            hVar.f10018a.K = style.K;
        }
        if (W(style, 8589934592L)) {
            hVar.f10018a.Q = style.Q;
        }
        if (W(style, 17179869184L)) {
            hVar.f10018a.R = style.R;
        }
        if (W(style, 137438953472L)) {
            hVar.f10018a.T = style.T;
        }
    }

    private boolean W(SVG.Style style, long j10) {
        return (style.f9685a & j10) != 0;
    }

    private void W0(h hVar, SVG.j0 j0Var) {
        boolean z10;
        if (j0Var.f9819b == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        hVar.f10018a.b(z10);
        SVG.Style style = j0Var.f9809e;
        if (style != null) {
            V0(hVar, style);
        }
        if (this.f9981c.n()) {
            for (CSSParser.l next : this.f9981c.d()) {
                if (CSSParser.l(this.f9986h, next.f9638a, j0Var)) {
                    V0(hVar, next.f9639b);
                }
            }
        }
        SVG.Style style2 = j0Var.f9810f;
        if (style2 != null) {
            V0(hVar, style2);
        }
    }

    private void X(boolean z10, SVG.b bVar, SVG.k0 k0Var) {
        boolean z11;
        Paint paint;
        float f10;
        float f11;
        float f12;
        float f13;
        float f14;
        float f15;
        float f16;
        float f17;
        float f18;
        float f19;
        float f20;
        float f21;
        float f22;
        SVG.b bVar2 = bVar;
        SVG.k0 k0Var2 = k0Var;
        String str = k0Var2.f9806l;
        if (str != null) {
            H(k0Var2, str);
        }
        Boolean bool = k0Var2.f9803i;
        int i10 = 0;
        if (bool == null || !bool.booleanValue()) {
            z11 = false;
        } else {
            z11 = true;
        }
        h hVar = this.f9982d;
        if (z10) {
            paint = hVar.f10021d;
        } else {
            paint = hVar.f10022e;
        }
        if (z11) {
            SVG.b S = S();
            SVG.o oVar = k0Var2.f9813m;
            if (oVar != null) {
                f19 = oVar.e(this);
            } else {
                f19 = 0.0f;
            }
            SVG.o oVar2 = k0Var2.f9814n;
            if (oVar2 != null) {
                f20 = oVar2.h(this);
            } else {
                f20 = 0.0f;
            }
            SVG.o oVar3 = k0Var2.f9815o;
            if (oVar3 != null) {
                f21 = oVar3.e(this);
            } else {
                f21 = S.f9761c;
            }
            SVG.o oVar4 = k0Var2.f9816p;
            if (oVar4 != null) {
                f22 = oVar4.h(this);
            } else {
                f22 = 0.0f;
            }
            f11 = f21;
            f13 = f19;
            f12 = f20;
            f10 = f22;
        } else {
            SVG.o oVar5 = k0Var2.f9813m;
            if (oVar5 != null) {
                f15 = oVar5.d(this, 1.0f);
            } else {
                f15 = 0.0f;
            }
            SVG.o oVar6 = k0Var2.f9814n;
            if (oVar6 != null) {
                f16 = oVar6.d(this, 1.0f);
            } else {
                f16 = 0.0f;
            }
            SVG.o oVar7 = k0Var2.f9815o;
            if (oVar7 != null) {
                f17 = oVar7.d(this, 1.0f);
            } else {
                f17 = 1.0f;
            }
            SVG.o oVar8 = k0Var2.f9816p;
            if (oVar8 != null) {
                f18 = oVar8.d(this, 1.0f);
            } else {
                f18 = 0.0f;
            }
            f13 = f15;
            f10 = f18;
            f12 = f16;
            f11 = f17;
        }
        S0();
        this.f9982d = M(k0Var2);
        Matrix matrix = new Matrix();
        if (!z11) {
            matrix.preTranslate(bVar2.f9759a, bVar2.f9760b);
            matrix.preScale(bVar2.f9761c, bVar2.f9762d);
        }
        Matrix matrix2 = k0Var2.f9804j;
        if (matrix2 != null) {
            matrix.preConcat(matrix2);
        }
        int size = k0Var2.f9802h.size();
        if (size == 0) {
            R0();
            if (z10) {
                this.f9982d.f10019b = false;
            } else {
                this.f9982d.f10020c = false;
            }
        } else {
            int[] iArr = new int[size];
            float[] fArr = new float[size];
            float f23 = -1.0f;
            Iterator<SVG.l0> it = k0Var2.f9802h.iterator();
            while (it.hasNext()) {
                SVG.c0 c0Var = (SVG.c0) it.next();
                Float f24 = c0Var.f9772h;
                if (f24 != null) {
                    f14 = f24.floatValue();
                } else {
                    f14 = 0.0f;
                }
                if (i10 == 0 || f14 >= f23) {
                    fArr[i10] = f14;
                    f23 = f14;
                } else {
                    fArr[i10] = f23;
                }
                S0();
                W0(this.f9982d, c0Var);
                SVG.Style style = this.f9982d.f10018a;
                SVG.f fVar = (SVG.f) style.J;
                if (fVar == null) {
                    fVar = SVG.f.f9782b;
                }
                iArr[i10] = x(fVar.f9784a, style.K.floatValue());
                i10++;
                R0();
            }
            if ((f13 == f11 && f12 == f10) || size == 1) {
                R0();
                paint.setColor(iArr[size - 1]);
                return;
            }
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            SVG.GradientSpread gradientSpread = k0Var2.f9805k;
            if (gradientSpread != null) {
                if (gradientSpread == SVG.GradientSpread.reflect) {
                    tileMode = Shader.TileMode.MIRROR;
                } else if (gradientSpread == SVG.GradientSpread.repeat) {
                    tileMode = Shader.TileMode.REPEAT;
                }
            }
            R0();
            LinearGradient linearGradient = new LinearGradient(f13, f12, f11, f10, iArr, fArr, tileMode);
            linearGradient.setLocalMatrix(matrix);
            paint.setShader(linearGradient);
            paint.setAlpha(w(this.f9982d.f10018a.f9688d.floatValue()));
        }
    }

    private void X0() {
        int i10;
        SVG.Style style = this.f9982d.f10018a;
        SVG.m0 m0Var = style.Q;
        if (m0Var instanceof SVG.f) {
            i10 = ((SVG.f) m0Var).f9784a;
        } else if (m0Var instanceof SVG.g) {
            i10 = style.f9698p.f9784a;
        } else {
            return;
        }
        Float f10 = style.R;
        if (f10 != null) {
            i10 = x(i10, f10.floatValue());
        }
        this.f9979a.drawColor(i10);
    }

    private Path Y(SVG.d dVar) {
        float f10;
        SVG.d dVar2 = dVar;
        SVG.o oVar = dVar2.f9773o;
        float f11 = 0.0f;
        if (oVar != null) {
            f10 = oVar.e(this);
        } else {
            f10 = 0.0f;
        }
        SVG.o oVar2 = dVar2.f9774p;
        if (oVar2 != null) {
            f11 = oVar2.h(this);
        }
        float c10 = dVar2.f9775q.c(this);
        float f12 = f10 - c10;
        float f13 = f11 - c10;
        float f14 = f10 + c10;
        float f15 = f11 + c10;
        if (dVar2.f9801h == null) {
            float f16 = 2.0f * c10;
            dVar2.f9801h = new SVG.b(f12, f13, f16, f16);
        }
        float f17 = 0.5522848f * c10;
        Path path = new Path();
        path.moveTo(f10, f13);
        float f18 = f10 + f17;
        float f19 = f11 - f17;
        Path path2 = path;
        path2.cubicTo(f18, f13, f14, f19, f14, f11);
        float f20 = f11 + f17;
        path2.cubicTo(f14, f20, f18, f15, f10, f15);
        float f21 = f10 - f17;
        path2.cubicTo(f21, f15, f12, f20, f12, f11);
        path2.cubicTo(f12, f19, f21, f13, f10, f13);
        path.close();
        return path;
    }

    /* access modifiers changed from: private */
    public boolean Y0() {
        Boolean bool = this.f9982d.f10018a.I;
        if (bool != null) {
            return bool.booleanValue();
        }
        return true;
    }

    private Path Z(SVG.i iVar) {
        float f10;
        SVG.i iVar2 = iVar;
        SVG.o oVar = iVar2.f9797o;
        float f11 = 0.0f;
        if (oVar != null) {
            f10 = oVar.e(this);
        } else {
            f10 = 0.0f;
        }
        SVG.o oVar2 = iVar2.f9798p;
        if (oVar2 != null) {
            f11 = oVar2.h(this);
        }
        float e10 = iVar2.f9799q.e(this);
        float h10 = iVar2.f9800r.h(this);
        float f12 = f10 - e10;
        float f13 = f11 - h10;
        float f14 = f10 + e10;
        float f15 = f11 + h10;
        if (iVar2.f9801h == null) {
            iVar2.f9801h = new SVG.b(f12, f13, e10 * 2.0f, 2.0f * h10);
        }
        float f16 = e10 * 0.5522848f;
        float f17 = 0.5522848f * h10;
        Path path = new Path();
        path.moveTo(f10, f13);
        float f18 = f10 + f16;
        float f19 = f11 - f17;
        Path path2 = path;
        path.cubicTo(f18, f13, f14, f19, f14, f11);
        float f20 = f17 + f11;
        Path path3 = path2;
        path3.cubicTo(f14, f20, f18, f15, f10, f15);
        float f21 = f10 - f16;
        path3.cubicTo(f21, f15, f12, f20, f12, f11);
        path3.cubicTo(f12, f19, f21, f13, f10, f13);
        path2.close();
        return path2;
    }

    /* access modifiers changed from: private */
    public static void Z0(String str, Object... objArr) {
        String.format(str, objArr);
    }

    private Path a0(SVG.p pVar) {
        float f10;
        float f11;
        float f12;
        SVG.o oVar = pVar.f9834o;
        float f13 = 0.0f;
        if (oVar == null) {
            f10 = 0.0f;
        } else {
            f10 = oVar.e(this);
        }
        SVG.o oVar2 = pVar.f9835p;
        if (oVar2 == null) {
            f11 = 0.0f;
        } else {
            f11 = oVar2.h(this);
        }
        SVG.o oVar3 = pVar.f9836q;
        if (oVar3 == null) {
            f12 = 0.0f;
        } else {
            f12 = oVar3.e(this);
        }
        SVG.o oVar4 = pVar.f9837r;
        if (oVar4 != null) {
            f13 = oVar4.h(this);
        }
        if (pVar.f9801h == null) {
            pVar.f9801h = new SVG.b(Math.min(f10, f12), Math.min(f11, f13), Math.abs(f12 - f10), Math.abs(f13 - f11));
        }
        Path path = new Path();
        path.moveTo(f10, f11);
        path.lineTo(f12, f13);
        return path;
    }

    private Path b0(SVG.y yVar) {
        Path path = new Path();
        float[] fArr = yVar.f9874o;
        path.moveTo(fArr[0], fArr[1]);
        int i10 = 2;
        while (true) {
            float[] fArr2 = yVar.f9874o;
            if (i10 >= fArr2.length) {
                break;
            }
            path.lineTo(fArr2[i10], fArr2[i10 + 1]);
            i10 += 2;
        }
        if (yVar instanceof SVG.z) {
            path.close();
        }
        if (yVar.f9801h == null) {
            yVar.f9801h = m(path);
        }
        return path;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00dd  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.graphics.Path c0(com.caverock.androidsvg.SVG.a0 r24) {
        /*
            r23 = this;
            r0 = r23
            r1 = r24
            com.caverock.androidsvg.SVG$o r2 = r1.f9755s
            r3 = 0
            if (r2 != 0) goto L_0x000f
            com.caverock.androidsvg.SVG$o r4 = r1.f9756t
            if (r4 != 0) goto L_0x000f
            r2 = r3
            goto L_0x0017
        L_0x000f:
            if (r2 != 0) goto L_0x0019
            com.caverock.androidsvg.SVG$o r2 = r1.f9756t
            float r2 = r2.h(r0)
        L_0x0017:
            r4 = r2
            goto L_0x002c
        L_0x0019:
            com.caverock.androidsvg.SVG$o r4 = r1.f9756t
            if (r4 != 0) goto L_0x0022
            float r2 = r2.e(r0)
            goto L_0x0017
        L_0x0022:
            float r2 = r2.e(r0)
            com.caverock.androidsvg.SVG$o r4 = r1.f9756t
            float r4 = r4.h(r0)
        L_0x002c:
            com.caverock.androidsvg.SVG$o r5 = r1.f9753q
            float r5 = r5.e(r0)
            r6 = 1073741824(0x40000000, float:2.0)
            float r5 = r5 / r6
            float r2 = java.lang.Math.min(r2, r5)
            com.caverock.androidsvg.SVG$o r5 = r1.f9754r
            float r5 = r5.h(r0)
            float r5 = r5 / r6
            float r4 = java.lang.Math.min(r4, r5)
            com.caverock.androidsvg.SVG$o r5 = r1.f9751o
            if (r5 == 0) goto L_0x004d
            float r5 = r5.e(r0)
            goto L_0x004e
        L_0x004d:
            r5 = r3
        L_0x004e:
            com.caverock.androidsvg.SVG$o r6 = r1.f9752p
            if (r6 == 0) goto L_0x0058
            float r6 = r6.h(r0)
            r13 = r6
            goto L_0x0059
        L_0x0058:
            r13 = r3
        L_0x0059:
            com.caverock.androidsvg.SVG$o r6 = r1.f9753q
            float r6 = r6.e(r0)
            com.caverock.androidsvg.SVG$o r7 = r1.f9754r
            float r7 = r7.h(r0)
            com.caverock.androidsvg.SVG$b r8 = r1.f9801h
            if (r8 != 0) goto L_0x0070
            com.caverock.androidsvg.SVG$b r8 = new com.caverock.androidsvg.SVG$b
            r8.<init>(r5, r13, r6, r7)
            r1.f9801h = r8
        L_0x0070:
            float r15 = r5 + r6
            float r1 = r13 + r7
            android.graphics.Path r14 = new android.graphics.Path
            r14.<init>()
            int r6 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r6 == 0) goto L_0x00dd
            int r3 = (r4 > r3 ? 1 : (r4 == r3 ? 0 : -1))
            if (r3 != 0) goto L_0x0083
            goto L_0x00dd
        L_0x0083:
            r3 = 1057841801(0x3f0d6289, float:0.5522848)
            float r16 = r2 * r3
            float r3 = r3 * r4
            float r12 = r13 + r4
            r14.moveTo(r5, r12)
            float r17 = r12 - r3
            float r11 = r5 + r2
            float r21 = r11 - r16
            r6 = r14
            r7 = r5
            r8 = r17
            r9 = r21
            r10 = r13
            r24 = r11
            r22 = r12
            r12 = r13
            r6.cubicTo(r7, r8, r9, r10, r11, r12)
            float r2 = r15 - r2
            r14.lineTo(r2, r13)
            float r6 = r2 + r16
            r7 = r14
            r8 = r6
            r9 = r13
            r10 = r15
            r11 = r17
            r12 = r15
            r13 = r22
            r7.cubicTo(r8, r9, r10, r11, r12, r13)
            float r12 = r1 - r4
            r14.lineTo(r15, r12)
            float r10 = r12 + r3
            r3 = r14
            r16 = r10
            r17 = r6
            r18 = r1
            r19 = r2
            r20 = r1
            r14.cubicTo(r15, r16, r17, r18, r19, r20)
            r2 = r24
            r3.lineTo(r2, r1)
            r6 = r3
            r7 = r21
            r8 = r1
            r9 = r5
            r11 = r5
            r6.cubicTo(r7, r8, r9, r10, r11, r12)
            r3.lineTo(r5, r13)
            goto L_0x00ed
        L_0x00dd:
            r3 = r14
            r3.moveTo(r5, r13)
            r3.lineTo(r15, r13)
            r3.lineTo(r15, r1)
            r3.lineTo(r5, r1)
            r3.lineTo(r5, r13)
        L_0x00ed:
            r3.close()
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.caverock.androidsvg.d.c0(com.caverock.androidsvg.SVG$a0):android.graphics.Path");
    }

    private Path d0(SVG.u0 u0Var) {
        float f10;
        float f11;
        float f12;
        List<SVG.o> list = u0Var.f9875o;
        float f13 = 0.0f;
        if (list == null || list.size() == 0) {
            f10 = 0.0f;
        } else {
            f10 = u0Var.f9875o.get(0).e(this);
        }
        List<SVG.o> list2 = u0Var.f9876p;
        if (list2 == null || list2.size() == 0) {
            f11 = 0.0f;
        } else {
            f11 = u0Var.f9876p.get(0).h(this);
        }
        List<SVG.o> list3 = u0Var.f9877q;
        if (list3 == null || list3.size() == 0) {
            f12 = 0.0f;
        } else {
            f12 = u0Var.f9877q.get(0).e(this);
        }
        List<SVG.o> list4 = u0Var.f9878r;
        if (!(list4 == null || list4.size() == 0)) {
            f13 = u0Var.f9878r.get(0).h(this);
        }
        if (this.f9982d.f10018a.B != SVG.Style.TextAnchor.Start) {
            float n10 = n(u0Var);
            if (this.f9982d.f10018a.B == SVG.Style.TextAnchor.Middle) {
                n10 /= 2.0f;
            }
            f10 -= n10;
        }
        if (u0Var.f9801h == null) {
            i iVar = new i(f10, f11);
            E(u0Var, iVar);
            RectF rectF = iVar.f10029d;
            u0Var.f9801h = new SVG.b(rectF.left, rectF.top, rectF.width(), iVar.f10029d.height());
        }
        Path path = new Path();
        E(u0Var, new g(f10 + f12, f11 + f13, path));
        return path;
    }

    private void e0(boolean z10, SVG.b bVar, SVG.o0 o0Var) {
        boolean z11;
        Paint paint;
        float f10;
        float f11;
        float f12;
        float f13;
        float f14;
        float f15;
        float f16;
        float f17;
        float f18;
        SVG.b bVar2 = bVar;
        SVG.o0 o0Var2 = o0Var;
        String str = o0Var2.f9806l;
        if (str != null) {
            H(o0Var2, str);
        }
        Boolean bool = o0Var2.f9803i;
        int i10 = 0;
        if (bool == null || !bool.booleanValue()) {
            z11 = false;
        } else {
            z11 = true;
        }
        h hVar = this.f9982d;
        if (z10) {
            paint = hVar.f10021d;
        } else {
            paint = hVar.f10022e;
        }
        if (z11) {
            SVG.o oVar = new SVG.o(50.0f, SVG.Unit.percent);
            SVG.o oVar2 = o0Var2.f9829m;
            if (oVar2 != null) {
                f16 = oVar2.e(this);
            } else {
                f16 = oVar.e(this);
            }
            SVG.o oVar3 = o0Var2.f9830n;
            if (oVar3 != null) {
                f17 = oVar3.h(this);
            } else {
                f17 = oVar.h(this);
            }
            SVG.o oVar4 = o0Var2.f9831o;
            if (oVar4 != null) {
                f18 = oVar4.c(this);
            } else {
                f18 = oVar.c(this);
            }
            f10 = f18;
            f12 = f16;
            f11 = f17;
        } else {
            SVG.o oVar5 = o0Var2.f9829m;
            if (oVar5 != null) {
                f13 = oVar5.d(this, 1.0f);
            } else {
                f13 = 0.5f;
            }
            SVG.o oVar6 = o0Var2.f9830n;
            if (oVar6 != null) {
                f14 = oVar6.d(this, 1.0f);
            } else {
                f14 = 0.5f;
            }
            SVG.o oVar7 = o0Var2.f9831o;
            if (oVar7 != null) {
                f15 = oVar7.d(this, 1.0f);
            } else {
                f15 = 0.5f;
            }
            f12 = f13;
            f10 = f15;
            f11 = f14;
        }
        S0();
        this.f9982d = M(o0Var2);
        Matrix matrix = new Matrix();
        if (!z11) {
            matrix.preTranslate(bVar2.f9759a, bVar2.f9760b);
            matrix.preScale(bVar2.f9761c, bVar2.f9762d);
        }
        Matrix matrix2 = o0Var2.f9804j;
        if (matrix2 != null) {
            matrix.preConcat(matrix2);
        }
        int size = o0Var2.f9802h.size();
        if (size == 0) {
            R0();
            if (z10) {
                this.f9982d.f10019b = false;
            } else {
                this.f9982d.f10020c = false;
            }
        } else {
            int[] iArr = new int[size];
            float[] fArr = new float[size];
            float f19 = -1.0f;
            Iterator<SVG.l0> it = o0Var2.f9802h.iterator();
            while (true) {
                float f20 = 0.0f;
                if (!it.hasNext()) {
                    break;
                }
                SVG.c0 c0Var = (SVG.c0) it.next();
                Float f21 = c0Var.f9772h;
                if (f21 != null) {
                    f20 = f21.floatValue();
                }
                if (i10 == 0 || f20 >= f19) {
                    fArr[i10] = f20;
                    f19 = f20;
                } else {
                    fArr[i10] = f19;
                }
                S0();
                W0(this.f9982d, c0Var);
                SVG.Style style = this.f9982d.f10018a;
                SVG.f fVar = (SVG.f) style.J;
                if (fVar == null) {
                    fVar = SVG.f.f9782b;
                }
                iArr[i10] = x(fVar.f9784a, style.K.floatValue());
                i10++;
                R0();
            }
            if (f10 == 0.0f || size == 1) {
                R0();
                paint.setColor(iArr[size - 1]);
                return;
            }
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            SVG.GradientSpread gradientSpread = o0Var2.f9805k;
            if (gradientSpread != null) {
                if (gradientSpread == SVG.GradientSpread.reflect) {
                    tileMode = Shader.TileMode.MIRROR;
                } else if (gradientSpread == SVG.GradientSpread.repeat) {
                    tileMode = Shader.TileMode.REPEAT;
                }
            }
            R0();
            RadialGradient radialGradient = new RadialGradient(f12, f11, f10, iArr, fArr, tileMode);
            radialGradient.setLocalMatrix(matrix);
            paint.setShader(radialGradient);
            paint.setAlpha(w(this.f9982d.f10018a.f9688d.floatValue()));
        }
    }

    private SVG.b f0(SVG.o oVar, SVG.o oVar2, SVG.o oVar3, SVG.o oVar4) {
        float f10;
        float f11;
        float f12;
        float f13 = 0.0f;
        if (oVar != null) {
            f10 = oVar.e(this);
        } else {
            f10 = 0.0f;
        }
        if (oVar2 != null) {
            f13 = oVar2.h(this);
        }
        SVG.b S = S();
        if (oVar3 != null) {
            f11 = oVar3.e(this);
        } else {
            f11 = S.f9761c;
        }
        if (oVar4 != null) {
            f12 = oVar4.h(this);
        } else {
            f12 = S.f9762d;
        }
        return new SVG.b(f10, f13, f11, f12);
    }

    @TargetApi(19)
    private Path g0(SVG.i0 i0Var, boolean z10) {
        Path path;
        Path j10;
        this.f9983e.push(this.f9982d);
        h hVar = new h(this.f9982d);
        this.f9982d = hVar;
        W0(hVar, i0Var);
        if (!A() || !Y0()) {
            this.f9982d = this.f9983e.pop();
            return null;
        }
        if (i0Var instanceof SVG.b1) {
            if (!z10) {
                F("<use> elements inside a <clipPath> cannot reference another <use>", new Object[0]);
            }
            SVG.b1 b1Var = (SVG.b1) i0Var;
            SVG.l0 p10 = i0Var.f9818a.p(b1Var.f9763p);
            if (p10 == null) {
                F("Use reference '%s' not found", b1Var.f9763p);
                this.f9982d = this.f9983e.pop();
                return null;
            } else if (!(p10 instanceof SVG.i0)) {
                this.f9982d = this.f9983e.pop();
                return null;
            } else {
                path = g0((SVG.i0) p10, false);
                if (path == null) {
                    return null;
                }
                if (b1Var.f9801h == null) {
                    b1Var.f9801h = m(path);
                }
                Matrix matrix = b1Var.f9817o;
                if (matrix != null) {
                    path.transform(matrix);
                }
            }
        } else if (i0Var instanceof SVG.k) {
            SVG.k kVar = (SVG.k) i0Var;
            if (i0Var instanceof SVG.u) {
                path = new C0114d(((SVG.u) i0Var).f9856o).f();
                if (i0Var.f9801h == null) {
                    i0Var.f9801h = m(path);
                }
            } else {
                path = i0Var instanceof SVG.a0 ? c0((SVG.a0) i0Var) : i0Var instanceof SVG.d ? Y((SVG.d) i0Var) : i0Var instanceof SVG.i ? Z((SVG.i) i0Var) : i0Var instanceof SVG.y ? b0((SVG.y) i0Var) : null;
            }
            if (path == null) {
                return null;
            }
            if (kVar.f9801h == null) {
                kVar.f9801h = m(path);
            }
            Matrix matrix2 = kVar.f9812n;
            if (matrix2 != null) {
                path.transform(matrix2);
            }
            path.setFillType(P());
        } else if (i0Var instanceof SVG.u0) {
            SVG.u0 u0Var = (SVG.u0) i0Var;
            path = d0(u0Var);
            if (path == null) {
                return null;
            }
            Matrix matrix3 = u0Var.f9858s;
            if (matrix3 != null) {
                path.transform(matrix3);
            }
            path.setFillType(P());
        } else {
            F("Invalid %s element found in clipPath definition", i0Var.n());
            return null;
        }
        if (!(this.f9982d.f10018a.L == null || (j10 = j(i0Var, i0Var.f9801h)) == null)) {
            path.op(j10, Path.Op.INTERSECT);
        }
        this.f9982d = this.f9983e.pop();
        return path;
    }

    /* access modifiers changed from: private */
    public static void h(float f10, float f11, float f12, float f13, float f14, boolean z10, boolean z11, float f15, float f16, SVG.w wVar) {
        float f17;
        SVG.w wVar2;
        double d10;
        double d11;
        float f18 = f14;
        boolean z12 = z11;
        float f19 = f15;
        float f20 = f16;
        if (f10 != f19 || f11 != f20) {
            if (f12 == 0.0f) {
                f17 = f19;
                wVar2 = wVar;
            } else if (f13 == 0.0f) {
                wVar2 = wVar;
                f17 = f19;
            } else {
                float abs = Math.abs(f12);
                float abs2 = Math.abs(f13);
                double radians = Math.toRadians(((double) f18) % 360.0d);
                double cos = Math.cos(radians);
                double sin = Math.sin(radians);
                double d12 = ((double) (f10 - f19)) / 2.0d;
                double d13 = ((double) (f11 - f20)) / 2.0d;
                double d14 = (cos * d12) + (sin * d13);
                double d15 = ((-sin) * d12) + (d13 * cos);
                double d16 = (double) (abs * abs);
                double d17 = (double) (abs2 * abs2);
                double d18 = d14 * d14;
                double d19 = d15 * d15;
                double d20 = (d18 / d16) + (d19 / d17);
                if (d20 > 0.99999d) {
                    double sqrt = Math.sqrt(d20) * 1.00001d;
                    abs = (float) (((double) abs) * sqrt);
                    abs2 = (float) (sqrt * ((double) abs2));
                    d16 = (double) (abs * abs);
                    d17 = (double) (abs2 * abs2);
                }
                double d21 = -1.0d;
                if (z10 == z12) {
                    d10 = -1.0d;
                } else {
                    d10 = 1.0d;
                }
                double d22 = d16 * d17;
                double d23 = d16 * d19;
                double d24 = d17 * d18;
                double d25 = ((d22 - d23) - d24) / (d23 + d24);
                if (d25 < 0.0d) {
                    d25 = 0.0d;
                }
                double sqrt2 = d10 * Math.sqrt(d25);
                double d26 = (double) abs;
                double d27 = (double) abs2;
                double d28 = ((d26 * d15) / d27) * sqrt2;
                float f21 = abs2;
                double d29 = sqrt2 * (-((d27 * d14) / d26));
                float f22 = abs;
                double d30 = (((double) (f10 + f15)) / 2.0d) + ((cos * d28) - (sin * d29));
                double d31 = (((double) (f11 + f16)) / 2.0d) + (sin * d28) + (cos * d29);
                double d32 = (d14 - d28) / d26;
                double d33 = (d15 - d29) / d27;
                double d34 = ((-d14) - d28) / d26;
                double d35 = ((-d15) - d29) / d27;
                double d36 = (d32 * d32) + (d33 * d33);
                double sqrt3 = Math.sqrt(d36);
                if (d33 < 0.0d) {
                    d11 = -1.0d;
                } else {
                    d11 = 1.0d;
                }
                double acos = d11 * Math.acos(d32 / sqrt3);
                double sqrt4 = Math.sqrt(d36 * ((d34 * d34) + (d35 * d35)));
                double d37 = (d32 * d34) + (d33 * d35);
                if ((d32 * d35) - (d33 * d34) >= 0.0d) {
                    d21 = 1.0d;
                }
                double v10 = d21 * v(d37 / sqrt4);
                if (!z11 && v10 > 0.0d) {
                    v10 -= 6.283185307179586d;
                } else if (z11 && v10 < 0.0d) {
                    v10 += 6.283185307179586d;
                }
                float[] i10 = i(acos % 6.283185307179586d, v10 % 6.283185307179586d);
                Matrix matrix = new Matrix();
                matrix.postScale(f22, f21);
                matrix.postRotate(f14);
                matrix.postTranslate((float) d30, (float) d31);
                matrix.mapPoints(i10);
                i10[i10.length - 2] = f15;
                i10[i10.length - 1] = f16;
                for (int i11 = 0; i11 < i10.length; i11 += 6) {
                    wVar.c(i10[i11], i10[i11 + 1], i10[i11 + 2], i10[i11 + 3], i10[i11 + 4], i10[i11 + 5]);
                }
                return;
            }
            wVar2.e(f17, f20);
        }
    }

    private void h0() {
        this.f9984f.pop();
        this.f9985g.pop();
    }

    private static float[] i(double d10, double d11) {
        int ceil = (int) Math.ceil((Math.abs(d11) * 2.0d) / 3.141592653589793d);
        double d12 = d11 / ((double) ceil);
        double d13 = d12 / 2.0d;
        double sin = (Math.sin(d13) * 1.3333333333333333d) / (Math.cos(d13) + 1.0d);
        float[] fArr = new float[(ceil * 6)];
        int i10 = 0;
        for (int i11 = 0; i11 < ceil; i11++) {
            double d14 = d10 + (((double) i11) * d12);
            double cos = Math.cos(d14);
            double sin2 = Math.sin(d14);
            int i12 = i10 + 1;
            fArr[i10] = (float) (cos - (sin * sin2));
            int i13 = i12 + 1;
            fArr[i12] = (float) (sin2 + (cos * sin));
            d12 = d12;
            double d15 = d14 + d12;
            double cos2 = Math.cos(d15);
            double sin3 = Math.sin(d15);
            int i14 = i13 + 1;
            fArr[i13] = (float) ((sin * sin3) + cos2);
            int i15 = i14 + 1;
            fArr[i14] = (float) (sin3 - (sin * cos2));
            int i16 = i15 + 1;
            fArr[i15] = (float) cos2;
            i10 = i16 + 1;
            fArr[i16] = (float) sin3;
        }
        return fArr;
    }

    private void i0(SVG.h0 h0Var) {
        this.f9984f.push(h0Var);
        this.f9985g.push(this.f9979a.getMatrix());
    }

    @TargetApi(19)
    private Path j(SVG.i0 i0Var, SVG.b bVar) {
        Path g02;
        SVG.l0 p10 = i0Var.f9818a.p(this.f9982d.f10018a.L);
        boolean z10 = false;
        if (p10 == null) {
            F("ClipPath reference '%s' not found", this.f9982d.f10018a.L);
            return null;
        }
        SVG.e eVar = (SVG.e) p10;
        this.f9983e.push(this.f9982d);
        this.f9982d = M(eVar);
        Boolean bool = eVar.f9781p;
        if (bool == null || bool.booleanValue()) {
            z10 = true;
        }
        Matrix matrix = new Matrix();
        if (!z10) {
            matrix.preTranslate(bVar.f9759a, bVar.f9760b);
            matrix.preScale(bVar.f9761c, bVar.f9762d);
        }
        Matrix matrix2 = eVar.f9817o;
        if (matrix2 != null) {
            matrix.preConcat(matrix2);
        }
        Path path = new Path();
        for (SVG.l0 next : eVar.f9785i) {
            if ((next instanceof SVG.i0) && (g02 = g0((SVG.i0) next, true)) != null) {
                path.op(g02, Path.Op.UNION);
            }
        }
        if (this.f9982d.f10018a.L != null) {
            if (eVar.f9801h == null) {
                eVar.f9801h = m(path);
            }
            Path j10 = j(eVar, eVar.f9801h);
            if (j10 != null) {
                path.op(j10, Path.Op.INTERSECT);
            }
        }
        path.transform(matrix);
        this.f9982d = this.f9983e.pop();
        return path;
    }

    private void j0(SVG.i0 i0Var) {
        k0(i0Var, i0Var.f9801h);
    }

    private List<c> k(SVG.p pVar) {
        float f10;
        float f11;
        float f12;
        SVG.o oVar = pVar.f9834o;
        float f13 = 0.0f;
        if (oVar != null) {
            f10 = oVar.e(this);
        } else {
            f10 = 0.0f;
        }
        SVG.o oVar2 = pVar.f9835p;
        if (oVar2 != null) {
            f11 = oVar2.h(this);
        } else {
            f11 = 0.0f;
        }
        SVG.o oVar3 = pVar.f9836q;
        if (oVar3 != null) {
            f12 = oVar3.e(this);
        } else {
            f12 = 0.0f;
        }
        SVG.o oVar4 = pVar.f9837r;
        if (oVar4 != null) {
            f13 = oVar4.h(this);
        }
        float f14 = f13;
        ArrayList arrayList = new ArrayList(2);
        float f15 = f12 - f10;
        float f16 = f14 - f11;
        arrayList.add(new c(f10, f11, f15, f16));
        arrayList.add(new c(f12, f14, f15, f16));
        return arrayList;
    }

    private void k0(SVG.i0 i0Var, SVG.b bVar) {
        if (this.f9982d.f10018a.N != null) {
            Paint paint = new Paint();
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
            this.f9979a.saveLayer((RectF) null, paint, 31);
            Paint paint2 = new Paint();
            paint2.setColorFilter(new ColorMatrixColorFilter(new ColorMatrix(new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.2127f, 0.7151f, 0.0722f, 0.0f, 0.0f})));
            this.f9979a.saveLayer((RectF) null, paint2, 31);
            SVG.r rVar = (SVG.r) this.f9981c.p(this.f9982d.f10018a.N);
            J0(rVar, i0Var, bVar);
            this.f9979a.restore();
            Paint paint3 = new Paint();
            paint3.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
            this.f9979a.saveLayer((RectF) null, paint3, 31);
            J0(rVar, i0Var, bVar);
            this.f9979a.restore();
            this.f9979a.restore();
        }
        R0();
    }

    private List<c> l(SVG.y yVar) {
        SVG.y yVar2 = yVar;
        int length = yVar2.f9874o.length;
        int i10 = 2;
        if (length < 2) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        float[] fArr = yVar2.f9874o;
        c cVar = new c(fArr[0], fArr[1], 0.0f, 0.0f);
        float f10 = 0.0f;
        float f11 = 0.0f;
        while (i10 < length) {
            float[] fArr2 = yVar2.f9874o;
            float f12 = fArr2[i10];
            float f13 = fArr2[i10 + 1];
            cVar.a(f12, f13);
            arrayList.add(cVar);
            i10 += 2;
            cVar = new c(f12, f13, f12 - cVar.f9999a, f13 - cVar.f10000b);
            float f14 = f12;
            f11 = f13;
            f10 = f14;
        }
        if (yVar2 instanceof SVG.z) {
            float[] fArr3 = yVar2.f9874o;
            float f15 = fArr3[0];
            if (f10 != f15) {
                float f16 = fArr3[1];
                if (f11 != f16) {
                    cVar.a(f15, f16);
                    arrayList.add(cVar);
                    c cVar2 = new c(f15, f16, f15 - cVar.f9999a, f16 - cVar.f10000b);
                    cVar2.b((c) arrayList.get(0));
                    arrayList.add(cVar2);
                    arrayList.set(0, cVar2);
                }
            }
        } else {
            arrayList.add(cVar);
        }
        return arrayList;
    }

    private void l0(SVG.l0 l0Var, j jVar) {
        float f10;
        float f11;
        float f12;
        SVG.Style.TextAnchor O;
        float f13;
        if (jVar.a((SVG.w0) l0Var)) {
            if (l0Var instanceof SVG.x0) {
                S0();
                L0((SVG.x0) l0Var);
                R0();
                return;
            }
            boolean z10 = true;
            if (l0Var instanceof SVG.t0) {
                y("TSpan render", new Object[0]);
                S0();
                SVG.t0 t0Var = (SVG.t0) l0Var;
                W0(this.f9982d, t0Var);
                if (A()) {
                    List<SVG.o> list = t0Var.f9875o;
                    if (list == null || list.size() <= 0) {
                        z10 = false;
                    }
                    boolean z11 = jVar instanceof f;
                    float f14 = 0.0f;
                    if (z11) {
                        if (!z10) {
                            f13 = ((f) jVar).f10011b;
                        } else {
                            f13 = t0Var.f9875o.get(0).e(this);
                        }
                        List<SVG.o> list2 = t0Var.f9876p;
                        if (list2 == null || list2.size() == 0) {
                            f11 = ((f) jVar).f10012c;
                        } else {
                            f11 = t0Var.f9876p.get(0).h(this);
                        }
                        List<SVG.o> list3 = t0Var.f9877q;
                        if (list3 == null || list3.size() == 0) {
                            f10 = 0.0f;
                        } else {
                            f10 = t0Var.f9877q.get(0).e(this);
                        }
                        List<SVG.o> list4 = t0Var.f9878r;
                        if (!(list4 == null || list4.size() == 0)) {
                            f14 = t0Var.f9878r.get(0).h(this);
                        }
                        f12 = f14;
                        f14 = f13;
                    } else {
                        f12 = 0.0f;
                        f11 = 0.0f;
                        f10 = 0.0f;
                    }
                    if (z10 && (O = O()) != SVG.Style.TextAnchor.Start) {
                        float n10 = n(t0Var);
                        if (O == SVG.Style.TextAnchor.Middle) {
                            n10 /= 2.0f;
                        }
                        f14 -= n10;
                    }
                    r((SVG.i0) t0Var.d());
                    if (z11) {
                        f fVar = (f) jVar;
                        fVar.f10011b = f14 + f10;
                        fVar.f10012c = f11 + f12;
                    }
                    boolean m02 = m0();
                    E(t0Var, jVar);
                    if (m02) {
                        j0(t0Var);
                    }
                }
                R0();
            } else if (l0Var instanceof SVG.s0) {
                S0();
                SVG.s0 s0Var = (SVG.s0) l0Var;
                W0(this.f9982d, s0Var);
                if (A()) {
                    r((SVG.i0) s0Var.d());
                    SVG.l0 p10 = l0Var.f9818a.p(s0Var.f9851o);
                    if (p10 == null || !(p10 instanceof SVG.w0)) {
                        F("Tref reference '%s' not found", s0Var.f9851o);
                    } else {
                        StringBuilder sb2 = new StringBuilder();
                        G((SVG.w0) p10, sb2);
                        if (sb2.length() > 0) {
                            jVar.b(sb2.toString());
                        }
                    }
                }
                R0();
            }
        }
    }

    private SVG.b m(Path path) {
        RectF rectF = new RectF();
        path.computeBounds(rectF, true);
        return new SVG.b(rectF.left, rectF.top, rectF.width(), rectF.height());
    }

    private boolean m0() {
        SVG.l0 p10;
        if (!M0()) {
            return false;
        }
        this.f9979a.saveLayerAlpha((RectF) null, w(this.f9982d.f10018a.f9697n.floatValue()), 31);
        this.f9983e.push(this.f9982d);
        h hVar = new h(this.f9982d);
        this.f9982d = hVar;
        String str = hVar.f10018a.N;
        if (str != null && ((p10 = this.f9981c.p(str)) == null || !(p10 instanceof SVG.r))) {
            F("Mask reference '%s' not found", this.f9982d.f10018a.N);
            this.f9982d.f10018a.N = null;
        }
        return true;
    }

    private float n(SVG.w0 w0Var) {
        k kVar = new k(this, (a) null);
        E(w0Var, kVar);
        return kVar.f10032b;
    }

    private c n0(c cVar, c cVar2, c cVar3) {
        float D = D(cVar2.f10001c, cVar2.f10002d, cVar2.f9999a - cVar.f9999a, cVar2.f10000b - cVar.f10000b);
        if (D == 0.0f) {
            D = D(cVar2.f10001c, cVar2.f10002d, cVar3.f9999a - cVar2.f9999a, cVar3.f10000b - cVar2.f10000b);
        }
        int i10 = (D > 0.0f ? 1 : (D == 0.0f ? 0 : -1));
        if (i10 > 0) {
            return cVar2;
        }
        if (i10 == 0 && (cVar2.f10001c > 0.0f || cVar2.f10002d >= 0.0f)) {
            return cVar2;
        }
        cVar2.f10001c = -cVar2.f10001c;
        cVar2.f10002d = -cVar2.f10002d;
        return cVar2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0066, code lost:
        r3 = r3 - r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0082, code lost:
        if (r12 != 8) goto L_0x008e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.graphics.Matrix o(com.caverock.androidsvg.SVG.b r10, com.caverock.androidsvg.SVG.b r11, com.caverock.androidsvg.PreserveAspectRatio r12) {
        /*
            r9 = this;
            android.graphics.Matrix r0 = new android.graphics.Matrix
            r0.<init>()
            if (r12 == 0) goto L_0x009b
            com.caverock.androidsvg.PreserveAspectRatio$Alignment r1 = r12.a()
            if (r1 != 0) goto L_0x000f
            goto L_0x009b
        L_0x000f:
            float r1 = r10.f9761c
            float r2 = r11.f9761c
            float r1 = r1 / r2
            float r2 = r10.f9762d
            float r3 = r11.f9762d
            float r2 = r2 / r3
            float r3 = r11.f9759a
            float r3 = -r3
            float r4 = r11.f9760b
            float r4 = -r4
            com.caverock.androidsvg.PreserveAspectRatio r5 = com.caverock.androidsvg.PreserveAspectRatio.f9650d
            boolean r5 = r12.equals(r5)
            if (r5 == 0) goto L_0x0035
            float r11 = r10.f9759a
            float r10 = r10.f9760b
            r0.preTranslate(r11, r10)
            r0.preScale(r1, r2)
            r0.preTranslate(r3, r4)
            return r0
        L_0x0035:
            com.caverock.androidsvg.PreserveAspectRatio$Scale r5 = r12.b()
            com.caverock.androidsvg.PreserveAspectRatio$Scale r6 = com.caverock.androidsvg.PreserveAspectRatio.Scale.slice
            if (r5 != r6) goto L_0x0042
            float r1 = java.lang.Math.max(r1, r2)
            goto L_0x0046
        L_0x0042:
            float r1 = java.lang.Math.min(r1, r2)
        L_0x0046:
            float r2 = r10.f9761c
            float r2 = r2 / r1
            float r5 = r10.f9762d
            float r5 = r5 / r1
            int[] r6 = com.caverock.androidsvg.d.a.f9987a
            com.caverock.androidsvg.PreserveAspectRatio$Alignment r7 = r12.a()
            int r7 = r7.ordinal()
            r7 = r6[r7]
            r8 = 1073741824(0x40000000, float:2.0)
            switch(r7) {
                case 1: goto L_0x0062;
                case 2: goto L_0x0062;
                case 3: goto L_0x0062;
                case 4: goto L_0x005e;
                case 5: goto L_0x005e;
                case 6: goto L_0x005e;
                default: goto L_0x005d;
            }
        L_0x005d:
            goto L_0x0067
        L_0x005e:
            float r7 = r11.f9761c
            float r7 = r7 - r2
            goto L_0x0066
        L_0x0062:
            float r7 = r11.f9761c
            float r7 = r7 - r2
            float r7 = r7 / r8
        L_0x0066:
            float r3 = r3 - r7
        L_0x0067:
            com.caverock.androidsvg.PreserveAspectRatio$Alignment r12 = r12.a()
            int r12 = r12.ordinal()
            r12 = r6[r12]
            r2 = 2
            if (r12 == r2) goto L_0x0089
            r2 = 3
            if (r12 == r2) goto L_0x0085
            r2 = 5
            if (r12 == r2) goto L_0x0089
            r2 = 6
            if (r12 == r2) goto L_0x0085
            r2 = 7
            if (r12 == r2) goto L_0x0089
            r2 = 8
            if (r12 == r2) goto L_0x0085
            goto L_0x008e
        L_0x0085:
            float r11 = r11.f9762d
            float r11 = r11 - r5
            goto L_0x008d
        L_0x0089:
            float r11 = r11.f9762d
            float r11 = r11 - r5
            float r11 = r11 / r8
        L_0x008d:
            float r4 = r4 - r11
        L_0x008e:
            float r11 = r10.f9759a
            float r10 = r10.f9760b
            r0.preTranslate(r11, r10)
            r0.preScale(r1, r1)
            r0.preTranslate(r3, r4)
        L_0x009b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.caverock.androidsvg.d.o(com.caverock.androidsvg.SVG$b, com.caverock.androidsvg.SVG$b, com.caverock.androidsvg.PreserveAspectRatio):android.graphics.Matrix");
    }

    private void o0(SVG.d dVar) {
        y("Circle render", new Object[0]);
        SVG.o oVar = dVar.f9775q;
        if (oVar != null && !oVar.j()) {
            W0(this.f9982d, dVar);
            if (A() && Y0()) {
                Matrix matrix = dVar.f9812n;
                if (matrix != null) {
                    this.f9979a.concat(matrix);
                }
                Path Y = Y(dVar);
                U0(dVar);
                r(dVar);
                p(dVar);
                boolean m02 = m0();
                if (this.f9982d.f10019b) {
                    B(dVar, Y);
                }
                if (this.f9982d.f10020c) {
                    C(Y);
                }
                if (m02) {
                    j0(dVar);
                }
            }
        }
    }

    private void p(SVG.i0 i0Var) {
        q(i0Var, i0Var.f9801h);
    }

    private void p0(SVG.i iVar) {
        y("Ellipse render", new Object[0]);
        SVG.o oVar = iVar.f9799q;
        if (oVar != null && iVar.f9800r != null && !oVar.j() && !iVar.f9800r.j()) {
            W0(this.f9982d, iVar);
            if (A() && Y0()) {
                Matrix matrix = iVar.f9812n;
                if (matrix != null) {
                    this.f9979a.concat(matrix);
                }
                Path Z = Z(iVar);
                U0(iVar);
                r(iVar);
                p(iVar);
                boolean m02 = m0();
                if (this.f9982d.f10019b) {
                    B(iVar, Z);
                }
                if (this.f9982d.f10020c) {
                    C(Z);
                }
                if (m02) {
                    j0(iVar);
                }
            }
        }
    }

    private void q(SVG.i0 i0Var, SVG.b bVar) {
        Path j10;
        if (this.f9982d.f10018a.L != null && (j10 = j(i0Var, bVar)) != null) {
            this.f9979a.clipPath(j10);
        }
    }

    private void q0(SVG.l lVar) {
        y("Group render", new Object[0]);
        W0(this.f9982d, lVar);
        if (A()) {
            Matrix matrix = lVar.f9817o;
            if (matrix != null) {
                this.f9979a.concat(matrix);
            }
            p(lVar);
            boolean m02 = m0();
            F0(lVar, true);
            if (m02) {
                j0(lVar);
            }
            U0(lVar);
        }
    }

    private void r(SVG.i0 i0Var) {
        SVG.m0 m0Var = this.f9982d.f10018a.f9686b;
        if (m0Var instanceof SVG.t) {
            z(true, i0Var.f9801h, (SVG.t) m0Var);
        }
        SVG.m0 m0Var2 = this.f9982d.f10018a.f9689e;
        if (m0Var2 instanceof SVG.t) {
            z(false, i0Var.f9801h, (SVG.t) m0Var2);
        }
    }

    private void r0(SVG.n nVar) {
        SVG.o oVar;
        String str;
        float f10;
        float f11;
        int i10 = 0;
        y("Image render", new Object[0]);
        SVG.o oVar2 = nVar.f9823s;
        if (oVar2 != null && !oVar2.j() && (oVar = nVar.f9824t) != null && !oVar.j() && (str = nVar.f9820p) != null) {
            PreserveAspectRatio preserveAspectRatio = nVar.f9826o;
            if (preserveAspectRatio == null) {
                preserveAspectRatio = PreserveAspectRatio.f9651e;
            }
            Bitmap s10 = s(str);
            if (s10 == null) {
                SVG.k();
                return;
            }
            SVG.b bVar = new SVG.b(0.0f, 0.0f, (float) s10.getWidth(), (float) s10.getHeight());
            W0(this.f9982d, nVar);
            if (A() && Y0()) {
                Matrix matrix = nVar.f9825u;
                if (matrix != null) {
                    this.f9979a.concat(matrix);
                }
                SVG.o oVar3 = nVar.f9821q;
                if (oVar3 != null) {
                    f10 = oVar3.e(this);
                } else {
                    f10 = 0.0f;
                }
                SVG.o oVar4 = nVar.f9822r;
                if (oVar4 != null) {
                    f11 = oVar4.h(this);
                } else {
                    f11 = 0.0f;
                }
                this.f9982d.f10023f = new SVG.b(f10, f11, nVar.f9823s.e(this), nVar.f9824t.e(this));
                if (!this.f9982d.f10018a.C.booleanValue()) {
                    SVG.b bVar2 = this.f9982d.f10023f;
                    O0(bVar2.f9759a, bVar2.f9760b, bVar2.f9761c, bVar2.f9762d);
                }
                nVar.f9801h = this.f9982d.f10023f;
                U0(nVar);
                p(nVar);
                boolean m02 = m0();
                X0();
                this.f9979a.save();
                this.f9979a.concat(o(this.f9982d.f10023f, bVar, preserveAspectRatio));
                if (this.f9982d.f10018a.T != SVG.Style.RenderQuality.optimizeSpeed) {
                    i10 = 2;
                }
                this.f9979a.drawBitmap(s10, 0.0f, 0.0f, new Paint(i10));
                this.f9979a.restore();
                if (m02) {
                    j0(nVar);
                }
            }
        }
    }

    private Bitmap s(String str) {
        int indexOf;
        if (!str.startsWith("data:") || str.length() < 14 || (indexOf = str.indexOf(44)) < 12 || !";base64".equals(str.substring(indexOf - 7, indexOf))) {
            return null;
        }
        try {
            byte[] decode = Base64.decode(str.substring(indexOf + 1), 0);
            return BitmapFactory.decodeByteArray(decode, 0, decode.length);
        } catch (Exception unused) {
            return null;
        }
    }

    private void s0(SVG.p pVar) {
        y("Line render", new Object[0]);
        W0(this.f9982d, pVar);
        if (A() && Y0() && this.f9982d.f10020c) {
            Matrix matrix = pVar.f9812n;
            if (matrix != null) {
                this.f9979a.concat(matrix);
            }
            Path a02 = a0(pVar);
            U0(pVar);
            r(pVar);
            p(pVar);
            boolean m02 = m0();
            C(a02);
            I0(pVar);
            if (m02) {
                j0(pVar);
            }
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0052, code lost:
        if (r6.equals("monospace") == false) goto L_0x0029;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.graphics.Typeface t(java.lang.String r6, java.lang.Integer r7, com.caverock.androidsvg.SVG.Style.FontStyle r8) {
        /*
            r5 = this;
            com.caverock.androidsvg.SVG$Style$FontStyle r0 = com.caverock.androidsvg.SVG.Style.FontStyle.Italic
            r1 = 1
            r2 = 0
            if (r8 != r0) goto L_0x0008
            r8 = r1
            goto L_0x0009
        L_0x0008:
            r8 = r2
        L_0x0009:
            int r7 = r7.intValue()
            r0 = 500(0x1f4, float:7.0E-43)
            r3 = 3
            r4 = 2
            if (r7 <= r0) goto L_0x0019
            if (r8 == 0) goto L_0x0017
            r7 = r3
            goto L_0x001e
        L_0x0017:
            r7 = r1
            goto L_0x001e
        L_0x0019:
            if (r8 == 0) goto L_0x001d
            r7 = r4
            goto L_0x001e
        L_0x001d:
            r7 = r2
        L_0x001e:
            r6.hashCode()
            r8 = -1
            int r0 = r6.hashCode()
            switch(r0) {
                case -1536685117: goto L_0x0055;
                case -1431958525: goto L_0x004c;
                case -1081737434: goto L_0x0041;
                case 109326717: goto L_0x0036;
                case 1126973893: goto L_0x002b;
                default: goto L_0x0029;
            }
        L_0x0029:
            r1 = r8
            goto L_0x005f
        L_0x002b:
            java.lang.String r0 = "cursive"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x0034
            goto L_0x0029
        L_0x0034:
            r1 = 4
            goto L_0x005f
        L_0x0036:
            java.lang.String r0 = "serif"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x003f
            goto L_0x0029
        L_0x003f:
            r1 = r3
            goto L_0x005f
        L_0x0041:
            java.lang.String r0 = "fantasy"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x004a
            goto L_0x0029
        L_0x004a:
            r1 = r4
            goto L_0x005f
        L_0x004c:
            java.lang.String r0 = "monospace"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x005f
            goto L_0x0029
        L_0x0055:
            java.lang.String r0 = "sans-serif"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x005e
            goto L_0x0029
        L_0x005e:
            r1 = r2
        L_0x005f:
            switch(r1) {
                case 0: goto L_0x0080;
                case 1: goto L_0x0079;
                case 2: goto L_0x0072;
                case 3: goto L_0x006b;
                case 4: goto L_0x0064;
                default: goto L_0x0062;
            }
        L_0x0062:
            r6 = 0
            goto L_0x0086
        L_0x0064:
            android.graphics.Typeface r6 = android.graphics.Typeface.SANS_SERIF
            android.graphics.Typeface r6 = android.graphics.Typeface.create(r6, r7)
            goto L_0x0086
        L_0x006b:
            android.graphics.Typeface r6 = android.graphics.Typeface.SERIF
            android.graphics.Typeface r6 = android.graphics.Typeface.create(r6, r7)
            goto L_0x0086
        L_0x0072:
            android.graphics.Typeface r6 = android.graphics.Typeface.SANS_SERIF
            android.graphics.Typeface r6 = android.graphics.Typeface.create(r6, r7)
            goto L_0x0086
        L_0x0079:
            android.graphics.Typeface r6 = android.graphics.Typeface.MONOSPACE
            android.graphics.Typeface r6 = android.graphics.Typeface.create(r6, r7)
            goto L_0x0086
        L_0x0080:
            android.graphics.Typeface r6 = android.graphics.Typeface.SANS_SERIF
            android.graphics.Typeface r6 = android.graphics.Typeface.create(r6, r7)
        L_0x0086:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.caverock.androidsvg.d.t(java.lang.String, java.lang.Integer, com.caverock.androidsvg.SVG$Style$FontStyle):android.graphics.Typeface");
    }

    private void t0(SVG.u uVar) {
        y("Path render", new Object[0]);
        if (uVar.f9856o != null) {
            W0(this.f9982d, uVar);
            if (A() && Y0()) {
                h hVar = this.f9982d;
                if (hVar.f10020c || hVar.f10019b) {
                    Matrix matrix = uVar.f9812n;
                    if (matrix != null) {
                        this.f9979a.concat(matrix);
                    }
                    Path f10 = new C0114d(uVar.f9856o).f();
                    if (uVar.f9801h == null) {
                        uVar.f9801h = m(f10);
                    }
                    U0(uVar);
                    r(uVar);
                    p(uVar);
                    boolean m02 = m0();
                    if (this.f9982d.f10019b) {
                        f10.setFillType(U());
                        B(uVar, f10);
                    }
                    if (this.f9982d.f10020c) {
                        C(f10);
                    }
                    I0(uVar);
                    if (m02) {
                        j0(uVar);
                    }
                }
            }
        }
    }

    private void u(SVG.l0 l0Var) {
        Boolean bool;
        if ((l0Var instanceof SVG.j0) && (bool = ((SVG.j0) l0Var).f9808d) != null) {
            this.f9982d.f10025h = bool.booleanValue();
        }
    }

    private void u0(SVG.y yVar) {
        y("PolyLine render", new Object[0]);
        W0(this.f9982d, yVar);
        if (A() && Y0()) {
            h hVar = this.f9982d;
            if (hVar.f10020c || hVar.f10019b) {
                Matrix matrix = yVar.f9812n;
                if (matrix != null) {
                    this.f9979a.concat(matrix);
                }
                if (yVar.f9874o.length >= 2) {
                    Path b02 = b0(yVar);
                    U0(yVar);
                    b02.setFillType(U());
                    r(yVar);
                    p(yVar);
                    boolean m02 = m0();
                    if (this.f9982d.f10019b) {
                        B(yVar, b02);
                    }
                    if (this.f9982d.f10020c) {
                        C(b02);
                    }
                    I0(yVar);
                    if (m02) {
                        j0(yVar);
                    }
                }
            }
        }
    }

    private static double v(double d10) {
        if (d10 < -1.0d) {
            return 3.141592653589793d;
        }
        if (d10 > 1.0d) {
            return 0.0d;
        }
        return Math.acos(d10);
    }

    private void v0(SVG.z zVar) {
        y("Polygon render", new Object[0]);
        W0(this.f9982d, zVar);
        if (A() && Y0()) {
            h hVar = this.f9982d;
            if (hVar.f10020c || hVar.f10019b) {
                Matrix matrix = zVar.f9812n;
                if (matrix != null) {
                    this.f9979a.concat(matrix);
                }
                if (zVar.f9874o.length >= 2) {
                    Path b02 = b0(zVar);
                    U0(zVar);
                    r(zVar);
                    p(zVar);
                    boolean m02 = m0();
                    if (this.f9982d.f10019b) {
                        B(zVar, b02);
                    }
                    if (this.f9982d.f10020c) {
                        C(b02);
                    }
                    I0(zVar);
                    if (m02) {
                        j0(zVar);
                    }
                }
            }
        }
    }

    private static int w(float f10) {
        int i10 = (int) (f10 * 256.0f);
        if (i10 < 0) {
            return 0;
        }
        if (i10 > 255) {
            return 255;
        }
        return i10;
    }

    private void w0(SVG.a0 a0Var) {
        y("Rect render", new Object[0]);
        SVG.o oVar = a0Var.f9753q;
        if (oVar != null && a0Var.f9754r != null && !oVar.j() && !a0Var.f9754r.j()) {
            W0(this.f9982d, a0Var);
            if (A() && Y0()) {
                Matrix matrix = a0Var.f9812n;
                if (matrix != null) {
                    this.f9979a.concat(matrix);
                }
                Path c02 = c0(a0Var);
                U0(a0Var);
                r(a0Var);
                p(a0Var);
                boolean m02 = m0();
                if (this.f9982d.f10019b) {
                    B(a0Var, c02);
                }
                if (this.f9982d.f10020c) {
                    C(c02);
                }
                if (m02) {
                    j0(a0Var);
                }
            }
        }
    }

    private static int x(int i10, float f10) {
        int i11 = 255;
        int round = Math.round(((float) ((i10 >> 24) & 255)) * f10);
        if (round < 0) {
            i11 = 0;
        } else if (round <= 255) {
            i11 = round;
        }
        return (i10 & 16777215) | (i11 << 24);
    }

    private void x0(SVG.d0 d0Var) {
        z0(d0Var, f0(d0Var.f9776q, d0Var.f9777r, d0Var.f9778s, d0Var.f9779t), d0Var.f9838p, d0Var.f9826o);
    }

    /* access modifiers changed from: private */
    public static void y(String str, Object... objArr) {
    }

    private void y0(SVG.d0 d0Var, SVG.b bVar) {
        z0(d0Var, bVar, d0Var.f9838p, d0Var.f9826o);
    }

    private void z(boolean z10, SVG.b bVar, SVG.t tVar) {
        String str;
        SVG.l0 p10 = this.f9981c.p(tVar.f9853a);
        if (p10 == null) {
            Object[] objArr = new Object[2];
            if (z10) {
                str = "Fill";
            } else {
                str = "Stroke";
            }
            objArr[0] = str;
            objArr[1] = tVar.f9853a;
            F("%s reference '%s' not found", objArr);
            SVG.m0 m0Var = tVar.f9854b;
            if (m0Var != null) {
                P0(this.f9982d, z10, m0Var);
            } else if (z10) {
                this.f9982d.f10019b = false;
            } else {
                this.f9982d.f10020c = false;
            }
        } else if (p10 instanceof SVG.k0) {
            X(z10, bVar, (SVG.k0) p10);
        } else if (p10 instanceof SVG.o0) {
            e0(z10, bVar, (SVG.o0) p10);
        } else if (p10 instanceof SVG.b0) {
            Q0(z10, (SVG.b0) p10);
        }
    }

    private void z0(SVG.d0 d0Var, SVG.b bVar, SVG.b bVar2, PreserveAspectRatio preserveAspectRatio) {
        y("Svg render", new Object[0]);
        if (bVar.f9761c != 0.0f && bVar.f9762d != 0.0f) {
            if (preserveAspectRatio == null && (preserveAspectRatio = d0Var.f9826o) == null) {
                preserveAspectRatio = PreserveAspectRatio.f9651e;
            }
            W0(this.f9982d, d0Var);
            if (A()) {
                h hVar = this.f9982d;
                hVar.f10023f = bVar;
                if (!hVar.f10018a.C.booleanValue()) {
                    SVG.b bVar3 = this.f9982d.f10023f;
                    O0(bVar3.f9759a, bVar3.f9760b, bVar3.f9761c, bVar3.f9762d);
                }
                q(d0Var, this.f9982d.f10023f);
                if (bVar2 != null) {
                    this.f9979a.concat(o(this.f9982d.f10023f, bVar2, preserveAspectRatio));
                    this.f9982d.f10024g = d0Var.f9838p;
                } else {
                    Canvas canvas = this.f9979a;
                    SVG.b bVar4 = this.f9982d.f10023f;
                    canvas.translate(bVar4.f9759a, bVar4.f9760b);
                }
                boolean m02 = m0();
                X0();
                F0(d0Var, true);
                if (m02) {
                    j0(d0Var);
                }
                U0(d0Var);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void G0(SVG svg, c cVar) {
        SVG.b bVar;
        PreserveAspectRatio preserveAspectRatio;
        SVG.b bVar2;
        if (cVar != null) {
            this.f9981c = svg;
            SVG.d0 m10 = svg.m();
            if (m10 == null) {
                Z0("Nothing to render. Document is empty.", new Object[0]);
                return;
            }
            if (cVar.e()) {
                SVG.j0 j10 = this.f9981c.j(cVar.f9976e);
                if (j10 == null || !(j10 instanceof SVG.c1)) {
                    String.format("View element with id \"%s\" not found.", new Object[]{cVar.f9976e});
                    return;
                }
                SVG.c1 c1Var = (SVG.c1) j10;
                bVar = c1Var.f9838p;
                if (bVar == null) {
                    String.format("View element with id \"%s\" is missing a viewBox attribute.", new Object[]{cVar.f9976e});
                    return;
                }
                preserveAspectRatio = c1Var.f9826o;
            } else {
                if (cVar.f()) {
                    bVar2 = cVar.f9975d;
                } else {
                    bVar2 = m10.f9838p;
                }
                bVar = bVar2;
                if (cVar.c()) {
                    preserveAspectRatio = cVar.f9973b;
                } else {
                    preserveAspectRatio = m10.f9826o;
                }
            }
            if (cVar.b()) {
                svg.a(cVar.f9972a);
            }
            if (cVar.d()) {
                CSSParser.m mVar = new CSSParser.m();
                this.f9986h = mVar;
                mVar.f9641a = svg.j(cVar.f9974c);
            }
            N0();
            u(m10);
            S0();
            SVG.b bVar3 = new SVG.b(cVar.f9977f);
            SVG.o oVar = m10.f9778s;
            if (oVar != null) {
                bVar3.f9761c = oVar.d(this, bVar3.f9761c);
            }
            SVG.o oVar2 = m10.f9779t;
            if (oVar2 != null) {
                bVar3.f9762d = oVar2.d(this, bVar3.f9762d);
            }
            z0(m10, bVar3, bVar, preserveAspectRatio);
            R0();
            if (cVar.b()) {
                svg.b();
                return;
            }
            return;
        }
        throw new NullPointerException("renderOptions shouldn't be null");
    }

    /* access modifiers changed from: package-private */
    public float Q() {
        return this.f9982d.f10021d.getTextSize();
    }

    /* access modifiers changed from: package-private */
    public float R() {
        return this.f9982d.f10021d.getTextSize() / 2.0f;
    }

    /* access modifiers changed from: package-private */
    public SVG.b S() {
        h hVar = this.f9982d;
        SVG.b bVar = hVar.f10024g;
        if (bVar != null) {
            return bVar;
        }
        return hVar.f10023f;
    }

    /* access modifiers changed from: package-private */
    public float T() {
        return this.f9980b;
    }

    private class k extends j {

        /* renamed from: b  reason: collision with root package name */
        float f10032b;

        private k() {
            super(d.this, (a) null);
            this.f10032b = 0.0f;
        }

        public void b(String str) {
            this.f10032b += d.this.f9982d.f10021d.measureText(str);
        }

        /* synthetic */ k(d dVar, a aVar) {
            this();
        }
    }

    private class h {

        /* renamed from: a  reason: collision with root package name */
        SVG.Style f10018a;

        /* renamed from: b  reason: collision with root package name */
        boolean f10019b;

        /* renamed from: c  reason: collision with root package name */
        boolean f10020c;

        /* renamed from: d  reason: collision with root package name */
        Paint f10021d;

        /* renamed from: e  reason: collision with root package name */
        Paint f10022e;

        /* renamed from: f  reason: collision with root package name */
        SVG.b f10023f;

        /* renamed from: g  reason: collision with root package name */
        SVG.b f10024g;

        /* renamed from: h  reason: collision with root package name */
        boolean f10025h;

        h() {
            Paint paint = new Paint();
            this.f10021d = paint;
            paint.setFlags(Opcodes.INSTANCEOF);
            this.f10021d.setHinting(0);
            this.f10021d.setStyle(Paint.Style.FILL);
            this.f10021d.setTypeface(Typeface.DEFAULT);
            Paint paint2 = new Paint();
            this.f10022e = paint2;
            paint2.setFlags(Opcodes.INSTANCEOF);
            this.f10022e.setHinting(0);
            this.f10022e.setStyle(Paint.Style.STROKE);
            this.f10022e.setTypeface(Typeface.DEFAULT);
            this.f10018a = SVG.Style.a();
        }

        h(h hVar) {
            this.f10019b = hVar.f10019b;
            this.f10020c = hVar.f10020c;
            this.f10021d = new Paint(hVar.f10021d);
            this.f10022e = new Paint(hVar.f10022e);
            SVG.b bVar = hVar.f10023f;
            if (bVar != null) {
                this.f10023f = new SVG.b(bVar);
            }
            SVG.b bVar2 = hVar.f10024g;
            if (bVar2 != null) {
                this.f10024g = new SVG.b(bVar2);
            }
            this.f10025h = hVar.f10025h;
            try {
                this.f10018a = (SVG.Style) hVar.f10018a.clone();
            } catch (CloneNotSupportedException unused) {
                this.f10018a = SVG.Style.a();
            }
        }
    }
}
