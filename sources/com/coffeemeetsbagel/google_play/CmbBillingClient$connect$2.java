package com.coffeemeetsbagel.google_play;

import fa.a;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import qj.h;
import rn.a;

final class CmbBillingClient$connect$2 extends Lambda implements Function1<h<Throwable>, a<?>> {
    final /* synthetic */ CmbBillingClient this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CmbBillingClient$connect$2(CmbBillingClient cmbBillingClient) {
        super(1);
        this.this$0 = cmbBillingClient;
    }

    /* access modifiers changed from: private */
    public static final Integer e(Function2 function2, Object obj, Object obj2) {
        j.g(function2, "$tmp0");
        return (Integer) function2.invoke(obj, obj2);
    }

    /* access modifiers changed from: private */
    public static final a f(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (a) function1.invoke(obj);
    }

    /* renamed from: d */
    public final a<?> invoke(h<Throwable> hVar) {
        j.g(hVar, "throwableFlowable");
        h<R> z02 = hVar.z0(h.i0(1, this.this$0.f13907a), new s(AnonymousClass1.f13915a));
        final CmbBillingClient cmbBillingClient = this.this$0;
        return z02.M(new t(new Function1<Integer, a<? extends Long>>() {
            /* renamed from: a */
            public final a<? extends Long> invoke(Integer num) {
                j.g(num, "retryNumber");
                cmbBillingClient.f13908b.set(num.intValue());
                double pow = Math.pow(2.0d, (double) num.intValue());
                if (num.intValue() >= cmbBillingClient.f13907a) {
                    return h.H(new TimeoutException("Unable to start connection."));
                }
                a.C0491a aVar = fa.a.f40771d;
                String w10 = cmbBillingClient.f13909c;
                j.f(w10, "tag");
                aVar.a(w10, "Retry #" + num.intValue() + " will trigger in " + pow + " seconds.");
                return h.q0((long) pow, TimeUnit.SECONDS);
            }
        }));
    }
}
