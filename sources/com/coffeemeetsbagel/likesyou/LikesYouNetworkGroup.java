package com.coffeemeetsbagel.likesyou;

import java.util.List;
import kotlin.jvm.internal.j;
import lg.c;
import org.apache.commons.beanutils.PropertyUtils;

public final class LikesYouNetworkGroup {
    @c("contextual_recommendation")
    private final NetworkContextualRecommendation contextualRecommendation;
    private final int count;
    @c("empty_state")
    private final NetworkEmptyState emptyState;
    @c("ordered_profile_ids")
    private final List<String> freeProfileIds;
    @c("group_order_ordinal")
    private final int groupOrdinal;

    /* renamed from: id  reason: collision with root package name */
    private final String f34333id;
    @c("max_display_count")
    private final Integer maxDisplayCount;
    private final String name;
    @c("paywall_profile_ids")
    private final List<String> paywallProfileIds;

    public LikesYouNetworkGroup(String str, String str2, int i10, NetworkContextualRecommendation networkContextualRecommendation, NetworkEmptyState networkEmptyState, int i11, List<String> list, List<String> list2, Integer num) {
        j.g(str, "id");
        j.g(str2, "name");
        j.g(list, "freeProfileIds");
        this.f34333id = str;
        this.name = str2;
        this.count = i10;
        this.contextualRecommendation = networkContextualRecommendation;
        this.emptyState = networkEmptyState;
        this.groupOrdinal = i11;
        this.freeProfileIds = list;
        this.paywallProfileIds = list2;
        this.maxDisplayCount = num;
    }

    public static /* synthetic */ LikesYouNetworkGroup copy$default(LikesYouNetworkGroup likesYouNetworkGroup, String str, String str2, int i10, NetworkContextualRecommendation networkContextualRecommendation, NetworkEmptyState networkEmptyState, int i11, List list, List list2, Integer num, int i12, Object obj) {
        LikesYouNetworkGroup likesYouNetworkGroup2 = likesYouNetworkGroup;
        int i13 = i12;
        return likesYouNetworkGroup.copy((i13 & 1) != 0 ? likesYouNetworkGroup2.f34333id : str, (i13 & 2) != 0 ? likesYouNetworkGroup2.name : str2, (i13 & 4) != 0 ? likesYouNetworkGroup2.count : i10, (i13 & 8) != 0 ? likesYouNetworkGroup2.contextualRecommendation : networkContextualRecommendation, (i13 & 16) != 0 ? likesYouNetworkGroup2.emptyState : networkEmptyState, (i13 & 32) != 0 ? likesYouNetworkGroup2.groupOrdinal : i11, (i13 & 64) != 0 ? likesYouNetworkGroup2.freeProfileIds : list, (i13 & 128) != 0 ? likesYouNetworkGroup2.paywallProfileIds : list2, (i13 & 256) != 0 ? likesYouNetworkGroup2.maxDisplayCount : num);
    }

    public final String component1() {
        return this.f34333id;
    }

    public final String component2() {
        return this.name;
    }

    public final int component3() {
        return this.count;
    }

    public final NetworkContextualRecommendation component4() {
        return this.contextualRecommendation;
    }

    public final NetworkEmptyState component5() {
        return this.emptyState;
    }

    public final int component6() {
        return this.groupOrdinal;
    }

    public final List<String> component7() {
        return this.freeProfileIds;
    }

    public final List<String> component8() {
        return this.paywallProfileIds;
    }

    public final Integer component9() {
        return this.maxDisplayCount;
    }

    public final LikesYouNetworkGroup copy(String str, String str2, int i10, NetworkContextualRecommendation networkContextualRecommendation, NetworkEmptyState networkEmptyState, int i11, List<String> list, List<String> list2, Integer num) {
        j.g(str, "id");
        j.g(str2, "name");
        List<String> list3 = list;
        j.g(list3, "freeProfileIds");
        return new LikesYouNetworkGroup(str, str2, i10, networkContextualRecommendation, networkEmptyState, i11, list3, list2, num);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LikesYouNetworkGroup)) {
            return false;
        }
        LikesYouNetworkGroup likesYouNetworkGroup = (LikesYouNetworkGroup) obj;
        return j.b(this.f34333id, likesYouNetworkGroup.f34333id) && j.b(this.name, likesYouNetworkGroup.name) && this.count == likesYouNetworkGroup.count && j.b(this.contextualRecommendation, likesYouNetworkGroup.contextualRecommendation) && j.b(this.emptyState, likesYouNetworkGroup.emptyState) && this.groupOrdinal == likesYouNetworkGroup.groupOrdinal && j.b(this.freeProfileIds, likesYouNetworkGroup.freeProfileIds) && j.b(this.paywallProfileIds, likesYouNetworkGroup.paywallProfileIds) && j.b(this.maxDisplayCount, likesYouNetworkGroup.maxDisplayCount);
    }

    public final NetworkContextualRecommendation getContextualRecommendation() {
        return this.contextualRecommendation;
    }

    public final int getCount() {
        return this.count;
    }

    public final NetworkEmptyState getEmptyState() {
        return this.emptyState;
    }

    public final List<String> getFreeProfileIds() {
        return this.freeProfileIds;
    }

    public final int getGroupOrdinal() {
        return this.groupOrdinal;
    }

    public final String getId() {
        return this.f34333id;
    }

    public final Integer getMaxDisplayCount() {
        return this.maxDisplayCount;
    }

    public final String getName() {
        return this.name;
    }

    public final List<String> getPaywallProfileIds() {
        return this.paywallProfileIds;
    }

    public int hashCode() {
        int hashCode = ((((this.f34333id.hashCode() * 31) + this.name.hashCode()) * 31) + Integer.hashCode(this.count)) * 31;
        NetworkContextualRecommendation networkContextualRecommendation = this.contextualRecommendation;
        int i10 = 0;
        int hashCode2 = (hashCode + (networkContextualRecommendation == null ? 0 : networkContextualRecommendation.hashCode())) * 31;
        NetworkEmptyState networkEmptyState = this.emptyState;
        int hashCode3 = (((((hashCode2 + (networkEmptyState == null ? 0 : networkEmptyState.hashCode())) * 31) + Integer.hashCode(this.groupOrdinal)) * 31) + this.freeProfileIds.hashCode()) * 31;
        List<String> list = this.paywallProfileIds;
        int hashCode4 = (hashCode3 + (list == null ? 0 : list.hashCode())) * 31;
        Integer num = this.maxDisplayCount;
        if (num != null) {
            i10 = num.hashCode();
        }
        return hashCode4 + i10;
    }

    public String toString() {
        return "LikesYouNetworkGroup(id=" + this.f34333id + ", name=" + this.name + ", count=" + this.count + ", contextualRecommendation=" + this.contextualRecommendation + ", emptyState=" + this.emptyState + ", groupOrdinal=" + this.groupOrdinal + ", freeProfileIds=" + this.freeProfileIds + ", paywallProfileIds=" + this.paywallProfileIds + ", maxDisplayCount=" + this.maxDisplayCount + PropertyUtils.MAPPED_DELIM2;
    }
}
