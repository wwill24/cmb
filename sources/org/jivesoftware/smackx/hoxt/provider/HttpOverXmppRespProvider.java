package org.jivesoftware.smackx.hoxt.provider;

import com.facebook.internal.ServerProtocol;
import java.io.IOException;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.parsing.SmackParsingException;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.hoxt.packet.HttpOverXmppResp;
import org.jivesoftware.smackx.shim.packet.HeadersExtension;

public class HttpOverXmppRespProvider extends AbstractHttpOverXmppProvider<HttpOverXmppResp> {
    private static final String ATTRIBUTE_STATUS_CODE = "statusCode";
    private static final String ATTRIBUTE_STATUS_MESSAGE = "statusMessage";

    public HttpOverXmppResp parse(XmlPullParser xmlPullParser, int i10, XmlEnvironment xmlEnvironment) throws IOException, XmlPullParserException, SmackParsingException {
        String attributeValue = xmlPullParser.getAttributeValue("", ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION);
        String attributeValue2 = xmlPullParser.getAttributeValue("", ATTRIBUTE_STATUS_MESSAGE);
        int parseInt = Integer.parseInt(xmlPullParser.getAttributeValue("", ATTRIBUTE_STATUS_CODE));
        HeadersExtension parseHeaders = parseHeaders(xmlPullParser);
        return ((HttpOverXmppResp.Builder) ((HttpOverXmppResp.Builder) ((HttpOverXmppResp.Builder) HttpOverXmppResp.builder().setHeaders(parseHeaders)).setData(parseData(xmlPullParser))).setStatusCode(parseInt).setStatusMessage(attributeValue2).setVersion(attributeValue)).build();
    }
}
