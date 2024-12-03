package io.sentry;

import io.sentry.hints.g;
import io.sentry.util.i;
import java.io.File;

public final /* synthetic */ class r implements i.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ s f31605a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Throwable f31606b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ File f31607c;

    public /* synthetic */ r(s sVar, Throwable th2, File file) {
        this.f31605a = sVar;
        this.f31606b = th2;
        this.f31607c = file;
    }

    public final void accept(Object obj) {
        this.f31605a.k(this.f31606b, this.f31607c, (g) obj);
    }
}
