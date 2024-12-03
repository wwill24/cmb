package org.jivesoftware.smack.xml.xpp3;

import java.io.IOException;
import javax.xml.namespace.QName;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;

public final class Xpp3XmlPullParser implements XmlPullParser {
    private final org.xmlpull.v1.XmlPullParser xpp3XmlPullParser;

    public Xpp3XmlPullParser(org.xmlpull.v1.XmlPullParser xmlPullParser) {
        this.xpp3XmlPullParser = xmlPullParser;
    }

    private static String nullValueToDefaultPrefix(String str) {
        return str != null ? str : "";
    }

    private static XmlPullParser.Event xpp3EventIntegerToEvent(int i10) {
        switch (i10) {
            case 0:
                return XmlPullParser.Event.START_DOCUMENT;
            case 1:
                return XmlPullParser.Event.END_DOCUMENT;
            case 2:
                return XmlPullParser.Event.START_ELEMENT;
            case 3:
                return XmlPullParser.Event.END_ELEMENT;
            case 4:
                return XmlPullParser.Event.TEXT_CHARACTERS;
            case 5:
                return XmlPullParser.Event.OTHER;
            case 6:
                return XmlPullParser.Event.ENTITY_REFERENCE;
            case 7:
                return XmlPullParser.Event.IGNORABLE_WHITESPACE;
            case 8:
                return XmlPullParser.Event.PROCESSING_INSTRUCTION;
            case 9:
                return XmlPullParser.Event.COMMENT;
            case 10:
                return XmlPullParser.Event.OTHER;
            default:
                throw new IllegalArgumentException("Unknown XPP3 event integer: " + i10);
        }
    }

    public int getAttributeCount() {
        return this.xpp3XmlPullParser.getAttributeCount();
    }

    public String getAttributeName(int i10) {
        try {
            return this.xpp3XmlPullParser.getAttributeName(i10);
        } catch (IndexOutOfBoundsException unused) {
            return null;
        }
    }

    public String getAttributeNamespace(int i10) {
        try {
            String attributeNamespace = this.xpp3XmlPullParser.getAttributeNamespace(i10);
            if ("".equals(attributeNamespace)) {
                return null;
            }
            return attributeNamespace;
        } catch (IndexOutOfBoundsException unused) {
            return null;
        }
    }

    public String getAttributePrefix(int i10) {
        try {
            return nullValueToDefaultPrefix(this.xpp3XmlPullParser.getAttributePrefix(i10));
        } catch (IndexOutOfBoundsException unused) {
            return null;
        }
    }

    public QName getAttributeQName(int i10) {
        String attributeName = getAttributeName(i10);
        if (attributeName == null) {
            return null;
        }
        return new QName(getAttributeNamespace(i10), attributeName, nullValueToDefaultPrefix(getAttributePrefix(i10)));
    }

    public String getAttributeType(int i10) {
        try {
            return this.xpp3XmlPullParser.getAttributeType(i10);
        } catch (IndexOutOfBoundsException unused) {
            return null;
        }
    }

    public String getAttributeValue(int i10) {
        return this.xpp3XmlPullParser.getAttributeValue(i10);
    }

    public int getColumnNumber() {
        return this.xpp3XmlPullParser.getColumnNumber();
    }

    public int getDepth() {
        return this.xpp3XmlPullParser.getDepth();
    }

    public XmlPullParser.Event getEventType() throws XmlPullParserException {
        try {
            return xpp3EventIntegerToEvent(this.xpp3XmlPullParser.getEventType());
        } catch (org.xmlpull.v1.XmlPullParserException e10) {
            throw new XmlPullParserException((Exception) e10);
        }
    }

    public String getInputEncoding() {
        return this.xpp3XmlPullParser.getInputEncoding();
    }

    public int getLineNumber() {
        return this.xpp3XmlPullParser.getLineNumber();
    }

    public String getName() {
        return this.xpp3XmlPullParser.getName();
    }

    public String getNamespace(String str) {
        return this.xpp3XmlPullParser.getNamespace(str);
    }

    public int getNamespaceCount() throws XmlPullParserException {
        try {
            return this.xpp3XmlPullParser.getNamespaceCount(this.xpp3XmlPullParser.getDepth());
        } catch (org.xmlpull.v1.XmlPullParserException e10) {
            throw new XmlPullParserException((Exception) e10);
        }
    }

    public String getNamespacePrefix(int i10) throws XmlPullParserException {
        try {
            return this.xpp3XmlPullParser.getNamespacePrefix(i10);
        } catch (org.xmlpull.v1.XmlPullParserException e10) {
            throw new XmlPullParserException((Exception) e10);
        }
    }

    public String getNamespaceUri(int i10) throws XmlPullParserException {
        try {
            return this.xpp3XmlPullParser.getNamespaceUri(i10);
        } catch (org.xmlpull.v1.XmlPullParserException e10) {
            throw new XmlPullParserException((Exception) e10);
        }
    }

    public String getPositionDescription() {
        return this.xpp3XmlPullParser.getPositionDescription();
    }

    public String getPrefix() {
        return this.xpp3XmlPullParser.getPrefix();
    }

    public Object getProperty(String str) {
        return this.xpp3XmlPullParser.getProperty(str);
    }

    public QName getQName() {
        return new QName(this.xpp3XmlPullParser.getNamespace(), this.xpp3XmlPullParser.getName(), nullValueToDefaultPrefix(this.xpp3XmlPullParser.getPrefix()));
    }

    public String getText() {
        return this.xpp3XmlPullParser.getText();
    }

    public boolean isWhiteSpace() throws XmlPullParserException {
        try {
            return this.xpp3XmlPullParser.isWhitespace();
        } catch (org.xmlpull.v1.XmlPullParserException e10) {
            throw new XmlPullParserException((Exception) e10);
        }
    }

    public XmlPullParser.Event next() throws IOException, XmlPullParserException {
        try {
            return xpp3EventIntegerToEvent(this.xpp3XmlPullParser.next());
        } catch (org.xmlpull.v1.XmlPullParserException e10) {
            throw new XmlPullParserException((Exception) e10);
        }
    }

    public XmlPullParser.TagEvent nextTag() throws IOException, XmlPullParserException {
        try {
            int nextTag = this.xpp3XmlPullParser.nextTag();
            if (nextTag == 2) {
                return XmlPullParser.TagEvent.START_ELEMENT;
            }
            if (nextTag == 3) {
                return XmlPullParser.TagEvent.END_ELEMENT;
            }
            throw new AssertionError();
        } catch (org.xmlpull.v1.XmlPullParserException e10) {
            throw new XmlPullParserException((Exception) e10);
        }
    }

    public String nextText() throws IOException, XmlPullParserException {
        try {
            return this.xpp3XmlPullParser.nextText();
        } catch (org.xmlpull.v1.XmlPullParserException e10) {
            throw new XmlPullParserException((Exception) e10);
        }
    }

    public boolean supportsRoundtrip() {
        return this.xpp3XmlPullParser.getFeature(Xpp3XmlPullParserFactory.FEATURE_XML_ROUNDTRIP);
    }

    public String getAttributeValue(String str, String str2) {
        return this.xpp3XmlPullParser.getAttributeValue(str, str2);
    }

    public String getNamespace() {
        return this.xpp3XmlPullParser.getNamespace();
    }
}
