package org.jivesoftware.smack.packet;

import java.util.Collection;
import java.util.List;
import java.util.Locale;
import javax.xml.namespace.QName;
import org.apache.commons.beanutils.PropertyUtils;
import org.jivesoftware.smack.packet.StanzaError;
import org.jivesoftware.smack.util.Objects;
import org.jivesoftware.smack.util.XmlStringBuilder;

public abstract class IQ extends Stanza implements IqView {
    public static final String IQ_ELEMENT = "iq";
    public static final String QUERY_ELEMENT = "query";
    private final String childElementName;
    private final String childElementNamespace;
    private final QName childElementQName;
    private Type type;

    /* renamed from: org.jivesoftware.smack.packet.IQ$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$jivesoftware$smack$packet$IQ$Type;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                org.jivesoftware.smack.packet.IQ$Type[] r0 = org.jivesoftware.smack.packet.IQ.Type.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$org$jivesoftware$smack$packet$IQ$Type = r0
                org.jivesoftware.smack.packet.IQ$Type r1 = org.jivesoftware.smack.packet.IQ.Type.get     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$org$jivesoftware$smack$packet$IQ$Type     // Catch:{ NoSuchFieldError -> 0x001d }
                org.jivesoftware.smack.packet.IQ$Type r1 = org.jivesoftware.smack.packet.IQ.Type.set     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smack.packet.IQ.AnonymousClass1.<clinit>():void");
        }
    }

    public static class IQChildElementXmlStringBuilder extends XmlStringBuilder {
        /* access modifiers changed from: private */
        public final String element;
        /* access modifiers changed from: private */
        public boolean isEmptyElement;

        /* synthetic */ IQChildElementXmlStringBuilder(String str, String str2, String str3, XmlEnvironment xmlEnvironment, AnonymousClass1 r52) {
            this(str, str2, str3, xmlEnvironment);
        }

        public void setEmptyElement() {
            this.isEmptyElement = true;
        }

        public IQChildElementXmlStringBuilder(ExtensionElement extensionElement, XmlEnvironment xmlEnvironment) {
            this(extensionElement.getElementName(), extensionElement.getNamespace(), extensionElement.getLanguage(), xmlEnvironment);
        }

        private IQChildElementXmlStringBuilder(String str, String str2, String str3, XmlEnvironment xmlEnvironment) {
            super(str, str2, str3, xmlEnvironment);
            this.element = str;
        }
    }

    public enum ResponseType {
        result(Type.result),
        error(Type.error);
        
        final Type type;

        private ResponseType(Type type2) {
            this.type = type2;
        }

        /* access modifiers changed from: package-private */
        public Type getType() {
            return this.type;
        }
    }

    public enum Type {
        get,
        set,
        result,
        error;

        public static Type fromString(String str) {
            return valueOf(str.toLowerCase(Locale.US));
        }
    }

    protected IQ(IQ iq) {
        super((Stanza) iq);
        this.type = Type.get;
        this.type = iq.getType();
        this.childElementName = iq.childElementName;
        this.childElementNamespace = iq.childElementNamespace;
        this.childElementQName = iq.childElementQName;
    }

    private void appendInnerXml(XmlStringBuilder xmlStringBuilder) {
        IQChildElementXmlStringBuilder iQChildElementBuilder;
        if (this.type == Type.error) {
            appendErrorIfExists(xmlStringBuilder);
        } else if (this.childElementName != null && (iQChildElementBuilder = getIQChildElementBuilder(new IQChildElementXmlStringBuilder(getChildElementName(), getChildElementNamespace(), (String) null, xmlStringBuilder.getXmlEnvironment(), (AnonymousClass1) null))) != null) {
            xmlStringBuilder.append((XmlStringBuilder) iQChildElementBuilder);
            List<ExtensionElement> extensions = getExtensions();
            if (iQChildElementBuilder.isEmptyElement) {
                if (extensions.isEmpty()) {
                    xmlStringBuilder.closeEmptyElement();
                    return;
                }
                xmlStringBuilder.rightAngleBracket();
            }
            xmlStringBuilder.append((Collection<? extends Element>) extensions);
            xmlStringBuilder.closeElement(iQChildElementBuilder.element);
        }
    }

    public static ErrorIQ createErrorResponse(IQ iq, StanzaError stanzaError) {
        if (iq.isRequestIQ()) {
            ErrorIQ errorIQ = new ErrorIQ(stanzaError);
            errorIQ.setStanzaId(iq.getStanzaId());
            errorIQ.setFrom(iq.getTo());
            errorIQ.setTo(iq.getFrom());
            return errorIQ;
        }
        throw new IllegalArgumentException("IQ must be of type 'set' or 'get'. Original IQ: " + iq.toXML());
    }

    public static IQ createResultIQ(IQ iq) {
        return new EmptyResultIQ(iq);
    }

    public final String getChildElementName() {
        return this.childElementName;
    }

    public final String getChildElementNamespace() {
        return this.childElementNamespace;
    }

    public final QName getChildElementQName() {
        return this.childElementQName;
    }

    public final XmlStringBuilder getChildElementXML() {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder();
        appendInnerXml(xmlStringBuilder);
        return xmlStringBuilder;
    }

    public final String getElementName() {
        return IQ_ELEMENT;
    }

    /* access modifiers changed from: protected */
    public abstract IQChildElementXmlStringBuilder getIQChildElementBuilder(IQChildElementXmlStringBuilder iQChildElementXmlStringBuilder);

    public Type getType() {
        return this.type;
    }

    public boolean isRequestIQ() {
        int i10 = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$packet$IQ$Type[this.type.ordinal()];
        return i10 == 1 || i10 == 2;
    }

    public boolean isResponseIQ() {
        return !isRequestIQ();
    }

    public void setType(Type type2) {
        this.type = (Type) Objects.requireNonNull(type2, "type must not be null");
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("IQ Stanza (");
        sb2.append(getChildElementName());
        sb2.append(' ');
        sb2.append(getChildElementNamespace());
        sb2.append(") [");
        logCommonAttributes(sb2);
        sb2.append("type=");
        sb2.append(this.type);
        sb2.append(',');
        sb2.append(PropertyUtils.INDEXED_DELIM2);
        return sb2.toString();
    }

    public final XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder(this, xmlEnvironment);
        addCommonAttributes(xmlStringBuilder);
        Type type2 = this.type;
        if (type2 == null) {
            xmlStringBuilder.attribute("type", "get");
        } else {
            xmlStringBuilder.attribute("type", type2.toString());
        }
        xmlStringBuilder.rightAngleBracket();
        appendInnerXml(xmlStringBuilder);
        xmlStringBuilder.closeElement(IQ_ELEMENT);
        return xmlStringBuilder;
    }

    protected IQ(String str, String str2) {
        this(IqData.EMPTY, str, str2);
    }

    protected IQ(AbstractIqBuilder<?> abstractIqBuilder, String str, String str2) {
        super((StanzaBuilder<?>) abstractIqBuilder);
        this.type = Type.get;
        this.type = abstractIqBuilder.type;
        this.childElementName = str;
        this.childElementNamespace = str2;
        if (str == null) {
            this.childElementQName = null;
        } else {
            this.childElementQName = new QName(str2, str);
        }
    }

    @Deprecated
    public static ErrorIQ createErrorResponse(IQ iq, StanzaError.Builder builder) {
        return createErrorResponse(iq, builder.build());
    }

    public static ErrorIQ createErrorResponse(IQ iq, StanzaError.Condition condition) {
        return createErrorResponse(iq, StanzaError.getBuilder(condition).build());
    }
}
