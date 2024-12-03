package com.coffeemeetsbagel.models.entities;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class SuggestedLimitsEntity {

    /* renamed from: id  reason: collision with root package name */
    private final int f34727id;
    private final Integer numBagelsRequiredForUpsell;
    private final Integer remainingLikes;
    private final Integer remainingViews;

    public SuggestedLimitsEntity() {
        this(0, (Integer) null, (Integer) null, (Integer) null, 15, (DefaultConstructorMarker) null);
    }

    public SuggestedLimitsEntity(int i10, Integer num, Integer num2, Integer num3) {
        this.f34727id = i10;
        this.remainingLikes = num;
        this.remainingViews = num2;
        this.numBagelsRequiredForUpsell = num3;
    }

    public static /* synthetic */ SuggestedLimitsEntity copy$default(SuggestedLimitsEntity suggestedLimitsEntity, int i10, Integer num, Integer num2, Integer num3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = suggestedLimitsEntity.f34727id;
        }
        if ((i11 & 2) != 0) {
            num = suggestedLimitsEntity.remainingLikes;
        }
        if ((i11 & 4) != 0) {
            num2 = suggestedLimitsEntity.remainingViews;
        }
        if ((i11 & 8) != 0) {
            num3 = suggestedLimitsEntity.numBagelsRequiredForUpsell;
        }
        return suggestedLimitsEntity.copy(i10, num, num2, num3);
    }

    public final int component1() {
        return this.f34727id;
    }

    public final Integer component2() {
        return this.remainingLikes;
    }

    public final Integer component3() {
        return this.remainingViews;
    }

    public final Integer component4() {
        return this.numBagelsRequiredForUpsell;
    }

    public final SuggestedLimitsEntity copy(int i10, Integer num, Integer num2, Integer num3) {
        return new SuggestedLimitsEntity(i10, num, num2, num3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SuggestedLimitsEntity)) {
            return false;
        }
        SuggestedLimitsEntity suggestedLimitsEntity = (SuggestedLimitsEntity) obj;
        return this.f34727id == suggestedLimitsEntity.f34727id && j.b(this.remainingLikes, suggestedLimitsEntity.remainingLikes) && j.b(this.remainingViews, suggestedLimitsEntity.remainingViews) && j.b(this.numBagelsRequiredForUpsell, suggestedLimitsEntity.numBagelsRequiredForUpsell);
    }

    public final int getId() {
        return this.f34727id;
    }

    public final Integer getNumBagelsRequiredForUpsell() {
        return this.numBagelsRequiredForUpsell;
    }

    public final Integer getRemainingLikes() {
        return this.remainingLikes;
    }

    public final Integer getRemainingViews() {
        return this.remainingViews;
    }

    public int hashCode() {
        int hashCode = Integer.hashCode(this.f34727id) * 31;
        Integer num = this.remainingLikes;
        int i10 = 0;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.remainingViews;
        int hashCode3 = (hashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.numBagelsRequiredForUpsell;
        if (num3 != null) {
            i10 = num3.hashCode();
        }
        return hashCode3 + i10;
    }

    public String toString() {
        return "SuggestedLimitsEntity(id=" + this.f34727id + ", remainingLikes=" + this.remainingLikes + ", remainingViews=" + this.remainingViews + ", numBagelsRequiredForUpsell=" + this.numBagelsRequiredForUpsell + PropertyUtils.MAPPED_DELIM2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SuggestedLimitsEntity(int i10, Integer num, Integer num2, Integer num3, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? 0 : i10, (i11 & 2) != 0 ? null : num, (i11 & 4) != 0 ? null : num2, (i11 & 8) != 0 ? null : num3);
    }
}
