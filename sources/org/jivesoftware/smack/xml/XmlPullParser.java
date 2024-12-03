package org.jivesoftware.smack.xml;

import java.io.IOException;
import javax.xml.namespace.QName;

public interface XmlPullParser {

    public enum Event {
        START_DOCUMENT,
        END_DOCUMENT,
        START_ELEMENT,
        END_ELEMENT,
        TEXT_CHARACTERS,
        PROCESSING_INSTRUCTION,
        COMMENT,
        IGNORABLE_WHITESPACE,
        ENTITY_REFERENCE,
        OTHER
    }

    public enum TagEvent {
        START_ELEMENT,
        END_ELEMENT
    }

    int getAttributeCount();

    String getAttributeName(int i10);

    String getAttributeNamespace(int i10);

    String getAttributePrefix(int i10);

    QName getAttributeQName(int i10);

    String getAttributeType(int i10);

    String getAttributeValue(int i10);

    String getAttributeValue(String str) {
        return getAttributeValue((String) null, str);
    }

    String getAttributeValue(String str, String str2);

    int getColumnNumber();

    String getDefaultNamespace() {
        return getNamespace((String) null);
    }

    int getDepth();

    Event getEventType() throws XmlPullParserException;

    String getInputEncoding();

    int getLineNumber();

    String getName();

    String getNamespace();

    String getNamespace(String str);

    int getNamespaceCount() throws XmlPullParserException;

    String getNamespacePrefix(int i10) throws XmlPullParserException;

    String getNamespaceUri(int i10) throws XmlPullParserException;

    String getPositionDescription();

    String getPrefix();

    Object getProperty(String str);

    QName getQName();

    String getText();

    boolean isWhiteSpace() throws XmlPullParserException;

    Event next() throws IOException, XmlPullParserException;

    TagEvent nextTag() throws IOException, XmlPullParserException;

    String nextText() throws IOException, XmlPullParserException;

    boolean supportsRoundtrip();
}
