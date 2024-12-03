package com.coffeemeetsbagel.suggested_history;

import android.view.View;
import android.widget.FrameLayout;
import b6.d;
import b6.u;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.chat.details.ChatActivity;
import com.coffeemeetsbagel.models.Bagel;
import com.coffeemeetsbagel.models.constants.Extra;
import com.coffeemeetsbagel.suggested_history.k;
import com.coffeemeetsbagel.suggested_history.suggested_history_list.SuggestedHistoryListRouter;
import com.coffeemeetsbagel.suggested_history.suggested_history_list.f;
import com.coffeemeetsbagel.suggested_history.suggested_history_match_container.e;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.j;

public final class o extends u<View, k.b, m> {

    /* renamed from: f  reason: collision with root package name */
    private final d<?, ?> f37132f;

    /* renamed from: g  reason: collision with root package name */
    private u<?, ?, ?> f37133g;

    /* renamed from: h  reason: collision with root package name */
    private final FrameLayout f37134h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public o(zb.d dVar, k.b bVar, m mVar) {
        super(dVar.getRoot(), bVar, mVar);
        j.g(dVar, "view");
        j.g(bVar, "component");
        j.g(mVar, "interactor");
        d<?, ?> a10 = bVar.a();
        this.f37132f = a10;
        View findViewById = a10.findViewById(R.id.main_content);
        j.f(findViewById, "activity.findViewById(R.id.main_content)");
        this.f37134h = (FrameLayout) findViewById;
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [b6.u<?, ?, ?>, b6.u, b6.q] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void q(b6.u<?, ?, ?> r2) {
        /*
            r1 = this;
            b6.u<?, ?, ?> r0 = r1.f37133g
            if (r0 == 0) goto L_0x000c
            r1.b(r0)
            android.widget.FrameLayout r0 = r1.f37134h
            r0.removeAllViews()
        L_0x000c:
            r1.f37133g = r2
            r1.a(r2)
            android.widget.FrameLayout r0 = r1.f37134h
            android.view.View r2 = r2.l()
            r0.addView(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coffeemeetsbagel.suggested_history.o.q(b6.u):void");
    }

    /* access modifiers changed from: protected */
    public boolean h() {
        if (this.f37133g instanceof SuggestedHistoryListRouter) {
            return super.h();
        }
        ((m) f()).L1();
        return true;
    }

    public final void m(j jVar) {
        j.g(jVar, "listener");
        b6.j e10 = e();
        j.f(e10, "component");
        q(new f((f.a) e10).b(this.f37134h, jVar));
    }

    public final void n(Bagel bagel, com.coffeemeetsbagel.suggested_history.suggested_history_match_container.d dVar) {
        j.g(bagel, Extra.BAGEL);
        j.g(dVar, "matchInteractionListener");
        b6.j e10 = e();
        j.f(e10, "component");
        q(new e((e.a) e10).b(this.f37134h, bagel, dVar));
    }

    public final void o(Bagel bagel) {
        j.g(bagel, Extra.BAGEL);
        ChatActivity.P1(((k.b) e()).n(), bagel);
    }

    public final void p() {
        throw new NotImplementedError("An operation is not implemented: " + "Not yet implemented");
    }
}
