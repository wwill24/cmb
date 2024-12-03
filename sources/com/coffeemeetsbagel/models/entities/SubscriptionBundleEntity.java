package com.coffeemeetsbagel.models.entities;

import com.leanplum.internal.Constants;
import java.util.List;
import kotlin.jvm.internal.j;

public final class SubscriptionBundleEntity {
    private final List<String> benefits;

    /* renamed from: id  reason: collision with root package name */
    private final String f34726id;
    private final List<String> intents;
    private final String name;
    private final int tier;
    private final List<String> variants;

    public SubscriptionBundleEntity(String str, String str2, int i10, List<String> list, List<String> list2, List<String> list3) {
        j.g(str, "id");
        j.g(str2, "name");
        j.g(list, "intents");
        j.g(list2, "benefits");
        j.g(list3, Constants.Keys.VARIANTS);
        this.f34726id = str;
        this.name = str2;
        this.tier = i10;
        this.intents = list;
        this.benefits = list2;
        this.variants = list3;
    }

    public final List<String> getBenefits() {
        return this.benefits;
    }

    public final String getId() {
        return this.f34726id;
    }

    public final List<String> getIntents() {
        return this.intents;
    }

    public final String getName() {
        return this.name;
    }

    public final int getTier() {
        return this.tier;
    }

    public final List<String> getVariants() {
        return this.variants;
    }
}
