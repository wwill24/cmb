package com.google.android.material.button;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Layout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.Checkable;
import android.widget.CompoundButton;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.view.n0;
import androidx.core.widget.l;
import androidx.customview.view.AbsSavedState;
import bf.k;
import java.util.Iterator;
import java.util.LinkedHashSet;
import tf.h;
import tf.n;

public class MaterialButton extends AppCompatButton implements Checkable, n {

    /* renamed from: w  reason: collision with root package name */
    private static final int[] f19326w = {16842911};

    /* renamed from: x  reason: collision with root package name */
    private static final int[] f19327x = {16842912};

    /* renamed from: y  reason: collision with root package name */
    private static final int f19328y = k.Widget_MaterialComponents_Button;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    private final a f19329d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    private final LinkedHashSet<a> f19330e;

    /* renamed from: f  reason: collision with root package name */
    private b f19331f;

    /* renamed from: g  reason: collision with root package name */
    private PorterDuff.Mode f19332g;

    /* renamed from: h  reason: collision with root package name */
    private ColorStateList f19333h;

    /* renamed from: j  reason: collision with root package name */
    private Drawable f19334j;

    /* renamed from: k  reason: collision with root package name */
    private int f19335k;

    /* renamed from: l  reason: collision with root package name */
    private int f19336l;

    /* renamed from: m  reason: collision with root package name */
    private int f19337m;

    /* renamed from: n  reason: collision with root package name */
    private int f19338n;

    /* renamed from: p  reason: collision with root package name */
    private boolean f19339p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f19340q;

    /* renamed from: t  reason: collision with root package name */
    private int f19341t;

    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: c  reason: collision with root package name */
        boolean f19342c;

        class a implements Parcelable.ClassLoaderCreator<SavedState> {
            a() {
            }

            @NonNull
            /* renamed from: a */
            public SavedState createFromParcel(@NonNull Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
            }

            @NonNull
            /* renamed from: b */
            public SavedState createFromParcel(@NonNull Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @NonNull
            /* renamed from: c */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private void c(@NonNull Parcel parcel) {
            boolean z10 = true;
            if (parcel.readInt() != 1) {
                z10 = false;
            }
            this.f19342c = z10;
        }

        public void writeToParcel(@NonNull Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.f19342c ? 1 : 0);
        }

        public SavedState(@NonNull Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            if (classLoader == null) {
                getClass().getClassLoader();
            }
            c(parcel);
        }
    }

    public interface a {
        void a(MaterialButton materialButton, boolean z10);
    }

    interface b {
        void a(MaterialButton materialButton, boolean z10);
    }

