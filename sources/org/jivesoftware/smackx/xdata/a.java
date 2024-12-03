package org.jivesoftware.smackx.xdata;

import org.jivesoftware.smack.util.HashCode;
import org.jivesoftware.smackx.xdata.FormField;

public final /* synthetic */ class a implements HashCode.Calculator {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FormField.Option f24236a;

    public /* synthetic */ a(FormField.Option option) {
        this.f24236a = option;
    }

    public final void calculateHash(HashCode.Builder builder) {
        this.f24236a.lambda$hashCode$1(builder);
    }
}
