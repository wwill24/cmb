package org.jivesoftware.smackx.message_markup.element;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.jivesoftware.smack.packet.Element;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jivesoftware.smackx.message_markup.element.MarkupElement;

public class ListElement extends MarkupElement.NonEmptyChildElement {
    public static final String ELEMENT = "list";
    public static final String ELEM_LI = "li";
    private final List<ListEntryElement> entries;

    public static class ListEntryElement implements ExtensionElement {
        private final int start;

        public ListEntryElement(int i10) {
            this.start = i10;
        }

        public String getElementName() {
            return "li";
        }

        public String getNamespace() {
            return MarkupElement.NAMESPACE;
        }

        public int getStart() {
            return this.start;
        }

        public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder(this, xmlEnvironment);
            xmlStringBuilder.attribute("start", getStart());
            xmlStringBuilder.closeEmptyElement();
            return xmlStringBuilder;
        }
    }

    public ListElement(int i10, int i11, List<ListEntryElement> list) {
        super(i10, i11);
        this.entries = Collections.unmodifiableList(list);
    }

    public void appendInnerXml(XmlStringBuilder xmlStringBuilder) {
        xmlStringBuilder.append((Collection<? extends Element>) getEntries());
    }

    public String getElementName() {
        return "list";
    }

    public List<ListEntryElement> getEntries() {
        return this.entries;
    }
}
