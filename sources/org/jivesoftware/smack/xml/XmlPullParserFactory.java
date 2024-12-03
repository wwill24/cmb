package org.jivesoftware.smack.xml;

import java.io.Reader;

public interface XmlPullParserFactory {
    XmlPullParser newXmlPullParser(Reader reader) throws XmlPullParserException;
}
