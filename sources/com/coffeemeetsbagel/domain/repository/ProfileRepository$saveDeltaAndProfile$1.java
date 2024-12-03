package com.coffeemeetsbagel.domain.repository;

import com.coffeemeetsbagel.models.dto.ProfileDataContract;
import com.coffeemeetsbagel.models.dto.ProfileDataContractKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import okhttp3.b0;
import qj.w;
import retrofit2.r;

final class ProfileRepository$saveDeltaAndProfile$1 extends Lambda implements Function1<r<b0>, qj.b0<? extends Integer>> {
    final /* synthetic */ ProfileDataContract $profile;
    final /* synthetic */ ProfileRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ProfileRepository$saveDeltaAndProfile$1(ProfileRepository profileRepository, ProfileDataContract profileDataContract) {
        super(1);
        this.this$0 = profileRepository;
        this.$profile = profileDataContract;
    }

    /* access modifiers changed from: private */
    public static final Integer d(ProfileRepository profileRepository, ProfileDataContract profileDataContract) {
        j.g(profileRepository, "this$0");
        j.g(profileDataContract, "$profile");
        return Integer.valueOf(profileRepository.j().c(p.e(ProfileDataContractKt.toRoomEntity(profileDataContract))));
    }

    /* renamed from: c */
    public final qj.b0<? extends Integer> invoke(r<b0> rVar) {
        j.g(rVar, "it");
        return w.A(new m0(this.this$0, this.$profile));
    }
}
