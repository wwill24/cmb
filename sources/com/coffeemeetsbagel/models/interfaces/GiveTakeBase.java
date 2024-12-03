package com.coffeemeetsbagel.models.interfaces;

import com.coffeemeetsbagel.models.NetworkProfile;

public interface GiveTakeBase {
    String getEndDate();

    String getId();

    NetworkProfile getProfile();

    String getProfileId();

    String getStartDate();

    boolean isBlocked();
}
