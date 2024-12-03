package com.coffeemeetsbagel.instant_like;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import b6.j;
import com.coffeemeetsbagel.feature.bagel.UpdateBagelLocalUseCase;
import com.coffeemeetsbagel.feature.firebase.FirebaseContract;
import com.coffeemeetsbagel.feature.profile.ProfileContract$Manager;
import com.coffeemeetsbagel.instant_like.InstantLikeBottomSheetPresenter;
import com.coffeemeetsbagel.store.k0;

public final class f extends b6.c<InstantLikeBottomSheetRouter, c> {

    public interface a extends j<InstantLikeBottomSheetInteractor> {
        androidx.appcompat.app.c O0();
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final y9.a f14027a;

        /* renamed from: b  reason: collision with root package name */
        private final InstantLikeBottomSheetPresenter.c f14028b;

        public b(y9.a aVar, InstantLikeBottomSheetPresenter.c cVar) {
            kotlin.jvm.internal.j.g(aVar, "binding");
            kotlin.jvm.internal.j.g(cVar, "listenter");
            this.f14027a = aVar;
            this.f14028b = cVar;
        }

        public final InstantLikeBottomSheetPresenter a() {
            return new InstantLikeBottomSheetPresenter(this.f14027a, this.f14028b);
        }

        public final com.coffeemeetsbagel.store.alc.a b(a7.a aVar, FirebaseContract.Analytics analytics) {
            kotlin.jvm.internal.j.g(aVar, "analytics");
            kotlin.jvm.internal.j.g(analytics, "firebase");
            return new com.coffeemeetsbagel.store.alc.a(aVar, analytics);
        }
    }

    public interface c {
        UpdateBagelLocalUseCase M();

        androidx.appcompat.app.c O0();

        d T();

        FirebaseContract.Analytics a0();

        a7.a c();

        ProfileContract$Manager d();

        k0 j();

        com.coffeemeetsbagel.match.j l();

        com.coffeemeetsbagel.store.alc.b l0();

        c6.b m0();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public f(c cVar) {
        super(cVar);
        kotlin.jvm.internal.j.g(cVar, "dependency");
    }

    public final InstantLikeBottomSheetRouter b(ViewGroup viewGroup, y yVar, String str, boolean z10) {
        kotlin.jvm.internal.j.g(viewGroup, "parentViewGroup");
        kotlin.jvm.internal.j.g(yVar, "listener");
        kotlin.jvm.internal.j.g(str, "matchId");
        InstantLikeBottomSheetInteractor instantLikeBottomSheetInteractor = new InstantLikeBottomSheetInteractor(yVar, str, z10);
        y9.a c10 = y9.a.c(LayoutInflater.from(((c) a()).O0()), viewGroup, false);
        kotlin.jvm.internal.j.f(c10, "inflate(inflater, parentViewGroup, false)");
        a a10 = b.a().b(new b(c10, instantLikeBottomSheetInteractor)).c((c) a()).a();
        kotlin.jvm.internal.j.f(a10, "component");
        return new InstantLikeBottomSheetRouter(c10, a10, instantLikeBottomSheetInteractor);
    }
}
