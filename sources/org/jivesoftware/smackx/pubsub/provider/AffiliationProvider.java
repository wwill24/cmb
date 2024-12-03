package org.jivesoftware.smackx.pubsub.provider;

import java.io.IOException;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smack.util.ParserUtils;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smackx.iot.data.element.NodeElement;
import org.jivesoftware.smackx.pubsub.Affiliation;
import org.jxmpp.jid.BareJid;
import org.jxmpp.jid.EntityBareJid;

public class AffiliationProvider extends ExtensionElementProvider<Affiliation> {
    public Affiliation parse(XmlPullParser xmlPullParser, int i10, XmlEnvironment xmlEnvironment) throws IOException {
        Affiliation.Type type = null;
        String attributeValue = xmlPullParser.getAttributeValue((String) null, NodeElement.ELEMENT);
        EntityBareJid bareJidAttribute = ParserUtils.getBareJidAttribute(xmlPullParser);
        Affiliation.AffiliationNamespace fromXmlns = Affiliation.AffiliationNamespace.fromXmlns(xmlPullParser.getNamespace());
        String attributeValue2 = xmlPullParser.getAttributeValue((String) null, "affiliation");
        if (attributeValue2 != null) {
            type = Affiliation.Type.valueOf(attributeValue2);
        }
        if (attributeValue != null && bareJidAttribute == null) {
            return new Affiliation(attributeValue, type, fromXmlns);
        }
        if (attributeValue == null && bareJidAttribute != null) {
            return new Affiliation((BareJid) bareJidAttribute, type, fromXmlns);
        }
        throw new IOException("Invalid affililation. Either one of 'node' or 'jid' must be set. Node: " + attributeValue + ". Jid: " + bareJidAttribute + '.');
    }
}
