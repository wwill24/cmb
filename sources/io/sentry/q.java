package io.sentry;

import io.sentry.hints.g;
import io.sentry.util.i;
import java.io.File;

public final /* synthetic */ class q implements i.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ s f31598a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ File f31599b;

    public /* synthetic */ q(s sVar, File file) {
        this.f31598a = sVar;
        this.f31599b = file;
    }

    public final void accept(Object obj) {
        this.f31598a.l(this.f31599b, (g) obj);
    }
}
