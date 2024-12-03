package com.coffeemeetsbagel.match_view;

import com.coffeemeetsbagel.database.daos.h;
import com.coffeemeetsbagel.domain.repository.SubscriptionRepository;
import com.coffeemeetsbagel.models.ActivityReport;
import com.coffeemeetsbagel.utils.model.Optional;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.j;
import y6.a;

public final class GetActivityReportUseCase {

    /* renamed from: a  reason: collision with root package name */
    private final SubscriptionRepository f34597a;

    /* renamed from: b  reason: collision with root package name */
    private final h f34598b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final a f34599c;

    public GetActivityReportUseCase(SubscriptionRepository subscriptionRepository, h hVar, a aVar) {
        j.g(subscriptionRepository, "subscriptionRepository");
        j.g(hVar, "activityReportDatabase");
        j.g(aVar, "activityReportManager");
        this.f34597a = subscriptionRepository;
        this.f34598b = hVar;
        this.f34599c = aVar;
    }

    private final qj.h<Optional<ActivityReport>> f(String str) {
        qj.h<R> Y = this.f34598b.h(str).Y(new h(GetActivityReportUseCase$getActivityReportValue$1.f34600a));
        j.f(Y, "activityReportDatabase\n …          }\n            }");
        return Y;
    }

    /* access modifiers changed from: private */
    public static final Optional g(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (Optional) function1.invoke(obj);
    }

    private final qj.h<Boolean> h() {
        qj.h<R> Y = this.f34597a.T().Y(new g(GetActivityReportUseCase$getUnlockedValue$1.f34601a));
        j.f(Y, "subscriptionRepository\n … subscription.isPresent }");
        return Y;
    }

    /* access modifiers changed from: private */
    public static final Boolean i(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (Boolean) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final Pair k(Function2 function2, Object obj, Object obj2) {
        j.g(function2, "$tmp0");
        return (Pair) function2.invoke(obj, obj2);
    }

    /* access modifiers changed from: private */
    public static final void l(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    public final qj.h<Pair<Boolean, ActivityReport>> j(String str) {
        j.g(str, "profileId");
        qj.h<R> D = qj.h.n(h(), f(str), new e(GetActivityReportUseCase$invoke$1.f34602a)).v().D(new f(new GetActivityReportUseCase$invoke$2(this, str)));
        j.f(D, "operator fun invoke(prof…back)\n            }\n    }");
        return D;
    }
}
