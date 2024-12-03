package com.coffeemeetsbagel.cmb_views;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.mparticle.identity.IdentityHttpResponse;
import fa.a;
import kotlin.jvm.internal.j;
import q5.g;
import q5.n;
import q5.p;

public final class ExpandingView extends ConstraintLayout {
    private final String F = ExpandingView.class.getSimpleName();
    private final int G;
    private final int H;
    private final int I;
    private boolean J;
    private TextView K;
    private View L;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ExpandingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        j.g(context, IdentityHttpResponse.CONTEXT);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, p.ExpandingView, 0, 0);
        j.f(obtainStyledAttributes, "context.obtainStyledAttr…able.ExpandingView, 0, 0)");
        try {
            this.G = obtainStyledAttributes.getDimensionPixelSize(p.ExpandingView_peekHeight, 0);
            this.H = obtainStyledAttributes.getResourceId(p.ExpandingView_expandButtonId, 0);
            this.I = obtainStyledAttributes.getResourceId(p.ExpandingView_childContainerId, 0);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    /* access modifiers changed from: private */
    public static final void C(ExpandingView expandingView, View view) {
        j.g(expandingView, "this$0");
        expandingView.E();
    }

    private final void E() {
        View view = this.L;
        if (view != null) {
            this.J = !this.J;
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (this.J) {
                layoutParams.height = -2;
            } else {
                layoutParams.height = this.G;
            }
            view.setLayoutParams(layoutParams);
            if (this.J) {
                TextView textView = this.K;
                if (textView != null) {
                    textView.setText(getContext().getString(n.hide));
                    return;
                }
                return;
            }
            TextView textView2 = this.K;
            if (textView2 != null) {
                textView2.setText(getContext().getString(n.expand));
            }
        }
    }

    public final void D() {
        if (this.J) {
            E();
        }
    }

    public void addView(View view, int i10, ViewGroup.LayoutParams layoutParams) {
        Integer num;
        super.addView(view, i10, layoutParams);
        if (view != null) {
            num = Integer.valueOf(view.getId());
        } else {
            num = null;
        }
        int i11 = this.H;
        if (num != null && num.intValue() == i11) {
            if (view instanceof TextView) {
                this.K = (TextView) view;
            } else {
                a.C0491a aVar = a.f40771d;
                String str = this.F;
                j.f(str, "tag");
                aVar.b(str, view.getClass().getSimpleName() + " needs to be a TextView.");
            }
            TextView textView = this.K;
            if (textView != null) {
                textView.setText(getContext().getString(n.expand));
            }
            TextView textView2 = this.K;
            if (textView2 != null) {
                textView2.setOnClickListener(new g(this));
                return;
            }
            return;
        }
        int i12 = this.I;
        if (num != null && num.intValue() == i12) {
            this.L = view;
        }
    }
}
