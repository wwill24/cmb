package com.coffeemeetsbagel.store;

import com.coffeemeetsbagel.domain.repository.SubscriptionRepository;
import com.coffeemeetsbagel.utils.model.Optional;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import fa.a;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.j;
import qj.h;
import vb.c;

public final class GetSubscriptionBundlesUseCase {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final SubscriptionRepository f36700a;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final Optional<vb.a> f36701a;

        /* renamed from: b  reason: collision with root package name */
        private final Optional<c> f36702b;

        /* renamed from: c  reason: collision with root package name */
        private final List<c> f36703c;

        public a(Optional<vb.a> optional, Optional<c> optional2, List<c> list) {
            j.g(optional, "activeSubscription");
            j.g(optional2, "activeBundle");
            j.g(list, "subscriptionBundles");
            this.f36701a = optional;
            this.f36702b = optional2;
            this.f36703c = list;
        }

        public final Optional<c> a() {
            return this.f36702b;
        }

        public final Optional<vb.a> b() {
            return this.f36701a;
        }

        public final List<c> c() {
            return this.f36703c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return j.b(this.f36701a, aVar.f36701a) && j.b(this.f36702b, aVar.f36702b) && j.b(this.f36703c, aVar.f36703c);
        }

        public int hashCode() {
            return (((this.f36701a.hashCode() * 31) + this.f36702b.hashCode()) * 31) + this.f36703c.hashCode();
        }

        public String toString() {
            Optional<vb.a> optional = this.f36701a;
            Optional<c> optional2 = this.f36702b;
            List<c> list = this.f36703c;
            return "SubscriptionInfo(activeSubscription=" + optional + ", activeBundle=" + optional2 + ", subscriptionBundles=" + list + ")";
        }
    }

    public GetSubscriptionBundlesUseCase(SubscriptionRepository subscriptionRepository) {
        j.g(subscriptionRepository, "subscriptionRepository");
        this.f36700a = subscriptionRepository;
    }

    private final h<Pair<Optional<vb.a>, Optional<c>>> h() {
        h<R> M = this.f36700a.T().v().M(new z(new GetSubscriptionBundlesUseCase$activeSubscriptionInfo$1(this)));
        j.f(M, "private fun activeSubscr…    }\n            }\n    }");
        return M;
    }

    /* access modifiers changed from: private */
    public static final rn.a i(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (rn.a) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public final h<Pair<Pair<Optional<vb.a>, Optional<c>>, List<c>>> j(Pair<? extends Pair<? extends Optional<vb.a>, ? extends Optional<c>>, ? extends List<c>> pair) {
        if (((List) pair.d()).isEmpty()) {
            h<Pair<Pair<Optional<vb.a>, Optional<c>>, List<c>>> Y = SubscriptionRepository.l0(this.f36700a, "", 0, 2, (Object) null).Y(new y(new GetSubscriptionBundlesUseCase$fallbackBundles$1(pair)));
            j.f(Y, "pair: Pair<Pair<Optional…rst, bundles) }\n        }");
            return Y;
        }
        h<Pair<Pair<Optional<vb.a>, Optional<c>>, List<c>>> X = h.X(pair);
        j.f(X, "{\n            Flowable.just(pair)\n        }");
        return X;
    }

    /* access modifiers changed from: private */
    public static final Pair k(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (Pair) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final Pair m(Function2 function2, Object obj, Object obj2) {
        j.g(function2, "$tmp0");
        return (Pair) function2.invoke(obj, obj2);
    }

    /* access modifiers changed from: private */
    public static final rn.a n(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (rn.a) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final a o(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (a) function1.invoke(obj);
    }

    public final h<a> l(String str) {
        j.g(str, SDKConstants.PARAM_INTENT);
        a.C0491a aVar = fa.a.f40771d;
        aVar.a("GetSubscriptionBundlesUseCase", "invoke(" + str + ")");
        h<R> Y = h.n(h().v(), SubscriptionRepository.l0(this.f36700a, str, 0, 2, (Object) null).v(), new v(GetSubscriptionBundlesUseCase$invoke$1.f36704a)).M(new w(new GetSubscriptionBundlesUseCase$invoke$2(this))).Y(new x(GetSubscriptionBundlesUseCase$invoke$3.f36705a));
        j.f(Y, "operator fun invoke(inte…    )\n            }\n    }");
        return Y;
    }
}
