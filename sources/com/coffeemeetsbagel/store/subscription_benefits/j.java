package com.coffeemeetsbagel.store.subscription_benefits;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.Window;
import androidx.core.content.a;
import androidx.recyclerview.widget.RecyclerView;
import b6.p;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.image_loader.ImageLoaderContract;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import ub.d;
import vb.b;

public final class j extends p<View> {

    /* renamed from: e  reason: collision with root package name */
    private final d f36953e;

    /* renamed from: f  reason: collision with root package name */
    private final Window f36954f;

    /* renamed from: g  reason: collision with root package name */
    private final k f36955g;

    /* renamed from: h  reason: collision with root package name */
    private final int f36956h;

    /* renamed from: j  reason: collision with root package name */
    private final d f36957j = new d();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public j(d dVar, Window window, k kVar) {
        super(dVar.getRoot());
        kotlin.jvm.internal.j.g(dVar, "binding");
        kotlin.jvm.internal.j.g(window, "window");
        kotlin.jvm.internal.j.g(kVar, "userInteractionListener");
        this.f36953e = dVar;
        this.f36954f = window;
        this.f36955g = kVar;
        this.f36956h = window.getStatusBarColor();
    }

    /* access modifiers changed from: private */
    public static final void k(j jVar, View view) {
        kotlin.jvm.internal.j.g(jVar, "this$0");
        jVar.f36955g.j0();
    }

    /* access modifiers changed from: protected */
    public void d() {
        super.d();
        this.f36954f.setStatusBarColor(a.getColor(this.f7869c.getContext(), R.color.main_color));
        RecyclerView recyclerView = this.f36953e.f41968b;
        kotlin.jvm.internal.j.f(recyclerView, "binding.benefitList");
        m6.a.a(recyclerView, 1.0f, R.color.divider_color);
        this.f36953e.f41969c.setOnClickListener(new i(this));
    }

    /* access modifiers changed from: protected */
    public void i() {
        super.i();
        this.f36954f.setStatusBarColor(this.f36956h);
    }

    public final void l(b bVar, List<b> list) {
        boolean z10;
        List<b> list2 = list;
        kotlin.jvm.internal.j.g(bVar, "highlightedBenefit");
        kotlin.jvm.internal.j.g(list2, "benefits");
        this.f36953e.f41976k.f41966d.setText(bVar.f());
        this.f36953e.f41976k.f41964b.setText(bVar.b());
        if (bVar.d().length() > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            com.coffeemeetsbagel.image_loader.b bVar2 = com.coffeemeetsbagel.image_loader.b.f13967a;
            Context context = this.f7869c.getContext();
            kotlin.jvm.internal.j.f(context, "view.context");
            ImageLoaderContract.a.a(bVar2, context, bVar.d(), this.f36953e.f41976k.f41965c, (Integer) null, (Integer) null, (ImageLoaderContract.b) null, (List) null, (Map) null, (Function0) null, (Function1) null, (Bitmap.Config) null, (ImageLoaderContract.ImageBucketSize) null, new ImageLoaderContract.MemoryConfig[0], 4088, (Object) null);
        } else {
            this.f36953e.f41976k.f41965c.setImageResource(R.drawable.ic_2x);
        }
        this.f36953e.f41968b.setAdapter(this.f36957j);
        this.f36957j.J(list2);
    }
}
