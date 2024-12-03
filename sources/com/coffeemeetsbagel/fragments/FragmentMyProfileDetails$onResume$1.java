package com.coffeemeetsbagel.fragments;

import com.coffeemeetsbagel.models.Resource;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class FragmentMyProfileDetails$onResume$1 extends Lambda implements Function1<List<? extends Resource>, Unit> {
    final /* synthetic */ FragmentMyProfileDetails this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FragmentMyProfileDetails$onResume$1(FragmentMyProfileDetails fragmentMyProfileDetails) {
        super(1);
        this.this$0 = fragmentMyProfileDetails;
    }

    public final void a(List<Resource> list) {
        j.g(list, "resources");
        if (list.isEmpty()) {
            this.this$0.O0().d(this.this$0);
            this.this$0.O0().c();
            return;
        }
        this.this$0.f13539o0 = list;
        FragmentMyProfileDetails fragmentMyProfileDetails = this.this$0;
        fragmentMyProfileDetails.f13541p0 = fragmentMyProfileDetails.O0().e(list);
        FragmentMyProfileDetails fragmentMyProfileDetails2 = this.this$0;
        fragmentMyProfileDetails2.b3(fragmentMyProfileDetails2.f13541p0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((List) obj);
        return Unit.f32013a;
    }
}
