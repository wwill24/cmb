package com.google.android.material.internal;

import android.animation.TimeInterpolator;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.text.f;
import androidx.core.util.h;
import androidx.core.view.e;
import androidx.core.view.n0;
import com.google.android.material.internal.StaticLayoutBuilderCompat;
import qf.a;
import qf.d;

public final class b {

    /* renamed from: u0  reason: collision with root package name */
    private static final boolean f19814u0 = false;
    @NonNull

    /* renamed from: v0  reason: collision with root package name */
    private static final Paint f19815v0 = null;
    private Typeface A;
    private Typeface B;
    private Typeface C;
    private qf.a D;
    private qf.a E;
    private TextUtils.TruncateAt F = TextUtils.TruncateAt.END;
    private CharSequence G;
    private CharSequence H;
    private boolean I;
    private boolean J = true;
    private boolean K;
    private Bitmap L;
    private Paint M;
    private float N;
    private float O;
    private float P;
    private float Q;
    private float R;
    private int S;
    private int[] T;
    private boolean U;
    @NonNull
    private final TextPaint V;
    @NonNull
    private final TextPaint W;
    private TimeInterpolator X;
    private TimeInterpolator Y;
    private float Z;

    /* renamed from: a  reason: collision with root package name */
    private final View f19816a;

    /* renamed from: a0  reason: collision with root package name */
    private float f19817a0;

    /* renamed from: b  reason: collision with root package name */
    private float f19818b;

    /* renamed from: b0  reason: collision with root package name */
    private float f19819b0;

    /* renamed from: c  reason: collision with root package name */
    private boolean f19820c;

    /* renamed from: c0  reason: collision with root package name */
    private ColorStateList f19821c0;

    /* renamed from: d  reason: collision with root package name */
    private float f19822d;

    /* renamed from: d0  reason: collision with root package name */
    private float f19823d0;

    /* renamed from: e  reason: collision with root package name */
    private float f19824e;

    /* renamed from: e0  reason: collision with root package name */
    private float f19825e0;

    /* renamed from: f  reason: collision with root package name */
    private int f19826f;

    /* renamed from: f0  reason: collision with root package name */
    private float f19827f0;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    private final Rect f19828g;

    /* renamed from: g0  reason: collision with root package name */
    private ColorStateList f19829g0;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    private final Rect f19830h;

    /* renamed from: h0  reason: collision with root package name */
    private float f19831h0;
    @NonNull

    /* renamed from: i  reason: collision with root package name */
    private final RectF f19832i;

    /* renamed from: i0  reason: collision with root package name */
    private float f19833i0;

    /* renamed from: j  reason: collision with root package name */
    private int f19834j = 16;

    /* renamed from: j0  reason: collision with root package name */
    private float f19835j0;

    /* renamed from: k  reason: collision with root package name */
    private int f19836k = 16;

    /* renamed from: k0  reason: collision with root package name */
    private StaticLayout f19837k0;

    /* renamed from: l  reason: collision with root package name */
    private float f19838l = 15.0f;

    /* renamed from: l0  reason: collision with root package name */
    private float f19839l0;

    /* renamed from: m  reason: collision with root package name */
    private float f19840m = 15.0f;

    /* renamed from: m0  reason: collision with root package name */
    private float f19841m0;

    /* renamed from: n  reason: collision with root package name */
    private ColorStateList f19842n;

    /* renamed from: n0  reason: collision with root package name */
    private float f19843n0;

    /* renamed from: o  reason: collision with root package name */
    private ColorStateList f19844o;

    /* renamed from: o0  reason: collision with root package name */
    private CharSequence f19845o0;

    /* renamed from: p  reason: collision with root package name */
    private int f19846p;

    /* renamed from: p0  reason: collision with root package name */
    private int f19847p0 = 1;

    /* renamed from: q  reason: collision with root package name */
    private float f19848q;

    /* renamed from: q0  reason: collision with root package name */
    private float f19849q0 = 0.0f;

    /* renamed from: r  reason: collision with root package name */
    private float f19850r;

    /* renamed from: r0  reason: collision with root package name */
    private float f19851r0 = 1.0f;

