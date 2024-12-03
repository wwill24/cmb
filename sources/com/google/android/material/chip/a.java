package com.google.android.material.chip;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import bf.l;
import cf.h;
import com.google.android.gms.common.api.a;
import com.google.android.material.internal.n;
import com.google.android.material.internal.p;
import com.google.android.material.internal.r;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import net.bytebuddy.jar.asm.Opcodes;
import qf.c;
import qf.d;
import rf.b;
import tf.g;

public class a extends g implements Drawable.Callback, n.b {
    private static final int[] Q0 = {16842910};
    private static final ShapeDrawable R0 = new ShapeDrawable(new OvalShape());
    private int A0;
    private boolean B0;
    private int C0;
    private int D0 = 255;
    private ColorFilter E0;
    private PorterDuffColorFilter F0;
    private ColorStateList G;
    private ColorStateList G0;
    private ColorStateList H;
    private PorterDuff.Mode H0 = PorterDuff.Mode.SRC_IN;
    private float I;
    private int[] I0;
    private float J = -1.0f;
    private boolean J0;
    private ColorStateList K;
    private ColorStateList K0;
    private float L;
    @NonNull
    private WeakReference<C0234a> L0 = new WeakReference<>((Object) null);
    private ColorStateList M;
    private TextUtils.TruncateAt M0;
    private CharSequence N;
    private boolean N0;
    private boolean O;
    private int O0;
    private Drawable P;
    private boolean P0;
    private ColorStateList Q;
    private float R;
    private boolean S;
    private boolean T;
    private Drawable U;
    private Drawable V;
    private ColorStateList W;
    private float X;
    private CharSequence Y;
    private boolean Z;

    /* renamed from: a0  reason: collision with root package name */
    private boolean f19470a0;

    /* renamed from: b0  reason: collision with root package name */
    private Drawable f19471b0;

    /* renamed from: c0  reason: collision with root package name */
    private ColorStateList f19472c0;

    /* renamed from: d0  reason: collision with root package name */
    private h f19473d0;

    /* renamed from: e0  reason: collision with root package name */
    private h f19474e0;

    /* renamed from: f0  reason: collision with root package name */
    private float f19475f0;

    /* renamed from: g0  reason: collision with root package name */
    private float f19476g0;

    /* renamed from: h0  reason: collision with root package name */
    private float f19477h0;

    /* renamed from: i0  reason: collision with root package name */
    private float f19478i0;

    /* renamed from: j0  reason: collision with root package name */
    private float f19479j0;

    /* renamed from: k0  reason: collision with root package name */
    private float f19480k0;

    /* renamed from: l0  reason: collision with root package name */
    private float f19481l0;

    /* renamed from: m0  reason: collision with root package name */
    private float f19482m0;
    @NonNull

    /* renamed from: n0  reason: collision with root package name */
    private final Context f19483n0;

    /* renamed from: o0  reason: collision with root package name */
    private final Paint f19484o0 = new Paint(1);

    /* renamed from: p0  reason: collision with root package name */
    private final Paint f19485p0;

    /* renamed from: q0  reason: collision with root package name */
    private final Paint.FontMetrics f19486q0 = new Paint.FontMetrics();

    /* renamed from: r0  reason: collision with root package name */
    private final RectF f19487r0 = new RectF();

    /* renamed from: s0  reason: collision with root package name */
    private final PointF f19488s0 = new PointF();

    /* renamed from: t0  reason: collision with root package name */
    private final Path f19489t0 = new Path();
    @NonNull

    /* renamed from: u0  reason: collision with root package name */
    private final n f19490u0;

    /* renamed from: v0  reason: collision with root package name */
    private int f19491v0;

    /* renamed from: w0  reason: collision with root package name */
    private int f19492w0;

    /* renamed from: x0  reason: collision with root package name */
    private int f19493x0;

    /* renamed from: y0  reason: collision with root package name */
    private int f19494y0;

    /* renamed from: z0  reason: collision with root package name */
    private int f19495z0;

    /* renamed from: com.google.android.material.chip.a$a  reason: collision with other inner class name */
    public interface C0234a {
        void a();
    }

    private a(@NonNull Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        Q(context);
        this.f19483n0 = context;
        n nVar = new n(this);
        this.f19490u0 = nVar;
        this.N = "";
        nVar.e().density = context.getResources().getDisplayMetrics().density;
        this.f19485p0 = null;
        int[] iArr = Q0;
        setState(iArr);
        p2(iArr);
        this.N0 = true;
        if (b.f24443a) {
            R0.setTint(-1);
        }
    }

    private void A0(@NonNull Canvas canvas, @NonNull Rect rect) {
        if (R2()) {
            p0(rect, this.f19487r0);
            RectF rectF = this.f19487r0;
            float f10 = rectF.left;
            float f11 = rectF.top;
            canvas.translate(f10, f11);
            this.f19471b0.setBounds(0, 0, (int) this.f19487r0.width(), (int) this.f19487r0.height());
            this.f19471b0.draw(canvas);
            canvas.translate(-f10, -f11);
        }
    }

