package com.facebook.appevents;

import com.facebook.appevents.internal.AppEventUtility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.j;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH\u0007R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/facebook/appevents/AppEventStore;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "persistEvents", "", "accessTokenAppIdPair", "Lcom/facebook/appevents/AccessTokenAppIdPair;", "appEvents", "Lcom/facebook/appevents/SessionEventsState;", "eventsToPersist", "Lcom/facebook/appevents/AppEventCollection;", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class AppEventStore {
    public static final AppEventStore INSTANCE = new AppEventStore();
    private static final String TAG = AppEventStore.class.getName();

    private AppEventStore() {
    }

    public static final synchronized void persistEvents(AccessTokenAppIdPair accessTokenAppIdPair, SessionEventsState sessionEventsState) {
        Class<AppEventStore> cls = AppEventStore.class;
        synchronized (cls) {
            if (!CrashShieldHandler.isObjectCrashing(cls)) {
                try {
                    j.g(accessTokenAppIdPair, "accessTokenAppIdPair");
                    j.g(sessionEventsState, "appEvents");
                    AppEventUtility.assertIsNotMainThread();
                    PersistedEvents readAndClearStore = AppEventDiskStore.readAndClearStore();
                    readAndClearStore.addEvents(accessTokenAppIdPair, sessionEventsState.getEventsToPersist());
                    AppEventDiskStore.saveEventsToDisk$facebook_core_release(readAndClearStore);
                } catch (Throwable th2) {
                    CrashShieldHandler.handleThrowable(th2, cls);
                }
            }
        }
    }

    public static final synchronized void persistEvents(AppEventCollection appEventCollection) {
        Class<AppEventStore> cls = AppEventStore.class;
        synchronized (cls) {
            if (!CrashShieldHandler.isObjectCrashing(cls)) {
                try {
                    j.g(appEventCollection, "eventsToPersist");
                    AppEventUtility.assertIsNotMainThread();
                    PersistedEvents readAndClearStore = AppEventDiskStore.readAndClearStore();
                    for (AccessTokenAppIdPair next : appEventCollection.keySet()) {
                        SessionEventsState sessionEventsState = appEventCollection.get(next);
                        if (sessionEventsState != null) {
                            readAndClearStore.addEvents(next, sessionEventsState.getEventsToPersist());
                        } else {
                            throw new IllegalStateException("Required value was null.".toString());
                        }
                    }
                    AppEventDiskStore.saveEventsToDisk$facebook_core_release(readAndClearStore);
                } catch (Throwable th2) {
                    CrashShieldHandler.handleThrowable(th2, cls);
                }
            }
        }
    }
}
