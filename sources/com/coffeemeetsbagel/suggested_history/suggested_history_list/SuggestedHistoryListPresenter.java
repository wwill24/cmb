package com.coffeemeetsbagel.suggested_history.suggested_history_list;

import android.content.Context;
import android.view.View;
import b6.p;
import com.coffeemeetsbagel.models.Bagel;
import gk.f;
import java.util.List;
import kotlin.jvm.internal.j;
import lc.m;
import zb.a;

public final class SuggestedHistoryListPresenter extends p<View> {

    /* renamed from: e  reason: collision with root package name */
    private final a f37146e;

    /* renamed from: f  reason: collision with root package name */
    private final p f37147f;

    /* renamed from: g  reason: collision with root package name */
    private final f f37148g = b.b(new SuggestedHistoryListPresenter$adapter$2(this));

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SuggestedHistoryListPresenter(a aVar, p pVar) {
        super(aVar.getRoot());
        j.g(aVar, "binding");
        j.g(pVar, "listener");
        this.f37146e = aVar;
        this.f37147f = pVar;
    }

    private final e j() {
        return (e) this.f37148g.getValue();
    }

    /* access modifiers changed from: protected */
    public void d() {
        super.d();
        this.f37146e.f42224b.setAdapter(j());
        m mVar = m.f41114a;
        Context context = this.f7869c.getContext();
        j.f(context, "view.context");
        this.f37146e.f42224b.h(new u5.a(mVar.a(context, 16.0f)));
    }

    public final p k() {
        return this.f37147f;
    }

    public final void l() {
        this.f37146e.f42228f.setVisibility(8);
    }

    public final void m() {
        this.f37146e.f42228f.setVisibility(0);
    }

    public final void n(List<? extends Bagel> list) {
        j.g(list, "bagelsList");
        j().J(list);
    }
}
