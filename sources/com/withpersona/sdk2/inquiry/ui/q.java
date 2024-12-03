package com.withpersona.sdk2.inquiry.ui;

import android.view.View;
import com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent;
import com.withpersona.sdk2.inquiry.ui.UiWorkflow;
import java.util.Map;

public final /* synthetic */ class q implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UiScreenRunner f29518a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ View f29519b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Map f29520c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ UiComponent f29521d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ UiWorkflow.c.a f29522e;

    public /* synthetic */ q(UiScreenRunner uiScreenRunner, View view, Map map, UiComponent uiComponent, UiWorkflow.c.a aVar) {
        this.f29518a = uiScreenRunner;
        this.f29519b = view;
        this.f29520c = map;
        this.f29521d = uiComponent;
        this.f29522e = aVar;
    }

    public final void onClick(View view) {
        UiScreenRunner.Q(this.f29518a, this.f29519b, this.f29520c, this.f29521d, this.f29522e, view);
    }
}
