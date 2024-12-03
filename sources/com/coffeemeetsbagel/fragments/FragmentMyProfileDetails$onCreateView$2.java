package com.coffeemeetsbagel.fragments;

import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class FragmentMyProfileDetails$onCreateView$2 extends Lambda implements Function1<List<? extends String>, Unit> {
    final /* synthetic */ FragmentMyProfileDetails this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FragmentMyProfileDetails$onCreateView$2(FragmentMyProfileDetails fragmentMyProfileDetails) {
        super(1);
        this.this$0 = fragmentMyProfileDetails;
    }

    public final void a(List<String> list) {
        j.g(list, "list");
        this.this$0.l4(list);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((List) obj);
        return Unit.f32013a;
    }
}
