package com.coffeemeetsbagel.models.dto;

import com.coffeemeetsbagel.models.enums.MatchAction;
import com.coffeemeetsbagel.models.enums.MatchType;
import com.coffeemeetsbagel.models.enums.PurchaseAttribution;
import j$.time.OffsetDateTime;

public interface MatchContract {
    MatchAction getAction();

    OffsetDateTime getEndAt();

    String getId();

    String getLikeComment();

    String getMatchToMe();

    String getMessage();

    String getProfileId();

    PurchaseAttribution getPurchaseAttribution();

    int getRisingCount();

    Integer getShowOrder();

    OffsetDateTime getStartAt();

    MatchType getType();

    int getWooCount();

    int getWooSeenCount();

    boolean isBlocked();

    boolean isRising();
}
