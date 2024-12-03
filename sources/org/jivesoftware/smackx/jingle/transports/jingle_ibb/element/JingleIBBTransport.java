package org.jivesoftware.smackx.jingle.transports.jingle_ibb.element;

import java.util.List;
import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jivesoftware.smackx.jingle.element.JingleContentTransport;
import org.jivesoftware.smackx.jingle.element.JingleContentTransportCandidate;

public class JingleIBBTransport extends JingleContentTransport {
    public static final String ATTR_BLOCK_SIZE = "block-size";
    public static final String ATTR_SID = "sid";
    public static final short DEFAULT_BLOCK_SIZE = 4096;
    public static final String NAMESPACE_V1 = "urn:xmpp:jingle:transports:ibb:1";
    private final short blockSize;
    private final String sid;

    public JingleIBBTransport() {
        this(4096);
    }

    /* access modifiers changed from: protected */
    public void addExtraAttributes(XmlStringBuilder xmlStringBuilder) {
        xmlStringBuilder.attribute(ATTR_BLOCK_SIZE, (int) this.blockSize);
        xmlStringBuilder.attribute("sid", this.sid);
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof JingleIBBTransport)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        JingleIBBTransport jingleIBBTransport = (JingleIBBTransport) obj;
        if (!getSessionId().equals(jingleIBBTransport.getSessionId()) || getBlockSize() != jingleIBBTransport.getBlockSize()) {
            return false;
        }
        return true;
    }

    public short getBlockSize() {
        return this.blockSize;
    }

    public String getNamespace() {
        return NAMESPACE_V1;
    }

    public String getSessionId() {
        return this.sid;
    }

    public int hashCode() {
        return toXML().toString().hashCode();
    }

    public JingleIBBTransport(String str) {
        this(4096, str);
    }

    public JingleIBBTransport(short s10) {
        this(s10, StringUtils.randomString(24));
    }

    public JingleIBBTransport(short s10, String str) {
        super((List<JingleContentTransportCandidate>) null);
        if (s10 > 0) {
            this.blockSize = s10;
        } else {
            this.blockSize = 4096;
        }
        this.sid = str;
    }
}
