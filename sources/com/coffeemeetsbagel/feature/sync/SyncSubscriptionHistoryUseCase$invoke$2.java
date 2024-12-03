package com.coffeemeetsbagel.feature.sync;

import com.coffeemeetsbagel.domain.repository.UserRepository;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.j;
import qj.a;

/* synthetic */ class SyncSubscriptionHistoryUseCase$invoke$2 extends FunctionReferenceImpl implements Function1<String, a> {
    SyncSubscriptionHistoryUseCase$invoke$2(Object obj) {
        super(1, obj, UserRepository.class, "updatePurchasedSkus", "updatePurchasedSkus(Ljava/lang/String;)Lio/reactivex/Completable;", 0);
    }

    /* renamed from: c */
    public final a invoke(String str) {
        j.g(str, "p0");
        return ((UserRepository) this.receiver).B(str);
    }
}
