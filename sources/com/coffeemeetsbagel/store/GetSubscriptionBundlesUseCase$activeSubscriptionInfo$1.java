package com.coffeemeetsbagel.store;

import com.coffeemeetsbagel.utils.model.Optional;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import qj.h;
import vb.a;
import vb.c;

final class GetSubscriptionBundlesUseCase$activeSubscriptionInfo$1 extends Lambda implements Function1<Optional<a>, rn.a<? extends Pair<? extends Optional<a>, ? extends Optional<c>>>> {
    final /* synthetic */ GetSubscriptionBundlesUseCase this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GetSubscriptionBundlesUseCase$activeSubscriptionInfo$1(GetSubscriptionBundlesUseCase getSubscriptionBundlesUseCase) {
        super(1);
        this.this$0 = getSubscriptionBundlesUseCase;
    }

    /* access modifiers changed from: private */
    public static final Pair d(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (Pair) function1.invoke(obj);
    }

    /* renamed from: c */
    public final rn.a<? extends Pair<Optional<a>, Optional<c>>> invoke(final Optional<a> optional) {
        j.g(optional, "optionalSubscription");
        if (optional.d()) {
            h<R> Y = this.this$0.f36700a.g0(optional.c().c()).Y(new a0(new Function1<Optional<c>, Pair<? extends Optional<a>, ? extends Optional<c>>>() {
                /* renamed from: a */
                public final Pair<Optional<a>, Optional<c>> invoke(Optional<c> optional) {
                    j.g(optional, "optionalBundle");
                    return new Pair<>(optional, optional);
                }
            }));
            j.f(Y, "optionalSubscription ->\n…ndle) }\n                }");
            return Y;
        }
        h X = h.X(new Pair(Optional.a(), Optional.a()));
        j.f(X, "{\n                    //…ent()))\n                }");
        return X;
    }
}
