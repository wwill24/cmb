package com.coffeemeetsbagel.fragments;

import c9.a;
import com.coffeemeetsbagel.experiment.r;
import com.coffeemeetsbagel.profile.SaveMyProfileLocalUseCase;
import com.coffeemeetsbagel.profile.SaveProfilesLocalUseCase;
import com.coffeemeetsbagel.qna.GetUserMCQUseCase;
import com.coffeemeetsbagel.qna.SaveAnswerUseCase;
import com.coffeemeetsbagel.qna.e;
import com.coffeemeetsbagel.qna.j;
import com.coffeemeetsbagel.school.domain.GetSingleSchoolsUseCase;

public final class k4 {
    public static void a(FragmentMyProfileDetails fragmentMyProfileDetails, r rVar) {
        fragmentMyProfileDetails.f13518d = rVar;
    }

    public static void b(FragmentMyProfileDetails fragmentMyProfileDetails, e eVar) {
        fragmentMyProfileDetails.f13522f = eVar;
    }

    public static void c(FragmentMyProfileDetails fragmentMyProfileDetails, j jVar) {
        fragmentMyProfileDetails.f13524g = jVar;
    }

    public static void d(FragmentMyProfileDetails fragmentMyProfileDetails, a aVar) {
        fragmentMyProfileDetails.f13529j = aVar;
    }

    public static void e(FragmentMyProfileDetails fragmentMyProfileDetails, GetSingleSchoolsUseCase getSingleSchoolsUseCase) {
        fragmentMyProfileDetails.f13531k = getSingleSchoolsUseCase;
    }

    public static void f(FragmentMyProfileDetails fragmentMyProfileDetails, GetUserMCQUseCase getUserMCQUseCase) {
        fragmentMyProfileDetails.f13520e = getUserMCQUseCase;
    }

    public static void g(FragmentMyProfileDetails fragmentMyProfileDetails, SaveAnswerUseCase saveAnswerUseCase) {
        fragmentMyProfileDetails.f13526h = saveAnswerUseCase;
    }

    public static void h(FragmentMyProfileDetails fragmentMyProfileDetails, SaveMyProfileLocalUseCase saveMyProfileLocalUseCase) {
        fragmentMyProfileDetails.f13535m = saveMyProfileLocalUseCase;
    }

    public static void i(FragmentMyProfileDetails fragmentMyProfileDetails, SaveProfilesLocalUseCase saveProfilesLocalUseCase) {
        fragmentMyProfileDetails.f13533l = saveProfilesLocalUseCase;
    }
}
