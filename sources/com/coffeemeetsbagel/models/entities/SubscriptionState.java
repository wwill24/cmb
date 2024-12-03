package com.coffeemeetsbagel.models.entities;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.DefaultConstructorMarker;

public enum SubscriptionState {
    DEFAULT(0),
    RECOVERED(1),
    CANCELLED(3),
    ON_HOLD(5),
    RESTARTED(7);
    
    public static final Companion Companion = null;
    /* access modifiers changed from: private */
    public static final Map<Integer, SubscriptionState> map = null;
    private final int apiKey;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SubscriptionState fromApiKey(Integer num) {
            if (num == null) {
                try {
                    return SubscriptionState.DEFAULT;
                } catch (NoSuchElementException unused) {
                    return SubscriptionState.DEFAULT;
                }
            } else {
                SubscriptionState subscriptionState = (SubscriptionState) h0.j(SubscriptionState.map, Integer.valueOf(num.intValue()));
                if (subscriptionState == null) {
                    return SubscriptionState.DEFAULT;
                }
                return subscriptionState;
            }
        }
    }

    static {
        int i10;
        Companion = new Companion((DefaultConstructorMarker) null);
        SubscriptionState[] values = values();
        LinkedHashMap linkedHashMap = new LinkedHashMap(j.c(g0.e(values.length), 16));
        for (SubscriptionState subscriptionState : values) {
            linkedHashMap.put(Integer.valueOf(subscriptionState.apiKey), subscriptionState);
        }
        map = linkedHashMap;
    }

    private SubscriptionState(int i10) {
        this.apiKey = i10;
    }

    public final int getApiKey() {
        return this.apiKey;
    }
}
