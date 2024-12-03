package com.coffeemeetsbagel.store.premium_upsell;

import android.view.View;
import b6.p;
import com.coffeemeetsbagel.R;
import kotlin.jvm.internal.j;
import ub.b;

public final class x extends p<View> {

    /* renamed from: e  reason: collision with root package name */
    private final b f36908e;

    /* renamed from: f  reason: collision with root package name */
    private final a f36909f;

    public interface a {
        void onCancel();

        void v0();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public x(b bVar, a aVar) {
        super(bVar.getRoot());
        j.g(bVar, "binding");
        j.g(aVar, "listener");
        this.f36908e = bVar;
        this.f36909f = aVar;
    }

    /* access modifiers changed from: private */
    public static final void l(x xVar, View view) {
        j.g(xVar, "this$0");
        xVar.f36909f.v0();
    }

    /* access modifiers changed from: private */
    public static final void o(x xVar, View view) {
        j.g(xVar, "this$0");
        xVar.f36909f.onCancel();
    }

    /* access modifiers changed from: protected */
    public void d() {
        super.d();
        this.f36908e.f41960c.setOnClickListener(new v(this));
    }

    public final void m() {
        this.f36908e.f41962e.setBackgroundColor(androidx.core.content.a.getColor(this.f7869c.getContext(), R.color.main_color));
        this.f36908e.f41960c.setImageResource(R.drawable.close_x);
        this.f36908e.f41960c.setColorFilter(-1);
        this.f36908e.f41959b.setVisibility(8);
        this.f36908e.f41962e.setVisibility(0);
    }

    public final void n() {
        this.f36908e.f41962e.setBackgroundColor(-1);
        this.f36908e.f41960c.setImageResource(R.drawable.ic_back);
        this.f36908e.f41960c.setColorFilter(androidx.core.content.a.getColor(this.f7869c.getContext(), R.color.main_color));
        this.f36908e.f41959b.setVisibility(0);
        this.f36908e.f41959b.setOnClickListener(new w(this));
        this.f36908e.f41962e.setVisibility(0);
    }
}
