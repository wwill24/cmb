package org.jivesoftware.smackx.geoloc.provider;

import java.io.IOException;
import javax.xml.namespace.QName;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.parsing.SmackParsingException;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smack.util.ParserUtils;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.geoloc.packet.GeoLocation;
import org.jivesoftware.smackx.xdata.provider.FormFieldChildElementProvider;

public class GeoLocationProvider extends ExtensionElementProvider<GeoLocation> {
    public static final GeoLocationProvider INSTANCE = new GeoLocationProvider();

    /* renamed from: org.jivesoftware.smackx.geoloc.provider.GeoLocationProvider$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                org.jivesoftware.smack.xml.XmlPullParser$Event[] r0 = org.jivesoftware.smack.xml.XmlPullParser.Event.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event = r0
                org.jivesoftware.smack.xml.XmlPullParser$Event r1 = org.jivesoftware.smack.xml.XmlPullParser.Event.START_ELEMENT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event     // Catch:{ NoSuchFieldError -> 0x001d }
                org.jivesoftware.smack.xml.XmlPullParser$Event r1 = org.jivesoftware.smack.xml.XmlPullParser.Event.END_ELEMENT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smackx.geoloc.provider.GeoLocationProvider.AnonymousClass1.<clinit>():void");
        }
    }

    public static class GeoLocationFormFieldChildElementProvider extends FormFieldChildElementProvider<GeoLocation> {
        public static final GeoLocationFormFieldChildElementProvider INSTANCE = new GeoLocationFormFieldChildElementProvider();

        public QName getQName() {
            return GeoLocation.QNAME;
        }

        public GeoLocation parse(XmlPullParser xmlPullParser, int i10, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException, SmackParsingException {
            return GeoLocationProvider.INSTANCE.parse(xmlPullParser, i10, xmlEnvironment);
        }
    }

    private static void parseError(GeoLocation.Builder builder, XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        builder.setError(Double.valueOf(ParserUtils.getDoubleFromNextText(xmlPullParser)));
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x014c, code lost:
        if (r0.equals("countrycode") == false) goto L_0x0031;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.jivesoftware.smackx.geoloc.packet.GeoLocation parse(org.jivesoftware.smack.xml.XmlPullParser r6, int r7, org.jivesoftware.smack.packet.XmlEnvironment r8) throws org.jivesoftware.smack.xml.XmlPullParserException, java.io.IOException, org.jivesoftware.smack.parsing.SmackParsingException.SmackTextParseException, org.jivesoftware.smack.parsing.SmackParsingException.SmackUriSyntaxParsingException {
        /*
            r5 = this;
            org.jivesoftware.smackx.geoloc.packet.GeoLocation$Builder r8 = org.jivesoftware.smackx.geoloc.packet.GeoLocation.builder()
        L_0x0004:
            org.jivesoftware.smack.xml.XmlPullParser$Event r0 = r6.next()
            int[] r1 = org.jivesoftware.smackx.geoloc.provider.GeoLocationProvider.AnonymousClass1.$SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event
            int r0 = r0.ordinal()
            r0 = r1[r0]
            r1 = 2
            r2 = 1
            if (r0 == r2) goto L_0x0022
            if (r0 == r1) goto L_0x0017
            goto L_0x0004
        L_0x0017:
            int r0 = r6.getDepth()
            if (r0 != r7) goto L_0x0004
            org.jivesoftware.smackx.geoloc.packet.GeoLocation r6 = r8.build()
            return r6
        L_0x0022:
            java.lang.String r0 = r6.getName()
            r0.hashCode()
            r3 = -1
            int r4 = r0.hashCode()
            switch(r4) {
                case -2131707655: goto L_0x015c;
                case -1724546052: goto L_0x0150;
                case -1476113789: goto L_0x0146;
                case -1430646092: goto L_0x013a;
                case -934795532: goto L_0x012e;
                case -891990013: goto L_0x0122;
                case -234326098: goto L_0x0116;
                case 96681: goto L_0x010a;
                case 106911: goto L_0x00fd;
                case 107339: goto L_0x00ef;
                case 115369: goto L_0x00e1;
                case 116076: goto L_0x00d3;
                case 3002509: goto L_0x00c5;
                case 3506395: goto L_0x00b7;
                case 3556653: goto L_0x00a9;
                case 55126294: goto L_0x009c;
                case 95357039: goto L_0x008f;
                case 96784904: goto L_0x0082;
                case 97526796: goto L_0x0075;
                case 109641799: goto L_0x0068;
                case 697727394: goto L_0x005b;
                case 957831062: goto L_0x004e;
                case 1900805475: goto L_0x0041;
                case 2012106040: goto L_0x0034;
                default: goto L_0x0031;
            }
        L_0x0031:
            r1 = r3
            goto L_0x0167
        L_0x0034:
            java.lang.String r1 = "postalcode"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x003d
            goto L_0x0031
        L_0x003d:
            r1 = 23
            goto L_0x0167
        L_0x0041:
            java.lang.String r1 = "locality"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x004a
            goto L_0x0031
        L_0x004a:
            r1 = 22
            goto L_0x0167
        L_0x004e:
            java.lang.String r1 = "country"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0057
            goto L_0x0031
        L_0x0057:
            r1 = 21
            goto L_0x0167
        L_0x005b:
            java.lang.String r1 = "altaccuracy"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0064
            goto L_0x0031
        L_0x0064:
            r1 = 20
            goto L_0x0167
        L_0x0068:
            java.lang.String r1 = "speed"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0071
            goto L_0x0031
        L_0x0071:
            r1 = 19
            goto L_0x0167
        L_0x0075:
            java.lang.String r1 = "floor"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x007e
            goto L_0x0031
        L_0x007e:
            r1 = 18
            goto L_0x0167
        L_0x0082:
            java.lang.String r1 = "error"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x008b
            goto L_0x0031
        L_0x008b:
            r1 = 17
            goto L_0x0167
        L_0x008f:
            java.lang.String r1 = "datum"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0098
            goto L_0x0031
        L_0x0098:
            r1 = 16
            goto L_0x0167
        L_0x009c:
            java.lang.String r1 = "timestamp"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x00a5
            goto L_0x0031
        L_0x00a5:
            r1 = 15
            goto L_0x0167
        L_0x00a9:
            java.lang.String r1 = "text"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x00b3
            goto L_0x0031
        L_0x00b3:
            r1 = 14
            goto L_0x0167
        L_0x00b7:
            java.lang.String r1 = "room"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x00c1
            goto L_0x0031
        L_0x00c1:
            r1 = 13
            goto L_0x0167
        L_0x00c5:
            java.lang.String r1 = "area"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x00cf
            goto L_0x0031
        L_0x00cf:
            r1 = 12
            goto L_0x0167
        L_0x00d3:
            java.lang.String r1 = "uri"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x00dd
            goto L_0x0031
        L_0x00dd:
            r1 = 11
            goto L_0x0167
        L_0x00e1:
            java.lang.String r1 = "tzo"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x00eb
            goto L_0x0031
        L_0x00eb:
            r1 = 10
            goto L_0x0167
        L_0x00ef:
            java.lang.String r1 = "lon"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x00f9
            goto L_0x0031
        L_0x00f9:
            r1 = 9
            goto L_0x0167
        L_0x00fd:
            java.lang.String r1 = "lat"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0107
            goto L_0x0031
        L_0x0107:
            r1 = 8
            goto L_0x0167
        L_0x010a:
            java.lang.String r1 = "alt"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0114
            goto L_0x0031
        L_0x0114:
            r1 = 7
            goto L_0x0167
        L_0x0116:
            java.lang.String r1 = "bearing"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0120
            goto L_0x0031
        L_0x0120:
            r1 = 6
            goto L_0x0167
        L_0x0122:
            java.lang.String r1 = "street"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x012c
            goto L_0x0031
        L_0x012c:
            r1 = 5
            goto L_0x0167
        L_0x012e:
            java.lang.String r1 = "region"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0138
            goto L_0x0031
        L_0x0138:
            r1 = 4
            goto L_0x0167
        L_0x013a:
            java.lang.String r1 = "building"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0144
            goto L_0x0031
        L_0x0144:
            r1 = 3
            goto L_0x0167
        L_0x0146:
            java.lang.String r2 = "countrycode"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x0167
            goto L_0x0031
        L_0x0150:
            java.lang.String r1 = "description"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x015a
            goto L_0x0031
        L_0x015a:
            r1 = r2
            goto L_0x0167
        L_0x015c:
            java.lang.String r1 = "accuracy"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0166
            goto L_0x0031
        L_0x0166:
            r1 = 0
        L_0x0167:
            switch(r1) {
                case 0: goto L_0x024f;
                case 1: goto L_0x0246;
                case 2: goto L_0x023d;
                case 3: goto L_0x0234;
                case 4: goto L_0x022b;
                case 5: goto L_0x0222;
                case 6: goto L_0x0215;
                case 7: goto L_0x0208;
                case 8: goto L_0x01fb;
                case 9: goto L_0x01ee;
                case 10: goto L_0x01e5;
                case 11: goto L_0x01dc;
                case 12: goto L_0x01d3;
                case 13: goto L_0x01ca;
                case 14: goto L_0x01c1;
                case 15: goto L_0x01b8;
                case 16: goto L_0x01af;
                case 17: goto L_0x01aa;
                case 18: goto L_0x01a1;
                case 19: goto L_0x0194;
                case 20: goto L_0x0187;
                case 21: goto L_0x017e;
                case 22: goto L_0x0175;
                case 23: goto L_0x016c;
                default: goto L_0x016a;
            }
        L_0x016a:
            goto L_0x0004
        L_0x016c:
            java.lang.String r0 = r6.nextText()
            r8.setPostalcode(r0)
            goto L_0x0004
        L_0x0175:
            java.lang.String r0 = r6.nextText()
            r8.setLocality(r0)
            goto L_0x0004
        L_0x017e:
            java.lang.String r0 = r6.nextText()
            r8.setCountry(r0)
            goto L_0x0004
        L_0x0187:
            double r0 = org.jivesoftware.smack.util.ParserUtils.getDoubleFromNextText(r6)
            java.lang.Double r0 = java.lang.Double.valueOf(r0)
            r8.setAltAccuracy(r0)
            goto L_0x0004
        L_0x0194:
            double r0 = org.jivesoftware.smack.util.ParserUtils.getDoubleFromNextText(r6)
            java.lang.Double r0 = java.lang.Double.valueOf(r0)
            r8.setSpeed(r0)
            goto L_0x0004
        L_0x01a1:
            java.lang.String r0 = r6.nextText()
            r8.setFloor(r0)
            goto L_0x0004
        L_0x01aa:
            parseError(r8, r6)
            goto L_0x0004
        L_0x01af:
            java.lang.String r0 = r6.nextText()
            r8.setDatum(r0)
            goto L_0x0004
        L_0x01b8:
            java.util.Date r0 = org.jivesoftware.smack.util.ParserUtils.getDateFromNextText(r6)
            r8.setTimestamp(r0)
            goto L_0x0004
        L_0x01c1:
            java.lang.String r0 = r6.nextText()
            r8.setText(r0)
            goto L_0x0004
        L_0x01ca:
            java.lang.String r0 = r6.nextText()
            r8.setRoom(r0)
            goto L_0x0004
        L_0x01d3:
            java.lang.String r0 = r6.nextText()
            r8.setArea(r0)
            goto L_0x0004
        L_0x01dc:
            java.net.URI r0 = org.jivesoftware.smack.util.ParserUtils.getUriFromNextText(r6)
            r8.setUri(r0)
            goto L_0x0004
        L_0x01e5:
            java.lang.String r0 = r6.nextText()
            r8.setTzo(r0)
            goto L_0x0004
        L_0x01ee:
            double r0 = org.jivesoftware.smack.util.ParserUtils.getDoubleFromNextText(r6)
            java.lang.Double r0 = java.lang.Double.valueOf(r0)
            r8.setLon(r0)
            goto L_0x0004
        L_0x01fb:
            double r0 = org.jivesoftware.smack.util.ParserUtils.getDoubleFromNextText(r6)
            java.lang.Double r0 = java.lang.Double.valueOf(r0)
            r8.setLat(r0)
            goto L_0x0004
        L_0x0208:
            double r0 = org.jivesoftware.smack.util.ParserUtils.getDoubleFromNextText(r6)
            java.lang.Double r0 = java.lang.Double.valueOf(r0)
            r8.setAlt(r0)
            goto L_0x0004
        L_0x0215:
            double r0 = org.jivesoftware.smack.util.ParserUtils.getDoubleFromNextText(r6)
            java.lang.Double r0 = java.lang.Double.valueOf(r0)
            r8.setBearing(r0)
            goto L_0x0004
        L_0x0222:
            java.lang.String r0 = r6.nextText()
            r8.setStreet(r0)
            goto L_0x0004
        L_0x022b:
            java.lang.String r0 = r6.nextText()
            r8.setRegion(r0)
            goto L_0x0004
        L_0x0234:
            java.lang.String r0 = r6.nextText()
            r8.setBuilding(r0)
            goto L_0x0004
        L_0x023d:
            java.lang.String r0 = r6.nextText()
            r8.setCountryCode(r0)
            goto L_0x0004
        L_0x0246:
            java.lang.String r0 = r6.nextText()
            r8.setDescription(r0)
            goto L_0x0004
        L_0x024f:
            double r0 = org.jivesoftware.smack.util.ParserUtils.getDoubleFromNextText(r6)
            java.lang.Double r0 = java.lang.Double.valueOf(r0)
            r8.setAccuracy(r0)
            goto L_0x0004
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smackx.geoloc.provider.GeoLocationProvider.parse(org.jivesoftware.smack.xml.XmlPullParser, int, org.jivesoftware.smack.packet.XmlEnvironment):org.jivesoftware.smackx.geoloc.packet.GeoLocation");
    }
}
