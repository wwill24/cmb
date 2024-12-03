package org.jivesoftware.smackx.jingle.transports.jingle_s5b.elements;

import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.InternetAddress;
import org.jivesoftware.smack.util.Objects;
import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jivesoftware.smackx.bytestreams.socks5.packet.Bytestream;
import org.jivesoftware.smackx.jingle.element.JingleContentTransportCandidate;
import org.jxmpp.jid.Jid;
import org.jxmpp.jid.impl.a;
import org.jxmpp.stringprep.XmppStringprepException;

public final class JingleS5BTransportCandidate extends JingleContentTransportCandidate {
    public static final String ATTR_CID = "cid";
    public static final String ATTR_HOST = "host";
    public static final String ATTR_JID = "jid";
    public static final String ATTR_PORT = "port";
    public static final String ATTR_PRIORITY = "priority";
    public static final String ATTR_TYPE = "type";
    public static final String NAMESPACE = "urn:xmpp:jingle:transports:s5b:1";
    private final String cid;
    private final InternetAddress host;
    private final Jid jid;
    private final int port;
    private final int priority;
    private final Type type;

    public static final class Builder {
        private String cid;
        private InternetAddress host;
        private Jid jid;
        private int port;
        private int priority;
        private Type type;

        public JingleS5BTransportCandidate build() {
            return new JingleS5BTransportCandidate(this.cid, this.host, this.jid, this.port, this.priority, this.type);
        }

        public Builder setCandidateId(String str) {
            this.cid = str;
            return this;
        }

        public Builder setHost(String str) {
            return setHost(InternetAddress.from(str));
        }

        public Builder setJid(String str) throws XmppStringprepException {
            this.jid = a.o(str);
            return this;
        }

        public Builder setPort(int i10) {
            if (i10 >= 0) {
                this.port = i10;
                return this;
            }
            throw new IllegalArgumentException("Port MUST NOT be less than 0.");
        }

        public Builder setPriority(int i10) {
            if (i10 >= 0) {
                this.priority = i10;
                return this;
            }
            throw new IllegalArgumentException("Priority MUST NOT be less than 0.");
        }

        public Builder setType(Type type2) {
            this.type = type2;
            return this;
        }

        private Builder() {
            this.port = -1;
            this.priority = -1;
        }

        public Builder setHost(InternetAddress internetAddress) {
            this.host = internetAddress;
            return this;
        }
    }

    public enum Type {
        assisted(120),
        direct(126),
        proxy(10),
        tunnel(110);
        
        private final int weight;

        private Type(int i10) {
            this.weight = i10;
        }

        public static Type fromString(String str) {
            for (Type type : values()) {
                if (type.toString().equals(str)) {
                    return type;
                }
            }
            throw new IllegalArgumentException("Illegal type: " + str);
        }

        public int getWeight() {
            return this.weight;
        }
    }

    public JingleS5BTransportCandidate(String str, String str2, Jid jid2, int i10, int i11, Type type2) {
        this(str, InternetAddress.from(str2), jid2, i10, i11, type2);
    }

    public static Builder getBuilder() {
        return new Builder();
    }

    public String getCandidateId() {
        return this.cid;
    }

    public InternetAddress getHost() {
        return this.host;
    }

    public Jid getJid() {
        return this.jid;
    }

    public String getNamespace() {
        return "urn:xmpp:jingle:transports:s5b:1";
    }

    public int getPort() {
        return this.port;
    }

    public int getPriority() {
        return this.priority;
    }

    public Bytestream.StreamHost getStreamHost() {
        return new Bytestream.StreamHost(this.jid, this.host, this.port);
    }

    public Type getType() {
        return this.type;
    }

    public JingleS5BTransportCandidate(String str, InternetAddress internetAddress, Jid jid2, int i10, int i11, Type type2) {
        Objects.requireNonNull(str);
        Objects.requireNonNull(internetAddress);
        Objects.requireNonNull(jid2);
        if (i11 < 0) {
            throw new IllegalArgumentException("Priority MUST NOT be less than 0.");
        } else if (i10 >= 0) {
            this.cid = str;
            this.host = internetAddress;
            this.jid = jid2;
            this.port = i10;
            this.priority = i11;
            this.type = type2;
        } else {
            throw new IllegalArgumentException("Port MUST NOT be less than 0.");
        }
    }

    public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder(this, xmlEnvironment);
        xmlStringBuilder.attribute("cid", this.cid);
        xmlStringBuilder.attribute(ATTR_HOST, (CharSequence) this.host);
        xmlStringBuilder.attribute("jid", (CharSequence) this.jid);
        int i10 = this.port;
        if (i10 >= 0) {
            xmlStringBuilder.attribute(ATTR_PORT, i10);
        }
        xmlStringBuilder.attribute(ATTR_PRIORITY, this.priority);
        xmlStringBuilder.optAttribute("type", (Enum<?>) this.type);
        xmlStringBuilder.closeEmptyElement();
        return xmlStringBuilder;
    }

    public JingleS5BTransportCandidate(Bytestream.StreamHost streamHost, int i10, Type type2) {
        this(StringUtils.randomString(24), streamHost.getAddress(), streamHost.getJID(), streamHost.getPort(), i10, type2);
    }
}