    /* renamed from: s  reason: collision with root package name */
    private float f19852s;

    /* renamed from: s0  reason: collision with root package name */
    private int f19853s0 = StaticLayoutBuilderCompat.f19792o;

    /* renamed from: t  reason: collision with root package name */
    private float f19854t;

    /* renamed from: t0  reason: collision with root package name */
    private m f19855t0;

    /* renamed from: u  reason: collision with root package name */
    private float f19856u;

    /* renamed from: v  reason: collision with root package name */
    private float f19857v;

    /* renamed from: w  reason: collision with root package name */
    private Typeface f19858w;

    /* renamed from: x  reason: collision with root package name */
    private Typeface f19859x;

    /* renamed from: y  reason: collision with root package name */
    private Typeface f19860y;

    /* renamed from: z  reason: collision with root package name */
    private Typeface f19861z;

    class a implements a.C0292a {
        a() {
        }

        public void a(Typeface typeface) {
            b.this.l0(typeface);
        }
    }

    /* renamed from: com.google.android.material.internal.b$b  reason: collision with other inner class name */
    class C0238b implements a.C0292a {
        C0238b() {
        }

        public void a(Typeface typeface) {
            b.this.w0(typeface);
        }
    }

    public b(View view) {
        this.f19816a = view;
        TextPaint textPaint = new TextPaint(129);
        this.V = textPaint;
        this.W = new TextPaint(textPaint);
        this.f19830h = new Rect();
        this.f19828g = new Rect();
        this.f19832i = new RectF();
        this.f19824e = e();
        Y(view.getContext().getResources().getConfiguration());
    }

    private void C0(float f10) {
        boolean z10;
        h(f10);
        if (!f19814u0 || this.N == 1.0f) {
            z10 = false;
        } else {
            z10 = true;
        }
        this.K = z10;
        if (z10) {
            n();
        }
        n0.j0(this.f19816a);
    }

    private Layout.Alignment M() {
        int b10 = e.b(this.f19834j, this.I ? 1 : 0) & 7;
        if (b10 == 1) {
            return Layout.Alignment.ALIGN_CENTER;
        }
        if (b10 != 5) {
            if (this.I) {
                return Layout.Alignment.ALIGN_OPPOSITE;
            }
            return Layout.Alignment.ALIGN_NORMAL;
        } else if (this.I) {
            return Layout.Alignment.ALIGN_NORMAL;
        } else {
            return Layout.Alignment.ALIGN_OPPOSITE;
        }
    }

    private boolean O0() {
        return this.f19847p0 > 1 && (!this.I || this.f19820c) && !this.K;
    }

    private void P(@NonNull TextPaint textPaint) {
        textPaint.setTextSize(this.f19840m);
        textPaint.setTypeface(this.f19858w);
        textPaint.setLetterSpacing(this.f19831h0);
    }

    private void Q(@NonNull TextPaint textPaint) {
        textPaint.setTextSize(this.f19838l);
        textPaint.setTypeface(this.f19861z);
        textPaint.setLetterSpacing(this.f19833i0);
    }

    private void S(float f10) {
        Rect rect;
        if (this.f19820c) {
            RectF rectF = this.f19832i;
            if (f10 < this.f19824e) {
                rect = this.f19828g;
            } else {
                rect = this.f19830h;
            }
            rectF.set(rect);
            return;
        }
        this.f19832i.left = X((float) this.f19828g.left, (float) this.f19830h.left, f10, this.X);
        this.f19832i.top = X(this.f19848q, this.f19850r, f10, this.X);
        this.f19832i.right = X((float) this.f19828g.right, (float) this.f19830h.right, f10, this.X);
        this.f19832i.bottom = X((float) this.f19828g.bottom, (float) this.f19830h.bottom, f10, this.X);
    }

    private static boolean T(float f10, float f11) {
        return Math.abs(f10 - f11) < 1.0E-5f;
    }

    private boolean U() {
        return n0.B(this.f19816a) == 1;
    }

    private boolean W(@NonNull CharSequence charSequence, boolean z10) {
        androidx.core.text.e eVar;
        if (z10) {
            eVar = f.f4725d;
        } else {
            eVar = f.f4724c;
        }
        return eVar.isRtl(charSequence, 0, charSequence.length());
    }

