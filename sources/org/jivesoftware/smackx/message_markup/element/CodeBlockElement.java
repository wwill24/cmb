package org.jivesoftware.smackx.message_markup.element;

import org.jivesoftware.smackx.message_markup.element.MarkupElement;

public class CodeBlockElement extends MarkupElement.BlockLevelMarkupElement {
    public static final String ELEMENT = "bcode";

    public CodeBlockElement(int i10, int i11) {
        super(i10, i11);
    }

    public String getElementName() {
        return ELEMENT;
    }
}
