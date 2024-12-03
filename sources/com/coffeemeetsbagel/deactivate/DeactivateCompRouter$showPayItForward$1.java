package com.coffeemeetsbagel.deactivate;

import com.coffeemeetsbagel.deactivate.g;
import com.coffeemeetsbagel.external_links.CmbLinks;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

final class DeactivateCompRouter$showPayItForward$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ CmbLinks.PayItForwardSurveyParameters $payload;
    final /* synthetic */ DeactivateCompRouter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeactivateCompRouter$showPayItForward$1(DeactivateCompRouter deactivateCompRouter, CmbLinks.PayItForwardSurveyParameters payItForwardSurveyParameters) {
        super(0);
        this.this$0 = deactivateCompRouter;
        this.$payload = payItForwardSurveyParameters;
    }

    public final void invoke() {
        CmbLinks.Companion.launchMetSomeoneOnCmbSurvey(((g.a) this.this$0.e()).a(), this.$payload);
    }
}
