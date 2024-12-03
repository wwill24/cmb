package org.jivesoftware.smackx.bob;

import net.bytebuddy.jar.asm.signature.SignatureVisitor;
import org.jivesoftware.smack.util.StringUtils;

public class ContentId {
    private final String cid;
    private final String hash;
    private final String hashType;

    private ContentId(String str, String str2, String str3) {
        this.hash = (String) StringUtils.requireNotNullNorEmpty(str, "hash must not be null nor empty");
        this.hashType = (String) StringUtils.requireNotNullNorEmpty(str2, "hashType must not be null nor empty");
        this.cid = str3;
    }

    public static ContentId fromCid(String str) {
        return new ContentId(str.substring(str.indexOf("+") + 1, str.indexOf("@bob.xmpp.org")), str.substring(0, str.indexOf("+")), str);
    }

    public static ContentId fromSrc(String str) {
        return new ContentId(str.substring(str.indexOf("+") + 1, str.indexOf("@bob.xmpp.org")), str.substring(str.lastIndexOf("cid:") + 4, str.indexOf("+")));
    }

    public boolean equals(Object obj) {
        if (obj instanceof ContentId) {
            return this.cid.equals(((ContentId) obj).cid);
        }
        return false;
    }

    public String getCid() {
        return this.cid;
    }

    public String getHash() {
        return this.hash;
    }

    public String getHashType() {
        return this.hashType;
    }

    public int hashCode() {
        return this.cid.hashCode();
    }

    public String toSrc() {
        return "cid:" + getCid();
    }

    public ContentId(String str, String str2) {
        this(str, str2, str2 + SignatureVisitor.EXTENDS + str + "@bob.xmpp.org");
    }
}
