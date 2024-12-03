package com.leanplum.internal;

import com.leanplum.internal.VarCache;
import java.io.InputStream;

public final /* synthetic */ class a implements VarCache.StreamProvider {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ActionArg f22205a;

    public /* synthetic */ a(ActionArg actionArg) {
        this.f22205a = actionArg;
    }

    public final InputStream openStream() {
        return this.f22205a.defaultStream();
    }
}
