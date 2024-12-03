package com.coffeemeetsbagel.feature.bagel;

import com.coffeemeetsbagel.models.ActivityReport;
import com.coffeemeetsbagel.models.Bagel;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import qj.b0;
import qj.w;
import qj.y;

final class UpdateBagelLocalUseCase$invoke$2 extends Lambda implements Function1<Bagel, b0<? extends Bagel>> {
    final /* synthetic */ Bagel $bagel;
    final /* synthetic */ UpdateBagelLocalUseCase this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UpdateBagelLocalUseCase$invoke$2(Bagel bagel, UpdateBagelLocalUseCase updateBagelLocalUseCase) {
        super(1);
        this.$bagel = bagel;
        this.this$0 = updateBagelLocalUseCase;
    }

    /* access modifiers changed from: private */
    public static final void e(Bagel bagel, UpdateBagelLocalUseCase updateBagelLocalUseCase, Bagel bagel2, y yVar) {
        j.g(bagel, "$bagel");
        j.g(updateBagelLocalUseCase, "this$0");
        j.g(bagel2, "$updateBagel");
        j.g(yVar, "emitter");
        String profileId = bagel.getProfileId();
        updateBagelLocalUseCase.f12691a.b(p.e(profileId), new a0(bagel2, yVar, profileId));
    }

    /* access modifiers changed from: private */
    public static final void f(Bagel bagel, y yVar, String str, Map map) {
        j.g(bagel, "$updateBagel");
        j.g(yVar, "$emitter");
        bagel.getProfile().setActivityReport((ActivityReport) map.get(str));
        yVar.onSuccess(bagel);
    }

    /* renamed from: d */
    public final b0<? extends Bagel> invoke(Bagel bagel) {
        j.g(bagel, "updateBagel");
        return w.k(new z(this.$bagel, this.this$0, bagel));
    }
}
