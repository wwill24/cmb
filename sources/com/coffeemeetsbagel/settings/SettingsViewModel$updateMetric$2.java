package com.coffeemeetsbagel.settings;

import com.coffeemeetsbagel.models.ModelProfileUpdateDelta;
import com.coffeemeetsbagel.models.NetworkProfile;
import gk.g;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.rx2.RxAwaitKt;
import qj.w;

@d(c = "com.coffeemeetsbagel.settings.SettingsViewModel$updateMetric$2", f = "SettingsViewModel.kt", l = {90}, m = "invokeSuspend")
final class SettingsViewModel$updateMetric$2 extends SuspendLambda implements Function2<k0, c<? super Unit>, Object> {
    final /* synthetic */ ModelProfileUpdateDelta $delta;
    final /* synthetic */ NetworkProfile $networkProfile;
    int label;
    final /* synthetic */ SettingsViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SettingsViewModel$updateMetric$2(SettingsViewModel settingsViewModel, ModelProfileUpdateDelta modelProfileUpdateDelta, NetworkProfile networkProfile, c<? super SettingsViewModel$updateMetric$2> cVar) {
        super(2, cVar);
        this.this$0 = settingsViewModel;
        this.$delta = modelProfileUpdateDelta;
        this.$networkProfile = networkProfile;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        return new SettingsViewModel$updateMetric$2(this.this$0, this.$delta, this.$networkProfile, cVar);
    }

    public final Object invoke(k0 k0Var, c<? super Unit> cVar) {
        return ((SettingsViewModel$updateMetric$2) create(k0Var, cVar)).invokeSuspend(Unit.f32013a);
    }

    public final Object invokeSuspend(Object obj) {
        Object d10 = b.d();
        int i10 = this.label;
        if (i10 == 0) {
            g.b(obj);
            w<Integer> a10 = this.this$0.f36386d.a(this.$delta, this.$networkProfile);
            this.label = 1;
            if (RxAwaitKt.b(a10, this) == d10) {
                return d10;
            }
        } else if (i10 == 1) {
            g.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.f32013a;
    }
}
