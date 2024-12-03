package com.withpersona.sdk2.inquiry.steps.ui.styling;

import android.view.View;
import com.google.android.material.textfield.TextInputLayout;
import kotlin.jvm.internal.Ref$ObjectRef;

public final /* synthetic */ class j implements View.OnFocusChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TextInputLayout f29260a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Ref$ObjectRef f29261b;

    public /* synthetic */ j(TextInputLayout textInputLayout, Ref$ObjectRef ref$ObjectRef) {
        this.f29260a = textInputLayout;
        this.f29261b = ref$ObjectRef;
    }

    public final void onFocusChange(View view, boolean z10) {
        TextInputLayoutStylingKt.o(this.f29260a, this.f29261b, view, z10);
    }
}
