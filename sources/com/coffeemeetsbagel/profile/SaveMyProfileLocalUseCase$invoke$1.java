package com.coffeemeetsbagel.profile;

import com.coffeemeetsbagel.models.NetworkProfile;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import qj.b0;

final class SaveMyProfileLocalUseCase$invoke$1 extends Lambda implements Function1<Integer, b0<? extends List<? extends Long>>> {
    final /* synthetic */ NetworkProfile $networkProfile;
    final /* synthetic */ SaveMyProfileLocalUseCase this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SaveMyProfileLocalUseCase$invoke$1(SaveMyProfileLocalUseCase saveMyProfileLocalUseCase, NetworkProfile networkProfile) {
        super(1);
        this.this$0 = saveMyProfileLocalUseCase;
        this.$networkProfile = networkProfile;
    }

    /* renamed from: a */
    public final b0<? extends List<Long>> invoke(Integer num) {
        j.g(num, "it");
        return this.this$0.f36067b.d(this.$networkProfile);
    }
}
