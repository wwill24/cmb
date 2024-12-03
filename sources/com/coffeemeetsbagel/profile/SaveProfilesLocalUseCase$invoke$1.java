package com.coffeemeetsbagel.profile;

import com.coffeemeetsbagel.models.NetworkProfile;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import qj.b0;

final class SaveProfilesLocalUseCase$invoke$1 extends Lambda implements Function1<Integer, b0<? extends Integer>> {
    final /* synthetic */ List<NetworkProfile> $profiles;
    final /* synthetic */ SaveProfilesLocalUseCase this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SaveProfilesLocalUseCase$invoke$1(SaveProfilesLocalUseCase saveProfilesLocalUseCase, List<? extends NetworkProfile> list) {
        super(1);
        this.this$0 = saveProfilesLocalUseCase;
        this.$profiles = list;
    }

    /* renamed from: a */
    public final b0<? extends Integer> invoke(Integer num) {
        j.g(num, "it");
        return this.this$0.f36069b.l(this.$profiles);
    }
}
