package org.jivesoftware.smackx.stanza_content_encryption.element;

import org.jivesoftware.smack.util.EqualsUtil;

public final /* synthetic */ class a implements EqualsUtil.EqualsComperator {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ JidAffixElement f24232a;

    public /* synthetic */ a(JidAffixElement jidAffixElement) {
        this.f24232a = jidAffixElement;
    }

    public final void compare(EqualsUtil.Builder builder, Object obj) {
        this.f24232a.lambda$equals$0(builder, (JidAffixElement) obj);
    }
}
