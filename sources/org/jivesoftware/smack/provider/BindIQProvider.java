package org.jivesoftware.smack.provider;

import java.io.IOException;
import org.jivesoftware.smack.packet.Bind;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jxmpp.jid.impl.a;
import org.jxmpp.jid.parts.Resourcepart;

public class BindIQProvider extends IQProvider<Bind> {

    /* renamed from: org.jivesoftware.smack.provider.BindIQProvider$1  reason: invalid class name */
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
            throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smack.provider.BindIQProvider.AnonymousClass1.<clinit>():void");
        }
    }

    public Bind parse(XmlPullParser xmlPullParser, int i10, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException {
        Bind bind = null;
        while (true) {
            int i11 = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event[xmlPullParser.next().ordinal()];
            if (i11 == 1) {
                String name = xmlPullParser.getName();
                name.hashCode();
                if (name.equals("resource")) {
                    bind = Bind.newSet(Resourcepart.b(xmlPullParser.nextText()));
                } else if (name.equals("jid")) {
                    bind = Bind.newResult(a.j(xmlPullParser.nextText()));
                }
            } else if (i11 == 2 && xmlPullParser.getDepth() == i10) {
                return bind;
            }
        }
    }
}
