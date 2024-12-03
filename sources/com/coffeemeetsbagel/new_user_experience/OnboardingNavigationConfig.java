package com.coffeemeetsbagel.new_user_experience;

import android.annotation.SuppressLint;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.j;
import t9.a;

public final class OnboardingNavigationConfig {

    /* renamed from: a  reason: collision with root package name */
    private final List<Pages> f34778a;

    /* renamed from: b  reason: collision with root package name */
    private Pages f34779b;

    public enum Pages {
        CAROUSEL(""),
        INTRODUCTIONS("Name"),
        EMAIL("Email"),
        GENDER("Onboarding - Gender"),
        GENDER_INFERENCE("Onboarding - Gender Inferred"),
        GENDER_PREFENCE("Onboarding - Preferences - Gender"),
        BIRTHDAY("Age"),
        LOCATION("Location"),
        LOCATION_INPUT("Location Manual Entry"),
        NOTIFICATION_JUSTIFICATION("Push Notifications"),
        BIOGRAPHY(""),
        RELATIONSHIP_GOALS(""),
        NEW_TO_ONLINE_DATING("New To Online Dating"),
        PROFILE_REVIEW("Profile Review"),
        SHOW_PROFILE("Profile Review Profile"),
        MATCH_PREFS(""),
        PHOTO_MANAGER("Photo Manager"),
        PHOTO_INTRODUCTION("Photo Introduction"),
        LIGHT_MATCHES("First Bagel Screen"),
        ACTIVITY_MAIN("");
        
        private final String trackingName;

        private Pages(String str) {
            this.trackingName = str;
        }

        public final String b() {
            return this.trackingName;
        }
    }

    public OnboardingNavigationConfig(List<? extends Pages> list) {
        j.g(list, "pagesToShow");
        this.f34778a = list.isEmpty() ? d() : list;
    }

    @SuppressLint({"UseSparseArrays"})
    private final List<Pages> d() {
        HashMap hashMap = new HashMap(20);
        int i10 = a.onboardingCarouselOrder;
        if (i10 >= 0) {
            hashMap.put(Integer.valueOf(i10), Pages.CAROUSEL);
        }
        int i11 = a.onboardingEmailOrder;
        if (i11 >= 0) {
            hashMap.put(Integer.valueOf(i11), Pages.EMAIL);
        }
        int i12 = a.onboardingIntroductionsOrder;
        if (i12 >= 0) {
            hashMap.put(Integer.valueOf(i12), Pages.INTRODUCTIONS);
        }
        int i13 = a.onboardingGenderOrder;
        if (i13 >= 0) {
            hashMap.put(Integer.valueOf(i13), Pages.GENDER);
        }
        int i14 = a.onboardingGenderInferredOrder;
        if (i14 >= 0) {
            hashMap.put(Integer.valueOf(i14), Pages.GENDER_INFERENCE);
        }
        int i15 = a.onboardingGenderPreferredOrder;
        if (i15 >= 0) {
            hashMap.put(Integer.valueOf(i15), Pages.GENDER_PREFENCE);
        }
        int i16 = a.onboardingBirthdayOrder;
        if (i16 >= 0) {
            hashMap.put(Integer.valueOf(i16), Pages.BIRTHDAY);
        }
        int i17 = a.onboardingLocationOrder;
        if (i17 >= 0) {
            hashMap.put(Integer.valueOf(i17), Pages.LOCATION);
        }
        int i18 = a.onboardingLocationInputOrder;
        if (i18 >= 0) {
            hashMap.put(Integer.valueOf(i18), Pages.LOCATION_INPUT);
        }
        int i19 = a.onboardingNotificationOrder;
        if (i19 >= 0) {
            hashMap.put(Integer.valueOf(i19), Pages.NOTIFICATION_JUSTIFICATION);
        }
        int i20 = a.onboardingNewToOnlineDatingOrder;
        if (i20 >= 0) {
            hashMap.put(Integer.valueOf(i20), Pages.NEW_TO_ONLINE_DATING);
        }
        int i21 = a.onboardingBiographyOrder;
        if (i21 >= 0) {
            hashMap.put(Integer.valueOf(i21), Pages.BIOGRAPHY);
        }
        int i22 = a.onboardingGoalsOrder;
        if (i22 >= 0) {
            hashMap.put(Integer.valueOf(i22), Pages.RELATIONSHIP_GOALS);
        }
        int i23 = a.onboardingProfileReviewOrder;
        if (i23 >= 0) {
            hashMap.put(Integer.valueOf(i23), Pages.PROFILE_REVIEW);
        }
        int i24 = a.onboardingShowProfileOrder;
        if (i24 >= 0) {
            hashMap.put(Integer.valueOf(i24), Pages.SHOW_PROFILE);
        }
        int i25 = a.onboardingMatchPreferencesOrder;
        if (i25 >= 0) {
            hashMap.put(Integer.valueOf(i25), Pages.MATCH_PREFS);
        }
        int i26 = a.onboardingPhotoIntroductionOrder;
        if (i26 >= 0) {
            hashMap.put(Integer.valueOf(i26), Pages.PHOTO_INTRODUCTION);
        }
        int i27 = a.onboardingPhotoManagerOrder;
        if (i27 >= 0) {
            hashMap.put(Integer.valueOf(i27), Pages.PHOTO_MANAGER);
        }
        int i28 = a.onboardingLightMatchesOrder;
        if (i28 >= 0) {
            hashMap.put(Integer.valueOf(i28), Pages.LIGHT_MATCHES);
        }
        int i29 = a.onboardingActivitymainOrder;
        if (i29 >= 0) {
            hashMap.put(Integer.valueOf(i29), Pages.ACTIVITY_MAIN);
        }
        Collection values = g0.h(hashMap).values();
        j.f(values, "map.toSortedMap().values");
        return CollectionsKt___CollectionsKt.x0(values);
    }

    public final Pages a() {
        return this.f34779b;
    }

    public final Pages b() {
        Pages pages;
        int S = CollectionsKt___CollectionsKt.S(this.f34778a, this.f34779b) - 1;
        if (S >= 0) {
            pages = this.f34778a.get(S);
        } else {
            pages = null;
        }
        this.f34779b = pages;
        return pages;
    }

    public final Pages c() {
        Pages pages;
        int S = CollectionsKt___CollectionsKt.S(this.f34778a, this.f34779b) + 1;
        if (S < this.f34778a.size()) {
            pages = this.f34778a.get(S);
        } else {
            pages = null;
        }
        this.f34779b = pages;
        return pages;
    }
}
