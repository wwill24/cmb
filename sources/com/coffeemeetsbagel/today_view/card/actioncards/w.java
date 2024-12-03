package com.coffeemeetsbagel.today_view.card.actioncards;

import a7.a;
import b7.c;
import c6.b;
import com.coffeemeetsbagel.domain.repository.ActionCardRepository;
import com.coffeemeetsbagel.feature.profile.ProfileContract$Manager;
import com.coffeemeetsbagel.match.j;
import com.coffeemeetsbagel.profile.SaveProfilesLocalUseCase;
import com.coffeemeetsbagel.store.k0;
import com.coffeemeetsbagel.today_view.main.e;
import kotlin.Unit;
import qj.h;

public final class w {
    public static void a(ActionCardInteractor actionCardInteractor, ActionCardRepository actionCardRepository) {
        actionCardInteractor.f37232j = actionCardRepository;
    }

    public static void b(ActionCardInteractor actionCardInteractor, b bVar) {
        actionCardInteractor.D = bVar;
    }

    public static void c(ActionCardInteractor actionCardInteractor, a aVar) {
        actionCardInteractor.f37233k = aVar;
    }

    public static void d(ActionCardInteractor actionCardInteractor, c cVar) {
        actionCardInteractor.f37237p = cVar;
    }

    public static void e(ActionCardInteractor actionCardInteractor, j jVar) {
        actionCardInteractor.f37240w = jVar;
    }

    public static void f(ActionCardInteractor actionCardInteractor, t7.a aVar) {
        actionCardInteractor.f37241x = aVar;
    }

    public static void g(ActionCardInteractor actionCardInteractor, s9.a aVar) {
        actionCardInteractor.F = aVar;
    }

    public static void h(ActionCardInteractor actionCardInteractor, GetFirstEligibleActionCardUseCase getFirstEligibleActionCardUseCase) {
        actionCardInteractor.f37242y = getFirstEligibleActionCardUseCase;
    }

    public static void i(ActionCardInteractor actionCardInteractor, h<Unit> hVar) {
        actionCardInteractor.f37238q = hVar;
    }

    public static void j(ActionCardInteractor actionCardInteractor, ProfileContract$Manager profileContract$Manager) {
        actionCardInteractor.f37236n = profileContract$Manager;
    }

    public static void k(ActionCardInteractor actionCardInteractor, k0 k0Var) {
        actionCardInteractor.f37235m = k0Var;
    }

    public static void l(ActionCardInteractor actionCardInteractor, SaveProfilesLocalUseCase saveProfilesLocalUseCase) {
        actionCardInteractor.E = saveProfilesLocalUseCase;
    }

    public static void m(ActionCardInteractor actionCardInteractor, cb.a aVar) {
        actionCardInteractor.C = aVar;
    }

    public static void n(ActionCardInteractor actionCardInteractor, hb.c cVar) {
        actionCardInteractor.f37234l = cVar;
    }

    public static void o(ActionCardInteractor actionCardInteractor, bb.a aVar) {
        actionCardInteractor.B = aVar;
    }

    public static void p(ActionCardInteractor actionCardInteractor, e.a aVar) {
        actionCardInteractor.f37239t = aVar;
    }

    public static void q(ActionCardInteractor actionCardInteractor, a aVar) {
        actionCardInteractor.f37243z = aVar;
    }
}
