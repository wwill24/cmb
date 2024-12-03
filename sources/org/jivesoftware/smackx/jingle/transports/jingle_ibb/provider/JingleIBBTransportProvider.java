package org.jivesoftware.smackx.jingle.transports.jingle_ibb.provider;

import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smackx.jingle.provider.JingleContentTransportProvider;
import org.jivesoftware.smackx.jingle.transports.jingle_ibb.element.JingleIBBTransport;

public class JingleIBBTransportProvider extends JingleContentTransportProvider<JingleIBBTransport> {
    public JingleIBBTransport parse(XmlPullParser xmlPullParser, int i10, XmlEnvironment xmlEnvironment) {
        String attributeValue = xmlPullParser.getAttributeValue((String) null, JingleIBBTransport.ATTR_BLOCK_SIZE);
        return new JingleIBBTransport(attributeValue != null ? Short.valueOf(attributeValue).shortValue() : -1, xmlPullParser.getAttributeValue((String) null, "sid"));
    }
}
