package org.jivesoftware.smackx.eme.provider;

import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smackx.eme.element.ExplicitMessageEncryptionElement;

public class ExplicitMessageEncryptionProvider extends ExtensionElementProvider<ExplicitMessageEncryptionElement> {
    public ExplicitMessageEncryptionElement parse(XmlPullParser xmlPullParser, int i10, XmlEnvironment xmlEnvironment) {
        return new ExplicitMessageEncryptionElement(xmlPullParser.getAttributeValue((String) null, "namespace"), xmlPullParser.getAttributeValue((String) null, "name"));
    }
}
