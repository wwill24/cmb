package com.withpersona.sdk2.inquiry.ui;

import android.view.View;
import com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent;

public final /* synthetic */ class u implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UiScreenRunner f29529a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UiComponent f29530b;

    public /* synthetic */ u(UiScreenRunner uiScreenRunner, UiComponent uiComponent) {
        this.f29529a = uiScreenRunner;
        this.f29530b = uiComponent;
    }

    public final void onClick(View view) {
        UiScreenRunner.J(this.f29529a, this.f29530b, view);
    }
}
