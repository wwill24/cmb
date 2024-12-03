package org.jivesoftware.smack;

import org.jivesoftware.smack.util.Consumer;
import org.jivesoftware.smack.util.rce.RemoteConnectionException;

public final /* synthetic */ class m implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ StringBuilder f24128a;

    public /* synthetic */ m(StringBuilder sb2) {
        this.f24128a = sb2;
    }

    public final void accept(Object obj) {
        this.f24128a.append(((RemoteConnectionException) obj).getErrorMessage());
    }
}
