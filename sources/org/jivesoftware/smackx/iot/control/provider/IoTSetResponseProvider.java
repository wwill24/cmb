package org.jivesoftware.smackx.iot.control.provider;

import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.provider.IQProvider;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smackx.iot.control.element.IoTSetResponse;

public class IoTSetResponseProvider extends IQProvider<IoTSetResponse> {
    public IoTSetResponse parse(XmlPullParser xmlPullParser, int i10, XmlEnvironment xmlEnvironment) {
        return new IoTSetResponse();
    }
}
