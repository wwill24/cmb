package org.jivesoftware.smackx.bytestreams.ibb.provider;

import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.provider.IQProvider;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smackx.bytestreams.ibb.packet.Close;

public class CloseIQProvider extends IQProvider<Close> {
    public Close parse(XmlPullParser xmlPullParser, int i10, XmlEnvironment xmlEnvironment) {
        return new Close(xmlPullParser.getAttributeValue("", "sid"));
    }
}
