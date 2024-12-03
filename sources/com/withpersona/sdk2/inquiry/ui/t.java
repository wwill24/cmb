package com.withpersona.sdk2.inquiry.ui;

import android.view.View;
import com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent;

public final /* synthetic */ class t implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UiScreenRunner f29527a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UiComponent f29528b;

    public /* synthetic */ t(UiScreenRunner uiScreenRunner, UiComponent uiComponent) {
        this.f29527a = uiScreenRunner;
        this.f29528b = uiComponent;
    }

    public final void onClick(View view) {
        UiScreenRunner.I(this.f29527a, this.f29528b, view);
    }
}
