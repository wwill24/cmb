package com.coffeemeetsbagel.domain.repository;

import com.coffeemeetsbagel.models.dto.ProfileDataContract;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import x6.d;

final class ProfileRepository$getProfile$2 extends Lambda implements Function1<d<List<? extends ProfileDataContract>>, d<ProfileDataContract>> {

    /* renamed from: a  reason: collision with root package name */
    public static final ProfileRepository$getProfile$2 f12420a = new ProfileRepository$getProfile$2();

    ProfileRepository$getProfile$2() {
        super(1);
    }

    /* renamed from: a */
    public final d<ProfileDataContract> invoke(d<List<ProfileDataContract>> dVar) {
        ProfileDataContract profileDataContract;
        j.g(dVar, "<name for destructuring parameter 0>");
        boolean a10 = dVar.a();
        List b10 = dVar.b();
        Throwable c10 = dVar.c();
        if (b10 != null) {
            profileDataContract = (ProfileDataContract) CollectionsKt___CollectionsKt.P(b10);
        } else {
            profileDataContract = null;
        }
        return new d<>(a10, profileDataContract, c10);
    }
}
