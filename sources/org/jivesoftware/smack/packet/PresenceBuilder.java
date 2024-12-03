package org.jivesoftware.smack.packet;

import org.jivesoftware.smack.packet.Presence;
import org.jivesoftware.smack.packet.id.StanzaIdSource;
import org.jivesoftware.smack.util.Objects;
import org.jivesoftware.smack.util.ToStringUtil;
import org.jivesoftware.smackx.jingle.transports.jingle_s5b.elements.JingleS5BTransport;
import org.jivesoftware.smackx.jingle.transports.jingle_s5b.elements.JingleS5BTransportCandidate;

public final class PresenceBuilder extends MessageOrPresenceBuilder<Presence, PresenceBuilder> implements PresenceView {
    static final PresenceBuilder EMPTY = new PresenceBuilder((StanzaIdSource) new g());
    Presence.Mode mode;
    Byte priority;
    String status;
    Presence.Type type = Presence.Type.available;

    PresenceBuilder(Presence presence, String str) {
        super((Stanza) presence, str);
        copyFromPresence(presence);
    }

    private void copyFromPresence(Presence presence) {
        this.type = presence.getType();
        this.status = presence.getStatus();
        this.priority = Byte.valueOf(presence.getPriorityByte());
        this.mode = presence.getMode();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ String lambda$static$0() {
        return null;
    }

    /* access modifiers changed from: protected */
    public void addStanzaSpecificAttributes(ToStringUtil.Builder builder) {
        builder.addValue("type", this.type).addValue(JingleS5BTransport.ATTR_MODE, this.mode).addValue(JingleS5BTransportCandidate.ATTR_PRIORITY, this.priority).addValue("status", this.status);
    }

    public Presence.Mode getMode() {
        Presence.Mode mode2 = this.mode;
        if (mode2 == null) {
            return Presence.Mode.available;
        }
        return mode2;
    }

    public int getPriority() {
        return getPriorityByte();
    }

    public byte getPriorityByte() {
        Byte b10 = this.priority;
        if (b10 == null) {
            return 0;
        }
        return b10.byteValue();
    }

    public String getStatus() {
        return this.status;
    }

    public PresenceBuilder getThis() {
        return this;
    }

    public Presence.Type getType() {
        return this.type;
    }

    public PresenceBuilder ofType(Presence.Type type2) {
        this.type = (Presence.Type) Objects.requireNonNull(type2, "Type cannot be null");
        return getThis();
    }

    public PresenceBuilder setMode(Presence.Mode mode2) {
        this.mode = mode2;
        return getThis();
    }

    public PresenceBuilder setPriority(int i10) {
        if (i10 >= -128 && i10 <= 127) {
            return setPriority(Byte.valueOf((byte) i10));
        }
        throw new IllegalArgumentException("Priority value " + i10 + " is not valid. Valid range is -128 through 127.");
    }

    public PresenceBuilder setStatus(String str) {
        this.status = str;
        return getThis();
    }

    public Presence build() {
        return new Presence(this);
    }

    PresenceBuilder(Presence presence, StanzaIdSource stanzaIdSource) {
        super((Stanza) presence, stanzaIdSource);
        copyFromPresence(presence);
    }

    public PresenceBuilder setPriority(Byte b10) {
        this.priority = b10;
        return getThis();
    }

    PresenceBuilder(StanzaIdSource stanzaIdSource) {
        super(stanzaIdSource);
    }

    PresenceBuilder(String str) {
        super(str);
    }
}
