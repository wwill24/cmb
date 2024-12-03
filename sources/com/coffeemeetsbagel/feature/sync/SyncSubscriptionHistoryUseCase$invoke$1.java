package com.coffeemeetsbagel.feature.sync;

import com.android.billingclient.api.PurchaseHistoryRecord;
import com.mparticle.kits.AppsFlyerKit;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class SyncSubscriptionHistoryUseCase$invoke$1 extends Lambda implements Function1<List<? extends PurchaseHistoryRecord>, String> {

    /* renamed from: a  reason: collision with root package name */
    public static final SyncSubscriptionHistoryUseCase$invoke$1 f13418a = new SyncSubscriptionHistoryUseCase$invoke$1();

    SyncSubscriptionHistoryUseCase$invoke$1() {
        super(1);
    }

    /* renamed from: a */
    public final String invoke(List<? extends PurchaseHistoryRecord> list) {
        j.g(list, "list");
        ArrayList arrayList = new ArrayList(r.t(list, 10));
        for (PurchaseHistoryRecord d10 : list) {
            arrayList.add(d10.d());
        }
        return CollectionsKt___CollectionsKt.W(arrayList, AppsFlyerKit.COMMA, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, AnonymousClass2.f13419a, 30, (Object) null);
    }
}
