package org.jivesoftware.smackx.iot.data.provider;

import java.io.IOException;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.provider.IQProvider;
import org.jivesoftware.smack.util.ParserUtils;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smackx.iot.data.element.IoTDataRequest;

public class IoTDataRequestProvider extends IQProvider<IoTDataRequest> {
    public IoTDataRequest parse(XmlPullParser xmlPullParser, int i10, XmlEnvironment xmlEnvironment) throws IOException {
        return new IoTDataRequest(ParserUtils.getIntegerAttributeOrThrow(xmlPullParser, "seqnr", "IoT data request without sequence number"), ParserUtils.getBooleanAttribute(xmlPullParser, "momentary", false));
    }
}
