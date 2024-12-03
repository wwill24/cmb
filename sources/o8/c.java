package o8;

import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.XmlStringBuilder;

public class c implements ExtensionElement {

    /* renamed from: a  reason: collision with root package name */
    private final String f16835a;

    public c(String str) {
        this.f16835a = str;
    }

    private CharSequence a() {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder();
        xmlStringBuilder.halfOpenElement(getElementName());
        xmlStringBuilder.xmlnsAttribute(getNamespace());
        xmlStringBuilder.rightAngleBracket();
        xmlStringBuilder.openElement("url");
        xmlStringBuilder.append((CharSequence) this.f16835a);
        xmlStringBuilder.closeElement("url");
        xmlStringBuilder.closeElement(getElementName());
        return xmlStringBuilder;
    }

    public String b() {
        return this.f16835a;
    }

    public String getElementName() {
        return "x";
    }

    public String getNamespace() {
        return "jabber:x:oob";
    }

    public CharSequence toXML(String str) {
        return a();
    }

    public CharSequence toXML(XmlEnvironment xmlEnvironment) {
        return a();
    }
}
