package org.jivesoftware.smackx.jingle.element;

import java.util.Locale;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.XmlStringBuilder;

public final class JingleError implements ExtensionElement {
    public static String NAMESPACE = "urn:xmpp:jingle:errors:1";
    public static final JingleError OUT_OF_ORDER = new JingleError("out-of-order");
    public static final JingleError TIE_BREAK = new JingleError("tie-break");
    public static final JingleError UNKNOWN_SESSION = new JingleError("unknown-session");
    public static final JingleError UNSUPPORTED_INFO = new JingleError("unsupported-info");
    private final String errorName;

    private JingleError(String str) {
        this.errorName = str;
    }

    public static JingleError fromString(String str) {
        String lowerCase = str.toLowerCase(Locale.US);
        lowerCase.hashCode();
        char c10 = 65535;
        switch (lowerCase.hashCode()) {
            case -1789601929:
                if (lowerCase.equals("out-of-order")) {
                    c10 = 0;
                    break;
                }
                break;
            case -1454954477:
                if (lowerCase.equals("unknown-session")) {
                    c10 = 1;
                    break;
                }
                break;
            case -73956990:
                if (lowerCase.equals("tie-break")) {
                    c10 = 2;
                    break;
                }
                break;
            case 1052474694:
                if (lowerCase.equals("unsupported-info")) {
                    c10 = 3;
                    break;
                }
                break;
        }
        switch (c10) {
            case 0:
                return OUT_OF_ORDER;
            case 1:
                return UNKNOWN_SESSION;
            case 2:
                return TIE_BREAK;
            case 3:
                return UNSUPPORTED_INFO;
            default:
                throw new IllegalArgumentException();
        }
    }

    public String getElementName() {
        return this.errorName;
    }

    public String getMessage() {
        return this.errorName;
    }

    public String getNamespace() {
        return NAMESPACE;
    }

    public String toString() {
        return getMessage();
    }

    public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder((ExtensionElement) this);
        xmlStringBuilder.closeEmptyElement();
        return xmlStringBuilder;
    }
}
