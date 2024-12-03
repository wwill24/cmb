package com.facebook.stetho.inspector.elements.android;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.EditText;
import androidx.core.view.accessibility.k;
import androidx.core.view.n0;
import com.facebook.stetho.common.android.AccessibilityUtil;
import net.bytebuddy.jar.asm.Opcodes;

public final class AccessibilityNodeInfoWrapper {
    public static k createNodeInfoFromView(View view) {
        k N = k.N();
        n0.f0(view, N);
        return N;
    }

    public static String getActions(View view) {
        String str;
        k createNodeInfoFromView = createNodeInfoFromView(view);
        try {
            StringBuilder sb2 = new StringBuilder();
            for (k.a next : createNodeInfoFromView.h()) {
                if (sb2.length() > 0) {
                    sb2.append(", ");
                }
                int b10 = next.b();
                if (b10 == 1) {
                    sb2.append("focus");
                } else if (b10 != 2) {
                    switch (b10) {
                        case 4:
                            sb2.append("select");
                            break;
                        case 8:
                            sb2.append("clear-selection");
                            break;
                        case 16:
                            sb2.append("click");
                            break;
                        case 32:
                            sb2.append("long-click");
                            break;
                        case 64:
                            sb2.append("accessibility-focus");
                            break;
                        case 128:
                            sb2.append("clear-accessibility-focus");
                            break;
                        case 256:
                            sb2.append("next-at-movement-granularity");
                            break;
                        case 512:
                            sb2.append("previous-at-movement-granularity");
                            break;
                        case 1024:
                            sb2.append("next-html-element");
                            break;
                        case 2048:
                            sb2.append("previous-html-element");
                            break;
                        case Opcodes.ACC_SYNTHETIC:
                            sb2.append("scroll-forward");
                            break;
                        case 8192:
                            sb2.append("scroll-backward");
                            break;
                        case Opcodes.ACC_ENUM:
                            sb2.append("copy");
                            break;
                        case 32768:
                            sb2.append("paste");
                            break;
                        case 65536:
                            sb2.append("cut");
                            break;
                        case Opcodes.ACC_DEPRECATED:
                            sb2.append("set-selection");
                            break;
                        default:
                            CharSequence c10 = next.c();
                            if (c10 == null) {
                                sb2.append("unknown");
                                break;
                            } else {
                                sb2.append(c10);
                                break;
                            }
                    }
                } else {
                    sb2.append("clear-focus");
                }
            }
            if (sb2.length() > 0) {
                str = sb2.toString();
            } else {
                str = null;
            }
            return str;
        } finally {
            createNodeInfoFromView.R();
        }
    }

