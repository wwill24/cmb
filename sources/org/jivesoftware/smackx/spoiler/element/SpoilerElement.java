package org.jivesoftware.smackx.spoiler.element;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.NamedElement;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smack.util.XmlStringBuilder;

public class SpoilerElement implements ExtensionElement {
    public static final String ELEMENT = "spoiler";
    public static final SpoilerElement EMPTY = new SpoilerElement((String) null, (String) null);
    public static final String NAMESPACE = "urn:xmpp:spoiler:0";
    private final String hint;
    private final String language;

    public SpoilerElement(String str, String str2) {
        if (!StringUtils.isNotEmpty((CharSequence) str) || !StringUtils.isNullOrEmpty((CharSequence) str2)) {
            this.language = str;
            this.hint = str2;
            return;
        }
        throw new IllegalArgumentException("Hint cannot be null or empty if language is not empty.");
    }

    public static void addSpoiler(Message message) {
        message.addExtension(EMPTY);
    }

    public static boolean containsSpoiler(Message message) {
        return message.hasExtension(ELEMENT, "urn:xmpp:spoiler:0");
    }

    public static Map<String, String> getSpoilers(Message message) {
        if (!containsSpoiler(message)) {
            return Collections.emptyMap();
        }
        List<ExtensionElement> extensions = message.getExtensions(ELEMENT, "urn:xmpp:spoiler:0");
        HashMap hashMap = new HashMap();
        Iterator<ExtensionElement> it = extensions.iterator();
        while (it.hasNext()) {
            SpoilerElement spoilerElement = (SpoilerElement) it.next();
            if (spoilerElement.getLanguage() == null || spoilerElement.getLanguage().equals("")) {
                hashMap.put("", spoilerElement.getHint());
            } else {
                hashMap.put(spoilerElement.getLanguage(), spoilerElement.getHint());
            }
        }
        return hashMap;
    }

    public String getElementName() {
        return ELEMENT;
    }

    public String getHint() {
        return this.hint;
    }

    public String getLanguage() {
        return this.language;
    }

    public String getNamespace() {
        return "urn:xmpp:spoiler:0";
    }

    public CharSequence toXML(XmlEnvironment xmlEnvironment) {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder(this, xmlEnvironment);
        if (getHint() == null) {
            xmlStringBuilder.closeEmptyElement();
        } else {
            xmlStringBuilder.rightAngleBracket();
            xmlStringBuilder.append((CharSequence) getHint());
            xmlStringBuilder.closeElement((NamedElement) this);
        }
        return xmlStringBuilder;
    }

    public static void addSpoiler(Message message, String str) {
        message.addExtension(new SpoilerElement((String) null, str));
    }

    public static void addSpoiler(Message message, String str, String str2) {
        message.addExtension(new SpoilerElement(str, str2));
    }
}
