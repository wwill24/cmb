package org.jivesoftware.smackx.offline.packet;

import java.io.IOException;
import javax.xml.namespace.QName;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.iot.data.element.NodeElement;

public class OfflineMessageInfo implements ExtensionElement {
    public static final QName QNAME = new QName("http://jabber.org/protocol/offline", OfflineMessageRequest.ELEMENT);
    private String node = null;

    public static class Provider extends ExtensionElementProvider<OfflineMessageInfo> {
        public OfflineMessageInfo parse(XmlPullParser xmlPullParser, int i10, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException {
            OfflineMessageInfo offlineMessageInfo = new OfflineMessageInfo();
            boolean z10 = false;
            while (!z10) {
                XmlPullParser.Event next = xmlPullParser.next();
                if (next == XmlPullParser.Event.START_ELEMENT) {
                    if (xmlPullParser.getName().equals("item")) {
                        offlineMessageInfo.setNode(xmlPullParser.getAttributeValue("", NodeElement.ELEMENT));
                    }
                } else if (next == XmlPullParser.Event.END_ELEMENT && xmlPullParser.getName().equals(OfflineMessageRequest.ELEMENT)) {
                    z10 = true;
                }
            }
            return offlineMessageInfo;
        }
    }

    public String getElementName() {
        return QNAME.getLocalPart();
    }

    public String getNamespace() {
        return QNAME.getNamespaceURI();
    }

    public String getNode() {
        return this.node;
    }

    public void setNode(String str) {
        this.node = str;
    }

    public String toXML(XmlEnvironment xmlEnvironment) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append('<');
        sb2.append(getElementName());
        sb2.append(" xmlns=\"");
        sb2.append(getNamespace());
        sb2.append("\">");
        if (getNode() != null) {
            sb2.append("<item node=\"");
            sb2.append(getNode());
            sb2.append("\"/>");
        }
        sb2.append("</");
        sb2.append(getElementName());
        sb2.append('>');
        return sb2.toString();
    }
}
