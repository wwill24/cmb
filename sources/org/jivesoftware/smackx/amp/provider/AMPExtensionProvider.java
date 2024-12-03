package org.jivesoftware.smackx.amp.provider;

import java.util.logging.Logger;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smackx.amp.AMPDeliverCondition;
import org.jivesoftware.smackx.amp.AMPExpireAtCondition;
import org.jivesoftware.smackx.amp.AMPMatchResourceCondition;
import org.jivesoftware.smackx.amp.packet.AMPExtension;

public class AMPExtensionProvider extends ExtensionElementProvider<AMPExtension> {
    private static final Logger LOGGER = Logger.getLogger(AMPExtensionProvider.class.getName());

    private static AMPExtension.Condition createCondition(String str, String str2) {
        if (str == null || str2 == null) {
            LOGGER.severe("Can't create rule condition from null name and/or value");
            return null;
        } else if (AMPDeliverCondition.NAME.equals(str)) {
            try {
                return new AMPDeliverCondition(AMPDeliverCondition.Value.valueOf(str2));
            } catch (IllegalArgumentException unused) {
                Logger logger = LOGGER;
                logger.severe("Found invalid rule delivery condition value " + str2);
                return null;
            }
        } else if (AMPExpireAtCondition.NAME.equals(str)) {
            return new AMPExpireAtCondition(str2);
        } else {
            if (AMPMatchResourceCondition.NAME.equals(str)) {
                try {
                    return new AMPMatchResourceCondition(AMPMatchResourceCondition.Value.valueOf(str2));
                } catch (IllegalArgumentException unused2) {
                    Logger logger2 = LOGGER;
                    logger2.severe("Found invalid rule match-resource condition value " + str2);
                    return null;
                }
            } else {
                Logger logger3 = LOGGER;
                logger3.severe("Found unknown rule condition name " + str);
                return null;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x003e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.jivesoftware.smackx.amp.packet.AMPExtension parse(org.jivesoftware.smack.xml.XmlPullParser r7, int r8, org.jivesoftware.smack.packet.XmlEnvironment r9) throws org.jivesoftware.smack.xml.XmlPullParserException, java.io.IOException {
        /*
            r6 = this;
            r8 = 0
            java.lang.String r9 = "from"
            java.lang.String r9 = r7.getAttributeValue(r8, r9)
            java.lang.String r0 = "to"
            java.lang.String r0 = r7.getAttributeValue(r8, r0)
            java.lang.String r1 = "status"
            java.lang.String r1 = r7.getAttributeValue(r8, r1)
            if (r1 == 0) goto L_0x0030
            org.jivesoftware.smackx.amp.packet.AMPExtension$Status r1 = org.jivesoftware.smackx.amp.packet.AMPExtension.Status.valueOf(r1)     // Catch:{ IllegalArgumentException -> 0x001a }
            goto L_0x0031
        L_0x001a:
            java.util.logging.Logger r2 = LOGGER
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Found invalid amp status "
            r3.append(r4)
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r2.severe(r1)
        L_0x0030:
            r1 = r8
        L_0x0031:
            org.jivesoftware.smackx.amp.packet.AMPExtension r2 = new org.jivesoftware.smackx.amp.packet.AMPExtension
            r2.<init>(r9, r0, r1)
            java.lang.String r9 = "per-hop"
            java.lang.String r9 = r7.getAttributeValue(r8, r9)
            if (r9 == 0) goto L_0x0045
            boolean r9 = java.lang.Boolean.parseBoolean(r9)
            r2.setPerHop(r9)
        L_0x0045:
            r9 = 0
        L_0x0046:
            if (r9 != 0) goto L_0x00b8
            org.jivesoftware.smack.xml.XmlPullParser$Event r0 = r7.next()
            org.jivesoftware.smack.xml.XmlPullParser$Event r1 = org.jivesoftware.smack.xml.XmlPullParser.Event.START_ELEMENT
            if (r0 != r1) goto L_0x00a6
            java.lang.String r0 = r7.getName()
            java.lang.String r1 = "rule"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0046
            java.lang.String r0 = "action"
            java.lang.String r0 = r7.getAttributeValue(r8, r0)
            java.lang.String r1 = "condition"
            java.lang.String r1 = r7.getAttributeValue(r8, r1)
            java.lang.String r3 = "value"
            java.lang.String r3 = r7.getAttributeValue(r8, r3)
            org.jivesoftware.smackx.amp.packet.AMPExtension$Condition r1 = createCondition(r1, r3)
            if (r0 == 0) goto L_0x008f
            org.jivesoftware.smackx.amp.packet.AMPExtension$Action r0 = org.jivesoftware.smackx.amp.packet.AMPExtension.Action.valueOf(r0)     // Catch:{ IllegalArgumentException -> 0x0079 }
            goto L_0x0090
        L_0x0079:
            java.util.logging.Logger r3 = LOGGER
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "Found invalid rule action value "
            r4.append(r5)
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            r3.severe(r0)
        L_0x008f:
            r0 = r8
        L_0x0090:
            if (r0 == 0) goto L_0x009e
            if (r1 != 0) goto L_0x0095
            goto L_0x009e
        L_0x0095:
            org.jivesoftware.smackx.amp.packet.AMPExtension$Rule r3 = new org.jivesoftware.smackx.amp.packet.AMPExtension$Rule
            r3.<init>(r0, r1)
            r2.addRule(r3)
            goto L_0x0046
        L_0x009e:
            java.util.logging.Logger r0 = LOGGER
            java.lang.String r1 = "Rule is skipped because either it's action or it's condition is invalid"
            r0.severe(r1)
            goto L_0x0046
        L_0x00a6:
            org.jivesoftware.smack.xml.XmlPullParser$Event r1 = org.jivesoftware.smack.xml.XmlPullParser.Event.END_ELEMENT
            if (r0 != r1) goto L_0x0046
            java.lang.String r0 = r7.getName()
            java.lang.String r1 = "amp"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0046
            r9 = 1
            goto L_0x0046
        L_0x00b8:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smackx.amp.provider.AMPExtensionProvider.parse(org.jivesoftware.smack.xml.XmlPullParser, int, org.jivesoftware.smack.packet.XmlEnvironment):org.jivesoftware.smackx.amp.packet.AMPExtension");
    }
}
