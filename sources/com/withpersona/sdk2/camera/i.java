package com.withpersona.sdk2.camera;

import fj.d;
import fj.g;
import kotlin.Result;
import kotlinx.coroutines.flow.h;

public final class i implements d<h<Result<ParsedIdSideOrNone>>> {

    /* renamed from: a  reason: collision with root package name */
    private final h f14347a;

    public i(h hVar) {
        this.f14347a = hVar;
    }

    public static i a(h hVar) {
        return new i(hVar);
    }

    public static h<Result<ParsedIdSideOrNone>> c(h hVar) {
        return (h) g.e(hVar.a());
    }

    /* renamed from: b */
    public h<Result<ParsedIdSideOrNone>> get() {
        return c(this.f14347a);
    }
}
