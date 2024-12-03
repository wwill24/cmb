package com.withpersona.sdk2.inquiry.steps.ui.styling;

import android.content.res.ColorStateList;
import android.view.View;
import com.google.android.material.textfield.TextInputLayout;

public final /* synthetic */ class g implements View.OnLayoutChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TextInputLayout f29250a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f29251b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ColorStateList f29252c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f29253d;

    public /* synthetic */ g(TextInputLayout textInputLayout, int i10, ColorStateList colorStateList, int i11) {
        this.f29250a = textInputLayout;
        this.f29251b = i10;
        this.f29252c = colorStateList;
        this.f29253d = i11;
    }

    public final void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        TextInputLayoutStylingKt.k(this.f29250a, this.f29251b, this.f29252c, this.f29253d, view, i10, i11, i12, i13, i14, i15, i16, i17);
    }
}
