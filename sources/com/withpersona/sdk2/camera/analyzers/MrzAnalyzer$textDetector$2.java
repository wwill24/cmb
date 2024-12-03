package com.withpersona.sdk2.camera.analyzers;

import dh.b;
import dh.c;
import fh.a;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class MrzAnalyzer$textDetector$2 extends Lambda implements Function0<c> {

    /* renamed from: a  reason: collision with root package name */
    public static final MrzAnalyzer$textDetector$2 f14236a = new MrzAnalyzer$textDetector$2();

    MrzAnalyzer$textDetector$2() {
        super(0);
    }

    /* renamed from: a */
    public final c invoke() {
        c a10 = b.a(a.f23429c);
        j.f(a10, "getClient(TextRecognizerOptions.DEFAULT_OPTIONS)");
        return a10;
    }
}
