package androidx.work.impl;

import java.util.ArrayList;
import java.util.concurrent.Callable;

public final /* synthetic */ class p implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ r f7577a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ArrayList f7578b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f7579c;

    public /* synthetic */ p(r rVar, ArrayList arrayList, String str) {
        this.f7577a = rVar;
        this.f7578b = arrayList;
        this.f7579c = str;
    }

    public final Object call() {
        return this.f7577a.m(this.f7578b, this.f7579c);
    }
}
