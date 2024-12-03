package org.jivesoftware.smackx.pubsub;

import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.Objects;
import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jivesoftware.smackx.iot.data.element.NodeElement;
import org.jivesoftware.smackx.pubsub.packet.PubSubNamespace;
import org.jxmpp.jid.BareJid;

public class Affiliation implements ExtensionElement {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final String ELEMENT = "affiliation";
    private final Type affiliation;
    private final BareJid jid;
    private final AffiliationNamespace namespace;
    private final String node;

    public enum AffiliationNamespace {
        basic(PubSubElementType.AFFILIATIONS),
        owner(PubSubElementType.AFFILIATIONS_OWNER);
        
        public final PubSubElementType type;

        private AffiliationNamespace(PubSubElementType pubSubElementType) {
            this.type = pubSubElementType;
        }

        public static AffiliationNamespace fromXmlns(String str) {
            for (AffiliationNamespace affiliationNamespace : values()) {
                if (affiliationNamespace.type.getNamespace().getXmlns().equals(str)) {
                    return affiliationNamespace;
                }
            }
            throw new IllegalArgumentException("Invalid affiliations namespace: " + str);
        }
    }

    public enum Type {
        member,
        none,
        outcast,
        owner,
        publisher
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public Affiliation(String str, Type type) {
        this(str, type, type == null ? AffiliationNamespace.basic : AffiliationNamespace.owner);
    }

    public Type getAffiliation() {
        return this.affiliation;
    }

    public String getElementName() {
        return "affiliation";
    }

    public BareJid getJid() {
        return this.jid;
    }

    public String getNamespace() {
        return getPubSubNamespace().getXmlns();
    }

    public String getNode() {
        return this.node;
    }

    @Deprecated
    public String getNodeId() {
        return getNode();
    }

    public PubSubNamespace getPubSubNamespace() {
        return this.namespace.type.getNamespace();
    }

    @Deprecated
    public Type getType() {
        return getAffiliation();
    }

    public boolean isAffiliationModification() {
        return (this.jid == null || this.affiliation == null) ? false : true;
    }

    public Affiliation(String str, Type type, AffiliationNamespace affiliationNamespace) {
        this.node = (String) StringUtils.requireNotNullNorEmpty(str, "node must not be null nor empty");
        this.affiliation = type;
        this.jid = null;
        this.namespace = (AffiliationNamespace) Objects.requireNonNull(affiliationNamespace);
    }

    public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder((ExtensionElement) this);
        xmlStringBuilder.optAttribute(NodeElement.ELEMENT, this.node);
        xmlStringBuilder.optAttribute("jid", (CharSequence) this.jid);
        xmlStringBuilder.optAttribute("affiliation", (Enum<?>) this.affiliation);
        xmlStringBuilder.closeEmptyElement();
        return xmlStringBuilder;
    }

    public Affiliation(BareJid bareJid, Type type) {
        this(bareJid, type, AffiliationNamespace.owner);
    }

    public Affiliation(BareJid bareJid, Type type, AffiliationNamespace affiliationNamespace) {
        this.jid = bareJid;
        this.affiliation = type;
        this.node = null;
        this.namespace = affiliationNamespace;
    }
}
