package org.jivesoftware.smack.util;

import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.ServerProtocol;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;
import javax.xml.namespace.QName;
import org.apache.commons.beanutils.PropertyUtils;
import org.jivesoftware.smack.datatypes.UInt16;
import org.jivesoftware.smack.datatypes.UInt32;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.parsing.SmackParsingException;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jxmpp.jid.EntityBareJid;
import org.jxmpp.jid.EntityFullJid;
import org.jxmpp.jid.EntityJid;
import org.jxmpp.jid.Jid;
import org.jxmpp.jid.impl.a;
import org.jxmpp.jid.parts.Resourcepart;
import org.jxmpp.stringprep.XmppStringprepException;
import org.jxmpp.util.XmppDateTime;

public class ParserUtils {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final String JID = "jid";

    public static void assertAtEndTag(XmlPullParser xmlPullParser) throws XmlPullParserException {
    }

    public static void assertAtStartTag(XmlPullParser xmlPullParser) throws XmlPullParserException {
    }

    public static void assertAtStartTag(XmlPullParser xmlPullParser, String str) throws XmlPullParserException {
        assertAtStartTag(xmlPullParser);
    }

    public static void forwardToEndTagOfDepth(XmlPullParser xmlPullParser, int i10) throws XmlPullParserException, IOException {
        XmlPullParser.Event eventType = xmlPullParser.getEventType();
        while (true) {
            if (eventType != XmlPullParser.Event.END_ELEMENT || xmlPullParser.getDepth() != i10) {
                eventType = xmlPullParser.next();
            } else {
                return;
            }
        }
    }

    public static void forwardToStartElement(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        XmlPullParser.Event eventType = xmlPullParser.getEventType();
        while (eventType != XmlPullParser.Event.START_ELEMENT) {
            if (eventType != XmlPullParser.Event.END_DOCUMENT) {
                eventType = xmlPullParser.next();
            } else {
                throw new IllegalArgumentException("Document contains no start tag");
            }
        }
    }

    public static EntityBareJid getBareJidAttribute(XmlPullParser xmlPullParser) throws XmppStringprepException {
        return getBareJidAttribute(xmlPullParser, "jid");
    }

    public static Boolean getBooleanAttribute(XmlPullParser xmlPullParser, String str) {
        String attributeValue = xmlPullParser.getAttributeValue("", str);
        if (attributeValue == null) {
            return null;
        }
        return Boolean.valueOf(parseXmlBoolean(attributeValue.toLowerCase(Locale.US)));
    }

    public static Byte getByteAttributeFromNextText(XmlPullParser xmlPullParser) throws IOException, XmlPullParserException {
        return Byte.valueOf(xmlPullParser.nextText());
    }

