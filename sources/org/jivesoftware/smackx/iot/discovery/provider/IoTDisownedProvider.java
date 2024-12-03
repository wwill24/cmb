package org.jivesoftware.smackx.iot.discovery.provider;

import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.provider.IQProvider;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smackx.iot.discovery.element.IoTDisowned;
import org.jivesoftware.smackx.iot.parser.NodeInfoParser;

public class IoTDisownedProvider extends IQProvider<IoTDisowned> {
    public IoTDisowned parse(XmlPullParser xmlPullParser, int i10, XmlEnvironment xmlEnvironment) {
        return new IoTDisowned(NodeInfoParser.parse(xmlPullParser));
    }
}
