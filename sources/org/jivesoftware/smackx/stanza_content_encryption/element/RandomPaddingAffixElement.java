package org.jivesoftware.smackx.stanza_content_encryption.element;

import java.security.SecureRandom;
import net.bytebuddy.jar.asm.Opcodes;
import org.jivesoftware.smack.packet.NamedElement;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.EqualsUtil;
import org.jivesoftware.smack.util.RandomUtil;
import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smack.util.XmlStringBuilder;

public class RandomPaddingAffixElement implements NamedElement, AffixElement {
    public static final String ELEMENT = "rpad";
    private static final int maxPaddingLength = 200;
    private static final int minPaddingLength = 1;
    private final String padding;

    public RandomPaddingAffixElement(String str) {
        this.padding = StringUtils.escapeForXmlText(StringUtils.requireNotNullNorEmpty(str, "Value of 'rpad' MUST NOT be null nor empty.")).toString();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$equals$0(EqualsUtil.Builder builder, RandomPaddingAffixElement randomPaddingAffixElement) {
        builder.append(getPadding(), randomPaddingAffixElement.getPadding());
    }

    private static int randomPaddingLength() {
        return RandomUtil.nextSecureRandomInt(Opcodes.IFNONNULL) + 1;
    }

    public boolean equals(Object obj) {
        return EqualsUtil.equals(this, obj, new b(this));
    }

    public String getElementName() {
        return "rpad";
    }

    public String getPadding() {
        return this.padding;
    }

    public int hashCode() {
        return getPadding().hashCode();
    }

    public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
        return new XmlStringBuilder((NamedElement) this).rightAngleBracket().append((CharSequence) getPadding()).closeElement((NamedElement) this);
    }

    public RandomPaddingAffixElement() {
        this(StringUtils.randomString(randomPaddingLength(), new SecureRandom()));
    }
}
