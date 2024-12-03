package org.jivesoftware.smack.packet;

import java.util.List;
import java.util.Map;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;
import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smack.util.XmlStringBuilder;

public class StreamError extends AbstractError implements Nonza {
    public static final String ELEMENT = "stream:error";
    public static final String NAMESPACE = "urn:ietf:params:xml:ns:xmpp-streams";
    private final Condition condition;
    private final String conditionText;

    /* renamed from: org.jivesoftware.smack.packet.StreamError$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$jivesoftware$smack$packet$StreamError$Condition;

        static {
            int[] iArr = new int[Condition.values().length];
            $SwitchMap$org$jivesoftware$smack$packet$StreamError$Condition = iArr;
            try {
                iArr[Condition.see_other_host.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public enum Condition {
        bad_format,
        bad_namespace_prefix,
        conflict,
        connection_timeout,
        host_gone,
        host_unknown,
        improper_addressing,
        internal_server_error,
        invalid_from,
        invalid_namespace,
        invalid_xml,
        not_authorized,
        not_well_formed,
        policy_violation,
        remote_connection_failed,
        reset,
        resource_constraint,
        restricted_xml,
        see_other_host,
        system_shutdown,
        undefined_condition,
        unsupported_encoding,
        unsupported_feature,
        unsupported_stanza_type,
        unsupported_version;

        public static Condition fromString(String str) {
            if ("xml-not-well-formed".equals(str)) {
                str = "not-well-formed";
            }
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

    public StreamError(Condition condition2, String str, Map<String, String> map, List<ExtensionElement> list) {
        super(map, list);
        str = StringUtils.isNullOrEmpty((CharSequence) str) ? null : str;
        if (str == null || AnonymousClass1.$SwitchMap$org$jivesoftware$smack$packet$StreamError$Condition[condition2.ordinal()] == 1) {
            this.condition = condition2;
            this.conditionText = str;
            return;
        }
        throw new IllegalArgumentException("The given condition '" + condition2 + "' can not contain a conditionText");
    }

    public Condition getCondition() {
        return this.condition;
    }

    public String getConditionText() {
        return this.conditionText;
    }

    public String getElementName() {
        return ELEMENT;
    }

    public String getNamespace() {
        return NAMESPACE;
    }

    public String toString() {
        return toXML().toString();
    }

    public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder();
        xmlStringBuilder.openElement(ELEMENT);
        xmlStringBuilder.halfOpenElement(this.condition.toString()).xmlnsAttribute(NAMESPACE).closeEmptyElement();
        addDescriptiveTextsAndExtensions(xmlStringBuilder);
        xmlStringBuilder.closeElement(ELEMENT);
        return xmlStringBuilder;
    }
}
