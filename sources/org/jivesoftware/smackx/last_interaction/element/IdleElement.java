package org.jivesoftware.smackx.last_interaction.element;

import java.util.Date;
import javax.xml.namespace.QName;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.Presence;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.Objects;
import org.jivesoftware.smack.util.XmlStringBuilder;

public class IdleElement implements ExtensionElement {
    public static final String ATTR_SINCE = "since";
    public static final String ELEMENT = "idle";
    public static final String NAMESPACE = "urn:xmpp:idle:1";
    public static final QName QNAME = new QName(NAMESPACE, ELEMENT);
    private final Date since;

    public IdleElement() {
        this(new Date());
    }

    public static void addToPresence(Presence presence) {
        presence.addExtension(new IdleElement());
    }

    public static IdleElement fromPresence(Presence presence) {
        return (IdleElement) presence.getExtension(IdleElement.class);
    }

    public String getElementName() {
        return ELEMENT;
    }

    public String getNamespace() {
        return NAMESPACE;
    }

    public Date getSince() {
        return this.since;
    }

    public IdleElement(Date date) {
        this.since = (Date) Objects.requireNonNull(date);
    }

    public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
        return new XmlStringBuilder((ExtensionElement) this).attribute(ATTR_SINCE, this.since).closeEmptyElement();
    }
}
