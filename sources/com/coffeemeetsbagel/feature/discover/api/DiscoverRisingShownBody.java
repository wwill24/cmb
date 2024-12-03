package com.coffeemeetsbagel.feature.discover.api;

class DiscoverRisingShownBody {
    final String profile_id;
    final boolean shown;

    public DiscoverRisingShownBody(String str, boolean z10) {
        this.profile_id = str;
        this.shown = z10;
    }
}
