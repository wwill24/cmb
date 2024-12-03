package com.facebook.appevents.internal;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.facebook.FacebookSdk;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 &2\u00020\u0001:\u0001&B%\b\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0006\u0010#\u001a\u00020$J\u0006\u0010%\u001a\u00020$R \u0010\b\u001a\u0004\u0018\u00010\u00038FX\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000f@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\u0017\u0010\n\"\u0004\b\u0018\u0010\fR\u0011\u0010\u0019\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u001c\u0010\nR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u0006'"}, d2 = {"Lcom/facebook/appevents/internal/SessionInfo;", "", "sessionStartTime", "", "sessionLastEventTime", "sessionId", "Ljava/util/UUID;", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/util/UUID;)V", "diskRestoreTime", "getDiskRestoreTime", "()Ljava/lang/Long;", "setDiskRestoreTime", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "<set-?>", "", "interruptionCount", "getInterruptionCount", "()I", "getSessionId", "()Ljava/util/UUID;", "setSessionId", "(Ljava/util/UUID;)V", "getSessionLastEventTime", "setSessionLastEventTime", "sessionLength", "getSessionLength", "()J", "getSessionStartTime", "sourceApplicationInfo", "Lcom/facebook/appevents/internal/SourceApplicationInfo;", "getSourceApplicationInfo", "()Lcom/facebook/appevents/internal/SourceApplicationInfo;", "setSourceApplicationInfo", "(Lcom/facebook/appevents/internal/SourceApplicationInfo;)V", "incrementInterruptionCount", "", "writeSessionToDisk", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class SessionInfo {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String INTERRUPTION_COUNT_KEY = "com.facebook.appevents.SessionInfo.interruptionCount";
    private static final String LAST_SESSION_INFO_END_KEY = "com.facebook.appevents.SessionInfo.sessionEndTime";
    private static final String LAST_SESSION_INFO_START_KEY = "com.facebook.appevents.SessionInfo.sessionStartTime";
    private static final String SESSION_ID_KEY = "com.facebook.appevents.SessionInfo.sessionId";
    private Long diskRestoreTime;
    /* access modifiers changed from: private */
    public int interruptionCount;
    private UUID sessionId;
    private Long sessionLastEventTime;
    private final Long sessionStartTime;
    private SourceApplicationInfo sourceApplicationInfo;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\b\u001a\u00020\tH\u0007J\n\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/facebook/appevents/internal/SessionInfo$Companion;", "", "()V", "INTERRUPTION_COUNT_KEY", "", "LAST_SESSION_INFO_END_KEY", "LAST_SESSION_INFO_START_KEY", "SESSION_ID_KEY", "clearSavedSessionFromDisk", "", "getStoredSessionInfo", "Lcom/facebook/appevents/internal/SessionInfo;", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void clearSavedSessionFromDisk() {
            SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(FacebookSdk.getApplicationContext()).edit();
            edit.remove(SessionInfo.LAST_SESSION_INFO_START_KEY);
            edit.remove(SessionInfo.LAST_SESSION_INFO_END_KEY);
            edit.remove(SessionInfo.INTERRUPTION_COUNT_KEY);
            edit.remove(SessionInfo.SESSION_ID_KEY);
            edit.apply();
            SourceApplicationInfo.Companion.clearSavedSourceApplicationInfoFromDisk();
        }

        public final SessionInfo getStoredSessionInfo() {
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(FacebookSdk.getApplicationContext());
            long j10 = defaultSharedPreferences.getLong(SessionInfo.LAST_SESSION_INFO_START_KEY, 0);
            long j11 = defaultSharedPreferences.getLong(SessionInfo.LAST_SESSION_INFO_END_KEY, 0);
            String string = defaultSharedPreferences.getString(SessionInfo.SESSION_ID_KEY, (String) null);
            if (j10 == 0 || j11 == 0 || string == null) {
                return null;
            }
            SessionInfo sessionInfo = new SessionInfo(Long.valueOf(j10), Long.valueOf(j11), (UUID) null, 4, (DefaultConstructorMarker) null);
            sessionInfo.interruptionCount = defaultSharedPreferences.getInt(SessionInfo.INTERRUPTION_COUNT_KEY, 0);
            sessionInfo.setSourceApplicationInfo(SourceApplicationInfo.Companion.getStoredSourceApplicatioInfo());
            sessionInfo.setDiskRestoreTime(Long.valueOf(System.currentTimeMillis()));
            UUID fromString = UUID.fromString(string);
            j.f(fromString, "fromString(sessionIDStr)");
            sessionInfo.setSessionId(fromString);
            return sessionInfo;
        }
    }

    public SessionInfo(Long l10, Long l11) {
        this(l10, l11, (UUID) null, 4, (DefaultConstructorMarker) null);
    }

    public SessionInfo(Long l10, Long l11, UUID uuid) {
        j.g(uuid, "sessionId");
        this.sessionStartTime = l10;
        this.sessionLastEventTime = l11;
        this.sessionId = uuid;
    }

    public static final void clearSavedSessionFromDisk() {
        Companion.clearSavedSessionFromDisk();
    }

    public static final SessionInfo getStoredSessionInfo() {
        return Companion.getStoredSessionInfo();
    }

    public final Long getDiskRestoreTime() {
        Long l10 = this.diskRestoreTime;
        if (l10 == null) {
            return 0L;
        }
        return l10;
    }

    public final int getInterruptionCount() {
        return this.interruptionCount;
    }

    public final UUID getSessionId() {
        return this.sessionId;
    }

    public final Long getSessionLastEventTime() {
        return this.sessionLastEventTime;
    }

    public final long getSessionLength() {
        Long l10;
        if (this.sessionStartTime == null || (l10 = this.sessionLastEventTime) == null) {
            return 0;
        }
        if (l10 != null) {
            return l10.longValue() - this.sessionStartTime.longValue();
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    public final Long getSessionStartTime() {
        return this.sessionStartTime;
    }

    public final SourceApplicationInfo getSourceApplicationInfo() {
        return this.sourceApplicationInfo;
    }

    public final void incrementInterruptionCount() {
        this.interruptionCount++;
    }

    public final void setDiskRestoreTime(Long l10) {
        this.diskRestoreTime = l10;
    }

    public final void setSessionId(UUID uuid) {
        j.g(uuid, "<set-?>");
        this.sessionId = uuid;
    }

    public final void setSessionLastEventTime(Long l10) {
        this.sessionLastEventTime = l10;
    }

    public final void setSourceApplicationInfo(SourceApplicationInfo sourceApplicationInfo2) {
        this.sourceApplicationInfo = sourceApplicationInfo2;
    }

    public final void writeSessionToDisk() {
        long j10;
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(FacebookSdk.getApplicationContext()).edit();
        Long l10 = this.sessionStartTime;
        long j11 = 0;
        if (l10 == null) {
            j10 = 0;
        } else {
            j10 = l10.longValue();
        }
        edit.putLong(LAST_SESSION_INFO_START_KEY, j10);
        Long l11 = this.sessionLastEventTime;
        if (l11 != null) {
            j11 = l11.longValue();
        }
        edit.putLong(LAST_SESSION_INFO_END_KEY, j11);
        edit.putInt(INTERRUPTION_COUNT_KEY, this.interruptionCount);
        edit.putString(SESSION_ID_KEY, this.sessionId.toString());
        edit.apply();
        SourceApplicationInfo sourceApplicationInfo2 = this.sourceApplicationInfo;
        if (sourceApplicationInfo2 != null && sourceApplicationInfo2 != null) {
            sourceApplicationInfo2.writeSourceApplicationInfoToDisk();
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ SessionInfo(java.lang.Long r1, java.lang.Long r2, java.util.UUID r3, int r4, kotlin.jvm.internal.DefaultConstructorMarker r5) {
        /*
            r0 = this;
            r4 = r4 & 4
            if (r4 == 0) goto L_0x000d
            java.util.UUID r3 = java.util.UUID.randomUUID()
            java.lang.String r4 = "randomUUID()"
            kotlin.jvm.internal.j.f(r3, r4)
        L_0x000d:
            r0.<init>(r1, r2, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.internal.SessionInfo.<init>(java.lang.Long, java.lang.Long, java.util.UUID, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
