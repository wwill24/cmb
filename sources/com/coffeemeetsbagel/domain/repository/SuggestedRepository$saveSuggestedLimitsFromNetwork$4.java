package com.coffeemeetsbagel.domain.repository;

import com.coffeemeetsbagel.models.entities.SuggestedLimitsEntity;
import com.coffeemeetsbagel.models.util.DateUtils;
import com.coffeemeetsbagel.suggested.models.SuggestedLimitsNetworkResponse;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import qj.a;
import qj.f;
import yb.d;

final class SuggestedRepository$saveSuggestedLimitsFromNetwork$4 extends Lambda implements Function1<Pair<? extends SuggestedLimitsNetworkResponse, ? extends Boolean>, f> {
    final /* synthetic */ long $previousDateInMillis;
    final /* synthetic */ SuggestedRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SuggestedRepository$saveSuggestedLimitsFromNetwork$4(long j10, SuggestedRepository suggestedRepository) {
        super(1);
        this.$previousDateInMillis = j10;
        this.this$0 = suggestedRepository;
    }

    /* access modifiers changed from: private */
    public static final void e(SuggestedRepository suggestedRepository, SuggestedLimitsEntity suggestedLimitsEntity) {
        j.g(suggestedRepository, "this$0");
        j.g(suggestedLimitsEntity, "$limitsDb");
        suggestedRepository.f12452b.c(suggestedLimitsEntity);
    }

    /* access modifiers changed from: private */
    public static final void f(SuggestedRepository suggestedRepository, SuggestedLimitsEntity suggestedLimitsEntity) {
        j.g(suggestedRepository, "this$0");
        j.g(suggestedLimitsEntity, "$limitsDb");
        suggestedRepository.f12452b.c(suggestedLimitsEntity);
    }

    /* renamed from: d */
    public final f invoke(Pair<SuggestedLimitsNetworkResponse, Boolean> pair) {
        j.g(pair, "<name for destructuring parameter 0>");
        SuggestedLimitsNetworkResponse a10 = pair.a();
        boolean booleanValue = pair.b().booleanValue();
        d dVar = d.f42163a;
        j.f(a10, "suggestedLimits");
        SuggestedLimitsEntity a11 = dVar.a(a10);
        boolean z10 = true;
        if (booleanValue) {
            if (a10.getRemainingLikes() == null || a10.getRemainingViews() == null || a10.getNumBagelsRequiredForUpsell() == null) {
                z10 = false;
            }
            if (z10) {
                return a.w(new r2(this.this$0, a11));
            }
            return a.m();
        }
        if (this.$previousDateInMillis >= DateUtils.getTimestampForLastNoon()) {
            z10 = false;
        }
        if (z10) {
            return a.w(new s2(this.this$0, a11));
        }
        return a.m();
    }
}
