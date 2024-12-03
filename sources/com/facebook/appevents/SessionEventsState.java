package com.facebook.appevents;

import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.leanplum.internal.Constants;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u000f\b\u0001\u0018\u0000 *2\u00020\u0001:\u0001*B\u0017\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b(\u0010)J0\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u000e\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eJ\u000e\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\nJ&\u0010\r\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nJ\u0014\u0010\u0015\u001a\u00020\f2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0014R\u0014\u0010\u0017\u001a\u00020\u00168\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001a\u001a\u00020\u00198\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001c8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001c8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010\u001eR\u0016\u0010 \u001a\u00020\u00068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u0011\u0010$\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0017\u0010'\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00148F¢\u0006\u0006\u001a\u0004\b%\u0010&¨\u0006+"}, d2 = {"Lcom/facebook/appevents/SessionEventsState;", "", "Lcom/facebook/GraphRequest;", "request", "Landroid/content/Context;", "applicationContext", "", "numSkipped", "Lorg/json/a;", "events", "", "limitEventUsage", "", "populateRequest", "Lcom/facebook/appevents/AppEvent;", "event", "addEvent", "moveToAccumulated", "clearInFlightAndStats", "includeImplicitEvents", "", "accumulatePersistedEvents", "Lcom/facebook/internal/AttributionIdentifiers;", "attributionIdentifiers", "Lcom/facebook/internal/AttributionIdentifiers;", "", "anonymousAppDeviceGUID", "Ljava/lang/String;", "", "accumulatedEvents", "Ljava/util/List;", "inFlightEvents", "numSkippedEventsDueToFullBuffer", "I", "getAccumulatedEventCount", "()I", "accumulatedEventCount", "getEventsToPersist", "()Ljava/util/List;", "eventsToPersist", "<init>", "(Lcom/facebook/internal/AttributionIdentifiers;Ljava/lang/String;)V", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class SessionEventsState {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int MAX_ACCUMULATED_LOG_EVENTS = 1000;
    private static final String TAG = SessionEventsState.class.getSimpleName();
    private List<AppEvent> accumulatedEvents = new ArrayList();
    private final String anonymousAppDeviceGUID;
    private final AttributionIdentifiers attributionIdentifiers;
    private final List<AppEvent> inFlightEvents = new ArrayList();
    private int numSkippedEventsDueToFullBuffer;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/facebook/appevents/SessionEventsState$Companion;", "", "()V", "MAX_ACCUMULATED_LOG_EVENTS", "", "TAG", "", "kotlin.jvm.PlatformType", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public SessionEventsState(AttributionIdentifiers attributionIdentifiers2, String str) {
        j.g(attributionIdentifiers2, "attributionIdentifiers");
        j.g(str, "anonymousAppDeviceGUID");
        this.attributionIdentifiers = attributionIdentifiers2;
        this.anonymousAppDeviceGUID = str;
    }

    public final synchronized void accumulatePersistedEvents(List<AppEvent> list) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                j.g(list, Constants.Params.API_EVENTS_STATE);
                this.accumulatedEvents.addAll(list);
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, this);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002c, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void addEvent(com.facebook.appevents.AppEvent r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r2)     // Catch:{ all -> 0x0033 }
            if (r0 == 0) goto L_0x0009
            monitor-exit(r2)
            return
        L_0x0009:
            java.lang.String r0 = "event"
            kotlin.jvm.internal.j.g(r3, r0)     // Catch:{ all -> 0x002d }
            java.util.List<com.facebook.appevents.AppEvent> r0 = r2.accumulatedEvents     // Catch:{ all -> 0x002d }
            int r0 = r0.size()     // Catch:{ all -> 0x002d }
            java.util.List<com.facebook.appevents.AppEvent> r1 = r2.inFlightEvents     // Catch:{ all -> 0x002d }
            int r1 = r1.size()     // Catch:{ all -> 0x002d }
            int r0 = r0 + r1
            int r1 = MAX_ACCUMULATED_LOG_EVENTS     // Catch:{ all -> 0x002d }
            if (r0 < r1) goto L_0x0026
            int r3 = r2.numSkippedEventsDueToFullBuffer     // Catch:{ all -> 0x002d }
            int r3 = r3 + 1
            r2.numSkippedEventsDueToFullBuffer = r3     // Catch:{ all -> 0x002d }
            goto L_0x002b
        L_0x0026:
            java.util.List<com.facebook.appevents.AppEvent> r0 = r2.accumulatedEvents     // Catch:{ all -> 0x002d }
            r0.add(r3)     // Catch:{ all -> 0x002d }
        L_0x002b:
            monitor-exit(r2)
            return
        L_0x002d:
            r3 = move-exception
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r3, r2)     // Catch:{ all -> 0x0033 }
            monitor-exit(r2)
            return
        L_0x0033:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.SessionEventsState.addEvent(com.facebook.appevents.AppEvent):void");
    }

    public final synchronized void clearInFlightAndStats(boolean z10) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            if (z10) {
                try {
                    this.accumulatedEvents.addAll(this.inFlightEvents);
                } catch (Throwable th2) {
                    CrashShieldHandler.handleThrowable(th2, this);
                    return;
                }
            }
            this.inFlightEvents.clear();
            this.numSkippedEventsDueToFullBuffer = 0;
        }
    }

    public final synchronized int getAccumulatedEventCount() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return 0;
        }
        try {
            return this.accumulatedEvents.size();
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, this);
            return 0;
        }
    }

    public final synchronized List<AppEvent> getEventsToPersist() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            List<AppEvent> list = this.accumulatedEvents;
            this.accumulatedEvents = new ArrayList();
            return list;
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, this);
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x007e, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x007f, code lost:
        com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r9, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0082, code lost:
        return 0;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int populateRequest(com.facebook.GraphRequest r9, android.content.Context r10, boolean r11, boolean r12) {
        /*
            r8 = this;
            boolean r0 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r8)
            r1 = 0
            if (r0 == 0) goto L_0x0008
            return r1
        L_0x0008:
            java.lang.String r0 = "request"
            kotlin.jvm.internal.j.g(r9, r0)     // Catch:{ all -> 0x007e }
            java.lang.String r0 = "applicationContext"
            kotlin.jvm.internal.j.g(r10, r0)     // Catch:{ all -> 0x007e }
            monitor-enter(r8)     // Catch:{ all -> 0x007e }
            int r5 = r8.numSkippedEventsDueToFullBuffer     // Catch:{ all -> 0x007b }
            com.facebook.appevents.eventdeactivation.EventDeactivationManager r0 = com.facebook.appevents.eventdeactivation.EventDeactivationManager.INSTANCE     // Catch:{ all -> 0x007b }
            java.util.List<com.facebook.appevents.AppEvent> r0 = r8.accumulatedEvents     // Catch:{ all -> 0x007b }
            com.facebook.appevents.eventdeactivation.EventDeactivationManager.processEvents(r0)     // Catch:{ all -> 0x007b }
            java.util.List<com.facebook.appevents.AppEvent> r0 = r8.inFlightEvents     // Catch:{ all -> 0x007b }
            java.util.List<com.facebook.appevents.AppEvent> r2 = r8.accumulatedEvents     // Catch:{ all -> 0x007b }
            r0.addAll(r2)     // Catch:{ all -> 0x007b }
            java.util.List<com.facebook.appevents.AppEvent> r0 = r8.accumulatedEvents     // Catch:{ all -> 0x007b }
            r0.clear()     // Catch:{ all -> 0x007b }
            org.json.a r0 = new org.json.a     // Catch:{ all -> 0x007b }
            r0.<init>()     // Catch:{ all -> 0x007b }
            java.util.List<com.facebook.appevents.AppEvent> r2 = r8.inFlightEvents     // Catch:{ all -> 0x007b }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x007b }
        L_0x0033:
            boolean r3 = r2.hasNext()     // Catch:{ all -> 0x007b }
            if (r3 == 0) goto L_0x0063
            java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x007b }
            com.facebook.appevents.AppEvent r3 = (com.facebook.appevents.AppEvent) r3     // Catch:{ all -> 0x007b }
            boolean r4 = r3.isChecksumValid()     // Catch:{ all -> 0x007b }
            if (r4 == 0) goto L_0x0055
            if (r11 != 0) goto L_0x004d
            boolean r4 = r3.isImplicit()     // Catch:{ all -> 0x007b }
            if (r4 != 0) goto L_0x0033
        L_0x004d:
            org.json.b r3 = r3.getJsonObject()     // Catch:{ all -> 0x007b }
            r0.E(r3)     // Catch:{ all -> 0x007b }
            goto L_0x0033
        L_0x0055:
            com.facebook.internal.Utility r4 = com.facebook.internal.Utility.INSTANCE     // Catch:{ all -> 0x007b }
            java.lang.String r4 = TAG     // Catch:{ all -> 0x007b }
            java.lang.String r6 = "Event with invalid checksum: "
            java.lang.String r3 = kotlin.jvm.internal.j.p(r6, r3)     // Catch:{ all -> 0x007b }
            com.facebook.internal.Utility.logd((java.lang.String) r4, (java.lang.String) r3)     // Catch:{ all -> 0x007b }
            goto L_0x0033
        L_0x0063:
            int r11 = r0.o()     // Catch:{ all -> 0x007b }
            if (r11 != 0) goto L_0x006b
            monitor-exit(r8)     // Catch:{ all -> 0x007e }
            return r1
        L_0x006b:
            kotlin.Unit r11 = kotlin.Unit.f32013a     // Catch:{ all -> 0x007b }
            monitor-exit(r8)     // Catch:{ all -> 0x007e }
            r2 = r8
            r3 = r9
            r4 = r10
            r6 = r0
            r7 = r12
            r2.populateRequest(r3, r4, r5, r6, r7)     // Catch:{ all -> 0x007e }
            int r9 = r0.o()     // Catch:{ all -> 0x007e }
            return r9
        L_0x007b:
            r9 = move-exception
            monitor-exit(r8)     // Catch:{ all -> 0x007e }
            throw r9     // Catch:{ all -> 0x007e }
        L_0x007e:
            r9 = move-exception
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r9, r8)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.SessionEventsState.populateRequest(com.facebook.GraphRequest, android.content.Context, boolean, boolean):int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0040, code lost:
        com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r4, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0043, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x001d, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:?, code lost:
        r5 = new org.json.b();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x001f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void populateRequest(com.facebook.GraphRequest r4, android.content.Context r5, int r6, org.json.a r7, boolean r8) {
        /*
            r3 = this;
            boolean r0 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r3)
            if (r0 == 0) goto L_0x0007
            return
        L_0x0007:
            com.facebook.appevents.internal.AppEventsLoggerUtility r0 = com.facebook.appevents.internal.AppEventsLoggerUtility.INSTANCE     // Catch:{ JSONException -> 0x001f }
            com.facebook.appevents.internal.AppEventsLoggerUtility$GraphAPIActivityType r0 = com.facebook.appevents.internal.AppEventsLoggerUtility.GraphAPIActivityType.CUSTOM_APP_EVENTS     // Catch:{ JSONException -> 0x001f }
            com.facebook.internal.AttributionIdentifiers r1 = r3.attributionIdentifiers     // Catch:{ JSONException -> 0x001f }
            java.lang.String r2 = r3.anonymousAppDeviceGUID     // Catch:{ JSONException -> 0x001f }
            org.json.b r5 = com.facebook.appevents.internal.AppEventsLoggerUtility.getJSONObjectForGraphAPICall(r0, r1, r2, r8, r5)     // Catch:{ JSONException -> 0x001f }
            int r8 = r3.numSkippedEventsDueToFullBuffer     // Catch:{ JSONException -> 0x001f }
            if (r8 <= 0) goto L_0x0024
            java.lang.String r8 = "num_skipped_events"
            r5.put((java.lang.String) r8, (int) r6)     // Catch:{ JSONException -> 0x001f }
            goto L_0x0024
        L_0x001d:
            r4 = move-exception
            goto L_0x0040
        L_0x001f:
            org.json.b r5 = new org.json.b     // Catch:{ all -> 0x001d }
            r5.<init>()     // Catch:{ all -> 0x001d }
        L_0x0024:
            r4.setGraphObject(r5)     // Catch:{ all -> 0x001d }
            android.os.Bundle r5 = r4.getParameters()     // Catch:{ all -> 0x001d }
            java.lang.String r6 = r7.toString()     // Catch:{ all -> 0x001d }
            java.lang.String r7 = "events.toString()"
            kotlin.jvm.internal.j.f(r6, r7)     // Catch:{ all -> 0x001d }
            java.lang.String r7 = "custom_events"
            r5.putString(r7, r6)     // Catch:{ all -> 0x001d }
            r4.setTag(r6)     // Catch:{ all -> 0x001d }
            r4.setParameters(r5)     // Catch:{ all -> 0x001d }
            return
        L_0x0040:
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r4, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.SessionEventsState.populateRequest(com.facebook.GraphRequest, android.content.Context, int, org.json.a, boolean):void");
    }
}
