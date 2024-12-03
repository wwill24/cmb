package org.jivesoftware.smackx.disco.provider;

import java.io.IOException;
import org.jivesoftware.smack.packet.IqData;
import org.jivesoftware.smack.packet.StanzaBuilder;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.parsing.SmackParsingException;
import org.jivesoftware.smack.provider.C0522IqProvider;
import org.jivesoftware.smack.util.PacketParserUtils;
import org.jivesoftware.smack.util.ParserUtils;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.disco.packet.DiscoverInfo;
import org.jivesoftware.smackx.disco.packet.DiscoverInfoBuilder;
import org.jivesoftware.smackx.iot.data.element.NodeElement;

public class DiscoverInfoProvider extends C0522IqProvider<DiscoverInfo> {
    public DiscoverInfo parse(XmlPullParser xmlPullParser, int i10, IqData iqData, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException, SmackParsingException {
        DiscoverInfoBuilder builder = DiscoverInfo.builder(iqData);
        builder.setNode(xmlPullParser.getAttributeValue(NodeElement.ELEMENT));
        while (true) {
            XmlPullParser.Event next = xmlPullParser.next();
            if (next == XmlPullParser.Event.START_ELEMENT) {
                String name = xmlPullParser.getName();
                if (xmlPullParser.getNamespace().equals(DiscoverInfo.NAMESPACE)) {
                    name.hashCode();
                    if (name.equals("feature")) {
                        builder.addFeature(xmlPullParser.getAttributeValue("var"));
                    } else if (name.equals("identity")) {
                        builder.addIdentity(new DiscoverInfo.Identity(xmlPullParser.getAttributeValue("category"), xmlPullParser.getAttributeValue("type"), xmlPullParser.getAttributeValue("name"), ParserUtils.getXmlLang(xmlPullParser)));
                    }
                } else {
                    PacketParserUtils.addExtensionElement((StanzaBuilder<?>) builder, xmlPullParser, xmlEnvironment);
                }
            } else if (next == XmlPullParser.Event.END_ELEMENT && xmlPullParser.getDepth() == i10) {
                return builder.buildWithoutValidiation();
            }
        }
    }
}
