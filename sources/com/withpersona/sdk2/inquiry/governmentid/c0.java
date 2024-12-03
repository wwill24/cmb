package com.withpersona.sdk2.inquiry.governmentid;

import android.content.Context;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.j;
import ti.n;

public final class c0 extends RecyclerView.d0 {

    /* renamed from: u  reason: collision with root package name */
    private final View f25747u;

    /* renamed from: v  reason: collision with root package name */
    private final ImageView f25748v;

    /* renamed from: w  reason: collision with root package name */
    private final TextView f25749w;

    /* renamed from: x  reason: collision with root package name */
    private final ImageView f25750x;

    /* renamed from: y  reason: collision with root package name */
    private final ConstraintLayout f25751y;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c0(View view) {
        super(view);
        int i10;
        j.g(view, "view");
        this.f25747u = view;
        View findViewById = view.findViewById(l0.imageview_governmentid_listicon);
        j.f(findViewById, "view.findViewById(R.id.i…ew_governmentid_listicon)");
        ImageView imageView = (ImageView) findViewById;
        this.f25748v = imageView;
        View findViewById2 = view.findViewById(l0.textview_governmentid_listlabel);
        j.f(findViewById2, "view.findViewById(R.id.t…w_governmentid_listlabel)");
        this.f25749w = (TextView) findViewById2;
        View findViewById3 = view.findViewById(l0.imageview_countryselect_listrightarrow);
        j.f(findViewById3, "view.findViewById(R.id.i…tryselect_listrightarrow)");
        this.f25750x = (ImageView) findViewById3;
        View findViewById4 = view.findViewById(l0.root_layout);
        j.f(findViewById4, "view.findViewById(R.id.root_layout)");
        this.f25751y = (ConstraintLayout) findViewById4;
        Context context = view.getContext();
        j.f(context, "view.context");
        if (n.b(context, h0.personaGovIdSelectHideIcon, (TypedValue) null, false, 6, (Object) null)) {
            i10 = 8;
        } else {
            i10 = 0;
        }
        imageView.setVisibility(i10);
    }

    public final ImageView V() {
        return this.f25750x;
    }

    public final ImageView W() {
        return this.f25748v;
    }

    public final TextView X() {
        return this.f25749w;
    }

    public final ConstraintLayout Y() {
        return this.f25751y;
    }

    public final View Z() {
        return this.f25747u;
    }
}
