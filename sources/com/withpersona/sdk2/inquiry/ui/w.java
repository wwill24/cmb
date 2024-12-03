package com.withpersona.sdk2.inquiry.ui;

import android.view.View;
import android.widget.AdapterView;
import com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent;
import com.withpersona.sdk2.inquiry.ui.UiWorkflow;
import java.util.List;

public final /* synthetic */ class w implements AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ List f29536a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ View f29537b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ UiWorkflow.c.a f29538c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ UiComponent f29539d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ List f29540e;

    public /* synthetic */ w(List list, View view, UiWorkflow.c.a aVar, UiComponent uiComponent, List list2) {
        this.f29536a = list;
        this.f29537b = view;
        this.f29538c = aVar;
        this.f29539d = uiComponent;
        this.f29540e = list2;
    }

    public final void onItemClick(AdapterView adapterView, View view, int i10, long j10) {
        UiScreenRunner.L(this.f29536a, this.f29537b, this.f29538c, this.f29539d, this.f29540e, adapterView, view, i10, j10);
    }
}
