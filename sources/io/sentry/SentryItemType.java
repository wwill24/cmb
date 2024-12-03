package io.sentry;

import io.sentry.clientreport.b;
import io.sentry.protocol.v;
import java.io.IOException;
import java.util.Locale;
import org.jetbrains.annotations.ApiStatus;
import org.jivesoftware.smack.packet.Session;

@ApiStatus.Internal
public enum SentryItemType implements c1 {
    Session(Session.ELEMENT),
    Event("event"),
    UserFeedback("user_report"),
    Attachment("attachment"),
    Transaction("transaction"),
    Profile("profile"),
    ClientReport("client_report"),
    ReplayEvent("replay_event"),
    ReplayRecording("replay_recording"),
    Unknown("__unknown__");
    
    private final String itemType;

    static final class a implements s0<SentryItemType> {
        a() {
        }

        /* renamed from: b */
        public SentryItemType a(y0 y0Var, h0 h0Var) throws Exception {
            return SentryItemType.valueOfLabel(y0Var.G().toLowerCase(Locale.ROOT));
        }
    }

    private SentryItemType(String str) {
        this.itemType = str;
    }

    public static SentryItemType resolve(Object obj) {
        if (obj instanceof p3) {
            return Event;
        }
        if (obj instanceof v) {
            return Transaction;
        }
        if (obj instanceof Session) {
            return Session;
        }
        if (obj instanceof b) {
            return ClientReport;
        }
        return Attachment;
    }

    public static SentryItemType valueOfLabel(String str) {
        for (SentryItemType sentryItemType : values()) {
            if (sentryItemType.itemType.equals(str)) {
                return sentryItemType;
            }
        }
        return Unknown;
    }

    public String getItemType() {
        return this.itemType;
    }

    public void serialize(a1 a1Var, h0 h0Var) throws IOException {
        a1Var.I(this.itemType);
    }
}
