package org.jivesoftware.smackx.disco.provider;

import java.io.IOException;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.provider.IQProvider;
import org.jivesoftware.smack.util.ParserUtils;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.disco.packet.DiscoverItems;
import org.jivesoftware.smackx.iot.data.element.NodeElement;
import org.jxmpp.jid.Jid;

public class DiscoverItemsProvider extends IQProvider<DiscoverItems> {
    public DiscoverItems parse(XmlPullParser xmlPullParser, int i10, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException {
        DiscoverItems discoverItems = new DiscoverItems();
        discoverItems.setNode(xmlPullParser.getAttributeValue("", NodeElement.ELEMENT));
        boolean z10 = false;
        Jid jid = null;
        String str = "";
        String str2 = str;
        String str3 = str2;
        while (!z10) {
            XmlPullParser.Event next = xmlPullParser.next();
            if (next != XmlPullParser.Event.START_ELEMENT || !"item".equals(xmlPullParser.getName())) {
                XmlPullParser.Event event = XmlPullParser.Event.END_ELEMENT;
                if (next == event && "item".equals(xmlPullParser.getName())) {
                    DiscoverItems.Item item = new DiscoverItems.Item(jid);
                    item.setName(str);
                    item.setNode(str2);
                    item.setAction(str3);
                    discoverItems.addItem(item);
                } else if (next == event && "query".equals(xmlPullParser.getName())) {
                    z10 = true;
                }
            } else {
                jid = ParserUtils.getJidAttribute(xmlPullParser);
                str = xmlPullParser.getAttributeValue("", "name");
                str2 = xmlPullParser.getAttributeValue("", NodeElement.ELEMENT);
                str3 = xmlPullParser.getAttributeValue("", "action");
            }
        }
        return discoverItems;
    }
}
