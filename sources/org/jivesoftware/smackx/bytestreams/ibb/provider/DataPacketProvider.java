package org.jivesoftware.smackx.bytestreams.ibb.provider;

import java.io.IOException;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.parsing.SmackParsingException;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smack.util.ParserUtils;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.bytestreams.ibb.packet.Data;
import org.jivesoftware.smackx.bytestreams.ibb.packet.DataPacketExtension;

public class DataPacketProvider {

    public static class IQProvider extends org.jivesoftware.smack.provider.IQProvider<Data> {
        private static final PacketExtensionProvider packetExtensionProvider = new PacketExtensionProvider();

        public Data parse(XmlPullParser xmlPullParser, int i10, XmlEnvironment xmlEnvironment) throws IOException, XmlPullParserException, SmackParsingException {
            return new Data((DataPacketExtension) packetExtensionProvider.parse(xmlPullParser));
        }
    }

    public static class PacketExtensionProvider extends ExtensionElementProvider<DataPacketExtension> {
        public DataPacketExtension parse(XmlPullParser xmlPullParser, int i10, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException, SmackParsingException.RequiredAttributeMissingException {
            return new DataPacketExtension(xmlPullParser.getAttributeValue("", "sid"), ParserUtils.getRequiredUInt16Attribute(xmlPullParser, "seq"), xmlPullParser.nextText());
        }
    }
}
