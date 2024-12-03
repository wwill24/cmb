package com.withpersona.sdk2.camera;

import bh.c;
import bh.d;
import bh.e;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class SelfieProcessor$faceDetector$2 extends Lambda implements Function0<d> {

    /* renamed from: a  reason: collision with root package name */
    public static final SelfieProcessor$faceDetector$2 f14197a = new SelfieProcessor$faceDetector$2();

    SelfieProcessor$faceDetector$2() {
        super(0);
    }

    /* renamed from: a */
    public final d invoke() {
        d a10 = c.a(new e.a().c(0.35f).b(2).a());
        j.f(a10, "getClient(\n      FaceDet…L)\n        .build()\n    )");
        return a10;
    }
}