    private static float X(float f10, float f11, float f12, TimeInterpolator timeInterpolator) {
        if (timeInterpolator != null) {
            f12 = timeInterpolator.getInterpolation(f12);
        }
        return cf.a.a(f10, f11, f12);
    }

    private float Z(TextPaint textPaint, CharSequence charSequence) {
        return textPaint.measureText(charSequence, 0, charSequence.length());
    }

    private static int a(int i10, int i11, float f10) {
        float f11 = 1.0f - f10;
        return Color.argb(Math.round((((float) Color.alpha(i10)) * f11) + (((float) Color.alpha(i11)) * f10)), Math.round((((float) Color.red(i10)) * f11) + (((float) Color.red(i11)) * f10)), Math.round((((float) Color.green(i10)) * f11) + (((float) Color.green(i11)) * f10)), Math.round((((float) Color.blue(i10)) * f11) + (((float) Color.blue(i11)) * f10)));
    }

    private void b(boolean z10) {
        float f10;
        int i10;
        StaticLayout staticLayout;
        i(1.0f, z10);
        CharSequence charSequence = this.H;
        if (!(charSequence == null || (staticLayout = this.f19837k0) == null)) {
            this.f19845o0 = TextUtils.ellipsize(charSequence, this.V, (float) staticLayout.getWidth(), this.F);
        }
        CharSequence charSequence2 = this.f19845o0;
        float f11 = 0.0f;
        if (charSequence2 != null) {
            this.f19839l0 = Z(this.V, charSequence2);
        } else {
            this.f19839l0 = 0.0f;
        }
        int b10 = e.b(this.f19836k, this.I ? 1 : 0);
        int i11 = b10 & 112;
        if (i11 == 48) {
            this.f19850r = (float) this.f19830h.top;
        } else if (i11 != 80) {
            this.f19850r = ((float) this.f19830h.centerY()) - ((this.V.descent() - this.V.ascent()) / 2.0f);
        } else {
            this.f19850r = ((float) this.f19830h.bottom) + this.V.ascent();
        }
        int i12 = b10 & 8388615;
        if (i12 == 1) {
            this.f19854t = ((float) this.f19830h.centerX()) - (this.f19839l0 / 2.0f);
        } else if (i12 != 5) {
            this.f19854t = (float) this.f19830h.left;
        } else {
            this.f19854t = ((float) this.f19830h.right) - this.f19839l0;
        }
        i(0.0f, z10);
        StaticLayout staticLayout2 = this.f19837k0;
        if (staticLayout2 != null) {
            f10 = (float) staticLayout2.getHeight();
        } else {
            f10 = 0.0f;
        }
        StaticLayout staticLayout3 = this.f19837k0;
        if (staticLayout3 == null || this.f19847p0 <= 1) {
            CharSequence charSequence3 = this.H;
            if (charSequence3 != null) {
                f11 = Z(this.V, charSequence3);
            }
        } else {
            f11 = (float) staticLayout3.getWidth();
        }
        StaticLayout staticLayout4 = this.f19837k0;
        if (staticLayout4 != null) {
            i10 = staticLayout4.getLineCount();
        } else {
            i10 = 0;
        }
        this.f19846p = i10;
        int b11 = e.b(this.f19834j, this.I ? 1 : 0);
        int i13 = b11 & 112;
        if (i13 == 48) {
            this.f19848q = (float) this.f19828g.top;
        } else if (i13 != 80) {
            this.f19848q = ((float) this.f19828g.centerY()) - (f10 / 2.0f);
        } else {
            this.f19848q = (((float) this.f19828g.bottom) - f10) + this.V.descent();
        }
        int i14 = b11 & 8388615;
        if (i14 == 1) {
            this.f19852s = ((float) this.f19828g.centerX()) - (f11 / 2.0f);
        } else if (i14 != 5) {
            this.f19852s = (float) this.f19828g.left;
        } else {
            this.f19852s = ((float) this.f19828g.right) - f11;
        }
        j();
        C0(this.f19818b);
    }

