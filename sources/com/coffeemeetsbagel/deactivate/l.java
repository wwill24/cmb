package com.coffeemeetsbagel.deactivate;

import a7.a;
import com.coffeemeetsbagel.experiment.FeatureFlagRepository;
import com.coffeemeetsbagel.feature.profile.ProfileManager;
import com.coffeemeetsbagel.profile.GetMyOwnProfileLocalUseCase;
import d7.g;
import wb.c;

public final class l {
    public static void a(DeactivateCompInteractor deactivateCompInteractor, a aVar) {
        deactivateCompInteractor.f11985h = aVar;
    }

    public static void b(DeactivateCompInteractor deactivateCompInteractor, g gVar) {
        deactivateCompInteractor.f11986j = gVar;
    }

    public static void c(DeactivateCompInteractor deactivateCompInteractor, FeatureFlagRepository featureFlagRepository) {
        deactivateCompInteractor.f11988l = featureFlagRepository;
    }

    public static void d(DeactivateCompInteractor deactivateCompInteractor, c cVar) {
        deactivateCompInteractor.f11990n = cVar;
    }

    public static void e(DeactivateCompInteractor deactivateCompInteractor, GetMyOwnProfileLocalUseCase getMyOwnProfileLocalUseCase) {
        deactivateCompInteractor.f11989m = getMyOwnProfileLocalUseCase;
    }

    public static void f(DeactivateCompInteractor deactivateCompInteractor, ProfileManager profileManager) {
        deactivateCompInteractor.f11984g = profileManager;
    }

    public static void g(DeactivateCompInteractor deactivateCompInteractor, bb.a aVar) {
        deactivateCompInteractor.f11987k = aVar;
    }
}
