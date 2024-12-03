package com.withpersona.sdk2.camera.analyzers;

import bh.c;
import bh.d;
import bh.e;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class IdFrontAnalyzer$faceDetector$2 extends Lambda implements Function0<d> {

    /* renamed from: a  reason: collision with root package name */
    public static final IdFrontAnalyzer$faceDetector$2 f14233a = new IdFrontAnalyzer$faceDetector$2();

    IdFrontAnalyzer$faceDetector$2() {
        super(0);
    }

    /* renamed from: a */
    public final d invoke() {
        d a10 = c.a(new e.a().c(0.1f).a());
        j.f(a10, "getClient(\n      FaceDet…f)\n        .build()\n    )");
        return a10;
    }
}