    private void c() {
        g(this.f19818b);
    }

    private static boolean c0(@NonNull Rect rect, int i10, int i11, int i12, int i13) {
        return rect.left == i10 && rect.top == i11 && rect.right == i12 && rect.bottom == i13;
    }

    private float d(float f10) {
        float f11 = this.f19824e;
        if (f10 <= f11) {
            return cf.a.b(1.0f, 0.0f, this.f19822d, f11, f10);
        }
        return cf.a.b(0.0f, 1.0f, f11, 1.0f, f10);
    }

    private float e() {
        float f10 = this.f19822d;
        return f10 + ((1.0f - f10) * 0.5f);
    }

    private boolean f(@NonNull CharSequence charSequence) {
        boolean U2 = U();
        if (this.J) {
            return W(charSequence, U2);
        }
        return U2;
    }

    private void g(float f10) {
        float f11;
        S(f10);
        if (!this.f19820c) {
            this.f19856u = X(this.f19852s, this.f19854t, f10, this.X);
            this.f19857v = X(this.f19848q, this.f19850r, f10, this.X);
            C0(f10);
            f11 = f10;
        } else if (f10 < this.f19824e) {
            this.f19856u = this.f19852s;
            this.f19857v = this.f19848q;
            C0(0.0f);
            f11 = 0.0f;
        } else {
            this.f19856u = this.f19854t;
            this.f19857v = this.f19850r - ((float) Math.max(0, this.f19826f));
            C0(1.0f);
            f11 = 1.0f;
        }
        TimeInterpolator timeInterpolator = cf.a.f18978b;
        h0(1.0f - X(0.0f, 1.0f, 1.0f - f10, timeInterpolator));
        s0(X(1.0f, 0.0f, f10, timeInterpolator));
        if (this.f19844o != this.f19842n) {
            this.V.setColor(a(y(), w(), f11));
        } else {
            this.V.setColor(w());
        }
        float f12 = this.f19831h0;
        float f13 = this.f19833i0;
        if (f12 != f13) {
            this.V.setLetterSpacing(X(f13, f12, f10, timeInterpolator));
        } else {
            this.V.setLetterSpacing(f12);
        }
        this.P = X(this.f19823d0, this.Z, f10, (TimeInterpolator) null);
        this.Q = X(this.f19825e0, this.f19817a0, f10, (TimeInterpolator) null);
        this.R = X(this.f19827f0, this.f19819b0, f10, (TimeInterpolator) null);
        int a10 = a(x(this.f19829g0), x(this.f19821c0), f10);
        this.S = a10;
        this.V.setShadowLayer(this.P, this.Q, this.R, a10);
        if (this.f19820c) {
            this.V.setAlpha((int) (d(f10) * ((float) this.V.getAlpha())));
        }
        n0.j0(this.f19816a);
    }

    private void h(float f10) {
        i(f10, false);
    }

    private void h0(float f10) {
        this.f19841m0 = f10;
        n0.j0(this.f19816a);
    }

    private void i(float f10, boolean z10) {
        float f11;
        float f12;
        Typeface typeface;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        if (this.G != null) {
            float width = (float) this.f19830h.width();
            float width2 = (float) this.f19828g.width();
            if (T(f10, 1.0f)) {
                f12 = this.f19840m;
                f11 = this.f19831h0;
                this.N = 1.0f;
                typeface = this.f19858w;
            } else {
                float f13 = this.f19838l;
                float f14 = this.f19833i0;
                Typeface typeface2 = this.f19861z;
                if (T(f10, 0.0f)) {
                    this.N = 1.0f;
                } else {
                    this.N = X(this.f19838l, this.f19840m, f10, this.Y) / this.f19838l;
                }
                float f15 = this.f19840m / this.f19838l;
                float f16 = width2 * f15;
                if (!z10 && f16 > width) {
                    width = Math.min(width / f15, width2);
                } else {
                    width = width2;
                }
                f12 = f13;
                f11 = f14;
                typeface = typeface2;
            }
            int i10 = 1;
            boolean z16 = false;
            if (width > 0.0f) {
                if (this.O != f12) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (this.f19835j0 != f11) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                if (this.C != typeface) {
                    z13 = true;
                } else {
                    z13 = false;
                }
                StaticLayout staticLayout = this.f19837k0;
                if (staticLayout == null || width == ((float) staticLayout.getWidth())) {
                    z14 = false;
                } else {
                    z14 = true;
                }
                if (z11 || z12 || z14 || z13 || this.U) {
                    z15 = true;
                } else {
                    z15 = false;
                }
                this.O = f12;
                this.f19835j0 = f11;
                this.C = typeface;
                this.U = false;
                TextPaint textPaint = this.V;
                if (this.N != 1.0f) {
                    z16 = true;
                }
                textPaint.setLinearText(z16);
                z16 = z15;
            }
            if (this.H == null || z16) {
                this.V.setTextSize(this.O);
                this.V.setTypeface(this.C);
                this.V.setLetterSpacing(this.f19835j0);
                this.I = f(this.G);
                if (O0()) {
                    i10 = this.f19847p0;
                }
                StaticLayout k10 = k(i10, width, this.I);
                this.f19837k0 = k10;
                this.H = k10.getText();
            }
        }
    }

