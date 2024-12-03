package com.withpersona.sdk2.inquiry.ui;

import android.view.View;
import com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent;
import com.withpersona.sdk2.inquiry.ui.UiWorkflow;

public final /* synthetic */ class a0 implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UiScreenRunner f29377a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UiComponent f29378b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ UiWorkflow.c.a f29379c;

    public /* synthetic */ a0(UiScreenRunner uiScreenRunner, UiComponent uiComponent, UiWorkflow.c.a aVar) {
        this.f29377a = uiScreenRunner;
        this.f29378b = uiComponent;
        this.f29379c = aVar;
    }

    public final void onClick(View view) {
        UiScreenRunner.P(this.f29377a, this.f29378b, this.f29379c, view);
    }
}
