package org.jivesoftware.smackx.bytestreams.socks5.provider;

import java.io.IOException;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.provider.IQProvider;
import org.jivesoftware.smack.util.ParserUtils;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.bytestreams.socks5.packet.Bytestream;
import org.jivesoftware.smackx.jingle.transports.jingle_s5b.elements.JingleS5BTransport;
import org.jivesoftware.smackx.jingle.transports.jingle_s5b.elements.JingleS5BTransportCandidate;
import org.jxmpp.jid.Jid;

public class BytestreamsProvider extends IQProvider<Bytestream> {
    public Bytestream parse(XmlPullParser xmlPullParser, int i10, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException {
        Bytestream bytestream = new Bytestream();
        String attributeValue = xmlPullParser.getAttributeValue("", "sid");
        String attributeValue2 = xmlPullParser.getAttributeValue("", JingleS5BTransport.ATTR_MODE);
        boolean z10 = false;
        loop0:
        while (true) {
            String str = null;
            Jid jid = null;
            String str2 = null;
            while (!z10) {
                XmlPullParser.Event next = xmlPullParser.next();
                String name = xmlPullParser.getName();
                if (next == XmlPullParser.Event.START_ELEMENT) {
                    if (name.equals(Bytestream.StreamHost.ELEMENTNAME)) {
                        jid = ParserUtils.getJidAttribute(xmlPullParser);
                        str2 = xmlPullParser.getAttributeValue("", JingleS5BTransportCandidate.ATTR_HOST);
                        str = xmlPullParser.getAttributeValue("", JingleS5BTransportCandidate.ATTR_PORT);
                    } else if (name.equals(Bytestream.StreamHostUsed.ELEMENTNAME)) {
                        bytestream.setUsedHost(ParserUtils.getJidAttribute(xmlPullParser));
                    } else if (name.equals(Bytestream.Activate.ELEMENTNAME)) {
                        bytestream.setToActivate(ParserUtils.getJidAttribute(xmlPullParser));
                    }
                } else if (next != XmlPullParser.Event.END_ELEMENT) {
                    continue;
                } else if (name.equals("streamhost")) {
                    if (str == null) {
                        bytestream.addStreamHost(jid, str2);
                    } else {
                        bytestream.addStreamHost(jid, str2, Integer.parseInt(str));
                    }
                } else if (name.equals("query")) {
                    z10 = true;
                }
            }
            break loop0;
        }
        if (attributeValue2 == null) {
            bytestream.setMode(Bytestream.Mode.tcp);
        } else {
            bytestream.setMode(Bytestream.Mode.fromName(attributeValue2));
        }
        bytestream.setSessionID(attributeValue);
        return bytestream;
    }
}
