package com.coffeemeetsbagel.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.a;
import com.coffeemeetsbagel.cmb_views.CmbImageView;
import com.coffeemeetsbagel.cmb_views.CmbLinearLayout;
import com.coffeemeetsbagel.cmb_views.CmbTextView;
import com.coffeemeetsbagel.view.b;
import j5.x;
import java.util.ArrayList;
import lc.n;
import q5.i;
import q5.j;
import q5.k;
import q5.l;
import qj.q;

public class CmbToolbar extends ConstraintLayout {
    private CmbImageView F;
    private CmbTextView G;
    private CmbTextView H;
    private CmbLinearLayout I;
    private CmbImageView J;
    private CmbImageView K;
    private CmbTextView L;
    private CmbLinearLayout M;
    private RelativeLayout N;
    private CmbLinearLayout O;
    private CmbImageView P;
    private Drawable Q;
    private CmbImageView R;
    private CmbImageView S;
    private b T;

    public CmbToolbar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void D(int i10, View view, boolean z10) {
        ConstraintLayout.b bVar = (ConstraintLayout.b) view.getLayoutParams();
        boolean z11 = true;
        if ((view.getResources().getConfiguration().getLayoutDirection() != 1 || z10) && !z10) {
            z11 = false;
        }
        if (z11) {
            bVar.rightMargin = i10 - view.getWidth();
        } else {
            bVar.leftMargin = i10 - view.getWidth();
        }
        view.setLayoutParams(bVar);
    }

    private void E(boolean z10) {
        int i10;
        if (!F(this.M, this.O)) {
            if (z10) {
                i10 = Math.min(this.M.getWidth(), this.O.getWidth());
                if (i10 == 0) {
                    i10 = Math.max(this.M.getWidth(), this.O.getWidth());
                }
            } else {
                i10 = Math.max(this.M.getWidth(), this.O.getWidth());
            }
            if (i10 > 0) {
                D(i10, this.M, false);
                D(i10, this.O, true);
            }
        }
    }

    private boolean F(View view, View view2) {
        return M(view) == M(view2);
    }

    private int M(View view) {
        ConstraintLayout.b bVar = (ConstraintLayout.b) view.getLayoutParams();
        return view.getWidth() + bVar.leftMargin + bVar.rightMargin;
    }

    public void B(View view) {
        this.N.addView(view);
    }

    public void C(View view) {
        this.M.addView(view);
        E(false);
    }

    public q<x> G() {
        return this.I.a();
    }

    public void H(boolean z10) {
        if (z10) {
            n.a(getContext(), getLeftIcon().getDrawable().mutate(), i.main_color);
        } else {
            n.a(getContext(), getLeftIcon().getDrawable().mutate(), i.light_gray);
        }
    }

    /* access modifiers changed from: package-private */
    public void I() {
        this.T = null;
    }

    public void J() {
        this.M.removeAllViews();
    }

    public void K() {
        getLeftIcon().setEnabled(false);
        n.a(getContext(), getLeftIcon().getDrawable().mutate(), i.light_gray);
    }

    public void L() {
        getLeftIcon().setEnabled(true);
        n.a(getContext(), getLeftIcon().getDrawable().mutate(), i.main_color);
    }

    public void N() {
        this.I.setVisibility(8);
        E(true);
    }

    public void O() {
        this.P.setVisibility(8);
        E(true);
    }

    public void P() {
        this.F.setVisibility(8);
        this.O.setEnabled(false);
    }

    public void Q() {
        this.R.setVisibility(8);
        E(true);
    }

    public void R() {
        RelativeLayout relativeLayout = this.N;
        Resources resources = getResources();
        int i10 = j.spacer_2;
        relativeLayout.setPadding(0, resources.getDimensionPixelOffset(i10), 0, getResources().getDimensionPixelOffset(i10));
        this.H.setVisibility(8);
    }

    public q<x> S() {
        return this.P.c();
    }

    public q<x> T() {
        return this.O.a();
    }

    public q<x> U() {
        return this.K.c();
    }

    public void V(View view) {
        this.M.removeView(view);
        E(true);
    }

    public q<x> W() {
        return this.R.c();
    }

    public void X() {
        setDisplayHomeAsUp(true);
    }

    public void Y() {
        if (this.I.getParent() == null) {
            this.M.addView(this.I);
        }
        this.I.setVisibility(0);
        E(false);
    }

    public void Z(boolean z10) {
        if (z10) {
            if (this.S.getParent() == null) {
                this.M.addView(this.S);
            }
            this.S.setVisibility(0);
            E(false);
            return;
        }
        this.S.setVisibility(8);
        E(true);
    }

    public void a0() {
        if (this.P.getParent() == null) {
            this.M.addView(this.P);
        }
        this.P.setVisibility(0);
        E(false);
    }

    public void b0() {
        this.F.setVisibility(0);
        this.O.setEnabled(true);
    }

