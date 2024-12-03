package com.withpersona.sdk2.camera;

import fj.d;
import fj.g;
import kotlin.Result;
import kotlinx.coroutines.flow.h;

public final class j implements d<h<Result<w>>> {

    /* renamed from: a  reason: collision with root package name */
    private final h f14348a;

    public j(h hVar) {
        this.f14348a = hVar;
    }

    public static j a(h hVar) {
        return new j(hVar);
    }

    public static h<Result<w>> c(h hVar) {
        return (h) g.e(hVar.b());
    }

    /* renamed from: b */
    public h<Result<w>> get() {
        return c(this.f14348a);
    }
}
