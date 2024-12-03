package androidx.appcompat.widget;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.InputFilter;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.Property;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import androidx.annotation.NonNull;
import androidx.core.view.n0;
import androidx.core.widget.l;
import androidx.emoji2.text.e;
import d.h;
import d.j;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

public class SwitchCompat extends CompoundButton {

    /* renamed from: c0  reason: collision with root package name */
    private static final Property<SwitchCompat, Float> f1122c0 = new a(Float.class, "thumbPos");

    /* renamed from: d0  reason: collision with root package name */
    private static final int[] f1123d0 = {16842912};
    private int B;
    private float C;
    private float D;
    private VelocityTracker E;
    private int F;
    float G;
    private int H;
    private int I;
    private int J;
    private int K;
    private int L;
    private int M;
    private int N;
    private boolean O;
    private final TextPaint P;
    private ColorStateList Q;
    private Layout R;
    private Layout S;
    private TransformationMethod T;
    ObjectAnimator U;
    private final x V;
    @NonNull
    private k W;

    /* renamed from: a  reason: collision with root package name */
    private Drawable f1124a;

    /* renamed from: a0  reason: collision with root package name */
    private c f1125a0;

    /* renamed from: b  reason: collision with root package name */
    private ColorStateList f1126b;

    /* renamed from: b0  reason: collision with root package name */
    private final Rect f1127b0;

    /* renamed from: c  reason: collision with root package name */
    private PorterDuff.Mode f1128c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f1129d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f1130e;

    /* renamed from: f  reason: collision with root package name */
    private Drawable f1131f;

    /* renamed from: g  reason: collision with root package name */
    private ColorStateList f1132g;

    /* renamed from: h  reason: collision with root package name */
    private PorterDuff.Mode f1133h;

    /* renamed from: j  reason: collision with root package name */
    private boolean f1134j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f1135k;

    /* renamed from: l  reason: collision with root package name */
    private int f1136l;

    /* renamed from: m  reason: collision with root package name */
    private int f1137m;

    /* renamed from: n  reason: collision with root package name */
    private int f1138n;

    /* renamed from: p  reason: collision with root package name */
    private boolean f1139p;

    /* renamed from: q  reason: collision with root package name */
    private CharSequence f1140q;

    /* renamed from: t  reason: collision with root package name */
    private CharSequence f1141t;

    /* renamed from: w  reason: collision with root package name */
    private CharSequence f1142w;

    /* renamed from: x  reason: collision with root package name */
    private CharSequence f1143x;

    /* renamed from: y  reason: collision with root package name */
    private boolean f1144y;

    /* renamed from: z  reason: collision with root package name */
    private int f1145z;

    class a extends Property<SwitchCompat, Float> {
        a(Class cls, String str) {
            super(cls, str);
        }

        /* renamed from: a */
        public Float get(SwitchCompat switchCompat) {
            return Float.valueOf(switchCompat.G);
        }

        /* renamed from: b */
        public void set(SwitchCompat switchCompat, Float f10) {
            switchCompat.setThumbPosition(f10.floatValue());
        }
    }

    static class b {
        static void a(ObjectAnimator objectAnimator, boolean z10) {
            objectAnimator.setAutoCancel(z10);
        }
    }

    static class c extends e.C0055e {

        /* renamed from: a  reason: collision with root package name */
        private final Reference<SwitchCompat> f1146a;

        c(SwitchCompat switchCompat) {
            this.f1146a = new WeakReference(switchCompat);
        }

        public void a(Throwable th2) {
            SwitchCompat switchCompat = this.f1146a.get();
            if (switchCompat != null) {
                switchCompat.j();
            }
        }

        public void b() {
            SwitchCompat switchCompat = this.f1146a.get();
            if (switchCompat != null) {
                switchCompat.j();
            }
        }
    }

    public SwitchCompat(@NonNull Context context, AttributeSet attributeSet) {
        this(context, attributeSet, d.a.switchStyle);
    }

    private void a(boolean z10) {
        float f10;
        if (z10) {
            f10 = 1.0f;
        } else {
            f10 = 0.0f;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, f1122c0, new float[]{f10});
        this.U = ofFloat;
        ofFloat.setDuration(250);
        b.a(this.U, true);
        this.U.start();
    }