    public static CharSequence getDescription(View view) {
        boolean z10;
        CharSequence charSequence;
        k createNodeInfoFromView = createNodeInfoFromView(view);
        try {
            CharSequence q10 = createNodeInfoFromView.q();
            CharSequence v10 = createNodeInfoFromView.v();
            if (!TextUtils.isEmpty(v10)) {
                z10 = true;
            } else {
                z10 = false;
            }
            boolean z11 = view instanceof EditText;
            if (!TextUtils.isEmpty(q10) && (!z11 || !z10)) {
                return q10;
            }
            if (z10) {
                createNodeInfoFromView.R();
                return v10;
            }
            String str = null;
            if (view instanceof ViewGroup) {
                StringBuilder sb2 = new StringBuilder();
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i10 = 0; i10 < childCount; i10++) {
                    View childAt = viewGroup.getChildAt(i10);
                    k N = k.N();
                    n0.f0(childAt, N);
                    if (!AccessibilityUtil.isSpeakingNode(N, childAt) || AccessibilityUtil.isAccessibilityFocusable(N, childAt)) {
                        charSequence = null;
                    } else {
                        charSequence = getDescription(childAt);
                    }
                    if (!TextUtils.isEmpty(charSequence)) {
                        if (sb2.length() > 0) {
                            sb2.append(", ");
                        }
                        sb2.append(charSequence);
                    }
                    N.R();
                }
                if (sb2.length() > 0) {
                    str = sb2.toString();
                }
                createNodeInfoFromView.R();
                return str;
            }
            createNodeInfoFromView.R();
            return null;
        } finally {
            createNodeInfoFromView.R();
        }
    }

    public static String getFocusableReasons(View view) {
        k createNodeInfoFromView = createNodeInfoFromView(view);
        try {
            boolean hasText = AccessibilityUtil.hasText(createNodeInfoFromView);
            boolean B = createNodeInfoFromView.B();
            boolean hasNonActionableSpeakingDescendants = AccessibilityUtil.hasNonActionableSpeakingDescendants(createNodeInfoFromView, view);
            if (AccessibilityUtil.isActionableForAccessibility(createNodeInfoFromView)) {
                if (createNodeInfoFromView.n() <= 0) {
                    return "View is actionable and has no children.";
                }
                if (hasText) {
                    createNodeInfoFromView.R();
                    return "View is actionable and has a description.";
                } else if (B) {
                    createNodeInfoFromView.R();
                    return "View is actionable and checkable.";
                } else if (hasNonActionableSpeakingDescendants) {
                    createNodeInfoFromView.R();
                    return "View is actionable and has non-actionable descendants with descriptions.";
                }
            }
            if (AccessibilityUtil.isTopLevelScrollItem(createNodeInfoFromView, view)) {
                if (hasText) {
                    createNodeInfoFromView.R();
                    return "View is a direct child of a scrollable container and has a description.";
                } else if (B) {
                    createNodeInfoFromView.R();
                    return "View is a direct child of a scrollable container and is checkable.";
                } else if (hasNonActionableSpeakingDescendants) {
                    createNodeInfoFromView.R();
                    return "View is a direct child of a scrollable container and has non-actionable descendants with descriptions.";
                }
            }
            if (hasText) {
                createNodeInfoFromView.R();
                return "View has a description and is not actionable, but has no actionable ancestor.";
            }
            createNodeInfoFromView.R();
            return null;
        } finally {
            createNodeInfoFromView.R();
        }
    }

    public static boolean getIgnored(View view) {
        int z10 = n0.z(view);
        if (z10 == 2 || z10 == 4) {
            return true;
        }
        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
            if (n0.z((View) parent) == 4) {
                return true;
            }
        }
        k createNodeInfoFromView = createNodeInfoFromView(view);
        try {
            if (!createNodeInfoFromView.M()) {
                return true;
            }
            if (AccessibilityUtil.isAccessibilityFocusable(createNodeInfoFromView, view)) {
                if (createNodeInfoFromView.n() <= 0) {
                    createNodeInfoFromView.R();
                    return false;
                } else if (AccessibilityUtil.isSpeakingNode(createNodeInfoFromView, view)) {
                    createNodeInfoFromView.R();
                    return false;
                } else {
                    createNodeInfoFromView.R();
                    return true;
                }
            } else if (AccessibilityUtil.hasFocusableAncestor(createNodeInfoFromView, view) || !AccessibilityUtil.hasText(createNodeInfoFromView)) {
                createNodeInfoFromView.R();
                return true;
            } else {
                createNodeInfoFromView.R();
                return false;
            }
        } finally {
            createNodeInfoFromView.R();
        }
    }

    public static String getIgnoredReasons(View view) {
        int z10 = n0.z(view);
        if (z10 == 2) {
            return "View has importantForAccessibility set to 'NO'.";
        }
        if (z10 == 4) {
            return "View has importantForAccessibility set to 'NO_HIDE_DESCENDANTS'.";
        }
        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
            if (n0.z((View) parent) == 4) {
                return "An ancestor View has importantForAccessibility set to 'NO_HIDE_DESCENDANTS'.";
            }
        }
        k createNodeInfoFromView = createNodeInfoFromView(view);
        try {
            if (!createNodeInfoFromView.M()) {
                return "View is not visible.";
            }
            if (AccessibilityUtil.isAccessibilityFocusable(createNodeInfoFromView, view)) {
                createNodeInfoFromView.R();
                return "View is actionable, but has no description.";
            } else if (AccessibilityUtil.hasText(createNodeInfoFromView)) {
                createNodeInfoFromView.R();
                return "View is not actionable, and an ancestor View has co-opted its description.";
            } else {
                createNodeInfoFromView.R();
                return "View is not actionable and has no description.";
            }
        } finally {
            createNodeInfoFromView.R();
        }
    }

    public static boolean getIsAccessibilityFocused(View view) {
        k createNodeInfoFromView = createNodeInfoFromView(view);
        boolean A = createNodeInfoFromView.A();
        createNodeInfoFromView.R();
        return A;
    }
}
