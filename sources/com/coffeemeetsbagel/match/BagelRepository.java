package com.coffeemeetsbagel.match;

import com.coffeemeetsbagel.match.models.ActionOnBagelNetworkRequest;
import com.coffeemeetsbagel.match.models.NewWoosShownBody;
import com.coffeemeetsbagel.models.Bagel;
import com.coffeemeetsbagel.models.constants.Extra;
import com.coffeemeetsbagel.models.responses.ResponseGeneric;
import dk.a;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import qj.b0;
import qj.w;

public final class BagelRepository {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final l f34485a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final u f34486b;

    public BagelRepository(l lVar, u uVar) {
        j.g(lVar, "localDb");
        j.g(uVar, "remote");
        this.f34485a = lVar;
        this.f34486b = uVar;
    }

    /* access modifiers changed from: private */
    public static final ActionOnBagelNetworkRequest j(Bagel bagel, BagelRepository bagelRepository) {
        boolean z10;
        j.g(bagel, "$bagel");
        j.g(bagelRepository, "this$0");
        ActionOnBagelNetworkRequest actionOnBagelNetworkRequest = new ActionOnBagelNetworkRequest(bagel.getAction(), bagel.getLikeComment(), (String) null, 4, (DefaultConstructorMarker) null);
        bagelRepository.f34485a.g(bagel.getId(), bagel.getAction());
        String likeComment = bagel.getLikeComment();
        if (likeComment == null || likeComment.length() == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            bagelRepository.f34485a.c(bagel.getId(), bagel.getLikeComment());
        }
        return actionOnBagelNetworkRequest;
    }

    /* access modifiers changed from: private */
    public static final b0 k(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (b0) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final Bagel m(BagelRepository bagelRepository) {
        j.g(bagelRepository, "this$0");
        return bagelRepository.f34485a.m();
    }

    /* access modifiers changed from: private */
    public static final List o(BagelRepository bagelRepository) {
        j.g(bagelRepository, "this$0");
        return bagelRepository.f34485a.f();
    }

    /* access modifiers changed from: private */
    public static final Boolean r(BagelRepository bagelRepository, Bagel bagel) {
        j.g(bagelRepository, "this$0");
        j.g(bagel, "$bagel");
        return Boolean.valueOf(bagelRepository.f34485a.n(bagel));
    }

    /* access modifiers changed from: private */
    public static final b0 s(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (b0) function1.invoke(obj);
    }

    public final w<Bagel> i(Bagel bagel) {
        j.g(bagel, Extra.BAGEL);
        w<Bagel> v10 = w.A(new n(bagel, this)).K(a.c()).v(new o(new BagelRepository$actionOnBagel$2(this, bagel)));
        j.f(v10, "fun actionOnBagel(bagel:…, it)\n            }\n    }");
        return v10;
    }

    public final w<Bagel> l() {
        w<Bagel> K = w.A(new r(this)).K(a.c());
        j.f(K, "fromCallable {\n         …scribeOn(Schedulers.io())");
        return K;
    }

    public final w<List<Bagel>> n() {
        w<List<Bagel>> K = w.A(new m(this)).K(a.c());
        j.f(K, "fromCallable {\n         …scribeOn(Schedulers.io())");
        return K;
    }

    public final w<ResponseGeneric> p(String str, int i10) {
        j.g(str, "bagelId");
        w<ResponseGeneric> K = this.f34486b.f(str, new NewWoosShownBody(i10)).K(a.c());
        j.f(K, "remote.onNewWoosShownAsy…scribeOn(Schedulers.io())");
        return K;
    }

    public final w<Bagel> q(Bagel bagel) {
        j.g(bagel, Extra.BAGEL);
        w<Bagel> K = w.A(new p(this, bagel)).v(new q(new BagelRepository$updateBagel$2(this, bagel))).K(a.c());
        j.f(K, "fun updateBagel(bagel: B…On(Schedulers.io())\n    }");
        return K;
    }
}
