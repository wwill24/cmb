package org.jivesoftware.smackx.forward.packet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.xml.namespace.QName;
import org.jivesoftware.smack.packet.Element;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.NamedElement;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.Objects;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jivesoftware.smackx.delay.packet.DelayInformation;

public class Forwarded<S extends Stanza> implements ExtensionElement {
    public static final String ELEMENT = "forwarded";
    public static final String NAMESPACE = "urn:xmpp:forward:0";
    public static final QName QNAME = new QName(NAMESPACE, ELEMENT);
    private final DelayInformation delay;
    private final S forwardedStanza;

    @Deprecated
    public Forwarded(DelayInformation delayInformation, S s10) {
        this(s10, delayInformation);
    }

    public static List<Message> extractMessagesFrom(Collection<Forwarded<Message>> collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        for (Forwarded<Message> forwardedStanza2 : collection) {
            arrayList.add((Message) forwardedStanza2.getForwardedStanza());
        }
        return arrayList;
    }

    public static Forwarded<?> from(Stanza stanza) {
        return (Forwarded) stanza.getExtension(Forwarded.class);
    }

    public DelayInformation getDelayInformation() {
        return this.delay;
    }

    public String getElementName() {
        return ELEMENT;
    }

    public S getForwardedStanza() {
        return this.forwardedStanza;
    }

    public String getNamespace() {
        return NAMESPACE;
    }

    public boolean isForwarded(Class<? extends Stanza> cls) {
        return cls.isAssignableFrom(this.forwardedStanza.getClass());
    }

    public Forwarded(S s10) {
        this(s10, (DelayInformation) null);
    }

    public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder(this, xmlEnvironment);
        xmlStringBuilder.rightAngleBracket();
        xmlStringBuilder.optElement(getDelayInformation());
        xmlStringBuilder.append((Element) this.forwardedStanza);
        xmlStringBuilder.closeElement((NamedElement) this);
        return xmlStringBuilder;
    }

    public Forwarded(S s10, DelayInformation delayInformation) {
        this.forwardedStanza = (Stanza) Objects.requireNonNull(s10);
        this.delay = delayInformation;
    }
}
