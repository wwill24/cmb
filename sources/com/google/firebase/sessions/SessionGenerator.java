package com.google.firebase.sessions;

import java.util.Locale;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import org.apache.commons.cli.HelpFormatter;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\u0006\u0010\u0017\u001a\u00020\rJ\b\u0010\u0018\u001a\u00020\u0012H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r@BX.¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0013\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u000bR\u000e\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/google/firebase/sessions/SessionGenerator;", "", "collectEvents", "", "timeProvider", "Lcom/google/firebase/sessions/TimeProvider;", "uuidGenerator", "Lkotlin/Function0;", "Ljava/util/UUID;", "(ZLcom/google/firebase/sessions/TimeProvider;Lkotlin/jvm/functions/Function0;)V", "getCollectEvents", "()Z", "<set-?>", "Lcom/google/firebase/sessions/SessionDetails;", "currentSession", "getCurrentSession", "()Lcom/google/firebase/sessions/SessionDetails;", "firstSessionId", "", "hasGenerateSession", "getHasGenerateSession", "sessionIndex", "", "generateNewSession", "generateSessionId", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SessionGenerator {
    private final boolean collectEvents;
    private SessionDetails currentSession;
    private final String firstSessionId;
    private int sessionIndex;
    private final TimeProvider timeProvider;
    private final Function0<UUID> uuidGenerator;

    public SessionGenerator(boolean z10, TimeProvider timeProvider2, Function0<UUID> function0) {
        j.g(timeProvider2, "timeProvider");
        j.g(function0, "uuidGenerator");
        this.collectEvents = z10;
        this.timeProvider = timeProvider2;
        this.uuidGenerator = function0;
        this.firstSessionId = generateSessionId();
        this.sessionIndex = -1;
    }

    private final String generateSessionId() {
        String uuid = this.uuidGenerator.invoke().toString();
        j.f(uuid, "uuidGenerator().toString()");
        String lowerCase = r.D(uuid, HelpFormatter.DEFAULT_OPT_PREFIX, "", false, 4, (Object) null).toLowerCase(Locale.ROOT);
        j.f(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        return lowerCase;
    }

    public final SessionDetails generateNewSession() {
        String str;
        int i10 = this.sessionIndex + 1;
        this.sessionIndex = i10;
        if (i10 == 0) {
            str = this.firstSessionId;
        } else {
            str = generateSessionId();
        }
        this.currentSession = new SessionDetails(str, this.firstSessionId, this.sessionIndex, this.timeProvider.currentTimeUs());
        return getCurrentSession();
    }

    public final boolean getCollectEvents() {
        return this.collectEvents;
    }

    public final SessionDetails getCurrentSession() {
        SessionDetails sessionDetails = this.currentSession;
        if (sessionDetails != null) {
            return sessionDetails;
        }
        j.y("currentSession");
        return null;
    }

    public final boolean getHasGenerateSession() {
        return this.currentSession != null;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SessionGenerator(boolean z10, TimeProvider timeProvider2, Function0 function0, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(z10, timeProvider2, (i10 & 4) != 0 ? AnonymousClass1.INSTANCE : function0);
    }
}
