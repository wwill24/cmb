package org.jivesoftware.smackx.reference.element;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.NamedElement;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.Objects;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jivesoftware.smackx.reference.ReferenceManager;
import org.jxmpp.jid.BareJid;

public class ReferenceElement implements ExtensionElement {
    public static final String ATTR_ANCHOR = "anchor";
    public static final String ATTR_BEGIN = "begin";
    public static final String ATTR_END = "end";
    public static final String ATTR_TYPE = "type";
    public static final String ATTR_URI = "uri";
    public static final String ELEMENT = "reference";
    private final String anchor;
    private final Integer begin;
    private final ExtensionElement child;
    private final Integer end;
    private final Type type;
    private final URI uri;

    public enum Type {
        mention,
        data
    }

    public ReferenceElement(Integer num, Integer num2, Type type2, String str, URI uri2, ExtensionElement extensionElement) {
        if (num != null && num.intValue() < 0) {
            throw new IllegalArgumentException("Attribute 'begin' MUST NOT be smaller than 0.");
        } else if (num2 != null && num2.intValue() < 0) {
            throw new IllegalArgumentException("Attribute 'end' MUST NOT be smaller than 0.");
        } else if (num == null || num2 == null || num.intValue() < num2.intValue()) {
            Objects.requireNonNull(type2);
            this.begin = num;
            this.end = num2;
            this.type = type2;
            this.anchor = str;
            this.uri = uri2;
            this.child = extensionElement;
        } else {
            throw new IllegalArgumentException("Attribute 'begin' MUST be smaller than attribute 'end'.");
        }
    }

    public static void addMention(Stanza stanza, int i10, int i11, BareJid bareJid) {
        try {
            stanza.addExtension(new ReferenceElement(Integer.valueOf(i10), Integer.valueOf(i11), Type.mention, (String) null, new URI("xmpp:" + bareJid.toString())));
        } catch (URISyntaxException unused) {
            throw new AssertionError("Cannot create URI from bareJid.");
        }
    }

    public static boolean containsReferences(Stanza stanza) {
        return getReferencesFromStanza(stanza).size() > 0;
    }

    public static List<ReferenceElement> getReferencesFromStanza(Stanza stanza) {
        ArrayList arrayList = new ArrayList();
        Iterator<ExtensionElement> it = stanza.getExtensions(ELEMENT, ReferenceManager.NAMESPACE).iterator();
        while (it.hasNext()) {
            arrayList.add((ReferenceElement) it.next());
        }
        return arrayList;
    }

    public String getAnchor() {
        return this.anchor;
    }

    public Integer getBegin() {
        return this.begin;
    }

    public String getElementName() {
        return ELEMENT;
    }

    public Integer getEnd() {
        return this.end;
    }

    public String getNamespace() {
        return ReferenceManager.NAMESPACE;
    }

    public Type getType() {
        return this.type;
    }

    public URI getUri() {
        return this.uri;
    }

    public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder((ExtensionElement) this);
        Integer num = this.begin;
        int i10 = -1;
        XmlStringBuilder optIntAttribute = xmlStringBuilder.optIntAttribute(ATTR_BEGIN, num != null ? num.intValue() : -1);
        Integer num2 = this.end;
        if (num2 != null) {
            i10 = num2.intValue();
        }
        XmlStringBuilder optAttribute = optIntAttribute.optIntAttribute("end", i10).attribute("type", this.type.toString()).optAttribute(ATTR_ANCHOR, this.anchor);
        URI uri2 = this.uri;
        XmlStringBuilder optAttribute2 = optAttribute.optAttribute("uri", uri2 != null ? uri2.toString() : null);
        if (this.child == null) {
            return optAttribute2.closeEmptyElement();
        }
        return optAttribute2.rightAngleBracket().append(this.child.toXML()).closeElement((NamedElement) this);
    }

    public ReferenceElement(Integer num, Integer num2, Type type2, String str, URI uri2) {
        this(num, num2, type2, str, uri2, (ExtensionElement) null);
    }
}
