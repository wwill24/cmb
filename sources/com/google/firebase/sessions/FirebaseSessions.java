package com.google.firebase.sessions;

import android.app.Application;
import android.content.Context;
import cd.f;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.inject.Provider;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.ktx.Firebase;
import com.google.firebase.ktx.FirebaseKt;
import com.google.firebase.sessions.api.FirebaseSessionsDependencies;
import com.google.firebase.sessions.api.SessionSubscriber;
import com.google.firebase.sessions.settings.SessionsSettings;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.CoroutineDispatcher;

@Metadata(bv = {}, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 +2\u00020\u0001:\u0001+B7\b\u0000\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\"\u001a\u00020!\u0012\u0006\u0010$\u001a\u00020#\u0012\u0006\u0010%\u001a\u00020#\u0012\f\u0010(\u001a\b\u0012\u0004\u0012\u00020'0&¢\u0006\u0004\b)\u0010*J\u001b\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\b\u001a\u00020\u0007H\u0002J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0016\u001a\u00020\u00158\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0019\u001a\u00020\u00188\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001c\u001a\u00020\u001b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001f\u001a\u00020\u001e8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 \u0002\u0004\n\u0002\b\u0019¨\u0006,"}, d2 = {"Lcom/google/firebase/sessions/FirebaseSessions;", "", "Lcom/google/firebase/sessions/SessionDetails;", "sessionDetails", "", "initiateSessionStart", "(Lcom/google/firebase/sessions/SessionDetails;Lkotlin/coroutines/c;)Ljava/lang/Object;", "", "shouldCollectEvents", "Lcom/google/firebase/sessions/api/SessionSubscriber;", "subscriber", "register", "Lcom/google/firebase/FirebaseApp;", "firebaseApp", "Lcom/google/firebase/FirebaseApp;", "Lcom/google/firebase/sessions/ApplicationInfo;", "applicationInfo", "Lcom/google/firebase/sessions/ApplicationInfo;", "Lcom/google/firebase/sessions/settings/SessionsSettings;", "sessionSettings", "Lcom/google/firebase/sessions/settings/SessionsSettings;", "Lcom/google/firebase/sessions/TimeProvider;", "timeProvider", "Lcom/google/firebase/sessions/TimeProvider;", "Lcom/google/firebase/sessions/SessionGenerator;", "sessionGenerator", "Lcom/google/firebase/sessions/SessionGenerator;", "Lcom/google/firebase/sessions/EventGDTLogger;", "eventGDTLogger", "Lcom/google/firebase/sessions/EventGDTLogger;", "Lcom/google/firebase/sessions/SessionCoordinator;", "sessionCoordinator", "Lcom/google/firebase/sessions/SessionCoordinator;", "Lcom/google/firebase/installations/FirebaseInstallationsApi;", "firebaseInstallations", "Lkotlinx/coroutines/CoroutineDispatcher;", "backgroundDispatcher", "blockingDispatcher", "Lcom/google/firebase/inject/Provider;", "Lcd/f;", "transportFactoryProvider", "<init>", "(Lcom/google/firebase/FirebaseApp;Lcom/google/firebase/installations/FirebaseInstallationsApi;Lkotlinx/coroutines/CoroutineDispatcher;Lkotlinx/coroutines/CoroutineDispatcher;Lcom/google/firebase/inject/Provider;)V", "Companion", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 7, 1})
public final class FirebaseSessions {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String TAG = "FirebaseSessions";
    private final ApplicationInfo applicationInfo;
    private final EventGDTLogger eventGDTLogger;
    private final FirebaseApp firebaseApp;
    private final SessionCoordinator sessionCoordinator;
    private final SessionGenerator sessionGenerator;
    private final SessionsSettings sessionSettings;
    private final TimeProvider timeProvider;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u00068FX\u0004¢\u0006\f\u0012\u0004\b\u0007\u0010\u0002\u001a\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/google/firebase/sessions/FirebaseSessions$Companion;", "", "()V", "TAG", "", "instance", "Lcom/google/firebase/sessions/FirebaseSessions;", "getInstance$annotations", "getInstance", "()Lcom/google/firebase/sessions/FirebaseSessions;", "app", "Lcom/google/firebase/FirebaseApp;", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void getInstance$annotations() {
        }

        public final FirebaseSessions getInstance() {
            return getInstance(FirebaseKt.getApp(Firebase.INSTANCE));
        }

        public final FirebaseSessions getInstance(FirebaseApp firebaseApp) {
            j.g(firebaseApp, "app");
            Object obj = firebaseApp.get(FirebaseSessions.class);
            j.f(obj, "app.get(FirebaseSessions::class.java)");
            return (FirebaseSessions) obj;
        }
    }

    public FirebaseSessions(FirebaseApp firebaseApp2, FirebaseInstallationsApi firebaseInstallationsApi, CoroutineDispatcher coroutineDispatcher, CoroutineDispatcher coroutineDispatcher2, Provider<f> provider) {
        FirebaseApp firebaseApp3 = firebaseApp2;
        FirebaseInstallationsApi firebaseInstallationsApi2 = firebaseInstallationsApi;
        Provider<f> provider2 = provider;
        j.g(firebaseApp3, "firebaseApp");
        j.g(firebaseInstallationsApi2, "firebaseInstallations");
        j.g(coroutineDispatcher, "backgroundDispatcher");
        CoroutineDispatcher coroutineDispatcher3 = coroutineDispatcher2;
        j.g(coroutineDispatcher3, "blockingDispatcher");
        j.g(provider2, "transportFactoryProvider");
        this.firebaseApp = firebaseApp3;
        ApplicationInfo applicationInfo2 = SessionEvents.INSTANCE.getApplicationInfo(firebaseApp3);
        this.applicationInfo = applicationInfo2;
        Context applicationContext = firebaseApp2.getApplicationContext();
        j.f(applicationContext, "firebaseApp.applicationContext");
        CoroutineDispatcher coroutineDispatcher4 = coroutineDispatcher;
        SessionsSettings sessionsSettings = new SessionsSettings(applicationContext, coroutineDispatcher3, coroutineDispatcher4, firebaseInstallationsApi, applicationInfo2);
        this.sessionSettings = sessionsSettings;
        Time time = new Time();
        this.timeProvider = time;
        EventGDTLogger eventGDTLogger2 = new EventGDTLogger(provider2);
        this.eventGDTLogger = eventGDTLogger2;
        this.sessionCoordinator = new SessionCoordinator(firebaseInstallationsApi2, eventGDTLogger2);
        SessionGenerator sessionGenerator2 = new SessionGenerator(shouldCollectEvents(), time, (Function0) null, 4, (DefaultConstructorMarker) null);
        this.sessionGenerator = sessionGenerator2;
        SessionInitiator sessionInitiator = new SessionInitiator(time, coroutineDispatcher4, new FirebaseSessions$sessionInitiateListener$1(this), sessionsSettings, sessionGenerator2);
        Context applicationContext2 = firebaseApp2.getApplicationContext().getApplicationContext();
        if (applicationContext2 instanceof Application) {
            ((Application) applicationContext2).registerActivityLifecycleCallbacks(sessionInitiator.getActivityLifecycleCallbacks$com_google_firebase_firebase_sessions());
            firebaseApp3.addLifecycleEventListener(new b(applicationContext2, sessionInitiator));
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Failed to register lifecycle callbacks, unexpected context ");
        sb2.append(applicationContext2.getClass());
        sb2.append('.');
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-0  reason: not valid java name */
    public static final void m3_init_$lambda0(Context context, SessionInitiator sessionInitiator, String str, FirebaseOptions firebaseOptions) {
        j.g(sessionInitiator, "$sessionInitiator");
        ((Application) context).unregisterActivityLifecycleCallbacks(sessionInitiator.getActivityLifecycleCallbacks$com_google_firebase_firebase_sessions());
    }

    public static final FirebaseSessions getInstance() {
        return Companion.getInstance();
    }

    public static final FirebaseSessions getInstance(FirebaseApp firebaseApp2) {
        return Companion.getInstance(firebaseApp2);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00db  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00de  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object initiateSessionStart(com.google.firebase.sessions.SessionDetails r11, kotlin.coroutines.c<? super kotlin.Unit> r12) {
        /*
            r10 = this;
            boolean r0 = r12 instanceof com.google.firebase.sessions.FirebaseSessions$initiateSessionStart$1
            if (r0 == 0) goto L_0x0013
            r0 = r12
            com.google.firebase.sessions.FirebaseSessions$initiateSessionStart$1 r0 = (com.google.firebase.sessions.FirebaseSessions$initiateSessionStart$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.google.firebase.sessions.FirebaseSessions$initiateSessionStart$1 r0 = new com.google.firebase.sessions.FirebaseSessions$initiateSessionStart$1
            r0.<init>(r10, r12)
        L_0x0018:
            java.lang.Object r12 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.b.d()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x0055
            if (r2 == r5) goto L_0x0049
            if (r2 == r4) goto L_0x0038
            if (r2 != r3) goto L_0x0030
            gk.g.b(r12)     // Catch:{ IllegalStateException -> 0x0105 }
            goto L_0x0105
        L_0x0030:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x0038:
            java.lang.Object r11 = r0.L$2
            java.util.Map r11 = (java.util.Map) r11
            java.lang.Object r2 = r0.L$1
            com.google.firebase.sessions.SessionDetails r2 = (com.google.firebase.sessions.SessionDetails) r2
            java.lang.Object r4 = r0.L$0
            com.google.firebase.sessions.FirebaseSessions r4 = (com.google.firebase.sessions.FirebaseSessions) r4
            gk.g.b(r12)
            goto L_0x00d3
        L_0x0049:
            java.lang.Object r11 = r0.L$1
            com.google.firebase.sessions.SessionDetails r11 = (com.google.firebase.sessions.SessionDetails) r11
            java.lang.Object r2 = r0.L$0
            com.google.firebase.sessions.FirebaseSessions r2 = (com.google.firebase.sessions.FirebaseSessions) r2
            gk.g.b(r12)
            goto L_0x0068
        L_0x0055:
            gk.g.b(r12)
            com.google.firebase.sessions.api.FirebaseSessionsDependencies r12 = com.google.firebase.sessions.api.FirebaseSessionsDependencies.INSTANCE
            r0.L$0 = r10
            r0.L$1 = r11
            r0.label = r5
            java.lang.Object r12 = r12.getRegisteredSubscribers$com_google_firebase_firebase_sessions(r0)
            if (r12 != r1) goto L_0x0067
            return r1
        L_0x0067:
            r2 = r10
        L_0x0068:
            java.util.Map r12 = (java.util.Map) r12
            boolean r6 = r12.isEmpty()
            if (r6 == 0) goto L_0x0073
            kotlin.Unit r11 = kotlin.Unit.f32013a
            return r11
        L_0x0073:
            java.util.Collection r6 = r12.values()
            java.util.Iterator r6 = r6.iterator()
        L_0x007b:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x0094
            java.lang.Object r7 = r6.next()
            com.google.firebase.sessions.api.SessionSubscriber r7 = (com.google.firebase.sessions.api.SessionSubscriber) r7
            com.google.firebase.sessions.api.SessionSubscriber$SessionDetails r8 = new com.google.firebase.sessions.api.SessionSubscriber$SessionDetails
            java.lang.String r9 = r11.getSessionId()
            r8.<init>(r9)
            r7.onSessionChanged(r8)
            goto L_0x007b
        L_0x0094:
            java.util.Collection r6 = r12.values()
            boolean r7 = r6 instanceof java.util.Collection
            if (r7 == 0) goto L_0x00a3
            boolean r7 = r6.isEmpty()
            if (r7 == 0) goto L_0x00a3
            goto L_0x00ba
        L_0x00a3:
            java.util.Iterator r6 = r6.iterator()
        L_0x00a7:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x00ba
            java.lang.Object r7 = r6.next()
            com.google.firebase.sessions.api.SessionSubscriber r7 = (com.google.firebase.sessions.api.SessionSubscriber) r7
            boolean r7 = r7.isDataCollectionEnabled()
            if (r7 == 0) goto L_0x00a7
            r5 = 0
        L_0x00ba:
            if (r5 == 0) goto L_0x00bf
            kotlin.Unit r11 = kotlin.Unit.f32013a
            return r11
        L_0x00bf:
            com.google.firebase.sessions.settings.SessionsSettings r5 = r2.sessionSettings
            r0.L$0 = r2
            r0.L$1 = r11
            r0.L$2 = r12
            r0.label = r4
            java.lang.Object r4 = r5.updateSettings(r0)
            if (r4 != r1) goto L_0x00d0
            return r1
        L_0x00d0:
            r4 = r2
            r2 = r11
            r11 = r12
        L_0x00d3:
            com.google.firebase.sessions.settings.SessionsSettings r12 = r4.sessionSettings
            boolean r12 = r12.getSessionsEnabled()
            if (r12 != 0) goto L_0x00de
            kotlin.Unit r11 = kotlin.Unit.f32013a
            return r11
        L_0x00de:
            com.google.firebase.sessions.SessionGenerator r12 = r4.sessionGenerator
            boolean r12 = r12.getCollectEvents()
            if (r12 != 0) goto L_0x00e9
            kotlin.Unit r11 = kotlin.Unit.f32013a
            return r11
        L_0x00e9:
            com.google.firebase.sessions.SessionEvents r12 = com.google.firebase.sessions.SessionEvents.INSTANCE     // Catch:{ IllegalStateException -> 0x0105 }
            com.google.firebase.FirebaseApp r5 = r4.firebaseApp     // Catch:{ IllegalStateException -> 0x0105 }
            com.google.firebase.sessions.settings.SessionsSettings r6 = r4.sessionSettings     // Catch:{ IllegalStateException -> 0x0105 }
            com.google.firebase.sessions.SessionEvent r11 = r12.startSession(r5, r2, r6, r11)     // Catch:{ IllegalStateException -> 0x0105 }
            com.google.firebase.sessions.SessionCoordinator r12 = r4.sessionCoordinator     // Catch:{ IllegalStateException -> 0x0105 }
            r2 = 0
            r0.L$0 = r2     // Catch:{ IllegalStateException -> 0x0105 }
            r0.L$1 = r2     // Catch:{ IllegalStateException -> 0x0105 }
            r0.L$2 = r2     // Catch:{ IllegalStateException -> 0x0105 }
            r0.label = r3     // Catch:{ IllegalStateException -> 0x0105 }
            java.lang.Object r11 = r12.attemptLoggingSessionEvent(r11, r0)     // Catch:{ IllegalStateException -> 0x0105 }
            if (r11 != r1) goto L_0x0105
            return r1
        L_0x0105:
            kotlin.Unit r11 = kotlin.Unit.f32013a
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.sessions.FirebaseSessions.initiateSessionStart(com.google.firebase.sessions.SessionDetails, kotlin.coroutines.c):java.lang.Object");
    }

    private final boolean shouldCollectEvents() {
        if (Math.random() <= this.sessionSettings.getSamplingRate()) {
            return true;
        }
        return false;
    }

    public final void register(SessionSubscriber sessionSubscriber) {
        j.g(sessionSubscriber, "subscriber");
        FirebaseSessionsDependencies.INSTANCE.register$com_google_firebase_firebase_sessions(sessionSubscriber);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Registering Sessions SDK subscriber with name: ");
        sb2.append(sessionSubscriber.getSessionSubscriberName());
        sb2.append(", data collection enabled: ");
        sb2.append(sessionSubscriber.isDataCollectionEnabled());
        if (this.sessionGenerator.getHasGenerateSession()) {
            sessionSubscriber.onSessionChanged(new SessionSubscriber.SessionDetails(this.sessionGenerator.getCurrentSession().getSessionId()));
        }
    }
}
