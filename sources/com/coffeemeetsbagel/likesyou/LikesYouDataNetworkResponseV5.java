package com.coffeemeetsbagel.likesyou;

import java.util.List;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class LikesYouDataNetworkResponseV5 {
    private final List<LikesYouNetworkCard> cards;
    private final List<LikesYouNetworkGroup> groups;
    private final List<LikesYouNetworkPaywallCard> paywallCards;

    public LikesYouDataNetworkResponseV5(List<LikesYouNetworkCard> list, List<LikesYouNetworkGroup> list2, List<LikesYouNetworkPaywallCard> list3) {
        j.g(list, "cards");
        j.g(list2, "groups");
        this.cards = list;
        this.groups = list2;
        this.paywallCards = list3;
    }

    public static /* synthetic */ LikesYouDataNetworkResponseV5 copy$default(LikesYouDataNetworkResponseV5 likesYouDataNetworkResponseV5, List<LikesYouNetworkCard> list, List<LikesYouNetworkGroup> list2, List<LikesYouNetworkPaywallCard> list3, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = likesYouDataNetworkResponseV5.cards;
        }
        if ((i10 & 2) != 0) {
            list2 = likesYouDataNetworkResponseV5.groups;
        }
        if ((i10 & 4) != 0) {
            list3 = likesYouDataNetworkResponseV5.paywallCards;
        }
        return likesYouDataNetworkResponseV5.copy(list, list2, list3);
    }

    public final List<LikesYouNetworkCard> component1() {
        return this.cards;
    }

    public final List<LikesYouNetworkGroup> component2() {
        return this.groups;
    }

    public final List<LikesYouNetworkPaywallCard> component3() {
        return this.paywallCards;
    }

    public final LikesYouDataNetworkResponseV5 copy(List<LikesYouNetworkCard> list, List<LikesYouNetworkGroup> list2, List<LikesYouNetworkPaywallCard> list3) {
        j.g(list, "cards");
        j.g(list2, "groups");
        return new LikesYouDataNetworkResponseV5(list, list2, list3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LikesYouDataNetworkResponseV5)) {
            return false;
        }
        LikesYouDataNetworkResponseV5 likesYouDataNetworkResponseV5 = (LikesYouDataNetworkResponseV5) obj;
        return j.b(this.cards, likesYouDataNetworkResponseV5.cards) && j.b(this.groups, likesYouDataNetworkResponseV5.groups) && j.b(this.paywallCards, likesYouDataNetworkResponseV5.paywallCards);
    }

    public final List<LikesYouNetworkCard> getCards() {
        return this.cards;
    }

    public final List<LikesYouNetworkGroup> getGroups() {
        return this.groups;
    }

    public final List<LikesYouNetworkPaywallCard> getPaywallCards() {
        return this.paywallCards;
    }

    public int hashCode() {
        int hashCode = ((this.cards.hashCode() * 31) + this.groups.hashCode()) * 31;
        List<LikesYouNetworkPaywallCard> list = this.paywallCards;
        return hashCode + (list == null ? 0 : list.hashCode());
    }

    public String toString() {
        return "LikesYouDataNetworkResponseV5(cards=" + this.cards + ", groups=" + this.groups + ", paywallCards=" + this.paywallCards + PropertyUtils.MAPPED_DELIM2;
    }
}
