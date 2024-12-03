package com.leanplum;

import com.leanplum.internal.VarCache;
import java.io.InputStream;

public final /* synthetic */ class w implements VarCache.StreamProvider {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Var f22228a;

    public /* synthetic */ w(Var var) {
        this.f22228a = var;
    }

    public final InputStream openStream() {
        return this.f22228a.defaultStream();
    }
}
