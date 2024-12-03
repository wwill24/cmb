package com.withpersona.sdk2.inquiry.steps.ui.styling;

import android.content.res.ColorStateList;
import android.view.View;
import com.google.android.material.textfield.TextInputLayout;

public final /* synthetic */ class h implements View.OnLayoutChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TextInputLayout f29254a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ColorStateList f29255b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ColorStateList f29256c;

    public /* synthetic */ h(TextInputLayout textInputLayout, ColorStateList colorStateList, ColorStateList colorStateList2) {
        this.f29254a = textInputLayout;
        this.f29255b = colorStateList;
        this.f29256c = colorStateList2;
    }

    public final void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        TextInputLayoutStylingKt.l(this.f29254a, this.f29255b, this.f29256c, view, i10, i11, i12, i13, i14, i15, i16, i17);
    }
}
