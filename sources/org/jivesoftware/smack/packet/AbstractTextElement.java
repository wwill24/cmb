package org.jivesoftware.smack.packet;

import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smack.util.XmlStringBuilder;

public abstract class AbstractTextElement implements ExtensionElement {
    public static final String ELEMENT = "text";
    private final String lang;
    private final String text;

    protected AbstractTextElement(String str, String str2) {
        this.text = (String) StringUtils.requireNotNullNorEmpty(str, "Text must not be null nor empty");
        this.lang = str2;
    }

    public String getElementName() {
        return "text";
    }

    @Deprecated
    public final String getLang() {
        return this.lang;
    }

    public final String getLanguage() {
        return this.lang;
    }

    public final String getText() {
        return this.text;
    }

    public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder(this, xmlEnvironment);
        xmlStringBuilder.rightAngleBracket();
        xmlStringBuilder.escape(this.text);
        xmlStringBuilder.closeElement((NamedElement) this);
        return xmlStringBuilder;
    }
}
