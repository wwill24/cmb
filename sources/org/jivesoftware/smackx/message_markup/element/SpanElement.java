package org.jivesoftware.smackx.message_markup.element;

import java.util.Collections;
import java.util.Set;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jivesoftware.smackx.message_markup.element.MarkupElement;

public class SpanElement extends MarkupElement.NonEmptyChildElement {
    public static final String ELEMENT = "span";
    public static final String code = "code";
    public static final String deleted = "deleted";
    public static final String emphasis = "emphasis";
    private final Set<SpanStyle> styles;

    public enum SpanStyle {
        emphasis,
        code,
        deleted
    }

    public SpanElement(int i10, int i11, Set<SpanStyle> set) {
        super(i10, i11);
        this.styles = Collections.unmodifiableSet(set);
    }

    /* access modifiers changed from: protected */
    public void appendInnerXml(XmlStringBuilder xmlStringBuilder) {
        for (SpanStyle emptyElement : getStyles()) {
            xmlStringBuilder.emptyElement((Enum<?>) emptyElement);
        }
    }

    public String getElementName() {
        return "span";
    }

    public Set<SpanStyle> getStyles() {
        return this.styles;
    }
}
