package org.jivesoftware.smack.packet;

import javax.xml.namespace.QName;

public interface FullyQualifiedElement extends NamedElement, XmlLangElement {
    String getLanguage() {
        return null;
    }

    String getNamespace();

    QName getQName() {
        return new QName(getNamespace(), getElementName());
    }
}
