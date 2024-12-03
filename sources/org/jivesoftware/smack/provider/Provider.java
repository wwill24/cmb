package org.jivesoftware.smack.provider;

import java.io.IOException;
import org.jivesoftware.smack.packet.Element;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.parsing.SmackParsingException;
import org.jivesoftware.smack.util.ParserUtils;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;

public abstract class Provider<E extends Element> extends AbstractProvider<E> {
    public final E parse(XmlPullParser xmlPullParser) throws IOException, XmlPullParserException, SmackParsingException {
        return parse(xmlPullParser, (XmlEnvironment) null);
    }

    public abstract E parse(XmlPullParser xmlPullParser, int i10, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException, SmackParsingException;

    public final E parse(XmlPullParser xmlPullParser, XmlEnvironment xmlEnvironment) throws IOException, XmlPullParserException, SmackParsingException {
        ParserUtils.assertAtStartTag(xmlPullParser);
        int depth = xmlPullParser.getDepth();
        E parse = parse(xmlPullParser, depth, XmlEnvironment.from(xmlPullParser, xmlEnvironment));
        ParserUtils.forwardToEndTagOfDepth(xmlPullParser, depth);
        return parse;
    }
}
