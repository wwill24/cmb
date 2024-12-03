package com.coffeemeetsbagel.match_view;

import gk.h;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

final class MatchViewInteractor$trackView$1 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ MatchViewInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MatchViewInteractor$trackView$1(MatchViewInteractor matchViewInteractor) {
        super(1);
        this.this$0 = matchViewInteractor;
    }

    public final void a(String str) {
        String str2;
        Pair[] pairArr = new Pair[3];
        pairArr[0] = h.a("activity report rnding state", str);
        if (this.this$0.V) {
            str2 = "yes";
        } else {
            str2 = "no";
        }
        pairArr[1] = h.a("activity report seen", str2);
        pairArr[2] = h.a("source", this.this$0.f34629p);
        this.this$0.x2().trackEvent("Profile Viewed", h0.l(pairArr));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((String) obj);
        return Unit.f32013a;
    }
}
