package org.jivesoftware.smack.packet;

import java.util.Collection;
import java.util.List;
import java.util.Locale;
import org.apache.commons.beanutils.PropertyUtils;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.util.Objects;
import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jivesoftware.smackx.jingle.transports.jingle_s5b.elements.JingleS5BTransportCandidate;
import org.jxmpp.jid.Jid;

public final class Presence extends MessageOrPresence<PresenceBuilder> implements PresenceView {
    public static final String ELEMENT = "presence";
    private Mode mode;
    private Byte priority;
    private String status;
    private Type type;

    public enum Mode {
        chat,
        available,
        away,
        xa,
        dnd;

        public static Mode fromString(String str) {
            return valueOf(str.toLowerCase(Locale.US));
        }
    }

    public enum Type {
        available,
        unavailable,
        subscribe,
        subscribed,
        unsubscribe,
        unsubscribed,
        error,
        probe;

        public static Type fromString(String str) {
            return valueOf(str.toLowerCase(Locale.US));
        }
    }

    @Deprecated
    public Presence(Type type2) {
        this.type = Type.available;
        this.status = null;
        this.mode = null;
        setType(type2);
    }

    @Deprecated
    public Presence cloneWithNewId() {
        Presence clone = clone();
        clone.setNewStanzaId();
        return clone;
    }

    public String getElementName() {
        return ELEMENT;
    }

    public Mode getMode() {
        Mode mode2 = this.mode;
        if (mode2 == null) {
            return Mode.available;
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

    public Type getType() {
        return this.type;
    }

    public boolean isAvailable() {
        return this.type == Type.available;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = r2.mode;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isAway() {
        /*
            r2 = this;
            org.jivesoftware.smack.packet.Presence$Type r0 = r2.type
            org.jivesoftware.smack.packet.Presence$Type r1 = org.jivesoftware.smack.packet.Presence.Type.available
            if (r0 != r1) goto L_0x0016
            org.jivesoftware.smack.packet.Presence$Mode r0 = r2.mode
            org.jivesoftware.smack.packet.Presence$Mode r1 = org.jivesoftware.smack.packet.Presence.Mode.away
            if (r0 == r1) goto L_0x0014
            org.jivesoftware.smack.packet.Presence$Mode r1 = org.jivesoftware.smack.packet.Presence.Mode.xa
            if (r0 == r1) goto L_0x0014
            org.jivesoftware.smack.packet.Presence$Mode r1 = org.jivesoftware.smack.packet.Presence.Mode.dnd
            if (r0 != r1) goto L_0x0016
        L_0x0014:
            r0 = 1
            goto L_0x0017
        L_0x0016:
            r0 = 0
        L_0x0017:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smack.packet.Presence.isAway():boolean");
    }

    @Deprecated
    public void setMode(Mode mode2) {
        this.mode = mode2;
    }

    @Deprecated
    public void setPriority(int i10) {
        if (i10 < -128 || i10 > 127) {
            throw new IllegalArgumentException("Priority value " + i10 + " is not valid. Valid range is -128 through 127.");
        }
        setPriority((byte) i10);
    }

    @Deprecated
    public void setStatus(String str) {
        this.status = str;
    }

    @Deprecated
    public void setType(Type type2) {
        this.type = (Type) Objects.requireNonNull(type2, "Type cannot be null");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Presence Stanza [");
        logCommonAttributes(sb2);
        sb2.append("type=");
        sb2.append(this.type);
        sb2.append(',');
        if (this.mode != null) {
            sb2.append("mode=");
            sb2.append(this.mode);
            sb2.append(',');
        }
        if (!StringUtils.isNullOrEmpty((CharSequence) this.status)) {
            sb2.append("status=");
            sb2.append(this.status);
            sb2.append(',');
        }
        if (this.priority != null) {
            sb2.append("prio=");
            sb2.append(this.priority);
            sb2.append(',');
        }
        sb2.append(PropertyUtils.INDEXED_DELIM2);
        return sb2.toString();
    }

    @Deprecated
    public Presence clone() {
        return new Presence(this);
    }

    public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
        Mode mode2;
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder(this, xmlEnvironment);
        addCommonAttributes(xmlStringBuilder);
        Type type2 = this.type;
        if (type2 != Type.available) {
            xmlStringBuilder.attribute("type", (Enum<?>) type2);
        }
        List<ExtensionElement> extensions = getExtensions();
        if (this.status == null && this.priority == null && (((mode2 = this.mode) == null || mode2 == Mode.available) && extensions.isEmpty() && getError() == null)) {
            return xmlStringBuilder.closeEmptyElement();
        }
        xmlStringBuilder.rightAngleBracket();
        xmlStringBuilder.optElement("status", this.status);
        xmlStringBuilder.optElement(JingleS5BTransportCandidate.ATTR_PRIORITY, (Object) this.priority);
        Mode mode3 = this.mode;
        if (!(mode3 == null || mode3 == Mode.available)) {
            xmlStringBuilder.element("show", (Enum<?>) mode3);
        }
        xmlStringBuilder.append((Collection<? extends Element>) extensions);
        appendErrorIfExists(xmlStringBuilder);
        xmlStringBuilder.closeElement(ELEMENT);
        return xmlStringBuilder;
    }

    public void setPriority(byte b10) {
        this.priority = Byte.valueOf(b10);
    }

    public PresenceBuilder asBuilder() {
        return StanzaBuilder.buildPresenceFrom(this, getStanzaId());
    }

    public PresenceBuilder asBuilder(String str) {
        return StanzaBuilder.buildPresenceFrom(this, str);
    }

    @Deprecated
    public Presence(Jid jid, Type type2) {
        this(type2);
        setTo(jid);
    }

    public PresenceBuilder asBuilder(XMPPConnection xMPPConnection) {
        return xMPPConnection.getStanzaFactory().buildPresenceStanzaFrom(this);
    }

    @Deprecated
    public Presence(Type type2, String str, int i10, Mode mode2) {
        this.type = Type.available;
        this.status = null;
        this.mode = null;
        setType(type2);
        setStatus(str);
        setPriority(i10);
        setMode(mode2);
    }

    Presence(PresenceBuilder presenceBuilder) {
        super((StanzaBuilder<?>) presenceBuilder);
        this.type = Type.available;
        this.status = null;
        this.mode = null;
        this.type = presenceBuilder.type;
        this.status = presenceBuilder.status;
        this.priority = presenceBuilder.priority;
        this.mode = presenceBuilder.mode;
    }

    public Presence(Presence presence) {
        super((Stanza) presence);
        this.type = Type.available;
        this.status = null;
        this.mode = null;
        this.type = presence.type;
        this.status = presence.status;
        this.priority = presence.priority;
        this.mode = presence.mode;
    }
}
