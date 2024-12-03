package org.jivesoftware.smackx.muc.packet;

import java.io.IOException;
import javax.xml.namespace.QName;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;

public class GroupChatInvitation implements ExtensionElement {
    public static final String ELEMENT = "x";
    public static final String NAMESPACE = "jabber:x:conference";
    public static final QName QNAME = new QName(NAMESPACE, "x");
    private final String roomAddress;

    public static class Provider extends ExtensionElementProvider<GroupChatInvitation> {
        public GroupChatInvitation parse(XmlPullParser xmlPullParser, int i10, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException {
            String attributeValue = xmlPullParser.getAttributeValue("", "jid");
            xmlPullParser.next();
            return new GroupChatInvitation(attributeValue);
        }
    }

    public GroupChatInvitation(String str) {
        this.roomAddress = str;
    }

    public static GroupChatInvitation from(Stanza stanza) {
        return (GroupChatInvitation) stanza.getExtension(GroupChatInvitation.class);
    }

    public String getElementName() {
        return "x";
    }

    public String getNamespace() {
        return NAMESPACE;
    }

    public String getRoomAddress() {
        return this.roomAddress;
    }

    public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder((ExtensionElement) this);
        xmlStringBuilder.attribute("jid", getRoomAddress());
        xmlStringBuilder.closeEmptyElement();
        return xmlStringBuilder;
    }
}
