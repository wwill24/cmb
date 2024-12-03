package org.jivesoftware.smackx.jingle.transports.jingle_s5b.elements;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jivesoftware.smackx.bytestreams.socks5.packet.Bytestream;
import org.jivesoftware.smackx.jingle.element.JingleContentTransport;
import org.jivesoftware.smackx.jingle.element.JingleContentTransportCandidate;
import org.jivesoftware.smackx.jingle.element.JingleContentTransportInfo;
import org.jivesoftware.smackx.jingle.transports.jingle_s5b.elements.JingleS5BTransportInfo;

public class JingleS5BTransport extends JingleContentTransport {
    public static final String ATTR_DSTADDR = "dstaddr";
    public static final String ATTR_MODE = "mode";
    public static final String ATTR_SID = "sid";
    public static final String NAMESPACE_V1 = "urn:xmpp:jingle:transports:s5b:1";
    private final String dstAddr;
    private final Bytestream.Mode mode;
    private final String streamId;

    public static class Builder {
        private final ArrayList<JingleContentTransportCandidate> candidates = new ArrayList<>();
        private String dstAddr;
        private JingleContentTransportInfo info;
        private Bytestream.Mode mode;
        private String streamId;

        public Builder addTransportCandidate(JingleS5BTransportCandidate jingleS5BTransportCandidate) {
            if (this.info == null) {
                this.candidates.add(jingleS5BTransportCandidate);
                return this;
            }
            throw new IllegalStateException("Builder has already an info set. The transport can only have either an info or transport candidates, not both.");
        }

        public JingleS5BTransport build() {
            return new JingleS5BTransport(this.candidates, this.info, this.streamId, this.dstAddr, this.mode);
        }

        public Builder setCandidateActivated(String str) {
            return setTransportInfo(new JingleS5BTransportInfo.CandidateActivated(str));
        }

        public Builder setCandidateError() {
            return setTransportInfo(JingleS5BTransportInfo.CandidateError.INSTANCE);
        }

        public Builder setCandidateUsed(String str) {
            return setTransportInfo(new JingleS5BTransportInfo.CandidateUsed(str));
        }

        public Builder setDestinationAddress(String str) {
            this.dstAddr = str;
            return this;
        }

        public Builder setMode(Bytestream.Mode mode2) {
            this.mode = mode2;
            return this;
        }

        public Builder setProxyError() {
            return setTransportInfo(JingleS5BTransportInfo.ProxyError.INSTANCE);
        }

        public Builder setStreamId(String str) {
            this.streamId = str;
            return this;
        }

        public Builder setTransportInfo(JingleContentTransportInfo jingleContentTransportInfo) {
            if (!this.candidates.isEmpty()) {
                throw new IllegalStateException("Builder has already at least one candidate set. The transport can only have either an info or transport candidates, not both.");
            } else if (this.info == null) {
                this.info = jingleContentTransportInfo;
                return this;
            } else {
                throw new IllegalStateException("Builder has already an info set.");
            }
        }
    }

    protected JingleS5BTransport(List<JingleContentTransportCandidate> list, JingleContentTransportInfo jingleContentTransportInfo, String str, String str2, Bytestream.Mode mode2) {
        super(list, jingleContentTransportInfo);
        StringUtils.requireNotNullNorEmpty(str, "sid MUST be neither null, nor empty.");
        this.streamId = str;
        this.dstAddr = str2;
        this.mode = mode2;
    }

    public static Builder getBuilder() {
        return new Builder();
    }

    /* access modifiers changed from: protected */
    public void addExtraAttributes(XmlStringBuilder xmlStringBuilder) {
        xmlStringBuilder.optAttribute(ATTR_DSTADDR, this.dstAddr);
        xmlStringBuilder.optAttribute(ATTR_MODE, (Enum<?>) this.mode);
        xmlStringBuilder.attribute("sid", this.streamId);
    }

    public JingleS5BTransportCandidate getCandidate(String str) {
        Iterator<JingleContentTransportCandidate> it = this.candidates.iterator();
        while (it.hasNext()) {
            JingleS5BTransportCandidate jingleS5BTransportCandidate = (JingleS5BTransportCandidate) it.next();
            if (jingleS5BTransportCandidate.getCandidateId().equals(str)) {
                return jingleS5BTransportCandidate;
            }
        }
        return null;
    }

    public String getDestinationAddress() {
        return this.dstAddr;
    }

    public Bytestream.Mode getMode() {
        Bytestream.Mode mode2 = this.mode;
        return mode2 == null ? Bytestream.Mode.tcp : mode2;
    }

    public String getNamespace() {
        return "urn:xmpp:jingle:transports:s5b:1";
    }

    public String getStreamId() {
        return this.streamId;
    }

    public boolean hasCandidate(String str) {
        return getCandidate(str) != null;
    }
}
