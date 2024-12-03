package org.jivesoftware.smackx.message_markup.element;

import javax.xml.namespace.QName;
import org.jivesoftware.smackx.message_markup.element.MarkupElement;

public class BlockQuoteElement extends MarkupElement.BlockLevelMarkupElement {
    public static final String ELEMENT = "bquote";
    public static final QName QNAME = new QName(MarkupElement.NAMESPACE, ELEMENT);

    public BlockQuoteElement(int i10, int i11) {
        super(i10, i11);
    }

    public String getElementName() {
        return QNAME.getLocalPart();
    }
}
