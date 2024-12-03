package org.jivesoftware.smack.util;

import java.io.Writer;

public final /* synthetic */ class r implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Writer f24196a;

    public /* synthetic */ r(Writer writer) {
        this.f24196a = writer;
    }

    public final void accept(Object obj) {
        XmlStringBuilder.lambda$write$0(this.f24196a, (CharSequence) obj);
    }
}
