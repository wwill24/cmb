package org.jivesoftware.smackx.ox.element;

import java.util.Date;
import java.util.List;
import java.util.Set;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.NamedElement;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jxmpp.jid.Jid;

public class SignElement extends OpenPgpContentElement {
    public static final String ELEMENT = "sign";

    public SignElement(Set<Jid> set, Date date, List<ExtensionElement> list) {
        super(set, date, list);
    }

    public String getElementName() {
        return ELEMENT;
    }

    public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
        XmlStringBuilder rightAngleBracket = new XmlStringBuilder((ExtensionElement) this).rightAngleBracket();
        addCommonXml(rightAngleBracket);
        rightAngleBracket.closeElement((NamedElement) this);
        return rightAngleBracket;
    }
}
