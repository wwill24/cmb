package com.withpersona.sdk2.inquiry.ui;

import aj.m;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.checkbox.MaterialCheckBox;
import kotlin.jvm.internal.j;

public final class f extends RecyclerView.d0 {

    /* renamed from: u  reason: collision with root package name */
    private final TextView f29394u;

    /* renamed from: v  reason: collision with root package name */
    private final MaterialCheckBox f29395v;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public f(m mVar) {
        super(mVar.getRoot());
        j.g(mVar, "binding");
        TextView textView = mVar.f24873c;
        j.f(textView, "binding.textviewInputSelectListItemLabel");
        this.f29394u = textView;
        MaterialCheckBox materialCheckBox = mVar.f24872b;
        j.f(materialCheckBox, "binding.checkbox");
        this.f29395v = materialCheckBox;
    }

    public final MaterialCheckBox V() {
        return this.f29395v;
    }

    public final TextView W() {
        return this.f29394u;
    }
}
