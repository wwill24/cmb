package org.jivesoftware.smackx.bytestreams.socks5.packet;

import com.facebook.internal.security.CertificateUtil;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.jivesoftware.smack.packet.Element;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.NamedElement;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.InternetAddress;
import org.jivesoftware.smack.util.Objects;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jivesoftware.smackx.jingle.transports.jingle_s5b.elements.JingleS5BTransport;
import org.jivesoftware.smackx.jingle.transports.jingle_s5b.elements.JingleS5BTransportCandidate;
import org.jxmpp.jid.Jid;

public class Bytestream extends IQ {
    public static final String ELEMENT = "query";
    public static final String NAMESPACE = "http://jabber.org/protocol/bytestreams";
    private Mode mode;
    private String sessionID;
    private final List<StreamHost> streamHosts;
    private Activate toActivate;
    private StreamHostUsed usedHost;

    /* renamed from: org.jivesoftware.smackx.bytestreams.socks5.packet.Bytestream$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$jivesoftware$smack$packet$IQ$Type;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                org.jivesoftware.smack.packet.IQ$Type[] r0 = org.jivesoftware.smack.packet.IQ.Type.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$org$jivesoftware$smack$packet$IQ$Type = r0
                org.jivesoftware.smack.packet.IQ$Type r1 = org.jivesoftware.smack.packet.IQ.Type.set     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$org$jivesoftware$smack$packet$IQ$Type     // Catch:{ NoSuchFieldError -> 0x001d }
                org.jivesoftware.smack.packet.IQ$Type r1 = org.jivesoftware.smack.packet.IQ.Type.result     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$org$jivesoftware$smack$packet$IQ$Type     // Catch:{ NoSuchFieldError -> 0x0028 }
                org.jivesoftware.smack.packet.IQ$Type r1 = org.jivesoftware.smack.packet.IQ.Type.get     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smackx.bytestreams.socks5.packet.Bytestream.AnonymousClass1.<clinit>():void");
        }
    }

    public static class Activate extends BytestreamExtensionElement {
        public static String ELEMENTNAME = "activate";
        private final Jid target;

        public Activate(Jid jid) {
            super((AnonymousClass1) null);
            this.target = jid;
        }

        public String getElementName() {
            return ELEMENTNAME;
        }

        public Jid getTarget() {
            return this.target;
        }

        public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder(this, xmlEnvironment);
            xmlStringBuilder.rightAngleBracket();
            xmlStringBuilder.escape((CharSequence) getTarget());
            xmlStringBuilder.closeElement((NamedElement) this);
            return xmlStringBuilder;
        }
    }

    private static abstract class BytestreamExtensionElement implements ExtensionElement {
        private BytestreamExtensionElement() {
        }

        /* synthetic */ BytestreamExtensionElement(AnonymousClass1 r12) {
            this();
        }

