package com.coffeemeetsbagel.profile;

import com.coffeemeetsbagel.models.entities.EthnicityType;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class ProfileMappersKt$toNetwork$3$1 extends Lambda implements Function1<EthnicityType, CharSequence> {

    /* renamed from: a  reason: collision with root package name */
    public static final ProfileMappersKt$toNetwork$3$1 f36025a = new ProfileMappersKt$toNetwork$3$1();

    ProfileMappersKt$toNetwork$3$1() {
        super(1);
    }

    /* renamed from: a */
    public final CharSequence invoke(EthnicityType ethnicityType) {
        j.g(ethnicityType, "it");
        return ethnicityType.getApiKey();
    }
}
