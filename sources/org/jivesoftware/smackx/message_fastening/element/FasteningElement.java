package org.jivesoftware.smackx.message_fastening.element;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.jivesoftware.smack.packet.Element;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.MessageBuilder;
import org.jivesoftware.smack.packet.NamedElement;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.Objects;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jivesoftware.smackx.sid.element.OriginIdElement;

public final class FasteningElement implements ExtensionElement {
    public static final String ATTR_CLEAR = "clear";
    public static final String ATTR_ID = "id";
    public static final String ATTR_SHELL = "shell";
    public static final String ELEMENT = "apply-to";
    public static final String NAMESPACE = "urn:xmpp:fasten:0";
    private final boolean clear;
    private final List<ExternalElement> externalPayloads;
    private final OriginIdElement referencedStanzasOriginId;
    private final boolean shell;
    private final List<ExtensionElement> wrappedPayloads;

    public static class Builder {
        private final List<ExternalElement> externalPayloads = new ArrayList();
        private boolean isClear = false;
        private boolean isShell = false;
        private OriginIdElement originId;
        private final List<ExtensionElement> wrappedPayloads = new ArrayList();

        private void validateThatIfIsShellThenOtherwiseEmpty() {
            if (this.isShell) {
                if (this.isClear || !this.wrappedPayloads.isEmpty() || !this.externalPayloads.isEmpty()) {
                    throw new IllegalArgumentException("A fastening that is a shell element must be otherwise empty and cannot have a 'clear' attribute.");
                }
            }
        }

        public Builder addExternalPayload(ExternalElement externalElement) {
            return addExternalPayloads(Collections.singletonList(externalElement));
        }

        public Builder addExternalPayloads(List<ExternalElement> list) {
            this.externalPayloads.addAll(list);
            return this;
        }

        public Builder addWrappedPayload(ExtensionElement extensionElement) {
            return addWrappedPayloads(Collections.singletonList(extensionElement));
        }

        public Builder addWrappedPayloads(List<ExtensionElement> list) {
            this.wrappedPayloads.addAll(list);
            return this;
        }

        public FasteningElement build() {
            validateThatIfIsShellThenOtherwiseEmpty();
            return new FasteningElement(this.originId, this.wrappedPayloads, this.externalPayloads, this.isClear, this.isShell);
        }

        public Builder setClear() {
            this.isClear = true;
            return this;
        }

        public Builder setOriginId(String str) {
            return setOriginId(new OriginIdElement(str));
        }

        public Builder setShell() {
            this.isShell = true;
            return this;
        }

        public Builder setOriginId(OriginIdElement originIdElement) {
            this.originId = originIdElement;
            return this;
        }
    }

    private void addPayloads(XmlStringBuilder xmlStringBuilder) {
        for (ExternalElement append : this.externalPayloads) {
            xmlStringBuilder.append((Element) append);
        }
        for (ExtensionElement append2 : this.wrappedPayloads) {
            xmlStringBuilder.append((Element) append2);
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static FasteningElement createShellElementForSensitiveElement(FasteningElement fasteningElement) {
        return createShellElementForSensitiveElement(fasteningElement.getReferencedStanzasOriginId());
    }

    public static boolean hasFasteningElement(Message message) {
        return message.hasExtension(ELEMENT, "urn:xmpp:fasten:0");
    }

    public void applyTo(MessageBuilder messageBuilder) {
        if (!hasFasteningElement(messageBuilder)) {
            messageBuilder.addExtension(this);
            return;
        }
        throw new IllegalArgumentException("Stanza cannot contain more than one apply-to elements.");
    }

    public String getElementName() {
        return ELEMENT;
    }

    public List<ExternalElement> getExternalPayloads() {
        return Collections.unmodifiableList(this.externalPayloads);
    }

    public String getNamespace() {
        return "urn:xmpp:fasten:0";
    }

    public OriginIdElement getReferencedStanzasOriginId() {
        return this.referencedStanzasOriginId;
    }

    public List<ExtensionElement> getWrappedPayloads() {
        return Collections.unmodifiableList(this.wrappedPayloads);
    }

    public boolean isRemovingElement() {
        return this.clear;
    }

    public boolean isShellElement() {
        return this.shell;
    }

    private FasteningElement(OriginIdElement originIdElement, List<ExtensionElement> list, List<ExternalElement> list2, boolean z10, boolean z11) {
        ArrayList arrayList = new ArrayList();
        this.externalPayloads = arrayList;
        ArrayList arrayList2 = new ArrayList();
        this.wrappedPayloads = arrayList2;
        this.referencedStanzasOriginId = (OriginIdElement) Objects.requireNonNull(originIdElement, "Fastening element MUST contain an origin-id.");
        arrayList2.addAll(list);
        arrayList.addAll(list2);
        this.clear = z10;
        this.shell = z11;
    }

    public static FasteningElement createShellElementForSensitiveElement(String str) {
        return createShellElementForSensitiveElement(new OriginIdElement(str));
    }

    public static boolean hasFasteningElement(MessageBuilder messageBuilder) {
        return messageBuilder.hasExtension((Class<? extends ExtensionElement>) FasteningElement.class);
    }

    public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
        XmlStringBuilder rightAngleBracket = new XmlStringBuilder((ExtensionElement) this).attribute("id", this.referencedStanzasOriginId.getId()).optBooleanAttribute(ATTR_CLEAR, isRemovingElement()).optBooleanAttribute(ATTR_SHELL, isShellElement()).rightAngleBracket();
        addPayloads(rightAngleBracket);
        return rightAngleBracket.closeElement((NamedElement) this);
    }

    public static FasteningElement createShellElementForSensitiveElement(OriginIdElement originIdElement) {
        return builder().setOriginId(originIdElement).setShell().build();
    }
}
