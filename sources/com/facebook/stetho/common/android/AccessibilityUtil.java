package com.facebook.stetho.common.android;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AdapterView;
import android.widget.HorizontalScrollView;
import android.widget.ScrollView;
import android.widget.Spinner;
import androidx.core.view.accessibility.k;
import androidx.core.view.n0;
import java.util.List;
import net.bytebuddy.jar.asm.Opcodes;

public final class AccessibilityUtil {
    private AccessibilityUtil() {
    }

    public static boolean hasFocusableAncestor(k kVar, View view) {
        if (kVar == null || view == null) {
            return false;
        }
        ViewParent H = n0.H(view);
        if (!(H instanceof View)) {
            return false;
        }
        k N = k.N();
        try {
            n0.f0((View) H, N);
            if (N == null) {
                return false;
            }
            if (isAccessibilityFocusable(N, (View) H)) {
                N.R();
                return true;
            } else if (hasFocusableAncestor(N, (View) H)) {
                N.R();
                return true;
            } else {
                N.R();
                return false;
            }
        } finally {
            N.R();
        }
    }

    public static boolean hasNonActionableSpeakingDescendants(k kVar, View view) {
        if (!(kVar == null || view == null || !(view instanceof ViewGroup))) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = viewGroup.getChildAt(i10);
                if (childAt != null) {
                    k N = k.N();
                    try {
                        n0.f0(childAt, N);
                        if (!isAccessibilityFocusable(N, childAt)) {
                            if (isSpeakingNode(N, childAt)) {
                                N.R();
                                return true;
                            }
                        }
                    } finally {
                        N.R();
                    }
                }
            }
        }
        return false;
    }

    public static boolean hasText(k kVar) {
        if (kVar == null) {
            return false;
        }
        return !TextUtils.isEmpty(kVar.v()) || !TextUtils.isEmpty(kVar.q());
    }

    public static boolean isAccessibilityFocusable(k kVar, View view) {
        if (kVar == null || view == null || !kVar.M()) {
            return false;
        }
        if (isActionableForAccessibility(kVar)) {
            return true;
        }
        if (!isTopLevelScrollItem(kVar, view) || !isSpeakingNode(kVar, view)) {
            return false;
        }
        return true;
    }

    public static boolean isActionableForAccessibility(k kVar) {
        if (kVar == null) {
            return false;
        }
        if (kVar.D() || kVar.H() || kVar.F()) {
            return true;
        }
        List<k.a> h10 = kVar.h();
        if (h10.contains(16) || h10.contains(32) || h10.contains(1)) {
            return true;
        }
        return false;
    }

    public static boolean isSpeakingNode(k kVar, View view) {
        int z10;
        if (kVar == null || view == null || !kVar.M() || (z10 = n0.z(view)) == 4) {
            return false;
        }
        if (z10 == 2 && kVar.n() <= 0) {
            return false;
        }
        if (kVar.B() || hasText(kVar) || hasNonActionableSpeakingDescendants(kVar, view)) {
            return true;
        }
        return false;
    }

    public static boolean isTopLevelScrollItem(k kVar, View view) {
        View view2;
        if (kVar == null || view == null || (view2 = (View) n0.H(view)) == null) {
            return false;
        }
        if (kVar.J()) {
            return true;
        }
        List<k.a> h10 = kVar.h();
        if (h10.contains(Integer.valueOf(Opcodes.ACC_SYNTHETIC)) || h10.contains(8192)) {
            return true;
        }
        if (view2 instanceof Spinner) {
            return false;
        }
        if ((view2 instanceof AdapterView) || (view2 instanceof ScrollView) || (view2 instanceof HorizontalScrollView)) {
            return true;
        }
        return false;
    }
}
