package o8;

import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.XmlStringBuilder;

public class a implements ExtensionElement {

    /* renamed from: a  reason: collision with root package name */
    private final String f16833a;

    public a(String str) {
        this.f16833a = str;
    }

    private CharSequence a() {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder();
        xmlStringBuilder.openElement(getElementName());
        xmlStringBuilder.append((CharSequence) this.f16833a);
        xmlStringBuilder.closeElement(getElementName());
        return xmlStringBuilder;
    }

    public String b() {
        return this.f16833a;
    }

    public String getElementName() {
        return "category";
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