    public void c0(boolean z10) {
        if (this.R.getParent() == null) {
            this.M.addView(this.R);
        }
        if (z10) {
            n.a(getContext(), this.R.getDrawable().mutate(), i.main_color);
        } else {
            n.a(getContext(), this.R.getDrawable().mutate(), i.light_gray);
        }
        this.R.setVisibility(0);
        E(false);
    }

    public void d0() {
        RelativeLayout relativeLayout = this.N;
        Resources resources = getResources();
        int i10 = j.spacer_1;
        relativeLayout.setPadding(0, resources.getDimensionPixelOffset(i10), 0, getResources().getDimensionPixelOffset(i10));
        this.H.setVisibility(0);
    }

    public void e0(boolean z10, String str) {
        boolean z11;
        int i10;
        if (this.K.getParent() == null) {
            this.M.addView(this.K);
        }
        boolean z12 = true;
        if (!TextUtils.isEmpty(str)) {
            this.K.setContentDescription(str);
            this.K.setImportantForAccessibility(1);
        } else {
            this.K.setImportantForAccessibility(4);
        }
        if (this.K.getVisibility() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        CmbImageView cmbImageView = this.K;
        if (z10) {
            i10 = 0;
        } else {
            i10 = 8;
        }
        cmbImageView.setVisibility(i10);
        if (!z11 || z10) {
            z12 = false;
        }
        E(z12);
    }

    public b f0(b.a aVar) {
        if (this.T == null) {
            this.T = new b(aVar, this);
            ArrayList arrayList = new ArrayList();
            for (int i10 = 0; i10 < this.M.getChildCount(); i10++) {
                arrayList.add(this.M.getChildAt(i10));
            }
            this.T.c(arrayList);
            J();
            this.T.b(this.F.getDrawable());
            Drawable drawable = getResources().getDrawable(k.ic_back);
            n.a(getContext(), drawable, i.very_dark_gray);
            setLeftIcon(drawable);
            if (aVar.b(this.T)) {
                return this.T;
            }
            this.T.a();
            return null;
        }
        throw new IllegalStateException("CmbActionMode already started");
    }

    public View getHistoryIcon() {
        return this.P;
    }

    public CmbImageView getLeftIcon() {
        return this.F;
    }

    public RelativeLayout getMainContentHolder() {
        return this.N;
    }

    public CmbImageView getPaintedDoor() {
        return this.K;
    }

    public View getRewindIcon() {
        return this.R;
    }

    public View getSubTitleView() {
        return this.H;
    }

    /* access modifiers changed from: package-private */
    public String getTitleText() {
        return this.G.getText().toString();
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        this.F = (CmbImageView) findViewById(l.cmb_toolbar_left_icon);
        this.G = (CmbTextView) findViewById(l.cmb_toolbar_title);
        this.H = (CmbTextView) findViewById(l.cmb_toolbar_subtitle);
        this.I = (CmbLinearLayout) findViewById(l.cmb_toolbar_bean_shop);
        this.J = (CmbImageView) findViewById(l.bean_count_badge);
        this.L = (CmbTextView) findViewById(l.bean_count);
        this.M = (CmbLinearLayout) findViewById(l.cmb_toolbar_menu_items);
        this.N = (RelativeLayout) findViewById(l.cmb_toolbar_main_content_container);
        this.O = (CmbLinearLayout) findViewById(l.left_icon_holder);
        this.K = (CmbImageView) findViewById(l.cmb_toolbar_trailing_painted_door);
        this.P = (CmbImageView) findViewById(l.cmb_toolbar_history);
        this.S = (CmbImageView) findViewById(l.cta_match_prefs);
        this.R = (CmbImageView) findViewById(l.cmb_toolbar_rewind);
        this.F.setContentDescription(getResources().getString(q5.n.my_profile));
        int dimensionPixelSize = getResources().getDimensionPixelSize(j.margin_xsmall);
        Drawable drawable = a.getDrawable(getContext(), k.ic_single_bean);
        if (drawable != null) {
            Drawable r10 = androidx.core.graphics.drawable.a.r(drawable);
            androidx.core.graphics.drawable.a.n(r10, getResources().getColor(i.main_color));
            r10.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            this.L.setCompoundDrawables((Drawable) null, (Drawable) null, r10, (Drawable) null);
        }
        this.L.setGravity(17);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        E(false);
    }

    public void setBeanCount(String str) {
        this.L.setText(str);
    }

    public void setDisplayHomeAsUp(boolean z10) {
        if (z10) {
            this.F.setImageResource(k.arrow_back);
            this.F.setContentDescription(getResources().getString(q5.n.go_back));
            return;
        }
        Drawable drawable = this.Q;
        if (drawable != null) {
            this.F.setImageDrawable(drawable);
        }
    }

    public void setLeftIcon(Drawable drawable) {
        this.Q = drawable;
        this.F.setImageDrawable(drawable);
    }

    public void setMatchPrefsClickListener(View.OnClickListener onClickListener) {
        this.S.setOnClickListener(onClickListener);
    }

    public void setSubtitle(String str) {
        this.H.setText(str);
    }

    public void setTitle(String str) {
        this.G.setText(str);
    }

    public void setTitle(int i10) {
        this.G.setText(i10);
    }
}
