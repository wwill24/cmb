package org.jivesoftware.smack.packet;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;
import org.apache.commons.beanutils.PropertyUtils;
import org.jivesoftware.smack.packet.AbstractError;
import org.jivesoftware.smack.util.Objects;
import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jivesoftware.smackx.sid.element.StanzaIdElement;

public class StanzaError extends AbstractError implements ExtensionElement {
    static final Map<Condition, Type> CONDITION_TO_TYPE;
    public static final String ERROR = "error";
    public static final String ERROR_CONDITION_AND_TEXT_NAMESPACE = "urn:ietf:params:xml:ns:xmpp-stanzas";
    private static final Logger LOGGER = Logger.getLogger(StanzaError.class.getName());
    @Deprecated
    public static final String NAMESPACE = "urn:ietf:params:xml:ns:xmpp-stanzas";
    public static final QName QNAME = new QName("jabber:client", "error");
    private final Condition condition;
    private final String conditionText;
    private final String errorGenerator;
    private final Type type;

    /* renamed from: org.jivesoftware.smack.packet.StanzaError$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$jivesoftware$smack$packet$StanzaError$Condition;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                org.jivesoftware.smack.packet.StanzaError$Condition[] r0 = org.jivesoftware.smack.packet.StanzaError.Condition.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$org$jivesoftware$smack$packet$StanzaError$Condition = r0
                org.jivesoftware.smack.packet.StanzaError$Condition r1 = org.jivesoftware.smack.packet.StanzaError.Condition.gone     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$org$jivesoftware$smack$packet$StanzaError$Condition     // Catch:{ NoSuchFieldError -> 0x001d }
                org.jivesoftware.smack.packet.StanzaError$Condition r1 = org.jivesoftware.smack.packet.StanzaError.Condition.redirect     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smack.packet.StanzaError.AnonymousClass1.<clinit>():void");
        }
    }

    public static final class Builder extends AbstractError.Builder<Builder> {
        private Condition condition;
        private String conditionText;
        private String errorGenerator;
        private Type type;

        /* synthetic */ Builder(AnonymousClass1 r12) {
            this();
        }

        public StanzaError build() {
            return new StanzaError(this.condition, this.conditionText, this.errorGenerator, this.type, this.descriptiveTexts, this.extensions);
        }

        public Builder copyFrom(StanzaError stanzaError) {
            setCondition(stanzaError.getCondition());
            setType(stanzaError.getType());
            setConditionText(stanzaError.getConditionText());
            setErrorGenerator(stanzaError.getErrorGenerator());
            setDescriptiveTexts(stanzaError.descriptiveTexts);
            setTextNamespace(stanzaError.textNamespace);
            setExtensions(stanzaError.extensions);
            return this;
        }

        /* access modifiers changed from: protected */
        public Builder getThis() {
            return this;
        }

        public Builder setCondition(Condition condition2) {
            this.condition = condition2;
            return this;
        }

        public Builder setConditionText(String str) {
            this.conditionText = str;
            return this;
        }

        public Builder setErrorGenerator(String str) {
            this.errorGenerator = str;
            return this;
        }

        public Builder setType(Type type2) {
            this.type = type2;
            return this;
        }