    public MaterialButton(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    private boolean b() {
        int i10 = this.f19341t;
        return i10 == 3 || i10 == 4;
    }

    private boolean c() {
        int i10 = this.f19341t;
        return i10 == 1 || i10 == 2;
    }

    private boolean d() {
        int i10 = this.f19341t;
        return i10 == 16 || i10 == 32;
    }

    private boolean e() {
        return n0.B(this) == 1;
    }

    private boolean f() {
        a aVar = this.f19329d;
        return aVar != null && !aVar.o();
    }

    private void g() {
        if (c()) {
            l.n(this, this.f19334j, (Drawable) null, (Drawable) null, (Drawable) null);
        } else if (b()) {
            l.n(this, (Drawable) null, (Drawable) null, this.f19334j, (Drawable) null);
        } else if (d()) {
            l.n(this, (Drawable) null, this.f19334j, (Drawable) null, (Drawable) null);
        }
    }

    @NonNull
    private String getA11yClassName() {
        return (a() ? CompoundButton.class : Button.class).getName();
    }

    private Layout.Alignment getActualTextAlignment() {
        int textAlignment = getTextAlignment();
        if (textAlignment == 1) {
            return getGravityTextAlignment();
        }
        if (textAlignment == 6 || textAlignment == 3) {
            return Layout.Alignment.ALIGN_OPPOSITE;
        }
        if (textAlignment != 4) {
            return Layout.Alignment.ALIGN_NORMAL;
        }
        return Layout.Alignment.ALIGN_CENTER;
    }

    private Layout.Alignment getGravityTextAlignment() {
        int gravity = getGravity() & 8388615;
        if (gravity == 1) {
            return Layout.Alignment.ALIGN_CENTER;
        }
        if (gravity == 5 || gravity == 8388613) {
            return Layout.Alignment.ALIGN_OPPOSITE;
        }
        return Layout.Alignment.ALIGN_NORMAL;
    }

    private int getTextHeight() {
        if (getLineCount() > 1) {
            return getLayout().getHeight();
        }
        TextPaint paint = getPaint();
        String charSequence = getText().toString();
        if (getTransformationMethod() != null) {
            charSequence = getTransformationMethod().getTransformation(charSequence, this).toString();
        }
        Rect rect = new Rect();
        paint.getTextBounds(charSequence, 0, charSequence.length(), rect);
        return Math.min(rect.height(), getLayout().getHeight());
    }

    private int getTextLayoutWidth() {
        int lineCount = getLineCount();
        float f10 = 0.0f;
        for (int i10 = 0; i10 < lineCount; i10++) {
            f10 = Math.max(f10, getLayout().getLineWidth(i10));
        }
        return (int) Math.ceil((double) f10);
    }

    private void h(boolean z10) {
        Drawable drawable = this.f19334j;
        boolean z11 = true;
        if (drawable != null) {
            Drawable mutate = androidx.core.graphics.drawable.a.r(drawable).mutate();
            this.f19334j = mutate;
            androidx.core.graphics.drawable.a.o(mutate, this.f19333h);
            PorterDuff.Mode mode = this.f19332g;
            if (mode != null) {
                androidx.core.graphics.drawable.a.p(this.f19334j, mode);
            }
            int i10 = this.f19335k;
            if (i10 == 0) {
                i10 = this.f19334j.getIntrinsicWidth();
            }
            int i11 = this.f19335k;
            if (i11 == 0) {
                i11 = this.f19334j.getIntrinsicHeight();
            }
            Drawable drawable2 = this.f19334j;
            int i12 = this.f19336l;
            int i13 = this.f19337m;
            drawable2.setBounds(i12, i13, i10 + i12, i11 + i13);
            this.f19334j.setVisible(true, z10);
        }
        if (z10) {
            g();
            return;
        }
        Drawable[] d10 = l.d(this);
        Drawable drawable3 = d10[0];
        Drawable drawable4 = d10[1];
        Drawable drawable5 = d10[2];
        if ((!c() || drawable3 == this.f19334j) && ((!b() || drawable5 == this.f19334j) && (!d() || drawable4 == this.f19334j))) {
            z11 = false;
        }
        if (z11) {
            g();
        }
    }

    private void i(int i10, int i11) {
        if (this.f19334j != null && getLayout() != null) {
            if (c() || b()) {
                this.f19337m = 0;
                Layout.Alignment actualTextAlignment = getActualTextAlignment();
                int i12 = this.f19341t;
                boolean z10 = true;
                if (i12 == 1 || i12 == 3 || ((i12 == 2 && actualTextAlignment == Layout.Alignment.ALIGN_NORMAL) || (i12 == 4 && actualTextAlignment == Layout.Alignment.ALIGN_OPPOSITE))) {
                    this.f19336l = 0;
                    h(false);
                    return;
                }
                int i13 = this.f19335k;
                if (i13 == 0) {
                    i13 = this.f19334j.getIntrinsicWidth();
                }
                int textLayoutWidth = ((((i10 - getTextLayoutWidth()) - n0.F(this)) - i13) - this.f19338n) - n0.G(this);
                if (actualTextAlignment == Layout.Alignment.ALIGN_CENTER) {
                    textLayoutWidth /= 2;
                }
                boolean e10 = e();
                if (this.f19341t != 4) {
                    z10 = false;
                }
                if (e10 != z10) {
                    textLayoutWidth = -textLayoutWidth;
                }
                if (this.f19336l != textLayoutWidth) {
                    this.f19336l = textLayoutWidth;
                    h(false);
                }
            } else if (d()) {
                this.f19336l = 0;
                if (this.f19341t == 16) {
                    this.f19337m = 0;
                    h(false);
                    return;
                }
                int i14 = this.f19335k;
                if (i14 == 0) {
                    i14 = this.f19334j.getIntrinsicHeight();
                }
                int max = Math.max(0, (((((i11 - getTextHeight()) - getPaddingTop()) - i14) - this.f19338n) - getPaddingBottom()) / 2);
                if (this.f19337m != max) {
                    this.f19337m = max;
                    h(false);
                }
            }
        }
    }

    public boolean a() {
        a aVar = this.f19329d;
        return aVar != null && aVar.p();
    }

    public ColorStateList getBackgroundTintList() {
        return getSupportBackgroundTintList();
    }

    public PorterDuff.Mode getBackgroundTintMode() {
        return getSupportBackgroundTintMode();
    }

    public int getCornerRadius() {
        if (f()) {
            return this.f19329d.b();
        }
        return 0;
    }

    public Drawable getIcon() {
        return this.f19334j;
    }

    public int getIconGravity() {
        return this.f19341t;
    }

    public int getIconPadding() {
        return this.f19338n;
    }

    public int getIconSize() {
        return this.f19335k;
    }

    public ColorStateList getIconTint() {
        return this.f19333h;
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.f19332g;
    }

    public int getInsetBottom() {
        return this.f19329d.c();
    }

    public int getInsetTop() {
        return this.f19329d.d();
    }

    public ColorStateList getRippleColor() {
        if (f()) {
            return this.f19329d.h();
        }
        return null;
    }

    @NonNull
    public tf.k getShapeAppearanceModel() {
        if (f()) {
            return this.f19329d.i();
        }
        throw new IllegalStateException("Attempted to get ShapeAppearanceModel from a MaterialButton which has an overwritten background.");
    }

    public ColorStateList getStrokeColor() {
        if (f()) {
            return this.f19329d.j();
        }
        return null;
    }

    public int getStrokeWidth() {
        if (f()) {
            return this.f19329d.k();
        }
        return 0;
    }

    public ColorStateList getSupportBackgroundTintList() {
        if (f()) {
            return this.f19329d.l();
        }
        return super.getSupportBackgroundTintList();
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        if (f()) {
            return this.f19329d.m();
        }
        return super.getSupportBackgroundTintMode();
    }

    public boolean isChecked() {
        return this.f19339p;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (f()) {
            h.f(this, this.f19329d.f());
        }
    }

    /* access modifiers changed from: protected */
    public int[] onCreateDrawableState(int i10) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i10 + 2);
        if (a()) {
            View.mergeDrawableStates(onCreateDrawableState, f19326w);
        }
        if (isChecked()) {
            View.mergeDrawableStates(onCreateDrawableState, f19327x);
        }
        return onCreateDrawableState;
    }

    public void onInitializeAccessibilityEvent(@NonNull AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(getA11yClassName());
        accessibilityEvent.setChecked(isChecked());
    }

    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(getA11yClassName());
        accessibilityNodeInfo.setCheckable(a());
        accessibilityNodeInfo.setChecked(isChecked());
        accessibilityNodeInfo.setClickable(isClickable());
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        i(getMeasuredWidth(), getMeasuredHeight());
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        setChecked(savedState.f19342c);
    }

    @NonNull
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f19342c = this.f19339p;
        return savedState;
    }

    /* access modifiers changed from: protected */
    public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        super.onTextChanged(charSequence, i10, i11, i12);
        i(getMeasuredWidth(), getMeasuredHeight());
    }

    public boolean performClick() {
        if (this.f19329d.q()) {
            toggle();
        }
        return super.performClick();
    }

    public void refreshDrawableState() {
        super.refreshDrawableState();
        if (this.f19334j != null) {
            if (this.f19334j.setState(getDrawableState())) {
                invalidate();
            }
        }
    }

    public void setBackground(@NonNull Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    public void setBackgroundColor(int i10) {
        if (f()) {
            this.f19329d.s(i10);
        } else {
            super.setBackgroundColor(i10);
        }
    }

    public void setBackgroundDrawable(@NonNull Drawable drawable) {
        if (!f()) {
            super.setBackgroundDrawable(drawable);
        } else if (drawable != getBackground()) {
            this.f19329d.t();
            super.setBackgroundDrawable(drawable);
        } else {
            getBackground().setState(drawable.getState());
        }
    }

    public void setBackgroundResource(int i10) {
        Drawable drawable;
        if (i10 != 0) {
            drawable = e.a.b(getContext(), i10);
        } else {
            drawable = null;
        }
        setBackgroundDrawable(drawable);
    }

    public void setBackgroundTintList(ColorStateList colorStateList) {
        setSupportBackgroundTintList(colorStateList);
    }

    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        setSupportBackgroundTintMode(mode);
    }

    public void setCheckable(boolean z10) {
        if (f()) {
            this.f19329d.u(z10);
        }
    }

    public void setChecked(boolean z10) {
        if (a() && isEnabled() && this.f19339p != z10) {
            this.f19339p = z10;
            refreshDrawableState();
            if (getParent() instanceof MaterialButtonToggleGroup) {
                ((MaterialButtonToggleGroup) getParent()).m(this, this.f19339p);
            }
            if (!this.f19340q) {
                this.f19340q = true;
                Iterator<a> it = this.f19330e.iterator();
                while (it.hasNext()) {
                    it.next().a(this, this.f19339p);
                }
                this.f19340q = false;
            }
        }
    }

    public void setCornerRadius(int i10) {
        if (f()) {
            this.f19329d.v(i10);
        }
    }

    public void setCornerRadiusResource(int i10) {
        if (f()) {
            setCornerRadius(getResources().getDimensionPixelSize(i10));
        }
    }

    public void setElevation(float f10) {
        super.setElevation(f10);
        if (f()) {
            this.f19329d.f().a0(f10);
        }
    }

    public void setIcon(Drawable drawable) {
        if (this.f19334j != drawable) {
            this.f19334j = drawable;
            h(true);
            i(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setIconGravity(int i10) {
        if (this.f19341t != i10) {
            this.f19341t = i10;
            i(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setIconPadding(int i10) {
        if (this.f19338n != i10) {
            this.f19338n = i10;
            setCompoundDrawablePadding(i10);
        }
    }

    public void setIconResource(int i10) {
        Drawable drawable;
        if (i10 != 0) {
            drawable = e.a.b(getContext(), i10);
        } else {
            drawable = null;
        }
        setIcon(drawable);
    }

    public void setIconSize(int i10) {
        if (i10 < 0) {
            throw new IllegalArgumentException("iconSize cannot be less than 0");
        } else if (this.f19335k != i10) {
            this.f19335k = i10;
            h(true);
        }
    }

    public void setIconTint(ColorStateList colorStateList) {
        if (this.f19333h != colorStateList) {
            this.f19333h = colorStateList;
            h(false);
        }
    }

    public void setIconTintMode(PorterDuff.Mode mode) {
        if (this.f19332g != mode) {
            this.f19332g = mode;
            h(false);
        }
    }

    public void setIconTintResource(int i10) {
        setIconTint(e.a.a(getContext(), i10));
    }

    public void setInsetBottom(int i10) {
        this.f19329d.w(i10);
    }

    public void setInsetTop(int i10) {
        this.f19329d.x(i10);
    }

    /* access modifiers changed from: package-private */
    public void setInternalBackground(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    /* access modifiers changed from: package-private */
    public void setOnPressedChangeListenerInternal(b bVar) {
        this.f19331f = bVar;
    }

    public void setPressed(boolean z10) {
        b bVar = this.f19331f;
        if (bVar != null) {
            bVar.a(this, z10);
        }
        super.setPressed(z10);
    }

    public void setRippleColor(ColorStateList colorStateList) {
        if (f()) {
            this.f19329d.y(colorStateList);
        }
    }

    public void setRippleColorResource(int i10) {
        if (f()) {
            setRippleColor(e.a.a(getContext(), i10));
        }
    }

    public void setShapeAppearanceModel(@NonNull tf.k kVar) {
        if (f()) {
            this.f19329d.z(kVar);
            return;
        }
        throw new IllegalStateException("Attempted to set ShapeAppearanceModel on a MaterialButton which has an overwritten background.");
    }

    /* access modifiers changed from: package-private */
    public void setShouldDrawSurfaceColorStroke(boolean z10) {
        if (f()) {
            this.f19329d.A(z10);
        }
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        if (f()) {
            this.f19329d.B(colorStateList);
        }
    }

    public void setStrokeColorResource(int i10) {
        if (f()) {
            setStrokeColor(e.a.a(getContext(), i10));
        }
    }

    public void setStrokeWidth(int i10) {
        if (f()) {
            this.f19329d.C(i10);
        }
    }

    public void setStrokeWidthResource(int i10) {
        if (f()) {
            setStrokeWidth(getResources().getDimensionPixelSize(i10));
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (f()) {
            this.f19329d.D(colorStateList);
        } else {
            super.setSupportBackgroundTintList(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (f()) {
            this.f19329d.E(mode);
        } else {
            super.setSupportBackgroundTintMode(mode);
        }
    }

    public void setTextAlignment(int i10) {
        super.setTextAlignment(i10);
        i(getMeasuredWidth(), getMeasuredHeight());
    }

    public void setToggleCheckedStateOnClick(boolean z10) {
        this.f19329d.F(z10);
    }

    public void toggle() {
        setChecked(!this.f19339p);
    }

    public MaterialButton(@NonNull Context context, AttributeSet attributeSet) {
        this(context, attributeSet, bf.b.materialButtonStyle);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public MaterialButton(@androidx.annotation.NonNull android.content.Context r9, android.util.AttributeSet r10, int r11) {
        /*
            r8 = this;
            int r6 = f19328y
            android.content.Context r9 = wf.a.c(r9, r10, r11, r6)
            r8.<init>(r9, r10, r11)
            java.util.LinkedHashSet r9 = new java.util.LinkedHashSet
            r9.<init>()
            r8.f19330e = r9
            r9 = 0
            r8.f19339p = r9
            r8.f19340q = r9
            android.content.Context r7 = r8.getContext()
            int[] r2 = bf.l.MaterialButton
            int[] r5 = new int[r9]
            r0 = r7
            r1 = r10
            r3 = r11
            r4 = r6
            android.content.res.TypedArray r0 = com.google.android.material.internal.p.i(r0, r1, r2, r3, r4, r5)
            int r1 = bf.l.MaterialButton_iconPadding
            int r1 = r0.getDimensionPixelSize(r1, r9)
            r8.f19338n = r1
            int r1 = bf.l.MaterialButton_iconTintMode
            r2 = -1
            int r1 = r0.getInt(r1, r2)
            android.graphics.PorterDuff$Mode r2 = android.graphics.PorterDuff.Mode.SRC_IN
            android.graphics.PorterDuff$Mode r1 = com.google.android.material.internal.r.j(r1, r2)
            r8.f19332g = r1
            android.content.Context r1 = r8.getContext()
            int r2 = bf.l.MaterialButton_iconTint
            android.content.res.ColorStateList r1 = qf.c.a(r1, r0, r2)
            r8.f19333h = r1
            android.content.Context r1 = r8.getContext()
            int r2 = bf.l.MaterialButton_icon
            android.graphics.drawable.Drawable r1 = qf.c.d(r1, r0, r2)
            r8.f19334j = r1
            int r1 = bf.l.MaterialButton_iconGravity
            r2 = 1
            int r1 = r0.getInteger(r1, r2)
            r8.f19341t = r1
            int r1 = bf.l.MaterialButton_iconSize
            int r1 = r0.getDimensionPixelSize(r1, r9)
            r8.f19335k = r1
            tf.k$b r10 = tf.k.e(r7, r10, r11, r6)
            tf.k r10 = r10.m()
            com.google.android.material.button.a r11 = new com.google.android.material.button.a
            r11.<init>(r8, r10)
            r8.f19329d = r11
            r11.r(r0)
            r0.recycle()
            int r10 = r8.f19338n
            r8.setCompoundDrawablePadding(r10)
            android.graphics.drawable.Drawable r10 = r8.f19334j
            if (r10 == 0) goto L_0x0084
            r9 = r2
        L_0x0084:
            r8.h(r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.button.MaterialButton.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }
}
