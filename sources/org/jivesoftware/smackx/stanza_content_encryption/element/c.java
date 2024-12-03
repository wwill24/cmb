package org.jivesoftware.smackx.stanza_content_encryption.element;

import org.jivesoftware.smack.util.EqualsUtil;

public final /* synthetic */ class c implements EqualsUtil.EqualsComperator {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TimestampAffixElement f24234a;

    public /* synthetic */ c(TimestampAffixElement timestampAffixElement) {
        this.f24234a = timestampAffixElement;
    }

    public final void compare(EqualsUtil.Builder builder, Object obj) {
        this.f24234a.lambda$equals$0(builder, (TimestampAffixElement) obj);
    }
}
