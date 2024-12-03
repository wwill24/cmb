package com.coffeemeetsbagel.store.premium_upsell;

import a7.a;
import android.annotation.SuppressLint;
import com.coffeemeetsbagel.domain.repository.SubscriptionRepository;
import com.coffeemeetsbagel.domain.repository.UserRepository;
import com.coffeemeetsbagel.store.PurchaseSource;
import com.jakewharton.rxrelay2.b;
import fa.a;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;
import org.jivesoftware.smack.sm.packet.StreamManagement;
import org.jivesoftware.smackx.mam.element.MamElements;

@SuppressLint({"CheckResult"})
public final class PremiumUpsellAnalytics {

    /* renamed from: a  reason: collision with root package name */
    private final a f36826a;

    /* renamed from: b  reason: collision with root package name */
    private final PurchaseSource f36827b;

    /* renamed from: c  reason: collision with root package name */
    private final b<DropOffPoint> f36828c;

    /* renamed from: d  reason: collision with root package name */
    private Boolean f36829d;

    /* renamed from: e  reason: collision with root package name */
    private Integer f36830e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public boolean f36831f;

    public enum DropOffPoint {
        f36833a("unknown", -1),
        SUBSCRIPTION_BENEFITS("benefits", 0),
        COMPARE_PLAN("compare_plan", 1),
        RECOMMENDED_PLAN("recommended_plan", 2),
        SUBSCRIPTION_VARIANTS("payment_plan_info", 2),
        PAYMENT_DIALOG("payment_confirmation", 3),
        PAYMENT_END("subscription_purchased", 4);
        
        private final String value;
        private final int weight;

        private DropOffPoint(String str, int i10) {
            this.value = str;
            this.weight = i10;
        }

        public final String b() {
            return this.value;
        }

        public final int c() {
            return this.weight;
        }
    }

    public enum Result {
        INCOMPLETE("incomplete"),
        SUCCESS("succeeded"),
        FAILURE(StreamManagement.Failed.ELEMENT),
        f36844d("unknown");
        
        private final String value;

        private Result(String str) {
            this.value = str;
        }

        public final String b() {
            return this.value;
        }
    }

    public PremiumUpsellAnalytics(a aVar, PurchaseSource purchaseSource, UserRepository userRepository, SubscriptionRepository subscriptionRepository) {
        j.g(aVar, "analytics");
        j.g(purchaseSource, "source");
        j.g(userRepository, "userRepository");
        j.g(subscriptionRepository, "subscriptionRepository");
        this.f36826a = aVar;
        this.f36827b = purchaseSource;
        b<DropOffPoint> D0 = b.D0(DropOffPoint.f36833a);
        j.f(D0, "createDefault(DropOffPoint.UNKNOWN)");
        this.f36828c = D0;
        userRepository.o().K(dk.a.c()).c(new h(new Function1<ja.b, Unit>(this) {
            final /* synthetic */ PremiumUpsellAnalytics this$0;

            {
                this.this$0 = r1;
            }

            public final void a(ja.b bVar) {
                this.this$0.f36831f = bVar.A();
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((ja.b) obj);
                return Unit.f32013a;
            }
        }));
        subscriptionRepository.T().L().D(new i(AnonymousClass2.f36832a)).K(dk.a.c()).c(new j(new Function1<Integer, Unit>(this) {
            final /* synthetic */ PremiumUpsellAnalytics this$0;

            {
                this.this$0 = r1;
            }

            public final void a(Integer num) {
                j.f(num, "tier");
                if (num.intValue() >= 0) {
                    this.this$0.j(true, num);
                } else {
                    PremiumUpsellAnalytics.k(this.this$0, false, (Integer) null, 2, (Object) null);
                }
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((Integer) obj);
                return Unit.f32013a;
            }
        }));
    }

