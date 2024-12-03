package com.coffeemeetsbagel.feature.mongoose.api.models;

public class ChatTokenDecoded {
    private long exp;
    private long iat;

    public long getExp() {
        return this.exp;
    }

    public long getIat() {
        return this.iat;
    }
}
