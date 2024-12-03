package com.coffeemeetsbagel.domain.repository;

import com.coffeemeetsbagel.models.entities.EthnicityType;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class ProfileRepository$saveEthnicities$1 extends Lambda implements Function1<EthnicityType, CharSequence> {

    /* renamed from: a  reason: collision with root package name */
    public static final ProfileRepository$saveEthnicities$1 f12421a = new ProfileRepository$saveEthnicities$1();

    ProfileRepository$saveEthnicities$1() {
        super(1);
    }

    /* renamed from: a */
    public final CharSequence invoke(EthnicityType ethnicityType) {
        j.g(ethnicityType, "it");
        return ethnicityType.getApiKey();
    }
}
