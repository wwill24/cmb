package com.google.android.material.checkbox;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.AnimatedStateListDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.autofill.AutofillManager;
import android.widget.CompoundButton;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.h1;
import androidx.core.widget.d;
import bf.f;
import bf.j;
import bf.k;
import bf.l;
import com.google.android.material.internal.r;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class MaterialCheckBox extends AppCompatCheckBox {
    private static final int F = k.Widget_MaterialComponents_CompoundButton_CheckBox;
    private static final int[] G = {bf.b.state_indeterminate};
    private static final int[] H;
    private static final int[][] I;
    @SuppressLint({"DiscouragedApi"})
    private static final int J = Resources.getSystem().getIdentifier("btn_check_material_anim", "drawable", "android");
    private CharSequence B;
    private CompoundButton.OnCheckedChangeListener C;
    private final androidx.vectordrawable.graphics.drawable.c D;
    private final androidx.vectordrawable.graphics.drawable.b E;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    private final LinkedHashSet<c> f19421e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    private final LinkedHashSet<b> f19422f;

    /* renamed from: g  reason: collision with root package name */
    private ColorStateList f19423g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f19424h;

    /* renamed from: j  reason: collision with root package name */
    private boolean f19425j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f19426k;

    /* renamed from: l  reason: collision with root package name */
    private CharSequence f19427l;

    /* renamed from: m  reason: collision with root package name */
    private Drawable f19428m;

    /* renamed from: n  reason: collision with root package name */
    private Drawable f19429n;

    /* renamed from: p  reason: collision with root package name */
    private boolean f19430p;

    /* renamed from: q  reason: collision with root package name */
    ColorStateList f19431q;

    /* renamed from: t  reason: collision with root package name */
    ColorStateList f19432t;
    @NonNull

    /* renamed from: w  reason: collision with root package name */
    private PorterDuff.Mode f19433w;

    /* renamed from: x  reason: collision with root package name */
    private int f19434x;
    /* access modifiers changed from: private */

    /* renamed from: y  reason: collision with root package name */
    public int[] f19435y;

    /* renamed from: z  reason: collision with root package name */
    private boolean f19436z;

    static class SavedState extends View.BaseSavedState {
        @NonNull
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        int f19437a;

        class a implements Parcelable.Creator<SavedState> {
            a() {
            }

            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (a) null);
            }

            /* renamed from: b */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        /* synthetic */ SavedState(Parcel parcel, a aVar) {
            this(parcel);
        }

        @NonNull
        private String a() {
            int i10 = this.f19437a;
            return i10 != 1 ? i10 != 2 ? "unchecked" : "indeterminate" : "checked";
        }

        @NonNull
        public String toString() {
            return "MaterialCheckBox.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " CheckedState=" + a() + "}";
        }

        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeValue(Integer.valueOf(this.f19437a));
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f19437a = ((Integer) parcel.readValue(getClass().getClassLoader())).intValue();
        }
    }

    class a extends androidx.vectordrawable.graphics.drawable.b {
        a() {
        }

        public void b(Drawable drawable) {
            super.b(drawable);
            ColorStateList colorStateList = MaterialCheckBox.this.f19431q;
            if (colorStateList != null) {
                androidx.core.graphics.drawable.a.o(drawable, colorStateList);
            }
        }

        public void c(Drawable drawable) {
            super.c(drawable);
            MaterialCheckBox materialCheckBox = MaterialCheckBox.this;
            ColorStateList colorStateList = materialCheckBox.f19431q;
            if (colorStateList != null) {
                androidx.core.graphics.drawable.a.n(drawable, colorStateList.getColorForState(materialCheckBox.f19435y, MaterialCheckBox.this.f19431q.getDefaultColor()));
            }
        }
    }

    public interface b {
        void a(@NonNull MaterialCheckBox materialCheckBox, int i10);
    }

    public interface c {
        void a(@NonNull MaterialCheckBox materialCheckBox, boolean z10);
    }

    static {
        int i10 = bf.b.state_error;
        H = new int[]{i10};
        I = new int[][]{new int[]{16842910, i10}, new int[]{16842910, 16842912}, new int[]{16842910, -16842912}, new int[]{-16842910, 16842912}, new int[]{-16842910, -16842912}};
    }

    public MaterialCheckBox(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, bf.b.checkboxStyle);
    }

    private boolean c(h1 h1Var) {
        int n10 = h1Var.n(l.MaterialCheckBox_android_button, 0);
        int n11 = h1Var.n(l.MaterialCheckBox_buttonCompat, 0);
        if (n10 == J && n11 == 0) {
            return true;
        }
        return false;
    }

    private void e() {
        this.f19428m = jf.b.b(this.f19428m, this.f19431q, d.c(this));
        this.f19429n = jf.b.b(this.f19429n, this.f19432t, this.f19433w);
        g();
        h();
        super.setButtonDrawable(jf.b.a(this.f19428m, this.f19429n));
        refreshDrawableState();
    }

    private void f() {
        if (Build.VERSION.SDK_INT >= 30 && this.B == null) {
            super.setStateDescription(getButtonStateDescription());
        }
    }

    private void g() {
        androidx.vectordrawable.graphics.drawable.c cVar;
        if (this.f19430p) {
            androidx.vectordrawable.graphics.drawable.c cVar2 = this.D;
            if (cVar2 != null) {
                cVar2.f(this.E);
                this.D.b(this.E);
            }
            Drawable drawable = this.f19428m;
            if ((drawable instanceof AnimatedStateListDrawable) && (cVar = this.D) != null) {
                int i10 = f.checked;
                int i11 = f.unchecked;
                ((AnimatedStateListDrawable) drawable).addTransition(i10, i11, cVar, false);
                ((AnimatedStateListDrawable) this.f19428m).addTransition(f.indeterminate, i11, this.D, false);
            }
        }
    }

    @NonNull
    private String getButtonStateDescription() {
        int i10 = this.f19434x;
        if (i10 == 1) {
            return getResources().getString(j.mtrl_checkbox_state_description_checked);
        }
        if (i10 == 0) {
            return getResources().getString(j.mtrl_checkbox_state_description_unchecked);
        }
        return getResources().getString(j.mtrl_checkbox_state_description_indeterminate);
    }

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.f19423g == null) {
            int[][] iArr = I;
            int[] iArr2 = new int[iArr.length];
            int d10 = hf.a.d(this, bf.b.colorControlActivated);
            int d11 = hf.a.d(this, bf.b.colorError);
            int d12 = hf.a.d(this, bf.b.colorSurface);
            int d13 = hf.a.d(this, bf.b.colorOnSurface);
            iArr2[0] = hf.a.i(d12, d11, 1.0f);
            iArr2[1] = hf.a.i(d12, d10, 1.0f);
            iArr2[2] = hf.a.i(d12, d13, 0.54f);
            iArr2[3] = hf.a.i(d12, d13, 0.38f);
            iArr2[4] = hf.a.i(d12, d13, 0.38f);
            this.f19423g = new ColorStateList(iArr, iArr2);
        }
        return this.f19423g;
    }

    private ColorStateList getSuperButtonTintList() {
        ColorStateList colorStateList = this.f19431q;
        if (colorStateList != null) {
            return colorStateList;
        }
        if (super.getButtonTintList() != null) {
            return super.getButtonTintList();
        }
        return getSupportButtonTintList();
    }

    private void h() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        Drawable drawable = this.f19428m;
        if (!(drawable == null || (colorStateList2 = this.f19431q) == null)) {
            androidx.core.graphics.drawable.a.o(drawable, colorStateList2);
        }
        Drawable drawable2 = this.f19429n;
        if (drawable2 != null && (colorStateList = this.f19432t) != null) {
            androidx.core.graphics.drawable.a.o(drawable2, colorStateList);
        }
    }

    private void i() {
    }

    public boolean d() {
        return this.f19426k;
    }

    public Drawable getButtonDrawable() {
        return this.f19428m;
    }

    public Drawable getButtonIconDrawable() {
        return this.f19429n;
    }

    public ColorStateList getButtonIconTintList() {
        return this.f19432t;
    }

    @NonNull
    public PorterDuff.Mode getButtonIconTintMode() {
        return this.f19433w;
    }

    public ColorStateList getButtonTintList() {
        return this.f19431q;
    }

    public int getCheckedState() {
        return this.f19434x;
    }

    public CharSequence getErrorAccessibilityLabel() {
        return this.f19427l;
    }

    public boolean isChecked() {
        return this.f19434x == 1;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f19424h && this.f19431q == null && this.f19432t == null) {
            setUseMaterialThemeColors(true);
        }
    }

    /* access modifiers changed from: protected */
    public int[] onCreateDrawableState(int i10) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i10 + 2);
        if (getCheckedState() == 2) {
            View.mergeDrawableStates(onCreateDrawableState, G);
        }
        if (d()) {
            View.mergeDrawableStates(onCreateDrawableState, H);
        }
        this.f19435y = jf.b.d(onCreateDrawableState);
        i();
        return onCreateDrawableState;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        Drawable a10;
        int i10;
        if (!this.f19425j || !TextUtils.isEmpty(getText()) || (a10 = d.a(this)) == null) {
            super.onDraw(canvas);
            return;
        }
        if (r.i(this)) {
            i10 = -1;
        } else {
            i10 = 1;
        }
        int width = ((getWidth() - a10.getIntrinsicWidth()) / 2) * i10;
        int save = canvas.save();
        canvas.translate((float) width, 0.0f);
        super.onDraw(canvas);
        canvas.restoreToCount(save);
        if (getBackground() != null) {
            Rect bounds = a10.getBounds();
            androidx.core.graphics.drawable.a.l(getBackground(), bounds.left + width, bounds.top, bounds.right + width, bounds.bottom);
        }
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        if (accessibilityNodeInfo != null && d()) {
            accessibilityNodeInfo.setText(accessibilityNodeInfo.getText() + ", " + this.f19427l);
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setCheckedState(savedState.f19437a);
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f19437a = getCheckedState();
        return savedState;
    }

    public void setButtonDrawable(int i10) {
        setButtonDrawable(e.a.b(getContext(), i10));
    }

    public void setButtonIconDrawable(Drawable drawable) {
        this.f19429n = drawable;
        e();
    }

    public void setButtonIconDrawableResource(int i10) {
        setButtonIconDrawable(e.a.b(getContext(), i10));
    }

    public void setButtonIconTintList(ColorStateList colorStateList) {
        if (this.f19432t != colorStateList) {
            this.f19432t = colorStateList;
            e();
        }
    }

    public void setButtonIconTintMode(@NonNull PorterDuff.Mode mode) {
        if (this.f19433w != mode) {
            this.f19433w = mode;
            e();
        }
    }

    public void setButtonTintList(ColorStateList colorStateList) {
        if (this.f19431q != colorStateList) {
            this.f19431q = colorStateList;
            e();
        }
    }

    public void setButtonTintMode(PorterDuff.Mode mode) {
        setSupportButtonTintMode(mode);
        e();
    }

    public void setCenterIfNoTextEnabled(boolean z10) {
        this.f19425j = z10;
    }

    public void setChecked(boolean z10) {
        setCheckedState(z10 ? 1 : 0);
    }

    public void setCheckedState(int i10) {
        boolean z10;
        AutofillManager autofillManager;
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener;
        if (this.f19434x != i10) {
            this.f19434x = i10;
            if (i10 == 1) {
                z10 = true;
            } else {
                z10 = false;
            }
            super.setChecked(z10);
            refreshDrawableState();
            f();
            if (!this.f19436z) {
                this.f19436z = true;
                LinkedHashSet<b> linkedHashSet = this.f19422f;
                if (linkedHashSet != null) {
                    Iterator<b> it = linkedHashSet.iterator();
                    while (it.hasNext()) {
                        it.next().a(this, this.f19434x);
                    }
                }
                if (!(this.f19434x == 2 || (onCheckedChangeListener = this.C) == null)) {
                    onCheckedChangeListener.onCheckedChanged(this, isChecked());
                }
                if (Build.VERSION.SDK_INT >= 26 && (autofillManager = (AutofillManager) getContext().getSystemService(AutofillManager.class)) != null) {
                    autofillManager.notifyValueChanged(this);
                }
                this.f19436z = false;
            }
        }
    }

    public void setEnabled(boolean z10) {
        super.setEnabled(z10);
        i();
    }

    public void setErrorAccessibilityLabel(CharSequence charSequence) {
        this.f19427l = charSequence;
    }

    public void setErrorAccessibilityLabelResource(int i10) {
        setErrorAccessibilityLabel(i10 != 0 ? getResources().getText(i10) : null);
    }

    public void setErrorShown(boolean z10) {
        if (this.f19426k != z10) {
            this.f19426k = z10;
            refreshDrawableState();
            Iterator<c> it = this.f19421e.iterator();
            while (it.hasNext()) {
                it.next().a(this, this.f19426k);
            }
        }
    }

    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.C = onCheckedChangeListener;
    }

    public void setStateDescription(CharSequence charSequence) {
        this.B = charSequence;
        if (charSequence == null) {
            f();
        } else {
            super.setStateDescription(charSequence);
        }
    }

    public void setUseMaterialThemeColors(boolean z10) {
        this.f19424h = z10;
        if (z10) {
            d.d(this, getMaterialThemeColorsTintList());
        } else {
            d.d(this, (ColorStateList) null);
        }
    }

    public void toggle() {
        setChecked(!isChecked());
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public MaterialCheckBox(android.content.Context r9, android.util.AttributeSet r10, int r11) {
        /*
            r8 = this;
            int r4 = F
            android.content.Context r9 = wf.a.c(r9, r10, r11, r4)
            r8.<init>(r9, r10, r11)
            java.util.LinkedHashSet r9 = new java.util.LinkedHashSet
            r9.<init>()
            r8.f19421e = r9
            java.util.LinkedHashSet r9 = new java.util.LinkedHashSet
            r9.<init>()
            r8.f19422f = r9
            android.content.Context r9 = r8.getContext()
            int r0 = bf.e.mtrl_checkbox_button_checked_unchecked
            androidx.vectordrawable.graphics.drawable.c r9 = androidx.vectordrawable.graphics.drawable.c.a(r9, r0)
            r8.D = r9
            com.google.android.material.checkbox.MaterialCheckBox$a r9 = new com.google.android.material.checkbox.MaterialCheckBox$a
            r9.<init>()
            r8.E = r9
            android.content.Context r9 = r8.getContext()
            android.graphics.drawable.Drawable r0 = androidx.core.widget.d.a(r8)
            r8.f19428m = r0
            android.content.res.ColorStateList r0 = r8.getSuperButtonTintList()
            r8.f19431q = r0
            r6 = 0
            r8.setSupportButtonTintList(r6)
            int[] r2 = bf.l.MaterialCheckBox
            r7 = 0
            int[] r5 = new int[r7]
            r0 = r9
            r1 = r10
            r3 = r11
            androidx.appcompat.widget.h1 r10 = com.google.android.material.internal.p.j(r0, r1, r2, r3, r4, r5)
            int r11 = bf.l.MaterialCheckBox_buttonIcon
            android.graphics.drawable.Drawable r11 = r10.g(r11)
            r8.f19429n = r11
            android.graphics.drawable.Drawable r11 = r8.f19428m
            r0 = 1
            if (r11 == 0) goto L_0x007c
            boolean r11 = com.google.android.material.internal.p.g(r9)
            if (r11 == 0) goto L_0x007c
            boolean r11 = r8.c(r10)
            if (r11 == 0) goto L_0x007c
            super.setButtonDrawable((android.graphics.drawable.Drawable) r6)
            int r11 = bf.e.mtrl_checkbox_button
            android.graphics.drawable.Drawable r11 = e.a.b(r9, r11)
            r8.f19428m = r11
            r8.f19430p = r0
            android.graphics.drawable.Drawable r11 = r8.f19429n
            if (r11 != 0) goto L_0x007c
            int r11 = bf.e.mtrl_checkbox_button_icon
            android.graphics.drawable.Drawable r11 = e.a.b(r9, r11)
            r8.f19429n = r11
        L_0x007c:
            int r11 = bf.l.MaterialCheckBox_buttonIconTint
            android.content.res.ColorStateList r9 = qf.c.b(r9, r10, r11)
            r8.f19432t = r9
            int r9 = bf.l.MaterialCheckBox_buttonIconTintMode
            r11 = -1
            int r9 = r10.k(r9, r11)
            android.graphics.PorterDuff$Mode r11 = android.graphics.PorterDuff.Mode.SRC_IN
            android.graphics.PorterDuff$Mode r9 = com.google.android.material.internal.r.j(r9, r11)
            r8.f19433w = r9
            int r9 = bf.l.MaterialCheckBox_useMaterialThemeColors
            boolean r9 = r10.a(r9, r7)
            r8.f19424h = r9
            int r9 = bf.l.MaterialCheckBox_centerIfNoTextEnabled
            boolean r9 = r10.a(r9, r0)
            r8.f19425j = r9
            int r9 = bf.l.MaterialCheckBox_errorShown
            boolean r9 = r10.a(r9, r7)
            r8.f19426k = r9
            int r9 = bf.l.MaterialCheckBox_errorAccessibilityLabel
            java.lang.CharSequence r9 = r10.p(r9)
            r8.f19427l = r9
            int r9 = bf.l.MaterialCheckBox_checkedState
            boolean r11 = r10.s(r9)
            if (r11 == 0) goto L_0x00c2
            int r9 = r10.k(r9, r7)
            r8.setCheckedState(r9)
        L_0x00c2:
            r10.w()
            r8.e()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.checkbox.MaterialCheckBox.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    public void setButtonDrawable(Drawable drawable) {
        this.f19428m = drawable;
        this.f19430p = false;
        e();
    }
}
