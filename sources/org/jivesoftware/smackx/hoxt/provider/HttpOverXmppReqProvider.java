package org.jivesoftware.smackx.hoxt.provider;

import com.facebook.internal.ServerProtocol;
import java.io.IOException;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.parsing.SmackParsingException;
import org.jivesoftware.smack.util.ParserUtils;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.hoxt.packet.AbstractHttpOverXmpp;
import org.jivesoftware.smackx.hoxt.packet.HttpMethod;
import org.jivesoftware.smackx.hoxt.packet.HttpOverXmppReq;
import org.jivesoftware.smackx.jingle.element.Jingle;

public class HttpOverXmppReqProvider extends AbstractHttpOverXmppProvider<HttpOverXmppReq> {
    private static final String ATTRIBUTE_MAX_CHUNK_SIZE = "maxChunkSize";
    private static final String ATTRIBUTE_METHOD = "method";
    private static final String ATTRIBUTE_RESOURCE = "resource";

    public HttpOverXmppReq parse(XmlPullParser xmlPullParser, int i10, XmlEnvironment xmlEnvironment) throws IOException, XmlPullParserException, SmackParsingException {
        HttpOverXmppReq.Builder builder = HttpOverXmppReq.builder();
        builder.setResource(xmlPullParser.getAttributeValue("", ATTRIBUTE_RESOURCE));
        builder.setVersion(xmlPullParser.getAttributeValue("", ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION));
        builder.setMethod(HttpMethod.valueOf(xmlPullParser.getAttributeValue("", "method")));
        String attributeValue = xmlPullParser.getAttributeValue("", "sipub");
        String attributeValue2 = xmlPullParser.getAttributeValue("", AbstractHttpOverXmpp.Ibb.ELEMENT);
        String attributeValue3 = xmlPullParser.getAttributeValue("", Jingle.ELEMENT);
        if (attributeValue != null) {
            builder.setSipub(ParserUtils.parseXmlBoolean(attributeValue));
        }
        if (attributeValue2 != null) {
            builder.setIbb(ParserUtils.parseXmlBoolean(attributeValue2));
        }
        if (attributeValue3 != null) {
            builder.setJingle(ParserUtils.parseXmlBoolean(attributeValue3));
        }
        String attributeValue4 = xmlPullParser.getAttributeValue("", ATTRIBUTE_MAX_CHUNK_SIZE);
        if (attributeValue4 != null) {
            builder.setMaxChunkSize(Integer.parseInt(attributeValue4));
        }
        builder.setHeaders(parseHeaders(xmlPullParser));
        builder.setData(parseData(xmlPullParser));
        return builder.build();
    }
}
