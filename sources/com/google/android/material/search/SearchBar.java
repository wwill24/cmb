package com.google.android.material.search;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.n0;
import androidx.customview.view.AbsSavedState;
import bf.b;
import bf.d;
import bf.k;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.internal.q;
import hf.a;
import tf.g;
import tf.h;

public class SearchBar extends Toolbar {

    /* renamed from: q0  reason: collision with root package name */
    private static final int f19989q0 = k.Widget_Material3_SearchBar;

    /* renamed from: e0  reason: collision with root package name */
    private final TextView f19990e0;

    /* renamed from: f0  reason: collision with root package name */
    private final boolean f19991f0;

    /* renamed from: g0  reason: collision with root package name */
    private final boolean f19992g0;

    /* renamed from: h0  reason: collision with root package name */
    private final Drawable f19993h0;

    /* renamed from: i0  reason: collision with root package name */
    private final boolean f19994i0;

    /* renamed from: j0  reason: collision with root package name */
    private final boolean f19995j0;

    /* renamed from: k0  reason: collision with root package name */
    private View f19996k0;

    /* renamed from: l0  reason: collision with root package name */
    private Integer f19997l0;

    /* renamed from: m0  reason: collision with root package name */
    private Drawable f19998m0;

    /* renamed from: n0  reason: collision with root package name */
    private int f19999n0;

    /* renamed from: o0  reason: collision with root package name */
    private boolean f20000o0;

    /* renamed from: p0  reason: collision with root package name */
    private g f20001p0;

    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: c  reason: collision with root package name */
        String f20002c;

        class a implements Parcelable.ClassLoaderCreator<SavedState> {
            a() {
            }

            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* renamed from: b */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            /* renamed from: c */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        public SavedState(Parcel parcel) {
            this(parcel, (ClassLoader) null);
        }

        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeString(this.f20002c);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f20002c = parcel.readString();
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    private int T(int i10, int i11) {
        return i10 == 0 ? i11 : i10;
    }

    private void U() {
        View view = this.f19996k0;
        if (view != null) {
            int measuredWidth = view.getMeasuredWidth();
            int measuredWidth2 = (getMeasuredWidth() / 2) - (measuredWidth / 2);
            int i10 = measuredWidth2 + measuredWidth;
            int measuredHeight = this.f19996k0.getMeasuredHeight();
            int measuredHeight2 = (getMeasuredHeight() / 2) - (measuredHeight / 2);
            V(this.f19996k0, measuredWidth2, measuredHeight2, i10, measuredHeight2 + measuredHeight);
        }
    }

    private void V(View view, int i10, int i11, int i12, int i13) {
        if (n0.B(this) == 1) {
            view.layout(getMeasuredWidth() - i12, i11, getMeasuredWidth() - i10, i13);
        } else {
            view.layout(i10, i11, i12, i13);
        }
    }

    private Drawable W(Drawable drawable) {
        int i10;
        int i11;
        if (!this.f19994i0 || drawable == null) {
            return drawable;
        }
        Integer num = this.f19997l0;
        if (num != null) {
            i10 = num.intValue();
        } else {
            if (drawable == this.f19993h0) {
                i11 = b.colorOnSurfaceVariant;
            } else {
                i11 = b.colorOnSurface;
            }
            i10 = a.d(this, i11);
        }
        Drawable r10 = androidx.core.graphics.drawable.a.r(drawable.mutate());
        androidx.core.graphics.drawable.a.n(r10, i10);
        return r10;
    }

    private void X(int i10, int i11) {
        View view = this.f19996k0;
        if (view != null) {
            view.measure(i10, i11);
        }
    }

    private void Y() {
        if (this.f19992g0 && (getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            Resources resources = getResources();
            int dimensionPixelSize = resources.getDimensionPixelSize(d.m3_searchbar_margin_horizontal);
            int dimensionPixelSize2 = resources.getDimensionPixelSize(d.m3_searchbar_margin_vertical);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) getLayoutParams();
            marginLayoutParams.leftMargin = T(marginLayoutParams.leftMargin, dimensionPixelSize);
            marginLayoutParams.topMargin = T(marginLayoutParams.topMargin, dimensionPixelSize2);
            marginLayoutParams.rightMargin = T(marginLayoutParams.rightMargin, dimensionPixelSize);
            marginLayoutParams.bottomMargin = T(marginLayoutParams.bottomMargin, dimensionPixelSize2);
        }
    }

    private void Z() {
        if (getLayoutParams() instanceof AppBarLayout.e) {
            AppBarLayout.e eVar = (AppBarLayout.e) getLayoutParams();
            if (this.f20000o0) {
                if (eVar.c() == 0) {
                    eVar.g(53);
                }
            } else if (eVar.c() == 53) {
                eVar.g(0);
            }
        }
    }

    private void setNavigationIconDecorative(boolean z10) {
        Drawable drawable;
        ImageButton c10 = q.c(this);
        if (c10 != null) {
            c10.setClickable(!z10);
            c10.setFocusable(!z10);
            Drawable background = c10.getBackground();
            if (background != null) {
                this.f19998m0 = background;
            }
            if (z10) {
                drawable = null;
            } else {
                drawable = this.f19998m0;
            }
            c10.setBackgroundDrawable(drawable);
        }
    }

