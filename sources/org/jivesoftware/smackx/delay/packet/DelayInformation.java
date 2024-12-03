package org.jivesoftware.smackx.delay.packet;

import java.util.Date;
import javax.xml.namespace.QName;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jxmpp.util.XmppDateTime;

public class DelayInformation implements ExtensionElement {
    public static final String ELEMENT = "delay";
    public static final String NAMESPACE = "urn:xmpp:delay";
    public static final QName QNAME = new QName(NAMESPACE, ELEMENT);
    private final String from;
    private final String reason;
    private final Date stamp;

    public DelayInformation(Date date, String str, String str2) {
        this.stamp = date;
        this.from = str;
        this.reason = str2;
    }

    public static DelayInformation from(Stanza stanza) {
        return (DelayInformation) stanza.getExtension(DelayInformation.class);
    }

    public String getElementName() {
        return ELEMENT;
    }

    public String getFrom() {
        return this.from;
    }

    public String getNamespace() {
        return NAMESPACE;
    }

    public String getReason() {
        return this.reason;
    }

    public Date getStamp() {
        return this.stamp;
    }

    @Deprecated
    public static DelayInformation getFrom(Stanza stanza) {
        return from(stanza);
    }

    public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder(this, xmlEnvironment);
        xmlStringBuilder.attribute("stamp", XmppDateTime.i(this.stamp));
        xmlStringBuilder.optAttribute("from", this.from);
        xmlStringBuilder.optTextChild(this.reason, this);
        return xmlStringBuilder;
    }

    public DelayInformation(Date date) {
        this(date, (String) null, (String) null);
    }
}
