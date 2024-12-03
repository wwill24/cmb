package org.jivesoftware.smackx.mood.provider;

import java.io.IOException;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.mood.element.MoodConcretisation;

public abstract class SimpleMoodConcretisationProvider<C extends MoodConcretisation> extends MoodConcretisationProvider<C> {
    /* access modifiers changed from: protected */
    public abstract C simpleExtension();

    public C parse(XmlPullParser xmlPullParser, int i10, XmlEnvironment xmlEnvironment) throws IOException, XmlPullParserException {
        return simpleExtension();
    }
}
