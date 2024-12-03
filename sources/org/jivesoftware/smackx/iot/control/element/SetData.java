package org.jivesoftware.smackx.iot.control.element;

import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.XmlStringBuilder;

public abstract class SetData implements ExtensionElement {
    private final String name;
    private final Type type;
    private final String value;

    public enum Type {
        BOOL,
        INT,
        LONG,
        DOUBLE;
        
        private final String toStringCache;

        public String toString() {
            return this.toStringCache;
        }
    }

    protected SetData(String str, Type type2, String str2) {
        this.name = str;
        this.type = type2;
        this.value = str2;
    }

    public final String getElementName() {
        return getType().toString();
    }

    public final String getName() {
        return this.name;
    }

    public final String getNamespace() {
        return "urn:xmpp:iot:control";
    }

    public final Type getType() {
        return this.type;
    }

    public final String getValue() {
        return this.value;
    }

    public final XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder(this, xmlEnvironment);
        xmlStringBuilder.attribute("name", this.name);
        xmlStringBuilder.attribute("value", this.value);
        xmlStringBuilder.closeEmptyElement();
        return xmlStringBuilder;
    }
}
