package com.coffeemeetsbagel.domain.repository;

import com.coffeemeetsbagel.models.responses.BlockProfileResponse;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class ProfileRepository$blockProfile$1 extends Lambda implements Function1<BlockProfileResponse, String> {

    /* renamed from: a  reason: collision with root package name */
    public static final ProfileRepository$blockProfile$1 f12419a = new ProfileRepository$blockProfile$1();

    ProfileRepository$blockProfile$1() {
        super(1);
    }

    /* renamed from: a */
    public final String invoke(BlockProfileResponse blockProfileResponse) {
        j.g(blockProfileResponse, "response");
        return blockProfileResponse.getResult();
    }
}
