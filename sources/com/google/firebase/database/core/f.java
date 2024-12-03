package com.google.firebase.database.core;

import com.google.firebase.database.core.view.QuerySpec;
import java.util.concurrent.Callable;

public final /* synthetic */ class f implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SyncTree f21075a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ QuerySpec f21076b;

    public /* synthetic */ f(SyncTree syncTree, QuerySpec querySpec) {
        this.f21075a = syncTree;
        this.f21076b = querySpec;
    }

    public final Object call() {
        return this.f21075a.lambda$getServerValue$0(this.f21076b);
    }
}
