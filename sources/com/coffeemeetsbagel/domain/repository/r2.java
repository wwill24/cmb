package com.coffeemeetsbagel.domain.repository;

import com.coffeemeetsbagel.models.entities.SuggestedLimitsEntity;
import vj.a;

public final /* synthetic */ class r2 implements a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SuggestedRepository f12568a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SuggestedLimitsEntity f12569b;

    public /* synthetic */ r2(SuggestedRepository suggestedRepository, SuggestedLimitsEntity suggestedLimitsEntity) {
        this.f12568a = suggestedRepository;
        this.f12569b = suggestedLimitsEntity;
    }

    public final void run() {
        SuggestedRepository$saveSuggestedLimitsFromNetwork$4.e(this.f12568a, this.f12569b);
    }
}
