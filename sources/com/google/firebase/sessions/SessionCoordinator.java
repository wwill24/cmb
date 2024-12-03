package com.google.firebase.sessions;

import com.google.firebase.installations.FirebaseInstallationsApi;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0017\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\u001b\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"}, d2 = {"Lcom/google/firebase/sessions/SessionCoordinator;", "", "Lcom/google/firebase/sessions/SessionEvent;", "sessionEvent", "", "attemptLoggingSessionEvent", "(Lcom/google/firebase/sessions/SessionEvent;Lkotlin/coroutines/c;)Ljava/lang/Object;", "Lcom/google/firebase/installations/FirebaseInstallationsApi;", "firebaseInstallations", "Lcom/google/firebase/installations/FirebaseInstallationsApi;", "Lcom/google/firebase/sessions/EventGDTLoggerInterface;", "eventGDTLogger", "Lcom/google/firebase/sessions/EventGDTLoggerInterface;", "<init>", "(Lcom/google/firebase/installations/FirebaseInstallationsApi;Lcom/google/firebase/sessions/EventGDTLoggerInterface;)V", "Companion", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 7, 1})
public final class SessionCoordinator {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String TAG = "SessionCoordinator";
    private final EventGDTLoggerInterface eventGDTLogger;
    private final FirebaseInstallationsApi firebaseInstallations;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/google/firebase/sessions/SessionCoordinator$Companion;", "", "()V", "TAG", "", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public SessionCoordinator(FirebaseInstallationsApi firebaseInstallationsApi, EventGDTLoggerInterface eventGDTLoggerInterface) {
        j.g(firebaseInstallationsApi, "firebaseInstallations");
        j.g(eventGDTLoggerInterface, "eventGDTLogger");
        this.firebaseInstallations = firebaseInstallationsApi;
        this.eventGDTLogger = eventGDTLoggerInterface;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object attemptLoggingSessionEvent(com.google.firebase.sessions.SessionEvent r6, kotlin.coroutines.c<? super kotlin.Unit> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.google.firebase.sessions.SessionCoordinator$attemptLoggingSessionEvent$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            com.google.firebase.sessions.SessionCoordinator$attemptLoggingSessionEvent$1 r0 = (com.google.firebase.sessions.SessionCoordinator$attemptLoggingSessionEvent$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.google.firebase.sessions.SessionCoordinator$attemptLoggingSessionEvent$1 r0 = new com.google.firebase.sessions.SessionCoordinator$attemptLoggingSessionEvent$1
            r0.<init>(r5, r7)
        L_0x0018:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.b.d()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0043
            if (r2 != r3) goto L_0x003b
            java.lang.Object r6 = r0.L$3
            com.google.firebase.sessions.SessionInfo r6 = (com.google.firebase.sessions.SessionInfo) r6
            java.lang.Object r1 = r0.L$2
            com.google.firebase.sessions.SessionInfo r1 = (com.google.firebase.sessions.SessionInfo) r1
            java.lang.Object r2 = r0.L$1
            com.google.firebase.sessions.SessionEvent r2 = (com.google.firebase.sessions.SessionEvent) r2
            java.lang.Object r0 = r0.L$0
            com.google.firebase.sessions.SessionCoordinator r0 = (com.google.firebase.sessions.SessionCoordinator) r0
            gk.g.b(r7)     // Catch:{ Exception -> 0x0039 }
            goto L_0x006b
        L_0x0039:
            r6 = move-exception
            goto L_0x0078
        L_0x003b:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0043:
            gk.g.b(r7)
            com.google.firebase.sessions.SessionInfo r7 = r6.getSessionData()
            com.google.firebase.installations.FirebaseInstallationsApi r2 = r5.firebaseInstallations     // Catch:{ Exception -> 0x0073 }
            com.google.android.gms.tasks.Task r2 = r2.getId()     // Catch:{ Exception -> 0x0073 }
            java.lang.String r4 = "firebaseInstallations.id"
            kotlin.jvm.internal.j.f(r2, r4)     // Catch:{ Exception -> 0x0073 }
            r0.L$0 = r5     // Catch:{ Exception -> 0x0073 }
            r0.L$1 = r6     // Catch:{ Exception -> 0x0073 }
            r0.L$2 = r7     // Catch:{ Exception -> 0x0073 }
            r0.L$3 = r7     // Catch:{ Exception -> 0x0073 }
            r0.label = r3     // Catch:{ Exception -> 0x0073 }
            java.lang.Object r0 = kotlinx.coroutines.tasks.TasksKt.a(r2, r0)     // Catch:{ Exception -> 0x0073 }
            if (r0 != r1) goto L_0x0066
            return r1
        L_0x0066:
            r2 = r6
            r6 = r7
            r1 = r6
            r7 = r0
            r0 = r5
        L_0x006b:
            java.lang.String r3 = "{\n        firebaseInstallations.id.await()\n      }"
            kotlin.jvm.internal.j.f(r7, r3)     // Catch:{ Exception -> 0x0039 }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ Exception -> 0x0039 }
            goto L_0x008d
        L_0x0073:
            r0 = move-exception
            r2 = r6
            r1 = r7
            r6 = r0
            r0 = r5
        L_0x0078:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r3 = "Error getting Firebase Installation ID: "
            r7.append(r3)
            r7.append(r6)
            java.lang.String r6 = ". Using an empty ID"
            r7.append(r6)
            java.lang.String r7 = ""
            r6 = r1
        L_0x008d:
            r6.setFirebaseInstallationId(r7)
            com.google.firebase.sessions.EventGDTLoggerInterface r6 = r0.eventGDTLogger     // Catch:{ RuntimeException -> 0x00aa }
            r6.log(r2)     // Catch:{ RuntimeException -> 0x00aa }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ RuntimeException -> 0x00aa }
            r6.<init>()     // Catch:{ RuntimeException -> 0x00aa }
            java.lang.String r7 = "Successfully logged Session Start event: "
            r6.append(r7)     // Catch:{ RuntimeException -> 0x00aa }
            com.google.firebase.sessions.SessionInfo r7 = r2.getSessionData()     // Catch:{ RuntimeException -> 0x00aa }
            java.lang.String r7 = r7.getSessionId()     // Catch:{ RuntimeException -> 0x00aa }
            r6.append(r7)     // Catch:{ RuntimeException -> 0x00aa }
        L_0x00aa:
            kotlin.Unit r6 = kotlin.Unit.f32013a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.sessions.SessionCoordinator.attemptLoggingSessionEvent(com.google.firebase.sessions.SessionEvent, kotlin.coroutines.c):java.lang.Object");
    }
}
