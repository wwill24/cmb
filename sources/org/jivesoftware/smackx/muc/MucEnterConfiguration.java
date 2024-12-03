package org.jivesoftware.smackx.muc;

import java.util.Date;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.packet.Presence;
import org.jivesoftware.smack.packet.PresenceBuilder;
import org.jivesoftware.smack.util.Consumer;
import org.jivesoftware.smack.util.Objects;
import org.jivesoftware.smackx.muc.packet.MUCInitialPresence;
import org.jxmpp.jid.impl.a;
import org.jxmpp.jid.parts.Resourcepart;

public final class MucEnterConfiguration {
    private final Presence joinPresence;
    private final int maxChars;
    private final int maxStanzas;
    private final Resourcepart nickname;
    private final String password;
    private final int seconds;
    private final Date since;
    private final long timeout;

    public static final class Builder {
        /* access modifiers changed from: private */
        public Presence joinPresence;
        /* access modifiers changed from: private */
        public final PresenceBuilder joinPresenceBuilder;
        /* access modifiers changed from: private */
        public int maxChars = -1;
        /* access modifiers changed from: private */
        public int maxStanzas = -1;
        /* access modifiers changed from: private */
        public final Resourcepart nickname;
        /* access modifiers changed from: private */
        public String password;
        /* access modifiers changed from: private */
        public int seconds = -1;
        /* access modifiers changed from: private */
        public Date since;
        /* access modifiers changed from: private */
        public long timeout;

        Builder(Resourcepart resourcepart, XMPPConnection xMPPConnection) {
            this.nickname = (Resourcepart) Objects.requireNonNull(resourcepart, "Nickname must not be null");
            long replyTimeout = xMPPConnection.getReplyTimeout();
            this.timeout = replyTimeout;
            timeoutAfter(replyTimeout);
            this.joinPresenceBuilder = xMPPConnection.getStanzaFactory().buildPresenceStanza();
        }

        public MucEnterConfiguration build() {
            return new MucEnterConfiguration(this);
        }

        public Builder requestHistorySince(int i10) {
            this.seconds = i10;
            return this;
        }

        public Builder requestMaxCharsHistory(int i10) {
            this.maxChars = i10;
            return this;
        }

        public Builder requestMaxStanzasHistory(int i10) {
            this.maxStanzas = i10;
            return this;
        }

        public Builder requestNoHistory() {
            this.maxChars = 0;
            this.maxStanzas = -1;
            this.seconds = -1;
            this.since = null;
            return this;
        }

        public Builder timeoutAfter(long j10) {
            if (j10 > 0) {
                this.timeout = j10;
                return this;
            }
            throw new IllegalArgumentException("timeout must be positive");
        }

        public Builder withPassword(String str) {
            this.password = str;
            return this;
        }

        @Deprecated
        public Builder withPresence(Presence presence) {
            if (presence.getType() == Presence.Type.available) {
                this.joinPresence = presence;
                return this;
            }
            throw new IllegalArgumentException("Presence must be of type 'available'");
        }

        public Builder requestHistorySince(Date date) {
            this.since = date;
            return this;
        }

        public Builder withPresence(Consumer<? super PresenceBuilder> consumer) {
            consumer.accept(this.joinPresenceBuilder);
            if (this.joinPresenceBuilder.getType() == Presence.Type.available) {
                return this;
            }
            throw new IllegalArgumentException("Presence must be of type 'available'");
        }
    }

    MucEnterConfiguration(Builder builder) {
        PresenceBuilder presenceBuilder;
        this.nickname = builder.nickname;
        String access$100 = builder.password;
        this.password = access$100;
        int access$200 = builder.maxChars;
        this.maxChars = access$200;
        int access$300 = builder.maxStanzas;
        this.maxStanzas = access$300;
        int access$400 = builder.seconds;
        this.seconds = access$400;
        Date access$500 = builder.since;
        this.since = access$500;
        this.timeout = builder.timeout;
        if (builder.joinPresence == null) {
            presenceBuilder = builder.joinPresenceBuilder.ofType(Presence.Type.available);
        } else {
            presenceBuilder = builder.joinPresence.asBuilder();
        }
        presenceBuilder.addExtension(new MUCInitialPresence(access$100, access$200, access$300, access$400, access$500));
        this.joinPresence = presenceBuilder.build();
    }

    /* access modifiers changed from: package-private */
    public Presence getJoinPresence(MultiUserChat multiUserChat) {
        this.joinPresence.setTo(a.m(multiUserChat.getRoom(), this.nickname));
        return this.joinPresence;
    }

    /* access modifiers changed from: package-private */
    public long getTimeout() {
        return this.timeout;
    }
}
