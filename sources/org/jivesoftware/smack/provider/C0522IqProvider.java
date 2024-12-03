package org.jivesoftware.smack.provider;

import java.io.IOException;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.IqData;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.parsing.SmackParsingException;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;

/* renamed from: org.jivesoftware.smack.provider.IqProvider  reason: case insensitive filesystem */
public abstract class C0522IqProvider<I extends IQ> extends AbstractProvider<I> {
    public abstract I parse(XmlPullParser xmlPullParser, int i10, IqData iqData, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException, SmackParsingException;

    public final I parse(XmlPullParser xmlPullParser, IqData iqData) throws XmlPullParserException, IOException, SmackParsingException {
        return parse(xmlPullParser, iqData, (XmlEnvironment) null);
    }

    public final I parse(XmlPullParser xmlPullParser, IqData iqData, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException, SmackParsingException {
        return parse(xmlPullParser, xmlPullParser.getDepth(), iqData, XmlEnvironment.from(xmlPullParser, xmlEnvironment));
    }
}
