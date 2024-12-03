package org.jivesoftware.smackx.iqregister.packet;

import java.util.Map;
import javax.xml.namespace.QName;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.XmlEnvironment;

public class Registration extends IQ {
    public static final String ELEMENT = "query";
    public static final String NAMESPACE = "jabber:iq:register";
    private final Map<String, String> attributes;
    private final String instructions;

    public static final class Feature implements ExtensionElement {
        public static final String ELEMENT = "register";
        public static final Feature INSTANCE = new Feature();
        public static final String NAMESPACE = "http://jabber.org/features/iq-register";
        public static final QName QNAME = new QName(NAMESPACE, "register");

        private Feature() {
        }

        public String getElementName() {
            return "register";
        }

        public String getNamespace() {
            return NAMESPACE;
        }

        public CharSequence toXML(XmlEnvironment xmlEnvironment) {
            return "<register xmlns='http://jabber.org/features/iq-register'/>";
        }
    }

    public Registration() {
        this((Map<String, String>) null);
    }

    public Map<String, String> getAttributes() {
        return this.attributes;
    }

    /* access modifiers changed from: protected */
    public IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder iQChildElementXmlStringBuilder) {
        iQChildElementXmlStringBuilder.rightAngleBracket();
        iQChildElementXmlStringBuilder.optElement("instructions", this.instructions);
        Map<String, String> map = this.attributes;
        if (map != null && map.size() > 0) {
            for (String next : this.attributes.keySet()) {
                iQChildElementXmlStringBuilder.element(next, this.attributes.get(next));
            }
        }
        return iQChildElementXmlStringBuilder;
    }

    public String getInstructions() {
        return this.instructions;
    }

    public Registration(Map<String, String> map) {
        this((String) null, map);
    }

    public Registration(String str, Map<String, String> map) {
        super("query", NAMESPACE);
        this.instructions = str;
        this.attributes = map;
    }
}
