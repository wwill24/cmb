package com.coffeemeetsbagel.fragments;

import com.coffeemeetsbagel.models.NetworkProfile;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import qj.b0;

final class FragmentMyProfileDetails$mCallBackUpdateProfile$1$onReceiveSuccess$1 extends Lambda implements Function1<List<? extends Long>, b0<? extends List<? extends Long>>> {
    final /* synthetic */ NetworkProfile $mutatedInMemoryMyProfile;
    final /* synthetic */ FragmentMyProfileDetails this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FragmentMyProfileDetails$mCallBackUpdateProfile$1$onReceiveSuccess$1(FragmentMyProfileDetails fragmentMyProfileDetails, NetworkProfile networkProfile) {
        super(1);
        this.this$0 = fragmentMyProfileDetails;
        this.$mutatedInMemoryMyProfile = networkProfile;
    }

    /* renamed from: a */
    public final b0<? extends List<Long>> invoke(List<Long> list) {
        j.g(list, "it");
        return this.this$0.u3().c(this.$mutatedInMemoryMyProfile);
    }
}
