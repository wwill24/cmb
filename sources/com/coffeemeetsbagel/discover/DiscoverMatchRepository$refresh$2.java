package com.coffeemeetsbagel.discover;

import com.coffeemeetsbagel.models.GiveTake;
import com.coffeemeetsbagel.models.NetworkProfile;
import com.coffeemeetsbagel.models.RisingGiveTake;
import com.coffeemeetsbagel.models.responses.ResponseGiveTakes;
import com.coffeemeetsbagel.models.responses.ResponseRisingGiveTakes;
import java.util.ArrayList;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import qj.b0;
import qj.w;

final class DiscoverMatchRepository$refresh$2 extends Lambda implements Function1<Pair<? extends ResponseGiveTakes, ? extends ResponseRisingGiveTakes>, b0<? extends List<? extends NetworkProfile>>> {
    final /* synthetic */ DiscoverMatchRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DiscoverMatchRepository$refresh$2(DiscoverMatchRepository discoverMatchRepository) {
        super(1);
        this.this$0 = discoverMatchRepository;
    }

    /* access modifiers changed from: private */
    public static final List d(DiscoverMatchRepository discoverMatchRepository, ResponseGiveTakes responseGiveTakes, ResponseRisingGiveTakes responseRisingGiveTakes) {
        j.g(discoverMatchRepository, "this$0");
        discoverMatchRepository.g(responseGiveTakes.getResults());
        discoverMatchRepository.h(responseRisingGiveTakes.getResults());
        List<GiveTake> results = responseGiveTakes.getResults();
        j.f(results, "giveTakes.results");
        ArrayList arrayList = new ArrayList();
        for (GiveTake profile : results) {
            NetworkProfile profile2 = profile.getProfile();
            if (profile2 != null) {
                arrayList.add(profile2);
            }
        }
        List<RisingGiveTake> results2 = responseRisingGiveTakes.getResults();
        j.f(results2, "risingGiveTakes.results");
        ArrayList arrayList2 = new ArrayList();
        for (RisingGiveTake profile3 : results2) {
            NetworkProfile profile4 = profile3.getProfile();
            if (profile4 != null) {
                arrayList2.add(profile4);
            }
        }
        return CollectionsKt___CollectionsKt.h0(arrayList, arrayList2);
    }

    /* renamed from: c */
    public final b0<? extends List<NetworkProfile>> invoke(Pair<? extends ResponseGiveTakes, ? extends ResponseRisingGiveTakes> pair) {
        j.g(pair, "pair");
        return w.A(new c(this.this$0, (ResponseGiveTakes) pair.c(), (ResponseRisingGiveTakes) pair.d()));
    }
}