    private void b() {
        Drawable drawable = this.f1124a;
        if (drawable == null) {
            return;
        }
        if (this.f1129d || this.f1130e) {
            Drawable mutate = androidx.core.graphics.drawable.a.r(drawable).mutate();
            this.f1124a = mutate;
            if (this.f1129d) {
                androidx.core.graphics.drawable.a.o(mutate, this.f1126b);
            }
            if (this.f1130e) {
                androidx.core.graphics.drawable.a.p(this.f1124a, this.f1128c);
            }
            if (this.f1124a.isStateful()) {
                this.f1124a.setState(getDrawableState());
            }
        }
    }

    private void c() {
        Drawable drawable = this.f1131f;
        if (drawable == null) {
            return;
        }
        if (this.f1134j || this.f1135k) {
            Drawable mutate = androidx.core.graphics.drawable.a.r(drawable).mutate();
            this.f1131f = mutate;
            if (this.f1134j) {
                androidx.core.graphics.drawable.a.o(mutate, this.f1132g);
            }
            if (this.f1135k) {
                androidx.core.graphics.drawable.a.p(this.f1131f, this.f1133h);
            }
            if (this.f1131f.isStateful()) {
                this.f1131f.setState(getDrawableState());
            }
        }
    }

    private void d() {
        ObjectAnimator objectAnimator = this.U;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    private void e(MotionEvent motionEvent) {
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.setAction(3);
        super.onTouchEvent(obtain);
        obtain.recycle();
    }

    private static float f(float f10, float f11, float f12) {
        return f10 < f11 ? f11 : f10 > f12 ? f12 : f10;
    }

    private CharSequence g(CharSequence charSequence) {
        TransformationMethod f10 = getEmojiTextViewHelper().f(this.T);
        if (f10 != null) {
            return f10.getTransformation(charSequence, this);
        }
        return charSequence;
    }

    @NonNull
    private k getEmojiTextViewHelper() {
        if (this.W == null) {
            this.W = new k(this);
        }
        return this.W;
    }

    private boolean getTargetCheckedState() {
        return this.G > 0.5f;
    }

    private int getThumbOffset() {
        float f10;
        if (t1.b(this)) {
            f10 = 1.0f - this.G;
        } else {
            f10 = this.G;
        }
        return (int) ((f10 * ((float) getThumbScrollRange())) + 0.5f);
    }

    private int getThumbScrollRange() {
        Rect rect;
        Drawable drawable = this.f1131f;
        if (drawable == null) {
            return 0;
        }
        Rect rect2 = this.f1127b0;
        drawable.getPadding(rect2);
        Drawable drawable2 = this.f1124a;
        if (drawable2 != null) {
            rect = k0.d(drawable2);
        } else {
            rect = k0.f1310c;
        }
        return ((((this.H - this.J) - rect2.left) - rect2.right) - rect.left) - rect.right;
    }

    private boolean h(float f10, float f11) {
        if (this.f1124a == null) {
            return false;
        }
        int thumbOffset = getThumbOffset();
        this.f1124a.getPadding(this.f1127b0);
        int i10 = this.L;
        int i11 = this.B;
        int i12 = i10 - i11;
        int i13 = (this.K + thumbOffset) - i11;
        Rect rect = this.f1127b0;
        int i14 = this.J + i13 + rect.left + rect.right + i11;
        int i15 = this.N + i11;
        if (f10 <= ((float) i13) || f10 >= ((float) i14) || f11 <= ((float) i12) || f11 >= ((float) i15)) {
            return false;
        }
        return true;
    }

    private Layout i(CharSequence charSequence) {
        int i10;
        TextPaint textPaint = this.P;
        if (charSequence != null) {
            i10 = (int) Math.ceil((double) Layout.getDesiredWidth(charSequence, textPaint));
        } else {
            i10 = 0;
        }
        return new StaticLayout(charSequence, textPaint, i10, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
    }

    private void k() {
        if (Build.VERSION.SDK_INT >= 30) {
            CharSequence charSequence = this.f1142w;
            if (charSequence == null) {
                charSequence = getResources().getString(h.abc_capital_off);
            }
            n0.M0(this, charSequence);
        }
    }

    private void l() {
        if (Build.VERSION.SDK_INT >= 30) {
            CharSequence charSequence = this.f1140q;
            if (charSequence == null) {
                charSequence = getResources().getString(h.abc_capital_on);
            }
            n0.M0(this, charSequence);
        }
    }

    private void o(int i10, int i11) {
        Typeface typeface;
        if (i10 == 1) {
            typeface = Typeface.SANS_SERIF;
        } else if (i10 == 2) {
            typeface = Typeface.SERIF;
        } else if (i10 != 3) {
            typeface = null;
        } else {
            typeface = Typeface.MONOSPACE;
        }
        n(typeface, i11);
    }

    private void p() {
        if (this.f1125a0 == null && this.W.b() && e.h()) {
            e b10 = e.b();
            int d10 = b10.d();
            if (d10 == 3 || d10 == 0) {
                c cVar = new c(this);
                this.f1125a0 = cVar;
                b10.s(cVar);
            }
        }
    }

    private void q(MotionEvent motionEvent) {
        boolean z10;
        this.f1145z = 0;
        boolean z11 = true;
        if (motionEvent.getAction() != 1 || !isEnabled()) {
            z10 = false;
        } else {
            z10 = true;
        }
        boolean isChecked = isChecked();
        if (z10) {
            this.E.computeCurrentVelocity(1000);
            float xVelocity = this.E.getXVelocity();
            if (Math.abs(xVelocity) <= ((float) this.F)) {
                z11 = getTargetCheckedState();
            } else if (!t1.b(this) ? xVelocity <= 0.0f : xVelocity >= 0.0f) {
                z11 = false;
            }
        } else {
            z11 = isChecked;
        }
        if (z11 != isChecked) {
            playSoundEffect(0);
        }
        setChecked(z11);
        e(motionEvent);
    }

    private void setTextOffInternal(CharSequence charSequence) {
        this.f1142w = charSequence;
        this.f1143x = g(charSequence);
        this.S = null;
        if (this.f1144y) {
            p();
        }
    }

    private void setTextOnInternal(CharSequence charSequence) {
        this.f1140q = charSequence;
        this.f1141t = g(charSequence);
        this.R = null;
        if (this.f1144y) {
            p();
        }
    }

    public void draw(Canvas canvas) {
        Rect rect;
        int i10;
        int i11;
        Rect rect2 = this.f1127b0;
        int i12 = this.K;
        int i13 = this.L;
        int i14 = this.M;
        int i15 = this.N;
        int thumbOffset = getThumbOffset() + i12;
        Drawable drawable = this.f1124a;
        if (drawable != null) {
            rect = k0.d(drawable);
        } else {
            rect = k0.f1310c;
        }
        Drawable drawable2 = this.f1131f;
        if (drawable2 != null) {
            drawable2.getPadding(rect2);
            int i16 = rect2.left;
            thumbOffset += i16;
            if (rect != null) {
                int i17 = rect.left;
                if (i17 > i16) {
                    i12 += i17 - i16;
                }
                int i18 = rect.top;
                int i19 = rect2.top;
                if (i18 > i19) {
                    i10 = (i18 - i19) + i13;
                } else {
                    i10 = i13;
                }
                int i20 = rect.right;
                int i21 = rect2.right;
                if (i20 > i21) {
                    i14 -= i20 - i21;
                }
                int i22 = rect.bottom;
                int i23 = rect2.bottom;
                if (i22 > i23) {
                    i11 = i15 - (i22 - i23);
                    this.f1131f.setBounds(i12, i10, i14, i11);
                }
            } else {
                i10 = i13;
            }
            i11 = i15;
            this.f1131f.setBounds(i12, i10, i14, i11);
        }
        Drawable drawable3 = this.f1124a;
        if (drawable3 != null) {
            drawable3.getPadding(rect2);
            int i24 = thumbOffset - rect2.left;
            int i25 = thumbOffset + this.J + rect2.right;
            this.f1124a.setBounds(i24, i13, i25, i15);
            Drawable background = getBackground();
            if (background != null) {
                androidx.core.graphics.drawable.a.l(background, i24, i13, i25, i15);
            }
        }
        super.draw(canvas);
    }

    public void drawableHotspotChanged(float f10, float f11) {
        super.drawableHotspotChanged(f10, f11);
        Drawable drawable = this.f1124a;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.k(drawable, f10, f11);
        }
        Drawable drawable2 = this.f1131f;
        if (drawable2 != null) {
            androidx.core.graphics.drawable.a.k(drawable2, f10, f11);
        }
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f1124a;
        boolean z10 = false;
        if (drawable != null && drawable.isStateful()) {
            z10 = false | drawable.setState(drawableState);
        }
        Drawable drawable2 = this.f1131f;
        if (drawable2 != null && drawable2.isStateful()) {
            z10 |= drawable2.setState(drawableState);
        }
        if (z10) {
            invalidate();
        }
    }

    public int getCompoundPaddingLeft() {
        if (!t1.b(this)) {
            return super.getCompoundPaddingLeft();
        }
        int compoundPaddingLeft = super.getCompoundPaddingLeft() + this.H;
        if (!TextUtils.isEmpty(getText())) {
            return compoundPaddingLeft + this.f1138n;
        }
        return compoundPaddingLeft;
    }

    public int getCompoundPaddingRight() {
        if (t1.b(this)) {
            return super.getCompoundPaddingRight();
        }
        int compoundPaddingRight = super.getCompoundPaddingRight() + this.H;
        if (!TextUtils.isEmpty(getText())) {
            return compoundPaddingRight + this.f1138n;
        }
        return compoundPaddingRight;
    }

    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return l.u(super.getCustomSelectionActionModeCallback());
    }

