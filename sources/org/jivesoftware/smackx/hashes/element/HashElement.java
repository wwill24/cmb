package org.jivesoftware.smackx.hashes.element;

import javax.xml.namespace.QName;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.NamedElement;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.Objects;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jivesoftware.smack.util.stringencoder.Base64;
import org.jivesoftware.smackx.hashes.HashManager;

public class HashElement implements ExtensionElement {
    public static final String ATTR_ALGO = "algo";
    public static final String ELEMENT = "hash";
    public static final QName QNAME = new QName(HashManager.NAMESPACE.V2.toString(), "hash");
    private final HashManager.ALGORITHM algorithm;
    private final byte[] hash;
    private final String hashB64;

    public HashElement(HashManager.ALGORITHM algorithm2, byte[] bArr) {
        this.algorithm = (HashManager.ALGORITHM) Objects.requireNonNull(algorithm2);
        this.hash = (byte[]) Objects.requireNonNull(bArr);
        this.hashB64 = Base64.encodeToString(bArr);
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof HashElement)) {
            return false;
        }
        HashElement hashElement = (HashElement) obj;
        if (getAlgorithm() != hashElement.getAlgorithm() || !getHashB64().equals(hashElement.getHashB64())) {
            return false;
        }
        return true;
    }

    public HashManager.ALGORITHM getAlgorithm() {
        return this.algorithm;
    }

    public String getElementName() {
        return QNAME.getLocalPart();
    }

    public byte[] getHash() {
        return this.hash;
    }

    public String getHashB64() {
        return this.hashB64;
    }

    public String getNamespace() {
        return QNAME.getNamespaceURI();
    }

    public int hashCode() {
        return toXML().toString().hashCode();
    }

    public CharSequence toXML(XmlEnvironment xmlEnvironment) {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder((ExtensionElement) this);
        xmlStringBuilder.attribute(ATTR_ALGO, this.algorithm.toString());
        xmlStringBuilder.rightAngleBracket();
        xmlStringBuilder.append((CharSequence) this.hashB64);
        xmlStringBuilder.closeElement((NamedElement) this);
        return xmlStringBuilder;
    }

    public HashElement(HashManager.ALGORITHM algorithm2, String str) {
        this.algorithm = algorithm2;
        this.hash = Base64.decode(str);
        this.hashB64 = str;
    }
}
