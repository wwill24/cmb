package org.jivesoftware.smackx.ping.packet;

import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.IqData;
import org.jivesoftware.smack.packet.SimpleIQ;
import org.jxmpp.jid.Jid;

public class Ping extends SimpleIQ {
    public static final String ELEMENT = "ping";
    public static final String NAMESPACE = "urn:xmpp:ping";

    public Ping() {
        super(ELEMENT, NAMESPACE);
    }

    public IQ getPong() {
        return IQ.createResultIQ(this);
    }

    public Ping(Jid jid) {
        this();
        setTo(jid);
        setType(IQ.Type.get);
    }

    public Ping(XMPPConnection xMPPConnection, Jid jid) {
        this(xMPPConnection.getStanzaFactory().buildIqData(), jid);
    }

    public Ping(IqData iqData, Jid jid) {
        super(((IqData) iqData.to(jid)).ofType(IQ.Type.get), ELEMENT, NAMESPACE);
    }

    public Ping(IqData iqData) {
        super(iqData, ELEMENT, NAMESPACE);
    }
}
