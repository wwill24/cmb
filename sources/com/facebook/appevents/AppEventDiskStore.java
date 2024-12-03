package com.facebook.appevents;

import com.facebook.appevents.AccessTokenAppIdPair;
import com.facebook.appevents.AppEvent;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001\rB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0007J\u0017\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\bH\u0001¢\u0006\u0002\b\fR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n \u0006*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/facebook/appevents/AppEventDiskStore;", "", "()V", "PERSISTED_EVENTS_FILENAME", "", "TAG", "kotlin.jvm.PlatformType", "readAndClearStore", "Lcom/facebook/appevents/PersistedEvents;", "saveEventsToDisk", "", "eventsToPersist", "saveEventsToDisk$facebook_core_release", "MovedClassObjectInputStream", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class AppEventDiskStore {
    public static final AppEventDiskStore INSTANCE = new AppEventDiskStore();
    private static final String PERSISTED_EVENTS_FILENAME = "AppEventsLogger.persistedevents";
    private static final String TAG = AppEventDiskStore.class.getName();

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0014¨\u0006\b"}, d2 = {"Lcom/facebook/appevents/AppEventDiskStore$MovedClassObjectInputStream;", "Ljava/io/ObjectInputStream;", "inputStream", "Ljava/io/InputStream;", "(Ljava/io/InputStream;)V", "readClassDescriptor", "Ljava/io/ObjectStreamClass;", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private static final class MovedClassObjectInputStream extends ObjectInputStream {
        private static final String ACCESS_TOKEN_APP_ID_PAIR_SERIALIZATION_PROXY_V1_CLASS_NAME = "com.facebook.appevents.AppEventsLogger$AccessTokenAppIdPair$SerializationProxyV1";
        private static final String APP_EVENT_SERIALIZATION_PROXY_V1_CLASS_NAME = "com.facebook.appevents.AppEventsLogger$AppEvent$SerializationProxyV2";
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/facebook/appevents/AppEventDiskStore$MovedClassObjectInputStream$Companion;", "", "()V", "ACCESS_TOKEN_APP_ID_PAIR_SERIALIZATION_PROXY_V1_CLASS_NAME", "", "APP_EVENT_SERIALIZATION_PROXY_V1_CLASS_NAME", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public MovedClassObjectInputStream(InputStream inputStream) {
            super(inputStream);
        }

        /* access modifiers changed from: protected */
        public ObjectStreamClass readClassDescriptor() throws IOException, ClassNotFoundException {
            ObjectStreamClass readClassDescriptor = super.readClassDescriptor();
            if (j.b(readClassDescriptor.getName(), ACCESS_TOKEN_APP_ID_PAIR_SERIALIZATION_PROXY_V1_CLASS_NAME)) {
                readClassDescriptor = ObjectStreamClass.lookup(AccessTokenAppIdPair.SerializationProxyV1.class);
            } else if (j.b(readClassDescriptor.getName(), APP_EVENT_SERIALIZATION_PROXY_V1_CLASS_NAME)) {
                readClassDescriptor = ObjectStreamClass.lookup(AppEvent.SerializationProxyV2.class);
            }
            j.f(readClassDescriptor, "resultClassDescriptor");
            return readClassDescriptor;
        }
    }

    private AppEventDiskStore() {
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(8:21|24|25|26|27|28|29|30) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x004f */
    /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x005f */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x006b A[SYNTHETIC, Splitter:B:48:0x006b] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:24:0x0043=Splitter:B:24:0x0043, B:29:0x004f=Splitter:B:29:0x004f, B:41:0x005f=Splitter:B:41:0x005f} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final synchronized com.facebook.appevents.PersistedEvents readAndClearStore() {
        /*
            java.lang.Class<com.facebook.appevents.AppEventDiskStore> r0 = com.facebook.appevents.AppEventDiskStore.class
            monitor-enter(r0)
            com.facebook.appevents.internal.AppEventUtility.assertIsNotMainThread()     // Catch:{ all -> 0x0072 }
            android.content.Context r1 = com.facebook.FacebookSdk.getApplicationContext()     // Catch:{ all -> 0x0072 }
            r2 = 0
            java.lang.String r3 = "AppEventsLogger.persistedevents"
            java.io.FileInputStream r3 = r1.openFileInput(r3)     // Catch:{ FileNotFoundException -> 0x005e, Exception -> 0x0050, all -> 0x0040 }
            java.lang.String r4 = "context.openFileInput(PERSISTED_EVENTS_FILENAME)"
            kotlin.jvm.internal.j.f(r3, r4)     // Catch:{ FileNotFoundException -> 0x005e, Exception -> 0x0050, all -> 0x0040 }
            com.facebook.appevents.AppEventDiskStore$MovedClassObjectInputStream r4 = new com.facebook.appevents.AppEventDiskStore$MovedClassObjectInputStream     // Catch:{ FileNotFoundException -> 0x005e, Exception -> 0x0050, all -> 0x0040 }
            java.io.BufferedInputStream r5 = new java.io.BufferedInputStream     // Catch:{ FileNotFoundException -> 0x005e, Exception -> 0x0050, all -> 0x0040 }
            r5.<init>(r3)     // Catch:{ FileNotFoundException -> 0x005e, Exception -> 0x0050, all -> 0x0040 }
            r4.<init>(r5)     // Catch:{ FileNotFoundException -> 0x005e, Exception -> 0x0050, all -> 0x0040 }
            java.lang.Object r3 = r4.readObject()     // Catch:{ FileNotFoundException -> 0x005f, Exception -> 0x0051, all -> 0x003e }
            if (r3 == 0) goto L_0x0036
            com.facebook.appevents.PersistedEvents r3 = (com.facebook.appevents.PersistedEvents) r3     // Catch:{ FileNotFoundException -> 0x005f, Exception -> 0x0051, all -> 0x003e }
            com.facebook.internal.Utility.closeQuietly(r4)     // Catch:{ all -> 0x0072 }
            java.lang.String r2 = "AppEventsLogger.persistedevents"
            java.io.File r1 = r1.getFileStreamPath(r2)     // Catch:{ Exception -> 0x0034 }
            r1.delete()     // Catch:{ Exception -> 0x0034 }
        L_0x0034:
            r2 = r3
            goto L_0x0069
        L_0x0036:
            java.lang.NullPointerException r3 = new java.lang.NullPointerException     // Catch:{ FileNotFoundException -> 0x005f, Exception -> 0x0051, all -> 0x003e }
            java.lang.String r5 = "null cannot be cast to non-null type com.facebook.appevents.PersistedEvents"
            r3.<init>(r5)     // Catch:{ FileNotFoundException -> 0x005f, Exception -> 0x0051, all -> 0x003e }
            throw r3     // Catch:{ FileNotFoundException -> 0x005f, Exception -> 0x0051, all -> 0x003e }
        L_0x003e:
            r2 = move-exception
            goto L_0x0043
        L_0x0040:
            r3 = move-exception
            r4 = r2
            r2 = r3
        L_0x0043:
            com.facebook.internal.Utility.closeQuietly(r4)     // Catch:{ all -> 0x0072 }
            java.lang.String r3 = "AppEventsLogger.persistedevents"
            java.io.File r1 = r1.getFileStreamPath(r3)     // Catch:{ Exception -> 0x004f }
            r1.delete()     // Catch:{ Exception -> 0x004f }
        L_0x004f:
            throw r2     // Catch:{ all -> 0x0072 }
        L_0x0050:
            r4 = r2
        L_0x0051:
            com.facebook.internal.Utility.closeQuietly(r4)     // Catch:{ all -> 0x0072 }
            java.lang.String r3 = "AppEventsLogger.persistedevents"
            java.io.File r1 = r1.getFileStreamPath(r3)     // Catch:{ Exception -> 0x0069 }
        L_0x005a:
            r1.delete()     // Catch:{ Exception -> 0x0069 }
            goto L_0x0069
        L_0x005e:
            r4 = r2
        L_0x005f:
            com.facebook.internal.Utility.closeQuietly(r4)     // Catch:{ all -> 0x0072 }
            java.lang.String r3 = "AppEventsLogger.persistedevents"
            java.io.File r1 = r1.getFileStreamPath(r3)     // Catch:{ Exception -> 0x0069 }
            goto L_0x005a
        L_0x0069:
            if (r2 != 0) goto L_0x0070
            com.facebook.appevents.PersistedEvents r2 = new com.facebook.appevents.PersistedEvents     // Catch:{ all -> 0x0072 }
            r2.<init>()     // Catch:{ all -> 0x0072 }
        L_0x0070:
            monitor-exit(r0)
            return r2
        L_0x0072:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.AppEventDiskStore.readAndClearStore():com.facebook.appevents.PersistedEvents");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:7|6|8|9|13|15) */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0026, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0027, code lost:
        com.facebook.internal.Utility.closeQuietly(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002a, code lost:
        throw r6;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x001e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void saveEventsToDisk$facebook_core_release(com.facebook.appevents.PersistedEvents r6) {
        /*
            java.lang.String r0 = "AppEventsLogger.persistedevents"
            android.content.Context r1 = com.facebook.FacebookSdk.getApplicationContext()
            r2 = 0
            java.io.ObjectOutputStream r3 = new java.io.ObjectOutputStream     // Catch:{ all -> 0x001e }
            java.io.BufferedOutputStream r4 = new java.io.BufferedOutputStream     // Catch:{ all -> 0x001e }
            r5 = 0
            java.io.FileOutputStream r5 = r1.openFileOutput(r0, r5)     // Catch:{ all -> 0x001e }
            r4.<init>(r5)     // Catch:{ all -> 0x001e }
            r3.<init>(r4)     // Catch:{ all -> 0x001e }
            r3.writeObject(r6)     // Catch:{ all -> 0x001d }
            com.facebook.internal.Utility.closeQuietly(r3)
            goto L_0x002e
        L_0x001d:
            r2 = r3
        L_0x001e:
            java.io.File r6 = r1.getFileStreamPath(r0)     // Catch:{ Exception -> 0x002b, all -> 0x0026 }
            r6.delete()     // Catch:{ Exception -> 0x002b, all -> 0x0026 }
            goto L_0x002b
        L_0x0026:
            r6 = move-exception
            com.facebook.internal.Utility.closeQuietly(r2)
            throw r6
        L_0x002b:
            com.facebook.internal.Utility.closeQuietly(r2)
        L_0x002e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.AppEventDiskStore.saveEventsToDisk$facebook_core_release(com.facebook.appevents.PersistedEvents):void");
    }
}
