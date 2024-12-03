package org.jivesoftware.smack.compress.packet;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Collections;
import java.util.List;
import javax.xml.namespace.QName;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.NamedElement;
import org.jivesoftware.smack.packet.Nonza;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.XmlStringBuilder;

public class Compress implements Nonza {
    public static final String ELEMENT = "compress";
    public static final String NAMESPACE = "http://jabber.org/protocol/compress";
    public final String method;

    public static class Feature implements ExtensionElement {
        public static final String ELEMENT = "compression";
        public static final QName QNAME = new QName("http://jabber.org/protocol/compress", ELEMENT);
        public final List<String> methods;

        public Feature(List<String> list) {
            this.methods = list;
        }

        public String getElementName() {
            return ELEMENT;
        }

        public List<String> getMethods() {
            return Collections.unmodifiableList(this.methods);
        }

        public String getNamespace() {
            return "http://jabber.org/protocol/compress";
        }

        public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder((ExtensionElement) this);
            xmlStringBuilder.rightAngleBracket();
            for (String element : this.methods) {
                xmlStringBuilder.element(FirebaseAnalytics.Param.METHOD, element);
            }
            xmlStringBuilder.closeElement((NamedElement) this);
            return xmlStringBuilder;
        }
    }

    public Compress(String str) {
        this.method = str;
    }

    public String getElementName() {
        return ELEMENT;
    }

    public String getNamespace() {
        return "http://jabber.org/protocol/compress";
    }

    public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder(this, xmlEnvironment);
        xmlStringBuilder.rightAngleBracket();
        xmlStringBuilder.element(FirebaseAnalytics.Param.METHOD, this.method);
        xmlStringBuilder.closeElement((NamedElement) this);
        return xmlStringBuilder;
    }
}
