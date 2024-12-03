package com.coffeemeetsbagel.feature.sync;

import com.coffeemeetsbagel.domain.repository.UserRepository;
import com.coffeemeetsbagel.google_play.CmbBillingClient;
import dk.a;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;
import qj.f;

public final class SyncSubscriptionHistoryUseCase {

    /* renamed from: a  reason: collision with root package name */
    private final CmbBillingClient f13415a;

    /* renamed from: b  reason: collision with root package name */
    private final UserRepository f13416b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final String f13417c;

    public SyncSubscriptionHistoryUseCase(CmbBillingClient cmbBillingClient, UserRepository userRepository) {
        j.g(cmbBillingClient, "billingClient");
        j.g(userRepository, "userRepository");
        this.f13415a = cmbBillingClient;
        this.f13416b = userRepository;
        String simpleName = SyncSubscriptionHistoryUseCase.class.getSimpleName();
        j.f(simpleName, "SyncSubscriptionHistoryU…se::class.java.simpleName");
        this.f13417c = simpleName;
    }

    /* access modifiers changed from: private */
    public static final String f(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (String) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final f g(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (f) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void h(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    public final void e() {
        this.f13415a.U().D(new s(SyncSubscriptionHistoryUseCase$invoke$1.f13418a)).w(new t(new SyncSubscriptionHistoryUseCase$invoke$2(this.f13416b))).r(new u(new SyncSubscriptionHistoryUseCase$invoke$3(this))).F(a.c()).d();
    }
}
