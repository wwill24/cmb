package o8;

import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.XmlStringBuilder;

public class b implements ExtensionElement {

    /* renamed from: a  reason: collision with root package name */
    private final String f16834a;

    public b(String str) {
        this.f16834a = str;
    }

    private CharSequence a() {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder();
        xmlStringBuilder.openElement(getElementName());
        xmlStringBuilder.append((CharSequence) this.f16834a);
        xmlStringBuilder.closeElement(getElementName());
        return xmlStringBuilder;
    }

    public String b() {
        return this.f16834a;
    }

    public String getElementName() {
        return "timestamp";
    }

    public String getNamespace() {
        return null;
    }

    public CharSequence toXML(String str) {
        return a();
    }

    public CharSequence toXML(XmlEnvironment xmlEnvironment) {
        return a();
    }
}
