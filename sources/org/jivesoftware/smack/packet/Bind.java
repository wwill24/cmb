package org.jivesoftware.smack.packet;

import javax.xml.namespace.QName;
import org.jivesoftware.smack.packet.IQ;
import org.jxmpp.jid.EntityFullJid;
import org.jxmpp.jid.parts.Resourcepart;

public final class Bind extends IQ {
    public static final String ELEMENT = "bind";
    public static final String NAMESPACE = "urn:ietf:params:xml:ns:xmpp-bind";
    private final EntityFullJid jid;
    private final Resourcepart resource;

    public static final class Feature implements ExtensionElement {
        public static final Feature INSTANCE = new Feature();
        public static final QName QNAME = new QName(Bind.NAMESPACE, Bind.ELEMENT);

        private Feature() {
        }

        public String getElementName() {
            return Bind.ELEMENT;
        }

        public String getNamespace() {
            return Bind.NAMESPACE;
        }

        public String toXML(XmlEnvironment xmlEnvironment) {
            return "<bind xmlns='urn:ietf:params:xml:ns:xmpp-bind'/>";
        }
    }

    private Bind(Resourcepart resourcepart, EntityFullJid entityFullJid) {
        super(ELEMENT, NAMESPACE);
        this.resource = resourcepart;
        this.jid = entityFullJid;
    }

    public static Bind newResult(EntityFullJid entityFullJid) {
        return new Bind((Resourcepart) null, entityFullJid);
    }

    public static Bind newSet(Resourcepart resourcepart) {
        Bind bind = new Bind(resourcepart, (EntityFullJid) null);
        bind.setType(IQ.Type.set);
        return bind;
    }

    /* access modifiers changed from: protected */
    public IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder iQChildElementXmlStringBuilder) {
        iQChildElementXmlStringBuilder.rightAngleBracket();
        iQChildElementXmlStringBuilder.optElement("resource", (CharSequence) this.resource);
        iQChildElementXmlStringBuilder.optElement("jid", (CharSequence) this.jid);
        return iQChildElementXmlStringBuilder;
    }

    public EntityFullJid getJid() {
        return this.jid;
    }

    public Resourcepart getResource() {
        return this.resource;
    }
}
