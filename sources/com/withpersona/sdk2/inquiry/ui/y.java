package com.withpersona.sdk2.inquiry.ui;

import android.view.View;
import com.google.android.material.textfield.TextInputLayout;
import com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent;

public final /* synthetic */ class y implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UiScreenRunner f29544a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TextInputLayout f29545b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ UiComponent f29546c;

    public /* synthetic */ y(UiScreenRunner uiScreenRunner, TextInputLayout textInputLayout, UiComponent uiComponent) {
        this.f29544a = uiScreenRunner;
        this.f29545b = textInputLayout;
        this.f29546c = uiComponent;
    }

    public final void onClick(View view) {
        UiScreenRunner.N(this.f29544a, this.f29545b, this.f29546c, view);
    }
}
