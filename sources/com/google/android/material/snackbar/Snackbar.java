package com.google.android.material.snackbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import bf.b;
import bf.h;
import com.google.android.material.snackbar.BaseTransientBottomBar;

public class Snackbar extends BaseTransientBottomBar<Snackbar> {
    private static final int[] I;
    private static final int[] J;
    private final AccessibilityManager G;
    private boolean H;

    public static final class SnackbarLayout extends BaseTransientBottomBar.t {
        public SnackbarLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        /* access modifiers changed from: protected */
        public void onMeasure(int i10, int i11) {
            super.onMeasure(i10, i11);
            int childCount = getChildCount();
            int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            for (int i12 = 0; i12 < childCount; i12++) {
                View childAt = getChildAt(i12);
                if (childAt.getLayoutParams().width == -1) {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(childAt.getMeasuredHeight(), 1073741824));
                }
            }
        }

        public /* bridge */ /* synthetic */ void setBackground(Drawable drawable) {
            super.setBackground(drawable);
        }

        public /* bridge */ /* synthetic */ void setBackgroundDrawable(Drawable drawable) {
            super.setBackgroundDrawable(drawable);
        }

        public /* bridge */ /* synthetic */ void setBackgroundTintList(ColorStateList colorStateList) {
            super.setBackgroundTintList(colorStateList);
        }

        public /* bridge */ /* synthetic */ void setBackgroundTintMode(PorterDuff.Mode mode) {
            super.setBackgroundTintMode(mode);
        }

        public /* bridge */ /* synthetic */ void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
            super.setLayoutParams(layoutParams);
        }

        public /* bridge */ /* synthetic */ void setOnClickListener(View.OnClickListener onClickListener) {
            super.setOnClickListener(onClickListener);
        }
    }

    public static class a extends BaseTransientBottomBar.r<Snackbar> {
        /* renamed from: c */
        public void b(Snackbar snackbar) {
        }
    }

    static {
        int i10 = b.snackbarButtonStyle;
        I = new int[]{i10};
        J = new int[]{i10, b.snackbarTextViewStyle};
    }

    private Snackbar(@NonNull Context context, @NonNull ViewGroup viewGroup, @NonNull View view, @NonNull a aVar) {
        super(context, viewGroup, view, aVar);
        this.G = (AccessibilityManager) viewGroup.getContext().getSystemService("accessibility");
    }

    private static ViewGroup j0(View view) {
        ViewGroup viewGroup = null;
        while (!(view instanceof CoordinatorLayout)) {
            if (view instanceof FrameLayout) {
                if (view.getId() == 16908290) {
                    return (ViewGroup) view;
                }
                viewGroup = (ViewGroup) view;
            }
            if (view != null) {
                ViewParent parent = view.getParent();
                if (parent instanceof View) {
                    view = (View) parent;
                    continue;
                } else {
                    view = null;
                    continue;
                }
            }
            if (view == null) {
                return viewGroup;
            }
        }
        return (ViewGroup) view;
    }

    private SnackbarContentLayout k0() {
        return (SnackbarContentLayout) this.f20079i.getChildAt(0);
    }

    private TextView l0() {
        return k0().getMessageView();
    }

    private static boolean m0(@NonNull Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(J);
        int resourceId = obtainStyledAttributes.getResourceId(0, -1);
        int resourceId2 = obtainStyledAttributes.getResourceId(1, -1);
        obtainStyledAttributes.recycle();
        if (resourceId == -1 || resourceId2 == -1) {
            return false;
        }
        return true;
    }

    @NonNull
    public static Snackbar n0(@NonNull View view, @NonNull CharSequence charSequence, int i10) {
        return o0((Context) null, view, charSequence, i10);
    }

    @NonNull
    private static Snackbar o0(Context context, @NonNull View view, @NonNull CharSequence charSequence, int i10) {
        int i11;
        ViewGroup j02 = j0(view);
        if (j02 != null) {
            if (context == null) {
                context = j02.getContext();
            }
            LayoutInflater from = LayoutInflater.from(context);
            if (m0(context)) {
                i11 = h.mtrl_layout_snackbar_include;
            } else {
                i11 = h.design_layout_snackbar_include;
            }
            SnackbarContentLayout snackbarContentLayout = (SnackbarContentLayout) from.inflate(i11, j02, false);
            Snackbar snackbar = new Snackbar(context, j02, snackbarContentLayout, snackbarContentLayout);
            snackbar.p0(charSequence);
            snackbar.X(i10);
            return snackbar;
        }
        throw new IllegalArgumentException("No suitable parent found from the given view. Please provide a valid view.");
    }

    public void A() {
        super.A();
    }

    public int E() {
        int i10;
        int E = super.E();
        if (E == -2) {
            return -2;
        }
        if (Build.VERSION.SDK_INT >= 29) {
            if (this.H) {
                i10 = 4;
            } else {
                i10 = 0;
            }
            return this.G.getRecommendedTimeoutMillis(E, i10 | 1 | 2);
        } else if (!this.H || !this.G.isTouchExplorationEnabled()) {
            return E;
        } else {
            return -2;
        }
    }

    public void b0() {
        super.b0();
    }

    @NonNull
    public Snackbar p0(@NonNull CharSequence charSequence) {
        l0().setText(charSequence);
        return this;
    }

    @NonNull
    public Snackbar q0(int i10) {
        l0().setMaxLines(i10);
        return this;
    }
}
