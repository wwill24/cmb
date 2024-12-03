package org.jivesoftware.smackx.jingle.element;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.jivesoftware.smack.packet.Element;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.NamedElement;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.XmlStringBuilder;

public abstract class JingleContentTransport implements ExtensionElement {
    public static final String ELEMENT = "transport";
    protected final List<JingleContentTransportCandidate> candidates;
    protected final JingleContentTransportInfo info;

    protected JingleContentTransport(List<JingleContentTransportCandidate> list) {
        this(list, (JingleContentTransportInfo) null);
    }

    /* access modifiers changed from: protected */
    public void addExtraAttributes(XmlStringBuilder xmlStringBuilder) {
    }

    public List<JingleContentTransportCandidate> getCandidates() {
        return this.candidates;
    }

    public String getElementName() {
        return ELEMENT;
    }

    public JingleContentTransportInfo getInfo() {
        return this.info;
    }

    protected JingleContentTransport(List<JingleContentTransportCandidate> list, JingleContentTransportInfo jingleContentTransportInfo) {
        if (list != null) {
            this.candidates = Collections.unmodifiableList(list);
        } else {
            this.candidates = Collections.emptyList();
        }
        this.info = jingleContentTransportInfo;
    }

    public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder(this, xmlEnvironment);
        addExtraAttributes(xmlStringBuilder);
        if (!this.candidates.isEmpty() || this.info != null) {
            xmlStringBuilder.rightAngleBracket();
            xmlStringBuilder.append((Collection<? extends Element>) this.candidates);
            xmlStringBuilder.optElement(this.info);
            xmlStringBuilder.closeElement((NamedElement) this);
        } else {
            xmlStringBuilder.closeEmptyElement();
        }
        return xmlStringBuilder;
    }
}
