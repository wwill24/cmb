package org.jivesoftware.smackx.iqregister.provider;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.parsing.SmackParsingException;
import org.jivesoftware.smack.provider.IQProvider;
import org.jivesoftware.smack.util.PacketParserUtils;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.iqregister.packet.Registration;

public class RegistrationProvider extends IQProvider<Registration> {
    public Registration parse(XmlPullParser xmlPullParser, int i10, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException, SmackParsingException {
        HashMap hashMap = new HashMap();
        LinkedList linkedList = new LinkedList();
        String str = null;
        while (true) {
            XmlPullParser.Event next = xmlPullParser.next();
            if (next == XmlPullParser.Event.START_ELEMENT) {
                if (xmlPullParser.getNamespace().equals(Registration.NAMESPACE)) {
                    String name = xmlPullParser.getName();
                    String text = xmlPullParser.next() == XmlPullParser.Event.TEXT_CHARACTERS ? xmlPullParser.getText() : "";
                    if (!name.equals("instructions")) {
                        hashMap.put(name, text);
                    } else {
                        str = text;
                    }
                } else {
                    PacketParserUtils.addExtensionElement((Collection<ExtensionElement>) linkedList, xmlPullParser, xmlEnvironment);
                }
            } else if (next == XmlPullParser.Event.END_ELEMENT && xmlPullParser.getName().equals("query")) {
                Registration registration = new Registration(str, hashMap);
                registration.addExtensions(linkedList);
                return registration;
            }
        }
    }
}
