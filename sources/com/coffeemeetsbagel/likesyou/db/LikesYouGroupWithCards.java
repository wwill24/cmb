package com.coffeemeetsbagel.likesyou.db;

import com.coffeemeetsbagel.models.entities.LikesYouCardEntity;
import com.coffeemeetsbagel.models.entities.LikesYouGroupEntity;
import com.coffeemeetsbagel.models.entities.LikesYouPaywallCard;
import java.util.List;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class LikesYouGroupWithCards {
    private final List<LikesYouCardEntity> cards;
    private final LikesYouGroupEntity group;
    private final List<LikesYouPaywallCard> paywallCards;

    public LikesYouGroupWithCards(LikesYouGroupEntity likesYouGroupEntity, List<LikesYouCardEntity> list, List<LikesYouPaywallCard> list2) {
        j.g(likesYouGroupEntity, "group");
        j.g(list, "cards");
        j.g(list2, "paywallCards");
        this.group = likesYouGroupEntity;
        this.cards = list;
        this.paywallCards = list2;
    }

    public static /* synthetic */ LikesYouGroupWithCards copy$default(LikesYouGroupWithCards likesYouGroupWithCards, LikesYouGroupEntity likesYouGroupEntity, List<LikesYouCardEntity> list, List<LikesYouPaywallCard> list2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            likesYouGroupEntity = likesYouGroupWithCards.group;
        }
        if ((i10 & 2) != 0) {
            list = likesYouGroupWithCards.cards;
        }
        if ((i10 & 4) != 0) {
            list2 = likesYouGroupWithCards.paywallCards;
        }
        return likesYouGroupWithCards.copy(likesYouGroupEntity, list, list2);
    }

    public final LikesYouGroupEntity component1() {
        return this.group;
    }

    public final List<LikesYouCardEntity> component2() {
        return this.cards;
    }

    public final List<LikesYouPaywallCard> component3() {
        return this.paywallCards;
    }

    public final LikesYouGroupWithCards copy(LikesYouGroupEntity likesYouGroupEntity, List<LikesYouCardEntity> list, List<LikesYouPaywallCard> list2) {
        j.g(likesYouGroupEntity, "group");
        j.g(list, "cards");
        j.g(list2, "paywallCards");
        return new LikesYouGroupWithCards(likesYouGroupEntity, list, list2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LikesYouGroupWithCards)) {
            return false;
        }
        LikesYouGroupWithCards likesYouGroupWithCards = (LikesYouGroupWithCards) obj;
        return j.b(this.group, likesYouGroupWithCards.group) && j.b(this.cards, likesYouGroupWithCards.cards) && j.b(this.paywallCards, likesYouGroupWithCards.paywallCards);
    }

    public final List<LikesYouCardEntity> getCards() {
        return this.cards;
    }

    public final LikesYouGroupEntity getGroup() {
        return this.group;
    }

    public final List<LikesYouPaywallCard> getPaywallCards() {
        return this.paywallCards;
    }

    public int hashCode() {
        return (((this.group.hashCode() * 31) + this.cards.hashCode()) * 31) + this.paywallCards.hashCode();
    }

    public String toString() {
        return "LikesYouGroupWithCards(group=" + this.group + ", cards=" + this.cards + ", paywallCards=" + this.paywallCards + PropertyUtils.MAPPED_DELIM2;
    }
}