    private boolean A1(@NonNull int[] iArr, @NonNull int[] iArr2) {
        int i10;
        int i11;
        boolean z10;
        boolean z11;
        int i12;
        int i13;
        int i14;
        boolean z12;
        boolean z13;
        int i15;
        boolean onStateChange = super.onStateChange(iArr);
        ColorStateList colorStateList = this.G;
        if (colorStateList != null) {
            i10 = colorStateList.getColorForState(iArr, this.f19491v0);
        } else {
            i10 = 0;
        }
        int l10 = l(i10);
        boolean z14 = true;
        if (this.f19491v0 != l10) {
            this.f19491v0 = l10;
            onStateChange = true;
        }
        ColorStateList colorStateList2 = this.H;
        if (colorStateList2 != null) {
            i11 = colorStateList2.getColorForState(iArr, this.f19492w0);
        } else {
            i11 = 0;
        }
        int l11 = l(i11);
        if (this.f19492w0 != l11) {
            this.f19492w0 = l11;
            onStateChange = true;
        }
        int h10 = hf.a.h(l10, l11);
        if (this.f19493x0 != h10) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (x() == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 || z11) {
            this.f19493x0 = h10;
            b0(ColorStateList.valueOf(h10));
            onStateChange = true;
        }
        ColorStateList colorStateList3 = this.K;
        if (colorStateList3 != null) {
            i12 = colorStateList3.getColorForState(iArr, this.f19494y0);
        } else {
            i12 = 0;
        }
        if (this.f19494y0 != i12) {
            this.f19494y0 = i12;
            onStateChange = true;
        }
        if (this.K0 == null || !b.e(iArr)) {
            i13 = 0;
        } else {
            i13 = this.K0.getColorForState(iArr, this.f19495z0);
        }
        if (this.f19495z0 != i13) {
            this.f19495z0 = i13;
            if (this.J0) {
                onStateChange = true;
            }
        }
        if (this.f19490u0.d() == null || this.f19490u0.d().i() == null) {
            i14 = 0;
        } else {
            i14 = this.f19490u0.d().i().getColorForState(iArr, this.A0);
        }
        if (this.A0 != i14) {
            this.A0 = i14;
            onStateChange = true;
        }
        if (!r1(getState(), 16842912) || !this.Z) {
            z12 = false;
        } else {
            z12 = true;
        }
        if (this.B0 == z12 || this.f19471b0 == null) {
            z13 = false;
        } else {
            float q02 = q0();
            this.B0 = z12;
            if (q02 != q0()) {
                onStateChange = true;
                z13 = true;
            } else {
                z13 = false;
                onStateChange = true;
            }
        }
        ColorStateList colorStateList4 = this.G0;
        if (colorStateList4 != null) {
            i15 = colorStateList4.getColorForState(iArr, this.C0);
        } else {
            i15 = 0;
        }
        if (this.C0 != i15) {
            this.C0 = i15;
            this.F0 = jf.b.h(this, this.G0, this.H0);
        } else {
            z14 = onStateChange;
        }
        if (w1(this.P)) {
            z14 |= this.P.setState(iArr);
        }
        if (w1(this.f19471b0)) {
            z14 |= this.f19471b0.setState(iArr);
        }
        if (w1(this.U)) {
            int[] iArr3 = new int[(iArr.length + iArr2.length)];
            System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
            System.arraycopy(iArr2, 0, iArr3, iArr.length, iArr2.length);
            z14 |= this.U.setState(iArr3);
        }
        if (b.f24443a && w1(this.V)) {
            z14 |= this.V.setState(iArr2);
        }
        if (z14) {
            invalidateSelf();
        }
        if (z13) {
            z1();
        }
        return z14;
    }

    private void B0(@NonNull Canvas canvas, @NonNull Rect rect) {
        if (!this.P0) {
            this.f19484o0.setColor(this.f19492w0);
            this.f19484o0.setStyle(Paint.Style.FILL);
            this.f19484o0.setColorFilter(p1());
            this.f19487r0.set(rect);
            canvas.drawRoundRect(this.f19487r0, M0(), M0(), this.f19484o0);
        }
    }

    private void C0(@NonNull Canvas canvas, @NonNull Rect rect) {
        if (S2()) {
            p0(rect, this.f19487r0);
            RectF rectF = this.f19487r0;
            float f10 = rectF.left;
            float f11 = rectF.top;
            canvas.translate(f10, f11);
            this.P.setBounds(0, 0, (int) this.f19487r0.width(), (int) this.f19487r0.height());
            this.P.draw(canvas);
            canvas.translate(-f10, -f11);
        }
    }

    private void D0(@NonNull Canvas canvas, @NonNull Rect rect) {
        if (this.L > 0.0f && !this.P0) {
            this.f19484o0.setColor(this.f19494y0);
            this.f19484o0.setStyle(Paint.Style.STROKE);
            if (!this.P0) {
                this.f19484o0.setColorFilter(p1());
            }
            RectF rectF = this.f19487r0;
            float f10 = this.L;
            rectF.set(((float) rect.left) + (f10 / 2.0f), ((float) rect.top) + (f10 / 2.0f), ((float) rect.right) - (f10 / 2.0f), ((float) rect.bottom) - (f10 / 2.0f));
            float f11 = this.J - (this.L / 2.0f);
            canvas.drawRoundRect(this.f19487r0, f11, f11, this.f19484o0);
        }
    }

    private void E0(@NonNull Canvas canvas, @NonNull Rect rect) {
        if (!this.P0) {
            this.f19484o0.setColor(this.f19491v0);
            this.f19484o0.setStyle(Paint.Style.FILL);
            this.f19487r0.set(rect);
            canvas.drawRoundRect(this.f19487r0, M0(), M0(), this.f19484o0);
        }
    }

