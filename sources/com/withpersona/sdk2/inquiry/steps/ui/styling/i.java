package com.withpersona.sdk2.inquiry.steps.ui.styling;

import android.content.res.ColorStateList;
import android.view.View;
import com.google.android.material.textfield.TextInputLayout;

public final /* synthetic */ class i implements View.OnLayoutChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TextInputLayout f29257a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ColorStateList f29258b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ColorStateList f29259c;

    public /* synthetic */ i(TextInputLayout textInputLayout, ColorStateList colorStateList, ColorStateList colorStateList2) {
        this.f29257a = textInputLayout;
        this.f29258b = colorStateList;
        this.f29259c = colorStateList2;
    }

    public final void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        TextInputLayoutStylingKt.n(this.f29257a, this.f29258b, this.f29259c, view, i10, i11, i12, i13, i14, i15, i16, i17);
    }
}
