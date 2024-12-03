package com.coffeemeetsbagel.analytics_common;

import com.facebook.internal.AnalyticsEvents;

public enum AnalyticsConstants$Logout {
    AUTOMATIC(AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_AUTOMATIC),
    USER_INITIATED("user initiated");
    
    final String logoutType;

    private AnalyticsConstants$Logout(String str) {
        this.logoutType = str;
    }

    public String toString() {
        return this.logoutType;
    }
}
