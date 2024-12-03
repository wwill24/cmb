package org.jivesoftware.smackx.mood.provider;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.parsing.SmackParsingException;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smack.provider.ProviderManager;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.mood.Mood;
import org.jivesoftware.smackx.mood.element.MoodConcretisation;
import org.jivesoftware.smackx.mood.element.MoodElement;

public class MoodProvider extends ExtensionElementProvider<MoodElement> {
    public static final MoodProvider INSTANCE = new MoodProvider();
    private static final Logger LOGGER = Logger.getLogger(MoodProvider.class.getName());

    /* renamed from: org.jivesoftware.smackx.mood.provider.MoodProvider$1  reason: invalid class name */
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
            throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smackx.mood.provider.MoodProvider.AnonymousClass1.<clinit>():void");
        }
    }

    public MoodElement parse(XmlPullParser xmlPullParser, int i10, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException, SmackParsingException {
        MoodElement.MoodSubjectElement moodSubjectElement = null;
        Mood mood = null;
        MoodConcretisation moodConcretisation = null;
        String str = null;
        while (true) {
            int i11 = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event[xmlPullParser.next().ordinal()];
            if (i11 != 1) {
                if (i11 == 2 && MoodElement.ELEMENT.equals(xmlPullParser.getName())) {
                    break;
                }
            } else {
                String name = xmlPullParser.getName();
                String namespace = xmlPullParser.getNamespace();
                if ("text".equals(name)) {
                    str = xmlPullParser.nextText();
                } else if (!"http://jabber.org/protocol/mood".equals(namespace)) {
                    Logger logger = LOGGER;
                    Level level = Level.FINE;
                    logger.log(level, "Foreign namespace " + namespace + " detected. Try to find suitable MoodConcretisationProvider.");
                    MoodConcretisationProvider moodConcretisationProvider = (MoodConcretisationProvider) ProviderManager.getExtensionProvider(name, namespace);
                    if (moodConcretisationProvider != null) {
                        moodConcretisation = (MoodConcretisation) moodConcretisationProvider.parse(xmlPullParser);
                    } else {
                        logger.log(level, "No provider for <" + name + " xmlns:'" + namespace + "'/> found. Ignore.");
                    }
                } else {
                    try {
                        mood = Mood.valueOf(name);
                    } catch (IllegalArgumentException unused) {
                        throw new XmlPullParserException("Unknown mood value: " + name + " encountered.");
                    }
                }
            }
        }
        if (!(mood == null && moodConcretisation == null)) {
            moodSubjectElement = new MoodElement.MoodSubjectElement(mood, moodConcretisation);
        }
        return new MoodElement(moodSubjectElement, str);
    }
}
