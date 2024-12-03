package com.coffeemeetsbagel.new_user_experience.match_prefs.distance;

import com.coffeemeetsbagel.models.CmbErrorCode;
import com.coffeemeetsbagel.models.ModelProfileUpdateDelta;
import com.coffeemeetsbagel.transport.SuccessStatus;
import ja.b;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import qj.b0;
import qj.w;
import qj.y;

final class DistanceMatchPreferenceInteractor$updateProfileService$1 extends Lambda implements Function1<b, b0<? extends Unit>> {
    final /* synthetic */ DistanceMatchPreferenceInteractor this$0;

    public static final class a implements jc.b<Void> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ DistanceMatchPreferenceInteractor f35298a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ y<Unit> f35299b;

        a(DistanceMatchPreferenceInteractor distanceMatchPreferenceInteractor, y<Unit> yVar) {
            this.f35298a = distanceMatchPreferenceInteractor;
            this.f35299b = yVar;
        }

        public void b(CmbErrorCode cmbErrorCode) {
            String str;
            Integer num = null;
            if (cmbErrorCode != null) {
                str = cmbErrorCode.getErrorMessage();
            } else {
                str = null;
            }
            if (cmbErrorCode != null) {
                num = Integer.valueOf(cmbErrorCode.getErrorCode());
            }
            this.f35299b.onError(new Throwable(str + ", code: " + num));
        }

        /* renamed from: c */
        public void a(Void voidR, SuccessStatus successStatus) {
            this.f35298a.j2().f();
            this.f35299b.onSuccess(Unit.f32013a);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DistanceMatchPreferenceInteractor$updateProfileService$1(DistanceMatchPreferenceInteractor distanceMatchPreferenceInteractor) {
        super(1);
        this.this$0 = distanceMatchPreferenceInteractor;
    }

    /* access modifiers changed from: private */
    public static final void d(DistanceMatchPreferenceInteractor distanceMatchPreferenceInteractor, ModelProfileUpdateDelta modelProfileUpdateDelta, y yVar) {
        j.g(distanceMatchPreferenceInteractor, "this$0");
        j.g(modelProfileUpdateDelta, "$delta");
        j.g(yVar, "emitter");
        distanceMatchPreferenceInteractor.j2().p(new a(distanceMatchPreferenceInteractor, yVar), modelProfileUpdateDelta, true);
    }

    /* renamed from: c */
    public final b0<? extends Unit> invoke(b bVar) {
        j.g(bVar, "user");
        ModelProfileUpdateDelta modelProfileUpdateDelta = new ModelProfileUpdateDelta();
        if (bVar.x()) {
            modelProfileUpdateDelta.updateCriteriaDistanceKm(((s) this.this$0.f7875e).l());
        } else {
            modelProfileUpdateDelta.updateCriteriaDistanceMiles(((s) this.this$0.f7875e).m());
        }
        return w.k(new p(this.this$0, modelProfileUpdateDelta));
    }
}
