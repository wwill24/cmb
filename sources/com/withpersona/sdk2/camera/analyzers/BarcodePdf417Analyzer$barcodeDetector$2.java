package com.withpersona.sdk2.camera.analyzers;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import vg.a;
import vg.b;
import vg.c;

final class BarcodePdf417Analyzer$barcodeDetector$2 extends Lambda implements Function0<a> {

    /* renamed from: a  reason: collision with root package name */
    public static final BarcodePdf417Analyzer$barcodeDetector$2 f14227a = new BarcodePdf417Analyzer$barcodeDetector$2();

    BarcodePdf417Analyzer$barcodeDetector$2() {
        super(0);
    }

    /* renamed from: a */
    public final a invoke() {
        a a10 = c.a(new b.a().b(2048, new int[0]).a());
        j.f(a10, "getClient(\n      Barcode…7)\n        .build()\n    )");
        return a10;
    }
}
