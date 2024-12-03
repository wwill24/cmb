package com.facebook.appevents;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.j;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\"\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0010\u0010\u0010\u001a\u00020\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012J\u0013\u0010\u0013\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\tH\u0002J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0015\u001a\u00020\tH\u0002J\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\t0\u0017R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/facebook/appevents/AppEventCollection;", "", "()V", "eventCount", "", "getEventCount", "()I", "stateMap", "Ljava/util/HashMap;", "Lcom/facebook/appevents/AccessTokenAppIdPair;", "Lcom/facebook/appevents/SessionEventsState;", "addEvent", "", "accessTokenAppIdPair", "appEvent", "Lcom/facebook/appevents/AppEvent;", "addPersistedEvents", "persistedEvents", "Lcom/facebook/appevents/PersistedEvents;", "get", "getSessionEventsState", "accessTokenAppId", "keySet", "", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class AppEventCollection {
    private final HashMap<AccessTokenAppIdPair, SessionEventsState> stateMap = new HashMap<>();

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000b, code lost:
        r1 = com.facebook.FacebookSdk.getApplicationContext();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final synchronized com.facebook.appevents.SessionEventsState getSessionEventsState(com.facebook.appevents.AccessTokenAppIdPair r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            java.util.HashMap<com.facebook.appevents.AccessTokenAppIdPair, com.facebook.appevents.SessionEventsState> r0 = r4.stateMap     // Catch:{ all -> 0x002e }
            java.lang.Object r0 = r0.get(r5)     // Catch:{ all -> 0x002e }
            com.facebook.appevents.SessionEventsState r0 = (com.facebook.appevents.SessionEventsState) r0     // Catch:{ all -> 0x002e }
            if (r0 != 0) goto L_0x0022
            android.content.Context r1 = com.facebook.FacebookSdk.getApplicationContext()     // Catch:{ all -> 0x002e }
            com.facebook.internal.AttributionIdentifiers$Companion r2 = com.facebook.internal.AttributionIdentifiers.Companion     // Catch:{ all -> 0x002e }
            com.facebook.internal.AttributionIdentifiers r2 = r2.getAttributionIdentifiers(r1)     // Catch:{ all -> 0x002e }
            if (r2 == 0) goto L_0x0022
            com.facebook.appevents.SessionEventsState r0 = new com.facebook.appevents.SessionEventsState     // Catch:{ all -> 0x002e }
            com.facebook.appevents.AppEventsLogger$Companion r3 = com.facebook.appevents.AppEventsLogger.Companion     // Catch:{ all -> 0x002e }
            java.lang.String r1 = r3.getAnonymousAppDeviceGUID(r1)     // Catch:{ all -> 0x002e }
            r0.<init>(r2, r1)     // Catch:{ all -> 0x002e }
        L_0x0022:
            if (r0 != 0) goto L_0x0027
            r5 = 0
            monitor-exit(r4)
            return r5
        L_0x0027:
            java.util.HashMap<com.facebook.appevents.AccessTokenAppIdPair, com.facebook.appevents.SessionEventsState> r1 = r4.stateMap     // Catch:{ all -> 0x002e }
            r1.put(r5, r0)     // Catch:{ all -> 0x002e }
            monitor-exit(r4)
            return r0
        L_0x002e:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.AppEventCollection.getSessionEventsState(com.facebook.appevents.AccessTokenAppIdPair):com.facebook.appevents.SessionEventsState");
    }

    public final synchronized void addEvent(AccessTokenAppIdPair accessTokenAppIdPair, AppEvent appEvent) {
        j.g(accessTokenAppIdPair, "accessTokenAppIdPair");
        j.g(appEvent, "appEvent");
        SessionEventsState sessionEventsState = getSessionEventsState(accessTokenAppIdPair);
        if (sessionEventsState != null) {
            sessionEventsState.addEvent(appEvent);
        }
    }

    public final synchronized void addPersistedEvents(PersistedEvents persistedEvents) {
        if (persistedEvents != null) {
            for (Map.Entry next : persistedEvents.entrySet()) {
                SessionEventsState sessionEventsState = getSessionEventsState((AccessTokenAppIdPair) next.getKey());
                if (sessionEventsState != null) {
                    for (AppEvent addEvent : (List) next.getValue()) {
                        sessionEventsState.addEvent(addEvent);
                    }
                }
            }
        }
    }

    public final synchronized SessionEventsState get(AccessTokenAppIdPair accessTokenAppIdPair) {
        j.g(accessTokenAppIdPair, "accessTokenAppIdPair");
        return this.stateMap.get(accessTokenAppIdPair);
    }

    public final synchronized int getEventCount() {
        int i10;
        i10 = 0;
        for (SessionEventsState accumulatedEventCount : this.stateMap.values()) {
            i10 += accumulatedEventCount.getAccumulatedEventCount();
        }
        return i10;
    }

    public final synchronized Set<AccessTokenAppIdPair> keySet() {
        Set<AccessTokenAppIdPair> keySet;
        keySet = this.stateMap.keySet();
        j.f(keySet, "stateMap.keys");
        return keySet;
    }
}