    /* access modifiers changed from: private */
    public static final void d(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final Integer e(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (Integer) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void f(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    private final Map<String, String> h(String str, String str2, int i10, int i11, Result result) {
        boolean z10;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(MamElements.MamResultExtension.ELEMENT, result.b());
        DropOffPoint E0 = this.f36828c.E0();
        j.d(E0);
        linkedHashMap.put("exit_screen", E0.b());
        linkedHashMap.put("is_free_trial", String.valueOf(this.f36831f));
        String c10 = this.f36827b.c();
        if (c10 != null) {
            String str3 = (String) linkedHashMap.put("source", c10);
        }
        String a10 = this.f36827b.a();
        if (a10 != null) {
            String str4 = (String) linkedHashMap.put("feature source", a10);
        }
        Integer num = this.f36830e;
        if (num != null) {
            String str5 = (String) linkedHashMap.put("current_tier", String.valueOf(num.intValue()));
        }
        Boolean bool = this.f36829d;
        if (bool != null) {
            String str6 = (String) linkedHashMap.put("current_subscriber", String.valueOf(bool.booleanValue()));
        }
        boolean z11 = true;
        if (str2.length() > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            linkedHashMap.put("exit_bundle_name", str2);
        }
        if (str.length() <= 0) {
            z11 = false;
        }
        if (z11) {
            linkedHashMap.put("exit_bundle_id", str);
        }
        if (result == Result.SUCCESS) {
            if (i10 >= 0) {
                linkedHashMap.put("purchased_tier", String.valueOf(i10));
            }
            if (i11 > 0) {
                linkedHashMap.put("purchased_tier_duration", String.valueOf(i11));
            }
        }
        fa.a.f40771d.a("PremiumUpsellAnalytics", "bundleValues: values= " + linkedHashMap);
        return linkedHashMap;
    }

    public static /* synthetic */ void k(PremiumUpsellAnalytics premiumUpsellAnalytics, boolean z10, Integer num, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            num = null;
        }
        premiumUpsellAnalytics.j(z10, num);
    }

    private final void n(String str, String str2, int i10, int i11, Result result) {
        a.C0491a aVar = fa.a.f40771d;
        aVar.a("PremiumUpsellAnalytics", "trackMpuEnd: result= " + result);
        this.f36826a.trackEvent("Modular Subscription Prompt Viewed", h(str, str2, i10, i11, result));
    }

    static /* synthetic */ void o(PremiumUpsellAnalytics premiumUpsellAnalytics, String str, String str2, int i10, int i11, Result result, int i12, Object obj) {
        premiumUpsellAnalytics.n((i12 & 1) != 0 ? "" : str, (i12 & 2) != 0 ? "" : str2, (i12 & 4) != 0 ? -1 : i10, (i12 & 8) != 0 ? -1 : i11, result);
    }

    public final void i(String str, String str2) {
        j.g(str, "bundledId");
        j.g(str2, "bundleName");
        o(this, str, str2, 0, 0, Result.INCOMPLETE, 12, (Object) null);
    }

    public final void j(boolean z10, Integer num) {
        this.f36829d = Boolean.valueOf(z10);
        if (z10) {
            this.f36830e = num;
        } else {
            this.f36830e = null;
        }
    }

    public final void l(String str, String str2, DropOffPoint dropOffPoint) {
        j.g(str, "bundledId");
        j.g(str2, "bundleName");
        j.g(dropOffPoint, "dropOffPoint");
        m(dropOffPoint);
        o(this, str, str2, 0, 0, Result.FAILURE, 12, (Object) null);
    }

    public final void m(DropOffPoint dropOffPoint) {
        j.g(dropOffPoint, "dropOffPoint");
        int c10 = dropOffPoint.c();
        DropOffPoint E0 = this.f36828c.E0();
        j.d(E0);
        if (c10 >= E0.c()) {
            a.C0491a aVar = fa.a.f40771d;
            aVar.a("PremiumUpsellAnalytics", "trackFunnelStep: " + dropOffPoint);
            this.f36828c.accept(dropOffPoint);
        }
    }

    public final void p(String str, String str2, int i10, int i11) {
        j.g(str, "bundleId");
        j.g(str2, "bundleName");
        m(DropOffPoint.PAYMENT_END);
        n(str, str2, i10, i11, Result.SUCCESS);
    }
}
