package org.jivesoftware.smackx.iot.discovery.provider;

import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.provider.IQProvider;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smackx.iot.discovery.element.IoTUnregister;
import org.jivesoftware.smackx.iot.parser.NodeInfoParser;

public class IoTUnregisterProvider extends IQProvider<IoTUnregister> {
    public IoTUnregister parse(XmlPullParser xmlPullParser, int i10, XmlEnvironment xmlEnvironment) {
        return new IoTUnregister(NodeInfoParser.parse(xmlPullParser));
    }
}
