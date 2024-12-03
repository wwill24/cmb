package org.jivesoftware.smack.packet;

import java.util.List;
import javax.xml.namespace.QName;
import org.jivesoftware.smack.util.XmppElementUtil;
import org.jxmpp.jid.Jid;

public interface StanzaView extends XmlLangElement {
    StanzaError getError();

    <E extends ExtensionElement> E getExtension(Class<E> cls) {
        ExtensionElement extension = getExtension(XmppElementUtil.getQNameFor(cls));
        if (extension == null) {
            return null;
        }
        return XmppElementUtil.castOrThrow(extension, cls);
    }

    ExtensionElement getExtension(QName qName);

    List<ExtensionElement> getExtensions();

    <E extends ExtensionElement> List<E> getExtensions(Class<E> cls);

    List<ExtensionElement> getExtensions(QName qName);

    Jid getFrom();

    String getStanzaId();

    Jid getTo();

    boolean hasExtension(QName qName) {
        return getExtension(qName) != null;
    }

    boolean hasExtension(Class<? extends ExtensionElement> cls) {
        return getExtension(cls) != null;
    }

    boolean hasExtension(String str) {
        for (ExtensionElement namespace : getExtensions()) {
            if (namespace.getNamespace().equals(str)) {
                return true;
            }
        }
        return false;
    }
}
