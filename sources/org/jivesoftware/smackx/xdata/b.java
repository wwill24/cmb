package org.jivesoftware.smackx.xdata;

import org.jivesoftware.smack.util.EqualsUtil;
import org.jivesoftware.smackx.xdata.FormField;

public final /* synthetic */ class b implements EqualsUtil.EqualsComperator {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FormField.Option f24237a;

    public /* synthetic */ b(FormField.Option option) {
        this.f24237a = option;
    }

    public final void compare(EqualsUtil.Builder builder, Object obj) {
        this.f24237a.lambda$equals$0(builder, (FormField.Option) obj);
    }
}
