package com.coffeemeetsbagel.today_view.card.deactivated;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.cmb_views.CmbButton;
import com.coffeemeetsbagel.cmb_views.CmbTextView;
import com.mparticle.identity.IdentityHttpResponse;
import j5.x;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import lc.c;
import qj.q;
import r7.h;

public class DeactivatedComponentView extends ConstraintLayout {
    private ImageView F;
    private CmbTextView G;
    private CmbTextView H;
    private CmbButton I;
    private h J;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public DeactivatedComponentView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        j.g(context, IdentityHttpResponse.CONTEXT);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DeactivatedComponentView(Context context, AttributeSet attributeSet, int i10, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }

    public final void B() {
        h hVar = this.J;
        if (hVar != null && hVar != null) {
            hVar.hide();
        }
    }

    public q<x> C() {
        CmbButton cmbButton = this.I;
        if (cmbButton == null) {
            j.y("reactivateButton");
            cmbButton = null;
        }
        q<x> a10 = cmbButton.a();
        j.f(a10, "reactivateButton.clicks()");
        return a10;
    }

    public final void D() {
        c.i(this.J);
    }

    public final void E() {
        ImageView imageView = this.F;
        if (imageView == null) {
            j.y("deactivatedImage");
            imageView = null;
        }
        imageView.setImageResource(R.drawable.no_rising);
    }

    public final void F() {
        ImageView imageView = this.F;
        if (imageView == null) {
            j.y("deactivatedImage");
            imageView = null;
        }
        imageView.setImageResource(R.drawable.rising);
    }

    public final void G(String str, String str2) {
        j.g(str, "title");
        j.g(str2, "description");
        CmbTextView cmbTextView = this.G;
        CmbTextView cmbTextView2 = null;
        if (cmbTextView == null) {
            j.y("titleText");
            cmbTextView = null;
        }
        cmbTextView.setText(str);
        CmbTextView cmbTextView3 = this.H;
        if (cmbTextView3 == null) {
            j.y("descriptionText");
        } else {
            cmbTextView2 = cmbTextView3;
        }
        cmbTextView2.setText(str2);
    }

    public final void H() {
        h hVar = new h(getContext());
        this.J = hVar;
        hVar.show();
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        View findViewById = findViewById(R.id.button_bottom);
        j.f(findViewById, "findViewById(R.id.button_bottom)");
        this.I = (CmbButton) findViewById;
        View findViewById2 = findViewById(R.id.deactivated_image);
        j.f(findViewById2, "findViewById(R.id.deactivated_image)");
        this.F = (ImageView) findViewById2;
        View findViewById3 = findViewById(R.id.textView_explanation0);
        j.f(findViewById3, "findViewById(R.id.textView_explanation0)");
        this.G = (CmbTextView) findViewById3;
        View findViewById4 = findViewById(R.id.textView_explanation1);
        j.f(findViewById4, "findViewById(R.id.textView_explanation1)");
        this.H = (CmbTextView) findViewById4;
        View findViewById5 = findViewById(R.id.button_bottom);
        j.f(findViewById5, "findViewById(R.id.button_bottom)");
        this.I = (CmbButton) findViewById5;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeactivatedComponentView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        j.g(context, IdentityHttpResponse.CONTEXT);
    }
}