    private void j() {
        Bitmap bitmap = this.L;
        if (bitmap != null) {
            bitmap.recycle();
            this.L = null;
        }
    }

    private StaticLayout k(int i10, float f10, boolean z10) {
        StaticLayout staticLayout;
        Layout.Alignment alignment;
        if (i10 == 1) {
            try {
                alignment = Layout.Alignment.ALIGN_NORMAL;
            } catch (StaticLayoutBuilderCompat.StaticLayoutBuilderCompatException e10) {
                e10.getCause().getMessage();
                staticLayout = null;
            }
        } else {
            alignment = M();
        }
        staticLayout = StaticLayoutBuilderCompat.b(this.G, this.V, (int) f10).d(this.F).g(z10).c(alignment).f(false).i(i10).h(this.f19849q0, this.f19851r0).e(this.f19853s0).j(this.f19855t0).a();
        return (StaticLayout) h.g(staticLayout);
    }

    private void m(@NonNull Canvas canvas, float f10, float f11) {
        int alpha = this.V.getAlpha();
        canvas.translate(f10, f11);
        float f12 = (float) alpha;
        this.V.setAlpha((int) (this.f19843n0 * f12));
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 31) {
            TextPaint textPaint = this.V;
            textPaint.setShadowLayer(this.P, this.Q, this.R, hf.a.a(this.S, textPaint.getAlpha()));
        }
        Canvas canvas2 = canvas;
        this.f19837k0.draw(canvas);
        this.V.setAlpha((int) (this.f19841m0 * f12));
        if (i10 >= 31) {
            TextPaint textPaint2 = this.V;
            textPaint2.setShadowLayer(this.P, this.Q, this.R, hf.a.a(this.S, textPaint2.getAlpha()));
        }
        int lineBaseline = this.f19837k0.getLineBaseline(0);
        CharSequence charSequence = this.f19845o0;
        float f13 = (float) lineBaseline;
        canvas.drawText(charSequence, 0, charSequence.length(), 0.0f, f13, this.V);
        if (i10 >= 31) {
            this.V.setShadowLayer(this.P, this.Q, this.R, this.S);
        }
        if (!this.f19820c) {
            String trim = this.f19845o0.toString().trim();
            if (trim.endsWith("…")) {
                trim = trim.substring(0, trim.length() - 1);
            }
            String str = trim;
            this.V.setAlpha(alpha);
            canvas.drawText(str, 0, Math.min(this.f19837k0.getLineEnd(0), str.length()), 0.0f, f13, this.V);
        }
    }

    private boolean m0(Typeface typeface) {
        qf.a aVar = this.E;
        if (aVar != null) {
            aVar.c();
        }
        if (this.f19860y == typeface) {
            return false;
        }
        this.f19860y = typeface;
        Typeface b10 = qf.h.b(this.f19816a.getContext().getResources().getConfiguration(), typeface);
        this.f19859x = b10;
        if (b10 == null) {
            b10 = this.f19860y;
        }
        this.f19858w = b10;
        return true;
    }

    private void n() {
        if (this.L == null && !this.f19828g.isEmpty() && !TextUtils.isEmpty(this.H)) {
            g(0.0f);
            int width = this.f19837k0.getWidth();
            int height = this.f19837k0.getHeight();
            if (width > 0 && height > 0) {
                this.L = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
                this.f19837k0.draw(new Canvas(this.L));
                if (this.M == null) {
                    this.M = new Paint(3);
                }
            }
        }
    }

    private float s(int i10, int i11) {
        if (i11 == 17 || (i11 & 7) == 1) {
            return (((float) i10) / 2.0f) - (this.f19839l0 / 2.0f);
        }
        if ((i11 & 8388613) == 8388613 || (i11 & 5) == 5) {
            if (this.I) {
                return (float) this.f19830h.left;
            }
            return ((float) this.f19830h.right) - this.f19839l0;
        } else if (this.I) {
            return ((float) this.f19830h.right) - this.f19839l0;
        } else {
            return (float) this.f19830h.left;
        }
    }

    private void s0(float f10) {
        this.f19843n0 = f10;
        n0.j0(this.f19816a);
    }

    private float t(@NonNull RectF rectF, int i10, int i11) {
        if (i11 == 17 || (i11 & 7) == 1) {
            return (((float) i10) / 2.0f) + (this.f19839l0 / 2.0f);
        }
        if ((i11 & 8388613) == 8388613 || (i11 & 5) == 5) {
            if (this.I) {
                return rectF.left + this.f19839l0;
            }
            return (float) this.f19830h.right;
        } else if (this.I) {
            return (float) this.f19830h.right;
        } else {
            return rectF.left + this.f19839l0;
        }
    }

    private int x(ColorStateList colorStateList) {
        if (colorStateList == null) {
            return 0;
        }
        int[] iArr = this.T;
        if (iArr != null) {
            return colorStateList.getColorForState(iArr, 0);
        }
        return colorStateList.getDefaultColor();
    }

    private boolean x0(Typeface typeface) {
        qf.a aVar = this.D;
        if (aVar != null) {
            aVar.c();
        }
        if (this.B == typeface) {
            return false;
        }
        this.B = typeface;
        Typeface b10 = qf.h.b(this.f19816a.getContext().getResources().getConfiguration(), typeface);
        this.A = b10;
        if (b10 == null) {
            b10 = this.B;
        }
        this.f19861z = b10;
        return true;
    }

    private int y() {
        return x(this.f19842n);
    }

    public float A() {
        Q(this.W);
        return (-this.W.ascent()) + this.W.descent();
    }

    public void A0(float f10) {
        this.f19822d = f10;
        this.f19824e = e();
    }

    public int B() {
        return this.f19834j;
    }

    public void B0(int i10) {
        this.f19853s0 = i10;
    }

    public float C() {
        Q(this.W);
        return -this.W.ascent();
    }

    public float D() {
        return this.f19838l;
    }

    public void D0(float f10) {
        this.f19849q0 = f10;
    }

    public Typeface E() {
        Typeface typeface = this.f19861z;
        return typeface != null ? typeface : Typeface.DEFAULT;
    }

    public void E0(float f10) {
        this.f19851r0 = f10;
    }

    public float F() {
        return this.f19818b;
    }

    public void F0(int i10) {
        if (i10 != this.f19847p0) {
            this.f19847p0 = i10;
            j();
            a0();
        }
    }

    public float G() {
        return this.f19824e;
    }

    public void G0(TimeInterpolator timeInterpolator) {
        this.X = timeInterpolator;
        a0();
    }

    public int H() {
        return this.f19853s0;
    }

    public void H0(boolean z10) {
        this.J = z10;
    }

    public int I() {
        StaticLayout staticLayout = this.f19837k0;
        if (staticLayout != null) {
            return staticLayout.getLineCount();
        }
        return 0;
    }

    public final boolean I0(int[] iArr) {
        this.T = iArr;
        if (!V()) {
            return false;
        }
        a0();
        return true;
    }

    public float J() {
        return this.f19837k0.getSpacingAdd();
    }

    public void J0(m mVar) {
        if (this.f19855t0 != mVar) {
            this.f19855t0 = mVar;
            b0(true);
        }
    }

    public float K() {
        return this.f19837k0.getSpacingMultiplier();
    }

    public void K0(CharSequence charSequence) {
        if (charSequence == null || !TextUtils.equals(this.G, charSequence)) {
            this.G = charSequence;
            this.H = null;
            j();
            a0();
        }
    }

    public int L() {
        return this.f19847p0;
    }

    public void L0(TimeInterpolator timeInterpolator) {
        this.Y = timeInterpolator;
        a0();
    }

    public void M0(@NonNull TextUtils.TruncateAt truncateAt) {
        this.F = truncateAt;
        a0();
    }

    public TimeInterpolator N() {
        return this.X;
    }

    public void N0(Typeface typeface) {
        boolean m02 = m0(typeface);
        boolean x02 = x0(typeface);
        if (m02 || x02) {
            a0();
        }
    }

    public CharSequence O() {
        return this.G;
    }

    @NonNull
    public TextUtils.TruncateAt R() {
        return this.F;
    }

    public final boolean V() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2 = this.f19844o;
        if ((colorStateList2 == null || !colorStateList2.isStateful()) && ((colorStateList = this.f19842n) == null || !colorStateList.isStateful())) {
            return false;
        }
        return true;
    }

    public void Y(@NonNull Configuration configuration) {
        if (Build.VERSION.SDK_INT >= 31) {
            Typeface typeface = this.f19860y;
            if (typeface != null) {
                this.f19859x = qf.h.b(configuration, typeface);
            }
            Typeface typeface2 = this.B;
            if (typeface2 != null) {
                this.A = qf.h.b(configuration, typeface2);
            }
            Typeface typeface3 = this.f19859x;
            if (typeface3 == null) {
                typeface3 = this.f19860y;
            }
            this.f19858w = typeface3;
            Typeface typeface4 = this.A;
            if (typeface4 == null) {
                typeface4 = this.B;
            }
            this.f19861z = typeface4;
            b0(true);
        }
    }

    public void a0() {
        b0(false);
    }

    public void b0(boolean z10) {
        if ((this.f19816a.getHeight() > 0 && this.f19816a.getWidth() > 0) || z10) {
            b(z10);
            c();
        }
    }

    public void d0(ColorStateList colorStateList) {
        if (this.f19844o != colorStateList || this.f19842n != colorStateList) {
            this.f19844o = colorStateList;
            this.f19842n = colorStateList;
            a0();
        }
    }

    public void e0(int i10, int i11, int i12, int i13) {
        if (!c0(this.f19830h, i10, i11, i12, i13)) {
            this.f19830h.set(i10, i11, i12, i13);
            this.U = true;
        }
    }

    public void f0(@NonNull Rect rect) {
        e0(rect.left, rect.top, rect.right, rect.bottom);
    }

    public void g0(int i10) {
        d dVar = new d(this.f19816a.getContext(), i10);
        if (dVar.i() != null) {
            this.f19844o = dVar.i();
        }
        if (dVar.j() != 0.0f) {
            this.f19840m = dVar.j();
        }
        ColorStateList colorStateList = dVar.f24415c;
        if (colorStateList != null) {
            this.f19821c0 = colorStateList;
        }
        this.f19817a0 = dVar.f24420h;
        this.f19819b0 = dVar.f24421i;
        this.Z = dVar.f24422j;
        this.f19831h0 = dVar.f24424l;
        qf.a aVar = this.E;
        if (aVar != null) {
            aVar.c();
        }
        this.E = new qf.a(new a(), dVar.e());
        dVar.h(this.f19816a.getContext(), this.E);
        a0();
    }

    public void i0(ColorStateList colorStateList) {
        if (this.f19844o != colorStateList) {
            this.f19844o = colorStateList;
            a0();
        }
    }

    public void j0(int i10) {
        if (this.f19836k != i10) {
            this.f19836k = i10;
            a0();
        }
    }

    public void k0(float f10) {
        if (this.f19840m != f10) {
            this.f19840m = f10;
            a0();
        }
    }

    public void l(@NonNull Canvas canvas) {
        boolean z10;
        int save = canvas.save();
        if (this.H != null && this.f19832i.width() > 0.0f && this.f19832i.height() > 0.0f) {
            this.V.setTextSize(this.O);
            float f10 = this.f19856u;
            float f11 = this.f19857v;
            if (!this.K || this.L == null) {
                z10 = false;
            } else {
                z10 = true;
            }
            float f12 = this.N;
            if (f12 != 1.0f && !this.f19820c) {
                canvas.scale(f12, f12, f10, f11);
            }
            if (z10) {
                canvas.drawBitmap(this.L, f10, f11, this.M);
                canvas.restoreToCount(save);
                return;
            }
            if (!O0() || (this.f19820c && this.f19818b <= this.f19824e)) {
                canvas.translate(f10, f11);
                this.f19837k0.draw(canvas);
            } else {
                m(canvas, this.f19856u - ((float) this.f19837k0.getLineStart(0)), f11);
            }
            canvas.restoreToCount(save);
        }
    }

    public void l0(Typeface typeface) {
        if (m0(typeface)) {
            a0();
        }
    }

    public void n0(int i10) {
        this.f19826f = i10;
    }

    public void o(@NonNull RectF rectF, int i10, int i11) {
        this.I = f(this.G);
        rectF.left = Math.max(s(i10, i11), (float) this.f19830h.left);
        rectF.top = (float) this.f19830h.top;
        rectF.right = Math.min(t(rectF, i10, i11), (float) this.f19830h.right);
        rectF.bottom = ((float) this.f19830h.top) + r();
    }

    public void o0(int i10, int i11, int i12, int i13) {
        if (!c0(this.f19828g, i10, i11, i12, i13)) {
            this.f19828g.set(i10, i11, i12, i13);
            this.U = true;
        }
    }

    public ColorStateList p() {
        return this.f19844o;
    }

    public void p0(@NonNull Rect rect) {
        o0(rect.left, rect.top, rect.right, rect.bottom);
    }

    public int q() {
        return this.f19836k;
    }

    public void q0(float f10) {
        if (this.f19833i0 != f10) {
            this.f19833i0 = f10;
            a0();
        }
    }

    public float r() {
        P(this.W);
        return -this.W.ascent();
    }

    public void r0(int i10) {
        d dVar = new d(this.f19816a.getContext(), i10);
        if (dVar.i() != null) {
            this.f19842n = dVar.i();
        }
        if (dVar.j() != 0.0f) {
            this.f19838l = dVar.j();
        }
        ColorStateList colorStateList = dVar.f24415c;
        if (colorStateList != null) {
            this.f19829g0 = colorStateList;
        }
        this.f19825e0 = dVar.f24420h;
        this.f19827f0 = dVar.f24421i;
        this.f19823d0 = dVar.f24422j;
        this.f19833i0 = dVar.f24424l;
        qf.a aVar = this.D;
        if (aVar != null) {
            aVar.c();
        }
        this.D = new qf.a(new C0238b(), dVar.e());
        dVar.h(this.f19816a.getContext(), this.D);
        a0();
    }

    public void t0(ColorStateList colorStateList) {
        if (this.f19842n != colorStateList) {
            this.f19842n = colorStateList;
            a0();
        }
    }

    public float u() {
        return this.f19840m;
    }

    public void u0(int i10) {
        if (this.f19834j != i10) {
            this.f19834j = i10;
            a0();
        }
    }

    public Typeface v() {
        Typeface typeface = this.f19858w;
        return typeface != null ? typeface : Typeface.DEFAULT;
    }

    public void v0(float f10) {
        if (this.f19838l != f10) {
            this.f19838l = f10;
            a0();
        }
    }

    public int w() {
        return x(this.f19844o);
    }

    public void w0(Typeface typeface) {
        if (x0(typeface)) {
            a0();
        }
    }

    public void y0(float f10) {
        float a10 = v0.a.a(f10, 0.0f, 1.0f);
        if (a10 != this.f19818b) {
            this.f19818b = a10;
            c();
        }
    }

    public int z() {
        return this.f19846p;
    }

    public void z0(boolean z10) {
        this.f19820c = z10;
    }
}
