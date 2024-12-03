package com.coffeemeetsbagel.domain.repository;

import com.coffeemeetsbagel.models.ProfileDtoImplementation;
import com.coffeemeetsbagel.models.dto.ProfileDataContractKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import okhttp3.b0;
import qj.w;
import retrofit2.r;

final class ProfileRepository$saveGender$1 extends Lambda implements Function1<r<b0>, qj.b0<? extends Integer>> {
    final /* synthetic */ ProfileDtoImplementation $profile;
    final /* synthetic */ ProfileRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ProfileRepository$saveGender$1(ProfileRepository profileRepository, ProfileDtoImplementation profileDtoImplementation) {
        super(1);
        this.this$0 = profileRepository;
        this.$profile = profileDtoImplementation;
    }

    /* access modifiers changed from: private */
    public static final Integer d(ProfileRepository profileRepository, ProfileDtoImplementation profileDtoImplementation) {
        j.g(profileRepository, "this$0");
        j.g(profileDtoImplementation, "$profile");
        return Integer.valueOf(profileRepository.j().c(p.e(ProfileDataContractKt.toRoomEntity(profileDtoImplementation))));
    }

    /* renamed from: c */
    public final qj.b0<? extends Integer> invoke(r<b0> rVar) {
        j.g(rVar, "it");
        return w.A(new n0(this.this$0, this.$profile));
    }
}