    public static Date getDateFromNextText(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException, SmackParsingException.SmackTextParseException {
        return getDateFromString(xmlPullParser.nextText());
    }

    public static Date getDateFromOptionalXep82String(String str) throws SmackParsingException.SmackTextParseException {
        if (str == null) {
            return null;
        }
        return getDateFromXep82String(str);
    }

    public static Date getDateFromString(String str) throws SmackParsingException.SmackTextParseException {
        try {
            return XmppDateTime.l(str);
        } catch (ParseException e10) {
            throw new SmackParsingException.SmackTextParseException(e10);
        }
    }

    public static Date getDateFromXep82String(String str) throws SmackParsingException.SmackTextParseException {
        try {
            return XmppDateTime.m(str);
        } catch (ParseException e10) {
            throw new SmackParsingException.SmackTextParseException(e10);
        }
    }

    public static Double getDoubleAttribute(XmlPullParser xmlPullParser, String str) {
        String attributeValue = xmlPullParser.getAttributeValue("", str);
        if (attributeValue == null) {
            return null;
        }
        return Double.valueOf(attributeValue);
    }

    public static double getDoubleFromNextText(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        return Double.valueOf(xmlPullParser.nextText()).doubleValue();
    }

    public static EntityJid getEntityJidAttribute(XmlPullParser xmlPullParser, String str) throws XmppStringprepException {
        String attributeValue = xmlPullParser.getAttributeValue("", str);
        if (attributeValue == null) {
            return null;
        }
        Jid o10 = a.o(attributeValue);
        if (!o10.E()) {
            return null;
        }
        EntityFullJid m12 = o10.m1();
        if (m12 != null) {
            return m12;
        }
        return o10.h1();
    }

    public static EntityFullJid getFullJidAttribute(XmlPullParser xmlPullParser) throws XmppStringprepException {
        return getFullJidAttribute(xmlPullParser, "jid");
    }

    public static Integer getIntegerAttribute(XmlPullParser xmlPullParser, String str) {
        String attributeValue = xmlPullParser.getAttributeValue("", str);
        if (attributeValue == null) {
            return null;
        }
        return Integer.valueOf(attributeValue);
    }

    public static int getIntegerAttributeOrThrow(XmlPullParser xmlPullParser, String str, String str2) throws IOException {
        Integer integerAttribute = getIntegerAttribute(xmlPullParser, str);
        if (integerAttribute != null) {
            return integerAttribute.intValue();
        }
        throw new IOException(str2);
    }

    public static int getIntegerFromNextText(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        return Integer.valueOf(xmlPullParser.nextText()).intValue();
    }

    public static Jid getJidAttribute(XmlPullParser xmlPullParser) throws XmppStringprepException {
        return getJidAttribute(xmlPullParser, "jid");
    }

    public static Long getLongAttribute(XmlPullParser xmlPullParser, String str) {
        String attributeValue = xmlPullParser.getAttributeValue("", str);
        if (attributeValue == null) {
            return null;
        }
        return Long.valueOf(attributeValue);
    }

    @Deprecated
    public static QName getQName(XmlPullParser xmlPullParser) {
        return xmlPullParser.getQName();
    }

    public static String getRequiredAttribute(XmlPullParser xmlPullParser, String str) throws IOException {
        String attributeValue = xmlPullParser.getAttributeValue("", str);
        if (!StringUtils.isNullOrEmpty((CharSequence) attributeValue)) {
            return attributeValue;
        }
        throw new IOException("Attribute " + str + " is null or empty (" + attributeValue + PropertyUtils.MAPPED_DELIM2);
    }

    public static String getRequiredNextText(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        String nextText = xmlPullParser.nextText();
        if (!StringUtils.isNullOrEmpty((CharSequence) nextText)) {
            return nextText;
        }
        throw new IOException("Next text is null or empty (" + nextText + PropertyUtils.MAPPED_DELIM2);
    }

    public static UInt16 getRequiredUInt16Attribute(XmlPullParser xmlPullParser, String str) throws SmackParsingException.RequiredAttributeMissingException {
        UInt16 uInt16Attribute = getUInt16Attribute(xmlPullParser, str);
        if (uInt16Attribute != null) {
            return uInt16Attribute;
        }
        throw new SmackParsingException.RequiredAttributeMissingException(str);
    }

    public static Resourcepart getResourcepartAttribute(XmlPullParser xmlPullParser, String str) throws XmppStringprepException {
        String attributeValue = xmlPullParser.getAttributeValue("", str);
        if (attributeValue == null) {
            return null;
        }
        return Resourcepart.b(attributeValue);
    }

    public static Short getShortAttribute(XmlPullParser xmlPullParser, String str) {
        String attributeValue = xmlPullParser.getAttributeValue("", str);
        if (attributeValue == null) {
            return null;
        }
        return Short.valueOf(attributeValue);
    }

    public static UInt16 getUInt16Attribute(XmlPullParser xmlPullParser, String str) {
        Integer integerAttribute = getIntegerAttribute(xmlPullParser, str);
        if (integerAttribute == null) {
            return null;
        }
        return UInt16.from(integerAttribute.intValue());
    }

    public static UInt32 getUInt32Attribute(XmlPullParser xmlPullParser, String str) {
        Long longAttribute = getLongAttribute(xmlPullParser, str);
        if (longAttribute == null) {
            return null;
        }
        return UInt32.from(longAttribute.longValue());
    }

    public static URI getUriFromNextText(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException, SmackParsingException.SmackUriSyntaxParsingException {
        try {
            return new URI(xmlPullParser.nextText());
        } catch (URISyntaxException e10) {
            throw new SmackParsingException.SmackUriSyntaxParsingException(e10);
        }
    }

    public static String getXmlLang(XmlPullParser xmlPullParser, XmlEnvironment xmlEnvironment) {
        String xmlLang = getXmlLang(xmlPullParser);
        if (xmlLang != null) {
            return xmlLang;
        }
        return xmlEnvironment.getEffectiveLanguage();
    }

    public static boolean parseXmlBoolean(String str) {
        str.hashCode();
        char c10 = 65535;
        switch (str.hashCode()) {
            case 48:
                if (str.equals("0")) {
                    c10 = 0;
                    break;
                }
                break;
            case 49:
                if (str.equals(AppEventsConstants.EVENT_PARAM_VALUE_YES)) {
                    c10 = 1;
                    break;
                }
                break;
            case 3569038:
                if (str.equals(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE)) {
                    c10 = 2;
                    break;
                }
                break;
            case 97196323:
                if (str.equals("false")) {
                    c10 = 3;
                    break;
                }
                break;
        }
        switch (c10) {
            case 0:
            case 3:
                return false;
            case 1:
            case 2:
                return true;
            default:
                throw new IllegalArgumentException(str + " is not a valid boolean string");
        }
    }

    public static EntityBareJid getBareJidAttribute(XmlPullParser xmlPullParser, String str) throws XmppStringprepException {
        String attributeValue = xmlPullParser.getAttributeValue("", str);
        if (attributeValue == null) {
            return null;
        }
        return a.h(attributeValue);
    }

    public static EntityFullJid getFullJidAttribute(XmlPullParser xmlPullParser, String str) throws XmppStringprepException {
        String attributeValue = xmlPullParser.getAttributeValue("", str);
        if (attributeValue == null) {
            return null;
        }
        return a.j(attributeValue);
    }

    public static Jid getJidAttribute(XmlPullParser xmlPullParser, String str) throws XmppStringprepException {
        String attributeValue = xmlPullParser.getAttributeValue("", str);
        if (attributeValue == null) {
            return null;
        }
        return a.o(attributeValue);
    }

    public static double getDoubleAttribute(XmlPullParser xmlPullParser, String str, long j10) {
        Double doubleAttribute = getDoubleAttribute(xmlPullParser, str);
        if (doubleAttribute == null) {
            return (double) j10;
        }
        return doubleAttribute.doubleValue();
    }

    public static int getIntegerAttribute(XmlPullParser xmlPullParser, String str, int i10) {
        Integer integerAttribute = getIntegerAttribute(xmlPullParser, str);
        if (integerAttribute == null) {
            return i10;
        }
        return integerAttribute.intValue();
    }

    public static long getLongAttribute(XmlPullParser xmlPullParser, String str, long j10) {
        Long longAttribute = getLongAttribute(xmlPullParser, str);
        if (longAttribute == null) {
            return j10;
        }
        return longAttribute.longValue();
    }

    public static short getShortAttribute(XmlPullParser xmlPullParser, String str, short s10) {
        Short shortAttribute = getShortAttribute(xmlPullParser, str);
        if (shortAttribute == null) {
            return s10;
        }
        return shortAttribute.shortValue();
    }

    public static String getXmlLang(XmlPullParser xmlPullParser) {
        return xmlPullParser.getAttributeValue("http://www.w3.org/XML/1998/namespace", "lang");
    }

    public static boolean getBooleanAttribute(XmlPullParser xmlPullParser, String str, boolean z10) {
        Boolean booleanAttribute = getBooleanAttribute(xmlPullParser, str);
        if (booleanAttribute == null) {
            return z10;
        }
        return booleanAttribute.booleanValue();
    }
}