    public boolean getShowText() {
        return this.f1144y;
    }

    public boolean getSplitTrack() {
        return this.f1139p;
    }

    public int getSwitchMinWidth() {
        return this.f1137m;
    }

    public int getSwitchPadding() {
        return this.f1138n;
    }

    public CharSequence getTextOff() {
        return this.f1142w;
    }

    public CharSequence getTextOn() {
        return this.f1140q;
    }

    public Drawable getThumbDrawable() {
        return this.f1124a;
    }

    /* access modifiers changed from: protected */
    public final float getThumbPosition() {
        return this.G;
    }

    public int getThumbTextPadding() {
        return this.f1136l;
    }

    public ColorStateList getThumbTintList() {
        return this.f1126b;
    }

    public PorterDuff.Mode getThumbTintMode() {
        return this.f1128c;
    }

    public Drawable getTrackDrawable() {
        return this.f1131f;
    }

    public ColorStateList getTrackTintList() {
        return this.f1132g;
    }

    public PorterDuff.Mode getTrackTintMode() {
        return this.f1133h;
    }

    /* access modifiers changed from: package-private */
    public void j() {
        setTextOnInternal(this.f1140q);
        setTextOffInternal(this.f1142w);
        requestLayout();
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f1124a;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.f1131f;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        ObjectAnimator objectAnimator = this.U;
        if (objectAnimator != null && objectAnimator.isStarted()) {
            this.U.end();
            this.U = null;
        }
    }

