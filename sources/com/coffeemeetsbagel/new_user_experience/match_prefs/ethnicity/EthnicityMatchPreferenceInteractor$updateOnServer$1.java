package com.coffeemeetsbagel.new_user_experience.match_prefs.ethnicity;

import com.coffeemeetsbagel.models.Resource;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class EthnicityMatchPreferenceInteractor$updateOnServer$1 extends Lambda implements Function1<Resource, CharSequence> {

    /* renamed from: a  reason: collision with root package name */
    public static final EthnicityMatchPreferenceInteractor$updateOnServer$1 f35338a = new EthnicityMatchPreferenceInteractor$updateOnServer$1();

    EthnicityMatchPreferenceInteractor$updateOnServer$1() {
        super(1);
    }

    /* renamed from: a */
    public final CharSequence invoke(Resource resource) {
        j.g(resource, "it");
        return resource.getValue();
    }
}