        private Builder() {
        }
    }

    public enum Condition {
        bad_request,
        conflict,
        feature_not_implemented,
        forbidden,
        gone,
        internal_server_error,
        item_not_found,
        jid_malformed,
        not_acceptable,
        not_allowed,
        not_authorized,
        policy_violation,
        recipient_unavailable,
        redirect,
        registration_required,
        remote_server_not_found,
        remote_server_timeout,
        resource_constraint,
        service_unavailable,
        subscription_required,
        undefined_condition,
        unexpected_request;

        public static Condition fromString(String str) {
            String replace = str.replace(SignatureVisitor.SUPER, '_');
            try {
                return valueOf(replace);
            } catch (Exception e10) {
                throw new IllegalStateException("Could not transform string '" + replace + "' to XMPPErrorCondition", e10);
            }
        }

        public String toString() {
            return name().replace('_', SignatureVisitor.SUPER);
        }
    }

    public enum Type {
        WAIT,
        CANCEL,
        MODIFY,
        AUTH,
        CONTINUE;

        public static Type fromString(String str) {
            return valueOf(str.toUpperCase(Locale.US));
        }

        public String toString() {
            return name().toLowerCase(Locale.US);
        }
    }

    static {
        HashMap hashMap = new HashMap();
        CONDITION_TO_TYPE = hashMap;
        Condition condition2 = Condition.bad_request;
        Type type2 = Type.MODIFY;
        hashMap.put(condition2, type2);
        Condition condition3 = Condition.conflict;
        Type type3 = Type.CANCEL;
        hashMap.put(condition3, type3);
        hashMap.put(Condition.feature_not_implemented, type3);
        Condition condition4 = Condition.forbidden;
        Type type4 = Type.AUTH;
        hashMap.put(condition4, type4);
        hashMap.put(Condition.gone, type3);
        hashMap.put(Condition.internal_server_error, type3);
        hashMap.put(Condition.item_not_found, type3);
        hashMap.put(Condition.jid_malformed, type2);
        hashMap.put(Condition.not_acceptable, type2);
        hashMap.put(Condition.not_allowed, type3);
        hashMap.put(Condition.not_authorized, type4);
        hashMap.put(Condition.policy_violation, type2);
        Condition condition5 = Condition.recipient_unavailable;
        Type type5 = Type.WAIT;
        hashMap.put(condition5, type5);
        hashMap.put(Condition.redirect, type2);
        hashMap.put(Condition.registration_required, type4);
        hashMap.put(Condition.remote_server_not_found, type3);
        hashMap.put(Condition.remote_server_timeout, type5);
        hashMap.put(Condition.resource_constraint, type5);
        hashMap.put(Condition.service_unavailable, type3);
        hashMap.put(Condition.subscription_required, type4);
        hashMap.put(Condition.undefined_condition, type2);
        hashMap.put(Condition.unexpected_request, type5);
    }

    public StanzaError(Condition condition2, String str, String str2, Type type2, Map<String, String> map, List<ExtensionElement> list) {
        super(map, "urn:ietf:params:xml:ns:xmpp-stanzas", list);
        int i10;
        this.condition = (Condition) Objects.requireNonNull(condition2, "condition must not be null");
        str = StringUtils.isNullOrEmpty((CharSequence) str) ? null : str;
        if (str == null || (i10 = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$packet$StanzaError$Condition[condition2.ordinal()]) == 1 || i10 == 2) {
            this.conditionText = str;
            this.errorGenerator = str2;
            if (type2 == null) {
                Type type3 = CONDITION_TO_TYPE.get(condition2);
                if (type3 == null) {
                    Logger logger = LOGGER;
                    logger.warning("Could not determine type for condition: " + condition2);
                    type3 = Type.CANCEL;
                }
                this.type = type3;
                return;
            }
            this.type = type2;
            return;
        }
        throw new IllegalArgumentException("Condition text can only be set with condtion types 'gone' and 'redirect', not " + condition2);
    }

    public static Builder from(Condition condition2, String str) {
        Builder condition3 = getBuilder().setCondition(condition2);
        if (str != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("en", str);
            condition3.setDescriptiveTexts(hashMap);
        }
        return condition3;
    }

    public static Builder getBuilder() {
        return new Builder((AnonymousClass1) null);
    }

    public Condition getCondition() {
        return this.condition;
    }

    public String getConditionText() {
        return this.conditionText;
    }

    public String getElementName() {
        return QNAME.getLocalPart();
    }

    public String getErrorGenerator() {
        return this.errorGenerator;
    }

    public String getNamespace() {
        return QNAME.getNamespaceURI();
    }

    public Type getType() {
        return this.type;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("XMPPError: ");
        sb2.append(this.condition.toString());
        sb2.append(" - ");
        sb2.append(this.type.toString());
        String descriptiveText = getDescriptiveText();
        if (descriptiveText != null) {
            sb2.append(" [");
            sb2.append(descriptiveText);
            sb2.append(PropertyUtils.INDEXED_DELIM2);
        }
        if (this.errorGenerator != null) {
            sb2.append(". Generated by ");
            sb2.append(this.errorGenerator);
        }
        return sb2.toString();
    }

    public static Builder getBuilder(Condition condition2) {
        return getBuilder().setCondition(condition2);
    }

    public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder(this, xmlEnvironment);
        xmlStringBuilder.attribute("type", this.type.toString());
        xmlStringBuilder.optAttribute(StanzaIdElement.ATTR_BY, this.errorGenerator);
        xmlStringBuilder.rightAngleBracket();
        xmlStringBuilder.halfOpenElement(this.condition.toString());
        xmlStringBuilder.xmlnsAttribute("urn:ietf:params:xml:ns:xmpp-stanzas");
        if (this.conditionText != null) {
            xmlStringBuilder.rightAngleBracket();
            xmlStringBuilder.escape(this.conditionText);
            xmlStringBuilder.closeElement(this.condition.toString());
        } else {
            xmlStringBuilder.closeEmptyElement();
        }
        addDescriptiveTextsAndExtensions(xmlStringBuilder);
        xmlStringBuilder.closeElement((NamedElement) this);
        return xmlStringBuilder;
    }

    public static Builder getBuilder(StanzaError stanzaError) {
        return getBuilder().copyFrom(stanzaError);
    }
}
