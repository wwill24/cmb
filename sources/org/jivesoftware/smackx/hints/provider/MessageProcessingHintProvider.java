package org.jivesoftware.smackx.hints.provider;

import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smackx.hints.element.MessageProcessingHint;

public abstract class MessageProcessingHintProvider<H extends MessageProcessingHint> extends ExtensionElementProvider<H> {
    /* access modifiers changed from: protected */
    public abstract H getHint();

    public H parse(XmlPullParser xmlPullParser, int i10, XmlEnvironment xmlEnvironment) {
        return getHint();
    }
}
