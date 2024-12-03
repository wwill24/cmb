package com.coffeemeetsbagel.store;

import com.coffeemeetsbagel.models.entities.BenefitEntity;
import com.coffeemeetsbagel.subscription.network.models.NetworkBenefit;
import kotlin.jvm.internal.j;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final b f36778a = new b();

    private b() {
    }

    public final vb.b a(BenefitEntity benefitEntity) {
        j.g(benefitEntity, "entity");
        return new vb.b(benefitEntity.getKey(), benefitEntity.getDeepLinkTags(), benefitEntity.getDescription(), benefitEntity.getIconUrl(), benefitEntity.getImageUrl(), benefitEntity.getTitle(), benefitEntity.getTitleSmallDisplay());
    }

    public final BenefitEntity b(String str, NetworkBenefit networkBenefit) {
        j.g(str, "benefitMapKey");
        j.g(networkBenefit, "benefit");
        return new BenefitEntity(str, System.currentTimeMillis(), networkBenefit.getIntents(), networkBenefit.getDescription(), networkBenefit.getIconUrl(), networkBenefit.getImageUrl(), networkBenefit.getTitle(), networkBenefit.getTitleSmallDisplay());
    }
}