    public void m(Context context, int i10) {
        h1 t10 = h1.t(context, i10, j.TextAppearance);
        ColorStateList c10 = t10.c(j.TextAppearance_android_textColor);
        if (c10 != null) {
            this.Q = c10;
        } else {
            this.Q = getTextColors();
        }
        int f10 = t10.f(j.TextAppearance_android_textSize, 0);
        if (f10 != 0) {
            float f11 = (float) f10;
            if (f11 != this.P.getTextSize()) {
                this.P.setTextSize(f11);
                requestLayout();
            }
        }
        o(t10.k(j.TextAppearance_android_typeface, -1), t10.k(j.TextAppearance_android_textStyle, -1));
        if (t10.a(j.TextAppearance_textAllCaps, false)) {
            this.T = new h.a(getContext());
        } else {
            this.T = null;
        }
        setTextOnInternal(this.f1140q);
        setTextOffInternal(this.f1142w);
        t10.w();
    }

    public void n(Typeface typeface, int i10) {
        Typeface typeface2;
        int i11;
        float f10 = 0.0f;
        boolean z10 = false;
        if (i10 > 0) {
            if (typeface == null) {
                typeface2 = Typeface.defaultFromStyle(i10);
            } else {
                typeface2 = Typeface.create(typeface, i10);
            }
            setSwitchTypeface(typeface2);
            if (typeface2 != null) {
                i11 = typeface2.getStyle();
            } else {
                i11 = 0;
            }
            int i12 = (~i11) & i10;
            TextPaint textPaint = this.P;
            if ((i12 & 1) != 0) {
                z10 = true;
            }
            textPaint.setFakeBoldText(z10);
            TextPaint textPaint2 = this.P;
            if ((i12 & 2) != 0) {
                f10 = -0.25f;
            }
            textPaint2.setTextSkewX(f10);
            return;
        }
        this.P.setFakeBoldText(false);
        this.P.setTextSkewX(0.0f);
        setSwitchTypeface(typeface);
    }

