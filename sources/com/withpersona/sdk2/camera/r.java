package com.withpersona.sdk2.camera;

import fj.d;
import fk.a;
import kotlin.Result;
import kotlinx.coroutines.flow.h;

public final class r implements d<GovernmentIdFeed> {

    /* renamed from: a  reason: collision with root package name */
    private final a<h<Result<ParsedIdSideOrNone>>> f14375a;

    public r(a<h<Result<ParsedIdSideOrNone>>> aVar) {
        this.f14375a = aVar;
    }

    public static r a(a<h<Result<ParsedIdSideOrNone>>> aVar) {
        return new r(aVar);
    }

    public static GovernmentIdFeed c(h<Result<ParsedIdSideOrNone>> hVar) {
        return new GovernmentIdFeed(hVar);
    }

    /* renamed from: b */
    public GovernmentIdFeed get() {
        return c(this.f14375a.get());
    }
}
