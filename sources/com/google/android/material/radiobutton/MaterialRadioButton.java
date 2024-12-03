package com.google.android.material.radiobutton;

import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.r;
import androidx.core.widget.d;
import bf.b;
import bf.k;
import hf.a;

public class MaterialRadioButton extends r {

    /* renamed from: g  reason: collision with root package name */
    private static final int f19985g = k.Widget_MaterialComponents_CompoundButton_RadioButton;

    /* renamed from: h  reason: collision with root package name */
    private static final int[][] f19986h = {new int[]{16842910, 16842912}, new int[]{16842910, -16842912}, new int[]{-16842910, 16842912}, new int[]{-16842910, -16842912}};

    /* renamed from: e  reason: collision with root package name */
    private ColorStateList f19987e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f19988f;

    public MaterialRadioButton(@NonNull Context context, AttributeSet attributeSet) {
        this(context, attributeSet, b.radioButtonStyle);
    }

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.f19987e == null) {
            int d10 = a.d(this, b.colorControlActivated);
            int d11 = a.d(this, b.colorOnSurface);
            int d12 = a.d(this, b.colorSurface);
            int[][] iArr = f19986h;
            int[] iArr2 = new int[iArr.length];
            iArr2[0] = a.i(d12, d10, 1.0f);
            iArr2[1] = a.i(d12, d11, 0.54f);
            iArr2[2] = a.i(d12, d11, 0.38f);
            iArr2[3] = a.i(d12, d11, 0.38f);
            this.f19987e = new ColorStateList(iArr, iArr2);
        }
        return this.f19987e;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f19988f && d.b(this) == null) {
            setUseMaterialThemeColors(true);
        }
    }

    public void setUseMaterialThemeColors(boolean z10) {
        this.f19988f = z10;
        if (z10) {
            d.d(this, getMaterialThemeColorsTintList());
        } else {
            d.d(this, (ColorStateList) null);
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public MaterialRadioButton(@androidx.annotation.NonNull android.content.Context r8, android.util.AttributeSet r9, int r10) {
        /*
            r7 = this;
            int r4 = f19985g
            android.content.Context r8 = wf.a.c(r8, r9, r10, r4)
            r7.<init>(r8, r9, r10)
            android.content.Context r8 = r7.getContext()
            int[] r2 = bf.l.MaterialRadioButton
            r6 = 0
            int[] r5 = new int[r6]
            r0 = r8
            r1 = r9
            r3 = r10
            android.content.res.TypedArray r9 = com.google.android.material.internal.p.i(r0, r1, r2, r3, r4, r5)
            int r10 = bf.l.MaterialRadioButton_buttonTint
            boolean r0 = r9.hasValue(r10)
            if (r0 == 0) goto L_0x0028
            android.content.res.ColorStateList r8 = qf.c.a(r8, r9, r10)
            androidx.core.widget.d.d(r7, r8)
        L_0x0028:
            int r8 = bf.l.MaterialRadioButton_useMaterialThemeColors
            boolean r8 = r9.getBoolean(r8, r6)
            r7.f19988f = r8
            r9.recycle()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.radiobutton.MaterialRadioButton.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }
}
