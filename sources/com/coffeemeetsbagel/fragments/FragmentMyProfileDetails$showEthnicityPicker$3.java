package com.coffeemeetsbagel.fragments;

import com.coffeemeetsbagel.cmb_views.CmbTextView;
import com.coffeemeetsbagel.models.ModelProfileUpdateDelta;
import com.coffeemeetsbagel.models.NetworkProfile;
import com.coffeemeetsbagel.models.util.StringUtils;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import lc.c;

final class FragmentMyProfileDetails$showEthnicityPicker$3 extends Lambda implements Function1<List<? extends String>, Unit> {
    final /* synthetic */ FragmentMyProfileDetails this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FragmentMyProfileDetails$showEthnicityPicker$3(FragmentMyProfileDetails fragmentMyProfileDetails) {
        super(1);
        this.this$0 = fragmentMyProfileDetails;
    }

    public final void a(List<String> list) {
        j.g(list, "selectedEthnicities");
        this.this$0.h4(true);
        String join = StringUtils.join(list, ", ");
        ModelProfileUpdateDelta t22 = FragmentMyProfileDetails.f13514z0;
        j.d(t22);
        t22.updateEthnicity(join);
        CmbTextView m22 = this.this$0.f13550w;
        j.d(m22);
        m22.setText(this.this$0.p3(list));
        NetworkProfile y22 = this.this$0.f13519d0;
        j.d(y22);
        y22.setEthnicity(join);
        NetworkProfile j10 = this.this$0.M0().j();
        j.d(j10);
        j10.setEthnicity(join);
        c.h(this.this$0.f13530j0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((List) obj);
        return Unit.f32013a;
    }
}
