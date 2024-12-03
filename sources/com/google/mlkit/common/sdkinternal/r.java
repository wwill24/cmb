package com.google.mlkit.common.sdkinternal;

import com.google.mlkit.common.sdkinternal.a;
import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.util.Set;

final class r extends PhantomReference implements a.C0248a {

    /* renamed from: a  reason: collision with root package name */
    private final Set f21455a;

    /* renamed from: b  reason: collision with root package name */
    private final Runnable f21456b;

    /* synthetic */ r(Object obj, ReferenceQueue referenceQueue, Set set, Runnable runnable, q qVar) {
        super(obj, referenceQueue);
        this.f21455a = set;
        this.f21456b = runnable;
    }

    public final void a() {
        if (this.f21455a.remove(this)) {
            clear();
            this.f21456b.run();
        }
    }
}
