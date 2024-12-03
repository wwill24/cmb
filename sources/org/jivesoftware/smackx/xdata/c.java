package org.jivesoftware.smackx.xdata;

import org.jivesoftware.smack.util.EqualsUtil;
import org.jivesoftware.smackx.xdata.FormField;

public final /* synthetic */ class c implements EqualsUtil.EqualsComperator {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FormField.Value f24238a;

    public /* synthetic */ c(FormField.Value value) {
        this.f24238a = value;
    }

    public final void compare(EqualsUtil.Builder builder, Object obj) {
        this.f24238a.lambda$equals$0(builder, (FormField.Value) obj);
    }
}
