package com.coffeemeetsbagel.match;

import com.coffeemeetsbagel.models.responses.ResponseGeneric;
import kotlin.jvm.internal.j;
import qj.w;

public final class x {

    /* renamed from: a  reason: collision with root package name */
    private final BagelRepository f34524a;

    public x(BagelRepository bagelRepository) {
        j.g(bagelRepository, "repository");
        this.f34524a = bagelRepository;
    }

    public final w<ResponseGeneric> a(String str, int i10) {
        j.g(str, "bagelId");
        return this.f34524a.p(str, i10);
    }
}