        public final String getNamespace() {
            return Bytestream.NAMESPACE;
        }
    }

    public enum Mode {
        tcp,
        udp;

        public static Mode fromName(String str) {
            try {
                return valueOf(str);
            } catch (Exception unused) {
                return tcp;
            }
        }
    }

    public static class StreamHost extends BytestreamExtensionElement {
        public static String ELEMENTNAME = "streamhost";
        private final InternetAddress address;
        private final Jid jid;
        private final int port;

        public StreamHost(Jid jid2, String str) {
            this(jid2, str, 0);
        }

        public InternetAddress getAddress() {
            return this.address;
        }

        public String getElementName() {
            return ELEMENTNAME;
        }

        public Jid getJID() {
            return this.jid;
        }

        public int getPort() {
            return this.port;
        }

        public String toString() {
            return "SOCKS5 Stream Host: " + this.jid + "[" + this.address + CertificateUtil.DELIMITER + this.port + "]";
        }

        public StreamHost(Jid jid2, String str, int i10) {
            this(jid2, InternetAddress.from(str), i10);
        }

        public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder(this, xmlEnvironment);
            xmlStringBuilder.attribute("jid", (CharSequence) getJID());
            xmlStringBuilder.attribute(JingleS5BTransportCandidate.ATTR_HOST, (CharSequence) this.address);
            if (getPort() != 0) {
                xmlStringBuilder.attribute(JingleS5BTransportCandidate.ATTR_PORT, Integer.toString(getPort()));
            } else {
                xmlStringBuilder.attribute("zeroconf", "_jabber.bytestreams");
            }
            xmlStringBuilder.closeEmptyElement();
            return xmlStringBuilder;
        }

        public StreamHost(Jid jid2, InetAddress inetAddress, int i10) {
            this(jid2, InternetAddress.from(inetAddress), i10);
        }

        public StreamHost(Jid jid2, InternetAddress internetAddress, int i10) {
            super((AnonymousClass1) null);
            this.jid = (Jid) Objects.requireNonNull(jid2, "StreamHost JID must not be null");
            this.address = (InternetAddress) Objects.requireNonNull(internetAddress);
            this.port = i10;
        }
    }

    public static class StreamHostUsed extends BytestreamExtensionElement {
        public static String ELEMENTNAME = "streamhost-used";
        private final Jid jid;

        public StreamHostUsed(Jid jid2) {
            super((AnonymousClass1) null);
            this.jid = jid2;
        }

        public String getElementName() {
            return ELEMENTNAME;
        }

        public Jid getJID() {
            return this.jid;
        }

        public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder(this, xmlEnvironment);
            xmlStringBuilder.attribute("jid", (CharSequence) getJID());
            xmlStringBuilder.closeEmptyElement();
            return xmlStringBuilder;
        }
    }

    public Bytestream() {
        super("query", NAMESPACE);
        this.mode = Mode.tcp;
        this.streamHosts = new ArrayList();
    }

    public StreamHost addStreamHost(Jid jid, String str) {
        return addStreamHost(jid, str, 0);
    }

    public int countStreamHosts() {
        return this.streamHosts.size();
    }

    /* access modifiers changed from: protected */
    public IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder iQChildElementXmlStringBuilder) {
        int i10 = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$packet$IQ$Type[getType().ordinal()];
        if (i10 == 1) {
            iQChildElementXmlStringBuilder.optAttribute("sid", getSessionID());
            iQChildElementXmlStringBuilder.optAttribute(JingleS5BTransport.ATTR_MODE, (Enum<?>) getMode());
            iQChildElementXmlStringBuilder.rightAngleBracket();
            if (getToActivate() == null) {
                for (StreamHost xml : getStreamHosts()) {
                    iQChildElementXmlStringBuilder.append(xml.toXML());
                }
            } else {
                iQChildElementXmlStringBuilder.append(getToActivate().toXML());
            }
        } else if (i10 == 2) {
            iQChildElementXmlStringBuilder.rightAngleBracket();
            iQChildElementXmlStringBuilder.optAppend((Element) getUsedHost());
            for (StreamHost xml2 : this.streamHosts) {
                iQChildElementXmlStringBuilder.append(xml2.toXML());
            }
        } else if (i10 == 3) {
            iQChildElementXmlStringBuilder.setEmptyElement();
        } else {
            throw new IllegalStateException();
        }
        return iQChildElementXmlStringBuilder;
    }

    public Mode getMode() {
        return this.mode;
    }

    public String getSessionID() {
        return this.sessionID;
    }

    public StreamHost getStreamHost(Jid jid) {
        if (jid == null) {
            return null;
        }
        for (StreamHost next : this.streamHosts) {
            if (next.getJID().Y(jid)) {
                return next;
            }
        }
        return null;
    }

    public List<StreamHost> getStreamHosts() {
        return Collections.unmodifiableList(this.streamHosts);
    }

    public Activate getToActivate() {
        return this.toActivate;
    }

    public StreamHostUsed getUsedHost() {
        return this.usedHost;
    }

    public void setMode(Mode mode2) {
        this.mode = mode2;
    }

    public void setSessionID(String str) {
        this.sessionID = str;
    }

    public void setToActivate(Jid jid) {
        this.toActivate = new Activate(jid);
    }

    public void setUsedHost(Jid jid) {
        this.usedHost = new StreamHostUsed(jid);
    }

    public StreamHost addStreamHost(Jid jid, String str, int i10) {
        StreamHost streamHost = new StreamHost(jid, str, i10);
        addStreamHost(streamHost);
        return streamHost;
    }

    public Bytestream(String str) {
        this();
        setSessionID(str);
    }

    public void addStreamHost(StreamHost streamHost) {
        this.streamHosts.add(streamHost);
    }
}
