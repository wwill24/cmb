package org.jivesoftware.smackx.message_markup.element;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.NamedElement;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jivesoftware.smackx.message_markup.element.ListElement;
import org.jivesoftware.smackx.message_markup.element.SpanElement;

public class MarkupElement implements ExtensionElement {
    public static final String ELEMENT = "markup";
    public static final String NAMESPACE = "urn:xmpp:markup:0";
    private final List<MarkupChildElement> childElements;

    public static abstract class BlockLevelMarkupElement extends MarkupChildElement {
        protected BlockLevelMarkupElement(int i10, int i11) {
            super(i10, i11);
        }

        /* access modifiers changed from: protected */
        public final void afterXmlPrelude(XmlStringBuilder xmlStringBuilder) {
            xmlStringBuilder.closeEmptyElement();
        }
    }

    public static final class Builder {
        private final List<CodeBlockElement> codes;
        /* access modifiers changed from: private */
        public final List<ListElement> lists;
        private final List<BlockQuoteElement> quotes;
        private final List<SpanElement> spans;

        public static final class ListBuilder {
            private int end;
            private final ArrayList<ListElement.ListEntryElement> entries;
            private final Builder markup;

            public ListBuilder addEntry(int i10, int i11) {
                ListElement.ListEntryElement listEntryElement;
                Builder.verifyStartEnd(i10, i11);
                if (this.entries.size() == 0) {
                    listEntryElement = null;
                } else {
                    ArrayList<ListElement.ListEntryElement> arrayList = this.entries;
                    listEntryElement = arrayList.get(arrayList.size() - 1);
                }
                if (listEntryElement == null || i10 == this.end) {
                    this.entries.add(new ListElement.ListEntryElement(i10));
                    this.end = i11;
                    return this;
                }
                throw new IllegalArgumentException("Next entries start must be equal to last entries end (" + this.end + ").");
            }

            public Builder endList() {
                if (this.entries.size() > 0) {
                    this.markup.lists.add(new ListElement(this.entries.get(0).getStart(), this.end, this.entries));
                }
                return this.markup;
            }

            private ListBuilder(Builder builder) {
                this.entries = new ArrayList<>();
                this.end = -1;
                this.markup = builder;
            }
        }

        /* access modifiers changed from: private */
        public static void verifyStartEnd(int i10, int i11) {
            if (i10 >= i11 || i10 < 0) {
                throw new IllegalArgumentException("Start value (" + i10 + ") MUST be greater equal than 0 and MUST be smaller than end value (" + i11 + ").");
            }
        }

        public Builder addSpan(int i10, int i11, Set<SpanElement.SpanStyle> set) {
            verifyStartEnd(i10, i11);
            for (SpanElement next : this.spans) {
                if ((i10 >= next.getStart() && i10 <= next.getEnd()) || (i11 >= next.getStart() && i11 <= next.getEnd())) {
                    throw new IllegalArgumentException("Spans MUST NOT overlap each other.");
                }
            }
            this.spans.add(new SpanElement(i10, i11, set));
            return this;
        }

        public ListBuilder beginList() {
            return new ListBuilder();
        }

        public MarkupElement build() {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.spans);
            arrayList.addAll(this.quotes);
            arrayList.addAll(this.codes);
            arrayList.addAll(this.lists);
            return new MarkupElement(arrayList);
        }

        public Builder setBlockQuote(int i10, int i11) {
            verifyStartEnd(i10, i11);
            for (BlockQuoteElement next : this.quotes) {
                Integer valueOf = Integer.valueOf(i10);
                Integer valueOf2 = Integer.valueOf(i11);
                if (valueOf.compareTo(Integer.valueOf(next.getStart())) * valueOf.compareTo(Integer.valueOf(next.getEnd())) * valueOf2.compareTo(Integer.valueOf(next.getStart())) * valueOf2.compareTo(Integer.valueOf(next.getEnd())) < 1) {
                    throw new IllegalArgumentException("BlockQuotes MUST NOT overlap each others boundaries");
                }
            }
            this.quotes.add(new BlockQuoteElement(i10, i11));
            return this;
        }

        public Builder setCode(int i10, int i11) {
            return addSpan(i10, i11, Collections.singleton(SpanElement.SpanStyle.code));
        }

        public Builder setCodeBlock(int i10, int i11) {
            verifyStartEnd(i10, i11);
            this.codes.add(new CodeBlockElement(i10, i11));
            return this;
        }

        public Builder setDeleted(int i10, int i11) {
            return addSpan(i10, i11, Collections.singleton(SpanElement.SpanStyle.deleted));
        }

        public Builder setEmphasis(int i10, int i11) {
            return addSpan(i10, i11, Collections.singleton(SpanElement.SpanStyle.emphasis));
        }

        private Builder() {
            this.spans = new ArrayList();
            this.quotes = new ArrayList();
            this.codes = new ArrayList();
            this.lists = new ArrayList();
        }
    }

    public static abstract class MarkupChildElement implements ExtensionElement {
        public static final String ATTR_END = "end";
        public static final String ATTR_START = "start";
        private final int end;
        private final int start;

        protected MarkupChildElement(int i10, int i11) {
            this.start = i10;
            this.end = i11;
        }

        /* access modifiers changed from: protected */
        public abstract void afterXmlPrelude(XmlStringBuilder xmlStringBuilder);

        public final int getEnd() {
            return this.end;
        }

        public final String getNamespace() {
            return MarkupElement.NAMESPACE;
        }

        public final int getStart() {
            return this.start;
        }

        public final XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder(this, xmlEnvironment);
            xmlStringBuilder.attribute("start", getStart());
            xmlStringBuilder.attribute("end", getEnd());
            afterXmlPrelude(xmlStringBuilder);
            return xmlStringBuilder;
        }
    }

    public static abstract class NonEmptyChildElement extends MarkupChildElement {
        protected NonEmptyChildElement(int i10, int i11) {
            super(i10, i11);
        }

        /* access modifiers changed from: protected */
        public final void afterXmlPrelude(XmlStringBuilder xmlStringBuilder) {
            xmlStringBuilder.rightAngleBracket();
            appendInnerXml(xmlStringBuilder);
            xmlStringBuilder.closeElement((NamedElement) this);
        }

        /* access modifiers changed from: protected */
        public abstract void appendInnerXml(XmlStringBuilder xmlStringBuilder);
    }

    public MarkupElement(List<MarkupChildElement> list) {
        this.childElements = Collections.unmodifiableList(list);
    }

    public static Builder getBuilder() {
        return new Builder();
    }

    public List<MarkupChildElement> getChildElements() {
        return this.childElements;
    }

    public String getElementName() {
        return ELEMENT;
    }

    public String getNamespace() {
        return NAMESPACE;
    }

    public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
        XmlStringBuilder rightAngleBracket = new XmlStringBuilder((ExtensionElement) this).rightAngleBracket();
        for (MarkupChildElement xml : getChildElements()) {
            rightAngleBracket.append(xml.toXML());
        }
        rightAngleBracket.closeElement((NamedElement) this);
        return rightAngleBracket;
    }
}
