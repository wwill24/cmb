package com.coffeemeetsbagel.shop.wallet;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b6.d;
import b6.p;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import k9.c;

public final class j extends p<RecyclerView> {

    /* renamed from: e  reason: collision with root package name */
    private final k f36654e;

    /* renamed from: f  reason: collision with root package name */
    private final d<?, ?> f36655f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public j(RecyclerView recyclerView, k kVar, d<?, ?> dVar) {
        super(recyclerView);
        kotlin.jvm.internal.j.g(recyclerView, "view");
        kotlin.jvm.internal.j.g(kVar, "adapter");
        kotlin.jvm.internal.j.g(dVar, "componentActivity");
        this.f36654e = kVar;
        this.f36655f = dVar;
    }

    /* access modifiers changed from: protected */
    public void d() {
        super.d();
        ((RecyclerView) g()).setLayoutManager(new LinearLayoutManager(this.f36655f));
        ((RecyclerView) g()).setAdapter(this.f36654e);
    }

    public final String j(int i10) {
        String string = this.f36655f.getString(i10);
        kotlin.jvm.internal.j.f(string, "componentActivity.getString(stringResId)");
        return string;
    }

    public final void k(List<? extends c> list) {
        kotlin.jvm.internal.j.g(list, FirebaseAnalytics.Param.ITEMS);
        this.f36654e.G(list);
    }
}
