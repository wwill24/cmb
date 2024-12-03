package com.withpersona.sdk2.inquiry.ui;

import android.view.View;
import com.google.android.material.textfield.TextInputLayout;
import com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent;

public final /* synthetic */ class x implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UiScreenRunner f29541a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TextInputLayout f29542b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ UiComponent f29543c;

    public /* synthetic */ x(UiScreenRunner uiScreenRunner, TextInputLayout textInputLayout, UiComponent uiComponent) {
        this.f29541a = uiScreenRunner;
        this.f29542b = textInputLayout;
        this.f29543c = uiComponent;
    }

    public final void onClick(View view) {
        UiScreenRunner.M(this.f29541a, this.f29542b, this.f29543c, view);
    }
}
