package org.jivesoftware.smackx.ox.element;

import java.util.Date;
import java.util.List;
import java.util.Set;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.NamedElement;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jxmpp.jid.Jid;

public class SigncryptElement extends EncryptedOpenPgpContentElement {
    public static final String ELEMENT = "signcrypt";

    public SigncryptElement(Set<? extends Jid> set, String str, Date date, List<ExtensionElement> list) {
        super(set, str, date, list);
    }

    public String getElementName() {
        return ELEMENT;
    }

    public SigncryptElement(Set<? extends Jid> set, List<ExtensionElement> list) {
        super(set, list);
    }

    public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
        XmlStringBuilder rightAngleBracket = new XmlStringBuilder((ExtensionElement) this).rightAngleBracket();
        addCommonXml(rightAngleBracket);
        rightAngleBracket.closeElement((NamedElement) this);
        return rightAngleBracket;
    }
}
