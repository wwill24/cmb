package org.jivesoftware.smack.filter;

import org.jivesoftware.smack.packet.Presence;
import org.jivesoftware.smack.util.Objects;

public final class PresenceTypeFilter extends FlexibleStanzaTypeFilter<Presence> {
    public static final PresenceTypeFilter AVAILABLE;
    public static final PresenceTypeFilter ERROR = new PresenceTypeFilter(Presence.Type.error);
    public static final StanzaFilter OUTGOING_PRESENCE_BROADCAST;
    public static final PresenceTypeFilter PROBE = new PresenceTypeFilter(Presence.Type.probe);
    public static final PresenceTypeFilter SUBSCRIBE = new PresenceTypeFilter(Presence.Type.subscribe);
    public static final PresenceTypeFilter SUBSCRIBED = new PresenceTypeFilter(Presence.Type.subscribed);
    public static final PresenceTypeFilter UNAVAILABLE = new PresenceTypeFilter(Presence.Type.unavailable);
    public static final PresenceTypeFilter UNSUBSCRIBE = new PresenceTypeFilter(Presence.Type.unsubscribe);
    public static final PresenceTypeFilter UNSUBSCRIBED = new PresenceTypeFilter(Presence.Type.unsubscribed);
    private final Presence.Type type;

    static {
        PresenceTypeFilter presenceTypeFilter = new PresenceTypeFilter(Presence.Type.available);
        AVAILABLE = presenceTypeFilter;
        OUTGOING_PRESENCE_BROADCAST = new AndFilter(presenceTypeFilter, EmptyToMatcher.INSTANCE);
    }

    private PresenceTypeFilter(Presence.Type type2) {
        super(Presence.class);
        this.type = (Presence.Type) Objects.requireNonNull(type2, "type must not be null");
    }

    public String toString() {
        return PresenceTypeFilter.class.getSimpleName() + ": type=" + this.type;
    }

    /* access modifiers changed from: protected */
    public boolean acceptSpecific(Presence presence) {
        return presence.getType() == this.type;
    }
}