    public void addView(View view, int i10, ViewGroup.LayoutParams layoutParams) {
        if (this.f19991f0 && this.f19996k0 == null && !(view instanceof ActionMenuView)) {
            this.f19996k0 = view;
            view.setAlpha(0.0f);
        }
        super.addView(view, i10, layoutParams);
    }

    public View getCenterView() {
        return this.f19996k0;
    }

    /* access modifiers changed from: package-private */
    public float getCompatElevation() {
        g gVar = this.f20001p0;
        return gVar != null ? gVar.w() : n0.w(this);
    }

    public float getCornerSize() {
        return this.f20001p0.J();
    }

    public CharSequence getHint() {
        return this.f19990e0.getHint();
    }

    /* access modifiers changed from: package-private */
    public int getMenuResId() {
        return this.f19999n0;
    }

    public int getStrokeColor() {
        return this.f20001p0.F().getDefaultColor();
    }

    public float getStrokeWidth() {
        return this.f20001p0.H();
    }

    public CharSequence getText() {
        return this.f19990e0.getText();
    }

    @NonNull
    public TextView getTextView() {
        return this.f19990e0;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        h.f(this, this.f20001p0);
        Y();
        Z();
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(EditText.class.getCanonicalName());
        CharSequence text = getText();
        boolean isEmpty = TextUtils.isEmpty(text);
        if (Build.VERSION.SDK_INT >= 26) {
            accessibilityNodeInfo.setHintText(getHint());
            accessibilityNodeInfo.setShowingHintText(isEmpty);
        }
        if (isEmpty) {
            text = getHint();
        }
        accessibilityNodeInfo.setText(text);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        U();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        X(i10, i11);
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        setText((CharSequence) savedState.f20002c);
    }

    /* access modifiers changed from: protected */
    @NonNull
    public Parcelable onSaveInstanceState() {
        String str;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        CharSequence text = getText();
        if (text == null) {
            str = null;
        } else {
            str = text.toString();
        }
        savedState.f20002c = str;
        return savedState;
    }

    public void setCenterView(View view) {
        View view2 = this.f19996k0;
        if (view2 != null) {
            removeView(view2);
            this.f19996k0 = null;
        }
        if (view != null) {
            addView(view);
        }
    }

    public void setDefaultScrollFlagsEnabled(boolean z10) {
        this.f20000o0 = z10;
        Z();
    }

    public void setElevation(float f10) {
        super.setElevation(f10);
        g gVar = this.f20001p0;
        if (gVar != null) {
            gVar.a0(f10);
        }
    }

    public void setHint(CharSequence charSequence) {
        this.f19990e0.setHint(charSequence);
    }

    public void setNavigationIcon(Drawable drawable) {
        super.setNavigationIcon(W(drawable));
    }

    public void setNavigationOnClickListener(View.OnClickListener onClickListener) {
        boolean z10;
        if (!this.f19995j0) {
            super.setNavigationOnClickListener(onClickListener);
            if (onClickListener == null) {
                z10 = true;
            } else {
                z10 = false;
            }
            setNavigationIconDecorative(z10);
        }
    }

    public void setOnLoadAnimationFadeInEnabled(boolean z10) {
        throw null;
    }

    public void setStrokeColor(int i10) {
        if (getStrokeColor() != i10) {
            this.f20001p0.j0(ColorStateList.valueOf(i10));
        }
    }

    public void setStrokeWidth(float f10) {
        if (getStrokeWidth() != f10) {
            this.f20001p0.k0(f10);
        }
    }

    public void setSubtitle(CharSequence charSequence) {
    }

    public void setText(CharSequence charSequence) {
        this.f19990e0.setText(charSequence);
    }

    public void setTitle(CharSequence charSequence) {
    }

    public void x(int i10) {
        super.x(i10);
        this.f19999n0 = i10;
    }

    public static class ScrollingViewBehavior extends AppBarLayout.ScrollingViewBehavior {

        /* renamed from: h  reason: collision with root package name */
        private boolean f20003h = false;

        public ScrollingViewBehavior() {
        }

        private void U(AppBarLayout appBarLayout) {
            appBarLayout.setBackgroundColor(0);
            appBarLayout.setTargetElevation(0.0f);
        }

        /* access modifiers changed from: protected */
        public boolean P() {
            return true;
        }

        public boolean h(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull View view2) {
            boolean h10 = super.h(coordinatorLayout, view, view2);
            if (!this.f20003h && (view2 instanceof AppBarLayout)) {
                this.f20003h = true;
                U((AppBarLayout) view2);
            }
            return h10;
        }

        public ScrollingViewBehavior(@NonNull Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    public void setHint(int i10) {
        this.f19990e0.setHint(i10);
    }

    public void setText(int i10) {
        this.f19990e0.setText(i10);
    }
}
