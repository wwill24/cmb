package com.coffeemeetsbagel.new_user_experience.match_prefs.religion;

import com.coffeemeetsbagel.models.Resource;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class ReligionMatchPreferenceInteractor$updateOnServer$1 extends Lambda implements Function1<Resource, CharSequence> {

    /* renamed from: a  reason: collision with root package name */
    public static final ReligionMatchPreferenceInteractor$updateOnServer$1 f35465a = new ReligionMatchPreferenceInteractor$updateOnServer$1();

    ReligionMatchPreferenceInteractor$updateOnServer$1() {
        super(1);
    }

    /* renamed from: a */
    public final CharSequence invoke(Resource resource) {
        j.g(resource, "it");
        return resource.getValue();
    }
}
