package com.withpersona.sdk2.inquiry.governmentid;

import com.squareup.workflow1.ui.r;
import fj.d;
import fj.g;
import fk.a;
import java.util.Set;

public final class v implements d<Set<r<?>>> {

    /* renamed from: a  reason: collision with root package name */
    private final a<GovernmentIdCameraScreenViewFactory> f26015a;

    public v(a<GovernmentIdCameraScreenViewFactory> aVar) {
        this.f26015a = aVar;
    }

    public static v a(a<GovernmentIdCameraScreenViewFactory> aVar) {
        return new v(aVar);
    }

    public static Set<r<?>> c(GovernmentIdCameraScreenViewFactory governmentIdCameraScreenViewFactory) {
        return (Set) g.e(u.a(governmentIdCameraScreenViewFactory));
    }

    /* renamed from: b */
    public Set<r<?>> get() {
        return c(this.f26015a.get());
    }
}
