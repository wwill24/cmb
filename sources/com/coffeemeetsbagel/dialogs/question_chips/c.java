package com.coffeemeetsbagel.dialogs.question_chips;

import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.coffeemeetsbagel.cmb_views.ExpandingView;
import com.google.android.material.chip.ChipGroup;
import k6.f;
import kotlin.jvm.internal.j;

public final class c extends RecyclerView.d0 {

    /* renamed from: u  reason: collision with root package name */
    private final TextView f12145u;

    /* renamed from: v  reason: collision with root package name */
    private final ChipGroup f12146v;

    /* renamed from: w  reason: collision with root package name */
    private final ExpandingView f12147w;

    /* renamed from: x  reason: collision with root package name */
    private final TextView f12148x;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(f fVar) {
        super(fVar.getRoot());
        j.g(fVar, "view");
        TextView textView = fVar.f15740d;
        j.f(textView, "view.title");
        this.f12145u = textView;
        ChipGroup chipGroup = fVar.f15738b;
        j.f(chipGroup, "view.chipGroup");
        this.f12146v = chipGroup;
        ExpandingView b10 = fVar.getRoot();
        j.f(b10, "view.root");
        this.f12147w = b10;
        TextView textView2 = fVar.f15739c;
        j.f(textView2, "view.hideExpandButton");
        this.f12148x = textView2;
    }

    public final ChipGroup V() {
        return this.f12146v;
    }

    public final TextView W() {
        return this.f12148x;
    }

    public final ExpandingView X() {
        return this.f12147w;
    }

    public final TextView Y() {
        return this.f12145u;
    }
}
