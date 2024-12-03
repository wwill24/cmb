package com.coffeemeetsbagel.preferences;

import b6.i;
import com.uber.autodispose.p;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;
import qj.q;
import sj.a;
import tj.b;

public final class MatchPrefsContainerInteractor extends i<MatchPrefsContainerRouter> {

    /* renamed from: e  reason: collision with root package name */
    public g f35787e;

    private final <T> b I1(q<T> qVar, Function1<? super T, Unit> function1) {
        b c10 = ((p) qVar.a0(a.a()).g(com.uber.autodispose.a.a(this))).c(new q(new MatchPrefsContainerInteractor$observeAutoDispose$1(function1)));
        j.f(c10, "consumer: (T) -> Unit): …> consumer.invoke(data) }");
        return c10;
    }

    /* access modifiers changed from: private */
    public static final void J1(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    public final g H1() {
        g gVar = this.f35787e;
        if (gVar != null) {
            return gVar;
        }
        j.y("dataStream");
        return null;
    }

    /* access modifiers changed from: protected */
    public void y1() {
        super.y1();
        ((MatchPrefsContainerRouter) B1()).n();
        I1(H1().b(), new MatchPrefsContainerInteractor$didBecomeActive$1(this));
        I1(H1().a(), new MatchPrefsContainerInteractor$didBecomeActive$2(this));
        I1(H1().j(), new MatchPrefsContainerInteractor$didBecomeActive$3(this));
    }
}
