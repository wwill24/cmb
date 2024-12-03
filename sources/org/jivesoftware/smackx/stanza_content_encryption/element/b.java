package org.jivesoftware.smackx.stanza_content_encryption.element;

import org.jivesoftware.smack.util.EqualsUtil;

public final /* synthetic */ class b implements EqualsUtil.EqualsComperator {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ RandomPaddingAffixElement f24233a;

    public /* synthetic */ b(RandomPaddingAffixElement randomPaddingAffixElement) {
        this.f24233a = randomPaddingAffixElement;
    }

    public final void compare(EqualsUtil.Builder builder, Object obj) {
        this.f24233a.lambda$equals$0(builder, (RandomPaddingAffixElement) obj);
    }
}
