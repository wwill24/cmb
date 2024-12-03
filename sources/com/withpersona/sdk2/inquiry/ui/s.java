package com.withpersona.sdk2.inquiry.ui;

import android.view.View;
import com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent;

public final /* synthetic */ class s implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UiComponent.ClickableStack f29525a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UiScreenRunner f29526b;

    public /* synthetic */ s(UiComponent.ClickableStack clickableStack, UiScreenRunner uiScreenRunner) {
        this.f29525a = clickableStack;
        this.f29526b = uiScreenRunner;
    }

    public final void onClick(View view) {
        UiScreenRunner.z(this.f29525a, this.f29526b, view);
    }
}
