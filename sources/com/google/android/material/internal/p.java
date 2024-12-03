package com.google.android.material.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.h1;
import bf.b;
import bf.l;

public final class p {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f19893a = {b.colorPrimary};

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f19894b = {b.colorPrimaryVariant};

    public static void a(@NonNull Context context) {
        e(context, f19893a, "Theme.AppCompat");
    }

    private static void b(@NonNull Context context, AttributeSet attributeSet, int i10, int i11) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, l.ThemeEnforcement, i10, i11);
        boolean z10 = obtainStyledAttributes.getBoolean(l.ThemeEnforcement_enforceMaterialTheme, false);
        obtainStyledAttributes.recycle();
        if (z10) {
            TypedValue typedValue = new TypedValue();
            if (!context.getTheme().resolveAttribute(b.isMaterialTheme, typedValue, true) || (typedValue.type == 18 && typedValue.data == 0)) {
                c(context);
            }
        }
        a(context);
    }

    public static void c(@NonNull Context context) {
        e(context, f19894b, "Theme.MaterialComponents");
    }

    private static void d(@NonNull Context context, AttributeSet attributeSet, @NonNull int[] iArr, int i10, int i11, int... iArr2) {
        boolean z10;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, l.ThemeEnforcement, i10, i11);
        boolean z11 = false;
        if (!obtainStyledAttributes.getBoolean(l.ThemeEnforcement_enforceTextAppearance, false)) {
            obtainStyledAttributes.recycle();
            return;
        }
        if (iArr2 == null || iArr2.length == 0) {
            if (obtainStyledAttributes.getResourceId(l.ThemeEnforcement_android_textAppearance, -1) != -1) {
                z11 = true;
            }
            z10 = z11;
        } else {
            z10 = f(context, attributeSet, iArr, i10, i11, iArr2);
        }
        obtainStyledAttributes.recycle();
        if (!z10) {
            throw new IllegalArgumentException("This component requires that you specify a valid TextAppearance attribute. Update your app theme to inherit from Theme.MaterialComponents (or a descendant).");
        }
    }

    private static void e(@NonNull Context context, @NonNull int[] iArr, String str) {
        if (!h(context, iArr)) {
            throw new IllegalArgumentException("The style on this component requires your app theme to be " + str + " (or a descendant).");
        }
    }

    private static boolean f(@NonNull Context context, AttributeSet attributeSet, @NonNull int[] iArr, int i10, int i11, @NonNull int... iArr2) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i10, i11);
        for (int resourceId : iArr2) {
            if (obtainStyledAttributes.getResourceId(resourceId, -1) == -1) {
                obtainStyledAttributes.recycle();
                return false;
            }
        }
        obtainStyledAttributes.recycle();
        return true;
    }

    public static boolean g(@NonNull Context context) {
        return qf.b.b(context, b.isMaterial3Theme, false);
    }

    private static boolean h(@NonNull Context context, @NonNull int[] iArr) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(iArr);
        for (int i10 = 0; i10 < iArr.length; i10++) {
            if (!obtainStyledAttributes.hasValue(i10)) {
                obtainStyledAttributes.recycle();
                return false;
            }
        }
        obtainStyledAttributes.recycle();
        return true;
    }

    @NonNull
    public static TypedArray i(@NonNull Context context, AttributeSet attributeSet, @NonNull int[] iArr, int i10, int i11, int... iArr2) {
        b(context, attributeSet, i10, i11);
        d(context, attributeSet, iArr, i10, i11, iArr2);
        return context.obtainStyledAttributes(attributeSet, iArr, i10, i11);
    }

    public static h1 j(@NonNull Context context, AttributeSet attributeSet, @NonNull int[] iArr, int i10, int i11, int... iArr2) {
        b(context, attributeSet, i10, i11);
        d(context, attributeSet, iArr, i10, i11, iArr2);
        return h1.v(context, attributeSet, iArr, i10, i11);
    }
}
