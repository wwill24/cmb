package com.coffeemeetsbagel.feature.discover.api;

class DiscoverRisingTakeBody {
    final int action;
    final String profile_id;

    public DiscoverRisingTakeBody(String str, int i10) {
        this.profile_id = str;
        this.action = i10;
    }
}
