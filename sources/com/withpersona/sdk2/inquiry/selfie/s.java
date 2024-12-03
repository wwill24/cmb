package com.withpersona.sdk2.inquiry.selfie;

import com.squareup.workflow1.ui.r;
import fj.d;
import fj.g;
import fk.a;
import java.util.Set;

public final class s implements d<Set<r<?>>> {

    /* renamed from: a  reason: collision with root package name */
    private final a<SelfieCameraScreenViewFactory> f27433a;

    public s(a<SelfieCameraScreenViewFactory> aVar) {
        this.f27433a = aVar;
    }

    public static s a(a<SelfieCameraScreenViewFactory> aVar) {
        return new s(aVar);
    }

    public static Set<r<?>> c(SelfieCameraScreenViewFactory selfieCameraScreenViewFactory) {
        return (Set) g.e(r.a(selfieCameraScreenViewFactory));
    }

    /* renamed from: b */
    public Set<r<?>> get() {
        return c(this.f27433a.get());
    }
}
