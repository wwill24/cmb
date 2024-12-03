package org.jivesoftware.smackx.xhtmlim.packet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.xml.namespace.QName;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.MessageView;
import org.jivesoftware.smack.packet.NamedElement;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.XmlStringBuilder;

public final class XHTMLExtension implements ExtensionElement {
    public static final String ELEMENT = "html";
    public static final String NAMESPACE = "http://jabber.org/protocol/xhtml-im";
    public static final QName QNAME = new QName(NAMESPACE, ELEMENT);
    private final List<CharSequence> bodies = new ArrayList();

    public static XHTMLExtension from(MessageView messageView) {
        return (XHTMLExtension) messageView.getExtension(XHTMLExtension.class);
    }

    public void addBody(CharSequence charSequence) {
        synchronized (this.bodies) {
            this.bodies.add(charSequence);
        }
    }

    public List<CharSequence> getBodies() {
        List<CharSequence> unmodifiableList;
        synchronized (this.bodies) {
            unmodifiableList = Collections.unmodifiableList(new ArrayList(this.bodies));
        }
        return unmodifiableList;
    }

    public int getBodiesCount() {
        int size;
        synchronized (this.bodies) {
            size = this.bodies.size();
        }
        return size;
    }

    public String getElementName() {
        return ELEMENT;
    }

    public String getNamespace() {
        return NAMESPACE;
    }

    public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder((ExtensionElement) this);
        xmlStringBuilder.rightAngleBracket();
        for (CharSequence append : getBodies()) {
            xmlStringBuilder.append(append);
        }
        xmlStringBuilder.closeElement((NamedElement) this);
        return xmlStringBuilder;
    }
}
