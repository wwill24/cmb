package com.coffeemeetsbagel.new_user_experience.match_prefs.answerable_question;

import ja.b;
import kotlin.Pair;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class PremiumPreferenceInteractor$didBecomeActive$1 extends Lambda implements Function2<b, Boolean, Pair<? extends b, ? extends Boolean>> {

    /* renamed from: a  reason: collision with root package name */
    public static final PremiumPreferenceInteractor$didBecomeActive$1 f35236a = new PremiumPreferenceInteractor$didBecomeActive$1();

    PremiumPreferenceInteractor$didBecomeActive$1() {
        super(2);
    }

    /* renamed from: a */
    public final Pair<b, Boolean> invoke(b bVar, Boolean bool) {
        j.g(bVar, "user");
        j.g(bool, "capabilities");
        return new Pair<>(bVar, bool);
    }
}