    private void F0(@NonNull Canvas canvas, @NonNull Rect rect) {
        if (T2()) {
            s0(rect, this.f19487r0);
            RectF rectF = this.f19487r0;
            float f10 = rectF.left;
            float f11 = rectF.top;
            canvas.translate(f10, f11);
            this.U.setBounds(0, 0, (int) this.f19487r0.width(), (int) this.f19487r0.height());
            if (b.f24443a) {
                this.V.setBounds(this.U.getBounds());
                this.V.jumpToCurrentState();
                this.V.draw(canvas);
            } else {
                this.U.draw(canvas);
            }
            canvas.translate(-f10, -f11);
        }
    }

    private void G0(@NonNull Canvas canvas, @NonNull Rect rect) {
        this.f19484o0.setColor(this.f19495z0);
        this.f19484o0.setStyle(Paint.Style.FILL);
        this.f19487r0.set(rect);
        if (!this.P0) {
            canvas.drawRoundRect(this.f19487r0, M0(), M0(), this.f19484o0);
            return;
        }
        h(new RectF(rect), this.f19489t0);
        super.p(canvas, this.f19484o0, this.f19489t0, u());
    }

    private void H0(@NonNull Canvas canvas, @NonNull Rect rect) {
        Paint paint = this.f19485p0;
        if (paint != null) {
            paint.setColor(androidx.core.graphics.a.l(-16777216, Opcodes.LAND));
            canvas.drawRect(rect, this.f19485p0);
            if (S2() || R2()) {
                p0(rect, this.f19487r0);
                canvas.drawRect(this.f19487r0, this.f19485p0);
            }
            if (this.N != null) {
                canvas.drawLine((float) rect.left, rect.exactCenterY(), (float) rect.right, rect.exactCenterY(), this.f19485p0);
            }
            if (T2()) {
                s0(rect, this.f19487r0);
                canvas.drawRect(this.f19487r0, this.f19485p0);
            }
            this.f19485p0.setColor(androidx.core.graphics.a.l(Opcodes.V_PREVIEW, Opcodes.LAND));
            r0(rect, this.f19487r0);
            canvas.drawRect(this.f19487r0, this.f19485p0);
            this.f19485p0.setColor(androidx.core.graphics.a.l(-16711936, Opcodes.LAND));
            t0(rect, this.f19487r0);
            canvas.drawRect(this.f19487r0, this.f19485p0);
        }
    }