    /* access modifiers changed from: protected */
    public int[] onCreateDrawableState(int i10) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i10 + 1);
        if (isChecked()) {
            View.mergeDrawableStates(onCreateDrawableState, f1123d0);
        }
        return onCreateDrawableState;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        Layout layout;
        int i10;
        super.onDraw(canvas);
        Rect rect = this.f1127b0;
        Drawable drawable = this.f1131f;
        if (drawable != null) {
            drawable.getPadding(rect);
        } else {
            rect.setEmpty();
        }
        int i11 = this.L;
        int i12 = this.N;
        int i13 = i11 + rect.top;
        int i14 = i12 - rect.bottom;
        Drawable drawable2 = this.f1124a;
        if (drawable != null) {
            if (!this.f1139p || drawable2 == null) {
                drawable.draw(canvas);
            } else {
                Rect d10 = k0.d(drawable2);
                drawable2.copyBounds(rect);
                rect.left += d10.left;
                rect.right -= d10.right;
                int save = canvas.save();
                canvas.clipRect(rect, Region.Op.DIFFERENCE);
                drawable.draw(canvas);
                canvas.restoreToCount(save);
            }
        }
        int save2 = canvas.save();
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        if (getTargetCheckedState()) {
            layout = this.R;
        } else {
            layout = this.S;
        }
        if (layout != null) {
            int[] drawableState = getDrawableState();
            ColorStateList colorStateList = this.Q;
            if (colorStateList != null) {
                this.P.setColor(colorStateList.getColorForState(drawableState, 0));
            }
            this.P.drawableState = drawableState;
            if (drawable2 != null) {
                Rect bounds = drawable2.getBounds();
                i10 = bounds.left + bounds.right;
            } else {
                i10 = getWidth();
            }
            canvas.translate((float) ((i10 / 2) - (layout.getWidth() / 2)), (float) (((i13 + i14) / 2) - (layout.getHeight() / 2)));
            layout.draw(canvas);
        }
        canvas.restoreToCount(save2);
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("android.widget.Switch");
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        CharSequence charSequence;
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("android.widget.Switch");
        if (Build.VERSION.SDK_INT < 30) {
            if (isChecked()) {
                charSequence = this.f1140q;
            } else {
                charSequence = this.f1142w;
            }
            if (!TextUtils.isEmpty(charSequence)) {
                CharSequence text = accessibilityNodeInfo.getText();
                if (TextUtils.isEmpty(text)) {
                    accessibilityNodeInfo.setText(charSequence);
                    return;
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append(text);
                sb2.append(' ');
                sb2.append(charSequence);
                accessibilityNodeInfo.setText(sb2);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        super.onLayout(z10, i10, i11, i12, i13);
        int i20 = 0;
        if (this.f1124a != null) {
            Rect rect = this.f1127b0;
            Drawable drawable = this.f1131f;
            if (drawable != null) {
                drawable.getPadding(rect);
            } else {
                rect.setEmpty();
            }
            Rect d10 = k0.d(this.f1124a);
            i14 = Math.max(0, d10.left - rect.left);
            i20 = Math.max(0, d10.right - rect.right);
        } else {
            i14 = 0;
        }
        if (t1.b(this)) {
            i16 = getPaddingLeft() + i14;
            i15 = ((this.H + i16) - i14) - i20;
        } else {
            i15 = (getWidth() - getPaddingRight()) - i20;
            i16 = (i15 - this.H) + i14 + i20;
        }
        int gravity = getGravity() & 112;
        if (gravity == 16) {
            i19 = this.I;
            i18 = (((getPaddingTop() + getHeight()) - getPaddingBottom()) / 2) - (i19 / 2);
        } else if (gravity != 80) {
            i18 = getPaddingTop();
            i19 = this.I;
        } else {
            i17 = getHeight() - getPaddingBottom();
            i18 = i17 - this.I;
            this.K = i16;
            this.L = i18;
            this.N = i17;
            this.M = i15;
        }
        i17 = i19 + i18;
        this.K = i16;
        this.L = i18;
        this.N = i17;
        this.M = i15;
    }

    public void onMeasure(int i10, int i11) {
        int i12;
        int i13;
        int i14;
        int i15;
        if (this.f1144y) {
            if (this.R == null) {
                this.R = i(this.f1141t);
            }
            if (this.S == null) {
                this.S = i(this.f1143x);
            }
        }
        Rect rect = this.f1127b0;
        Drawable drawable = this.f1124a;
        int i16 = 0;
        if (drawable != null) {
            drawable.getPadding(rect);
            i13 = (this.f1124a.getIntrinsicWidth() - rect.left) - rect.right;
            i12 = this.f1124a.getIntrinsicHeight();
        } else {
            i13 = 0;
            i12 = 0;
        }
        if (this.f1144y) {
            i14 = Math.max(this.R.getWidth(), this.S.getWidth()) + (this.f1136l * 2);
        } else {
            i14 = 0;
        }
        this.J = Math.max(i14, i13);
        Drawable drawable2 = this.f1131f;
        if (drawable2 != null) {
            drawable2.getPadding(rect);
            i16 = this.f1131f.getIntrinsicHeight();
        } else {
            rect.setEmpty();
        }
        int i17 = rect.left;
        int i18 = rect.right;
        Drawable drawable3 = this.f1124a;
        if (drawable3 != null) {
            Rect d10 = k0.d(drawable3);
            i17 = Math.max(i17, d10.left);
            i18 = Math.max(i18, d10.right);
        }
        if (this.O) {
            i15 = Math.max(this.f1137m, (this.J * 2) + i17 + i18);
        } else {
            i15 = this.f1137m;
        }
        int max = Math.max(i16, i12);
        this.H = i15;
        this.I = max;
        super.onMeasure(i10, i11);
        if (getMeasuredHeight() < max) {
            setMeasuredDimension(getMeasuredWidthAndState(), max);
        }
    }

    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        CharSequence charSequence;
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        if (isChecked()) {
            charSequence = this.f1140q;
        } else {
            charSequence = this.f1142w;
        }
        if (charSequence != null) {
            accessibilityEvent.getText().add(charSequence);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0012, code lost:
        if (r0 != 3) goto L_0x00b7;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            android.view.VelocityTracker r0 = r6.E
            r0.addMovement(r7)
            int r0 = r7.getActionMasked()
            r1 = 1
            if (r0 == 0) goto L_0x009d
            r2 = 2
            if (r0 == r1) goto L_0x0089
            if (r0 == r2) goto L_0x0016
            r3 = 3
            if (r0 == r3) goto L_0x0089
            goto L_0x00b7
        L_0x0016:
            int r0 = r6.f1145z
            if (r0 == r1) goto L_0x0055
            if (r0 == r2) goto L_0x001e
            goto L_0x00b7
        L_0x001e:
            float r7 = r7.getX()
            int r0 = r6.getThumbScrollRange()
            float r2 = r6.C
            float r2 = r7 - r2
            r3 = 1065353216(0x3f800000, float:1.0)
            r4 = 0
            if (r0 == 0) goto L_0x0032
            float r0 = (float) r0
            float r2 = r2 / r0
            goto L_0x003b
        L_0x0032:
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 <= 0) goto L_0x0038
            r2 = r3
            goto L_0x003b
        L_0x0038:
            r0 = -1082130432(0xffffffffbf800000, float:-1.0)
            r2 = r0
        L_0x003b:
            boolean r0 = androidx.appcompat.widget.t1.b(r6)
            if (r0 == 0) goto L_0x0042
            float r2 = -r2
        L_0x0042:
            float r0 = r6.G
            float r0 = r0 + r2
            float r0 = f(r0, r4, r3)
            float r2 = r6.G
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 == 0) goto L_0x0054
            r6.C = r7
            r6.setThumbPosition(r0)
        L_0x0054:
            return r1
        L_0x0055:
            float r0 = r7.getX()
            float r3 = r7.getY()
            float r4 = r6.C
            float r4 = r0 - r4
            float r4 = java.lang.Math.abs(r4)
            int r5 = r6.B
            float r5 = (float) r5
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 > 0) goto L_0x007b
            float r4 = r6.D
            float r4 = r3 - r4
            float r4 = java.lang.Math.abs(r4)
            int r5 = r6.B
            float r5 = (float) r5
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 <= 0) goto L_0x00b7
        L_0x007b:
            r6.f1145z = r2
            android.view.ViewParent r7 = r6.getParent()
            r7.requestDisallowInterceptTouchEvent(r1)
            r6.C = r0
            r6.D = r3
            return r1
        L_0x0089:
            int r0 = r6.f1145z
            if (r0 != r2) goto L_0x0094
            r6.q(r7)
            super.onTouchEvent(r7)
            return r1
        L_0x0094:
            r0 = 0
            r6.f1145z = r0
            android.view.VelocityTracker r0 = r6.E
            r0.clear()
            goto L_0x00b7
        L_0x009d:
            float r0 = r7.getX()
            float r2 = r7.getY()
            boolean r3 = r6.isEnabled()
            if (r3 == 0) goto L_0x00b7
            boolean r3 = r6.h(r0, r2)
            if (r3 == 0) goto L_0x00b7
            r6.f1145z = r1
            r6.C = r0
            r6.D = r2
        L_0x00b7:
            boolean r7 = super.onTouchEvent(r7)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.SwitchCompat.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setAllCaps(boolean z10) {
        super.setAllCaps(z10);
        getEmojiTextViewHelper().d(z10);
    }

    public void setChecked(boolean z10) {
        float f10;
        super.setChecked(z10);
        boolean isChecked = isChecked();
        if (isChecked) {
            l();
        } else {
            k();
        }
        if (getWindowToken() == null || !n0.W(this)) {
            d();
            if (isChecked) {
                f10 = 1.0f;
            } else {
                f10 = 0.0f;
            }
            setThumbPosition(f10);
            return;
        }
        a(isChecked);
    }

    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(l.v(this, callback));
    }

    public void setEmojiCompatEnabled(boolean z10) {
        getEmojiTextViewHelper().e(z10);
        setTextOnInternal(this.f1140q);
        setTextOffInternal(this.f1142w);
        requestLayout();
    }

    /* access modifiers changed from: protected */
    public final void setEnforceSwitchWidth(boolean z10) {
        this.O = z10;
        invalidate();
    }

    public void setFilters(@NonNull InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().a(inputFilterArr));
    }

    public void setShowText(boolean z10) {
        if (this.f1144y != z10) {
            this.f1144y = z10;
            requestLayout();
            if (z10) {
                p();
            }
        }
    }

    public void setSplitTrack(boolean z10) {
        this.f1139p = z10;
        invalidate();
    }

    public void setSwitchMinWidth(int i10) {
        this.f1137m = i10;
        requestLayout();
    }

    public void setSwitchPadding(int i10) {
        this.f1138n = i10;
        requestLayout();
    }

    public void setSwitchTypeface(Typeface typeface) {
        if ((this.P.getTypeface() != null && !this.P.getTypeface().equals(typeface)) || (this.P.getTypeface() == null && typeface != null)) {
            this.P.setTypeface(typeface);
            requestLayout();
            invalidate();
        }
    }

    public void setTextOff(CharSequence charSequence) {
        setTextOffInternal(charSequence);
        requestLayout();
        if (!isChecked()) {
            k();
        }
    }

    public void setTextOn(CharSequence charSequence) {
        setTextOnInternal(charSequence);
        requestLayout();
        if (isChecked()) {
            l();
        }
    }

    public void setThumbDrawable(Drawable drawable) {
        Drawable drawable2 = this.f1124a;
        if (drawable2 != null) {
            drawable2.setCallback((Drawable.Callback) null);
        }
        this.f1124a = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    /* access modifiers changed from: package-private */
    public void setThumbPosition(float f10) {
        this.G = f10;
        invalidate();
    }

    public void setThumbResource(int i10) {
        setThumbDrawable(e.a.b(getContext(), i10));
    }

    public void setThumbTextPadding(int i10) {
        this.f1136l = i10;
        requestLayout();
    }

    public void setThumbTintList(ColorStateList colorStateList) {
        this.f1126b = colorStateList;
        this.f1129d = true;
        b();
    }

    public void setThumbTintMode(PorterDuff.Mode mode) {
        this.f1128c = mode;
        this.f1130e = true;
        b();
    }

    public void setTrackDrawable(Drawable drawable) {
        Drawable drawable2 = this.f1131f;
        if (drawable2 != null) {
            drawable2.setCallback((Drawable.Callback) null);
        }
        this.f1131f = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    public void setTrackResource(int i10) {
        setTrackDrawable(e.a.b(getContext(), i10));
    }

    public void setTrackTintList(ColorStateList colorStateList) {
        this.f1132g = colorStateList;
        this.f1134j = true;
        c();
    }

    public void setTrackTintMode(PorterDuff.Mode mode) {
        this.f1133h = mode;
        this.f1135k = true;
        c();
    }

    public void toggle() {
        setChecked(!isChecked());
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f1124a || drawable == this.f1131f;
    }

    public SwitchCompat(@NonNull Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f1126b = null;
        this.f1128c = null;
        this.f1129d = false;
        this.f1130e = false;
        this.f1132g = null;
        this.f1133h = null;
        this.f1134j = false;
        this.f1135k = false;
        this.E = VelocityTracker.obtain();
        this.O = true;
        this.f1127b0 = new Rect();
        c1.a(this, getContext());
        TextPaint textPaint = new TextPaint(1);
        this.P = textPaint;
        textPaint.density = getResources().getDisplayMetrics().density;
        int[] iArr = j.SwitchCompat;
        h1 v10 = h1.v(context, attributeSet, iArr, i10, 0);
        n0.q0(this, context, iArr, attributeSet, v10.r(), i10, 0);
        Drawable g10 = v10.g(j.SwitchCompat_android_thumb);
        this.f1124a = g10;
        if (g10 != null) {
            g10.setCallback(this);
        }
        Drawable g11 = v10.g(j.SwitchCompat_track);
        this.f1131f = g11;
        if (g11 != null) {
            g11.setCallback(this);
        }
        setTextOnInternal(v10.p(j.SwitchCompat_android_textOn));
        setTextOffInternal(v10.p(j.SwitchCompat_android_textOff));
        this.f1144y = v10.a(j.SwitchCompat_showText, true);
        this.f1136l = v10.f(j.SwitchCompat_thumbTextPadding, 0);
        this.f1137m = v10.f(j.SwitchCompat_switchMinWidth, 0);
        this.f1138n = v10.f(j.SwitchCompat_switchPadding, 0);
        this.f1139p = v10.a(j.SwitchCompat_splitTrack, false);
        ColorStateList c10 = v10.c(j.SwitchCompat_thumbTint);
        if (c10 != null) {
            this.f1126b = c10;
            this.f1129d = true;
        }
        PorterDuff.Mode e10 = k0.e(v10.k(j.SwitchCompat_thumbTintMode, -1), (PorterDuff.Mode) null);
        if (this.f1128c != e10) {
            this.f1128c = e10;
            this.f1130e = true;
        }
        if (this.f1129d || this.f1130e) {
            b();
        }
        ColorStateList c11 = v10.c(j.SwitchCompat_trackTint);
        if (c11 != null) {
            this.f1132g = c11;
            this.f1134j = true;
        }
        PorterDuff.Mode e11 = k0.e(v10.k(j.SwitchCompat_trackTintMode, -1), (PorterDuff.Mode) null);
        if (this.f1133h != e11) {
            this.f1133h = e11;
            this.f1135k = true;
        }
        if (this.f1134j || this.f1135k) {
            c();
        }
        int n10 = v10.n(j.SwitchCompat_switchTextAppearance, 0);
        if (n10 != 0) {
            m(context, n10);
        }
        x xVar = new x(this);
        this.V = xVar;
        xVar.m(attributeSet, i10);
        v10.w();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.B = viewConfiguration.getScaledTouchSlop();
        this.F = viewConfiguration.getScaledMinimumFlingVelocity();
        getEmojiTextViewHelper().c(attributeSet, i10);
        refreshDrawableState();
        setChecked(isChecked());
    }
}
