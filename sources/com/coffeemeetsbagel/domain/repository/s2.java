package com.coffeemeetsbagel.domain.repository;

import com.coffeemeetsbagel.models.entities.SuggestedLimitsEntity;
import vj.a;

public final /* synthetic */ class s2 implements a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SuggestedRepository f12573a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SuggestedLimitsEntity f12574b;

    public /* synthetic */ s2(SuggestedRepository suggestedRepository, SuggestedLimitsEntity suggestedLimitsEntity) {
        this.f12573a = suggestedRepository;
        this.f12574b = suggestedLimitsEntity;
    }

    public final void run() {
        SuggestedRepository$saveSuggestedLimitsFromNetwork$4.f(this.f12573a, this.f12574b);
    }
}
