package com.coffeemeetsbagel.bagel_profile.main;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.cmb_views.CmbTextView;
import com.coffeemeetsbagel.like_pass.view.CustomFabLikeButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.mparticle.identity.IdentityHttpResponse;
import io.reactivex.subjects.PublishSubject;
import j5.x;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import lc.n;
import qj.q;

public class GenericMatchContainerView extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private final PublishSubject<x> f11031a;

    /* renamed from: b  reason: collision with root package name */
    private FloatingActionButton f11032b;

    /* renamed from: c  reason: collision with root package name */
    private CustomFabLikeButton f11033c;

    /* renamed from: d  reason: collision with root package name */
    private CustomFabLikeButton f11034d;

    /* renamed from: e  reason: collision with root package name */
    private CustomFabLikeButton f11035e;

    /* renamed from: f  reason: collision with root package name */
    private CmbTextView f11036f;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public GenericMatchContainerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        j.g(context, IdentityHttpResponse.CONTEXT);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GenericMatchContainerView(Context context, AttributeSet attributeSet, int i10, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }

    /* access modifiers changed from: private */
    public static final void e(GenericMatchContainerView genericMatchContainerView, View view) {
        j.g(genericMatchContainerView, "this$0");
        genericMatchContainerView.f11031a.d(x.a());
    }

    public q<x> b() {
        q<x> P = this.f11031a.P();
        j.f(P, "editButtonClicked.hide()");
        return P;
    }

    public q<x> c() {
        CustomFabLikeButton customFabLikeButton = this.f11034d;
        if (customFabLikeButton == null) {
            j.y("flowerButton");
            customFabLikeButton = null;
        }
        q<x> g10 = customFabLikeButton.g();
        j.f(g10, "flowerButton.clicks()");
        return g10;
    }

    public final void d() {
        CustomFabLikeButton customFabLikeButton = this.f11034d;
        CmbTextView cmbTextView = null;
        if (customFabLikeButton == null) {
            j.y("flowerButton");
            customFabLikeButton = null;
        }
        customFabLikeButton.setVisibility(0);
        CustomFabLikeButton customFabLikeButton2 = this.f11035e;
        if (customFabLikeButton2 == null) {
            j.y("sendFlowerButton");
            customFabLikeButton2 = null;
        }
        customFabLikeButton2.setVisibility(8);
        CmbTextView cmbTextView2 = this.f11036f;
        if (cmbTextView2 == null) {
            j.y("priceText");
        } else {
            cmbTextView = cmbTextView2;
        }
        cmbTextView.setVisibility(8);
    }

    public q<x> f() {
        CustomFabLikeButton customFabLikeButton = this.f11035e;
        if (customFabLikeButton == null) {
            j.y("sendFlowerButton");
            customFabLikeButton = null;
        }
        q<x> g10 = customFabLikeButton.g();
        j.f(g10, "sendFlowerButton.clicks()");
        return g10;
    }

    @SuppressLint({"RestrictedApi"})
    public void g() {
        FloatingActionButton floatingActionButton = this.f11032b;
        if (floatingActionButton == null) {
            j.y("editButton");
            floatingActionButton = null;
        }
        floatingActionButton.setVisibility(0);
    }

    public final void h(boolean z10) {
        CustomFabLikeButton customFabLikeButton = this.f11034d;
        CustomFabLikeButton customFabLikeButton2 = null;
        if (customFabLikeButton == null) {
            j.y("flowerButton");
            customFabLikeButton = null;
        }
        customFabLikeButton.setVisibility(0);
        CustomFabLikeButton customFabLikeButton3 = this.f11033c;
        if (customFabLikeButton3 == null) {
            j.y("takeButton");
            customFabLikeButton3 = null;
        }
        customFabLikeButton3.setVisibility(8);
        CustomFabLikeButton customFabLikeButton4 = this.f11034d;
        if (customFabLikeButton4 == null) {
            j.y("flowerButton");
            customFabLikeButton4 = null;
        }
        customFabLikeButton4.setClickable(true);
        if (z10) {
            CustomFabLikeButton customFabLikeButton5 = this.f11034d;
            if (customFabLikeButton5 == null) {
                j.y("flowerButton");
            } else {
                customFabLikeButton2 = customFabLikeButton5;
            }
            customFabLikeButton2.setImageResource(R.drawable.like);
            return;
        }
        CustomFabLikeButton customFabLikeButton6 = this.f11034d;
        if (customFabLikeButton6 == null) {
            j.y("flowerButton");
        } else {
            customFabLikeButton2 = customFabLikeButton6;
        }
        customFabLikeButton2.setImageResource(R.drawable.flower);
    }

    public final void i(CharSequence charSequence) {
        j.g(charSequence, "priceString");
        CustomFabLikeButton customFabLikeButton = this.f11034d;
        CustomFabLikeButton customFabLikeButton2 = null;
        if (customFabLikeButton == null) {
            j.y("flowerButton");
            customFabLikeButton = null;
        }
        customFabLikeButton.setVisibility(8);
        CustomFabLikeButton customFabLikeButton3 = this.f11035e;
        if (customFabLikeButton3 == null) {
            j.y("sendFlowerButton");
            customFabLikeButton3 = null;
        }
        customFabLikeButton3.setVisibility(0);
        CmbTextView cmbTextView = this.f11036f;
        if (cmbTextView == null) {
            j.y("priceText");
            cmbTextView = null;
        }
        cmbTextView.setVisibility(0);
        CmbTextView cmbTextView2 = this.f11036f;
        if (cmbTextView2 == null) {
            j.y("priceText");
            cmbTextView2 = null;
        }
        cmbTextView2.setText(charSequence);
        CustomFabLikeButton customFabLikeButton4 = this.f11035e;
        if (customFabLikeButton4 == null) {
            j.y("sendFlowerButton");
        } else {
            customFabLikeButton2 = customFabLikeButton4;
        }
        customFabLikeButton2.setClickable(true);
    }

    @SuppressLint({"RestrictedApi"})
    public void j(boolean z10, boolean z11) {
        CustomFabLikeButton customFabLikeButton = this.f11034d;
        CustomFabLikeButton customFabLikeButton2 = null;
        if (customFabLikeButton == null) {
            j.y("flowerButton");
            customFabLikeButton = null;
        }
        customFabLikeButton.setVisibility(8);
        CustomFabLikeButton customFabLikeButton3 = this.f11033c;
        if (customFabLikeButton3 == null) {
            j.y("takeButton");
            customFabLikeButton3 = null;
        }
        customFabLikeButton3.setVisibility(0);
        CustomFabLikeButton customFabLikeButton4 = this.f11033c;
        if (customFabLikeButton4 == null) {
            j.y("takeButton");
            customFabLikeButton4 = null;
        }
        customFabLikeButton4.setClickable(true);
        if (!z10) {
            return;
        }
        if (z11) {
            CustomFabLikeButton customFabLikeButton5 = this.f11033c;
            if (customFabLikeButton5 == null) {
                j.y("takeButton");
            } else {
                customFabLikeButton2 = customFabLikeButton5;
            }
            customFabLikeButton2.setImageResource(R.drawable.like);
            return;
        }
        CustomFabLikeButton customFabLikeButton6 = this.f11033c;
        if (customFabLikeButton6 == null) {
            j.y("takeButton");
        } else {
            customFabLikeButton2 = customFabLikeButton6;
        }
        customFabLikeButton2.setImageResource(R.drawable.comment_overall);
    }

    public q<x> k() {
        CustomFabLikeButton customFabLikeButton = this.f11033c;
        if (customFabLikeButton == null) {
            j.y("takeButton");
            customFabLikeButton = null;
        }
        q<x> g10 = customFabLikeButton.g();
        j.f(g10, "takeButton.clicks()");
        return g10;
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        View findViewById = findViewById(R.id.edit_profile_button);
        j.f(findViewById, "findViewById(R.id.edit_profile_button)");
        this.f11032b = (FloatingActionButton) findViewById;
        View findViewById2 = findViewById(R.id.like_button);
        j.f(findViewById2, "findViewById(R.id.like_button)");
        this.f11033c = (CustomFabLikeButton) findViewById2;
        View findViewById3 = findViewById(R.id.flower_button);
        j.f(findViewById3, "findViewById(R.id.flower_button)");
        this.f11034d = (CustomFabLikeButton) findViewById3;
        View findViewById4 = findViewById(R.id.send_flower_button);
        j.f(findViewById4, "findViewById(R.id.send_flower_button)");
        this.f11035e = (CustomFabLikeButton) findViewById4;
        View findViewById5 = findViewById(R.id.price_text);
        j.f(findViewById5, "findViewById(R.id.price_text)");
        this.f11036f = (CmbTextView) findViewById5;
        FloatingActionButton floatingActionButton = this.f11032b;
        FloatingActionButton floatingActionButton2 = null;
        if (floatingActionButton == null) {
            j.y("editButton");
            floatingActionButton = null;
        }
        Drawable drawable = floatingActionButton.getDrawable();
        if (drawable != null) {
            n.a(getContext(), drawable, R.color.main_color);
        }
        FloatingActionButton floatingActionButton3 = this.f11032b;
        if (floatingActionButton3 == null) {
            j.y("editButton");
        } else {
            floatingActionButton2 = floatingActionButton3;
        }
        floatingActionButton2.setOnClickListener(new j(this));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GenericMatchContainerView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        j.g(context, IdentityHttpResponse.CONTEXT);
        PublishSubject<x> C0 = PublishSubject.C0();
        j.f(C0, "create<Irrelevant>()");
        this.f11031a = C0;
    }
}
