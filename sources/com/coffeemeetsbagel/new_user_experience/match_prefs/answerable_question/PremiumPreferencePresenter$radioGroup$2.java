package com.coffeemeetsbagel.new_user_experience.match_prefs.answerable_question;

import com.coffeemeetsbagel.cmb_views.CmbRadioGroup;
import com.coffeemeetsbagel.models.dto.Option;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class PremiumPreferencePresenter$radioGroup$2 extends Lambda implements Function0<CmbRadioGroup<Option>> {
    final /* synthetic */ PremiumPreferencePresenter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PremiumPreferencePresenter$radioGroup$2(PremiumPreferencePresenter premiumPreferencePresenter) {
        super(0);
        this.this$0 = premiumPreferencePresenter;
    }

    /* renamed from: a */
    public final CmbRadioGroup<Option> invoke() {
        CmbRadioGroup<Option> cmbRadioGroup = this.this$0.q().f40948l;
        j.e(cmbRadioGroup, "null cannot be cast to non-null type com.coffeemeetsbagel.cmb_views.CmbRadioGroup<com.coffeemeetsbagel.models.dto.Option>");
        return cmbRadioGroup;
    }
}
