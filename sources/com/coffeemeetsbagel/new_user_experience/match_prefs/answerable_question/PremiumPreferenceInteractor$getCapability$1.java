package com.coffeemeetsbagel.new_user_experience.match_prefs.answerable_question;

import com.coffeemeetsbagel.models.NetworkProfile;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class PremiumPreferenceInteractor$getCapability$1 extends Lambda implements Function1<NetworkProfile, Boolean> {

    /* renamed from: a  reason: collision with root package name */
    public static final PremiumPreferenceInteractor$getCapability$1 f35237a = new PremiumPreferenceInteractor$getCapability$1();

    PremiumPreferenceInteractor$getCapability$1() {
        super(1);
    }

    /* renamed from: a */
    public final Boolean invoke(NetworkProfile networkProfile) {
        j.g(networkProfile, "it");
        return Boolean.valueOf(networkProfile.hasPremiumPreferences());
    }
}