    private void I0(@NonNull Canvas canvas, @NonNull Rect rect) {
        boolean z10;
        if (this.N != null) {
            Paint.Align x02 = x0(rect, this.f19488s0);
            v0(rect, this.f19487r0);
            if (this.f19490u0.d() != null) {
                this.f19490u0.e().drawableState = getState();
                this.f19490u0.j(this.f19483n0);
            }
            this.f19490u0.e().setTextAlign(x02);
            int i10 = 0;
            if (Math.round(this.f19490u0.f(l1().toString())) > Math.round(this.f19487r0.width())) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                i10 = canvas.save();
                canvas.clipRect(this.f19487r0);
            }
            CharSequence charSequence = this.N;
            if (z10 && this.M0 != null) {
                charSequence = TextUtils.ellipsize(charSequence, this.f19490u0.e(), this.f19487r0.width(), this.M0);
            }
            CharSequence charSequence2 = charSequence;
            int length = charSequence2.length();
            PointF pointF = this.f19488s0;
            canvas.drawText(charSequence2, 0, length, pointF.x, pointF.y, this.f19490u0.e());
            if (z10) {
                canvas.restoreToCount(i10);
            }
        }
    }

    private boolean R2() {
        return this.f19470a0 && this.f19471b0 != null && this.B0;
    }

    private boolean S2() {
        return this.O && this.P != null;
    }

    private boolean T2() {
        return this.T && this.U != null;
    }

    private void U2(Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback((Drawable.Callback) null);
        }
    }

    private void V2() {
        this.K0 = this.J0 ? b.d(this.M) : null;
    }

    @TargetApi(21)
    private void W2() {
        this.V = new RippleDrawable(b.d(j1()), this.U, R0);
    }

    private float d1() {
        Drawable drawable;
        if (this.B0) {
            drawable = this.f19471b0;
        } else {
            drawable = this.P;
        }
        float f10 = this.R;
        if (f10 <= 0.0f && drawable != null) {
            f10 = (float) Math.ceil((double) r.c(this.f19483n0, 24));
            if (((float) drawable.getIntrinsicHeight()) <= f10) {
                return (float) drawable.getIntrinsicHeight();
            }
        }
        return f10;
    }

    private float e1() {
        Drawable drawable;
        if (this.B0) {
            drawable = this.f19471b0;
        } else {
            drawable = this.P;
        }
        float f10 = this.R;
        if (f10 > 0.0f || drawable == null) {
            return f10;
        }
        return (float) drawable.getIntrinsicWidth();
    }

    private void f2(ColorStateList colorStateList) {
        if (this.G != colorStateList) {
            this.G = colorStateList;
            onStateChange(getState());
        }
    }

    private void o0(Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback(this);
            androidx.core.graphics.drawable.a.m(drawable, androidx.core.graphics.drawable.a.f(this));
            drawable.setLevel(getLevel());
            drawable.setVisible(isVisible(), false);
            if (drawable == this.U) {
                if (drawable.isStateful()) {
                    drawable.setState(a1());
                }
                androidx.core.graphics.drawable.a.o(drawable, this.W);
                return;
            }
            Drawable drawable2 = this.P;
            if (drawable == drawable2 && this.S) {
                androidx.core.graphics.drawable.a.o(drawable2, this.Q);
            }
            if (drawable.isStateful()) {
                drawable.setState(getState());
            }
        }
    }

    private void p0(@NonNull Rect rect, @NonNull RectF rectF) {
        rectF.setEmpty();
        if (S2() || R2()) {
            float f10 = this.f19475f0 + this.f19476g0;
            float e12 = e1();
            if (androidx.core.graphics.drawable.a.f(this) == 0) {
                float f11 = ((float) rect.left) + f10;
                rectF.left = f11;
                rectF.right = f11 + e12;
            } else {
                float f12 = ((float) rect.right) - f10;
                rectF.right = f12;
                rectF.left = f12 - e12;
            }
            float d12 = d1();
            float exactCenterY = rect.exactCenterY() - (d12 / 2.0f);
            rectF.top = exactCenterY;
            rectF.bottom = exactCenterY + d12;
        }
    }

    private ColorFilter p1() {
        ColorFilter colorFilter = this.E0;
        return colorFilter != null ? colorFilter : this.F0;
    }

    private void r0(@NonNull Rect rect, @NonNull RectF rectF) {
        rectF.set(rect);
        if (T2()) {
            float f10 = this.f19482m0 + this.f19481l0 + this.X + this.f19480k0 + this.f19479j0;
            if (androidx.core.graphics.drawable.a.f(this) == 0) {
                rectF.right = ((float) rect.right) - f10;
            } else {
                rectF.left = ((float) rect.left) + f10;
            }
        }
    }

    private static boolean r1(int[] iArr, int i10) {
        if (iArr == null) {
            return false;
        }
        for (int i11 : iArr) {
            if (i11 == i10) {
                return true;
            }
        }
        return false;
    }

    private void s0(@NonNull Rect rect, @NonNull RectF rectF) {
        rectF.setEmpty();
        if (T2()) {
            float f10 = this.f19482m0 + this.f19481l0;
            if (androidx.core.graphics.drawable.a.f(this) == 0) {
                float f11 = ((float) rect.right) - f10;
                rectF.right = f11;
                rectF.left = f11 - this.X;
            } else {
                float f12 = ((float) rect.left) + f10;
                rectF.left = f12;
                rectF.right = f12 + this.X;
            }
            float exactCenterY = rect.exactCenterY();
            float f13 = this.X;
            float f14 = exactCenterY - (f13 / 2.0f);
            rectF.top = f14;
            rectF.bottom = f14 + f13;
        }
    }

    private void t0(@NonNull Rect rect, @NonNull RectF rectF) {
        rectF.setEmpty();
        if (T2()) {
            float f10 = this.f19482m0 + this.f19481l0 + this.X + this.f19480k0 + this.f19479j0;
            if (androidx.core.graphics.drawable.a.f(this) == 0) {
                float f11 = (float) rect.right;
                rectF.right = f11;
                rectF.left = f11 - f10;
            } else {
                int i10 = rect.left;
                rectF.left = (float) i10;
                rectF.right = ((float) i10) + f10;
            }
            rectF.top = (float) rect.top;
            rectF.bottom = (float) rect.bottom;
        }
    }

    private void v0(@NonNull Rect rect, @NonNull RectF rectF) {
        rectF.setEmpty();
        if (this.N != null) {
            float q02 = this.f19475f0 + q0() + this.f19478i0;
            float u02 = this.f19482m0 + u0() + this.f19479j0;
            if (androidx.core.graphics.drawable.a.f(this) == 0) {
                rectF.left = ((float) rect.left) + q02;
                rectF.right = ((float) rect.right) - u02;
            } else {
                rectF.left = ((float) rect.left) + u02;
                rectF.right = ((float) rect.right) - q02;
            }
            rectF.top = (float) rect.top;
            rectF.bottom = (float) rect.bottom;
        }
    }

    private static boolean v1(ColorStateList colorStateList) {
        return colorStateList != null && colorStateList.isStateful();
    }

    private float w0() {
        this.f19490u0.e().getFontMetrics(this.f19486q0);
        Paint.FontMetrics fontMetrics = this.f19486q0;
        return (fontMetrics.descent + fontMetrics.ascent) / 2.0f;
    }

    private static boolean w1(Drawable drawable) {
        return drawable != null && drawable.isStateful();
    }

    private static boolean x1(d dVar) {
        if (dVar == null || dVar.i() == null || !dVar.i().isStateful()) {
            return false;
        }
        return true;
    }

    private boolean y0() {
        return this.f19470a0 && this.f19471b0 != null && this.Z;
    }

    private void y1(AttributeSet attributeSet, int i10, int i11) {
        TypedArray i12 = p.i(this.f19483n0, attributeSet, l.Chip, i10, i11, new int[0]);
        this.P0 = i12.hasValue(l.Chip_shapeAppearance);
        f2(c.a(this.f19483n0, i12, l.Chip_chipSurfaceColor));
        J1(c.a(this.f19483n0, i12, l.Chip_chipBackgroundColor));
        X1(i12.getDimension(l.Chip_chipMinHeight, 0.0f));
        int i13 = l.Chip_chipCornerRadius;
        if (i12.hasValue(i13)) {
            L1(i12.getDimension(i13, 0.0f));
        }
        b2(c.a(this.f19483n0, i12, l.Chip_chipStrokeColor));
        d2(i12.getDimension(l.Chip_chipStrokeWidth, 0.0f));
        C2(c.a(this.f19483n0, i12, l.Chip_rippleColor));
        H2(i12.getText(l.Chip_android_text));
        d f10 = c.f(this.f19483n0, i12, l.Chip_android_textAppearance);
        f10.l(i12.getDimension(l.Chip_android_textSize, f10.j()));
        I2(f10);
        int i14 = i12.getInt(l.Chip_android_ellipsize, 0);
        if (i14 == 1) {
            u2(TextUtils.TruncateAt.START);
        } else if (i14 == 2) {
            u2(TextUtils.TruncateAt.MIDDLE);
        } else if (i14 == 3) {
            u2(TextUtils.TruncateAt.END);
        }
        W1(i12.getBoolean(l.Chip_chipIconVisible, false));
        if (!(attributeSet == null || attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconEnabled") == null || attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconVisible") != null)) {
            W1(i12.getBoolean(l.Chip_chipIconEnabled, false));
        }
        P1(c.d(this.f19483n0, i12, l.Chip_chipIcon));
        int i15 = l.Chip_chipIconTint;
        if (i12.hasValue(i15)) {
            T1(c.a(this.f19483n0, i12, i15));
        }
        R1(i12.getDimension(l.Chip_chipIconSize, -1.0f));
        s2(i12.getBoolean(l.Chip_closeIconVisible, false));
        if (!(attributeSet == null || attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconEnabled") == null || attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconVisible") != null)) {
            s2(i12.getBoolean(l.Chip_closeIconEnabled, false));
        }
        g2(c.d(this.f19483n0, i12, l.Chip_closeIcon));
        q2(c.a(this.f19483n0, i12, l.Chip_closeIconTint));
        l2(i12.getDimension(l.Chip_closeIconSize, 0.0f));
        B1(i12.getBoolean(l.Chip_android_checkable, false));
        I1(i12.getBoolean(l.Chip_checkedIconVisible, false));
        if (!(attributeSet == null || attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconEnabled") == null || attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconVisible") != null)) {
            I1(i12.getBoolean(l.Chip_checkedIconEnabled, false));
        }
        D1(c.d(this.f19483n0, i12, l.Chip_checkedIcon));
        int i16 = l.Chip_checkedIconTint;
        if (i12.hasValue(i16)) {
            F1(c.a(this.f19483n0, i12, i16));
        }
        F2(h.b(this.f19483n0, i12, l.Chip_showMotionSpec));
        v2(h.b(this.f19483n0, i12, l.Chip_hideMotionSpec));
        Z1(i12.getDimension(l.Chip_chipStartPadding, 0.0f));
        z2(i12.getDimension(l.Chip_iconStartPadding, 0.0f));
        x2(i12.getDimension(l.Chip_iconEndPadding, 0.0f));
        N2(i12.getDimension(l.Chip_textStartPadding, 0.0f));
        K2(i12.getDimension(l.Chip_textEndPadding, 0.0f));
        n2(i12.getDimension(l.Chip_closeIconStartPadding, 0.0f));
        i2(i12.getDimension(l.Chip_closeIconEndPadding, 0.0f));
        N1(i12.getDimension(l.Chip_chipEndPadding, 0.0f));
        B2(i12.getDimensionPixelSize(l.Chip_android_maxWidth, a.e.API_PRIORITY_OTHER));
        i12.recycle();
    }

    @NonNull
    public static a z0(@NonNull Context context, AttributeSet attributeSet, int i10, int i11) {
        a aVar = new a(context, attributeSet, i10, i11);
        aVar.y1(attributeSet, i10, i11);
        return aVar;
    }

    public void A2(int i10) {
        z2(this.f19483n0.getResources().getDimension(i10));
    }

    public void B1(boolean z10) {
        if (this.Z != z10) {
            this.Z = z10;
            float q02 = q0();
            if (!z10 && this.B0) {
                this.B0 = false;
            }
            float q03 = q0();
            invalidateSelf();
            if (q02 != q03) {
                z1();
            }
        }
    }

    public void B2(int i10) {
        this.O0 = i10;
    }

    public void C1(int i10) {
        B1(this.f19483n0.getResources().getBoolean(i10));
    }

    public void C2(ColorStateList colorStateList) {
        if (this.M != colorStateList) {
            this.M = colorStateList;
            V2();
            onStateChange(getState());
        }
    }

    public void D1(Drawable drawable) {
        if (this.f19471b0 != drawable) {
            float q02 = q0();
            this.f19471b0 = drawable;
            float q03 = q0();
            U2(this.f19471b0);
            o0(this.f19471b0);
            invalidateSelf();
            if (q02 != q03) {
                z1();
            }
        }
    }

    public void D2(int i10) {
        C2(e.a.a(this.f19483n0, i10));
    }

    public void E1(int i10) {
        D1(e.a.b(this.f19483n0, i10));
    }

    /* access modifiers changed from: package-private */
    public void E2(boolean z10) {
        this.N0 = z10;
    }

    public void F1(ColorStateList colorStateList) {
        if (this.f19472c0 != colorStateList) {
            this.f19472c0 = colorStateList;
            if (y0()) {
                androidx.core.graphics.drawable.a.o(this.f19471b0, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public void F2(h hVar) {
        this.f19473d0 = hVar;
    }

    public void G1(int i10) {
        F1(e.a.a(this.f19483n0, i10));
    }

    public void G2(int i10) {
        F2(h.c(this.f19483n0, i10));
    }

    public void H1(int i10) {
        I1(this.f19483n0.getResources().getBoolean(i10));
    }

    public void H2(CharSequence charSequence) {
        if (charSequence == null) {
            charSequence = "";
        }
        if (!TextUtils.equals(this.N, charSequence)) {
            this.N = charSequence;
            this.f19490u0.i(true);
            invalidateSelf();
            z1();
        }
    }

    public void I1(boolean z10) {
        boolean z11;
        if (this.f19470a0 != z10) {
            boolean R2 = R2();
            this.f19470a0 = z10;
            boolean R22 = R2();
            if (R2 != R22) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                if (R22) {
                    o0(this.f19471b0);
                } else {
                    U2(this.f19471b0);
                }
                invalidateSelf();
                z1();
            }
        }
    }

    public void I2(d dVar) {
        this.f19490u0.h(dVar, this.f19483n0);
    }

    public Drawable J0() {
        return this.f19471b0;
    }

    public void J1(ColorStateList colorStateList) {
        if (this.H != colorStateList) {
            this.H = colorStateList;
            onStateChange(getState());
        }
    }

    public void J2(int i10) {
        I2(new d(this.f19483n0, i10));
    }

    public ColorStateList K0() {
        return this.f19472c0;
    }

    public void K1(int i10) {
        J1(e.a.a(this.f19483n0, i10));
    }

    public void K2(float f10) {
        if (this.f19479j0 != f10) {
            this.f19479j0 = f10;
            invalidateSelf();
            z1();
        }
    }

    public ColorStateList L0() {
        return this.H;
    }

    @Deprecated
    public void L1(float f10) {
        if (this.J != f10) {
            this.J = f10;
            setShapeAppearanceModel(E().w(f10));
        }
    }

    public void L2(int i10) {
        K2(this.f19483n0.getResources().getDimension(i10));
    }

    public float M0() {
        return this.P0 ? J() : this.J;
    }

    @Deprecated
    public void M1(int i10) {
        L1(this.f19483n0.getResources().getDimension(i10));
    }

    public void M2(float f10) {
        d m12 = m1();
        if (m12 != null) {
            m12.l(f10);
            this.f19490u0.e().setTextSize(f10);
            a();
        }
    }

    public float N0() {
        return this.f19482m0;
    }

    public void N1(float f10) {
        if (this.f19482m0 != f10) {
            this.f19482m0 = f10;
            invalidateSelf();
            z1();
        }
    }

    public void N2(float f10) {
        if (this.f19478i0 != f10) {
            this.f19478i0 = f10;
            invalidateSelf();
            z1();
        }
    }

    public Drawable O0() {
        Drawable drawable = this.P;
        if (drawable != null) {
            return androidx.core.graphics.drawable.a.q(drawable);
        }
        return null;
    }

    public void O1(int i10) {
        N1(this.f19483n0.getResources().getDimension(i10));
    }

    public void O2(int i10) {
        N2(this.f19483n0.getResources().getDimension(i10));
    }

    public float P0() {
        return this.R;
    }

    public void P1(Drawable drawable) {
        Drawable drawable2;
        Drawable O02 = O0();
        if (O02 != drawable) {
            float q02 = q0();
            if (drawable != null) {
                drawable2 = androidx.core.graphics.drawable.a.r(drawable).mutate();
            } else {
                drawable2 = null;
            }
            this.P = drawable2;
            float q03 = q0();
            U2(O02);
            if (S2()) {
                o0(this.P);
            }
            invalidateSelf();
            if (q02 != q03) {
                z1();
            }
        }
    }

    public void P2(boolean z10) {
        if (this.J0 != z10) {
            this.J0 = z10;
            V2();
            onStateChange(getState());
        }
    }

    public ColorStateList Q0() {
        return this.Q;
    }

    public void Q1(int i10) {
        P1(e.a.b(this.f19483n0, i10));
    }

    /* access modifiers changed from: package-private */
    public boolean Q2() {
        return this.N0;
    }

    public float R0() {
        return this.I;
    }

    public void R1(float f10) {
        if (this.R != f10) {
            float q02 = q0();
            this.R = f10;
            float q03 = q0();
            invalidateSelf();
            if (q02 != q03) {
                z1();
            }
        }
    }

    public float S0() {
        return this.f19475f0;
    }

    public void S1(int i10) {
        R1(this.f19483n0.getResources().getDimension(i10));
    }

    public ColorStateList T0() {
        return this.K;
    }

    public void T1(ColorStateList colorStateList) {
        this.S = true;
        if (this.Q != colorStateList) {
            this.Q = colorStateList;
            if (S2()) {
                androidx.core.graphics.drawable.a.o(this.P, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public float U0() {
        return this.L;
    }

    public void U1(int i10) {
        T1(e.a.a(this.f19483n0, i10));
    }

    public Drawable V0() {
        Drawable drawable = this.U;
        if (drawable != null) {
            return androidx.core.graphics.drawable.a.q(drawable);
        }
        return null;
    }

    public void V1(int i10) {
        W1(this.f19483n0.getResources().getBoolean(i10));
    }

    public CharSequence W0() {
        return this.Y;
    }

    public void W1(boolean z10) {
        boolean z11;
        if (this.O != z10) {
            boolean S2 = S2();
            this.O = z10;
            boolean S22 = S2();
            if (S2 != S22) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                if (S22) {
                    o0(this.P);
                } else {
                    U2(this.P);
                }
                invalidateSelf();
                z1();
            }
        }
    }

    public float X0() {
        return this.f19481l0;
    }

    public void X1(float f10) {
        if (this.I != f10) {
            this.I = f10;
            invalidateSelf();
            z1();
        }
    }

    public float Y0() {
        return this.X;
    }

    public void Y1(int i10) {
        X1(this.f19483n0.getResources().getDimension(i10));
    }

    public float Z0() {
        return this.f19480k0;
    }

    public void Z1(float f10) {
        if (this.f19475f0 != f10) {
            this.f19475f0 = f10;
            invalidateSelf();
            z1();
        }
    }

    public void a() {
        z1();
        invalidateSelf();
    }

    @NonNull
    public int[] a1() {
        return this.I0;
    }

    public void a2(int i10) {
        Z1(this.f19483n0.getResources().getDimension(i10));
    }

    public ColorStateList b1() {
        return this.W;
    }

    public void b2(ColorStateList colorStateList) {
        if (this.K != colorStateList) {
            this.K = colorStateList;
            if (this.P0) {
                j0(colorStateList);
            }
            onStateChange(getState());
        }
    }

    public void c1(@NonNull RectF rectF) {
        t0(getBounds(), rectF);
    }

    public void c2(int i10) {
        b2(e.a.a(this.f19483n0, i10));
    }

    public void d2(float f10) {
        if (this.L != f10) {
            this.L = f10;
            this.f19484o0.setStrokeWidth(f10);
            if (this.P0) {
                super.k0(f10);
            }
            invalidateSelf();
        }
    }

    public void draw(@NonNull Canvas canvas) {
        Rect bounds = getBounds();
        if (!bounds.isEmpty() && getAlpha() != 0) {
            int i10 = 0;
            int i11 = this.D0;
            if (i11 < 255) {
                i10 = df.a.a(canvas, (float) bounds.left, (float) bounds.top, (float) bounds.right, (float) bounds.bottom, i11);
            }
            E0(canvas, bounds);
            B0(canvas, bounds);
            if (this.P0) {
                super.draw(canvas);
            }
            D0(canvas, bounds);
            G0(canvas, bounds);
            C0(canvas, bounds);
            A0(canvas, bounds);
            if (this.N0) {
                I0(canvas, bounds);
            }
            F0(canvas, bounds);
            H0(canvas, bounds);
            if (this.D0 < 255) {
                canvas.restoreToCount(i10);
            }
        }
    }

    public void e2(int i10) {
        d2(this.f19483n0.getResources().getDimension(i10));
    }

    public TextUtils.TruncateAt f1() {
        return this.M0;
    }

    public h g1() {
        return this.f19474e0;
    }

    public void g2(Drawable drawable) {
        Drawable drawable2;
        Drawable V0 = V0();
        if (V0 != drawable) {
            float u02 = u0();
            if (drawable != null) {
                drawable2 = androidx.core.graphics.drawable.a.r(drawable).mutate();
            } else {
                drawable2 = null;
            }
            this.U = drawable2;
            if (b.f24443a) {
                W2();
            }
            float u03 = u0();
            U2(V0);
            if (T2()) {
                o0(this.U);
            }
            invalidateSelf();
            if (u02 != u03) {
                z1();
            }
        }
    }

    public int getAlpha() {
        return this.D0;
    }

    public ColorFilter getColorFilter() {
        return this.E0;
    }

    public int getIntrinsicHeight() {
        return (int) this.I;
    }

    public int getIntrinsicWidth() {
        return Math.min(Math.round(this.f19475f0 + q0() + this.f19478i0 + this.f19490u0.f(l1().toString()) + this.f19479j0 + u0() + this.f19482m0), this.O0);
    }

    public int getOpacity() {
        return -3;
    }

    @TargetApi(21)
    public void getOutline(@NonNull Outline outline) {
        if (this.P0) {
            super.getOutline(outline);
            return;
        }
        Rect bounds = getBounds();
        if (!bounds.isEmpty()) {
            outline.setRoundRect(bounds, this.J);
        } else {
            outline.setRoundRect(0, 0, getIntrinsicWidth(), getIntrinsicHeight(), this.J);
        }
        outline.setAlpha(((float) getAlpha()) / 255.0f);
    }

    public float h1() {
        return this.f19477h0;
    }

    public void h2(CharSequence charSequence) {
        if (this.Y != charSequence) {
            this.Y = androidx.core.text.a.c().h(charSequence);
            invalidateSelf();
        }
    }

    public float i1() {
        return this.f19476g0;
    }

    public void i2(float f10) {
        if (this.f19481l0 != f10) {
            this.f19481l0 = f10;
            invalidateSelf();
            if (T2()) {
                z1();
            }
        }
    }

    public void invalidateDrawable(@NonNull Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    public boolean isStateful() {
        if (v1(this.G) || v1(this.H) || v1(this.K) || ((this.J0 && v1(this.K0)) || x1(this.f19490u0.d()) || y0() || w1(this.P) || w1(this.f19471b0) || v1(this.G0))) {
            return true;
        }
        return false;
    }

    public ColorStateList j1() {
        return this.M;
    }

    public void j2(int i10) {
        i2(this.f19483n0.getResources().getDimension(i10));
    }

    public h k1() {
        return this.f19473d0;
    }

    public void k2(int i10) {
        g2(e.a.b(this.f19483n0, i10));
    }

    public CharSequence l1() {
        return this.N;
    }

    public void l2(float f10) {
        if (this.X != f10) {
            this.X = f10;
            invalidateSelf();
            if (T2()) {
                z1();
            }
        }
    }

    public d m1() {
        return this.f19490u0.d();
    }

    public void m2(int i10) {
        l2(this.f19483n0.getResources().getDimension(i10));
    }

    public float n1() {
        return this.f19479j0;
    }

    public void n2(float f10) {
        if (this.f19480k0 != f10) {
            this.f19480k0 = f10;
            invalidateSelf();
            if (T2()) {
                z1();
            }
        }
    }

    public float o1() {
        return this.f19478i0;
    }

    public void o2(int i10) {
        n2(this.f19483n0.getResources().getDimension(i10));
    }

    public boolean onLayoutDirectionChanged(int i10) {
        boolean onLayoutDirectionChanged = super.onLayoutDirectionChanged(i10);
        if (S2()) {
            onLayoutDirectionChanged |= androidx.core.graphics.drawable.a.m(this.P, i10);
        }
        if (R2()) {
            onLayoutDirectionChanged |= androidx.core.graphics.drawable.a.m(this.f19471b0, i10);
        }
        if (T2()) {
            onLayoutDirectionChanged |= androidx.core.graphics.drawable.a.m(this.U, i10);
        }
        if (!onLayoutDirectionChanged) {
            return true;
        }
        invalidateSelf();
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean onLevelChange(int i10) {
        boolean onLevelChange = super.onLevelChange(i10);
        if (S2()) {
            onLevelChange |= this.P.setLevel(i10);
        }
        if (R2()) {
            onLevelChange |= this.f19471b0.setLevel(i10);
        }
        if (T2()) {
            onLevelChange |= this.U.setLevel(i10);
        }
        if (onLevelChange) {
            invalidateSelf();
        }
        return onLevelChange;
    }

    public boolean onStateChange(@NonNull int[] iArr) {
        if (this.P0) {
            super.onStateChange(iArr);
        }
        return A1(iArr, a1());
    }

    public boolean p2(@NonNull int[] iArr) {
        if (Arrays.equals(this.I0, iArr)) {
            return false;
        }
        this.I0 = iArr;
        if (T2()) {
            return A1(getState(), iArr);
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public float q0() {
        if (S2() || R2()) {
            return this.f19476g0 + e1() + this.f19477h0;
        }
        return 0.0f;
    }

    public boolean q1() {
        return this.J0;
    }

    public void q2(ColorStateList colorStateList) {
        if (this.W != colorStateList) {
            this.W = colorStateList;
            if (T2()) {
                androidx.core.graphics.drawable.a.o(this.U, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public void r2(int i10) {
        q2(e.a.a(this.f19483n0, i10));
    }

    public boolean s1() {
        return this.Z;
    }

    public void s2(boolean z10) {
        boolean z11;
        if (this.T != z10) {
            boolean T2 = T2();
            this.T = z10;
            boolean T22 = T2();
            if (T2 != T22) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                if (T22) {
                    o0(this.U);
                } else {
                    U2(this.U);
                }
                invalidateSelf();
                z1();
            }
        }
    }

    public void scheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable, long j10) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j10);
        }
    }

    public void setAlpha(int i10) {
        if (this.D0 != i10) {
            this.D0 = i10;
            invalidateSelf();
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        if (this.E0 != colorFilter) {
            this.E0 = colorFilter;
            invalidateSelf();
        }
    }

    public void setTintList(ColorStateList colorStateList) {
        if (this.G0 != colorStateList) {
            this.G0 = colorStateList;
            onStateChange(getState());
        }
    }

    public void setTintMode(@NonNull PorterDuff.Mode mode) {
        if (this.H0 != mode) {
            this.H0 = mode;
            this.F0 = jf.b.h(this, this.G0, mode);
            invalidateSelf();
        }
    }

    public boolean setVisible(boolean z10, boolean z11) {
        boolean visible = super.setVisible(z10, z11);
        if (S2()) {
            visible |= this.P.setVisible(z10, z11);
        }
        if (R2()) {
            visible |= this.f19471b0.setVisible(z10, z11);
        }
        if (T2()) {
            visible |= this.U.setVisible(z10, z11);
        }
        if (visible) {
            invalidateSelf();
        }
        return visible;
    }

    public boolean t1() {
        return w1(this.U);
    }

    public void t2(C0234a aVar) {
        this.L0 = new WeakReference<>(aVar);
    }

    /* access modifiers changed from: package-private */
    public float u0() {
        if (T2()) {
            return this.f19480k0 + this.X + this.f19481l0;
        }
        return 0.0f;
    }

    public boolean u1() {
        return this.T;
    }

    public void u2(TextUtils.TruncateAt truncateAt) {
        this.M0 = truncateAt;
    }

    public void unscheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }

    public void v2(h hVar) {
        this.f19474e0 = hVar;
    }

    public void w2(int i10) {
        v2(h.c(this.f19483n0, i10));
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public Paint.Align x0(@NonNull Rect rect, @NonNull PointF pointF) {
        pointF.set(0.0f, 0.0f);
        Paint.Align align = Paint.Align.LEFT;
        if (this.N != null) {
            float q02 = this.f19475f0 + q0() + this.f19478i0;
            if (androidx.core.graphics.drawable.a.f(this) == 0) {
                pointF.x = ((float) rect.left) + q02;
                align = Paint.Align.LEFT;
            } else {
                pointF.x = ((float) rect.right) - q02;
                align = Paint.Align.RIGHT;
            }
            pointF.y = ((float) rect.centerY()) - w0();
        }
        return align;
    }

    public void x2(float f10) {
        if (this.f19477h0 != f10) {
            float q02 = q0();
            this.f19477h0 = f10;
            float q03 = q0();
            invalidateSelf();
            if (q02 != q03) {
                z1();
            }
        }
    }

    public void y2(int i10) {
        x2(this.f19483n0.getResources().getDimension(i10));
    }

    /* access modifiers changed from: protected */
    public void z1() {
        C0234a aVar = this.L0.get();
        if (aVar != null) {
            aVar.a();
        }
    }

    public void z2(float f10) {
        if (this.f19476g0 != f10) {
            float q02 = q0();
            this.f19476g0 = f10;
            float q03 = q0();
            invalidateSelf();
            if (q02 != q03) {
                z1();
            }
        }
    }
}
