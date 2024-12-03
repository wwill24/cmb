package com.withpersona.sdk2.inquiry.ui;

import android.view.View;
import com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent;
import com.withpersona.sdk2.inquiry.ui.UiWorkflow;
import java.util.Map;

public final /* synthetic */ class v implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UiWorkflow.c.a f29531a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UiScreenRunner f29532b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ View f29533c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Map f29534d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ UiComponent f29535e;

    public /* synthetic */ v(UiWorkflow.c.a aVar, UiScreenRunner uiScreenRunner, View view, Map map, UiComponent uiComponent) {
        this.f29531a = aVar;
        this.f29532b = uiScreenRunner;
        this.f29533c = view;
        this.f29534d = map;
        this.f29535e = uiComponent;
    }

    public final void onClick(View view) {
        UiScreenRunner.K(this.f29531a, this.f29532b, this.f29533c, this.f29534d, this.f29535e, view);
    }
}
