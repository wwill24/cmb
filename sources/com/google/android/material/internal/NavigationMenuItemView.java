package com.google.android.material.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.i;
import androidx.appcompat.view.menu.n;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.appcompat.widget.n1;
import androidx.core.content.res.h;
import androidx.core.view.accessibility.k;
import androidx.core.view.n0;
import androidx.core.widget.l;
import bf.d;
import bf.e;
import bf.f;

public class NavigationMenuItemView extends i implements n.a {
    private static final int[] M = {16842912};
    private int C;
    private boolean D;
    boolean E;
    private final CheckedTextView F;
    private FrameLayout G;
    private i H;
    private ColorStateList I;
    private boolean J;
    private Drawable K;
    private final androidx.core.view.a L;

    class a extends androidx.core.view.a {
        a() {
        }

        public void g(View view, @NonNull k kVar) {
            super.g(view, kVar);
            kVar.Y(NavigationMenuItemView.this.E);
        }
    }

    public NavigationMenuItemView(@NonNull Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private StateListDrawable A() {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(d.a.colorControlHighlight, typedValue, true)) {
            return null;
        }
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(M, new ColorDrawable(typedValue.data));
        stateListDrawable.addState(ViewGroup.EMPTY_STATE_SET, new ColorDrawable(0));
        return stateListDrawable;
    }

    private boolean B() {
        if (this.H.getTitle() == null && this.H.getIcon() == null && this.H.getActionView() != null) {
            return true;
        }
        return false;
    }

    private void setActionView(View view) {
        if (view != null) {
            if (this.G == null) {
                this.G = (FrameLayout) ((ViewStub) findViewById(f.design_menu_item_action_area_stub)).inflate();
            }
            this.G.removeAllViews();
            this.G.addView(view);
        }
    }

    private void z() {
        if (B()) {
            this.F.setVisibility(8);
            FrameLayout frameLayout = this.G;
            if (frameLayout != null) {
                LinearLayoutCompat.a aVar = (LinearLayoutCompat.a) frameLayout.getLayoutParams();
                aVar.width = -1;
                this.G.setLayoutParams(aVar);
                return;
            }
            return;
        }
        this.F.setVisibility(0);
        FrameLayout frameLayout2 = this.G;
        if (frameLayout2 != null) {
            LinearLayoutCompat.a aVar2 = (LinearLayoutCompat.a) frameLayout2.getLayoutParams();
            aVar2.width = -2;
            this.G.setLayoutParams(aVar2);
        }
    }

    public void c(@NonNull i iVar, int i10) {
        int i11;
        this.H = iVar;
        if (iVar.getItemId() > 0) {
            setId(iVar.getItemId());
        }
        if (iVar.isVisible()) {
            i11 = 0;
        } else {
            i11 = 8;
        }
        setVisibility(i11);
        if (getBackground() == null) {
            n0.w0(this, A());
        }
        setCheckable(iVar.isCheckable());
        setChecked(iVar.isChecked());
        setEnabled(iVar.isEnabled());
        setTitle(iVar.getTitle());
        setIcon(iVar.getIcon());
        setActionView(iVar.getActionView());
        setContentDescription(iVar.getContentDescription());
        n1.a(this, iVar.getTooltipText());
        z();
    }

    public boolean d() {
        return false;
    }

    public i getItemData() {
        return this.H;
    }

    /* access modifiers changed from: protected */
    public int[] onCreateDrawableState(int i10) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i10 + 1);
        i iVar = this.H;
        if (iVar != null && iVar.isCheckable() && this.H.isChecked()) {
            View.mergeDrawableStates(onCreateDrawableState, M);
        }
        return onCreateDrawableState;
    }

    public void setCheckable(boolean z10) {
        refreshDrawableState();
        if (this.E != z10) {
            this.E = z10;
            this.L.l(this.F, 2048);
        }
    }

    public void setChecked(boolean z10) {
        refreshDrawableState();
        this.F.setChecked(z10);
        CheckedTextView checkedTextView = this.F;
        checkedTextView.setTypeface(checkedTextView.getTypeface(), z10 ? 1 : 0);
    }

    public void setHorizontalPadding(int i10) {
        setPadding(i10, getPaddingTop(), i10, getPaddingBottom());
    }

    public void setIcon(Drawable drawable) {
        if (drawable != null) {
            if (this.J) {
                Drawable.ConstantState constantState = drawable.getConstantState();
                if (constantState != null) {
                    drawable = constantState.newDrawable();
                }
                drawable = androidx.core.graphics.drawable.a.r(drawable).mutate();
                androidx.core.graphics.drawable.a.o(drawable, this.I);
            }
            int i10 = this.C;
            drawable.setBounds(0, 0, i10, i10);
        } else if (this.D) {
            if (this.K == null) {
                Drawable e10 = h.e(getResources(), e.navigation_empty_icon, getContext().getTheme());
                this.K = e10;
                if (e10 != null) {
                    int i11 = this.C;
                    e10.setBounds(0, 0, i11, i11);
                }
            }
            drawable = this.K;
        }
        l.n(this.F, drawable, (Drawable) null, (Drawable) null, (Drawable) null);
    }

    public void setIconPadding(int i10) {
        this.F.setCompoundDrawablePadding(i10);
    }

    public void setIconSize(int i10) {
        this.C = i10;
    }

    /* access modifiers changed from: package-private */
    public void setIconTintList(ColorStateList colorStateList) {
        boolean z10;
        this.I = colorStateList;
        if (colorStateList != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.J = z10;
        i iVar = this.H;
        if (iVar != null) {
            setIcon(iVar.getIcon());
        }
    }

    public void setMaxLines(int i10) {
        this.F.setMaxLines(i10);
    }

    public void setNeedsEmptyIcon(boolean z10) {
        this.D = z10;
    }

    public void setTextAppearance(int i10) {
        l.s(this.F, i10);
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.F.setTextColor(colorStateList);
    }

    public void setTitle(CharSequence charSequence) {
        this.F.setText(charSequence);
    }

    public NavigationMenuItemView(@NonNull Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        a aVar = new a();
        this.L = aVar;
        setOrientation(0);
        LayoutInflater.from(context).inflate(bf.h.design_navigation_menu_item, this, true);
        setIconSize(context.getResources().getDimensionPixelSize(d.design_navigation_icon_size));
        CheckedTextView checkedTextView = (CheckedTextView) findViewById(f.design_menu_item_text);
        this.F = checkedTextView;
        checkedTextView.setDuplicateParentStateEnabled(true);
        n0.s0(checkedTextView, aVar);
    }
}
