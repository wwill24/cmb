package com.coffeemeetsbagel.new_user_experience.match_prefs.answerable_question;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class PremiumPreferenceInteractor$renderOptionsAndAnswers$lockedStateSingle$1 extends Lambda implements Function1<Boolean, Boolean> {

    /* renamed from: a  reason: collision with root package name */
    public static final PremiumPreferenceInteractor$renderOptionsAndAnswers$lockedStateSingle$1 f35238a = new PremiumPreferenceInteractor$renderOptionsAndAnswers$lockedStateSingle$1();

    PremiumPreferenceInteractor$renderOptionsAndAnswers$lockedStateSingle$1() {
        super(1);
    }

    /* renamed from: a */
    public final Boolean invoke(Boolean bool) {
        j.g(bool, "hasPremPrefCapability");
        return Boolean.valueOf(!bool.booleanValue());
    }
}
