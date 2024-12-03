package org.jivesoftware.smackx.ox.element;

import java.util.Date;
import java.util.List;
import java.util.Set;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.util.Objects;
import org.jivesoftware.smack.util.RandomUtil;
import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jxmpp.jid.Jid;

public abstract class EncryptedOpenPgpContentElement extends OpenPgpContentElement {
    public static final String ELEM_RPAD = "rpad";
    private final String rpad;

    protected EncryptedOpenPgpContentElement(Set<? extends Jid> set, String str, Date date, List<ExtensionElement> list) {
        super((Set) Objects.requireNonNullNorEmpty(set, "Encrypted OpenPGP content elements must have at least one 'to' attribute."), date, list);
        this.rpad = (String) Objects.requireNonNull(str);
    }

    private static String createRandomPadding() {
        return StringUtils.randomString(RandomUtil.nextSecureRandomInt(256));
    }

    /* access modifiers changed from: protected */
    public void addCommonXml(XmlStringBuilder xmlStringBuilder) {
        super.addCommonXml(xmlStringBuilder);
        xmlStringBuilder.openElement("rpad").escape(this.rpad).closeElement("rpad");
    }

    protected EncryptedOpenPgpContentElement(Set<? extends Jid> set, List<ExtensionElement> list) {
        super((Set) Objects.requireNonNullNorEmpty(set, "Encrypted OpenPGP content elements must have at least one 'to' attribute."), new Date(), list);
        this.rpad = createRandomPadding();
    }
}
