package io.sentry;

import java.io.File;
import java.io.FilenameFilter;

public final /* synthetic */ class k implements FilenameFilter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ l f31315a;

    public /* synthetic */ k(l lVar) {
        this.f31315a = lVar;
    }

    public final boolean accept(File file, String str) {
        return this.f31315a.d(file, str);
    }
}
