package org.jivesoftware.smack.provider;

import java.io.IOException;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.IqData;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.parsing.SmackParsingException;
import org.jivesoftware.smack.util.ParserUtils;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;

public abstract class IQProvider<I extends IQ> extends C0522IqProvider<I> {
    public final I parse(XmlPullParser xmlPullParser) throws IOException, XmlPullParserException, SmackParsingException {
        return parse(xmlPullParser, (XmlEnvironment) null);
    }

    public abstract I parse(XmlPullParser xmlPullParser, int i10, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException, SmackParsingException;

    public final I parse(XmlPullParser xmlPullParser, XmlEnvironment xmlEnvironment) throws IOException, XmlPullParserException, SmackParsingException {
        ParserUtils.assertAtStartTag(xmlPullParser);
        int depth = xmlPullParser.getDepth();
        I parse = parse(xmlPullParser, depth, XmlEnvironment.from(xmlPullParser, xmlEnvironment));
        ParserUtils.forwardToEndTagOfDepth(xmlPullParser, depth);
        return parse;
    }

    public final I parse(XmlPullParser xmlPullParser, int i10, IqData iqData, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException, SmackParsingException {
        return parse(xmlPullParser, i10, xmlEnvironment);
    }
}
